package com.otaliastudios.cameraview.engine.meter;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import java.util.List;
@RequiresApi(21)
public abstract class BaseMeter extends BaseAction {
    public static final CameraLogger h = CameraLogger.create(BaseMeter.class.getSimpleName());
    public final List<MeteringRectangle> e;
    public boolean f;
    public boolean g;

    public BaseMeter(@NonNull List<MeteringRectangle> list, boolean z) {
        this.e = list;
        this.g = z;
    }

    public abstract boolean checkIsSupported(@NonNull ActionHolder actionHolder);

    public abstract boolean checkShouldSkip(@NonNull ActionHolder actionHolder);

    public boolean isSuccessful() {
        return this.f;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void onStart(@NonNull ActionHolder actionHolder) {
        super.onStart(actionHolder);
        boolean z = this.g && checkShouldSkip(actionHolder);
        if (!checkIsSupported(actionHolder) || z) {
            h.i("onStart:", "not supported or skipped. Dispatching COMPLETED state.");
            setSuccessful(true);
            setState(Integer.MAX_VALUE);
            return;
        }
        h.i("onStart:", "supported and not skipped. Dispatching onStarted.");
        onStarted(actionHolder, this.e);
    }

    public abstract void onStarted(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list);

    public void setSuccessful(boolean z) {
        this.f = z;
    }
}
