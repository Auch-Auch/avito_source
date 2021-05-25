package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.internal.VisibleForTesting;
import javax.annotation.Nullable;
public class GestureDetector {
    @VisibleForTesting
    @Nullable
    public ClickListener a;
    @VisibleForTesting
    public final float b;
    @VisibleForTesting
    public boolean c;
    @VisibleForTesting
    public boolean d;
    @VisibleForTesting
    public long e;
    @VisibleForTesting
    public float f;
    @VisibleForTesting
    public float g;

    public interface ClickListener {
        boolean onClick();
    }

    public GestureDetector(Context context) {
        this.b = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static GestureDetector newInstance(Context context) {
        return new GestureDetector(context);
    }

    public void init() {
        this.a = null;
        reset();
    }

    public boolean isCapturingGesture() {
        return this.c;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ClickListener clickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = true;
            this.d = true;
            this.e = motionEvent.getEventTime();
            this.f = motionEvent.getX();
            this.g = motionEvent.getY();
        } else if (action == 1) {
            this.c = false;
            if (Math.abs(motionEvent.getX() - this.f) > this.b || Math.abs(motionEvent.getY() - this.g) > this.b) {
                this.d = false;
            }
            if (this.d && motionEvent.getEventTime() - this.e <= ((long) ViewConfiguration.getLongPressTimeout()) && (clickListener = this.a) != null) {
                clickListener.onClick();
            }
            this.d = false;
        } else if (action != 2) {
            if (action == 3) {
                this.c = false;
                this.d = false;
            }
        } else if (Math.abs(motionEvent.getX() - this.f) > this.b || Math.abs(motionEvent.getY() - this.g) > this.b) {
            this.d = false;
        }
        return true;
    }

    public void reset() {
        this.c = false;
        this.d = false;
    }

    public void setClickListener(ClickListener clickListener) {
        this.a = clickListener;
    }
}
