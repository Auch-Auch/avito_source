package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Geometry;
public class VisibleRegionUtils {
    @NonNull
    public static native Geometry toPolygon(@NonNull VisibleRegion visibleRegion);
}
