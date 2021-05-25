package a2.a.a.r.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket_legacy.ui.LegacyCheckoutFragment;
import com.avito.android.basket_legacy.utils.CheckoutNavigationIcon;
import com.avito.android.ui_components.R;
public final class i<T> implements Observer<CheckoutNavigationIcon> {
    public final /* synthetic */ LegacyCheckoutFragment a;

    public i(LegacyCheckoutFragment legacyCheckoutFragment) {
        this.a = legacyCheckoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(CheckoutNavigationIcon checkoutNavigationIcon) {
        CheckoutNavigationIcon checkoutNavigationIcon2 = checkoutNavigationIcon;
        if (checkoutNavigationIcon2 == null) {
            return;
        }
        if (checkoutNavigationIcon2 == CheckoutNavigationIcon.BACK) {
            LegacyCheckoutFragment.access$getToolbar$p(this.a).setNavigationIcon(R.drawable.ic_back_24);
            LegacyCheckoutFragment.access$getToolbar$p(this.a).setNavigationOnClickListener(new t1(0, this));
            return;
        }
        LegacyCheckoutFragment.access$getToolbar$p(this.a).setNavigationIcon(R.drawable.ic_close_24);
        LegacyCheckoutFragment.access$getToolbar$p(this.a).setNavigationOnClickListener(new t1(1, this));
    }
}
