package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.CameraEngine;
@RequiresApi(21)
public class LogAction extends BaseAction {
    public static final CameraLogger f = CameraLogger.create(CameraEngine.class.getSimpleName());
    public String e;

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        String str = "aeMode: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE)) + " aeLock: " + ((Boolean) totalCaptureResult.get(CaptureResult.CONTROL_AE_LOCK)) + " aeState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE)) + " aeTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER)) + " afState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE)) + " afTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER));
        if (!str.equals(this.e)) {
            this.e = str;
            f.i(str);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onCompleted(@NonNull ActionHolder actionHolder) {
        super.onCompleted(actionHolder);
        setState(0);
        start(actionHolder);
    }
}
