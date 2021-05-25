package com.avito.android.avito_map.clustering;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.auth.AuthSource;
import com.google.maps.android.projection.Point;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/avito_map/clustering/SphericalMercatorProjection;", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", "latLng", "Lcom/google/maps/android/projection/Point;", "latLngToPoint", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lcom/google/maps/android/projection/Point;", "", AuthSource.SEND_ABUSE, "D", "mWorldWidth", "<init>", "(D)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class SphericalMercatorProjection {
    public final double a;

    public SphericalMercatorProjection(double d) {
        this.a = d;
    }

    @NotNull
    public final Point latLngToPoint(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
        double sin = Math.sin(Math.toRadians(avitoMapPoint.getLatitude()));
        double d = this.a;
        return new Point(((avitoMapPoint.getLongitude() / 360.0d) + 0.5d) * d, (((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * d);
    }
}
