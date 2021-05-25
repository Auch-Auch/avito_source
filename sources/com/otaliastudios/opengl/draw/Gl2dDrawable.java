package com.otaliastudios.opengl.draw;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\r\u001a\u00020\b8\u0006@\u0006XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "Lcom/otaliastudios/opengl/draw/GlDrawable;", "Landroid/graphics/RectF;", "Lcom/otaliastudios/opengl/geometry/RectF;", "rect", "", "getBounds", "(Landroid/graphics/RectF;)V", "", "f", "I", "getCoordsPerVertex", "()I", "coordsPerVertex", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public abstract class Gl2dDrawable extends GlDrawable {
    public final int f = 2;

    public final void getBounds(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MAX_VALUE;
        float f4 = -3.4028235E38f;
        float f5 = -3.4028235E38f;
        int i = 0;
        while (getVertexArray().hasRemaining()) {
            float f6 = getVertexArray().get();
            if (i % 2 == 0) {
                f2 = Math.min(f2, f6);
                f5 = Math.max(f5, f6);
            } else {
                f4 = Math.max(f4, f6);
                f3 = Math.min(f3, f6);
            }
            i++;
        }
        getVertexArray().rewind();
        rectF.set(f2, f4, f5, f3);
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public final int getCoordsPerVertex() {
        return this.f;
    }
}
