package a2.a.a.q.a.i;

import com.avito.android.basket.checkout.viewmodel.CheckoutViewModelImpl;
import com.avito.android.remote.model.CheckoutCommitResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<LoadingState<? super CheckoutCommitResult>> {
    public final /* synthetic */ CheckoutViewModelImpl a;

    public b(CheckoutViewModelImpl checkoutViewModelImpl) {
        this.a = checkoutViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super CheckoutCommitResult> loadingState) {
        LoadingState<? super CheckoutCommitResult> loadingState2 = loadingState;
        CheckoutViewModelImpl checkoutViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        CheckoutViewModelImpl.access$onCheckoutCommitResponse(checkoutViewModelImpl, loadingState2);
    }
}
