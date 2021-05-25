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
public class FocusMeter extends BaseMeter {
    public static final CameraLogger i = CameraLogger.create(FocusMeter.class.getSimpleName());

    public FocusMeter(@NonNull List<MeteringRectangle> list, boolean z) {
        super(list, z);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkIsSupported(@NonNull ActionHolder actionHolder) {
        Integer num = (Integer) actionHolder.getBuilder(this).get(CaptureRequest.CONTROL_AF_MODE);
        boolean z = num != null && (num.intValue() == 1 || num.intValue() == 4 || num.intValue() == 3 || num.intValue() == 2);
        i.i("checkIsSupported:", Boolean.valueOf(z));
        return z;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkShouldSkip(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult != null) {
            Integer num = (Integer) lastResult.get(CaptureResult.CONTROL_AF_STATE);
            boolean z = num != null && (num.intValue() == 4 || num.intValue() == 2);
            i.i("checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        i.i("checkShouldSkip: false - lastResult is null.");
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        i.i("onCaptureCompleted:", "afState:", num);
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 4) {
                setSuccessful(true);
                setState(Integer.MAX_VALUE);
            } else if (intValue == 5) {
                setSuccessful(false);
                setState(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onCompleted(@NonNull ActionHolder actionHolder) {
        super.onCompleted(actionHolder);
        actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AF_TRIGGER, null);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public void onStarted(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) {
        i.i("onStarted:", "with areas:", list);
        actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        int intValue = ((Integer) readCharacteristic(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        if (!list.isEmpty() && intValue > 0) {
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AF_REGIONS, list.subList(0, Math.min(intValue, list.size())).toArray(new MeteringRectangle[0]));
        }
        actionHolder.applyBuilder(this);
    }
}
