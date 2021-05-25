package com.otaliastudios.cameraview.gesture;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.gesture.GestureFinder;
public class ScrollGestureFinder extends GestureFinder {
    public static final CameraLogger h = CameraLogger.create(ScrollGestureFinder.class.getSimpleName());
    public GestureDetector e;
    public boolean f;
    public float g;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ GestureFinder.Controller a;

        public a(GestureFinder.Controller controller) {
            this.a = controller;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float f3;
            CameraLogger cameraLogger = ScrollGestureFinder.h;
            boolean z = false;
            cameraLogger.i("onScroll:", "distanceX=" + f, "distanceY=" + f2);
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            if (motionEvent.getX() != ScrollGestureFinder.this.getPoint(0).x || motionEvent.getY() != ScrollGestureFinder.this.getPoint(0).y) {
                boolean z2 = Math.abs(f) >= Math.abs(f2);
                ScrollGestureFinder.this.setGesture(z2 ? Gesture.SCROLL_HORIZONTAL : Gesture.SCROLL_VERTICAL);
                ScrollGestureFinder.this.getPoint(0).set(motionEvent.getX(), motionEvent.getY());
                z = z2;
            } else if (ScrollGestureFinder.this.getGesture() == Gesture.SCROLL_HORIZONTAL) {
                z = true;
            }
            ScrollGestureFinder.this.getPoint(1).set(motionEvent2.getX(), motionEvent2.getY());
            ScrollGestureFinder scrollGestureFinder = ScrollGestureFinder.this;
            GestureFinder.Controller controller = this.a;
            if (z) {
                f3 = f / ((float) controller.getWidth());
            } else {
                f3 = f2 / ((float) controller.getHeight());
            }
            scrollGestureFinder.g = f3;
            ScrollGestureFinder scrollGestureFinder2 = ScrollGestureFinder.this;
            scrollGestureFinder2.g = z ? -scrollGestureFinder2.g : scrollGestureFinder2.g;
            scrollGestureFinder2.f = true;
            return true;
        }
    }

    public ScrollGestureFinder(@NonNull GestureFinder.Controller controller) {
        super(controller, 2);
        GestureDetector gestureDetector = new GestureDetector(controller.getContext(), new a(controller));
        this.e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    public float getFactor() {
        return this.g;
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public float getValue(float f2, float f3, float f4) {
        return ((f4 - f3) * getFactor() * 2.0f) + f2;
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public boolean handleTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f = false;
        }
        this.e.onTouchEvent(motionEvent);
        if (this.f) {
            h.i("Notifying a gesture of type", getGesture().name());
        }
        return this.f;
    }
}
