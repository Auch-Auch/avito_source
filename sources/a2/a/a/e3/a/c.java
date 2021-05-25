package a2.a.a.e3.a;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.tariff.change.TariffChangeFragment;
import com.avito.android.util.LoadingState;
public final class c<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ TariffChangeFragment a;

    public c(TariffChangeFragment tariffChangeFragment) {
        this.a = tariffChangeFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            TariffChangeFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(TariffChangeFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            TariffChangeFragment.access$getProgressOverlay$p(this.a).showContent();
        }
    }
}
