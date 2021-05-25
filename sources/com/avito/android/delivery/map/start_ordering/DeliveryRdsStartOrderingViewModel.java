package com.avito.android.delivery.map.start_ordering;

import androidx.lifecycle.LiveData;
import com.avito.android.SummaryState;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.delivery.map.common.CameraCoordinatesEvent;
import com.avito.android.delivery.map.common.marker.Marker;
import com.avito.android.remote.model.delivery.Overlay;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\"\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0019R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0019¨\u0006)"}, d2 = {"Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModel;", "", "Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;", "event", "", "onNewCameraCoordinates", "(Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;)V", "onAuthCompleted", "()V", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "onNewLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "", "isNeedOpenCheckout", "()Z", "Lcom/avito/android/SummaryState;", "state", "setDataFromCheckout", "(Lcom/avito/android/SummaryState;)V", "summaryState", "()Lcom/avito/android/SummaryState;", "Landroidx/lifecycle/LiveData;", "", "getSnackBarEvents", "()Landroidx/lifecycle/LiveData;", "snackBarEvents", "getSelectCheckoutPinEvent", "selectCheckoutPinEvent", "", "Lcom/avito/android/delivery/map/common/marker/Marker;", "getNewMarkersEvents", "newMarkersEvents", "getAuthScreenChanges", "authScreenChanges", "Lcom/avito/android/delivery/map/start_ordering/PreselectPinEvent;", "getPreselectPinEvent", "preselectPinEvent", "Lcom/avito/android/remote/model/delivery/Overlay;", "getOverlayEvent", "overlayEvent", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryRdsStartOrderingViewModel {
    @NotNull
    LiveData<Unit> getAuthScreenChanges();

    @NotNull
    LiveData<List<Marker>> getNewMarkersEvents();

    @NotNull
    LiveData<Overlay> getOverlayEvent();

    @NotNull
    LiveData<PreselectPinEvent> getPreselectPinEvent();

    @NotNull
    LiveData<String> getSelectCheckoutPinEvent();

    @NotNull
    LiveData<String> getSnackBarEvents();

    boolean isNeedOpenCheckout();

    void onAuthCompleted();

    void onNewCameraCoordinates(@NotNull CameraCoordinatesEvent cameraCoordinatesEvent);

    void onNewLocation(@Nullable AvitoMapPoint avitoMapPoint);

    void setDataFromCheckout(@Nullable SummaryState summaryState);

    @Nullable
    SummaryState summaryState();
}
