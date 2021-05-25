package com.otaliastudios.cameraview.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.overlay.OverlayDrawer;
import com.otaliastudios.cameraview.preview.RendererCameraPreview;
import com.otaliastudios.cameraview.preview.RendererFrameCallback;
import com.otaliastudios.cameraview.preview.RendererThread;
import com.otaliastudios.cameraview.video.encoding.EncoderThread;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
@RequiresApi(api = 18)
public class SnapshotVideoRecorder extends VideoRecorder implements RendererFrameCallback, MediaEncoderEngine.Listener {
    public static final CameraLogger p = CameraLogger.create(SnapshotVideoRecorder.class.getSimpleName());
    public MediaEncoderEngine f;
    public final Object g = new Object();
    public RendererCameraPreview h;
    public int i;
    public int j;
    public int k;
    public Overlay l;
    public OverlayDrawer m;
    public boolean n;
    public Filter o;

    public SnapshotVideoRecorder(@NonNull CameraEngine cameraEngine, @NonNull RendererCameraPreview rendererCameraPreview, @Nullable Overlay overlay) {
        super(cameraEngine);
        boolean z = true;
        this.i = 1;
        this.j = 1;
        this.k = 0;
        this.h = rendererCameraPreview;
        this.l = overlay;
        this.n = (overlay == null || !overlay.drawsOn(Overlay.Target.VIDEO_SNAPSHOT)) ? false : z;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener
    @EncoderThread
    public void onEncodingEnd(int i2, @Nullable Exception exc) {
        if (exc != null) {
            p.e("Error onEncodingEnd", exc);
            this.a = null;
            this.mError = exc;
        } else if (i2 == 1) {
            p.i("onEncodingEnd because of max duration.");
            this.a.endReason = 2;
        } else if (i2 == 2) {
            p.i("onEncodingEnd because of max size.");
            this.a.endReason = 1;
        } else {
            p.i("onEncodingEnd because of user.");
        }
        this.i = 1;
        this.j = 1;
        this.h.removeRendererFrameCallback(this);
        this.h = null;
        OverlayDrawer overlayDrawer = this.m;
        if (overlayDrawer != null) {
            overlayDrawer.release();
            this.m = null;
        }
        synchronized (this.g) {
            this.f = null;
        }
        dispatchResult();
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener
    public void onEncodingStart() {
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener
    public void onEncodingStop() {
        dispatchVideoRecordingEnd();
    }

    @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
    @RendererThread
    public void onRendererFilterChanged(@NonNull Filter filter) {
        Filter copy = filter.copy();
        this.o = copy;
        copy.setSize(this.a.size.getWidth(), this.a.size.getHeight());
        synchronized (this.g) {
            MediaEncoderEngine mediaEncoderEngine = this.f;
            if (mediaEncoderEngine != null) {
                mediaEncoderEngine.notify("filter", this.o);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:92:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0250 A[SYNTHETIC] */
    @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
    @com.otaliastudios.cameraview.preview.RendererThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRendererFrame(@androidx.annotation.NonNull android.graphics.SurfaceTexture r25, int r26, float r27, float r28) {
        /*
        // Method dump skipped, instructions count: 745
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.video.SnapshotVideoRecorder.onRendererFrame(android.graphics.SurfaceTexture, int, float, float):void");
    }

    @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
    @RendererThread
    public void onRendererTextureCreated(int i2) {
        this.k = i2;
        if (this.n) {
            this.m = new OverlayDrawer(this.l, this.a.size);
        }
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void onStart() {
        this.h.addRendererFrameCallback(this);
        this.j = 0;
        dispatchVideoRecordingStart();
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void onStop(boolean z) {
        if (z) {
            p.i("Stopping the encoder engine from isCameraShutdown.");
            this.j = 1;
            this.i = 1;
            synchronized (this.g) {
                MediaEncoderEngine mediaEncoderEngine = this.f;
                if (mediaEncoderEngine != null) {
                    mediaEncoderEngine.stop();
                    this.f = null;
                }
            }
            return;
        }
        this.j = 1;
    }
}
