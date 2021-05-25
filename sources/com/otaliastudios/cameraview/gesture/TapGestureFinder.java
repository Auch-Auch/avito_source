package com.otaliastudios.cameraview.gesture;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.gesture.GestureFinder;
public class TapGestureFinder extends GestureFinder {
    public GestureDetector e;
    public boolean f;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            TapGestureFinder tapGestureFinder = TapGestureFinder.this;
            tapGestureFinder.f = true;
            tapGestureFinder.setGesture(Gesture.LONG_TAP);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            TapGestureFinder tapGestureFinder = TapGestureFinder.this;
            tapGestureFinder.f = true;
            tapGestureFinder.setGesture(Gesture.TAP);
            return true;
        }
    }

    public TapGestureFinder(@NonNull GestureFinder.Controller controller) {
        super(controller, 1);
        GestureDetector gestureDetector = new GestureDetector(controller.getContext(), new a());
        this.e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public float getValue(float f2, float f3, float f4) {
        return 0.0f;
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public boolean handleTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f = false;
        }
        this.e.onTouchEvent(motionEvent);
        if (!this.f) {
            return false;
        }
        getPoint(0).x = motionEvent.getX();
        getPoint(0).y = motionEvent.getY();
        return true;
    }
}
