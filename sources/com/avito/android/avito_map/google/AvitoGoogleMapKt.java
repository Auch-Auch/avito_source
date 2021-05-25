package com.avito.android.avito_map.google;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapPoint;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0004*\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/android/gms/maps/model/LatLng;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "toAvitoMapPoint", "(Lcom/google/android/gms/maps/model/LatLng;)Lcom/avito/android/avito_map/AvitoMapPoint;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "Lcom/google/android/gms/maps/model/LatLngBounds;", "toLatLngBounds", "(Lcom/avito/android/avito_map/AvitoMapBounds;)Lcom/google/android/gms/maps/model/LatLngBounds;", "toAvitoMapBounds", "(Lcom/google/android/gms/maps/model/LatLngBounds;)Lcom/avito/android/avito_map/AvitoMapBounds;", "avito-map_release"}, k = 2, mv = {1, 4, 2})
public final class AvitoGoogleMapKt {
    @NotNull
    public static final AvitoMapBounds toAvitoMapBounds(@NotNull LatLngBounds latLngBounds) {
        Intrinsics.checkNotNullParameter(latLngBounds, "$this$toAvitoMapBounds");
        return new AvitoMapBounds(new AvitoMapPoint(latLngBounds.northeast.latitude, latLngBounds.southwest.longitude), new AvitoMapPoint(latLngBounds.southwest.latitude, latLngBounds.northeast.longitude));
    }

    @NotNull
    public static final AvitoMapPoint toAvitoMapPoint(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "$this$toAvitoMapPoint");
        return new AvitoMapPoint(latLng.latitude, latLng.longitude);
    }

    @NotNull
    public static final LatLngBounds toLatLngBounds(@NotNull AvitoMapBounds avitoMapBounds) {
        Intrinsics.checkNotNullParameter(avitoMapBounds, "$this$toLatLngBounds");
        return new LatLngBounds(new LatLng(avitoMapBounds.getBottomRight().getLatitude(), avitoMapBounds.getTopLeft().getLongitude()), new LatLng(avitoMapBounds.getTopLeft().getLatitude(), avitoMapBounds.getBottomRight().getLongitude()));
    }
}
