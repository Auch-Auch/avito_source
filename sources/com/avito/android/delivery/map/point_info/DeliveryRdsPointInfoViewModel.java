package com.avito.android.delivery.map.point_info;

import androidx.lifecycle.LiveData;
import com.avito.android.delivery.map.common.marker.Marker;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView;
import com.avito.android.remote.model.delivery.Overlay;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0011\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\bR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModel;", "", "Lcom/avito/android/delivery/map/common/marker/Marker;", "marker", "", "onMarkerClicked", "(Lcom/avito/android/delivery/map/common/marker/Marker;)V", "onSelectedMarkerDisappeared", "()V", "Lcom/avito/android/remote/model/delivery/Overlay;", "overlay", "onNewOverlay", "(Lcom/avito/android/remote/model/delivery/Overlay;)V", "retry", "", "selectedService", "()Ljava/lang/String;", "fiasGuid", "markerId", "hide", "Landroidx/lifecycle/LiveData;", "getSnackBarEvents", "()Landroidx/lifecycle/LiveData;", "snackBarEvents", "Lio/reactivex/rxjava3/functions/Consumer;", "getServiceSelectConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "serviceSelectConsumer", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State;", "getPointInfoStateChanges", "pointInfoStateChanges", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryRdsPointInfoViewModel {
    @Nullable
    String fiasGuid();

    @NotNull
    LiveData<DeliveryRdsPointInfoView.State> getPointInfoStateChanges();

    @NotNull
    Consumer<String> getServiceSelectConsumer();

    @NotNull
    LiveData<String> getSnackBarEvents();

    void hide();

    @Nullable
    String markerId();

    void onMarkerClicked(@NotNull Marker marker);

    void onNewOverlay(@Nullable Overlay overlay);

    void onSelectedMarkerDisappeared();

    void retry();

    @Nullable
    String selectedService();
}
