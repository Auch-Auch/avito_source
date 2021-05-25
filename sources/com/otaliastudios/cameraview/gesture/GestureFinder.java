package com.otaliastudios.cameraview.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
public abstract class GestureFinder {
    public boolean a;
    @VisibleForTesting
    public Gesture b;
    public PointF[] c;
    public Controller d;

    public interface Controller {
        @NonNull
        Context getContext();

        int getHeight();

        int getWidth();
    }

    public GestureFinder(@NonNull Controller controller, int i) {
        this.d = controller;
        this.c = new PointF[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.c[i2] = new PointF(0.0f, 0.0f);
        }
    }

    public final float computeValue(float f, float f2, float f3) {
        float value = getValue(f, f2, f3);
        if (value < f2) {
            value = f2;
        }
        if (value > f3) {
            value = f3;
        }
        float f4 = ((f3 - f2) / 50.0f) / 2.0f;
        return (value < f - f4 || value > f4 + f) ? value : f;
    }

    @NonNull
    public Controller getController() {
        return this.d;
    }

    @NonNull
    public final Gesture getGesture() {
        return this.b;
    }

    @NonNull
    public final PointF getPoint(int i) {
        return this.c[i];
    }

    @NonNull
    public final PointF[] getPoints() {
        return this.c;
    }

    public abstract float getValue(float f, float f2, float f3);

    public abstract boolean handleTouchEvent(@NonNull MotionEvent motionEvent);

    public boolean isActive() {
        return this.a;
    }

    public final boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!this.a) {
            return false;
        }
        return handleTouchEvent(motionEvent);
    }

    public void setActive(boolean z) {
        this.a = z;
    }

    public final void setGesture(Gesture gesture) {
        this.b = gesture;
    }
}
