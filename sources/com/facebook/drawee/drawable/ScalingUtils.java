package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
public class ScalingUtils {

    public static abstract class AbstractScaleType implements ScaleType {
        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            getTransformImpl(matrix, rect, i, i2, f, f2, ((float) rect.width()) / ((float) i), ((float) rect.height()) / ((float) i2));
            return matrix;
        }

        public abstract void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4);
    }

    public interface ScaleType {
        public static final ScaleType CENTER = a.a;
        public static final ScaleType CENTER_CROP = b.a;
        public static final ScaleType CENTER_INSIDE = c.a;
        public static final ScaleType FIT_BOTTOM_START = d.a;
        public static final ScaleType FIT_CENTER = e.a;
        public static final ScaleType FIT_END = f.a;
        public static final ScaleType FIT_START = g.a;
        public static final ScaleType FIT_X = h.a;
        public static final ScaleType FIT_XY = i.a;
        public static final ScaleType FIT_Y = j.a;
        public static final ScaleType FOCUS_CROP = k.a;

        Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2);
    }

    public interface StatefulScaleType {
        Object getState();
    }

    public static class a extends AbstractScaleType {
        public static final ScaleType a = new a();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            matrix.setTranslate((float) ((int) ((((float) (rect.width() - i)) * 0.5f) + ((float) rect.left) + 0.5f)), (float) ((int) ((((float) (rect.height() - i2)) * 0.5f) + ((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "center";
        }
    }

    public static class b extends AbstractScaleType {
        public static final ScaleType a = new b();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float f5;
            float f6;
            if (f4 > f3) {
                f5 = ((((float) rect.width()) - (((float) i) * f4)) * 0.5f) + ((float) rect.left);
                f6 = (float) rect.top;
                f3 = f4;
            } else {
                f5 = (float) rect.left;
                f6 = ((((float) rect.height()) - (((float) i2) * f3)) * 0.5f) + ((float) rect.top);
            }
            matrix.setScale(f3, f3);
            matrix.postTranslate((float) ((int) (f5 + 0.5f)), (float) ((int) (f6 + 0.5f)));
        }

        public String toString() {
            return "center_crop";
        }
    }

    public static class c extends AbstractScaleType {
        public static final ScaleType a = new c();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(Math.min(f3, f4), 1.0f);
            float width = ((((float) rect.width()) - (((float) i) * min)) * 0.5f) + ((float) rect.left);
            float height = (((float) rect.height()) - (((float) i2) * min)) * 0.5f;
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + ((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "center_inside";
        }
    }

    public static class d extends AbstractScaleType {
        public static final ScaleType a = new d();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            float height = ((float) rect.height()) - (((float) i2) * min);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (height + ((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_bottom_start";
        }
    }

    public static class e extends AbstractScaleType {
        public static final ScaleType a = new e();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            float width = ((((float) rect.width()) - (((float) i) * min)) * 0.5f) + ((float) rect.left);
            float height = (((float) rect.height()) - (((float) i2) * min)) * 0.5f;
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + ((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_center";
        }
    }

    public static class f extends AbstractScaleType {
        public static final ScaleType a = new f();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            float width = ((float) rect.width()) - (((float) i) * min);
            float height = ((float) rect.height()) - (((float) i2) * min);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (width + ((float) rect.left) + 0.5f)), (float) ((int) (height + ((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_end";
        }
    }

    public static class g extends AbstractScaleType {
        public static final ScaleType a = new g();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_start";
        }
    }

    public static class h extends AbstractScaleType {
        public static final ScaleType a = new h();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float height = (((float) rect.height()) - (((float) i2) * f3)) * 0.5f;
            matrix.setScale(f3, f3);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (height + ((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_x";
        }
    }

    public static class i extends AbstractScaleType {
        public static final ScaleType a = new i();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            matrix.setScale(f3, f4);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_xy";
        }
    }

    public static class j extends AbstractScaleType {
        public static final ScaleType a = new j();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float width = (((float) rect.width()) - (((float) i) * f4)) * 0.5f;
            matrix.setScale(f4, f4);
            matrix.postTranslate((float) ((int) (width + ((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_y";
        }
    }

    public static class k extends AbstractScaleType {
        public static final ScaleType a = new k();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float f5;
            float f6;
            if (f4 > f3) {
                float f7 = ((float) i) * f4;
                f5 = Math.max(Math.min((((float) rect.width()) * 0.5f) - (f * f7), 0.0f), ((float) rect.width()) - f7) + ((float) rect.left);
                f6 = (float) rect.top;
                f3 = f4;
            } else {
                f5 = (float) rect.left;
                float f8 = ((float) i2) * f3;
                f6 = Math.max(Math.min((((float) rect.height()) * 0.5f) - (f2 * f8), 0.0f), ((float) rect.height()) - f8) + ((float) rect.top);
            }
            matrix.setScale(f3, f3);
            matrix.postTranslate((float) ((int) (f5 + 0.5f)), (float) ((int) (f6 + 0.5f)));
        }

        public String toString() {
            return "focus_crop";
        }
    }

    @Nullable
    public static ScaleTypeDrawable getActiveScaleTypeDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof DrawableParent) {
            return getActiveScaleTypeDrawable(((DrawableParent) drawable).getDrawable());
        }
        if (drawable instanceof ArrayDrawable) {
            ArrayDrawable arrayDrawable = (ArrayDrawable) drawable;
            int numberOfLayers = arrayDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                ScaleTypeDrawable activeScaleTypeDrawable = getActiveScaleTypeDrawable(arrayDrawable.getDrawable(i2));
                if (activeScaleTypeDrawable != null) {
                    return activeScaleTypeDrawable;
                }
            }
        }
        return null;
    }

    public static class InterpolatingScaleType implements ScaleType, StatefulScaleType {
        public final ScaleType a;
        public final ScaleType b;
        @Nullable
        public final Rect c;
        @Nullable
        public final Rect d;
        @Nullable
        public final PointF e;
        @Nullable
        public final PointF f;
        public final float[] g;
        public final float[] h;
        public final float[] i;
        public float j;

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, @Nullable Rect rect, @Nullable Rect rect2, @Nullable PointF pointF, @Nullable PointF pointF2) {
            this.g = new float[9];
            this.h = new float[9];
            this.i = new float[9];
            this.a = scaleType;
            this.b = scaleType2;
            this.c = rect;
            this.d = rect2;
            this.e = pointF;
            this.f = pointF2;
        }

        @Nullable
        public Rect getBoundsFrom() {
            return this.c;
        }

        @Nullable
        public Rect getBoundsTo() {
            return this.d;
        }

        @Nullable
        public PointF getFocusPointFrom() {
            return this.e;
        }

        @Nullable
        public PointF getFocusPointTo() {
            return this.f;
        }

        public ScaleType getScaleTypeFrom() {
            return this.a;
        }

        public ScaleType getScaleTypeTo() {
            return this.b;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType
        public Object getState() {
            return Float.valueOf(this.j);
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            Rect rect2 = this.c;
            Rect rect3 = rect2 != null ? rect2 : rect;
            Rect rect4 = this.d;
            Rect rect5 = rect4 != null ? rect4 : rect;
            ScaleType scaleType = this.a;
            PointF pointF = this.e;
            scaleType.getTransform(matrix, rect3, i2, i3, pointF == null ? f2 : pointF.x, pointF == null ? f3 : pointF.y);
            matrix.getValues(this.g);
            ScaleType scaleType2 = this.b;
            PointF pointF2 = this.f;
            scaleType2.getTransform(matrix, rect5, i2, i3, pointF2 == null ? f2 : pointF2.x, pointF2 == null ? f3 : pointF2.y);
            matrix.getValues(this.h);
            for (int i4 = 0; i4 < 9; i4++) {
                float[] fArr = this.i;
                float f4 = this.g[i4];
                float f5 = this.j;
                fArr[i4] = (this.h[i4] * f5) + ((1.0f - f5) * f4);
            }
            matrix.setValues(this.i);
            return matrix;
        }

        public float getValue() {
            return this.j;
        }

        public void setValue(float f2) {
            this.j = f2;
        }

        public String toString() {
            return String.format("InterpolatingScaleType(%s (%s) -> %s (%s))", String.valueOf(this.a), String.valueOf(this.e), String.valueOf(this.b), String.valueOf(this.f));
        }

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, @Nullable Rect rect, @Nullable Rect rect2) {
            this(scaleType, scaleType2, rect, rect2, null, null);
        }

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2) {
            this(scaleType, scaleType2, null, null);
        }
    }
}
