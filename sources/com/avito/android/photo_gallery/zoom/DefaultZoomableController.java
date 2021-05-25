package com.avito.android.photo_gallery.zoom;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.avito.android.photo_gallery.zoom.ZoomableController;
import com.avito.android.photo_gallery.zoom.gestures.TransformGestureDetector;
import com.facebook.common.logging.FLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class DefaultZoomableController implements ZoomableController, TransformGestureDetector.Listener {
    public static final int LIMIT_ALL = 11;
    public static final int LIMIT_NONE = 0;
    public static final int LIMIT_SCALE = 8;
    public static final int LIMIT_TRANSLATION_X = 1;
    public static final int LIMIT_TRANSLATION_Y = 2;
    public static final RectF r = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public TransformGestureDetector a;
    @Nullable
    public ZoomableController.Listener b = null;
    public boolean c = false;
    public boolean d = false;
    public boolean e = true;
    public boolean f = true;
    public float g = 1.0f;
    public float h = 8.0f;
    public final RectF i = new RectF();
    public final RectF j = new RectF();
    public final RectF k = new RectF();
    public final Matrix l = new Matrix();
    public final Matrix m = new Matrix();
    public final Matrix n = new Matrix();
    public final float[] o = new float[9];
    public final RectF p = new RectF();
    public boolean q;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LimitFlag {
    }

    public DefaultZoomableController(TransformGestureDetector transformGestureDetector) {
        this.a = transformGestureDetector;
        transformGestureDetector.setListener(this);
    }

    public static boolean f(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public static DefaultZoomableController newInstance() {
        return new DefaultZoomableController(TransformGestureDetector.newInstance());
    }

    public final float a(float f2, float f3, float f4, float f5, float f6) {
        float f7 = f3 - f2;
        float f8 = f5 - f4;
        if (f7 < Math.min(f6 - f4, f5 - f6) * 2.0f) {
            return f6 - ((f3 + f2) / 2.0f);
        }
        if (f7 < f8) {
            return f6 < (f4 + f5) / 2.0f ? f4 - f2 : f5 - f3;
        }
        if (f2 > f4) {
            return f4 - f2;
        }
        if (f3 < f5) {
            return f5 - f3;
        }
        return 0.0f;
    }

    public final boolean b(Matrix matrix, float f2, float f3, int i2) {
        if (!f(i2, 8)) {
            return false;
        }
        matrix.getValues(this.o);
        float f4 = this.o[0];
        float f5 = this.g;
        float min = Math.min(Math.max(f5, f4), this.h);
        if (min == f4) {
            return false;
        }
        float f6 = min / f4;
        matrix.postScale(f6, f6, f2, f3);
        return true;
    }

    public final boolean c(Matrix matrix, int i2) {
        float f2;
        float f3;
        if (!f(i2, 3)) {
            return false;
        }
        RectF rectF = this.p;
        rectF.set(this.j);
        matrix.mapRect(rectF);
        if (f(i2, 1)) {
            float f4 = rectF.left;
            float f5 = rectF.right;
            RectF rectF2 = this.i;
            f2 = a(f4, f5, rectF2.left, rectF2.right, this.j.centerX());
        } else {
            f2 = 0.0f;
        }
        if (f(i2, 2)) {
            float f6 = rectF.top;
            float f7 = rectF.bottom;
            RectF rectF3 = this.i;
            f3 = a(f6, f7, rectF3.top, rectF3.bottom, this.j.centerY());
        } else {
            f3 = 0.0f;
        }
        if (f2 == 0.0f && f3 == 0.0f) {
            return false;
        }
        matrix.postTranslate(f2, f3);
        return true;
    }

    public boolean calculateGestureTransform(Matrix matrix, int i2) {
        TransformGestureDetector transformGestureDetector = this.a;
        matrix.set(this.l);
        if (this.d) {
            matrix.postRotate(transformGestureDetector.getRotation() * 57.29578f, transformGestureDetector.getPivotX(), transformGestureDetector.getPivotY());
        }
        if (this.e) {
            float scale = transformGestureDetector.getScale();
            matrix.postScale(scale, scale, transformGestureDetector.getPivotX(), transformGestureDetector.getPivotY());
        }
        boolean b2 = b(matrix, transformGestureDetector.getPivotX(), transformGestureDetector.getPivotY(), i2) | false;
        if (this.f) {
            matrix.postTranslate(transformGestureDetector.getTranslationX(), transformGestureDetector.getTranslationY());
        }
        return c(matrix, i2) | b2;
    }

    public boolean calculateZoomToPointTransform(Matrix matrix, float f2, PointF pointF, PointF pointF2, int i2) {
        float[] fArr = this.o;
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        d(fArr, fArr, 1);
        float f3 = pointF2.x - fArr[0];
        float f4 = pointF2.y - fArr[1];
        matrix.setScale(f2, f2, fArr[0], fArr[1]);
        matrix.postTranslate(f3, f4);
        return c(matrix, i2) | b(matrix, fArr[0], fArr[1], i2) | false;
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public int computeHorizontalScrollExtent() {
        return (int) this.i.width();
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public int computeHorizontalScrollOffset() {
        return (int) (this.i.left - this.k.left);
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public int computeHorizontalScrollRange() {
        return (int) this.k.width();
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public int computeVerticalScrollExtent() {
        return (int) this.i.height();
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public int computeVerticalScrollOffset() {
        return (int) (this.i.top - this.k.top);
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public int computeVerticalScrollRange() {
        return (int) this.k.height();
    }

    public final void d(float[] fArr, float[] fArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * 2;
            int i5 = i4 + 0;
            float width = this.j.width() * fArr2[i5];
            RectF rectF = this.j;
            fArr[i5] = width + rectF.left;
            int i6 = i4 + 1;
            fArr[i6] = (rectF.height() * fArr2[i6]) + this.j.top;
        }
    }

    public final void e() {
        this.m.mapRect(this.k, this.j);
        if (this.b != null && isEnabled()) {
            this.b.onTransformChanged(this.m);
        }
    }

    public TransformGestureDetector getDetector() {
        return this.a;
    }

    public RectF getImageBounds() {
        return this.j;
    }

    public void getImageRelativeToViewAbsoluteTransform(Matrix matrix) {
        matrix.setRectToRect(r, this.k, Matrix.ScaleToFit.FILL);
    }

    public ZoomableController.Listener getListener() {
        return this.b;
    }

    public float getMaxScaleFactor() {
        return this.h;
    }

    public float getMinScaleFactor() {
        return this.g;
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public float getScaleFactor() {
        this.m.getValues(this.o);
        return this.o[0];
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public Matrix getTransform() {
        return this.m;
    }

    public RectF getViewBounds() {
        return this.i;
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public boolean isEnabled() {
        return this.c;
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public boolean isIdentity() {
        this.m.getValues(this.o);
        float[] fArr = this.o;
        fArr[0] = fArr[0] - 1.0f;
        fArr[4] = fArr[4] - 1.0f;
        fArr[8] = fArr[8] - 1.0f;
        for (int i2 = 0; i2 < 9; i2++) {
            if (Math.abs(this.o[i2]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    public boolean isRotationEnabled() {
        return this.d;
    }

    public boolean isScaleEnabled() {
        return this.e;
    }

    public boolean isTranslationEnabled() {
        return this.f;
    }

    public PointF mapImageToView(PointF pointF) {
        float[] fArr = this.o;
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        d(fArr, fArr, 1);
        this.m.mapPoints(fArr, 0, fArr, 0, 1);
        return new PointF(fArr[0], fArr[1]);
    }

    public PointF mapViewToImage(PointF pointF) {
        float[] fArr = this.o;
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        this.m.invert(this.n);
        this.n.mapPoints(fArr, 0, fArr, 0, 1);
        for (int i2 = 0; i2 < 1; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 0;
            float f2 = fArr[i4];
            RectF rectF = this.j;
            fArr[i4] = (f2 - rectF.left) / rectF.width();
            int i5 = i3 + 1;
            float f3 = fArr[i5];
            RectF rectF2 = this.j;
            fArr[i5] = (f3 - rectF2.top) / rectF2.height();
        }
        return new PointF(fArr[0], fArr[1]);
    }

    @Override // com.avito.android.photo_gallery.zoom.gestures.TransformGestureDetector.Listener
    public void onGestureBegin(TransformGestureDetector transformGestureDetector) {
        FLog.v(DefaultZoomableController.class, "onGestureBegin");
        this.l.set(this.m);
        if (this.b != null && isEnabled()) {
            this.b.onTransformBegin(this.m);
        }
        RectF rectF = this.k;
        float f2 = rectF.left;
        RectF rectF2 = this.i;
        this.q = !(f2 < rectF2.left - 0.001f && rectF.top < rectF2.top - 0.001f && rectF.right > rectF2.right + 0.001f && rectF.bottom > rectF2.bottom + 0.001f);
    }

    @Override // com.avito.android.photo_gallery.zoom.gestures.TransformGestureDetector.Listener
    public void onGestureEnd(TransformGestureDetector transformGestureDetector) {
        FLog.v(DefaultZoomableController.class, "onGestureEnd");
        if (this.b != null && isEnabled()) {
            this.b.onTransformEnd(this.m);
        }
    }

    @Override // com.avito.android.photo_gallery.zoom.gestures.TransformGestureDetector.Listener
    public void onGestureUpdate(TransformGestureDetector transformGestureDetector) {
        FLog.v(DefaultZoomableController.class, "onGestureUpdate");
        boolean calculateGestureTransform = calculateGestureTransform(this.m, 11);
        e();
        if (calculateGestureTransform) {
            this.a.restartGesture();
        }
        this.q = calculateGestureTransform;
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FLog.v(DefaultZoomableController.class, "onTouchEvent: action: ", Integer.valueOf(motionEvent.getAction()));
        if (this.c) {
            return this.a.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void reset() {
        FLog.v(DefaultZoomableController.class, "reset");
        this.a.reset();
        this.l.reset();
        this.m.reset();
        e();
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public void setEnabled(boolean z) {
        this.c = z;
        if (!z) {
            reset();
        }
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public void setImageBounds(RectF rectF) {
        if (!rectF.equals(this.j)) {
            this.j.set(rectF);
            e();
        }
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public void setListener(ZoomableController.Listener listener) {
        this.b = listener;
    }

    public void setMaxScaleFactor(float f2) {
        this.h = f2;
    }

    public void setMinScaleFactor(float f2) {
        this.g = f2;
    }

    public void setRotationEnabled(boolean z) {
        this.d = z;
    }

    public void setScaleEnabled(boolean z) {
        this.e = z;
    }

    public void setTransform(Matrix matrix) {
        FLog.v(DefaultZoomableController.class, "setTransform");
        this.m.set(matrix);
        e();
    }

    public void setTranslationEnabled(boolean z) {
        this.f = z;
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public void setViewBounds(RectF rectF) {
        this.i.set(rectF);
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController
    public boolean wasTransformCorrected() {
        return this.q;
    }

    public void zoomToPoint(float f2, PointF pointF, PointF pointF2) {
        FLog.v(DefaultZoomableController.class, "zoomToPoint");
        calculateZoomToPointTransform(this.m, f2, pointF, pointF2, 11);
        e();
    }
}
