package com.yandex.runtime.view.internal;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.TextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private EGLConfigChooserImpl configChooser;
    private GLContextFactory glContextFactory;
    private boolean initialized = false;
    private RenderThread renderThread;
    private GLSurfaceView.Renderer renderer;

    public class RenderThread extends Thread {
        private EGL10 egl;
        private EGLConfig eglConfig;
        private EGLContext eglContext;
        private EGLDisplay eglDisplay;
        private EGLSurface eglSurface;
        private GL10 gl;
        private Rect newViewport = null;
        private boolean paused = false;
        private boolean requested = false;
        private boolean stopped = false;
        private SurfaceTexture surface;

        public RenderThread(SurfaceTexture surfaceTexture) {
            this.surface = surfaceTexture;
        }

        private void checkEglError(String str) {
            int eglGetError = this.egl.eglGetError();
            if (eglGetError != 12288) {
                throw new RuntimeException(str + "; Got EGL error " + eglGetError);
            }
        }

        private void finishGL() {
            EGL10 egl10 = this.egl;
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            checkEglError("eglMakeCurrent() failed");
            GLTextureView.this.glContextFactory.destroyContext(this.egl, this.eglDisplay, this.eglContext);
            this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
            checkEglError("eglDestroySurface() failed");
        }

        private void initGL() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.egl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.eglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                this.egl.eglInitialize(eglGetDisplay, new int[2]);
                checkEglError("eglInitialize() failed");
                this.eglConfig = GLTextureView.this.configChooser.chooseConfig(this.egl, this.eglDisplay);
                this.eglContext = GLTextureView.this.glContextFactory.createContext(this.egl, this.eglDisplay, this.eglConfig);
                this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, this.surface, null);
                checkEglError("eglCreateWindowSurface() failed");
                EGL10 egl102 = this.egl;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface = this.eglSurface;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext);
                checkEglError("eglMakeCurrent() failed");
                this.gl = (GL10) this.eglContext.getGL();
                return;
            }
            throw new RuntimeException("eglGetDisplay() failed");
        }

        public synchronized void finish() {
            this.stopped = true;
            notifyAll();
        }

        public synchronized void onPause() {
            this.paused = true;
        }

        public synchronized void onResume() {
            this.paused = false;
            this.requested = true;
            notifyAll();
        }

        public synchronized void onSizeChanged(int i, int i2) {
            this.newViewport = new Rect(0, 0, i, i2);
            requestRender();
        }

        public synchronized void requestRender() {
            if (!this.paused) {
                this.requested = true;
                notifyAll();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            initGL();
            GLTextureView.this.renderer.onSurfaceCreated(this.gl, this.eglConfig);
            while (true) {
                synchronized (this) {
                    while (true) {
                        if ((this.paused || !this.requested) && !this.stopped) {
                            try {
                                wait();
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                    if (this.stopped) {
                        finishGL();
                        return;
                    }
                    this.requested = false;
                    if (this.newViewport != null) {
                        GLTextureView.this.renderer.onSurfaceChanged(this.gl, this.newViewport.width(), this.newViewport.height());
                        this.newViewport = null;
                    }
                }
                GLTextureView.this.renderer.onDrawFrame(this.gl);
                this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
            }
        }
    }

    public GLTextureView(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        EGLConfigChooserImpl eGLConfigChooserImpl = new EGLConfigChooserImpl();
        this.configChooser = eGLConfigChooserImpl;
        this.glContextFactory = new GLContextFactory(z, eGLConfigChooserImpl);
        setSurfaceTextureListener(this);
    }

    public void onPause() {
        if (this.initialized) {
            this.renderThread.onPause();
        }
    }

    public void onResume() {
        if (this.initialized) {
            this.renderThread.onResume();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        RenderThread renderThread2 = new RenderThread(surfaceTexture);
        this.renderThread = renderThread2;
        renderThread2.onSizeChanged(i, i2);
        this.renderThread.start();
        this.initialized = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (!this.initialized) {
            return true;
        }
        stopRenderThread();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.initialized) {
            this.renderThread.onSizeChanged(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void requestRender() {
        if (this.initialized) {
            this.renderThread.requestRender();
        }
    }

    public void setRenderer(GLSurfaceView.Renderer renderer2) {
        this.renderer = renderer2;
    }

    public void stopRenderThread() {
        this.renderThread.finish();
        try {
            this.renderThread.join();
        } catch (InterruptedException unused) {
        }
        this.initialized = false;
    }
}
