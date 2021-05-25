package com.yandex.mapkit.geometry.geo;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
public interface Projection {
    @NonNull
    XYPoint worldToXY(@NonNull Point point, int i);

    @NonNull
    Point xyToWorld(@NonNull XYPoint xYPoint, int i);
}
