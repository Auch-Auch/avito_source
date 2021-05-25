package a2.a.a.f.x.t.i;

import android.view.View;
import com.avito.android.advert.item.dfpcreditinfo.calculator.SravniCalculatorView;
import com.avito.android.lib.design.input.Input;
import com.avito.android.util.Keyboards;
public final class d implements View.OnFocusChangeListener {
    public final /* synthetic */ SravniCalculatorView a;

    public d(SravniCalculatorView sravniCalculatorView) {
        this.a = sravniCalculatorView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        Input input;
        if (!z && (input = this.a.h) != null) {
            Keyboards.hideKeyboard(input, false);
        }
        this.a.getListener().onInputFieldFocusChanged(z);
    }
}
