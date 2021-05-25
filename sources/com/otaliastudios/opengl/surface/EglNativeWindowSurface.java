package com.otaliastudios.opengl.surface;

import com.otaliastudios.opengl.core.EglCore;
import com.otaliastudios.opengl.internal.EglSurface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglNativeWindowSurface;", "Lcom/otaliastudios/opengl/surface/EglSurface;", "", "swapBuffers", "()Z", "Lcom/otaliastudios/opengl/core/EglCore;", "eglCore", "Lcom/otaliastudios/opengl/internal/EglSurface;", "eglSurface", "<init>", "(Lcom/otaliastudios/opengl/core/EglCore;Lcom/otaliastudios/opengl/internal/EglSurface;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public abstract class EglNativeWindowSurface extends EglSurface {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EglNativeWindowSurface(@NotNull EglCore eglCore, @NotNull EglSurface eglSurface) {
        super(eglCore, eglSurface);
        Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
    }

    public final boolean swapBuffers() {
        return getEglCore$egloo_metadata_release().swapSurfaceBuffers$egloo_metadata_release(getEglSurface$egloo_metadata_release());
    }
}
