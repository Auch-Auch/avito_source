package ru.avito.component.payments.method.list.simple;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.payments.method.list.SimplePaymentMethodItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/avito/component/payments/method/list/simple/PaymentMethodItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lru/avito/component/payments/method/list/simple/PaymentMethodViewHolder;", "Lru/avito/component/payments/method/list/SimplePaymentMethodItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lru/avito/component/payments/method/list/simple/PaymentMethodViewHolder;Lru/avito/component/payments/method/list/SimplePaymentMethodItem;I)V", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lkotlin/jvm/functions/Function1;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentMethodItemPresenter implements ItemPresenter<PaymentMethodViewHolder, SimplePaymentMethodItem> {
    public final Function1<SimplePaymentMethodItem, Unit> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PaymentMethodItemPresenter a;
        public final /* synthetic */ SimplePaymentMethodItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PaymentMethodItemPresenter paymentMethodItemPresenter, SimplePaymentMethodItem simplePaymentMethodItem) {
            super(0);
            this.a = paymentMethodItemPresenter;
            this.b = simplePaymentMethodItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.invoke(this.b);
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super ru.avito.component.payments.method.list.SimplePaymentMethodItem, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentMethodItemPresenter(@NotNull Function1<? super SimplePaymentMethodItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = function1;
    }

    public void bindView(@NotNull PaymentMethodViewHolder paymentMethodViewHolder, @NotNull SimplePaymentMethodItem simplePaymentMethodItem, int i) {
        Intrinsics.checkNotNullParameter(paymentMethodViewHolder, "view");
        Intrinsics.checkNotNullParameter(simplePaymentMethodItem, "item");
        paymentMethodViewHolder.setClickListener(new a(this, simplePaymentMethodItem));
        paymentMethodViewHolder.setEnabled(simplePaymentMethodItem.isEnabled());
        paymentMethodViewHolder.setLabel(simplePaymentMethodItem.getLabel());
        paymentMethodViewHolder.setTitle(simplePaymentMethodItem.getTitle());
        paymentMethodViewHolder.setSubtitle(simplePaymentMethodItem.getSubtitle());
        paymentMethodViewHolder.setInformation(simplePaymentMethodItem.getInformation());
    }
}
