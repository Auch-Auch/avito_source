package com.yandex.mapkit.user_location;

import androidx.annotation.NonNull;
import com.yandex.mapkit.map.CircleMapObject;
import com.yandex.mapkit.map.PlacemarkMapObject;
public interface UserLocationView {
    @NonNull
    CircleMapObject getAccuracyCircle();

    @NonNull
    PlacemarkMapObject getArrow();

    @NonNull
    PlacemarkMapObject getPin();

    boolean isValid();
}
