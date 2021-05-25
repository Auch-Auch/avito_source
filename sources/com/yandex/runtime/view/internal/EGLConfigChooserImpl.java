package com.yandex.runtime.view.internal;

import a2.b.a.a.a;
import android.opengl.GLSurfaceView;
import com.yandex.runtime.logging.Logger;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
public class EGLConfigChooserImpl implements GLSurfaceView.EGLConfigChooser, GLVersionProvider {
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final int EGL_OPENGL_ES3_BIT_KHR = 64;
    private int glVersion = 2;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0012: APUT  (r0v1 int[]), (1 ??[boolean, int, float, short, byte, char]), (r4v1 int) */
    private static int[] getAttrs(int i) {
        int[] iArr = new int[15];
        iArr[0] = 12352;
        iArr[1] = i == 3 ? 64 : 4;
        iArr[2] = 12324;
        iArr[3] = 8;
        iArr[4] = 12323;
        iArr[5] = 8;
        iArr[6] = 12322;
        iArr[7] = 8;
        iArr[8] = 12321;
        iArr[9] = 8;
        iArr[10] = 12325;
        iArr[11] = 16;
        iArr[12] = 12326;
        iArr[13] = 8;
        iArr[14] = 12344;
        return iArr;
    }

    private static EGLConfig tryChooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, int[] iArr) {
        int[] iArr2 = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, 1, iArr2) || iArr2[0] <= 0) {
            return null;
        }
        return eGLConfigArr[0];
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        EGLConfig tryChooseConfig = tryChooseConfig(egl10, eGLDisplay, getAttrs(3));
        if (tryChooseConfig != null) {
            this.glVersion = 3;
        } else {
            StringBuilder L = a.L("Could not choose OpenGl ES Version 3 config; Got EGL error ");
            L.append(egl10.eglGetError());
            Logger.warn(L.toString());
        }
        if (tryChooseConfig == null) {
            tryChooseConfig = tryChooseConfig(egl10, eGLDisplay, getAttrs(2));
        }
        if (tryChooseConfig != null) {
            return tryChooseConfig;
        }
        StringBuilder L2 = a.L("eglChooseConfig() failed; Got EGL error ");
        L2.append(egl10.eglGetError());
        throw new RuntimeException(L2.toString());
    }

    @Override // com.yandex.runtime.view.internal.GLVersionProvider
    public int getVersion() {
        return this.glVersion;
    }
}
