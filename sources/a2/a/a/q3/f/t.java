package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.util.LoadingState;
import com.avito.android.vas_performance.ui.PerformanceVasFragment;
public final class t<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ PerformanceVasFragment a;

    public t(PerformanceVasFragment performanceVasFragment) {
        this.a = performanceVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            PerformanceVasFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            PerformanceVasFragment.access$getProgressOverlay$p(this.a).showContent();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(PerformanceVasFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        }
    }
}
