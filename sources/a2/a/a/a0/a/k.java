package a2.a.a.a0.a;

import com.avito.android.cart.summary.CartSummaryViewModel;
import com.avito.android.remote.cart.model.CartSummary;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class k<T> implements Consumer<Notification<LoadingState<? super CartSummary>>> {
    public final /* synthetic */ CartSummaryViewModel a;

    public k(CartSummaryViewModel cartSummaryViewModel) {
        this.a = cartSummaryViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Notification<LoadingState<? super CartSummary>> notification) {
        Notification<LoadingState<? super CartSummary>> notification2 = notification;
        Intrinsics.checkNotNullExpressionValue(notification2, "it");
        if (!notification2.isOnNext() || !(notification2.getValue() instanceof LoadingState.Loading)) {
            this.a.n.postValue(Unit.INSTANCE);
        }
    }
}
