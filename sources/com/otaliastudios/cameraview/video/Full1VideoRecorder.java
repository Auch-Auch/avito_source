package com.otaliastudios.cameraview.video;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.engine.Camera1Engine;
import com.otaliastudios.cameraview.internal.CamcorderProfiles;
import com.otaliastudios.cameraview.size.Size;
public class Full1VideoRecorder extends FullVideoRecorder {
    public final Camera1Engine h;
    public final Camera i;
    public final int j;

    public Full1VideoRecorder(@NonNull Camera1Engine camera1Engine, @NonNull Camera camera, int i2) {
        super(camera1Engine);
        this.i = camera;
        this.h = camera1Engine;
        this.j = i2;
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    public void applyVideoSource(@NonNull VideoResult.Stub stub, @NonNull MediaRecorder mediaRecorder) {
        mediaRecorder.setCamera(this.i);
        mediaRecorder.setVideoSource(1);
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    @NonNull
    public CamcorderProfile getCamcorderProfile(@NonNull VideoResult.Stub stub) {
        int i2 = stub.rotation % 180;
        Size size = stub.size;
        if (i2 != 0) {
            size = size.flip();
        }
        return CamcorderProfiles.get(this.j, size);
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void onDispatchResult() {
        this.i.setPreviewCallbackWithBuffer(this.h);
        super.onDispatchResult();
    }
}
