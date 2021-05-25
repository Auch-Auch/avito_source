package com.otaliastudios.opengl.draw;

import a2.g.r.g;
import android.graphics.RectF;
import android.opengl.GLES20;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.internal.GlKt;
import com.otaliastudios.opengl.types.BuffersJvmKt;
import java.nio.FloatBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0017¢\u0006\u0004\b\u0005\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u000b\u0010\nJ-\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u000b\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R&\u0010\u001b\u001a\u00060\u0014j\u0002`\u00158\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u0005\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/otaliastudios/opengl/draw/GlRect;", "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "", "array", "", "setVertexArray", "([F)V", "Landroid/graphics/RectF;", "Lcom/otaliastudios/opengl/geometry/RectF;", "rect", "(Landroid/graphics/RectF;)V", "setRect", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "(FFFF)V", "draw", "()V", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", g.a, "Ljava/nio/FloatBuffer;", "getVertexArray", "()Ljava/nio/FloatBuffer;", "(Ljava/nio/FloatBuffer;)V", "vertexArray", "<init>", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class GlRect extends Gl2dDrawable {
    public static final float[] h = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    @NotNull
    public FloatBuffer g;

    public GlRect() {
        float[] fArr = h;
        FloatBuffer floatBuffer = BuffersJvmKt.floatBuffer(fArr.length);
        floatBuffer.put(fArr);
        floatBuffer.clear();
        this.g = floatBuffer;
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void draw() {
        Egloo.checkGlError("glDrawArrays start");
        GLES20.glDrawArrays(GlKt.getGL_TRIANGLE_STRIP(), 0, getVertexCount());
        Egloo.checkGlError("glDrawArrays end");
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    @NotNull
    public FloatBuffer getVertexArray() {
        return this.g;
    }

    public final void setRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        setRect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void setVertexArray(@NotNull FloatBuffer floatBuffer) {
        Intrinsics.checkNotNullParameter(floatBuffer, "<set-?>");
        this.g = floatBuffer;
    }

    public final void setRect(float f, float f2, float f3, float f4) {
        getVertexArray().clear();
        getVertexArray().put(f);
        getVertexArray().put(f4);
        getVertexArray().put(f3);
        getVertexArray().put(f4);
        getVertexArray().put(f);
        getVertexArray().put(f2);
        getVertexArray().put(f3);
        getVertexArray().put(f2);
        getVertexArray().flip();
        notifyVertexArrayChange();
    }

    @Deprecated(message = "Use setRect", replaceWith = @ReplaceWith(expression = "setRect(rect)", imports = {}))
    public void setVertexArray(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "array");
        if (fArr.length == getCoordsPerVertex() * 4) {
            getVertexArray().clear();
            getVertexArray().put(fArr);
            getVertexArray().flip();
            notifyVertexArrayChange();
            return;
        }
        throw new IllegalArgumentException("Vertex array should have 8 values.");
    }

    @Deprecated(message = "Use setRect", replaceWith = @ReplaceWith(expression = "setRect(rect)", imports = {}))
    public void setVertexArray(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        setRect(rectF);
    }
}
