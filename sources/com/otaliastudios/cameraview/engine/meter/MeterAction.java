package com.otaliastudios.cameraview.engine.meter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.ActionWrapper;
import com.otaliastudios.cameraview.engine.action.Actions;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import com.otaliastudios.cameraview.engine.metering.Camera2MeteringTransform;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.metering.MeteringRegions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RequiresApi(21)
public class MeterAction extends ActionWrapper {
    public static final CameraLogger j = CameraLogger.create(MeterAction.class.getSimpleName());
    public List<BaseMeter> e;
    public BaseAction f;
    public final MeteringRegions g;
    public final CameraEngine h;
    public final boolean i;

    public MeterAction(@NonNull CameraEngine cameraEngine, @Nullable MeteringRegions meteringRegions, boolean z) {
        this.g = meteringRegions;
        this.h = cameraEngine;
        this.i = z;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    @NonNull
    public BaseAction getAction() {
        return this.f;
    }

    public boolean isSuccessful() {
        for (BaseMeter baseMeter : this.e) {
            if (!baseMeter.isSuccessful()) {
                j.i("isSuccessful:", "returning false.");
                return false;
            }
        }
        j.i("isSuccessful:", "returning true.");
        return true;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper, com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@NonNull ActionHolder actionHolder) {
        CameraLogger cameraLogger = j;
        cameraLogger.w("onStart:", "initializing.");
        List arrayList = new ArrayList();
        if (this.g != null) {
            Camera2MeteringTransform camera2MeteringTransform = new Camera2MeteringTransform(this.h.getAngles(), this.h.getPreview().getSurfaceSize(), this.h.getPreviewStreamSize(Reference.VIEW), this.h.getPreview().isCropping(), actionHolder.getCharacteristics(this), actionHolder.getBuilder(this));
            arrayList = this.g.transform(camera2MeteringTransform).get(Integer.MAX_VALUE, camera2MeteringTransform);
        }
        ExposureMeter exposureMeter = new ExposureMeter(arrayList, this.i);
        FocusMeter focusMeter = new FocusMeter(arrayList, this.i);
        WhiteBalanceMeter whiteBalanceMeter = new WhiteBalanceMeter(arrayList, this.i);
        this.e = Arrays.asList(exposureMeter, focusMeter, whiteBalanceMeter);
        this.f = Actions.together(exposureMeter, focusMeter, whiteBalanceMeter);
        cameraLogger.w("onStart:", "initialized.");
        super.onStart(actionHolder);
    }
}
