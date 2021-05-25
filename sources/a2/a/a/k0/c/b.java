package a2.a.a.k0.c;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewImpl;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.util.LoadingState;
public final class b<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ DeliveryProfileSettingsViewImpl a;

    public b(DeliveryProfileSettingsViewImpl deliveryProfileSettingsViewImpl) {
        this.a = deliveryProfileSettingsViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            this.a.c.showLoading();
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.c.showContent();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a.c, null, 1, null);
        }
    }
}
