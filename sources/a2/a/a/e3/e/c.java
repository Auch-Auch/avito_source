package a2.a.a.e3.e;

import androidx.lifecycle.Observer;
import com.avito.android.tariff.fees_methods.FeesMethodsFragment;
import com.avito.android.tariff.routing.NavigationIcon;
import com.avito.android.ui_components.R;
public final class c<T> implements Observer<NavigationIcon> {
    public final /* synthetic */ FeesMethodsFragment a;

    public c(FeesMethodsFragment feesMethodsFragment) {
        this.a = feesMethodsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(NavigationIcon navigationIcon) {
        NavigationIcon navigationIcon2 = navigationIcon;
        if (navigationIcon2 != null) {
            int ordinal = navigationIcon2.ordinal();
            if (ordinal == 0) {
                FeesMethodsFragment.access$getToolbar$p(this.a).setNavigationIcon(R.drawable.ic_back_24);
                FeesMethodsFragment.access$getToolbar$p(this.a).setNavigationOnClickListener(new c0(1, this));
            } else if (ordinal == 1) {
                FeesMethodsFragment.access$getToolbar$p(this.a).setNavigationIcon(R.drawable.ic_close_24);
                FeesMethodsFragment.access$getToolbar$p(this.a).setNavigationOnClickListener(new c0(0, this));
            }
        }
    }
}
