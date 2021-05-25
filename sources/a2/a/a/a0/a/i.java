package a2.a.a.a0.a;

import com.avito.android.cart.summary.CartSummaryViewModel;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class i<T> implements Consumer<Boolean> {
    public final /* synthetic */ CartSummaryViewModel a;

    public i(CartSummaryViewModel cartSummaryViewModel) {
        this.a = cartSummaryViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        this.a.k.postValue(Unit.INSTANCE);
    }
}
