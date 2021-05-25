package com.otaliastudios.cameraview.engine.meter;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;
@RequiresApi(21)
public abstract class BaseReset extends BaseAction {
    public boolean e;

    public BaseReset(boolean z) {
        this.e = z;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void onStart(@NonNull ActionHolder actionHolder) {
        super.onStart(actionHolder);
        onStarted(actionHolder, this.e ? new MeteringRectangle((Rect) readCharacteristic(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect()), 0) : null);
    }

    public abstract void onStarted(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle);
}
