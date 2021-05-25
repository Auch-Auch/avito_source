package a2.a.a.q.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.basket.checkout.viewmodel.CheckoutContent;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.util.LoadingState;
public final class b<T> implements Observer<LoadingState<? super CheckoutContent>> {
    public final /* synthetic */ CheckoutFragment a;

    public b(CheckoutFragment checkoutFragment) {
        this.a = checkoutFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<? super CheckoutContent> loadingState) {
        LoadingState<? super CheckoutContent> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            CheckoutFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(CheckoutFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            CheckoutFragment.access$getProgressOverlay$p(this.a).showContent();
        }
    }
}
