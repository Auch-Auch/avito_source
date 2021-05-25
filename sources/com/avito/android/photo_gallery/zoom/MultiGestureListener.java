package com.avito.android.photo_gallery.zoom;

import android.annotation.TargetApi;
import android.view.GestureDetector;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
@TargetApi(23)
public class MultiGestureListener extends GestureDetector.SimpleOnGestureListener {
    public final List<GestureDetector.SimpleOnGestureListener> a = new ArrayList();

    public synchronized void addListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.a.add(simpleOnGestureListener);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnContextClickListener
    public synchronized boolean onContextClick(MotionEvent motionEvent) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).onContextClick(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public synchronized boolean onDoubleTap(MotionEvent motionEvent) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).onDoubleTap(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public synchronized boolean onDoubleTapEvent(MotionEvent motionEvent) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).onDoubleTapEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public synchronized boolean onDown(MotionEvent motionEvent) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).onDown(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public synchronized boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).onFling(motionEvent, motionEvent2, f, f2)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public synchronized void onLongPress(MotionEvent motionEvent) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).onLongPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public synchronized boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).onScroll(motionEvent, motionEvent2, f, f2)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public synchronized void onShowPress(MotionEvent motionEvent) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).onShowPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public synchronized boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).onSingleTapConfirmed(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public synchronized boolean onSingleTapUp(MotionEvent motionEvent) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).onSingleTapUp(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void removeListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.a.remove(simpleOnGestureListener);
    }
}
