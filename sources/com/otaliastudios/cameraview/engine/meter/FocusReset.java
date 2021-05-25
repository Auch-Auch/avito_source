package com.otaliastudios.cameraview.engine.meter;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
@RequiresApi(21)
public class FocusReset extends BaseReset {
    public static final CameraLogger f = CameraLogger.create(FocusReset.class.getSimpleName());

    public FocusReset() {
        super(true);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseReset
    public void onStarted(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        boolean z;
        Integer num;
        int intValue = ((Integer) readCharacteristic(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        boolean z2 = true;
        if (meteringRectangle == null || intValue <= 0) {
            z = false;
        } else {
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{meteringRectangle});
            z = true;
        }
        TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult == null) {
            num = null;
        } else {
            num = (Integer) lastResult.get(CaptureResult.CONTROL_AF_TRIGGER);
        }
        f.w("onStarted:", "last focus trigger is", num);
        if (num == null || num.intValue() != 1) {
            z2 = z;
        } else {
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        }
        if (z2) {
            actionHolder.applyBuilder(this);
        }
        setState(Integer.MAX_VALUE);
    }
}
