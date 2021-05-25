package com.otaliastudios.cameraview.gesture;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.gesture.GestureFinder;
public class PinchGestureFinder extends GestureFinder {
    public ScaleGestureDetector e;
    public boolean f;
    public float g = 0.0f;

    public class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            PinchGestureFinder pinchGestureFinder = PinchGestureFinder.this;
            pinchGestureFinder.f = true;
            pinchGestureFinder.g = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
            return true;
        }
    }

    public PinchGestureFinder(@NonNull GestureFinder.Controller controller) {
        super(controller, 2);
        setGesture(Gesture.PINCH);
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(controller.getContext(), new a());
        this.e = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
    }

    public float getFactor() {
        return this.g;
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public float getValue(float f2, float f3, float f4) {
        return a2.b.a.a.a.b(f4, f3, getFactor(), f2);
    }

    @Override // com.otaliastudios.cameraview.gesture.GestureFinder
    public boolean handleTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            this.f = false;
        }
        this.e.onTouchEvent(motionEvent);
        if (this.f) {
            getPoint(0).x = motionEvent.getX(0);
            getPoint(0).y = motionEvent.getY(0);
            z = true;
            if (motionEvent.getPointerCount() > 1) {
                getPoint(1).x = motionEvent.getX(1);
                getPoint(1).y = motionEvent.getY(1);
            }
        }
        return z;
    }
}
