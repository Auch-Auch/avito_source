package a2.a.a.z0;

import androidx.lifecycle.Observer;
import com.avito.android.hints.HintsDialogFragment;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Views;
public final class b<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ HintsDialogFragment a;

    public b(HintsDialogFragment hintsDialogFragment) {
        this.a = hintsDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 != null) {
            if (!Views.isVisible(HintsDialogFragment.access$getBottomSheet$p(this.a).getView())) {
                Views.show(HintsDialogFragment.access$getBottomSheet$p(this.a).getView());
                HintsDialogFragment.access$getBottomSheet$p(this.a).expand();
                HintsDialogFragment.access$getBottomSheet$p(this.a).setLockExpanded(true);
            }
            if (loadingState2 instanceof LoadingState.Loading) {
                HintsDialogFragment.access$getProgressOverlay$p(this.a).showLoading();
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                HintsDialogFragment.access$getProgressOverlay$p(this.a).showContent();
            } else if (loadingState2 instanceof LoadingState.Error) {
                LoadingOverlay.DefaultImpls.showLoadingProblem$default(HintsDialogFragment.access$getProgressOverlay$p(this.a), null, 1, null);
            }
        }
    }
}
