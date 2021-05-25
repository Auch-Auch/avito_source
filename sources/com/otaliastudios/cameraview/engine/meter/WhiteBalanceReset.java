package com.otaliastudios.cameraview.engine.meter;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
@RequiresApi(21)
public class WhiteBalanceReset extends BaseReset {
    public static final CameraLogger f = CameraLogger.create(WhiteBalanceReset.class.getSimpleName());

    public WhiteBalanceReset() {
        super(true);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseReset
    public void onStarted(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        f.w("onStarted:", "with area:", meteringRectangle);
        int intValue = ((Integer) readCharacteristic(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (meteringRectangle != null && intValue > 0) {
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{meteringRectangle});
            actionHolder.applyBuilder(this);
        }
        setState(Integer.MAX_VALUE);
    }
}
