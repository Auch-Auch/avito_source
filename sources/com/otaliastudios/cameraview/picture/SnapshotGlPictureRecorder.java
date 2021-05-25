package com.otaliastudios.cameraview.picture;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.avito.android.search.map.reducer.MapReducerKt;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.internal.CropHelper;
import com.otaliastudios.cameraview.internal.GlTextureDrawer;
import com.otaliastudios.cameraview.internal.WorkerHandler;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.overlay.OverlayDrawer;
import com.otaliastudios.cameraview.picture.PictureRecorder;
import com.otaliastudios.cameraview.preview.RendererCameraPreview;
import com.otaliastudios.cameraview.preview.RendererFrameCallback;
import com.otaliastudios.cameraview.preview.RendererThread;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.opengl.core.EglCore;
import com.otaliastudios.opengl.surface.EglWindowSurface;
public class SnapshotGlPictureRecorder extends SnapshotPictureRecorder {
    public RendererCameraPreview c;
    public AspectRatio d;
    public Overlay e;
    public boolean f;
    public OverlayDrawer g;
    public GlTextureDrawer h;

    public class a implements RendererFrameCallback {
        public a() {
        }

        @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
        @RendererThread
        public void onRendererFilterChanged(@NonNull Filter filter) {
            SnapshotGlPictureRecorder.this.onRendererFilterChanged(filter);
        }

        @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
        @RendererThread
        public void onRendererFrame(@NonNull SurfaceTexture surfaceTexture, int i, float f, float f2) {
            SnapshotGlPictureRecorder.this.c.removeRendererFrameCallback(this);
            SnapshotGlPictureRecorder.this.onRendererFrame(surfaceTexture, i, f, f2);
        }

        @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
        @RendererThread
        public void onRendererTextureCreated(int i) {
            SnapshotGlPictureRecorder.this.onRendererTextureCreated(i);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ SurfaceTexture a;
        public final /* synthetic */ int b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ EGLContext e;

        public b(SurfaceTexture surfaceTexture, int i, float f2, float f3, EGLContext eGLContext) {
            this.a = surfaceTexture;
            this.b = i;
            this.c = f2;
            this.d = f3;
            this.e = eGLContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            SnapshotGlPictureRecorder.this.takeFrame(this.a, this.b, this.c, this.d, this.e);
        }
    }

    public SnapshotGlPictureRecorder(@NonNull PictureResult.Stub stub, @Nullable PictureRecorder.PictureResultListener pictureResultListener, @NonNull RendererCameraPreview rendererCameraPreview, @NonNull AspectRatio aspectRatio, @Nullable Overlay overlay) {
        super(stub, pictureResultListener);
        this.c = rendererCameraPreview;
        this.d = aspectRatio;
        this.e = overlay;
        this.f = overlay != null && overlay.drawsOn(Overlay.Target.PICTURE_SNAPSHOT);
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void dispatchResult() {
        this.d = null;
        super.dispatchResult();
    }

    @TargetApi(19)
    @RendererThread
    public void onRendererFilterChanged(@NonNull Filter filter) {
        this.h.setFilter(filter.copy());
    }

    @TargetApi(19)
    @RendererThread
    public void onRendererFrame(@NonNull SurfaceTexture surfaceTexture, int i, float f2, float f3) {
        WorkerHandler.execute(new b(surfaceTexture, i, f2, f3, EGL14.eglGetCurrentContext()));
    }

    @TargetApi(19)
    @RendererThread
    public void onRendererTextureCreated(int i) {
        this.h = new GlTextureDrawer(i);
        Rect computeCrop = CropHelper.computeCrop(this.a.size, this.d);
        this.a.size = new Size(computeCrop.width(), computeCrop.height());
        if (this.f) {
            this.g = new OverlayDrawer(this.e, this.a.size);
        }
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    @TargetApi(19)
    public void take() {
        this.c.addRendererFrameCallback(new a());
    }

    @TargetApi(19)
    @WorkerThread
    public void takeFrame(@NonNull SurfaceTexture surfaceTexture, int i, float f2, float f3, @NonNull EGLContext eGLContext) {
        SurfaceTexture surfaceTexture2 = new SurfaceTexture((int) MapReducerKt.MAX_PIN_COUNT);
        surfaceTexture2.setDefaultBufferSize(this.a.size.getWidth(), this.a.size.getHeight());
        EglCore eglCore = new EglCore(eGLContext, 1);
        EglWindowSurface eglWindowSurface = new EglWindowSurface(eglCore, surfaceTexture2);
        eglWindowSurface.makeCurrent();
        float[] textureTransform = this.h.getTextureTransform();
        surfaceTexture.getTransformMatrix(textureTransform);
        Matrix.translateM(textureTransform, 0, (1.0f - f2) / 2.0f, (1.0f - f3) / 2.0f, 0.0f);
        Matrix.scaleM(textureTransform, 0, f2, f3, 1.0f);
        Matrix.translateM(textureTransform, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(textureTransform, 0, (float) (i + this.a.rotation), 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(textureTransform, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(textureTransform, 0, -0.5f, -0.5f, 0.0f);
        if (this.f) {
            this.g.draw(Overlay.Target.PICTURE_SNAPSHOT);
            Matrix.translateM(this.g.getTransform(), 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(this.g.getTransform(), 0, (float) this.a.rotation, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(this.g.getTransform(), 0, 1.0f, -1.0f, 1.0f);
            Matrix.translateM(this.g.getTransform(), 0, -0.5f, -0.5f, 0.0f);
        }
        this.a.rotation = 0;
        long timestamp = surfaceTexture.getTimestamp() / 1000;
        SnapshotPictureRecorder.LOG.i("takeFrame:", "timestampUs:", Long.valueOf(timestamp));
        this.h.draw(timestamp);
        if (this.f) {
            this.g.render(timestamp);
        }
        this.a.data = eglWindowSurface.toByteArray(Bitmap.CompressFormat.JPEG);
        eglWindowSurface.release();
        this.h.release();
        surfaceTexture2.release();
        if (this.f) {
            this.g.release();
        }
        eglCore.release$egloo_metadata_release();
        dispatchResult();
    }
}
