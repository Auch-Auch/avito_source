package a2.a.a.q.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket.checkout.CheckoutFragment;
public final class e<T> implements Observer<Boolean> {
    public final /* synthetic */ CheckoutFragment a;

    public e(CheckoutFragment checkoutFragment) {
        this.a = checkoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            bool2.booleanValue();
            CheckoutFragment.access$getButton$p(this.a).setLoading(bool2.booleanValue());
            CheckoutFragment.access$getButton$p(this.a).setClickable(!bool2.booleanValue());
            CheckoutFragment.access$getRecyclerView$p(this.a).removeOnItemTouchListener(this.a.k);
            if (bool2.booleanValue()) {
                CheckoutFragment.access$getRecyclerView$p(this.a).addOnItemTouchListener(this.a.k);
            }
        }
    }
}
