package a2.a.a.e3.d;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.tariff.edit_info.EditInfoFragment;
import com.avito.android.util.LoadingState;
public final class a<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ EditInfoFragment a;

    public a(EditInfoFragment editInfoFragment) {
        this.a = editInfoFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            EditInfoFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(EditInfoFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            EditInfoFragment.access$getProgressOverlay$p(this.a).showContent();
        }
    }
}
