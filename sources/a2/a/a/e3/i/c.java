package a2.a.a.e3.i;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment;
import com.avito.android.util.LoadingState;
public final class c<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ TariffPackageInfoFragment a;

    public c(TariffPackageInfoFragment tariffPackageInfoFragment) {
        this.a = tariffPackageInfoFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            TariffPackageInfoFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(TariffPackageInfoFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            TariffPackageInfoFragment.access$getProgressOverlay$p(this.a).showContent();
        }
    }
}
