package com.otaliastudios.opengl.surface;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.otaliastudios.opengl.core.EglCore;
import com.otaliastudios.opengl.internal.EglKt;
import com.otaliastudios.opengl.internal.EglSurface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010)\u001a\u00020\"\u0012\u0006\u0010 \u001a\u00020\u0019¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\rJ\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\rJ\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u00198\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0018R\"\u0010)\u001a\u00020\"8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglNativeSurface;", "", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", "setWidth", "(I)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setHeight", "getWidth", "()I", "getHeight", "release", "()V", "", "isCurrent", "()Z", "makeCurrent", "makeNothingCurrent", "", "nsecs", "setPresentationTime", "(J)V", AuthSource.SEND_ABUSE, "I", "Lcom/otaliastudios/opengl/internal/EglSurface;", "d", "Lcom/otaliastudios/opengl/internal/EglSurface;", "getEglSurface$egloo_metadata_release", "()Lcom/otaliastudios/opengl/internal/EglSurface;", "setEglSurface$egloo_metadata_release", "(Lcom/otaliastudios/opengl/internal/EglSurface;)V", "eglSurface", AuthSource.BOOKING_ORDER, "Lcom/otaliastudios/opengl/core/EglCore;", "c", "Lcom/otaliastudios/opengl/core/EglCore;", "getEglCore$egloo_metadata_release", "()Lcom/otaliastudios/opengl/core/EglCore;", "setEglCore$egloo_metadata_release", "(Lcom/otaliastudios/opengl/core/EglCore;)V", "eglCore", "<init>", "(Lcom/otaliastudios/opengl/core/EglCore;Lcom/otaliastudios/opengl/internal/EglSurface;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class EglNativeSurface {
    public int a = -1;
    public int b = -1;
    @NotNull
    public EglCore c;
    @NotNull
    public EglSurface d;

    public EglNativeSurface(@NotNull EglCore eglCore, @NotNull EglSurface eglSurface) {
        Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
        this.c = eglCore;
        this.d = eglSurface;
    }

    @NotNull
    public final EglCore getEglCore$egloo_metadata_release() {
        return this.c;
    }

    @NotNull
    public final EglSurface getEglSurface$egloo_metadata_release() {
        return this.d;
    }

    public final int getHeight() {
        int i = this.b;
        return i < 0 ? this.c.querySurface$egloo_metadata_release(this.d, EglKt.getEGL_HEIGHT()) : i;
    }

    public final int getWidth() {
        int i = this.a;
        return i < 0 ? this.c.querySurface$egloo_metadata_release(this.d, EglKt.getEGL_WIDTH()) : i;
    }

    public final boolean isCurrent() {
        return this.c.isSurfaceCurrent$egloo_metadata_release(this.d);
    }

    public final void makeCurrent() {
        this.c.makeSurfaceCurrent$egloo_metadata_release(this.d);
    }

    public final void makeNothingCurrent() {
        this.c.makeCurrent$egloo_metadata_release();
    }

    public void release() {
        this.c.releaseSurface$egloo_metadata_release(this.d);
        this.d = EglKt.getEGL_NO_SURFACE();
        this.b = -1;
        this.a = -1;
    }

    public final void setEglCore$egloo_metadata_release(@NotNull EglCore eglCore) {
        Intrinsics.checkNotNullParameter(eglCore, "<set-?>");
        this.c = eglCore;
    }

    public final void setEglSurface$egloo_metadata_release(@NotNull EglSurface eglSurface) {
        Intrinsics.checkNotNullParameter(eglSurface, "<set-?>");
        this.d = eglSurface;
    }

    public final void setHeight(int i) {
        this.b = i;
    }

    public final void setPresentationTime(long j) {
        this.c.setSurfacePresentationTime$egloo_metadata_release(this.d, j);
    }

    public final void setWidth(int i) {
        this.a = i;
    }
}
