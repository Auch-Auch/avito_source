package a2.a.a.t2;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.shop_settings.ShopSettingsFragment;
import com.avito.android.util.LoadingState;
public final class c<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ ShopSettingsFragment a;

    public c(ShopSettingsFragment shopSettingsFragment) {
        this.a = shopSettingsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        ShopSettingsFragment.access$enableBackground(this.a);
        if (loadingState2 == null) {
            return;
        }
        if (loadingState2 instanceof LoadingState.Loading) {
            ShopSettingsFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(ShopSettingsFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            ShopSettingsFragment.access$getProgressOverlay$p(this.a).showContent();
        }
    }
}
