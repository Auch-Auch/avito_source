package com.avito.android.delivery.map.start_ordering;

import com.avito.android.delivery.map.common.marker.Marker;
import com.avito.android.delivery.map.common.marker.MarkersKt;
import com.avito.android.remote.model.delivery.Cluster;
import com.avito.android.remote.model.delivery.DeliveryPointRect;
import com.avito.android.remote.model.delivery.DeliveryPointsRectResult;
import com.avito.android.remote.model.delivery.DeliveryPreselectPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0003\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPointsRectResult;", "", "Lcom/avito/android/delivery/map/common/marker/Marker;", "convert", "(Lcom/avito/android/remote/model/delivery/DeliveryPointsRectResult;)Ljava/util/List;", "Lcom/avito/android/remote/model/delivery/DeliveryPreselectPoint;", "Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "(Lcom/avito/android/remote/model/delivery/DeliveryPreselectPoint;)Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "delivery_release"}, k = 2, mv = {1, 4, 2})
public final class DeliveryRdsStartOrderingViewModelKt {
    @NotNull
    public static final List<Marker> convert(@NotNull DeliveryPointsRectResult deliveryPointsRectResult) {
        Intrinsics.checkNotNullParameter(deliveryPointsRectResult, "$this$convert");
        ArrayList arrayList = new ArrayList();
        List<DeliveryPointRect> pins = deliveryPointsRectResult.getPins();
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(pins, 10));
        Iterator<T> it = pins.iterator();
        while (it.hasNext()) {
            arrayList2.add(MarkersKt.convert$default(it.next(), null, 1, null));
        }
        arrayList.addAll(arrayList2);
        List<Cluster> clusters = deliveryPointsRectResult.getClusters();
        ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(clusters, 10));
        Iterator<T> it2 = clusters.iterator();
        while (it2.hasNext()) {
            arrayList3.add(MarkersKt.convert(it2.next()));
        }
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    @NotNull
    public static final Marker.Pin convert(@NotNull DeliveryPreselectPoint deliveryPreselectPoint) {
        Intrinsics.checkNotNullParameter(deliveryPreselectPoint, "$this$convert");
        return MarkersKt.convert(deliveryPreselectPoint.getPin(), deliveryPreselectPoint.getZoomLevel());
    }
}
