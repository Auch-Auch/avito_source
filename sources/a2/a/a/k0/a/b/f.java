package a2.a.a.k0.a.b;

import com.avito.android.delivery.map.common.CameraCoordinatesEvent;
import com.avito.android.delivery.map.common.DeliveryMapViewModel;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<CameraCoordinatesEvent> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public f(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(CameraCoordinatesEvent cameraCoordinatesEvent) {
        CameraCoordinatesEvent cameraCoordinatesEvent2 = cameraCoordinatesEvent;
        DeliveryMapViewModel mapViewModel = this.a.getMapViewModel();
        Intrinsics.checkNotNullExpressionValue(cameraCoordinatesEvent2, "newCameraCoordinates");
        mapViewModel.onNewCameraCoordinates(cameraCoordinatesEvent2);
        this.a.getStartOrderingViewModel().onNewCameraCoordinates(cameraCoordinatesEvent2);
    }
}
