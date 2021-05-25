package a2.a.a.e3.b;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.tariff.count.TariffCountFragment;
import com.avito.android.util.LoadingState;
public final class a<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ TariffCountFragment a;

    public a(TariffCountFragment tariffCountFragment) {
        this.a = tariffCountFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            TariffCountFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(TariffCountFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            TariffCountFragment.access$getProgressOverlay$p(this.a).showContent();
        }
    }
}
