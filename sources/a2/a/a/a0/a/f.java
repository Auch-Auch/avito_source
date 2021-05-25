package a2.a.a.a0.a;

import com.avito.android.cart.summary.CartSummaryViewImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class f<T> implements Consumer<Unit> {
    public final /* synthetic */ CartSummaryViewImpl a;

    public f(CartSummaryViewImpl cartSummaryViewImpl) {
        this.a = cartSummaryViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        this.a.a.accept(Boolean.FALSE);
    }
}
