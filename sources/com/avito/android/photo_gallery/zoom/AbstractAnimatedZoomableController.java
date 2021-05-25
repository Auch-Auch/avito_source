package com.avito.android.photo_gallery.zoom;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.avito.android.photo_gallery.zoom.gestures.TransformGestureDetector;
import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;
public abstract class AbstractAnimatedZoomableController extends DefaultZoomableController {
    public boolean s;
    public final float[] t = new float[9];
    public final float[] u = new float[9];
    public final float[] v = new float[9];
    public final Matrix w = new Matrix();
    public final Matrix x = new Matrix();

    public AbstractAnimatedZoomableController(TransformGestureDetector transformGestureDetector) {
        super(transformGestureDetector);
    }

    public void calculateInterpolation(Matrix matrix, float f) {
        for (int i = 0; i < 9; i++) {
            this.v[i] = (this.u[i] * f) + ((1.0f - f) * this.t[i]);
        }
        matrix.setValues(this.v);
    }

    public abstract Class<?> getLogTag();

    public float[] getStartValues() {
        return this.t;
    }

    public float[] getStopValues() {
        return this.u;
    }

    public Matrix getWorkingTransform() {
        return this.x;
    }

    public boolean isAnimating() {
        return this.s;
    }

    @Override // com.avito.android.photo_gallery.zoom.DefaultZoomableController, com.avito.android.photo_gallery.zoom.ZoomableController
    public boolean isIdentity() {
        return !isAnimating() && super.isIdentity();
    }

    @Override // com.avito.android.photo_gallery.zoom.DefaultZoomableController, com.avito.android.photo_gallery.zoom.gestures.TransformGestureDetector.Listener
    public void onGestureBegin(TransformGestureDetector transformGestureDetector) {
        FLog.v(getLogTag(), "onGestureBegin");
        stopAnimation();
        super.onGestureBegin(transformGestureDetector);
    }

    @Override // com.avito.android.photo_gallery.zoom.DefaultZoomableController, com.avito.android.photo_gallery.zoom.gestures.TransformGestureDetector.Listener
    public void onGestureUpdate(TransformGestureDetector transformGestureDetector) {
        FLog.v(getLogTag(), "onGestureUpdate %s", isAnimating() ? "(ignored)" : "");
        if (!isAnimating()) {
            super.onGestureUpdate(transformGestureDetector);
        }
    }

    @Override // com.avito.android.photo_gallery.zoom.DefaultZoomableController
    public void reset() {
        FLog.v(getLogTag(), "reset");
        stopAnimation();
        this.x.reset();
        this.w.reset();
        super.reset();
    }

    public void setAnimating(boolean z) {
        this.s = z;
    }

    public void setTransform(Matrix matrix, long j, @Nullable Runnable runnable) {
        FLog.v(getLogTag(), "setTransform: duration %d ms", Long.valueOf(j));
        if (j <= 0) {
            FLog.v(getLogTag(), "setTransformImmediate");
            stopAnimation();
            this.x.set(matrix);
            super.setTransform(matrix);
            getDetector().restartGesture();
            return;
        }
        setTransformAnimated(matrix, j, runnable);
    }

    public abstract void setTransformAnimated(Matrix matrix, long j, @Nullable Runnable runnable);

    public abstract void stopAnimation();

    @Override // com.avito.android.photo_gallery.zoom.DefaultZoomableController
    public void zoomToPoint(float f, PointF pointF, PointF pointF2) {
        zoomToPoint(f, pointF, pointF2, 11, 0, null);
    }

    public void zoomToPoint(float f, PointF pointF, PointF pointF2, int i, long j, @Nullable Runnable runnable) {
        FLog.v(getLogTag(), "zoomToPoint: duration %d ms", Long.valueOf(j));
        calculateZoomToPointTransform(this.w, f, pointF, pointF2, i);
        setTransform(this.w, j, runnable);
    }
}
