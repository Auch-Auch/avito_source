package com.otaliastudios.cameraview.engine.lock;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
@RequiresApi(21)
public class FocusLock extends BaseLock {
    public static final CameraLogger e = CameraLogger.create(FocusLock.class.getSimpleName());

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public boolean checkIsSupported(@NonNull ActionHolder actionHolder) {
        for (int i : (int[]) readCharacteristic(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0])) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public boolean checkShouldSkip(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult != null) {
            Integer num = (Integer) lastResult.get(CaptureResult.CONTROL_AF_STATE);
            boolean z = num != null && (num.intValue() == 4 || num.intValue() == 5 || num.intValue() == 0 || num.intValue() == 2 || num.intValue() == 6);
            Integer num2 = (Integer) lastResult.get(CaptureResult.CONTROL_AF_MODE);
            boolean z2 = z && (num2 != null && num2.intValue() == 1);
            e.i("checkShouldSkip:", Boolean.valueOf(z2));
            return z2;
        }
        e.i("checkShouldSkip: false - lastResult is null.");
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        e.i("onCapture:", "afState:", num, "afMode:", num2);
        if (num != null && num2 != null && num2.intValue() == 1) {
            int intValue = num.intValue();
            if (intValue == 0 || intValue == 2 || intValue == 4 || intValue == 5 || intValue == 6) {
                setState(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    public void onStarted(@NonNull ActionHolder actionHolder) {
        actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AF_MODE, 1);
        actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        actionHolder.applyBuilder(this);
    }
}
