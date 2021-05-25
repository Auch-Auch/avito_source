package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
public class ShapeAppearancePathProvider {
    public final ShapePath[] a = new ShapePath[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final ShapePath g = new ShapePath();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public final Path j = new Path();
    public final Path k = new Path();
    public boolean l = true;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i);
    }

    public static class a {
        public static final ShapeAppearancePathProvider a = new ShapeAppearancePathProvider();
    }

    public ShapeAppearancePathProvider() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.a[i2] = new ShapePath();
            this.b[i2] = new Matrix();
            this.c[i2] = new Matrix();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static ShapeAppearancePathProvider getInstance() {
        return a.a;
    }

    @RequiresApi(19)
    public final boolean a(Path path, int i2) {
        this.k.reset();
        this.a[i2].applyToPath(this.b[i2], this.k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.k.computeBounds(rectF, true);
        path.op(this.k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() <= 1.0f || rectF.height() <= 1.0f) {
            return false;
        }
        return true;
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, f2, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f2, RectF rectF, PathListener pathListener, @NonNull Path path) {
        int i2;
        float f3;
        EdgeTreatment edgeTreatment;
        CornerSize cornerSize;
        CornerTreatment cornerTreatment;
        path.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(rectF, Path.Direction.CW);
        int i3 = 0;
        while (true) {
            if (i3 >= 4) {
                break;
            }
            if (i3 == 1) {
                cornerSize = shapeAppearanceModel.getBottomRightCornerSize();
            } else if (i3 == 2) {
                cornerSize = shapeAppearanceModel.getBottomLeftCornerSize();
            } else if (i3 != 3) {
                cornerSize = shapeAppearanceModel.getTopRightCornerSize();
            } else {
                cornerSize = shapeAppearanceModel.getTopLeftCornerSize();
            }
            if (i3 == 1) {
                cornerTreatment = shapeAppearanceModel.getBottomRightCorner();
            } else if (i3 == 2) {
                cornerTreatment = shapeAppearanceModel.getBottomLeftCorner();
            } else if (i3 != 3) {
                cornerTreatment = shapeAppearanceModel.getTopRightCorner();
            } else {
                cornerTreatment = shapeAppearanceModel.getTopLeftCorner();
            }
            cornerTreatment.getCornerPath(this.a[i3], 90.0f, f2, rectF, cornerSize);
            int i4 = i3 + 1;
            float f4 = (float) (i4 * 90);
            this.b[i3].reset();
            PointF pointF = this.d;
            if (i3 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i3 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i3 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
            Matrix matrix = this.b[i3];
            PointF pointF2 = this.d;
            matrix.setTranslate(pointF2.x, pointF2.y);
            this.b[i3].preRotate(f4);
            float[] fArr = this.h;
            ShapePath[] shapePathArr = this.a;
            fArr[0] = shapePathArr[i3].endX;
            fArr[1] = shapePathArr[i3].endY;
            this.b[i3].mapPoints(fArr);
            this.c[i3].reset();
            Matrix matrix2 = this.c[i3];
            float[] fArr2 = this.h;
            matrix2.setTranslate(fArr2[0], fArr2[1]);
            this.c[i3].preRotate(f4);
            i3 = i4;
        }
        int i5 = 0;
        for (i2 = 4; i5 < i2; i2 = 4) {
            float[] fArr3 = this.h;
            ShapePath[] shapePathArr2 = this.a;
            fArr3[0] = shapePathArr2[i5].startX;
            fArr3[1] = shapePathArr2[i5].startY;
            this.b[i5].mapPoints(fArr3);
            if (i5 == 0) {
                float[] fArr4 = this.h;
                path.moveTo(fArr4[0], fArr4[1]);
            } else {
                float[] fArr5 = this.h;
                path.lineTo(fArr5[0], fArr5[1]);
            }
            this.a[i5].applyToPath(this.b[i5], path);
            if (pathListener != null) {
                pathListener.onCornerPathCreated(this.a[i5], this.b[i5], i5);
            }
            int i6 = i5 + 1;
            int i7 = i6 % 4;
            float[] fArr6 = this.h;
            ShapePath[] shapePathArr3 = this.a;
            fArr6[0] = shapePathArr3[i5].endX;
            fArr6[1] = shapePathArr3[i5].endY;
            this.b[i5].mapPoints(fArr6);
            float[] fArr7 = this.i;
            ShapePath[] shapePathArr4 = this.a;
            fArr7[0] = shapePathArr4[i7].startX;
            fArr7[1] = shapePathArr4[i7].startY;
            this.b[i7].mapPoints(fArr7);
            float[] fArr8 = this.h;
            float f5 = fArr8[0];
            float[] fArr9 = this.i;
            float max = Math.max(((float) Math.hypot((double) (f5 - fArr9[0]), (double) (fArr8[1] - fArr9[1]))) - 0.001f, 0.0f);
            float[] fArr10 = this.h;
            ShapePath[] shapePathArr5 = this.a;
            fArr10[0] = shapePathArr5[i5].endX;
            fArr10[1] = shapePathArr5[i5].endY;
            this.b[i5].mapPoints(fArr10);
            if (i5 == 1 || i5 == 3) {
                f3 = Math.abs(rectF.centerX() - this.h[0]);
            } else {
                f3 = Math.abs(rectF.centerY() - this.h[1]);
            }
            this.g.reset(0.0f, 0.0f);
            if (i5 == 1) {
                edgeTreatment = shapeAppearanceModel.getBottomEdge();
            } else if (i5 == 2) {
                edgeTreatment = shapeAppearanceModel.getLeftEdge();
            } else if (i5 != 3) {
                edgeTreatment = shapeAppearanceModel.getRightEdge();
            } else {
                edgeTreatment = shapeAppearanceModel.getTopEdge();
            }
            edgeTreatment.getEdgePath(max, f3, f2, this.g);
            this.j.reset();
            this.g.applyToPath(this.c[i5], this.j);
            if (!this.l || (!edgeTreatment.a() && !a(this.j, i5) && !a(this.j, i7))) {
                this.g.applyToPath(this.c[i5], path);
            } else {
                Path path2 = this.j;
                path2.op(path2, this.f, Path.Op.DIFFERENCE);
                float[] fArr11 = this.h;
                ShapePath shapePath = this.g;
                fArr11[0] = shapePath.startX;
                fArr11[1] = shapePath.startY;
                this.c[i5].mapPoints(fArr11);
                Path path3 = this.e;
                float[] fArr12 = this.h;
                path3.moveTo(fArr12[0], fArr12[1]);
                this.g.applyToPath(this.c[i5], this.e);
            }
            if (pathListener != null) {
                pathListener.onEdgePathCreated(this.g, this.c[i5], i5);
            }
            i5 = i6;
        }
        path.close();
        this.e.close();
        if (!this.e.isEmpty()) {
            path.op(this.e, Path.Op.UNION);
        }
    }
}
