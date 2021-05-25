package com.avito.android.authorization.login_protection.adapter.phone;

import com.avito.android.authorization.login_protection.action.PhoneListAction;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItemPresenterImpl;", "Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItemPresenter;", "Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItemView;", "view", "Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItemView;Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/authorization/login_protection/action/PhoneListAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneItemPresenterImpl implements PhoneItemPresenter {
    public final Consumer<PhoneListAction> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ PhoneItemView a;
        public final /* synthetic */ PhoneItemPresenterImpl b;
        public final /* synthetic */ PhoneItem c;

        public a(PhoneItemView phoneItemView, PhoneItemPresenterImpl phoneItemPresenterImpl, PhoneItem phoneItem) {
            this.a = phoneItemView;
            this.b = phoneItemPresenterImpl;
            this.c = phoneItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.b.a.accept(new PhoneListAction.PhoneClickAction(this.c.getFormattedValue()));
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Disposable a;
        public final /* synthetic */ PhoneItemView b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Disposable disposable, PhoneItemView phoneItemView, PhoneItemPresenterImpl phoneItemPresenterImpl, PhoneItem phoneItem) {
            super(0);
            this.a = disposable;
            this.b = phoneItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Disposable disposable = this.a;
            if (disposable != null) {
                disposable.dispose();
            }
            this.b.setUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public PhoneItemPresenterImpl(@NotNull Consumer<PhoneListAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull PhoneItemView phoneItemView, @NotNull PhoneItem phoneItem, int i) {
        Intrinsics.checkNotNullParameter(phoneItemView, "view");
        Intrinsics.checkNotNullParameter(phoneItem, "item");
        if (phoneItem.getHighlightStart() == -1 || phoneItem.getHighlightEnd() == -1) {
            phoneItemView.showPhoneNumber(phoneItem.getFormattedValue());
        } else {
            phoneItemView.showPhoneNumberWithHighlight(phoneItem.getFormattedValue(), phoneItem.getHighlightStart(), phoneItem.getHighlightEnd());
        }
        phoneItemView.setUnbindListener(new b(phoneItemView.getItemClicks().subscribe(new a(phoneItemView, this, phoneItem)), phoneItemView, this, phoneItem));
    }
}
