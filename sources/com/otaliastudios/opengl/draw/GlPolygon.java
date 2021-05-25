package com.otaliastudios.opengl.draw;

import a2.g.r.g;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.avito.android.remote.auth.AuthSource;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.extensions.MatrixKt;
import com.otaliastudios.opengl.internal.GlKt;
import com.otaliastudios.opengl.types.BuffersJvmKt;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004R*\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0019\u001a\u00060\u0011j\u0002`\u00128\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R,\u0010(\u001a\u00060\"j\u0002`#2\n\u0010\t\u001a\u00060\"j\u0002`#8F@FX\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010\u000bR*\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR*\u00102\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010\u000bR\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010\u000bR\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010\u000b¨\u0006;"}, d2 = {"Lcom/otaliastudios/opengl/draw/GlPolygon;", "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "", "onViewportSizeChanged", "()V", "draw", AuthSource.BOOKING_ORDER, AuthSource.SEND_ABUSE, "", "value", "k", "F", "getRadius", "()F", "setRadius", "(F)V", "radius", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "o", "Ljava/nio/FloatBuffer;", "getVertexArray", "()Ljava/nio/FloatBuffer;", "setVertexArray", "(Ljava/nio/FloatBuffer;)V", "vertexArray", "n", "getCenterY", "setCenterY", "centerY", "", "p", "I", "sides", "Landroid/graphics/PointF;", "Lcom/otaliastudios/opengl/geometry/PointF;", "getCenter", "()Landroid/graphics/PointF;", "setCenter", "(Landroid/graphics/PointF;)V", "center", "j", "viewportScaleY", "l", "getRotation", "setRotation", "rotation", AuthSource.OPEN_CHANNEL_LIST, "getCenterX", "setCenterX", "centerX", g.a, "viewportTranslationX", "h", "viewportTranslationY", "i", "viewportScaleX", "<init>", "(I)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class GlPolygon extends Gl2dDrawable {
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    @NotNull
    public FloatBuffer o;
    public final int p;

    public GlPolygon(int i2) {
        this.p = i2;
        if (i2 >= 3) {
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 1.0f;
            this.o = BuffersJvmKt.floatBuffer(getCoordsPerVertex() * (i2 + 2));
            b();
            return;
        }
        throw new IllegalArgumentException("Polygon should have at least 3 sides.");
    }

    public final void a() {
        MatrixKt.scale$default(getModelMatrix(), 1.0f / this.i, 1.0f / this.j, 0.0f, 4, null);
        MatrixKt.translate$default(getModelMatrix(), -this.g, -this.h, 0.0f, 4, null);
        if (getViewportWidth() > getViewportHeight()) {
            float viewportHeight = ((float) getViewportHeight()) / ((float) getViewportWidth());
            this.i = viewportHeight;
            this.j = 1.0f;
            this.g = (((float) 1) - viewportHeight) * this.m;
            this.h = 0.0f;
        } else if (getViewportWidth() < getViewportHeight()) {
            float viewportWidth = ((float) getViewportWidth()) / ((float) getViewportHeight());
            this.j = viewportWidth;
            this.i = 1.0f;
            this.h = (((float) 1) - viewportWidth) * this.n;
            this.g = 0.0f;
        } else {
            this.i = 1.0f;
            this.j = 1.0f;
            this.g = 0.0f;
            this.h = 0.0f;
        }
        MatrixKt.translate$default(getModelMatrix(), this.g, this.h, 0.0f, 4, null);
        MatrixKt.scale$default(getModelMatrix(), this.i, this.j, 0.0f, 4, null);
    }

    public final void b() {
        FloatBuffer vertexArray = getVertexArray();
        vertexArray.clear();
        vertexArray.put(this.m);
        vertexArray.put(this.n);
        float f = this.l * ((float) 0.017453292519943295d);
        int i2 = this.p;
        float f2 = ((float) 6.283185307179586d) / ((float) i2);
        for (int i3 = 0; i3 < i2; i3++) {
            double d = (double) f;
            vertexArray.put((this.k * ((float) Math.cos(d))) + this.m);
            vertexArray.put((this.k * ((float) Math.sin(d))) + this.n);
            f += f2;
        }
        vertexArray.put(vertexArray.get(2));
        vertexArray.put(vertexArray.get(3));
        vertexArray.flip();
        notifyVertexArrayChange();
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void draw() {
        GLES20.glDrawArrays(GlKt.getGL_TRIANGLE_FAN(), 0, getVertexCount());
        Egloo.checkGlError("glDrawArrays");
    }

    @NotNull
    public final PointF getCenter() {
        return new PointF(this.m, this.n);
    }

    public final float getCenterX() {
        return this.m;
    }

    public final float getCenterY() {
        return this.n;
    }

    public final float getRadius() {
        return this.k;
    }

    public final float getRotation() {
        return this.l;
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    @NotNull
    public FloatBuffer getVertexArray() {
        return this.o;
    }

    @Override // com.otaliastudios.opengl.core.GlViewportAware
    public void onViewportSizeChanged() {
        super.onViewportSizeChanged();
        a();
    }

    public final void setCenter(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "value");
        setCenterX(pointF.x);
        setCenterY(pointF.y);
    }

    public final void setCenterX(float f) {
        this.m = f;
        b();
        a();
    }

    public final void setCenterY(float f) {
        this.n = f;
        b();
        a();
    }

    public final void setRadius(float f) {
        this.k = f;
        b();
    }

    public final void setRotation(float f) {
        this.l = f % ((float) 360);
        b();
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void setVertexArray(@NotNull FloatBuffer floatBuffer) {
        Intrinsics.checkNotNullParameter(floatBuffer, "<set-?>");
        this.o = floatBuffer;
    }
}
