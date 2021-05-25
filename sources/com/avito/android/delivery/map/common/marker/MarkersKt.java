package com.avito.android.delivery.map.common.marker;

import com.avito.android.delivery.map.common.marker.Marker;
import com.avito.android.delivery.utils.CoordinatesKt;
import com.avito.android.remote.model.delivery.Cluster;
import com.avito.android.remote.model.delivery.DeliveryPointRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0004\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b\"\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u000b\"\u0016\u0010\r\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000b\"\u0016\u0010\u000e\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b\"\u0016\u0010\u000f\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b\"\u0016\u0010\u0010\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000b\"\u0016\u0010\u0011\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPointRect;", "", "zoomLevel", "Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "convert", "(Lcom/avito/android/remote/model/delivery/DeliveryPointRect;Ljava/lang/Float;)Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "Lcom/avito/android/remote/model/delivery/Cluster;", "Lcom/avito/android/delivery/map/common/marker/Marker$Cluster;", "(Lcom/avito/android/remote/model/delivery/Cluster;)Lcom/avito/android/delivery/map/common/marker/Marker$Cluster;", "", "ICON_ID_PIN_SELECTED", "Ljava/lang/String;", "ICON_ID_PIN_WITH_LABEL", "STUB_CLUSTER_TEXT", "ICON_ID_CLUSTER_DEFAULT", "ICON_ID_CLUSTER_WITH_LABEL", "ICON_ID_PIN_DEFAULT", "ICON_ID_MY_LOCATION", "delivery_release"}, k = 2, mv = {1, 4, 2})
public final class MarkersKt {
    @NotNull
    public static final String ICON_ID_CLUSTER_DEFAULT = "cluster_default %s";
    @NotNull
    public static final String ICON_ID_CLUSTER_WITH_LABEL = "cluster_with_label %s %s";
    @NotNull
    public static final String ICON_ID_MY_LOCATION = "my_location";
    @NotNull
    public static final String ICON_ID_PIN_DEFAULT = "pin_default";
    @NotNull
    public static final String ICON_ID_PIN_SELECTED = "pin_selected %s %s";
    @NotNull
    public static final String ICON_ID_PIN_WITH_LABEL = "pin_with_label %s %s";
    @NotNull
    public static final String STUB_CLUSTER_TEXT = "2222";

    @NotNull
    public static final Marker.Pin convert(@NotNull DeliveryPointRect deliveryPointRect, @Nullable Float f) {
        Intrinsics.checkNotNullParameter(deliveryPointRect, "$this$convert");
        return new Marker.Pin(deliveryPointRect.getId(), CoordinatesKt.toAvitoMapPoint(deliveryPointRect.getCoordinates()), deliveryPointRect.getFiasGuid(), deliveryPointRect.getServiceIds(), deliveryPointRect.getHint(), f);
    }

    public static /* synthetic */ Marker.Pin convert$default(DeliveryPointRect deliveryPointRect, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        return convert(deliveryPointRect, f);
    }

    @NotNull
    public static final Marker.Cluster convert(@NotNull Cluster cluster) {
        Intrinsics.checkNotNullParameter(cluster, "$this$convert");
        return new Marker.Cluster(cluster.getId(), CoordinatesKt.toAvitoMapPoint(cluster.getCoordinates()), cluster.getCount(), cluster.getHint());
    }
}
