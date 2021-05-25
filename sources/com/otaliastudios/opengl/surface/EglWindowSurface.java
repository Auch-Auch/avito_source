package com.otaliastudios.opengl.surface;

import a2.g.r.g;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.otaliastudios.opengl.core.EglCore;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B#\b\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglWindowSurface;", "Lcom/otaliastudios/opengl/surface/EglNativeWindowSurface;", "", "release", "()V", "Landroid/view/Surface;", "f", "Landroid/view/Surface;", "surface", "", g.a, "Z", "releaseSurface", "Lcom/otaliastudios/opengl/core/EglCore;", "eglCore", "<init>", "(Lcom/otaliastudios/opengl/core/EglCore;Landroid/view/Surface;Z)V", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "(Lcom/otaliastudios/opengl/core/EglCore;Landroid/graphics/SurfaceTexture;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class EglWindowSurface extends EglNativeWindowSurface {
    public Surface f;
    public boolean g;

    @JvmOverloads
    public EglWindowSurface(@NotNull EglCore eglCore, @NotNull Surface surface) {
        this(eglCore, surface, false, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EglWindowSurface(EglCore eglCore, Surface surface, boolean z, int i, j jVar) {
        this(eglCore, surface, (i & 4) != 0 ? false : z);
    }

    @Override // com.otaliastudios.opengl.surface.EglNativeSurface
    public void release() {
        super.release();
        if (this.g) {
            Surface surface = this.f;
            if (surface != null) {
                surface.release();
            }
            this.f = null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EglWindowSurface(@NotNull EglCore eglCore, @NotNull Surface surface, boolean z) {
        super(eglCore, eglCore.createWindowSurface$egloo_metadata_release(surface));
        Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.f = surface;
        this.g = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EglWindowSurface(@NotNull EglCore eglCore, @NotNull SurfaceTexture surfaceTexture) {
        super(eglCore, eglCore.createWindowSurface$egloo_metadata_release(surfaceTexture));
        Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
    }
}
