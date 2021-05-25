package com.yandex.mapkit.layers;

import androidx.annotation.NonNull;
import com.yandex.mapkit.GeoObject;
public interface GeoObjectTapEvent {
    @NonNull
    GeoObject getGeoObject();

    boolean isSelected();

    boolean isValid();

    void setSelected(boolean z);
}
