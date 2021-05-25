package a2.a.a.a0.a;

import androidx.lifecycle.Observer;
import com.avito.android.AuthIntentFactory;
import com.avito.android.cart.summary.CartSummaryFragment;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Unit;
public final class a<T> implements Observer<Unit> {
    public final /* synthetic */ CartSummaryFragment a;

    public a(CartSummaryFragment cartSummaryFragment) {
        this.a = cartSummaryFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        CartSummaryFragment cartSummaryFragment = this.a;
        cartSummaryFragment.startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(cartSummaryFragment.getActivityIntentFactory(), null, AuthSource.TEST_4, null, 5, null), 11);
    }
}
