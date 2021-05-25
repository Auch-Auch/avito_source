package ru.avito.component.payments.method.list.checkable;

import android.view.View;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.payments.method.CheckablePaymentMethodCard;
import ru.avito.component.payments.method.CheckablePaymentMethodListCard;
import ru.avito.component.payments.method.PaymentLabel;
import ru.avito.component.payments.method.list.checkable.CheckablePaymentMethodViewHolder;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#J\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0016\u0010\u0010J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0018\u0010\u0010J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u00020\t8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\f¨\u0006$"}, d2 = {"Lru/avito/component/payments/method/list/checkable/CheckablePaymentMethodViewHolderImpl;", "Lru/avito/component/payments/method/list/checkable/CheckablePaymentMethodViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/payments/method/CheckablePaymentMethodCard;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "isEnabled", "setEnabled", "(Z)V", "", "information", "setInformation", "(Ljava/lang/String;)V", "Lru/avito/component/payments/method/PaymentLabel;", "label", "setLabel", "(Lru/avito/component/payments/method/PaymentLabel;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "title", "setTitle", "paymentLabel", "setViewTag", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "isChecked", "()Z", "setChecked", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CheckablePaymentMethodViewHolderImpl extends BaseViewHolder implements CheckablePaymentMethodViewHolder, CheckablePaymentMethodCard {
    public final View s;
    public final /* synthetic */ CheckablePaymentMethodListCard t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckablePaymentMethodViewHolderImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new CheckablePaymentMethodListCard(view);
        this.s = view;
    }

    @Override // ru.avito.component.payments.method.CheckablePaymentMethodCard
    public boolean isChecked() {
        return this.t.isChecked();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        CheckablePaymentMethodViewHolder.DefaultImpls.onUnbind(this);
    }

    @Override // ru.avito.component.payments.method.CheckablePaymentMethodCard
    public void setChecked(boolean z) {
        this.t.setChecked(z);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setClickListener(function0);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setEnabled(boolean z) {
        this.t.setEnabled(z);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setInformation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "information");
        this.t.setInformation(str);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setLabel(@NotNull PaymentLabel paymentLabel) {
        Intrinsics.checkNotNullParameter(paymentLabel, "label");
        this.t.setLabel(paymentLabel);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
        this.t.setSubtitle(str);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setTitle(str);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodCard
    public void setViewTag(@NotNull PaymentLabel paymentLabel) {
        Intrinsics.checkNotNullParameter(paymentLabel, "paymentLabel");
        this.t.setViewTag(paymentLabel);
    }
}
