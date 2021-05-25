package com.avito.android.location_picker;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapPoint;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/location_picker/MapTransformationsProvider;", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", "latLng", "", "meters", "Lcom/avito/android/avito_map/AvitoMapBounds;", "mapBoundsByCenterAndMeters", "(Lcom/avito/android/avito_map/AvitoMapPoint;J)Lcom/avito/android/avito_map/AvitoMapBounds;", InternalConstsKt.FIRST_IMAGE, "second", "", "distanceBetweenCoordinatesByLongitude", "(Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapPoint;)D", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface MapTransformationsProvider {
    double distanceBetweenCoordinatesByLongitude(@Nullable AvitoMapPoint avitoMapPoint, @Nullable AvitoMapPoint avitoMapPoint2);

    @Nullable
    AvitoMapBounds mapBoundsByCenterAndMeters(@Nullable AvitoMapPoint avitoMapPoint, long j);
}
