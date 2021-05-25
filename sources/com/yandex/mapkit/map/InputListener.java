package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
public interface InputListener {
    void onMapLongTap(@NonNull Map map, @NonNull Point point);

    void onMapTap(@NonNull Map map, @NonNull Point point);
}
