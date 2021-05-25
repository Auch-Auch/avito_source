package a2.a.a.b0;

import androidx.lifecycle.Observer;
import com.avito.android.cart_fab.CartFabView;
public final class a<T> implements Observer<Integer> {
    public final /* synthetic */ CartFabView a;

    public a(CartFabView cartFabView) {
        this.a = cartFabView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        Integer num2 = num;
        this.a.e.onSizeChanged(this.a.getFab(), num2);
        this.a.a = num2;
    }
}
