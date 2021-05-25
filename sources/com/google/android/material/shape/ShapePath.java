package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;
public class ShapePath {
    public static final float ANGLE_LEFT = 180.0f;
    public final List<PathOperation> a = new ArrayList();
    public final List<c> b = new ArrayList();
    public boolean c;
    @Deprecated
    public float currentShadowAngle;
    @Deprecated
    public float endShadowAngle;
    @Deprecated
    public float endX;
    @Deprecated
    public float endY;
    @Deprecated
    public float startX;
    @Deprecated
    public float startY;

    public static class PathArcOperation extends PathOperation {
        public static final RectF a = new RectF();
        @Deprecated
        public float bottom;
        @Deprecated
        public float left;
        @Deprecated
        public float right;
        @Deprecated
        public float startAngle;
        @Deprecated
        public float sweepAngle;
        @Deprecated
        public float top;

        public PathArcOperation(float f, float f2, float f3, float f4) {
            this.left = f;
            this.top = f2;
            this.right = f3;
            this.bottom = f4;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = a;
            rectF.set(this.left, this.top, this.right, this.bottom);
            path.arcTo(rectF, this.startAngle, this.sweepAngle, false);
            path.transform(matrix);
        }
    }

    public static class PathCubicOperation extends PathOperation {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;

        public PathCubicOperation(float f2, float f3, float f4, float f5, float f6, float f7) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = f5;
            this.e = f6;
            this.f = f7;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.a, this.b, this.c, this.d, this.e, this.f);
            path.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {
        public float a;
        public float b;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.a, this.b);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {
        public final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix2, Path path);
    }

    public static class PathQuadOperation extends PathOperation {
        @Deprecated
        public float controlX;
        @Deprecated
        public float controlY;
        @Deprecated
        public float endX;
        @Deprecated
        public float endY;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(this.controlX, this.controlY, this.endX, this.endY);
            path.transform(matrix);
        }
    }

    public static class a extends c {
        public final PathArcOperation b;

        public a(PathArcOperation pathArcOperation) {
            this.b = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.c
        public void a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i, @NonNull Canvas canvas) {
            PathArcOperation pathArcOperation = this.b;
            float f = pathArcOperation.startAngle;
            float f2 = pathArcOperation.sweepAngle;
            PathArcOperation pathArcOperation2 = this.b;
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(pathArcOperation2.left, pathArcOperation2.top, pathArcOperation2.right, pathArcOperation2.bottom), i, f, f2);
        }
    }

    public static class b extends c {
        public final PathLineOperation b;
        public final float c;
        public final float d;

        public b(PathLineOperation pathLineOperation, float f, float f2) {
            this.b = pathLineOperation;
            this.c = f;
            this.d = f2;
        }

        @Override // com.google.android.material.shape.ShapePath.c
        public void a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i, @NonNull Canvas canvas) {
            PathLineOperation pathLineOperation = this.b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (pathLineOperation.b - this.d), (double) (pathLineOperation.a - this.c)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.c, this.d);
            matrix2.preRotate(b());
            shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i);
        }

        public float b() {
            PathLineOperation pathLineOperation = this.b;
            return (float) Math.toDegrees(Math.atan((double) ((pathLineOperation.b - this.d) / (pathLineOperation.a - this.c))));
        }
    }

    public static abstract class c {
        public static final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas);
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    public final void a(float f) {
        float f2 = this.currentShadowAngle;
        if (f2 != f) {
            float f3 = ((f - f2) + 360.0f) % 360.0f;
            if (f3 <= 180.0f) {
                float f4 = this.endX;
                float f5 = this.endY;
                PathArcOperation pathArcOperation = new PathArcOperation(f4, f5, f4, f5);
                pathArcOperation.startAngle = this.currentShadowAngle;
                pathArcOperation.sweepAngle = f3;
                this.b.add(new a(pathArcOperation));
                this.currentShadowAngle = f;
            }
        }
    }

    public void addArc(float f, float f2, float f3, float f4, float f5, float f6) {
        PathArcOperation pathArcOperation = new PathArcOperation(f, f2, f3, f4);
        pathArcOperation.startAngle = f5;
        pathArcOperation.sweepAngle = f6;
        this.a.add(pathArcOperation);
        a aVar = new a(pathArcOperation);
        float f7 = f5 + f6;
        boolean z = f6 < 0.0f;
        if (z) {
            f5 = (f5 + 180.0f) % 360.0f;
        }
        float f8 = z ? (180.0f + f7) % 360.0f : f7;
        a(f5);
        this.b.add(aVar);
        this.currentShadowAngle = f8;
        double d = (double) f7;
        this.endX = (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))) + ((f + f3) * 0.5f);
        this.endY = (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))) + ((f2 + f4) * 0.5f);
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).applyToPath(matrix, path);
        }
    }

    @RequiresApi(21)
    public void cubicToPoint(float f, float f2, float f3, float f4, float f5, float f6) {
        this.a.add(new PathCubicOperation(f, f2, f3, f4, f5, f6));
        this.c = true;
        this.endX = f5;
        this.endY = f6;
    }

    public void lineTo(float f, float f2) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.a = f;
        pathLineOperation.b = f2;
        this.a.add(pathLineOperation);
        b bVar = new b(pathLineOperation, this.endX, this.endY);
        a(bVar.b() + 270.0f);
        this.b.add(bVar);
        this.currentShadowAngle = bVar.b() + 270.0f;
        this.endX = f;
        this.endY = f2;
    }

    @RequiresApi(21)
    public void quadToPoint(float f, float f2, float f3, float f4) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.controlX = f;
        pathQuadOperation.controlY = f2;
        pathQuadOperation.endX = f3;
        pathQuadOperation.endY = f4;
        this.a.add(pathQuadOperation);
        this.c = true;
        this.endX = f3;
        this.endY = f4;
    }

    public void reset(float f, float f2) {
        reset(f, f2, 270.0f, 0.0f);
    }

    public void reset(float f, float f2, float f3, float f4) {
        this.startX = f;
        this.startY = f2;
        this.endX = f;
        this.endY = f2;
        this.currentShadowAngle = f3;
        this.endShadowAngle = (f3 + f4) % 360.0f;
        this.a.clear();
        this.b.clear();
        this.c = false;
    }

    public ShapePath(float f, float f2) {
        reset(f, f2);
    }
}
