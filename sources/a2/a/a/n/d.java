package a2.a.a.n;

import com.avito.android.autodeal_details.AutoDealDetailsActivity;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<PowerWebViewStateChangeEvent> {
    public final /* synthetic */ AutoDealDetailsActivity a;

    public d(AutoDealDetailsActivity autoDealDetailsActivity) {
        this.a = autoDealDetailsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(PowerWebViewStateChangeEvent powerWebViewStateChangeEvent) {
        int ordinal = powerWebViewStateChangeEvent.getState().ordinal();
        if (ordinal == 0) {
            AutoDealDetailsActivity.access$getProgressOverlay$p(this.a).showLoading();
        } else if (ordinal == 1) {
            AutoDealDetailsActivity.access$getProgressOverlay$p(this.a).showContent();
        } else if (ordinal == 3) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(AutoDealDetailsActivity.access$getProgressOverlay$p(this.a), null, 1, null);
        }
    }
}
