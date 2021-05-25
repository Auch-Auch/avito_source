package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
public final class GestureDetectorCompat {
    public final a a;

    public interface a {
    }

    public static class b implements a {
        public final GestureDetector a;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.a = new GestureDetector(context, onGestureListener, handler);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean isLongpressEnabled() {
        return ((b) this.a).a.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return ((b) this.a).a.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        ((b) this.a).a.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        ((b) this.a).a.setOnDoubleTapListener(onDoubleTapListener);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.a = new b(context, onGestureListener, handler);
    }
}
