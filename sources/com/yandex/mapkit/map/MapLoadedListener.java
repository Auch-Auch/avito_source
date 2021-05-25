package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
public interface MapLoadedListener {
    void onMapLoaded(@NonNull MapLoadStatistics mapLoadStatistics);
}
