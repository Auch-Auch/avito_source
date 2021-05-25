package com.otaliastudios.opengl.surface;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.otaliastudios.opengl.core.EglCore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglOffscreenSurface;", "Lcom/otaliastudios/opengl/surface/EglSurface;", "Lcom/otaliastudios/opengl/core/EglCore;", "eglCore", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "<init>", "(Lcom/otaliastudios/opengl/core/EglCore;II)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class EglOffscreenSurface extends EglSurface {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EglOffscreenSurface(@NotNull EglCore eglCore, int i, int i2) {
        super(eglCore, eglCore.createOffscreenSurface$egloo_metadata_release(i, i2));
        Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        setWidth(i);
        setHeight(i2);
    }
}
