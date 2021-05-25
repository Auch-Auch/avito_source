package a2.a.a.k0.c;

import com.avito.android.delivery.profile_settings.DeliveryProfileSettings;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModelImpl;
import com.avito.android.remote.model.delivery.DeliveryProfileSettingsResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<LoadingState<? super DeliveryProfileSettingsResponse>, LoadingState<? super DeliveryProfileSettings>> {
    public final /* synthetic */ DeliveryProfileSettingsViewModelImpl a;

    public g(DeliveryProfileSettingsViewModelImpl deliveryProfileSettingsViewModelImpl) {
        this.a = deliveryProfileSettingsViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.remote.model.delivery.DeliveryProfileSettingsResponse> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public LoadingState<? super DeliveryProfileSettings> apply(LoadingState<? super DeliveryProfileSettingsResponse> loadingState) {
        LoadingState<? super DeliveryProfileSettingsResponse> loadingState2 = loadingState;
        Intrinsics.checkNotNullParameter(loadingState2, "it");
        if (!(loadingState2 instanceof LoadingState.Loaded)) {
            return loadingState2;
        }
        this.a.k.trackLoaded();
        this.a.k.startPreparing();
        return new LoadingState.Loaded(this.a.i.convertToDeliveryProfileSettings((DeliveryProfileSettingsResponse) ((LoadingState.Loaded) loadingState2).getData()));
    }
}
