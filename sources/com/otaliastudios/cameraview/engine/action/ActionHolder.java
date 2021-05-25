package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
public interface ActionHolder {
    void addAction(@NonNull Action action);

    void applyBuilder(@NonNull Action action);

    void applyBuilder(@NonNull Action action, @NonNull CaptureRequest.Builder builder) throws CameraAccessException;

    @NonNull
    CaptureRequest.Builder getBuilder(@NonNull Action action);

    @NonNull
    CameraCharacteristics getCharacteristics(@NonNull Action action);

    @Nullable
    TotalCaptureResult getLastResult(@NonNull Action action);

    void removeAction(@NonNull Action action);
}
