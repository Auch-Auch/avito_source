package a2.a.a.r.a;

import androidx.lifecycle.Observer;
import com.avito.android.basket_legacy.ui.BasketActivity;
import com.avito.android.basket_legacy.utils.ProgressState;
import com.avito.android.progress_overlay.LoadingOverlay;
public final class b<T> implements Observer<ProgressState> {
    public final /* synthetic */ BasketActivity a;

    public b(BasketActivity basketActivity) {
        this.a = basketActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ProgressState progressState) {
        ProgressState progressState2 = progressState;
        if (progressState2 != null) {
            int ordinal = progressState2.ordinal();
            if (ordinal == 0) {
                BasketActivity.access$getProgressOverlay$p(this.a).showLoading();
            } else if (ordinal == 1) {
                BasketActivity.access$getProgressOverlay$p(this.a).showContent();
            } else if (ordinal == 2) {
                LoadingOverlay.DefaultImpls.showLoadingProblem$default(BasketActivity.access$getProgressOverlay$p(this.a), null, 1, null);
            }
        }
    }
}
