package com.otaliastudios.cameraview;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
public abstract class CameraListener {
    @UiThread
    public void onAutoFocusEnd(boolean z, @NonNull PointF pointF) {
    }

    @UiThread
    public void onAutoFocusStart(@NonNull PointF pointF) {
    }

    @UiThread
    public void onCameraClosed() {
    }

    @UiThread
    public void onCameraError(@NonNull CameraException cameraException) {
    }

    @UiThread
    public void onCameraOpened(@NonNull CameraOptions cameraOptions) {
    }

    @UiThread
    public void onExposureCorrectionChanged(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr) {
    }

    @UiThread
    public void onOrientationChanged(int i) {
    }

    @UiThread
    public void onPictureShutter() {
    }

    @UiThread
    public void onPictureTaken(@NonNull PictureResult pictureResult) {
    }

    @UiThread
    public void onVideoRecordingEnd() {
    }

    @UiThread
    public void onVideoRecordingStart() {
    }

    @UiThread
    public void onVideoTaken(@NonNull VideoResult videoResult) {
    }

    @UiThread
    public void onZoomChanged(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr) {
    }
}
