package a2.a.a.a0.a;

import com.avito.android.cart.summary.CartSummaryViewModel;
import com.avito.android.remote.cart.model.CartSummary;
import com.avito.android.remote.cart.model.Store;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class l<T> implements Consumer<LoadingState<? super CartSummary>> {
    public final /* synthetic */ CartSummaryViewModel a;
    public final /* synthetic */ boolean b;

    public l(CartSummaryViewModel cartSummaryViewModel, boolean z) {
        this.a = cartSummaryViewModel;
        this.b = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v19, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super CartSummary> loadingState) {
        LoadingState<? super CartSummary> loadingState2 = loadingState;
        if (Intrinsics.areEqual(loadingState2, LoadingState.Loading.INSTANCE)) {
            CartSummaryViewModel.access$showLoading(this.a, this.b);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.M.trackLoaded();
            this.a.M.startPreparing();
            CartSummary cartSummary = (CartSummary) ((LoadingState.Loaded) loadingState2).getData();
            CartSummary.FullCart fullCart = cartSummary.getFullCart();
            CartSummary.EmptyCart emptyCart = cartSummary.getEmptyCart();
            this.a.e = emptyCart;
            this.a.c = cartSummary.getXHash();
            CartSummaryViewModel.access$handleActions(this.a, cartSummary.getActions());
            if (fullCart != null) {
                List<Store> stores = fullCart.getStores();
                if (stores == null || stores.isEmpty()) {
                    this.a.h();
                    this.a.j.postValue(new CartSummaryViewModel.ScreenState.Error(this.a.E.getCartDataIsCorruptedMessage()));
                    this.a.M.trackDrawn();
                }
            }
            if (fullCart == null) {
                CartSummaryViewModel.access$onEmptyCartLoaded(this.a, emptyCart);
            } else {
                CartSummaryViewModel.access$onFullCartLoaded(this.a, cartSummary);
            }
            this.a.M.trackDrawn();
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.M.trackLoadingError();
            TypedError error = ((LoadingState.Error) loadingState2).getError();
            Throwable th = null;
            String message = error instanceof ErrorWithMessage ? ((ErrorWithMessage) error).getMessage() : null;
            if (error instanceof ErrorResult.UnknownError) {
                th = ((ErrorResult.UnknownError) error).getDebugThrowable();
            }
            this.a.M.startDrawing();
            this.a.d(message, th);
            this.a.M.trackDrawnError();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
