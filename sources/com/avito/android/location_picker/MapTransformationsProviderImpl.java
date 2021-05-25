package com.avito.android.location_picker;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapPoint;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/location_picker/MapTransformationsProviderImpl;", "Lcom/avito/android/location_picker/MapTransformationsProvider;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "latLng", "", "meters", "Lcom/avito/android/avito_map/AvitoMapBounds;", "mapBoundsByCenterAndMeters", "(Lcom/avito/android/avito_map/AvitoMapPoint;J)Lcom/avito/android/avito_map/AvitoMapBounds;", InternalConstsKt.FIRST_IMAGE, "second", "", "distanceBetweenCoordinatesByLongitude", "(Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapPoint;)D", "<init>", "()V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class MapTransformationsProviderImpl implements MapTransformationsProvider {
    @Override // com.avito.android.location_picker.MapTransformationsProvider
    public double distanceBetweenCoordinatesByLongitude(@Nullable AvitoMapPoint avitoMapPoint, @Nullable AvitoMapPoint avitoMapPoint2) {
        if (avitoMapPoint == null || avitoMapPoint2 == null) {
            return 0.0d;
        }
        double latitude = avitoMapPoint.getLatitude();
        double latitude2 = avitoMapPoint.getLatitude();
        double longitude = avitoMapPoint.getLongitude();
        double longitude2 = avitoMapPoint2.getLongitude();
        double radians = Math.toRadians(latitude2 - latitude);
        double radians2 = Math.toRadians(longitude2 - longitude);
        double d = (double) 2;
        double d2 = radians / d;
        double sin = Math.sin(d2);
        double d3 = radians2 / d;
        double a = a.a(d3, Math.sin(d3) * Math.cos(Math.toRadians(latitude2)) * Math.cos(Math.toRadians(latitude)), Math.sin(d2) * sin);
        return Math.atan2(Math.sqrt(a), Math.sqrt(((double) 1) - a)) * d * 6378.137d * 1000.0d;
    }

    @Override // com.avito.android.location_picker.MapTransformationsProvider
    @Nullable
    public AvitoMapBounds mapBoundsByCenterAndMeters(@Nullable AvitoMapPoint avitoMapPoint, long j) {
        if (avitoMapPoint == null) {
            return null;
        }
        double cos = (((double) j) * ((((double) 1) / (((((double) 2) * 3.141592653589793d) / ((double) 360)) * 6378.137d)) / ((double) 1000))) / Math.cos((3.141592653589793d / ((double) 180)) * avitoMapPoint.getLatitude());
        return new AvitoMapBounds(new AvitoMapPoint(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude() - cos), new AvitoMapPoint(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude() + cos));
    }
}
