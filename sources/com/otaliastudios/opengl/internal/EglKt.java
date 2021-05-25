package com.otaliastudios.opengl.internal;

import a2.g.r.g;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLExt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\bN\u001a@\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\b¢\u0006\u0004\b\u000b\u0010\f\u001a(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a0\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0010\u0010\u0016\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0010\u0010\u0018\u001a\u00020\u0012H\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\u0000H\b¢\u0006\u0004\b\u001a\u0010\u0017\u001a\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0007H\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a0\u0010\"\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0002H\b¢\u0006\u0004\b\"\u0010#\u001a0\u0010%\u001a\u00020\u001c2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0002H\b¢\u0006\u0004\b%\u0010&\u001a(\u0010'\u001a\u00020\u001c2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\b¢\u0006\u0004\b'\u0010(\u001a0\u0010,\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0012H\b¢\u0006\u0004\b,\u0010-\u001a \u0010.\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001cH\b¢\u0006\u0004\b.\u0010/\u001a(\u00102\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u00101\u001a\u000200H\b¢\u0006\u0004\b2\u00103\u001a \u00104\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0012H\b¢\u0006\u0004\b4\u00105\u001a \u00106\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001cH\b¢\u0006\u0004\b6\u0010/\u001a\u0010\u00107\u001a\u00020\nH\b¢\u0006\u0004\b7\u00108\u001a\u0018\u00109\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b9\u0010:\u001a\u0010\u0010;\u001a\u00020\u0007H\b¢\u0006\u0004\b;\u0010<\"\u001c\u0010@\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010<\"\u001c\u0010C\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bA\u0010>\u001a\u0004\bB\u0010<\"\u001c\u0010G\u001a\u00020\u00008\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u0017\"\u001c\u0010J\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bH\u0010>\u001a\u0004\bI\u0010<\"\u001c\u0010M\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bK\u0010>\u001a\u0004\bL\u0010<\"\u001c\u0010P\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bN\u0010>\u001a\u0004\bO\u0010<\"\u001c\u0010S\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bQ\u0010>\u001a\u0004\bR\u0010<\"\u001c\u0010V\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bT\u0010>\u001a\u0004\bU\u0010<\"\u001c\u0010Y\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bW\u0010>\u001a\u0004\bX\u0010<\"\u001c\u0010]\u001a\u00020\u00128\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010\u0019\"\u001c\u0010`\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\b^\u0010>\u001a\u0004\b_\u0010<\"\u001c\u0010c\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\ba\u0010>\u001a\u0004\bb\u0010<\"\u001c\u0010f\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bd\u0010>\u001a\u0004\be\u0010<\"\u001c\u0010i\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bg\u0010>\u001a\u0004\bh\u0010<\"\u001c\u0010l\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bj\u0010>\u001a\u0004\bk\u0010<\"\u001c\u0010o\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bm\u0010>\u001a\u0004\bn\u0010<\"\u001c\u0010r\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bp\u0010>\u001a\u0004\bq\u0010<\"\u001c\u0010u\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\bs\u0010>\u001a\u0004\bt\u0010<\"\u001c\u0010z\u001a\u00020\u001c8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u001c\u0010}\u001a\u00020\u00078\u0000@\u0000XD¢\u0006\f\n\u0004\b{\u0010>\u001a\u0004\b|\u0010<¨\u0006~"}, d2 = {"Lcom/otaliastudios/opengl/internal/EglDisplay;", "display", "", Navigation.ATTRIBUTES, "", "Lcom/otaliastudios/opengl/internal/EglConfig;", "configs", "", "configsSize", "numConfigs", "", "eglChooseConfig", "(Lcom/otaliastudios/opengl/internal/EglDisplay;[I[Lcom/otaliastudios/opengl/internal/EglConfig;I[I)Z", "major", "minor", "eglInitialize", "(Lcom/otaliastudios/opengl/internal/EglDisplay;[I[I)Z", Navigation.CONFIG, "Lcom/otaliastudios/opengl/internal/EglContext;", "sharedContext", "eglCreateContext", "(Lcom/otaliastudios/opengl/internal/EglDisplay;Lcom/otaliastudios/opengl/internal/EglConfig;Lcom/otaliastudios/opengl/internal/EglContext;[I)Lcom/otaliastudios/opengl/internal/EglContext;", "eglGetDefaultDisplay", "()Lcom/otaliastudios/opengl/internal/EglDisplay;", "eglGetCurrentContext", "()Lcom/otaliastudios/opengl/internal/EglContext;", "eglGetCurrentDisplay", "which", "Lcom/otaliastudios/opengl/internal/EglSurface;", "eglGetCurrentSurface", "(I)Lcom/otaliastudios/opengl/internal/EglSurface;", "surface", "attribute", VKApiConst.OUT, "eglQuerySurface", "(Lcom/otaliastudios/opengl/internal/EglDisplay;Lcom/otaliastudios/opengl/internal/EglSurface;I[I)Z", "", "eglCreateWindowSurface", "(Lcom/otaliastudios/opengl/internal/EglDisplay;Lcom/otaliastudios/opengl/internal/EglConfig;Ljava/lang/Object;[I)Lcom/otaliastudios/opengl/internal/EglSurface;", "eglCreatePbufferSurface", "(Lcom/otaliastudios/opengl/internal/EglDisplay;Lcom/otaliastudios/opengl/internal/EglConfig;[I)Lcom/otaliastudios/opengl/internal/EglSurface;", "draw", "read", "context", "eglMakeCurrent", "(Lcom/otaliastudios/opengl/internal/EglDisplay;Lcom/otaliastudios/opengl/internal/EglSurface;Lcom/otaliastudios/opengl/internal/EglSurface;Lcom/otaliastudios/opengl/internal/EglContext;)Z", "eglSwapBuffers", "(Lcom/otaliastudios/opengl/internal/EglDisplay;Lcom/otaliastudios/opengl/internal/EglSurface;)Z", "", "nanoseconds", "eglPresentationTime", "(Lcom/otaliastudios/opengl/internal/EglDisplay;Lcom/otaliastudios/opengl/internal/EglSurface;J)Z", "eglDestroyContext", "(Lcom/otaliastudios/opengl/internal/EglDisplay;Lcom/otaliastudios/opengl/internal/EglContext;)Z", "eglDestroySurface", "eglReleaseThread", "()Z", "eglTerminate", "(Lcom/otaliastudios/opengl/internal/EglDisplay;)Z", "eglGetError", "()I", "j", "I", "getEGL_CONTEXT_CLIENT_VERSION", "EGL_CONTEXT_CLIENT_VERSION", "h", "getEGL_READ", "EGL_READ", AuthSource.BOOKING_ORDER, "Lcom/otaliastudios/opengl/internal/EglDisplay;", "getEGL_NO_DISPLAY", "EGL_NO_DISPLAY", AuthSource.OPEN_CHANNEL_LIST, "getEGL_RED_SIZE", "EGL_RED_SIZE", "p", "getEGL_ALPHA_SIZE", "EGL_ALPHA_SIZE", "e", "getEGL_NONE", "EGL_NONE", "i", "getEGL_DRAW", "EGL_DRAW", "n", "getEGL_GREEN_SIZE", "EGL_GREEN_SIZE", "o", "getEGL_BLUE_SIZE", "EGL_BLUE_SIZE", AuthSource.SEND_ABUSE, "Lcom/otaliastudios/opengl/internal/EglContext;", "getEGL_NO_CONTEXT", "EGL_NO_CONTEXT", "t", "getEGL_RENDERABLE_TYPE", "EGL_RENDERABLE_TYPE", "k", "getEGL_OPENGL_ES2_BIT", "EGL_OPENGL_ES2_BIT", "d", "getEGL_SUCCESS", "EGL_SUCCESS", "f", "getEGL_WIDTH", "EGL_WIDTH", VKApiConst.Q, "getEGL_SURFACE_TYPE", "EGL_SURFACE_TYPE", "s", "getEGL_PBUFFER_BIT", "EGL_PBUFFER_BIT", g.a, "getEGL_HEIGHT", "EGL_HEIGHT", "l", "getEGL_OPENGL_ES3_BIT_KHR", "EGL_OPENGL_ES3_BIT_KHR", "c", "Lcom/otaliastudios/opengl/internal/EglSurface;", "getEGL_NO_SURFACE", "()Lcom/otaliastudios/opengl/internal/EglSurface;", "EGL_NO_SURFACE", "r", "getEGL_WINDOW_BIT", "EGL_WINDOW_BIT", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
public final class EglKt {
    @NotNull
    public static final EglContext a = new EglContext(EGL14.EGL_NO_CONTEXT);
    @NotNull
    public static final EglDisplay b = new EglDisplay(EGL14.EGL_NO_DISPLAY);
    @NotNull
    public static final EglSurface c = new EglSurface(EGL14.EGL_NO_SURFACE);
    public static final int d = 12288;
    public static final int e = 12344;
    public static final int f = 12375;
    public static final int g = 12374;
    public static final int h = 12378;
    public static final int i = 12377;
    public static final int j = 12440;
    public static final int k = 4;
    public static final int l = 64;
    public static final int m = 12324;
    public static final int n = 12323;
    public static final int o = 12322;
    public static final int p = 12321;
    public static final int q = 12339;
    public static final int r = 4;
    public static final int s = 1;
    public static final int t = 12352;

    public static final boolean eglChooseConfig(@NotNull EglDisplay eglDisplay, @NotNull int[] iArr, @NotNull EglConfig[] eglConfigArr, int i2, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(iArr, Navigation.ATTRIBUTES);
        Intrinsics.checkNotNullParameter(eglConfigArr, "configs");
        Intrinsics.checkNotNullParameter(iArr2, "numConfigs");
        EGLConfig[] eGLConfigArr = new EGLConfig[eglConfigArr.length];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eglDisplay.getNative(), iArr, 0, eGLConfigArr, 0, i2, iArr2, 0);
        if (eglChooseConfig) {
            Iterator it = ArraysKt___ArraysKt.getIndices(eglConfigArr).iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                EGLConfig eGLConfig = eGLConfigArr[nextInt];
                eglConfigArr[nextInt] = eGLConfig != null ? new EglConfig(eGLConfig) : null;
            }
        }
        return eglChooseConfig;
    }

    @NotNull
    public static final EglContext eglCreateContext(@NotNull EglDisplay eglDisplay, @NotNull EglConfig eglConfig, @NotNull EglContext eglContext, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(eglConfig, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(eglContext, "sharedContext");
        Intrinsics.checkNotNullParameter(iArr, Navigation.ATTRIBUTES);
        return new EglContext(EGL14.eglCreateContext(eglDisplay.getNative(), eglConfig.getNative(), eglContext.getNative(), iArr, 0));
    }

    @NotNull
    public static final EglSurface eglCreatePbufferSurface(@NotNull EglDisplay eglDisplay, @NotNull EglConfig eglConfig, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(eglConfig, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(iArr, Navigation.ATTRIBUTES);
        return new EglSurface(EGL14.eglCreatePbufferSurface(eglDisplay.getNative(), eglConfig.getNative(), iArr, 0));
    }

    @NotNull
    public static final EglSurface eglCreateWindowSurface(@NotNull EglDisplay eglDisplay, @NotNull EglConfig eglConfig, @NotNull Object obj, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(eglConfig, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(obj, "surface");
        Intrinsics.checkNotNullParameter(iArr, Navigation.ATTRIBUTES);
        return new EglSurface(EGL14.eglCreateWindowSurface(eglDisplay.getNative(), eglConfig.getNative(), obj, iArr, 0));
    }

    public static final boolean eglDestroyContext(@NotNull EglDisplay eglDisplay, @NotNull EglContext eglContext) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(eglContext, "context");
        return EGL14.eglDestroyContext(eglDisplay.getNative(), eglContext.getNative());
    }

    public static final boolean eglDestroySurface(@NotNull EglDisplay eglDisplay, @NotNull EglSurface eglSurface) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(eglSurface, "surface");
        return EGL14.eglDestroySurface(eglDisplay.getNative(), eglSurface.getNative());
    }

    @NotNull
    public static final EglContext eglGetCurrentContext() {
        return new EglContext(EGL14.eglGetCurrentContext());
    }

    @NotNull
    public static final EglDisplay eglGetCurrentDisplay() {
        return new EglDisplay(EGL14.eglGetCurrentDisplay());
    }

    @NotNull
    public static final EglSurface eglGetCurrentSurface(int i2) {
        return new EglSurface(EGL14.eglGetCurrentSurface(i2));
    }

    @NotNull
    public static final EglDisplay eglGetDefaultDisplay() {
        return new EglDisplay(EGL14.eglGetDisplay(0));
    }

    public static final int eglGetError() {
        return EGL14.eglGetError();
    }

    public static final boolean eglInitialize(@NotNull EglDisplay eglDisplay, @NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(iArr, "major");
        Intrinsics.checkNotNullParameter(iArr2, "minor");
        return EGL14.eglInitialize(eglDisplay.getNative(), iArr, 0, iArr2, 0);
    }

    public static final boolean eglMakeCurrent(@NotNull EglDisplay eglDisplay, @NotNull EglSurface eglSurface, @NotNull EglSurface eglSurface2, @NotNull EglContext eglContext) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(eglSurface, "draw");
        Intrinsics.checkNotNullParameter(eglSurface2, "read");
        Intrinsics.checkNotNullParameter(eglContext, "context");
        return EGL14.eglMakeCurrent(eglDisplay.getNative(), eglSurface.getNative(), eglSurface2.getNative(), eglContext.getNative());
    }

    public static final boolean eglPresentationTime(@NotNull EglDisplay eglDisplay, @NotNull EglSurface eglSurface, long j2) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(eglSurface, "surface");
        return EGLExt.eglPresentationTimeANDROID(eglDisplay.getNative(), eglSurface.getNative(), j2);
    }

    public static final boolean eglQuerySurface(@NotNull EglDisplay eglDisplay, @NotNull EglSurface eglSurface, int i2, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(eglSurface, "surface");
        Intrinsics.checkNotNullParameter(iArr, VKApiConst.OUT);
        return EGL14.eglQuerySurface(eglDisplay.getNative(), eglSurface.getNative(), i2, iArr, 0);
    }

    public static final boolean eglReleaseThread() {
        return EGL14.eglReleaseThread();
    }

    public static final boolean eglSwapBuffers(@NotNull EglDisplay eglDisplay, @NotNull EglSurface eglSurface) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        Intrinsics.checkNotNullParameter(eglSurface, "surface");
        return EGL14.eglSwapBuffers(eglDisplay.getNative(), eglSurface.getNative());
    }

    public static final boolean eglTerminate(@NotNull EglDisplay eglDisplay) {
        Intrinsics.checkNotNullParameter(eglDisplay, "display");
        return EGL14.eglTerminate(eglDisplay.getNative());
    }

    public static final int getEGL_ALPHA_SIZE() {
        return p;
    }

    public static final int getEGL_BLUE_SIZE() {
        return o;
    }

    public static final int getEGL_CONTEXT_CLIENT_VERSION() {
        return j;
    }

    public static final int getEGL_DRAW() {
        return i;
    }

    public static final int getEGL_GREEN_SIZE() {
        return n;
    }

    public static final int getEGL_HEIGHT() {
        return g;
    }

    public static final int getEGL_NONE() {
        return e;
    }

    @NotNull
    public static final EglContext getEGL_NO_CONTEXT() {
        return a;
    }

    @NotNull
    public static final EglDisplay getEGL_NO_DISPLAY() {
        return b;
    }

    @NotNull
    public static final EglSurface getEGL_NO_SURFACE() {
        return c;
    }

    public static final int getEGL_OPENGL_ES2_BIT() {
        return k;
    }

    public static final int getEGL_OPENGL_ES3_BIT_KHR() {
        return l;
    }

    public static final int getEGL_PBUFFER_BIT() {
        return s;
    }

    public static final int getEGL_READ() {
        return h;
    }

    public static final int getEGL_RED_SIZE() {
        return m;
    }

    public static final int getEGL_RENDERABLE_TYPE() {
        return t;
    }

    public static final int getEGL_SUCCESS() {
        return d;
    }

    public static final int getEGL_SURFACE_TYPE() {
        return q;
    }

    public static final int getEGL_WIDTH() {
        return f;
    }

    public static final int getEGL_WINDOW_BIT() {
        return r;
    }
}
