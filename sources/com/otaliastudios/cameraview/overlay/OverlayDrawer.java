package com.otaliastudios.cameraview.overlay;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.internal.GlTextureDrawer;
import com.otaliastudios.cameraview.internal.Issue514Workaround;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.size.Size;
public class OverlayDrawer {
    public static final CameraLogger g = CameraLogger.create(OverlayDrawer.class.getSimpleName());
    public Overlay a;
    public SurfaceTexture b;
    public Surface c;
    @VisibleForTesting
    public GlTextureDrawer d;
    public Issue514Workaround e;
    public final Object f = new Object();

    public OverlayDrawer(@NonNull Overlay overlay, @NonNull Size size) {
        this.a = overlay;
        this.d = new GlTextureDrawer();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.d.getTexture().getId());
        this.b = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(size.getWidth(), size.getHeight());
        this.c = new Surface(this.b);
        this.e = new Issue514Workaround(this.d.getTexture().getId());
    }

    public void draw(@NonNull Overlay.Target target) {
        try {
            Canvas lockCanvas = this.c.lockCanvas(null);
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.a.drawOn(target, lockCanvas);
            this.c.unlockCanvasAndPost(lockCanvas);
        } catch (Surface.OutOfResourcesException e2) {
            g.w("Got Surface.OutOfResourcesException while drawing video overlays", e2);
        }
        synchronized (this.f) {
            this.e.beforeOverlayUpdateTexImage();
            this.b.updateTexImage();
        }
        this.b.getTransformMatrix(this.d.getTextureTransform());
    }

    public float[] getTransform() {
        return this.d.getTextureTransform();
    }

    public void release() {
        Issue514Workaround issue514Workaround = this.e;
        if (issue514Workaround != null) {
            issue514Workaround.end();
            this.e = null;
        }
        SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.b = null;
        }
        Surface surface = this.c;
        if (surface != null) {
            surface.release();
            this.c = null;
        }
        GlTextureDrawer glTextureDrawer = this.d;
        if (glTextureDrawer != null) {
            glTextureDrawer.release();
            this.d = null;
        }
    }

    public void render(long j) {
        GLES20.glDisable(2884);
        GLES20.glDisable(2929);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        synchronized (this.f) {
            this.d.draw(j);
        }
    }
}
