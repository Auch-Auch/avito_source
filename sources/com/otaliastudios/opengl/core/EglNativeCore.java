package com.otaliastudios.opengl.core;

import android.opengl.EGL14;
import android.opengl.EGLExt;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.otaliastudios.opengl.internal.EglConfig;
import com.otaliastudios.opengl.internal.EglContext;
import com.otaliastudios.opengl.internal.EglDisplay;
import com.otaliastudios.opengl.internal.EglKt;
import com.otaliastudios.opengl.internal.EglSurface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001;B\u001d\b\u0000\u0012\b\b\u0002\u00107\u001a\u000203\u0012\b\b\u0002\u00108\u001a\u00020\u0011¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0005\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0017\u0010\u000bJ\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0017\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010$\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b%\u0010\u001eJ\u001f\u0010*\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0011H\u0000¢\u0006\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u0006<"}, d2 = {"Lcom/otaliastudios/opengl/core/EglNativeCore;", "", "", "release$egloo_metadata_release", "()V", "release", "makeCurrent$egloo_metadata_release", "makeCurrent", "Lcom/otaliastudios/opengl/internal/EglSurface;", "eglSurface", "releaseSurface$egloo_metadata_release", "(Lcom/otaliastudios/opengl/internal/EglSurface;)V", "releaseSurface", "surface", "createWindowSurface$egloo_metadata_release", "(Ljava/lang/Object;)Lcom/otaliastudios/opengl/internal/EglSurface;", "createWindowSurface", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "createOffscreenSurface$egloo_metadata_release", "(II)Lcom/otaliastudios/opengl/internal/EglSurface;", "createOffscreenSurface", "makeSurfaceCurrent$egloo_metadata_release", "makeSurfaceCurrent", "drawSurface", "readSurface", "(Lcom/otaliastudios/opengl/internal/EglSurface;Lcom/otaliastudios/opengl/internal/EglSurface;)V", "", "swapSurfaceBuffers$egloo_metadata_release", "(Lcom/otaliastudios/opengl/internal/EglSurface;)Z", "swapSurfaceBuffers", "", "nsecs", "setSurfacePresentationTime$egloo_metadata_release", "(Lcom/otaliastudios/opengl/internal/EglSurface;J)V", "setSurfacePresentationTime", "isSurfaceCurrent$egloo_metadata_release", "isSurfaceCurrent", "what", "querySurface$egloo_metadata_release", "(Lcom/otaliastudios/opengl/internal/EglSurface;I)I", "querySurface", "Lcom/otaliastudios/opengl/internal/EglDisplay;", AuthSource.SEND_ABUSE, "Lcom/otaliastudios/opengl/internal/EglDisplay;", "eglDisplay", "Lcom/otaliastudios/opengl/internal/EglConfig;", "c", "Lcom/otaliastudios/opengl/internal/EglConfig;", "eglConfig", "Lcom/otaliastudios/opengl/internal/EglContext;", AuthSource.BOOKING_ORDER, "Lcom/otaliastudios/opengl/internal/EglContext;", "eglContext", "sharedContext", "flags", "<init>", "(Lcom/otaliastudios/opengl/internal/EglContext;I)V", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class EglNativeCore {
    public static final Companion Companion = new Companion(null);
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    public EglDisplay a;
    public EglContext b;
    public EglConfig c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/otaliastudios/opengl/core/EglNativeCore$Companion;", "", "", "FLAG_RECORDABLE", "I", "FLAG_TRY_GLES3", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public EglNativeCore() {
        this(null, 0, 3, null);
    }

    public EglNativeCore(@NotNull EglContext eglContext, int i) {
        EglConfig config$egloo_metadata_release;
        Intrinsics.checkNotNullParameter(eglContext, "sharedContext");
        this.a = EglKt.getEGL_NO_DISPLAY();
        this.b = EglKt.getEGL_NO_CONTEXT();
        EglDisplay eglDisplay = new EglDisplay(EGL14.eglGetDisplay(0));
        this.a = eglDisplay;
        if (eglDisplay == EglKt.getEGL_NO_DISPLAY()) {
            throw new RuntimeException("unable to get EGL14 display");
        } else if (EGL14.eglInitialize(this.a.getNative(), new int[1], 0, new int[1], 0)) {
            EglNativeConfigChooser eglNativeConfigChooser = new EglNativeConfigChooser();
            boolean z = (i & 1) != 0;
            if (((i & 2) != 0) && (config$egloo_metadata_release = eglNativeConfigChooser.getConfig$egloo_metadata_release(this.a, 3, z)) != null) {
                EglContext eglContext2 = new EglContext(EGL14.eglCreateContext(this.a.getNative(), config$egloo_metadata_release.getNative(), eglContext.getNative(), new int[]{EglKt.getEGL_CONTEXT_CLIENT_VERSION(), 3, EglKt.getEGL_NONE()}, 0));
                try {
                    Egloo.checkEglError("eglCreateContext (3)");
                    this.c = config$egloo_metadata_release;
                    this.b = eglContext2;
                } catch (Exception unused) {
                }
            }
            if (this.b == EglKt.getEGL_NO_CONTEXT()) {
                EglConfig config$egloo_metadata_release2 = eglNativeConfigChooser.getConfig$egloo_metadata_release(this.a, 2, z);
                if (config$egloo_metadata_release2 != null) {
                    EglContext eglContext3 = new EglContext(EGL14.eglCreateContext(this.a.getNative(), config$egloo_metadata_release2.getNative(), eglContext.getNative(), new int[]{EglKt.getEGL_CONTEXT_CLIENT_VERSION(), 2, EglKt.getEGL_NONE()}, 0));
                    Egloo.checkEglError("eglCreateContext (2)");
                    this.c = config$egloo_metadata_release2;
                    this.b = eglContext3;
                    return;
                }
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
        } else {
            throw new RuntimeException("unable to initialize EGL14");
        }
    }

    @NotNull
    public final EglSurface createOffscreenSurface$egloo_metadata_release(int i, int i2) {
        int[] iArr = {EglKt.getEGL_WIDTH(), i, EglKt.getEGL_HEIGHT(), i2, EglKt.getEGL_NONE()};
        EglDisplay eglDisplay = this.a;
        EglConfig eglConfig = this.c;
        Intrinsics.checkNotNull(eglConfig);
        EglSurface eglSurface = new EglSurface(EGL14.eglCreatePbufferSurface(eglDisplay.getNative(), eglConfig.getNative(), iArr, 0));
        Egloo.checkEglError("eglCreatePbufferSurface");
        if (eglSurface != EglKt.getEGL_NO_SURFACE()) {
            return eglSurface;
        }
        throw new RuntimeException("surface was null");
    }

    @NotNull
    public final EglSurface createWindowSurface$egloo_metadata_release(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "surface");
        int[] iArr = {EglKt.getEGL_NONE()};
        EglDisplay eglDisplay = this.a;
        EglConfig eglConfig = this.c;
        Intrinsics.checkNotNull(eglConfig);
        EglSurface eglSurface = new EglSurface(EGL14.eglCreateWindowSurface(eglDisplay.getNative(), eglConfig.getNative(), obj, iArr, 0));
        Egloo.checkEglError("eglCreateWindowSurface");
        if (eglSurface != EglKt.getEGL_NO_SURFACE()) {
            return eglSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public final boolean isSurfaceCurrent$egloo_metadata_release(@NotNull EglSurface eglSurface) {
        Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
        return Intrinsics.areEqual(this.b, new EglContext(EGL14.eglGetCurrentContext())) && Intrinsics.areEqual(eglSurface, new EglSurface(EGL14.eglGetCurrentSurface(EglKt.getEGL_DRAW())));
    }

    public void makeCurrent$egloo_metadata_release() {
        if (!EGL14.eglMakeCurrent(this.a.getNative(), EglKt.getEGL_NO_SURFACE().getNative(), EglKt.getEGL_NO_SURFACE().getNative(), this.b.getNative())) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final void makeSurfaceCurrent$egloo_metadata_release(@NotNull EglSurface eglSurface) {
        Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
        EglDisplay eglDisplay = this.a;
        EglKt.getEGL_NO_DISPLAY();
        if (!EGL14.eglMakeCurrent(this.a.getNative(), eglSurface.getNative(), eglSurface.getNative(), this.b.getNative())) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final int querySurface$egloo_metadata_release(@NotNull EglSurface eglSurface, int i) {
        Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.a.getNative(), eglSurface.getNative(), i, iArr, 0);
        return iArr[0];
    }

    public void release$egloo_metadata_release() {
        if (this.a != EglKt.getEGL_NO_DISPLAY()) {
            EGL14.eglMakeCurrent(this.a.getNative(), EglKt.getEGL_NO_SURFACE().getNative(), EglKt.getEGL_NO_SURFACE().getNative(), EglKt.getEGL_NO_CONTEXT().getNative());
            EGL14.eglDestroyContext(this.a.getNative(), this.b.getNative());
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.a.getNative());
        }
        this.a = EglKt.getEGL_NO_DISPLAY();
        this.b = EglKt.getEGL_NO_CONTEXT();
        this.c = null;
    }

    public final void releaseSurface$egloo_metadata_release(@NotNull EglSurface eglSurface) {
        Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
        EGL14.eglDestroySurface(this.a.getNative(), eglSurface.getNative());
    }

    public final void setSurfacePresentationTime$egloo_metadata_release(@NotNull EglSurface eglSurface, long j) {
        Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
        EGLExt.eglPresentationTimeANDROID(this.a.getNative(), eglSurface.getNative(), j);
    }

    public final boolean swapSurfaceBuffers$egloo_metadata_release(@NotNull EglSurface eglSurface) {
        Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
        return EGL14.eglSwapBuffers(this.a.getNative(), eglSurface.getNative());
    }

    public final void makeSurfaceCurrent$egloo_metadata_release(@NotNull EglSurface eglSurface, @NotNull EglSurface eglSurface2) {
        Intrinsics.checkNotNullParameter(eglSurface, "drawSurface");
        Intrinsics.checkNotNullParameter(eglSurface2, "readSurface");
        EglDisplay eglDisplay = this.a;
        EglKt.getEGL_NO_DISPLAY();
        if (!EGL14.eglMakeCurrent(this.a.getNative(), eglSurface.getNative(), eglSurface2.getNative(), this.b.getNative())) {
            throw new RuntimeException("eglMakeCurrent(draw,read) failed");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EglNativeCore(EglContext eglContext, int i, int i2, j jVar) {
        this((i2 & 1) != 0 ? EglKt.getEGL_NO_CONTEXT() : eglContext, (i2 & 2) != 0 ? 0 : i);
    }
}
