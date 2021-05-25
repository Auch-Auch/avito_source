package com.yandex.mapkit.layers;

import androidx.annotation.NonNull;
public interface GeoObjectTapListener {
    boolean onObjectTap(@NonNull GeoObjectTapEvent geoObjectTapEvent);
}
