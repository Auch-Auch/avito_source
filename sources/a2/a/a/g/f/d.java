package a2.a.a.g.f;

import androidx.lifecycle.Observer;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.SnackBarListener;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockView;
import com.avito.android.remote.model.AdvertDeliverySwitchResponse;
import com.avito.android.util.LoadingState;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Observer<LoadingState<? super AdvertDeliverySwitchResponse>> {
    public final /* synthetic */ AdvertDeliveryBlockView a;

    public d(AdvertDeliveryBlockView advertDeliveryBlockView) {
        this.a = advertDeliveryBlockView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<? super AdvertDeliverySwitchResponse> loadingState) {
        LoadingState<? super AdvertDeliverySwitchResponse> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            this.a.setSwitchEnabled(false);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.setSwitchEnabled(true);
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
            if (((AdvertDeliverySwitchResponse) loaded.getData()).getMessage() != null) {
                AdvertDeliveryBlockView.Listener listener = this.a.e;
                String message = ((AdvertDeliverySwitchResponse) loaded.getData()).getMessage();
                Intrinsics.checkNotNull(message);
                listener.showSnackBar(message, 0, 3, this.a.a.getString(R.string.snackbar_action_button_text), new c(this, loadingState2), false);
            }
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.setSwitchEnabled(true);
            AdvertDeliveryBlockView advertDeliveryBlockView = this.a;
            AdvertDeliveryBlockView.access$setToggleValue(advertDeliveryBlockView, true ^ advertDeliveryBlockView.isChecked());
            SnackBarListener.DefaultImpls.showSnackBar$default(this.a.e, AdvertDeliveryBlockView.access$toErrorMessage(this.a, ((LoadingState.Error) loadingState2).getError()), -1, 0, null, null, true, 28, null);
        }
    }
}
