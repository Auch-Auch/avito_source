package com.avito.android.delivery.map.start_ordering;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.delivery.DeliveryPointsRectResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JQ\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingInteractor;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/avito_map/AvitoMapPoint;", "topLeft", "bottomRight", "", "clusterRadius", "userCoords", "", "useOrderHistory", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery/DeliveryPointsRectResult;", "getDeliveryPoints", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/Float;Lcom/avito/android/avito_map/AvitoMapPoint;Z)Lio/reactivex/rxjava3/core/Observable;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryRdsStartOrderingInteractor {
    @NotNull
    Observable<LoadingState<DeliveryPointsRectResult>> getDeliveryPoints(@Nullable String str, @NotNull AvitoMapPoint avitoMapPoint, @NotNull AvitoMapPoint avitoMapPoint2, @Nullable Float f, @Nullable AvitoMapPoint avitoMapPoint3, boolean z);
}
