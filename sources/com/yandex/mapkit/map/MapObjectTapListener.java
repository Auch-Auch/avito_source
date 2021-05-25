package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
public interface MapObjectTapListener {
    boolean onMapObjectTap(@NonNull MapObject mapObject, @NonNull Point point);
}
