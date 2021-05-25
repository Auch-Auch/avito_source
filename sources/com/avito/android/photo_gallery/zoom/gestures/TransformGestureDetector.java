package com.avito.android.photo_gallery.zoom.gestures;

import android.view.MotionEvent;
import com.avito.android.photo_gallery.zoom.gestures.MultiPointerGestureDetector;
public class TransformGestureDetector implements MultiPointerGestureDetector.Listener {
    public final MultiPointerGestureDetector a;
    public Listener b = null;

    public interface Listener {
        void onGestureBegin(TransformGestureDetector transformGestureDetector);

        void onGestureEnd(TransformGestureDetector transformGestureDetector);

        void onGestureUpdate(TransformGestureDetector transformGestureDetector);
    }

    public TransformGestureDetector(MultiPointerGestureDetector multiPointerGestureDetector) {
        this.a = multiPointerGestureDetector;
        multiPointerGestureDetector.setListener(this);
    }

    public static TransformGestureDetector newInstance() {
        return new TransformGestureDetector(MultiPointerGestureDetector.newInstance());
    }

    public final float a(float[] fArr, int i) {
        float f = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            f += fArr[i2];
        }
        if (i > 0) {
            return f / ((float) i);
        }
        return 0.0f;
    }

    public int getNewPointerCount() {
        return this.a.getNewPointerCount();
    }

    public float getPivotX() {
        return a(this.a.getStartX(), this.a.getPointerCount());
    }

    public float getPivotY() {
        return a(this.a.getStartY(), this.a.getPointerCount());
    }

    public int getPointerCount() {
        return this.a.getPointerCount();
    }

    public float getRotation() {
        if (this.a.getPointerCount() < 2) {
            return 0.0f;
        }
        float f = this.a.getStartX()[1] - this.a.getStartX()[0];
        float f2 = this.a.getStartY()[1] - this.a.getStartY()[0];
        return ((float) Math.atan2((double) (this.a.getCurrentY()[1] - this.a.getCurrentY()[0]), (double) (this.a.getCurrentX()[1] - this.a.getCurrentX()[0]))) - ((float) Math.atan2((double) f2, (double) f));
    }

    public float getScale() {
        if (this.a.getPointerCount() < 2) {
            return 1.0f;
        }
        float f = this.a.getStartX()[1] - this.a.getStartX()[0];
        float f2 = this.a.getStartY()[1] - this.a.getStartY()[0];
        float f3 = this.a.getCurrentX()[1] - this.a.getCurrentX()[0];
        return ((float) Math.hypot((double) f3, (double) (this.a.getCurrentY()[1] - this.a.getCurrentY()[0]))) / ((float) Math.hypot((double) f, (double) f2));
    }

    public float getTranslationX() {
        return a(this.a.getCurrentX(), this.a.getPointerCount()) - a(this.a.getStartX(), this.a.getPointerCount());
    }

    public float getTranslationY() {
        return a(this.a.getCurrentY(), this.a.getPointerCount()) - a(this.a.getStartY(), this.a.getPointerCount());
    }

    public boolean isGestureInProgress() {
        return this.a.isGestureInProgress();
    }

    @Override // com.avito.android.photo_gallery.zoom.gestures.MultiPointerGestureDetector.Listener
    public void onGestureBegin(MultiPointerGestureDetector multiPointerGestureDetector) {
        Listener listener = this.b;
        if (listener != null) {
            listener.onGestureBegin(this);
        }
    }

    @Override // com.avito.android.photo_gallery.zoom.gestures.MultiPointerGestureDetector.Listener
    public void onGestureEnd(MultiPointerGestureDetector multiPointerGestureDetector) {
        Listener listener = this.b;
        if (listener != null) {
            listener.onGestureEnd(this);
        }
    }

    @Override // com.avito.android.photo_gallery.zoom.gestures.MultiPointerGestureDetector.Listener
    public void onGestureUpdate(MultiPointerGestureDetector multiPointerGestureDetector) {
        Listener listener = this.b;
        if (listener != null) {
            listener.onGestureUpdate(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }

    public void reset() {
        this.a.reset();
    }

    public void restartGesture() {
        this.a.restartGesture();
    }

    public void setListener(Listener listener) {
        this.b = listener;
    }
}
