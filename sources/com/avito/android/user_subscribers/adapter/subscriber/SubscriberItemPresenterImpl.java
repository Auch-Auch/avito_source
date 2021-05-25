package com.avito.android.user_subscribers.adapter.subscriber;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.user_subscribers.action.SubscriberAction;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemPresenterImpl;", "Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemPresenter;", "Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemView;", "view", "Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemView;Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/user_subscribers/action/SubscriberAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriberItemPresenterImpl implements SubscriberItemPresenter {
    public final Consumer<SubscriberAction> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ SubscriberItemView b;
        public final /* synthetic */ SubscriberItemPresenterImpl c;

        public a(DeepLink deepLink, SubscriberItemView subscriberItemView, CompositeDisposable compositeDisposable, SubscriberItemPresenterImpl subscriberItemPresenterImpl, SubscriberItem subscriberItem) {
            this.a = deepLink;
            this.b = subscriberItemView;
            this.c = subscriberItemPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.c.a.accept(new SubscriberAction.OpenDeepLink(this.a));
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SubscriberItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SubscriberItemView subscriberItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = subscriberItemView;
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
    public SubscriberItemPresenterImpl(@NotNull Consumer<SubscriberAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull SubscriberItemView subscriberItemView, @NotNull SubscriberItem subscriberItem, int i) {
        Intrinsics.checkNotNullParameter(subscriberItemView, "view");
        Intrinsics.checkNotNullParameter(subscriberItem, "item");
        Image avatar = subscriberItem.getAvatar();
        Picture pictureOf$default = avatar != null ? AvitoPictureKt.pictureOf$default(avatar, true, 0.0f, 0.0f, null, 28, null) : null;
        if (subscriberItem.isShop()) {
            subscriberItemView.setShopAvatar(pictureOf$default);
        } else {
            subscriberItemView.setUserAvatar(pictureOf$default);
        }
        subscriberItemView.setTitle(subscriberItem.getTitle());
        subscriberItemView.setDescription(subscriberItem.getDescription());
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        subscriberItemView.setUnbindListener(new b(subscriberItemView, compositeDisposable));
        DeepLink deepLink = subscriberItem.getDeepLink();
        if (deepLink != null) {
            Disposable subscribe = subscriberItemView.clicks().subscribe(new a(deepLink, subscriberItemView, compositeDisposable, this, subscriberItem));
            Intrinsics.checkNotNullExpressionValue(subscribe, "clicks().subscribe {\n   …pLink))\n                }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }
}
