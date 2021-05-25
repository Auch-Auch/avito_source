package a2.a.a.e3.g;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.tariff.landing.TariffLandingFragment;
import com.avito.android.tariff.landing.viewmodel.TariffLanding;
import com.avito.android.util.LoadingState;
public final class b<T> implements Observer<LoadingState<? super TariffLanding>> {
    public final /* synthetic */ TariffLandingFragment a;

    public b(TariffLandingFragment tariffLandingFragment) {
        this.a = tariffLandingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<? super TariffLanding> loadingState) {
        LoadingState<? super TariffLanding> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            this.a.b().showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a.b(), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            TariffLandingFragment.access$handleLoadedState(this.a, (TariffLanding) ((LoadingState.Loaded) loadingState2).getData());
        }
    }
}
