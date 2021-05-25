package a2.a.a.a0.a;

import com.avito.android.cart.summary.CartSummaryViewModel;
import io.reactivex.rxjava3.functions.Consumer;
public final class m<T> implements Consumer<Throwable> {
    public final /* synthetic */ CartSummaryViewModel a;

    public m(CartSummaryViewModel cartSummaryViewModel) {
        this.a = cartSummaryViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        this.a.d(null, th);
    }
}
