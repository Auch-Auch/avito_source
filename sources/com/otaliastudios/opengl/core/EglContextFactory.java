package com.otaliastudios.opengl.core;

import android.opengl.GLSurfaceView;
import com.avito.android.remote.auth.AuthSource;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002¢\u0006\u0004\b\r\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u0012\u0004\b\f\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/otaliastudios/opengl/core/EglContextFactory;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "TAG", "Landroid/opengl/GLSurfaceView$EGLContextFactory;", "GLES3", "Landroid/opengl/GLSurfaceView$EGLContextFactory;", "getGLES3$annotations", "()V", "GLES2", "getGLES2$annotations", "<init>", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class EglContextFactory {
    @JvmField
    @NotNull
    public static final GLSurfaceView.EGLContextFactory GLES2 = new a(2);
    @JvmField
    @NotNull
    public static final GLSurfaceView.EGLContextFactory GLES3 = new a(3);
    public static final EglContextFactory INSTANCE = new EglContextFactory();
    public static final String a;

    public static final class a implements GLSurfaceView.EGLContextFactory {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        @NotNull
        public EGLContext createContext(@NotNull EGL10 egl10, @NotNull EGLDisplay eGLDisplay, @NotNull EGLConfig eGLConfig) {
            Intrinsics.checkNotNullParameter(egl10, "egl");
            Intrinsics.checkNotNullParameter(eGLDisplay, "display");
            Intrinsics.checkNotNullParameter(eGLConfig, "eglConfig");
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, this.a, 12344});
            Intrinsics.checkNotNullExpressionValue(eglCreateContext, "egl.eglCreateContext(dis…L_NO_CONTEXT, attributes)");
            return eglCreateContext;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(@NotNull EGL10 egl10, @NotNull EGLDisplay eGLDisplay, @NotNull EGLContext eGLContext) {
            Intrinsics.checkNotNullParameter(egl10, "egl");
            Intrinsics.checkNotNullParameter(eGLDisplay, "display");
            Intrinsics.checkNotNullParameter(eGLContext, "context");
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                EglContextFactory eglContextFactory = EglContextFactory.INSTANCE;
                String unused = EglContextFactory.a;
                String str = "display:" + eGLDisplay + " context:" + eGLContext;
                StringBuilder L = a2.b.a.a.a.L("eglDestroyContex");
                L.append(egl10.eglGetError());
                throw new RuntimeException(L.toString());
            }
        }
    }

    static {
        String simpleName = EglContextFactory.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "EglContextFactory::class.java.simpleName");
        a = simpleName;
    }

    public static /* synthetic */ void getGLES2$annotations() {
    }

    public static /* synthetic */ void getGLES3$annotations() {
    }
}
