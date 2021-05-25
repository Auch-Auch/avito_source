package com.otaliastudios.opengl.draw;

import a2.g.r.g;
import android.graphics.RectF;
import android.opengl.GLES20;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.internal.GlKt;
import com.otaliastudios.opengl.types.BuffersJvmKt;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0018JC\u0010#\u001a\u00020\u00042\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0002H\u0002¢\u0006\u0004\b#\u0010$R&\u0010+\u001a\u00060\u001bj\u0002`\u001c8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00101\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010-R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00104\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00106\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010-R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010-¨\u0006:"}, d2 = {"Lcom/otaliastudios/opengl/draw/GlRoundRect;", "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "", "corners", "", "setCornersPx", "(I)V", "topLeft", "topRight", "bottomLeft", "bottomRight", "(IIII)V", "Landroid/graphics/RectF;", "Lcom/otaliastudios/opengl/geometry/RectF;", "rect", "setRect", "(Landroid/graphics/RectF;)V", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "(FFFF)V", "onViewportSizeChanged", "()V", "draw", AuthSource.BOOKING_ORDER, "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "array", "pivotX", "pivotY", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "startAngle", AuthSource.SEND_ABUSE, "(Ljava/nio/FloatBuffer;FFFFI)V", "o", "Ljava/nio/FloatBuffer;", "getVertexArray", "()Ljava/nio/FloatBuffer;", "setVertexArray", "(Ljava/nio/FloatBuffer;)V", "vertexArray", "l", "F", AuthSource.OPEN_CHANNEL_LIST, "k", "i", "bottomLeftCorner", "n", g.a, "topLeftCorner", "h", "topRightCorner", "j", "bottomRightCorner", "<init>", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class GlRoundRect extends Gl2dDrawable {
    public float g;
    public float h;
    public float i;
    public float j;
    public float k = 1.0f;
    public float l = -1.0f;
    public float m = -1.0f;
    public float n = 1.0f;
    @NotNull
    public FloatBuffer o = BuffersJvmKt.floatBuffer(getCoordsPerVertex() * 82);

    public GlRoundRect() {
        b();
    }

    public final void a(FloatBuffer floatBuffer, float f, float f2, float f3, float f4, int i2) {
        int i3 = i2 - 90;
        float f5 = 1.0f / ((float) 19);
        float f6 = 0.0f;
        for (int i4 = 0; i4 < 20; i4++) {
            double d = (double) ((float) ((((double) ((((float) (i3 - i2)) * f6) + ((float) i2))) * 3.141592653589793d) / ((double) 180)));
            double d2 = (double) 2;
            float sqrt = (f3 * f4) / ((float) Math.sqrt((double) (((float) Math.pow((double) (((float) Math.sin(d)) * f3), d2)) + ((float) Math.pow((double) (((float) Math.cos(d)) * f4), d2)))));
            floatBuffer.put((((float) Math.cos(d)) * sqrt) + f);
            floatBuffer.put((sqrt * ((float) Math.sin(d))) + f2);
            f6 += f5;
        }
    }

    public final void b() {
        FloatBuffer vertexArray = getVertexArray();
        vertexArray.clear();
        vertexArray.put((this.n + this.m) / 2.0f);
        vertexArray.put((this.k + this.l) / 2.0f);
        boolean z = true;
        boolean z2 = getViewportHeight() > 0 && getViewportWidth() > 0;
        if (z2 && this.g > 0.0f) {
            float viewportWidth = (this.g / ((float) getViewportWidth())) * 2.0f;
            float viewportHeight = (this.g / ((float) getViewportHeight())) * 2.0f;
            a(vertexArray, this.m + viewportWidth, this.k - viewportHeight, viewportWidth, viewportHeight, 180);
        } else {
            vertexArray.put(this.m);
            vertexArray.put(this.k);
        }
        if (z2 && this.h > 0.0f) {
            float viewportWidth2 = (this.h / ((float) getViewportWidth())) * 2.0f;
            float viewportHeight2 = (this.h / ((float) getViewportHeight())) * 2.0f;
            a(vertexArray, this.n - viewportWidth2, this.k - viewportHeight2, viewportWidth2, viewportHeight2, 90);
        } else {
            vertexArray.put(this.n);
            vertexArray.put(this.k);
        }
        if (z2 && this.j > 0.0f) {
            float viewportWidth3 = (this.j / ((float) getViewportWidth())) * 2.0f;
            float viewportHeight3 = (this.j / ((float) getViewportHeight())) * 2.0f;
            a(vertexArray, this.n - viewportWidth3, this.l + viewportHeight3, viewportWidth3, viewportHeight3, 0);
        } else {
            vertexArray.put(this.n);
            vertexArray.put(this.l);
        }
        if (!z2 || this.i <= 0.0f) {
            z = false;
        }
        if (z) {
            float viewportWidth4 = (this.i / ((float) getViewportWidth())) * 2.0f;
            float viewportHeight4 = (this.i / ((float) getViewportHeight())) * 2.0f;
            a(vertexArray, this.m + viewportWidth4, this.l + viewportHeight4, viewportWidth4, viewportHeight4, -90);
        } else {
            vertexArray.put(this.m);
            vertexArray.put(this.l);
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

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    @NotNull
    public FloatBuffer getVertexArray() {
        return this.o;
    }

    @Override // com.otaliastudios.opengl.core.GlViewportAware
    public void onViewportSizeChanged() {
        super.onViewportSizeChanged();
        b();
    }

    public final void setCornersPx(int i2) {
        setCornersPx(i2, i2, i2, i2);
    }

    public final void setRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        setRect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void setVertexArray(@NotNull FloatBuffer floatBuffer) {
        Intrinsics.checkNotNullParameter(floatBuffer, "<set-?>");
        this.o = floatBuffer;
    }

    public final void setCornersPx(int i2, int i3, int i4, int i5) {
        this.g = (float) i2;
        this.h = (float) i3;
        this.i = (float) i4;
        this.j = (float) i5;
        b();
    }

    public final void setRect(float f, float f2, float f3, float f4) {
        this.m = f;
        this.k = f2;
        this.n = f3;
        this.l = f4;
        b();
    }
}
