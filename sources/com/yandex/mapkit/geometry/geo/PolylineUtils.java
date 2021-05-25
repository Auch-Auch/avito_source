package com.yandex.mapkit.geometry.geo;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.geometry.Polyline;
import com.yandex.mapkit.geometry.PolylinePosition;
import java.util.List;
public class PolylineUtils {
    @NonNull
    public static native PolylinePosition advancePolylinePosition(@NonNull Polyline polyline, @NonNull PolylinePosition polylinePosition, double d);

    @NonNull
    public static native Point pointByPolylinePosition(@NonNull Polyline polyline, @NonNull PolylinePosition polylinePosition);

    @NonNull
    public static native List<PolylinePosition> positionsOfFork(@NonNull Polyline polyline, @NonNull PolylinePosition polylinePosition, @NonNull Polyline polyline2, @NonNull PolylinePosition polylinePosition2);
}
