package ru.avito.component.payments.method;

import android.view.View;
import android.widget.RadioButton;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lru/avito/component/payments/method/CheckablePaymentMethodListCard;", "Lru/avito/component/payments/method/PaymentMethodListCard;", "Lru/avito/component/payments/method/CheckablePaymentMethodCard;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "checked", "isChecked", "()Z", "setChecked", "(Z)V", "Landroid/widget/RadioButton;", "h", "Landroid/widget/RadioButton;", "radioButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CheckablePaymentMethodListCard extends PaymentMethodListCard implements CheckablePaymentMethodCard {
    public final RadioButton h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckablePaymentMethodListCard(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.h = (RadioButton) Views.findById(view, R.id.payment_method_radiobutton);
    }

    @Override // ru.avito.component.payments.method.CheckablePaymentMethodCard
    public boolean isChecked() {
        return this.h.isChecked();
    }

    @Override // ru.avito.component.payments.method.CheckablePaymentMethodCard
    public void setChecked(boolean z) {
        this.h.setChecked(z);
    }

    @Override // ru.avito.component.payments.method.PaymentMethodListCard, ru.avito.component.payments.method.PaymentMethodCard
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        super.setClickListener(function0);
        this.h.setOnClickListener(new a(function0));
    }
}
