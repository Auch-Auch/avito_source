package com.avito.android.advert.item.dfpcreditinfo.calculator;

import android.text.Editable;
import com.avito.android.lib.design.input.Input;
import com.avito.android.util.SimpleTextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/advert/item/dfpcreditinfo/calculator/SravniCalculatorView$createInitialPaymentTextWatcher$1", "Lcom/avito/android/util/SimpleTextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "(Landroid/text/Editable;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SravniCalculatorView$createInitialPaymentTextWatcher$1 extends SimpleTextWatcher {
    public final /* synthetic */ SravniCalculatorView a;

    public static final class a implements Runnable {
        public final /* synthetic */ SravniCalculatorView$createInitialPaymentTextWatcher$1 a;
        public final /* synthetic */ int b;

        public a(SravniCalculatorView$createInitialPaymentTextWatcher$1 sravniCalculatorView$createInitialPaymentTextWatcher$1, int i) {
            this.a = sravniCalculatorView$createInitialPaymentTextWatcher$1;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.getListener().onInitialPaymentChanged(this.b);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public SravniCalculatorView$createInitialPaymentTextWatcher$1(SravniCalculatorView sravniCalculatorView) {
        this.a = sravniCalculatorView;
    }

    @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
    public void afterTextChanged(@NotNull Editable editable) {
        String deformattedText;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(editable, "s");
        Input input = this.a.h;
        int intValue = (input == null || (deformattedText = input.getDeformattedText()) == null || (intOrNull = l.toIntOrNull(deformattedText)) == null) ? 0 : intOrNull.intValue();
        Input input2 = this.a.h;
        if (input2 != null) {
            input2.post(new a(this, intValue));
        }
    }
}
