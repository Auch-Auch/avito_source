package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
public abstract class ActionWrapper extends BaseAction {

    public class a implements ActionCallback {
        public a() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
        public void onActionStateChanged(@NonNull Action action, int i) {
            ActionWrapper.this.setState(i);
            if (i == Integer.MAX_VALUE) {
                action.removeCallback(this);
            }
        }
    }

    @NonNull
    public abstract BaseAction getAction();

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onAbort(@NonNull ActionHolder actionHolder) {
        super.onAbort(actionHolder);
        getAction().onAbort(actionHolder);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        getAction().onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureProgressed(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        super.onCaptureProgressed(actionHolder, captureRequest, captureResult);
        getAction().onCaptureProgressed(actionHolder, captureRequest, captureResult);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureStarted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        super.onCaptureStarted(actionHolder, captureRequest);
        getAction().onCaptureStarted(actionHolder, captureRequest);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@NonNull ActionHolder actionHolder) {
        super.onStart(actionHolder);
        getAction().addCallback(new a());
        getAction().onStart(actionHolder);
    }
}
