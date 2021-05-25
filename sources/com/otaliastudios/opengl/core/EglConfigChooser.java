package com.otaliastudios.opengl.core;

import android.opengl.GLSurfaceView;
import com.avito.android.remote.auth.AuthSource;
import com.otaliastudios.opengl.internal.EglConfig;
import com.otaliastudios.opengl.internal.EglDisplay;
import java.util.Objects;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u0012\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/otaliastudios/opengl/core/EglConfigChooser;", "Lcom/otaliastudios/opengl/core/EglNativeConfigChooser;", "Landroid/opengl/EGLDisplay;", "display", "", "version", "", "recordable", "Landroid/opengl/EGLConfig;", "getConfig", "(Landroid/opengl/EGLDisplay;IZ)Landroid/opengl/EGLConfig;", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "GLES2", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "getGLES2$annotations", "()V", "GLES3", "getGLES3$annotations", "<init>", AuthSource.SEND_ABUSE, "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class EglConfigChooser extends EglNativeConfigChooser {
    @JvmField
    @NotNull
    public static final GLSurfaceView.EGLConfigChooser GLES2 = new a(2);
    @JvmField
    @NotNull
    public static final GLSurfaceView.EGLConfigChooser GLES3 = new a(3);
    public static final EglConfigChooser INSTANCE = new EglConfigChooser();

    public static final class a implements GLSurfaceView.EGLConfigChooser {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        public final int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            int[] iArr = new int[1];
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr) ? iArr[0] : i2;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        @NotNull
        public EGLConfig chooseConfig(@NotNull EGL10 egl10, @NotNull EGLDisplay eGLDisplay) {
            EGLConfig eGLConfig;
            EGLConfig[] eGLConfigArr;
            Intrinsics.checkNotNullParameter(egl10, "egl");
            Intrinsics.checkNotNullParameter(eGLDisplay, "display");
            int[] iArr = new int[1];
            int[] configSpec$egloo_metadata_release = EglConfigChooser.INSTANCE.getConfigSpec$egloo_metadata_release(this.a, true);
            if (egl10.eglChooseConfig(eGLDisplay, configSpec$egloo_metadata_release, null, 0, iArr)) {
                int i = 0;
                int i2 = iArr[0];
                if (i2 > 0) {
                    EGLConfig[] eGLConfigArr2 = new EGLConfig[i2];
                    if (egl10.eglChooseConfig(eGLDisplay, configSpec$egloo_metadata_release, eGLConfigArr2, i2, iArr)) {
                        Object[] array = ArraysKt___ArraysKt.filterNotNull(eGLConfigArr2).toArray(new EGLConfig[0]);
                        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                        EGLConfig[] eGLConfigArr3 = (EGLConfig[]) array;
                        int length = eGLConfigArr3.length;
                        while (true) {
                            if (i >= length) {
                                eGLConfig = null;
                                break;
                            }
                            eGLConfig = eGLConfigArr3[i];
                            int a3 = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                            int a4 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                            if (a3 >= 0 && a4 >= 0) {
                                int a5 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                                int a6 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                                int a8 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                                eGLConfigArr = eGLConfigArr3;
                                int a9 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                                if (a5 == 8 && a6 == 8 && a8 == 8 && a9 == 8) {
                                    break;
                                }
                            } else {
                                eGLConfigArr = eGLConfigArr3;
                            }
                            i++;
                            eGLConfigArr3 = eGLConfigArr;
                        }
                        if (eGLConfig != null) {
                            return eGLConfig;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    @JvmStatic
    @Nullable
    public static final android.opengl.EGLConfig getConfig(@NotNull android.opengl.EGLDisplay eGLDisplay, int i, boolean z) {
        Intrinsics.checkNotNullParameter(eGLDisplay, "display");
        EglConfig config$egloo_metadata_release = super.getConfig$egloo_metadata_release(new EglDisplay(eGLDisplay), i, z);
        if (config$egloo_metadata_release != null) {
            return config$egloo_metadata_release.getNative();
        }
        return null;
    }

    public static /* synthetic */ void getGLES2$annotations() {
    }

    public static /* synthetic */ void getGLES3$annotations() {
    }
}
