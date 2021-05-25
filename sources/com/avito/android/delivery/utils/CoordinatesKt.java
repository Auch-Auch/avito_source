package com.avito.android.delivery.utils;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.model.Coordinates;
import com.google.android.gms.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/Coordinates;", "Lcom/google/android/gms/maps/model/LatLng;", "toLatLng", "(Lcom/avito/android/remote/model/Coordinates;)Lcom/google/android/gms/maps/model/LatLng;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "toAvitoMapPoint", "(Lcom/avito/android/remote/model/Coordinates;)Lcom/avito/android/avito_map/AvitoMapPoint;", "toCoordinates", "(Lcom/google/android/gms/maps/model/LatLng;)Lcom/avito/android/remote/model/Coordinates;", "delivery_release"}, k = 2, mv = {1, 4, 2})
public final class CoordinatesKt {
    @NotNull
    public static final AvitoMapPoint toAvitoMapPoint(@NotNull Coordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "$this$toAvitoMapPoint");
        return new AvitoMapPoint(coordinates.getLatitude(), coordinates.getLongitude());
    }

    @NotNull
    public static final Coordinates toCoordinates(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "$this$toCoordinates");
        return new Coordinates(latLng.latitude, latLng.longitude);
    }

    @NotNull
    public static final LatLng toLatLng(@NotNull Coordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "$this$toLatLng");
        return new LatLng(coordinates.getLatitude(), coordinates.getLongitude());
    }
}
