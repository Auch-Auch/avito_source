package a2.a.a.a0.a;

import com.avito.android.cart.summary.CartSummaryViewImpl;
import com.avito.android.remote.cart.model.CartSummary;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class g<T> implements Consumer<Unit> {
    public final /* synthetic */ CartSummaryViewImpl a;
    public final /* synthetic */ CartSummary.Button b;

    public g(CartSummaryViewImpl cartSummaryViewImpl, String str, String str2, CartSummary.Button button) {
        this.a = cartSummaryViewImpl;
        this.b = button;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        this.a.q.trackEmptyCartButtonClicked();
        this.a.o.onDeepLinkClick(this.b.getDeepLink());
    }
}
