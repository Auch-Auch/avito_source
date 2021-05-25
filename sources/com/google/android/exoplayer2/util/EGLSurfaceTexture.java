package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@RequiresApi(17)
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final int SECURE_MODE_NONE = 0;
    public static final int SECURE_MODE_PROTECTED_PBUFFER = 2;
    public static final int SECURE_MODE_SURFACELESS_CONTEXT = 1;
    public static final int[] h = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    public final Handler a;
    public final int[] b;
    @Nullable
    public final TextureImageListener c;
    @Nullable
    public EGLDisplay d;
    @Nullable
    public EGLContext e;
    @Nullable
    public EGLSurface f;
    @Nullable
    public SurfaceTexture g;

    public static final class GlException extends RuntimeException {
        public GlException(String str, a aVar) {
            super(str);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SecureMode {
    }

    public interface TextureImageListener {
        void onFrameAvailable();
    }

    public EGLSurfaceTexture(Handler handler) {
        this(handler, null);
    }

    public SurfaceTexture getSurfaceTexture() {
        return (SurfaceTexture) Assertions.checkNotNull(this.g);
    }

    public void init(int i) {
        int[] iArr;
        EGLSurface eGLSurface;
        int[] iArr2;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            int[] iArr3 = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr3, 0, iArr3, 1)) {
                this.d = eglGetDisplay;
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr4 = new int[1];
                boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, h, 0, eGLConfigArr, 0, 1, iArr4, 0);
                if (!eglChooseConfig || iArr4[0] <= 0 || eGLConfigArr[0] == null) {
                    throw new GlException(Util.formatInvariant("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr4[0]), eGLConfigArr[0]), null);
                }
                EGLConfig eGLConfig = eGLConfigArr[0];
                EGLDisplay eGLDisplay = this.d;
                if (i == 0) {
                    iArr = new int[]{12440, 2, 12344};
                } else {
                    iArr = new int[]{12440, 2, 12992, 1, 12344};
                }
                EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                if (eglCreateContext != null) {
                    this.e = eglCreateContext;
                    EGLDisplay eGLDisplay2 = this.d;
                    if (i == 1) {
                        eGLSurface = EGL14.EGL_NO_SURFACE;
                    } else {
                        if (i == 2) {
                            iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                        } else {
                            iArr2 = new int[]{12375, 1, 12374, 1, 12344};
                        }
                        eGLSurface = EGL14.eglCreatePbufferSurface(eGLDisplay2, eGLConfig, iArr2, 0);
                        if (eGLSurface == null) {
                            throw new GlException("eglCreatePbufferSurface failed", null);
                        }
                    }
                    if (EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, eglCreateContext)) {
                        this.f = eGLSurface;
                        GLES20.glGenTextures(1, this.b, 0);
                        GlUtil.checkGlError();
                        SurfaceTexture surfaceTexture = new SurfaceTexture(this.b[0]);
                        this.g = surfaceTexture;
                        surfaceTexture.setOnFrameAvailableListener(this);
                        return;
                    }
                    throw new GlException("eglMakeCurrent failed", null);
                }
                throw new GlException("eglCreateContext failed", null);
            }
            throw new GlException("eglInitialize failed", null);
        }
        throw new GlException("eglGetDisplay failed", null);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.a.post(this);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.opengl.EGLContext, android.graphics.SurfaceTexture, android.opengl.EGLSurface, android.opengl.EGLDisplay] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void release() {
        /*
            r6 = this;
            android.os.Handler r0 = r6.a
            r0.removeCallbacks(r6)
            r0 = 19
            r1 = 0
            android.graphics.SurfaceTexture r2 = r6.g     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x0016
            r2.release()     // Catch:{ all -> 0x0068 }
            r2 = 1
            int[] r3 = r6.b     // Catch:{ all -> 0x0068 }
            r4 = 0
            android.opengl.GLES20.glDeleteTextures(r2, r3, r4)     // Catch:{ all -> 0x0068 }
        L_0x0016:
            android.opengl.EGLDisplay r2 = r6.d
            if (r2 == 0) goto L_0x002b
            android.opengl.EGLDisplay r3 = android.opengl.EGL14.EGL_NO_DISPLAY
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x002b
            android.opengl.EGLDisplay r2 = r6.d
            android.opengl.EGLSurface r3 = android.opengl.EGL14.EGL_NO_SURFACE
            android.opengl.EGLContext r4 = android.opengl.EGL14.EGL_NO_CONTEXT
            android.opengl.EGL14.eglMakeCurrent(r2, r3, r3, r4)
        L_0x002b:
            android.opengl.EGLSurface r2 = r6.f
            if (r2 == 0) goto L_0x003e
            android.opengl.EGLSurface r3 = android.opengl.EGL14.EGL_NO_SURFACE
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x003e
            android.opengl.EGLDisplay r2 = r6.d
            android.opengl.EGLSurface r3 = r6.f
            android.opengl.EGL14.eglDestroySurface(r2, r3)
        L_0x003e:
            android.opengl.EGLContext r2 = r6.e
            if (r2 == 0) goto L_0x0047
            android.opengl.EGLDisplay r3 = r6.d
            android.opengl.EGL14.eglDestroyContext(r3, r2)
        L_0x0047:
            int r2 = com.google.android.exoplayer2.util.Util.SDK_INT
            if (r2 < r0) goto L_0x004e
            android.opengl.EGL14.eglReleaseThread()
        L_0x004e:
            android.opengl.EGLDisplay r0 = r6.d
            if (r0 == 0) goto L_0x005f
            android.opengl.EGLDisplay r2 = android.opengl.EGL14.EGL_NO_DISPLAY
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x005f
            android.opengl.EGLDisplay r0 = r6.d
            android.opengl.EGL14.eglTerminate(r0)
        L_0x005f:
            r6.d = r1
            r6.e = r1
            r6.f = r1
            r6.g = r1
            return
        L_0x0068:
            r2 = move-exception
            android.opengl.EGLDisplay r3 = r6.d
            if (r3 == 0) goto L_0x007e
            android.opengl.EGLDisplay r4 = android.opengl.EGL14.EGL_NO_DISPLAY
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x007e
            android.opengl.EGLDisplay r3 = r6.d
            android.opengl.EGLSurface r4 = android.opengl.EGL14.EGL_NO_SURFACE
            android.opengl.EGLContext r5 = android.opengl.EGL14.EGL_NO_CONTEXT
            android.opengl.EGL14.eglMakeCurrent(r3, r4, r4, r5)
        L_0x007e:
            android.opengl.EGLSurface r3 = r6.f
            if (r3 == 0) goto L_0x0091
            android.opengl.EGLSurface r4 = android.opengl.EGL14.EGL_NO_SURFACE
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0091
            android.opengl.EGLDisplay r3 = r6.d
            android.opengl.EGLSurface r4 = r6.f
            android.opengl.EGL14.eglDestroySurface(r3, r4)
        L_0x0091:
            android.opengl.EGLContext r3 = r6.e
            if (r3 == 0) goto L_0x009a
            android.opengl.EGLDisplay r4 = r6.d
            android.opengl.EGL14.eglDestroyContext(r4, r3)
        L_0x009a:
            int r3 = com.google.android.exoplayer2.util.Util.SDK_INT
            if (r3 < r0) goto L_0x00a1
            android.opengl.EGL14.eglReleaseThread()
        L_0x00a1:
            android.opengl.EGLDisplay r0 = r6.d
            if (r0 == 0) goto L_0x00b2
            android.opengl.EGLDisplay r3 = android.opengl.EGL14.EGL_NO_DISPLAY
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x00b2
            android.opengl.EGLDisplay r0 = r6.d
            android.opengl.EGL14.eglTerminate(r0)
        L_0x00b2:
            r6.d = r1
            r6.e = r1
            r6.f = r1
            r6.g = r1
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.EGLSurfaceTexture.release():void");
    }

    @Override // java.lang.Runnable
    public void run() {
        TextureImageListener textureImageListener = this.c;
        if (textureImageListener != null) {
            textureImageListener.onFrameAvailable();
        }
        SurfaceTexture surfaceTexture = this.g;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public EGLSurfaceTexture(Handler handler, @Nullable TextureImageListener textureImageListener) {
        this.a = handler;
        this.c = textureImageListener;
        this.b = new int[1];
    }
}
