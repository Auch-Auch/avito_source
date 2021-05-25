package com.avito.android.avito_map;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapPoint;", "other", "", "almostEqual", "(Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapPoint;)Z", "avito-map_release"}, k = 2, mv = {1, 4, 2})
public final class AvitoMapPointKt {
    public static final boolean almostEqual(@NotNull AvitoMapPoint avitoMapPoint, @NotNull AvitoMapPoint avitoMapPoint2) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "$this$almostEqual");
        Intrinsics.checkNotNullParameter(avitoMapPoint2, "other");
        return Math.abs(avitoMapPoint.getLatitude() - avitoMapPoint2.getLatitude()) < 1.0E-4d && Math.abs(avitoMapPoint.getLongitude() - avitoMapPoint2.getLongitude()) < 1.0E-4d;
    }
}
