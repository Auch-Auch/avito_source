package com.avito.android.search.map.utils;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.model.Coordinates;
import com.google.android.gms.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a$\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\b¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\n\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0004\u001a\u00020\fH\b¢\u0006\u0004\b\n\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/android/gms/maps/model/LatLng;", "Lcom/avito/android/remote/model/Coordinates;", "toCoordinates", "(Lcom/google/android/gms/maps/model/LatLng;)Lcom/avito/android/remote/model/Coordinates;", "other", "", "precision", "", "equalsWithPrecision", "(Lcom/google/android/gms/maps/model/LatLng;Lcom/google/android/gms/maps/model/LatLng;D)Z", "equalsByLongitude", "(Lcom/google/android/gms/maps/model/LatLng;Lcom/google/android/gms/maps/model/LatLng;)Z", "Lcom/avito/android/avito_map/AvitoMapPoint;", "(Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapPoint;)Z", "map_release"}, k = 2, mv = {1, 4, 2})
public final class LatLngKt {
    public static final boolean equalsByLongitude(@NotNull LatLng latLng, @NotNull LatLng latLng2) {
        Intrinsics.checkNotNullParameter(latLng, "$this$equalsByLongitude");
        Intrinsics.checkNotNullParameter(latLng2, "other");
        return latLng.longitude == latLng2.longitude;
    }

    public static final boolean equalsWithPrecision(@NotNull LatLng latLng, @NotNull LatLng latLng2, double d) {
        Intrinsics.checkNotNullParameter(latLng, "$this$equalsWithPrecision");
        Intrinsics.checkNotNullParameter(latLng2, "other");
        double d2 = latLng.latitude;
        double d3 = latLng2.latitude;
        if (d2 == d3 && latLng.longitude == latLng2.longitude) {
            return true;
        }
        if (Math.abs(d2 - d3) >= d || Math.abs(latLng.longitude - latLng2.longitude) >= d) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final Coordinates toCoordinates(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "$this$toCoordinates");
        return new Coordinates(latLng.latitude, latLng.longitude);
    }

    public static final boolean equalsByLongitude(@NotNull AvitoMapPoint avitoMapPoint, @NotNull AvitoMapPoint avitoMapPoint2) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "$this$equalsByLongitude");
        Intrinsics.checkNotNullParameter(avitoMapPoint2, "other");
        return avitoMapPoint.getLongitude() == avitoMapPoint2.getLongitude();
    }
}
