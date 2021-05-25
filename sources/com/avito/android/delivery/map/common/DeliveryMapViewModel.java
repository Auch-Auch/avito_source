package com.avito.android.delivery.map.common;

import androidx.lifecycle.LiveData;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.delivery.map.common.DeliveryMapView;
import com.avito.android.delivery.map.common.marker.DeliveryMapMarkerIconFactory;
import com.avito.android.delivery.map.common.marker.Marker;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010 \u001a\u00020\u0004H&¢\u0006\u0004\b \u0010\u0010J\u000f\u0010!\u001a\u00020\u0004H&¢\u0006\u0004\b!\u0010\u0010J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000bH&¢\u0006\u0004\b#\u0010\u000eJ\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H&¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H&¢\u0006\u0004\b,\u0010\u0010R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170-8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00130-8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00020-8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010/R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040-8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010/R\u001c\u00109\u001a\b\u0012\u0004\u0012\u0002070-8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u0010/¨\u0006:"}, d2 = {"Lcom/avito/android/delivery/map/common/DeliveryMapViewModel;", "", "", "ready", "", "onMapIsReady", "(Z)V", "Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;", "event", "onNewCameraCoordinates", "(Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;)V", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "onNewLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "requestLocationFromServer", "()V", "onFindMeClick", "", "Lcom/avito/android/delivery/map/common/marker/Marker;", "actualMarkers", "onNewMarkers", "(Ljava/util/List;)V", "", "markerId", "", "latDiff", "", "zoomLevel", "onMarkerClick", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Float;)V", "clearSelection", "showProgress", "showContent", "latLng", "moveCamera", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "mapAttachHelper", "setMapAttachHelper", "(Lcom/avito/android/avito_map/AvitoMapAttachHelper;)V", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;", "factory", "attachIconFactory", "(Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;)V", "detachIconFactory", "Landroidx/lifecycle/LiveData;", "getSnackBarEvents", "()Landroidx/lifecycle/LiveData;", "snackBarEvents", "getMarkerClicks", "markerClicks", "getRequestLocationEvents", "requestLocationEvents", "getSelectedMarkerDisappearedEvents", "selectedMarkerDisappearedEvents", "Lcom/avito/android/delivery/map/common/DeliveryMapView$State;", "getViewStateChanges", "viewStateChanges", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryMapViewModel {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onMarkerClick$default(DeliveryMapViewModel deliveryMapViewModel, String str, Double d, Float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    f = null;
                }
                deliveryMapViewModel.onMarkerClick(str, d, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMarkerClick");
        }
    }

    void attachIconFactory(@NotNull DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory);

    void clearSelection();

    void detachIconFactory();

    @NotNull
    LiveData<Marker> getMarkerClicks();

    @NotNull
    LiveData<Boolean> getRequestLocationEvents();

    @NotNull
    LiveData<Unit> getSelectedMarkerDisappearedEvents();

    @NotNull
    LiveData<String> getSnackBarEvents();

    @NotNull
    LiveData<DeliveryMapView.State> getViewStateChanges();

    void moveCamera(@NotNull AvitoMapPoint avitoMapPoint);

    void onFindMeClick();

    void onMapIsReady(boolean z);

    void onMarkerClick(@NotNull String str, @Nullable Double d, @Nullable Float f);

    void onNewCameraCoordinates(@NotNull CameraCoordinatesEvent cameraCoordinatesEvent);

    void onNewLocation(@NotNull AvitoMapPoint avitoMapPoint);

    void onNewMarkers(@NotNull List<? extends Marker> list);

    void requestLocationFromServer();

    void setMapAttachHelper(@NotNull AvitoMapAttachHelper avitoMapAttachHelper);

    void showContent();

    void showProgress();
}
