package a2.a.a.e3.h;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.tariff.region.RegionFragment;
import com.avito.android.util.LoadingState;
public final class a<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ RegionFragment a;

    public a(RegionFragment regionFragment) {
        this.a = regionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            RegionFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(RegionFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            RegionFragment.access$getProgressOverlay$p(this.a).showContent();
        }
    }
}
