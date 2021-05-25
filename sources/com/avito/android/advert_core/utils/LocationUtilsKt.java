package com.avito.android.advert_core.utils;

import android.location.Location;
import com.avito.android.remote.model.Coordinates;
import com.google.android.gms.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/location/Location;", "Lcom/avito/android/remote/model/Coordinates;", "toCoordinates", "(Landroid/location/Location;)Lcom/avito/android/remote/model/Coordinates;", "Lcom/google/android/gms/maps/model/LatLng;", "toLatLng", "(Landroid/location/Location;)Lcom/google/android/gms/maps/model/LatLng;", "advert-core_release"}, k = 2, mv = {1, 4, 2})
public final class LocationUtilsKt {
    @NotNull
    public static final Coordinates toCoordinates(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "$this$toCoordinates");
        return new Coordinates(location.getLatitude(), location.getLongitude());
    }

    @NotNull
    public static final LatLng toLatLng(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "$this$toLatLng");
        return new LatLng(location.getLatitude(), location.getLongitude());
    }
}
