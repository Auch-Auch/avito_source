package a2.a.a.r.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket_legacy.ui.LegacyCheckoutFragment;
public final class d<T> implements Observer<String> {
    public final /* synthetic */ LegacyCheckoutFragment a;

    public d(LegacyCheckoutFragment legacyCheckoutFragment) {
        this.a = legacyCheckoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        if (str2 != null) {
            LegacyCheckoutFragment.access$getProceedButton$p(this.a).setText(str2);
        }
    }
}
