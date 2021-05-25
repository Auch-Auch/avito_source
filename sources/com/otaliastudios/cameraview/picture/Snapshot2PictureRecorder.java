package com.otaliastudios.cameraview.picture;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.engine.Camera2Engine;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.Actions;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import com.otaliastudios.cameraview.engine.action.CompletionCallback;
import com.otaliastudios.cameraview.engine.lock.LockAction;
import com.otaliastudios.cameraview.preview.RendererCameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
@RequiresApi(21)
public class Snapshot2PictureRecorder extends SnapshotGlPictureRecorder {
    public final Action i;
    public final ActionHolder j;
    public final boolean k;
    public Integer l;
    public Integer m;

    public class a extends CompletionCallback {
        public a() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
        public void onActionCompleted(@NonNull Action action) {
            SnapshotPictureRecorder.LOG.i("Taking picture with super.take().");
            Snapshot2PictureRecorder.super.take();
        }
    }

    public class b extends BaseAction {
        public b(Snapshot2PictureRecorder snapshot2PictureRecorder, a aVar) {
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
            if (num == null) {
                SnapshotPictureRecorder.LOG.w("FlashAction:", "Waiting flash, but flashState is null!", "Taking snapshot.");
                setState(Integer.MAX_VALUE);
            } else if (num.intValue() == 3) {
                SnapshotPictureRecorder.LOG.i("FlashAction:", "Waiting flash and we have FIRED state!", "Taking snapshot.");
                setState(Integer.MAX_VALUE);
            } else {
                SnapshotPictureRecorder.LOG.i("FlashAction:", "Waiting flash but flashState is", num, ". Waiting...");
            }
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction
        public void onStart(@NonNull ActionHolder actionHolder) {
            super.onStart(actionHolder);
            SnapshotPictureRecorder.LOG.i("FlashAction:", "Parameters locked, opening torch.");
            actionHolder.getBuilder(this).set(CaptureRequest.FLASH_MODE, 2);
            actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AE_MODE, 1);
            actionHolder.applyBuilder(this);
        }
    }

    public class c extends BaseAction {
        public c(a aVar) {
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction
        public void onStart(@NonNull ActionHolder actionHolder) {
            super.onStart(actionHolder);
            try {
                SnapshotPictureRecorder.LOG.i("ResetFlashAction:", "Reverting the flash changes.");
                CaptureRequest.Builder builder = actionHolder.getBuilder(this);
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                builder.set(CaptureRequest.FLASH_MODE, 0);
                actionHolder.applyBuilder(this, builder);
                builder.set(CaptureRequest.CONTROL_AE_MODE, Snapshot2PictureRecorder.this.l);
                builder.set(CaptureRequest.FLASH_MODE, Snapshot2PictureRecorder.this.m);
                actionHolder.applyBuilder(this);
            } catch (CameraAccessException unused) {
            }
        }
    }

    public Snapshot2PictureRecorder(@NonNull PictureResult.Stub stub, @NonNull Camera2Engine camera2Engine, @NonNull RendererCameraPreview rendererCameraPreview, @NonNull AspectRatio aspectRatio) {
        super(stub, camera2Engine, rendererCameraPreview, aspectRatio, camera2Engine.getOverlay());
        this.j = camera2Engine;
        boolean z = false;
        Integer num = null;
        BaseAction sequence = Actions.sequence(Actions.timeout(2500, new LockAction()), new b(this, null));
        this.i = sequence;
        sequence.addCallback(new a());
        TotalCaptureResult lastResult = camera2Engine.getLastResult(sequence);
        if (lastResult == null) {
            SnapshotPictureRecorder.LOG.w("Picture snapshot requested very early, before the first preview frame.", "Metering might not work as intended.");
        }
        num = lastResult != null ? (Integer) lastResult.get(CaptureResult.CONTROL_AE_STATE) : num;
        if (camera2Engine.getPictureSnapshotMetering() && num != null && num.intValue() == 4) {
            z = true;
        }
        this.k = z;
        this.l = (Integer) camera2Engine.getBuilder(sequence).get(CaptureRequest.CONTROL_AE_MODE);
        this.m = (Integer) camera2Engine.getBuilder(sequence).get(CaptureRequest.FLASH_MODE);
    }

    @Override // com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder, com.otaliastudios.cameraview.picture.PictureRecorder
    public void dispatchResult() {
        new c(null).start(this.j);
        super.dispatchResult();
    }

    @Override // com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder, com.otaliastudios.cameraview.picture.PictureRecorder
    public void take() {
        if (!this.k) {
            SnapshotPictureRecorder.LOG.i("take:", "Engine does no metering or needs no flash.", "Taking fast snapshot.");
            super.take();
            return;
        }
        SnapshotPictureRecorder.LOG.i("take:", "Engine needs flash. Starting action");
        this.i.start(this.j);
    }
}
