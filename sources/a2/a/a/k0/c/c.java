package a2.a.a.k0.c;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewImpl;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.ui_components.R;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Views;
import kotlin.jvm.functions.Function0;
public final class c<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ DeliveryProfileSettingsViewImpl a;

    public c(DeliveryProfileSettingsViewImpl deliveryProfileSettingsViewImpl) {
        this.a = deliveryProfileSettingsViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            this.a.g.setSwitchEnabled(false);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.g.setSwitchEnabled(true);
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.g.setSwitchEnabled(true);
            DeliveryProfileSettingsViewImpl deliveryProfileSettingsViewImpl = this.a;
            DeliveryProfileSettingsViewImpl.access$setToggleValue(deliveryProfileSettingsViewImpl, true ^ deliveryProfileSettingsViewImpl.g.isChecked());
            if (((LoadingState.Error) loadingState2).getError() instanceof ErrorResult.NetworkIOError) {
                Views.showSnackBar$default(this.a.h, R.string.connection_problem, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
            } else {
                Views.showSnackBar$default(this.a.h, com.avito.android.delivery.R.string.has_error_occurred, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
            }
        }
    }
}
