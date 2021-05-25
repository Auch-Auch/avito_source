package com.otaliastudios.opengl.core;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import com.otaliastudios.opengl.internal.EglConfig;
import com.otaliastudios.opengl.internal.EglDisplay;
import com.otaliastudios.opengl.internal.EglKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.webrtc.EglBase;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/otaliastudios/opengl/core/EglNativeConfigChooser;", "", "Lcom/otaliastudios/opengl/internal/EglDisplay;", "display", "", "version", "", "recordable", "Lcom/otaliastudios/opengl/internal/EglConfig;", "getConfig$egloo_metadata_release", "(Lcom/otaliastudios/opengl/internal/EglDisplay;IZ)Lcom/otaliastudios/opengl/internal/EglConfig;", "getConfig", "", "getConfigSpec$egloo_metadata_release", "(IZ)[I", "getConfigSpec", "<init>", "()V", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class EglNativeConfigChooser {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/otaliastudios/opengl/core/EglNativeConfigChooser$Companion;", "", "", "EGL_RECORDABLE_ANDROID", "I", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Nullable
    public final EglConfig getConfig$egloo_metadata_release(@NotNull EglDisplay eglDisplay, int i, boolean z) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        int[] configSpec$egloo_metadata_release = getConfigSpec$egloo_metadata_release(i, z);
        EglConfig[] eglConfigArr = new EglConfig[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eglDisplay.getNative(), configSpec$egloo_metadata_release, 0, eGLConfigArr, 0, 1, new int[1], 0);
        if (eglChooseConfig) {
            Iterator it = ArraysKt___ArraysKt.getIndices(eglConfigArr).iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                EGLConfig eGLConfig = eGLConfigArr[nextInt];
                eglConfigArr[nextInt] = eGLConfig != null ? new EglConfig(eGLConfig) : null;
            }
        }
        if (!eglChooseConfig) {
            return null;
        }
        return eglConfigArr[0];
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0068: APUT  (r1v1 int[]), (12 ??[int, float, short, byte, char]), (r0v9 int) */
    @NotNull
    public final int[] getConfigSpec$egloo_metadata_release(int i, boolean z) {
        int i2;
        int i3;
        if (i >= 3) {
            i2 = EglKt.getEGL_OPENGL_ES2_BIT() | EglKt.getEGL_OPENGL_ES3_BIT_KHR();
        } else {
            i2 = EglKt.getEGL_OPENGL_ES2_BIT();
        }
        int[] iArr = new int[15];
        iArr[0] = EglKt.getEGL_RED_SIZE();
        iArr[1] = 8;
        iArr[2] = EglKt.getEGL_GREEN_SIZE();
        iArr[3] = 8;
        iArr[4] = EglKt.getEGL_BLUE_SIZE();
        iArr[5] = 8;
        iArr[6] = EglKt.getEGL_ALPHA_SIZE();
        iArr[7] = 8;
        iArr[8] = EglKt.getEGL_SURFACE_TYPE();
        iArr[9] = EglKt.getEGL_WINDOW_BIT() | EglKt.getEGL_PBUFFER_BIT();
        iArr[10] = EglKt.getEGL_RENDERABLE_TYPE();
        iArr[11] = i2;
        if (z) {
            i3 = EglBase.EGL_RECORDABLE_ANDROID;
        } else {
            i3 = EglKt.getEGL_NONE();
        }
        iArr[12] = i3;
        iArr[13] = z ? 1 : 0;
        iArr[14] = EglKt.getEGL_NONE();
        return iArr;
    }
}
