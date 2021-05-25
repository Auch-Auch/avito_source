package com.avito.android.item_map.amenity;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.item_map.remote.model.AmenityPin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/item_map/remote/model/AmenityPin;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "toAvitoMapPoint", "(Lcom/avito/android/item_map/remote/model/AmenityPin;)Lcom/avito/android/avito_map/AvitoMapPoint;", "item-map_release"}, k = 2, mv = {1, 4, 2})
public final class AmenityButtonsPresenterKt {
    @NotNull
    public static final AvitoMapPoint toAvitoMapPoint(@NotNull AmenityPin amenityPin) {
        Intrinsics.checkNotNullParameter(amenityPin, "$this$toAvitoMapPoint");
        return new AvitoMapPoint(amenityPin.getCoordinates().getLatitude(), amenityPin.getCoordinates().getLongitude());
    }
}
