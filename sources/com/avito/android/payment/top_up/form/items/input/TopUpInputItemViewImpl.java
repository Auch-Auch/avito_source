package com.avito.android.payment.top_up.form.items.input;

import android.view.View;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text_input.MoneyBigInput;
import ru.avito.component.text_input.MoneyBigInputImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u000e\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\tH\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\u00020\u00108\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemView;", "Lru/avito/component/text_input/MoneyBigInput;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "rawText", "setRawInputListener", "(Lkotlin/jvm/functions/Function1;)V", "", "getRawTextValue", "()Ljava/lang/CharSequence;", "setRawTextValue", "(Ljava/lang/CharSequence;)V", "rawTextValue", "getFormattedText", "setFormattedText", "formattedText", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpInputItemViewImpl extends BaseViewHolder implements TopUpInputItemView, MoneyBigInput {
    public final /* synthetic */ MoneyBigInputImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopUpInputItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.s = new MoneyBigInputImpl(view);
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    @NotNull
    public CharSequence getFormattedText() {
        return this.s.getFormattedText();
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    @NotNull
    public CharSequence getRawTextValue() {
        return this.s.getRawTextValue();
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    public void setActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setActionListener(function0);
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    public void setFormattedText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.s.setFormattedText(charSequence);
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    public void setRawInputListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setRawInputListener(function1);
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    public void setRawTextValue(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.s.setRawTextValue(charSequence);
    }
}
