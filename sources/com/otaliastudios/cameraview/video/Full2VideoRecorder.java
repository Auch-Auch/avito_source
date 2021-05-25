package com.otaliastudios.cameraview.video;

import android.hardware.camera2.CaptureRequest;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.engine.Camera2Engine;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import com.otaliastudios.cameraview.engine.action.CompletionCallback;
import com.otaliastudios.cameraview.internal.CamcorderProfiles;
import com.otaliastudios.cameraview.size.Size;
@RequiresApi(21)
public class Full2VideoRecorder extends FullVideoRecorder {
    public ActionHolder h;
    public final String i;
    public Surface j;

    public class PrepareException extends Exception {
        public PrepareException(Full2VideoRecorder full2VideoRecorder, Throwable th, a aVar) {
            super(th);
        }
    }

    public class a extends BaseAction {
        public a(Full2VideoRecorder full2VideoRecorder) {
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public void onCaptureStarted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
            super.onCaptureStarted(actionHolder, captureRequest);
            Object tag = actionHolder.getBuilder(this).build().getTag();
            Object tag2 = captureRequest.getTag();
            if (tag == null) {
                if (tag2 != null) {
                    return;
                }
            } else if (!tag.equals(tag2)) {
                return;
            }
            setState(Integer.MAX_VALUE);
        }
    }

    public class b extends CompletionCallback {
        public b() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
        public void onActionCompleted(@NonNull Action action) {
            Full2VideoRecorder.super.onStart();
        }
    }

    public Full2VideoRecorder(@NonNull Camera2Engine camera2Engine, @NonNull String str) {
        super(camera2Engine);
        this.h = camera2Engine;
        this.i = str;
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    public void applyVideoSource(@NonNull VideoResult.Stub stub, @NonNull MediaRecorder mediaRecorder) {
        mediaRecorder.setVideoSource(2);
    }

    @NonNull
    public Surface createInputSurface(@NonNull VideoResult.Stub stub) throws PrepareException {
        if (prepareMediaRecorder(stub)) {
            Surface surface = this.mMediaRecorder.getSurface();
            this.j = surface;
            return surface;
        }
        throw new PrepareException(this, this.mError, null);
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    @NonNull
    public CamcorderProfile getCamcorderProfile(@NonNull VideoResult.Stub stub) {
        int i2 = stub.rotation % 180;
        Size size = stub.size;
        if (i2 != 0) {
            size = size.flip();
        }
        return CamcorderProfiles.get(this.i, size);
    }

    @Nullable
    public Surface getInputSurface() {
        return this.j;
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder, com.otaliastudios.cameraview.video.VideoRecorder
    public void onStart() {
        a aVar = new a(this);
        aVar.addCallback(new b());
        aVar.start(this.h);
    }
}
