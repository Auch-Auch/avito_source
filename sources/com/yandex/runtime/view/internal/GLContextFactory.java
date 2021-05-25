package com.yandex.runtime.view.internal;

import a2.b.a.a.a;
import android.opengl.GLSurfaceView;
import com.yandex.runtime.graphics.GLContextVersionBinding;
import com.yandex.runtime.logging.Logger;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
public class GLContextFactory implements GLSurfaceView.EGLContextFactory {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_CONTEXT_FLAGS_KHR = 12540;
    private static final int EGL_CONTEXT_OPENGL_DEBUG_BIT_KHR = 1;
    private final boolean debugEnabled;
    private final GLVersionProvider glVersionProvider;

    public GLContextFactory(boolean z, GLVersionProvider gLVersionProvider) {
        this.debugEnabled = z;
        this.glVersionProvider = gLVersionProvider;
    }

    private int[] attributes(int i, boolean z) {
        return z ? new int[]{EGL_CONTEXT_CLIENT_VERSION, i, EGL_CONTEXT_FLAGS_KHR, 1, 12344} : new int[]{EGL_CONTEXT_CLIENT_VERSION, i, 12344};
    }

    private EGLContext tryCreateContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, boolean z) {
        int version = this.glVersionProvider.getVersion();
        StringBuilder L = a.L("Create OpenGl ES context version ");
        L.append(String.valueOf(version));
        Logger.warn(L.toString());
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, attributes(version, z));
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        EGLContext eGLContext;
        if (this.debugEnabled) {
            Logger.warn("Trying to create debug gl context");
            eGLContext = tryCreateContext(egl10, eGLDisplay, eGLConfig, true);
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                StringBuilder L = a.L("Could not create debug gl context; Got EGL error ");
                L.append(egl10.eglGetError());
                Logger.warn(L.toString());
            }
        } else {
            eGLContext = null;
        }
        if ((eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) && ((eGLContext = tryCreateContext(egl10, eGLDisplay, eGLConfig, false)) == null || eGLContext == EGL10.EGL_NO_CONTEXT)) {
            StringBuilder L2 = a.L("eglCreateContext() failed; Got EGL error ");
            L2.append(egl10.eglGetError());
            throw new RuntimeException(L2.toString());
        }
        GLContextVersionBinding.setVersion(this.glVersionProvider.getVersion());
        return eGLContext;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            StringBuilder L = a.L("eglDestroyContext() failed; Got EGL error ");
            L.append(egl10.eglGetError());
            throw new RuntimeException(L.toString());
        }
    }
}
