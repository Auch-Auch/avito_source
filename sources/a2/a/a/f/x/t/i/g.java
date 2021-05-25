package a2.a.a.f.x.t.i;

import android.view.View;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton;
import com.avito.android.advert.item.dfpcreditinfo.calculator.TinkoffCalculatorView;
import com.avito.android.lib.design.input.Input;
import com.avito.android.util.Keyboards;
import t6.y.l;
public final class g implements View.OnFocusChangeListener {
    public final /* synthetic */ TinkoffCalculatorView a;

    public g(TinkoffCalculatorView tinkoffCalculatorView) {
        this.a = tinkoffCalculatorView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        String deformattedText;
        Integer intOrNull;
        if (!z) {
            DfpCreditButton.Listener listener = this.a.getListener();
            Input input = this.a.h;
            listener.onLoanChanged((input == null || (deformattedText = input.getDeformattedText()) == null || (intOrNull = l.toIntOrNull(deformattedText)) == null) ? 0 : intOrNull.intValue());
            Input input2 = this.a.h;
            if (input2 != null) {
                Keyboards.hideKeyboard(input2, false);
            }
        }
        this.a.getListener().onInputFieldFocusChanged(z);
    }
}
