package com.otaliastudios.opengl.draw;

import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.core.GlViewportAware;
import com.otaliastudios.opengl.internal.MiscKt;
import com.otaliastudios.opengl.types.BuffersKt;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\tR \u0010 \u001a\u00060\u001aj\u0002`\u001b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/otaliastudios/opengl/draw/GlDrawable;", "Lcom/otaliastudios/opengl/core/GlViewportAware;", "", "draw", "()V", "notifyVertexArrayChange", "release", "", "getVertexCount", "()I", "vertexCount", "getVertexStride", "vertexStride", "", "d", "[F", "getModelMatrix", "()[F", "modelMatrix", "getCoordsPerVertex", "coordsPerVertex", "<set-?>", "e", "I", "getVertexArrayVersion", "vertexArrayVersion", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "getVertexArray", "()Ljava/nio/FloatBuffer;", "setVertexArray", "(Ljava/nio/FloatBuffer;)V", "vertexArray", "<init>", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public abstract class GlDrawable extends GlViewportAware {
    @NotNull
    public final float[] d = MiscKt.matrixClone(Egloo.IDENTITY_MATRIX);
    public int e;

    public abstract void draw();

    public abstract int getCoordsPerVertex();

    @NotNull
    public final float[] getModelMatrix() {
        return this.d;
    }

    @NotNull
    public abstract FloatBuffer getVertexArray();

    public final int getVertexArrayVersion() {
        return this.e;
    }

    public int getVertexCount() {
        return getVertexArray().limit() / getCoordsPerVertex();
    }

    public int getVertexStride() {
        return getCoordsPerVertex() * 4;
    }

    public final void notifyVertexArrayChange() {
        this.e++;
    }

    public void release() {
        BuffersKt.dispose(getVertexArray());
    }

    public abstract void setVertexArray(@NotNull FloatBuffer floatBuffer);
}
