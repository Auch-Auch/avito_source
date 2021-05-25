package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
public interface InertiaMoveListener {
    void onCancel(@NonNull Map map, @NonNull CameraPosition cameraPosition);

    void onFinish(@NonNull Map map, @NonNull CameraPosition cameraPosition);

    void onStart(@NonNull Map map, @NonNull CameraPosition cameraPosition);
}
