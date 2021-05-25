package a2.a.a.a0.a;

import com.avito.android.cart.summary.CartSummaryView;
import com.avito.android.cart.summary.CartSummaryViewImpl;
import com.avito.android.remote.cart.model.CartSummary;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class e<T> implements Consumer<Unit> {
    public final /* synthetic */ CartSummaryViewImpl.g a;
    public final /* synthetic */ CartSummary.Button b;

    public e(CartSummaryViewImpl.g gVar, CartSummary.Button button, CartSummaryView.SubmitButton submitButton) {
        this.a = gVar;
        this.b = button;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        this.a.b.onSubmitClicked(this.b.getDeepLink());
    }
}
