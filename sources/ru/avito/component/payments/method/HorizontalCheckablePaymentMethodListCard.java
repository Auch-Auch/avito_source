package ru.avito.component.payments.method;

import android.view.View;
import android.widget.RadioButton;
import com.avito.android.lib.design.shadow_layout.ShadowLayout;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108V@VX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\n \u0016*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000e¨\u0006\u001b"}, d2 = {"Lru/avito/component/payments/method/HorizontalCheckablePaymentMethodListCard;", "Lru/avito/component/payments/method/HorizontalPaymentMethodListCard;", "Lru/avito/component/payments/method/CheckablePaymentMethodCard;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/RadioButton;", "h", "Landroid/widget/RadioButton;", "radioButton", "Landroid/view/View;", "j", "Landroid/view/View;", "shadowContainer", "", "checked", "isChecked", "()Z", "setChecked", "(Z)V", "kotlin.jvm.PlatformType", "i", "content", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class HorizontalCheckablePaymentMethodListCard extends HorizontalPaymentMethodListCard implements CheckablePaymentMethodCard {
    public final RadioButton h;
    public final View i;
    public final View j;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((Function0) this.b).invoke();
            } else if (i == 1) {
                ((Function0) this.b).invoke();
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalCheckablePaymentMethodListCard(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "shadowContainer");
        this.j = view;
        this.h = (RadioButton) Views.findById(view, R.id.payment_method_radiobutton);
        this.i = view.findViewById(R.id.payment_content);
    }

    @Override // ru.avito.component.payments.method.CheckablePaymentMethodCard
    public boolean isChecked() {
        return this.h.isChecked();
    }

    @Override // ru.avito.component.payments.method.CheckablePaymentMethodCard
    public void setChecked(boolean z) {
        View view = this.j;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.lib.design.shadow_layout.ShadowLayout");
        this.h.setChecked(z);
        ((ShadowLayout) view).setEnableShadows(isChecked());
        this.i.setBackgroundResource(isChecked() ? R.drawable.bg_payment_method_selected : R.drawable.bg_payment_method);
    }

    @Override // ru.avito.component.payments.method.HorizontalPaymentMethodListCard, ru.avito.component.payments.method.PaymentMethodCard
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.i.setOnClickListener(new a(0, function0));
        this.h.setOnClickListener(new a(1, function0));
    }
}
