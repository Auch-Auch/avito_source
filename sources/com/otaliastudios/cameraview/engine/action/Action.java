package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
public interface Action {
    public static final int STATE_COMPLETED = Integer.MAX_VALUE;

    void abort(@NonNull ActionHolder actionHolder);

    void addCallback(@NonNull ActionCallback actionCallback);

    int getState();

    void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult);

    void onCaptureProgressed(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult);

    void onCaptureStarted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest);

    void removeCallback(@NonNull ActionCallback actionCallback);

    void start(@NonNull ActionHolder actionHolder);
}
