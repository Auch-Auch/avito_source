package a2.a.a.u2;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.shop_settings_select.ShopSettingsSelectFragment;
import com.avito.android.util.LoadingState;
public final class a<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ ShopSettingsSelectFragment a;

    public a(ShopSettingsSelectFragment shopSettingsSelectFragment) {
        this.a = shopSettingsSelectFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 == null) {
            return;
        }
        if (loadingState2 instanceof LoadingState.Loading) {
            ShopSettingsSelectFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(ShopSettingsSelectFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            ShopSettingsSelectFragment.access$getProgressOverlay$p(this.a).showContent();
        }
    }
}
