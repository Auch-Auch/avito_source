package a2.a.a.k0.c;

import com.avito.android.delivery.profile_settings.DeliveryProfileSettings;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<LoadingState<? super DeliveryProfileSettings>> {
    public final /* synthetic */ DeliveryProfileSettingsViewModelImpl a;

    public h(DeliveryProfileSettingsViewModelImpl deliveryProfileSettingsViewModelImpl) {
        this.a = deliveryProfileSettingsViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super DeliveryProfileSettings> loadingState) {
        LoadingState<? super DeliveryProfileSettings> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.g = (DeliveryProfileSettings) ((LoadingState.Loaded) loadingState2).getData();
            this.a.k.trackPrepared();
            this.a.k.startDrawing();
            this.a.getDataChanges().postValue(this.a.g);
            this.a.k.trackDrawn();
        }
        this.a.getProgressChanges().postValue(loadingState2);
    }
}
