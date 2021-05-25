package com.otaliastudios.cameraview.engine.meter;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
@RequiresApi(21)
public class ExposureReset extends BaseReset {
    public static final CameraLogger f = CameraLogger.create(ExposureReset.class.getSimpleName());

    public ExposureReset() {
        super(true);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        if (getState() == 0) {
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            actionHolder.applyBuilder(this);
            setState(Integer.MAX_VALUE);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseReset
    public void onStarted(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        Integer num;
        int intValue = ((Integer) readCharacteristic(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue();
        if (meteringRectangle != null && intValue > 0) {
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        }
        TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult == null) {
            num = null;
        } else {
            num = (Integer) lastResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        }
        CameraLogger cameraLogger = f;
        int i = 2;
        cameraLogger.i("onStarted:", "last precapture trigger is", num);
        if (num != null && num.intValue() == 1) {
            cameraLogger.i("onStarted:", "canceling precapture.");
            if (Build.VERSION.SDK_INT < 23) {
                i = 0;
            }
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(i));
        }
        actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        actionHolder.applyBuilder(this);
        setState(0);
    }
}
