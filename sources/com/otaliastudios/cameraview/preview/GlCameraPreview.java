package com.otaliastudios.cameraview.preview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.R;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.filter.NoFilter;
import com.otaliastudios.cameraview.internal.GlTextureDrawer;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
public class GlCameraPreview extends CameraPreview<GLSurfaceView, SurfaceTexture> implements FilterCameraPreview, RendererCameraPreview {
    public boolean c;
    public SurfaceTexture d;
    public GlTextureDrawer e;
    public final Set<RendererFrameCallback> f = new CopyOnWriteArraySet();
    @VisibleForTesting
    public float g = 1.0f;
    @VisibleForTesting
    public float h = 1.0f;
    public View i;
    public Filter j;

    public class Renderer implements GLSurfaceView.Renderer {

        public class a implements Runnable {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (RendererFrameCallback rendererFrameCallback : GlCameraPreview.this.f) {
                    rendererFrameCallback.onRendererTextureCreated(this.a);
                }
            }
        }

        public class b implements SurfaceTexture.OnFrameAvailableListener {
            public b() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                ((GLSurfaceView) GlCameraPreview.this.getView()).requestRender();
            }
        }

        public Renderer() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        @RendererThread
        public void onDrawFrame(GL10 gl10) {
            GlCameraPreview glCameraPreview = GlCameraPreview.this;
            if (glCameraPreview.d != null && glCameraPreview.mInputStreamWidth > 0 && glCameraPreview.mInputStreamHeight > 0) {
                float[] textureTransform = glCameraPreview.e.getTextureTransform();
                GlCameraPreview.this.d.updateTexImage();
                GlCameraPreview.this.d.getTransformMatrix(textureTransform);
                if (GlCameraPreview.this.mDrawRotation != 0) {
                    Matrix.translateM(textureTransform, 0, 0.5f, 0.5f, 0.0f);
                    Matrix.rotateM(textureTransform, 0, (float) GlCameraPreview.this.mDrawRotation, 0.0f, 0.0f, 1.0f);
                    Matrix.translateM(textureTransform, 0, -0.5f, -0.5f, 0.0f);
                }
                if (GlCameraPreview.this.isCropping()) {
                    GlCameraPreview glCameraPreview2 = GlCameraPreview.this;
                    Matrix.translateM(textureTransform, 0, (1.0f - glCameraPreview2.g) / 2.0f, (1.0f - glCameraPreview2.h) / 2.0f, 0.0f);
                    GlCameraPreview glCameraPreview3 = GlCameraPreview.this;
                    Matrix.scaleM(textureTransform, 0, glCameraPreview3.g, glCameraPreview3.h, 1.0f);
                }
                GlCameraPreview glCameraPreview4 = GlCameraPreview.this;
                glCameraPreview4.e.draw(glCameraPreview4.d.getTimestamp() / 1000);
                for (RendererFrameCallback rendererFrameCallback : GlCameraPreview.this.f) {
                    GlCameraPreview glCameraPreview5 = GlCameraPreview.this;
                    rendererFrameCallback.onRendererFrame(glCameraPreview5.d, glCameraPreview5.mDrawRotation, glCameraPreview5.g, glCameraPreview5.h);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        @RendererThread
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            gl10.glViewport(0, 0, i, i2);
            GlCameraPreview.this.j.setSize(i, i2);
            GlCameraPreview glCameraPreview = GlCameraPreview.this;
            if (!glCameraPreview.c) {
                glCameraPreview.dispatchOnSurfaceAvailable(i, i2);
                GlCameraPreview.this.c = true;
            } else if (i != glCameraPreview.mOutputSurfaceWidth || i2 != glCameraPreview.mOutputSurfaceHeight) {
                glCameraPreview.dispatchOnSurfaceSizeChanged(i, i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        @RendererThread
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            GlCameraPreview glCameraPreview = GlCameraPreview.this;
            if (glCameraPreview.j == null) {
                glCameraPreview.j = new NoFilter();
            }
            GlCameraPreview.this.e = new GlTextureDrawer();
            GlCameraPreview glCameraPreview2 = GlCameraPreview.this;
            glCameraPreview2.e.setFilter(glCameraPreview2.j);
            int id = GlCameraPreview.this.e.getTexture().getId();
            GlCameraPreview.this.d = new SurfaceTexture(id);
            ((GLSurfaceView) GlCameraPreview.this.getView()).queueEvent(new a(id));
            GlCameraPreview.this.d.setOnFrameAvailableListener(new b());
        }

        @RendererThread
        public void onSurfaceDestroyed() {
            SurfaceTexture surfaceTexture = GlCameraPreview.this.d;
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(null);
                GlCameraPreview.this.d.release();
                GlCameraPreview.this.d = null;
            }
            GlTextureDrawer glTextureDrawer = GlCameraPreview.this.e;
            if (glTextureDrawer != null) {
                glTextureDrawer.release();
                GlCameraPreview.this.e = null;
            }
        }
    }

    public class a implements SurfaceHolder.Callback {
        public final /* synthetic */ GLSurfaceView a;
        public final /* synthetic */ Renderer b;

        /* renamed from: com.otaliastudios.cameraview.preview.GlCameraPreview$a$a  reason: collision with other inner class name */
        public class RunnableC0313a implements Runnable {
            public RunnableC0313a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.onSurfaceDestroyed();
            }
        }

        public a(GLSurfaceView gLSurfaceView, Renderer renderer) {
            this.a = gLSurfaceView;
            this.b = renderer;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            GlCameraPreview.this.dispatchOnSurfaceDestroyed();
            this.a.queueEvent(new RunnableC0313a());
            GlCameraPreview.this.c = false;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ RendererFrameCallback a;

        public b(RendererFrameCallback rendererFrameCallback) {
            this.a = rendererFrameCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            GlCameraPreview.this.f.add(this.a);
            GlTextureDrawer glTextureDrawer = GlCameraPreview.this.e;
            if (glTextureDrawer != null) {
                this.a.onRendererTextureCreated(glTextureDrawer.getTexture().getId());
            }
            this.a.onRendererFilterChanged(GlCameraPreview.this.j);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Filter a;

        public c(Filter filter) {
            this.a = filter;
        }

        @Override // java.lang.Runnable
        public void run() {
            GlTextureDrawer glTextureDrawer = GlCameraPreview.this.e;
            if (glTextureDrawer != null) {
                glTextureDrawer.setFilter(this.a);
            }
            for (RendererFrameCallback rendererFrameCallback : GlCameraPreview.this.f) {
                rendererFrameCallback.onRendererFilterChanged(this.a);
            }
        }
    }

    public GlCameraPreview(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // com.otaliastudios.cameraview.preview.RendererCameraPreview
    public void addRendererFrameCallback(@NonNull RendererFrameCallback rendererFrameCallback) {
        ((GLSurfaceView) getView()).queueEvent(new b(rendererFrameCallback));
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void crop(@Nullable CameraPreview.CropCallback cropCallback) {
        int i2;
        int i3;
        float f2;
        float f3;
        if (this.mInputStreamWidth > 0 && this.mInputStreamHeight > 0 && (i2 = this.mOutputSurfaceWidth) > 0 && (i3 = this.mOutputSurfaceHeight) > 0) {
            AspectRatio of = AspectRatio.of(i2, i3);
            AspectRatio of2 = AspectRatio.of(this.mInputStreamWidth, this.mInputStreamHeight);
            if (of.toFloat() >= of2.toFloat()) {
                f3 = of.toFloat() / of2.toFloat();
                f2 = 1.0f;
            } else {
                f2 = of2.toFloat() / of.toFloat();
                f3 = 1.0f;
            }
            this.mCropping = f2 > 1.02f || f3 > 1.02f;
            this.g = 1.0f / f2;
            this.h = 1.0f / f3;
            ((GLSurfaceView) getView()).requestRender();
        }
        if (cropCallback != null) {
            cropCallback.onCrop();
        }
    }

    @Override // com.otaliastudios.cameraview.preview.FilterCameraPreview
    @NonNull
    public Filter getCurrentFilter() {
        return this.j;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public Class<SurfaceTexture> getOutputClass() {
        return SurfaceTexture.class;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public View getRootView() {
        return this.i;
    }

    public int getTextureId() {
        GlTextureDrawer glTextureDrawer = this.e;
        if (glTextureDrawer != null) {
            return glTextureDrawer.getTexture().getId();
        }
        return -1;
    }

    @NonNull
    public Renderer instantiateRenderer() {
        return new Renderer();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void onDestroy() {
        super.onDestroy();
        this.f.clear();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void onPause() {
        super.onPause();
        ((GLSurfaceView) getView()).onPause();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void onResume() {
        super.onResume();
        ((GLSurfaceView) getView()).onResume();
    }

    @Override // com.otaliastudios.cameraview.preview.RendererCameraPreview
    public void removeRendererFrameCallback(@NonNull RendererFrameCallback rendererFrameCallback) {
        this.f.remove(rendererFrameCallback);
    }

    @Override // com.otaliastudios.cameraview.preview.FilterCameraPreview
    public void setFilter(@NonNull Filter filter) {
        this.j = filter;
        if (hasSurface()) {
            filter.setSize(this.mOutputSurfaceWidth, this.mOutputSurfaceHeight);
        }
        ((GLSurfaceView) getView()).queueEvent(new c(filter));
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public boolean supportsCropping() {
        return true;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public SurfaceTexture getOutput() {
        return this.d;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public GLSurfaceView onCreateView(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.cameraview_gl_view, viewGroup, false);
        GLSurfaceView gLSurfaceView = (GLSurfaceView) viewGroup2.findViewById(R.id.gl_surface_view);
        Renderer instantiateRenderer = instantiateRenderer();
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(instantiateRenderer);
        gLSurfaceView.setRenderMode(0);
        gLSurfaceView.getHolder().addCallback(new a(gLSurfaceView, instantiateRenderer));
        viewGroup.addView(viewGroup2, 0);
        this.i = viewGroup2;
        return gLSurfaceView;
    }
}
