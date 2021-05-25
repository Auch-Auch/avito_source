package a2.a.a.h;

import androidx.lifecycle.Observer;
import com.avito.android.advert_stats.AdvertStatsActivity;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.util.LoadingState;
public final class a<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ AdvertStatsActivity a;

    public a(AdvertStatsActivity advertStatsActivity) {
        this.a = advertStatsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            AdvertStatsActivity.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            AdvertStatsActivity.access$getProgressOverlay$p(this.a).showContent();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(AdvertStatsActivity.access$getProgressOverlay$p(this.a), null, 1, null);
        }
    }
}
