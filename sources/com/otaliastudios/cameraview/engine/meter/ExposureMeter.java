package com.otaliastudios.cameraview.engine.meter;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import java.util.List;
@RequiresApi(21)
public class ExposureMeter extends BaseMeter {
    public static final CameraLogger k = CameraLogger.create(ExposureMeter.class.getSimpleName());
    public boolean i = false;
    public boolean j = false;

    public ExposureMeter(@NonNull List<MeteringRectangle> list, boolean z) {
        super(list, z);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkIsSupported(@NonNull ActionHolder actionHolder) {
        boolean z = ((Integer) readCharacteristic(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2;
        Integer num = (Integer) actionHolder.getBuilder(this).get(CaptureRequest.CONTROL_AE_MODE);
        boolean z2 = num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5);
        this.j = !z;
        boolean z3 = ((Integer) readCharacteristic(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue() > 0;
        this.i = z3;
        boolean z4 = z2 && (this.j || z3);
        k.i("checkIsSupported:", Boolean.valueOf(z4), "trigger:", Boolean.valueOf(this.j), "areas:", Boolean.valueOf(this.i));
        return z4;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkShouldSkip(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult != null) {
            Integer num = (Integer) lastResult.get(CaptureResult.CONTROL_AE_STATE);
            boolean z = num != null && num.intValue() == 2;
            k.i("checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        k.i("checkShouldSkip: false - lastResult is null.");
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        k.i("onCaptureCompleted:", "aeState:", num, "aeTriggerState:", num2);
        if (num != null) {
            if (getState() == 0) {
                int intValue = num.intValue();
                if (intValue != 2) {
                    if (intValue == 3) {
                        setSuccessful(false);
                        setState(Integer.MAX_VALUE);
                    } else if (intValue != 4) {
                        if (intValue == 5) {
                            setState(1);
                        }
                    }
                }
                if (num2 != null && num2.intValue() == 1) {
                    setSuccessful(true);
                    setState(Integer.MAX_VALUE);
                }
            }
            if (getState() == 1) {
                int intValue2 = num.intValue();
                if (intValue2 != 2) {
                    if (intValue2 == 3) {
                        setSuccessful(false);
                        setState(Integer.MAX_VALUE);
                        return;
                    } else if (intValue2 != 4) {
                        return;
                    }
                }
                setSuccessful(true);
                setState(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onCompleted(@NonNull ActionHolder actionHolder) {
        super.onCompleted(actionHolder);
        actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, null);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public void onStarted(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) {
        k.i("onStarted:", "with areas:", list);
        if (this.i && !list.isEmpty()) {
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AE_REGIONS, list.subList(0, Math.min(((Integer) readCharacteristic(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue(), list.size())).toArray(new MeteringRectangle[0]));
        }
        if (this.j) {
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        }
        actionHolder.applyBuilder(this);
        if (this.j) {
            setState(0);
        } else {
            setState(1);
        }
    }
}
