package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
@RequiresApi(21)
public abstract class BaseAction implements Action {
    public final List<ActionCallback> a = new ArrayList();
    public int b;
    public ActionHolder c;
    public boolean d;

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public final void abort(@NonNull ActionHolder actionHolder) {
        actionHolder.removeAction(this);
        if (!isCompleted()) {
            onAbort(actionHolder);
            setState(Integer.MAX_VALUE);
        }
        this.d = false;
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void addCallback(@NonNull ActionCallback actionCallback) {
        if (!this.a.contains(actionCallback)) {
            this.a.add(actionCallback);
            actionCallback.onActionStateChanged(this, getState());
        }
    }

    @NonNull
    public ActionHolder getHolder() {
        return this.c;
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public final int getState() {
        return this.b;
    }

    public boolean isCompleted() {
        return this.b == Integer.MAX_VALUE;
    }

    public void onAbort(@NonNull ActionHolder actionHolder) {
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureProgressed(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    @CallSuper
    public void onCaptureStarted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        if (this.d) {
            onStart(actionHolder);
            this.d = false;
        }
    }

    public void onCompleted(@NonNull ActionHolder actionHolder) {
    }

    @CallSuper
    public void onStart(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
    }

    @NonNull
    public <T> T readCharacteristic(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) this.c.getCharacteristics(this).get(key);
        return t2 == null ? t : t2;
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void removeCallback(@NonNull ActionCallback actionCallback) {
        this.a.remove(actionCallback);
    }

    public final void setState(int i) {
        if (i != this.b) {
            this.b = i;
            for (ActionCallback actionCallback : this.a) {
                actionCallback.onActionStateChanged(this, this.b);
            }
            if (this.b == Integer.MAX_VALUE) {
                this.c.removeAction(this);
                onCompleted(this.c);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public final void start(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
        actionHolder.addAction(this);
        if (actionHolder.getLastResult(this) != null) {
            onStart(actionHolder);
        } else {
            this.d = true;
        }
    }
}
