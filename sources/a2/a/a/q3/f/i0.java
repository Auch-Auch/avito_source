package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.util.LoadingState;
import com.avito.android.vas_performance.ui.VisualVasFragment;
public final class i0<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ VisualVasFragment a;

    public i0(VisualVasFragment visualVasFragment) {
        this.a = visualVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            VisualVasFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            VisualVasFragment.access$getProgressOverlay$p(this.a).showContent();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(VisualVasFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        }
    }
}
