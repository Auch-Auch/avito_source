package com.avito.android.rating.user_contacts.adapter.contact;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.rating.user_contacts.action.UserContactAction;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItemPresenterImpl;", "Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItemPresenter;", "Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItemView;", "view", "Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItemView;Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/rating/user_contacts/action/UserContactAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "actionConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ContactItemPresenterImpl implements ContactItemPresenter {
    public final Consumer<UserContactAction> a;

    public static final class a<T> implements Consumer<Integer> {
        public final /* synthetic */ ContactItemPresenterImpl a;
        public final /* synthetic */ ContactItem b;

        public a(ContactItemPresenterImpl contactItemPresenterImpl, ContactItem contactItem) {
            this.a = contactItemPresenterImpl;
            this.b = contactItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            Consumer consumer = this.a.a;
            ContactItem contactItem = this.b;
            Intrinsics.checkNotNullExpressionValue(num2, "rating");
            consumer.accept(new UserContactAction.Rating(contactItem, num2.intValue()));
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ ContactItemPresenterImpl a;
        public final /* synthetic */ ContactItem b;

        public b(ContactItemPresenterImpl contactItemPresenterImpl, ContactItem contactItem) {
            this.a = contactItemPresenterImpl;
            this.b = contactItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(new UserContactAction.Remove(this.b));
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ContactItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ContactItemView contactItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = contactItemView;
            this.b = compositeDisposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.clear();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ContactItemPresenterImpl(@NotNull Consumer<UserContactAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "actionConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull ContactItemView contactItemView, @NotNull ContactItem contactItem, int i) {
        Intrinsics.checkNotNullParameter(contactItemView, "view");
        Intrinsics.checkNotNullParameter(contactItem, "item");
        contactItemView.setContactName(contactItem.getUserName());
        Image itemImage = contactItem.getItemImage();
        contactItemView.setItemImage(itemImage != null ? AvitoPictureKt.pictureOf$default(itemImage, true, 0.0f, 0.0f, null, 28, null) : null);
        contactItemView.setItemTitle(contactItem.getItemTitle());
        contactItemView.setItemPrice(contactItem.getItemPrice());
        contactItemView.resetRating();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        contactItemView.setUnbindListener(new c(contactItemView, compositeDisposable));
        Disposable subscribe = contactItemView.ratingClicks().subscribe(new a(this, contactItem));
        Intrinsics.checkNotNullExpressionValue(subscribe, "ratingClicks().subscribe… = rating))\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Disposable subscribe2 = contactItemView.removeClicks().subscribe(new b(this, contactItem));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "removeClicks().subscribe…move(item))\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
    }
}
