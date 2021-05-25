package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.util.LoadingState;
import com.avito.android.vas_performance.ui.LegacyVisualVasFragment;
public final class k<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ LegacyVisualVasFragment a;

    public k(LegacyVisualVasFragment legacyVisualVasFragment) {
        this.a = legacyVisualVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            LegacyVisualVasFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            LegacyVisualVasFragment.access$getProgressOverlay$p(this.a).showContent();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(LegacyVisualVasFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        }
    }
}
