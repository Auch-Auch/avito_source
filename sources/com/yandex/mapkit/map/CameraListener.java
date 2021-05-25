package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
public interface CameraListener {
    void onCameraPositionChanged(@NonNull Map map, @NonNull CameraPosition cameraPosition, @NonNull CameraUpdateSource cameraUpdateSource, boolean z);
}
