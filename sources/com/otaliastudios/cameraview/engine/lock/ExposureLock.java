package com.otaliastudios.cameraview.engine.lock;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
@RequiresApi(21)
public class ExposureLock extends BaseLock {
    public static final CameraLogger e = CameraLogger.create(ExposureLock.class.getSimpleName());

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public boolean checkIsSupported(@NonNull ActionHolder actionHolder) {
        boolean z = ((Integer) readCharacteristic(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) actionHolder.getBuilder(this).get(CaptureRequest.CONTROL_AE_MODE);
        boolean z2 = z && (num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5));
        e.i("checkIsSupported:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public boolean checkShouldSkip(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult != null) {
            Integer num = (Integer) lastResult.get(CaptureResult.CONTROL_AE_STATE);
            boolean z = num != null && num.intValue() == 3;
            e.i("checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        e.i("checkShouldSkip: false - lastResult is null.");
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        e.i("processCapture:", "aeState:", num);
        if (num != null && num.intValue() == 3) {
            setState(Integer.MAX_VALUE);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public void onStarted(@NonNull ActionHolder actionHolder) {
        actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(Build.VERSION.SDK_INT >= 23 ? 2 : 0));
        actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        actionHolder.applyBuilder(this);
    }
}
