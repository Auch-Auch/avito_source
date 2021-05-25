package com.yandex.mapkit.map;

import com.yandex.mapkit.geometry.BoundingBox;
public class Tools {
    public static BoundingBox getBounds(VisibleRegion visibleRegion) {
        return getBoundsNative(visibleRegion, BoundingBox.class);
    }

    private static native BoundingBox getBoundsNative(VisibleRegion visibleRegion, Class cls);
}
