package a2.a.a.k0.a.b;

import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModelImpl;
import com.avito.android.remote.model.delivery.DeliveryPointsRectResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class s<T> implements Consumer<LoadingState<? super DeliveryPointsRectResult>> {
    public final /* synthetic */ DeliveryRdsStartOrderingViewModelImpl a;

    public s(DeliveryRdsStartOrderingViewModelImpl deliveryRdsStartOrderingViewModelImpl) {
        this.a = deliveryRdsStartOrderingViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super DeliveryPointsRectResult> loadingState) {
        LoadingState<? super DeliveryPointsRectResult> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            DeliveryRdsStartOrderingViewModelImpl.access$onGetMarkersSuccess(this.a, (DeliveryPointsRectResult) ((LoadingState.Loaded) loadingState2).getData());
        } else if (loadingState2 instanceof LoadingState.Error) {
            DeliveryRdsStartOrderingViewModelImpl.access$onGetMarkersError(this.a, ((LoadingState.Error) loadingState2).getError());
        }
    }
}
