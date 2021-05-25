package a2.a.a.f.x.t.i;

import android.view.KeyEvent;
import android.widget.TextView;
import com.avito.android.advert.item.dfpcreditinfo.calculator.SravniCalculatorView;
public final class c implements TextView.OnEditorActionListener {
    public final /* synthetic */ SravniCalculatorView a;

    public c(SravniCalculatorView sravniCalculatorView) {
        this.a = sravniCalculatorView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.a.clearFocus();
        return true;
    }
}
