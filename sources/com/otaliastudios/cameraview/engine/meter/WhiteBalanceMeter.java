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
public class WhiteBalanceMeter extends BaseMeter {
    public static final CameraLogger i = CameraLogger.create(WhiteBalanceMeter.class.getSimpleName());

    public WhiteBalanceMeter(@NonNull List<MeteringRectangle> list, boolean z) {
        super(list, z);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkIsSupported(@NonNull ActionHolder actionHolder) {
        boolean z = ((Integer) readCharacteristic(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) actionHolder.getBuilder(this).get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z2 = z && num != null && num.intValue() == 1;
        i.i("checkIsSupported:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkShouldSkip(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult != null) {
            Integer num = (Integer) lastResult.get(CaptureResult.CONTROL_AWB_STATE);
            boolean z = num != null && num.intValue() == 2;
            i.i("checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        i.i("checkShouldSkip: false - lastResult is null.");
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        i.i("onCaptureCompleted:", "awbState:", num);
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 2) {
                setSuccessful(true);
                setState(Integer.MAX_VALUE);
            } else if (intValue == 3) {
                setSuccessful(false);
                setState(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public void onStarted(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) {
        i.i("onStarted:", "with areas:", list);
        int intValue = ((Integer) readCharacteristic(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (!list.isEmpty() && intValue > 0) {
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AWB_REGIONS, list.subList(0, Math.min(intValue, list.size())).toArray(new MeteringRectangle[0]));
            actionHolder.applyBuilder(this);
        }
    }
}
