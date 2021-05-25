package com.avito.android.search.map.utils;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.search.map.Area;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\r\u001a\u00020\f*\u0004\u0018\u00010\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\b¢\u0006\u0004\b\r\u0010\u000e\u001a \u0010\u000f\u001a\u00020\f*\u0004\u0018\u00010\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a \u0010\u000f\u001a\u00020\f*\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0011H\b¢\u0006\u0004\b\u000f\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/google/android/gms/maps/model/LatLngBounds;", "Lcom/avito/android/remote/model/search/map/Area;", "toArea", "(Lcom/google/android/gms/maps/model/LatLngBounds;)Lcom/avito/android/remote/model/search/map/Area;", "toLatLngBounds", "(Lcom/avito/android/remote/model/search/map/Area;)Lcom/google/android/gms/maps/model/LatLngBounds;", "", "", "toAnalyticsCoords", "(Lcom/google/android/gms/maps/model/LatLngBounds;)Ljava/util/List;", "other", "precision", "", "equalsWithPrecision", "(Lcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/maps/model/LatLngBounds;D)Z", "equalsByLongitude", "(Lcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/maps/model/LatLngBounds;)Z", "Lcom/avito/android/avito_map/AvitoMapBounds;", "(Lcom/avito/android/avito_map/AvitoMapBounds;Lcom/avito/android/avito_map/AvitoMapBounds;)Z", "map_release"}, k = 2, mv = {1, 4, 2})
public final class LatLngBoundsKt {
    public static final boolean equalsByLongitude(@Nullable LatLngBounds latLngBounds, @Nullable LatLngBounds latLngBounds2) {
        if (latLngBounds2 == null || latLngBounds == null) {
            return false;
        }
        LatLng latLng = latLngBounds.northeast;
        Intrinsics.checkNotNullExpressionValue(latLng, "northeast");
        LatLng latLng2 = latLngBounds2.northeast;
        Intrinsics.checkNotNullExpressionValue(latLng2, "other.northeast");
        if (!(latLng.longitude == latLng2.longitude)) {
            return false;
        }
        LatLng latLng3 = latLngBounds.southwest;
        Intrinsics.checkNotNullExpressionValue(latLng3, "southwest");
        LatLng latLng4 = latLngBounds2.southwest;
        Intrinsics.checkNotNullExpressionValue(latLng4, "other.southwest");
        if (latLng3.longitude == latLng4.longitude) {
            return true;
        }
        return false;
    }

    public static final boolean equalsWithPrecision(@Nullable LatLngBounds latLngBounds, @Nullable LatLngBounds latLngBounds2, double d) {
        boolean z;
        boolean z2;
        if (latLngBounds2 == null || latLngBounds == null) {
            return false;
        }
        LatLng latLng = latLngBounds.southwest;
        Intrinsics.checkNotNullExpressionValue(latLng, "southwest");
        LatLng latLng2 = latLngBounds2.southwest;
        Intrinsics.checkNotNullExpressionValue(latLng2, "other.southwest");
        double d2 = latLng.latitude;
        double d3 = latLng2.latitude;
        if (!(d2 == d3 && latLng.longitude == latLng2.longitude) && (Math.abs(d2 - d3) >= d || Math.abs(latLng.longitude - latLng2.longitude) >= d)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        LatLng latLng3 = latLngBounds.northeast;
        Intrinsics.checkNotNullExpressionValue(latLng3, "northeast");
        LatLng latLng4 = latLngBounds2.northeast;
        Intrinsics.checkNotNullExpressionValue(latLng4, "other.northeast");
        double d4 = latLng3.latitude;
        double d5 = latLng4.latitude;
        if (!(d4 == d5 && latLng3.longitude == latLng4.longitude) && (Math.abs(d4 - d5) >= d || Math.abs(latLng3.longitude - latLng4.longitude) >= d)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean equalsWithPrecision$default(LatLngBounds latLngBounds, LatLngBounds latLngBounds2, double d, int i, Object obj) {
        boolean z;
        boolean z2;
        double d2 = (i & 2) != 0 ? 1.0E-7d : d;
        if (latLngBounds2 == null || latLngBounds == null) {
            return false;
        }
        LatLng latLng = latLngBounds.southwest;
        Intrinsics.checkNotNullExpressionValue(latLng, "southwest");
        LatLng latLng2 = latLngBounds2.southwest;
        Intrinsics.checkNotNullExpressionValue(latLng2, "other.southwest");
        double d3 = latLng.latitude;
        double d4 = latLng2.latitude;
        if (!(d3 == d4 && latLng.longitude == latLng2.longitude) && (Math.abs(d3 - d4) >= d2 || Math.abs(latLng.longitude - latLng2.longitude) >= d2)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        LatLng latLng3 = latLngBounds.northeast;
        Intrinsics.checkNotNullExpressionValue(latLng3, "northeast");
        LatLng latLng4 = latLngBounds2.northeast;
        Intrinsics.checkNotNullExpressionValue(latLng4, "other.northeast");
        double d5 = latLng3.latitude;
        double d6 = latLng4.latitude;
        if (!(d5 == d6 && latLng3.longitude == latLng4.longitude) && (Math.abs(d5 - d6) >= d2 || Math.abs(latLng3.longitude - latLng4.longitude) >= d2)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final List<Double> toAnalyticsCoords(@NotNull LatLngBounds latLngBounds) {
        Intrinsics.checkNotNullParameter(latLngBounds, "$this$toAnalyticsCoords");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(latLngBounds.southwest.latitude), Double.valueOf(latLngBounds.southwest.longitude), Double.valueOf(latLngBounds.northeast.latitude), Double.valueOf(latLngBounds.northeast.longitude)});
    }

    @NotNull
    public static final Area toArea(@NotNull LatLngBounds latLngBounds) {
        Intrinsics.checkNotNullParameter(latLngBounds, "$this$toArea");
        return new Area(new Coordinates(latLngBounds.northeast.latitude, latLngBounds.southwest.longitude), new Coordinates(latLngBounds.southwest.latitude, latLngBounds.northeast.longitude));
    }

    @NotNull
    public static final LatLngBounds toLatLngBounds(@NotNull Area area) {
        Intrinsics.checkNotNullParameter(area, "$this$toLatLngBounds");
        return new LatLngBounds(new LatLng(area.getBottomRight().getLatitude(), area.getTopLeft().getLongitude()), new LatLng(area.getTopLeft().getLatitude(), area.getBottomRight().getLongitude()));
    }

    public static final boolean equalsByLongitude(@Nullable AvitoMapBounds avitoMapBounds, @Nullable AvitoMapBounds avitoMapBounds2) {
        if (avitoMapBounds2 == null || avitoMapBounds == null) {
            return false;
        }
        if (!(avitoMapBounds.getTopLeft().getLongitude() == avitoMapBounds2.getTopLeft().getLongitude())) {
            return false;
        }
        if (avitoMapBounds.getBottomRight().getLongitude() == avitoMapBounds2.getBottomRight().getLongitude()) {
            return true;
        }
        return false;
    }
}
