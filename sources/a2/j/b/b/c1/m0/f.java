package a2.j.b.b.c1.m0;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.spherical.OrientationListener;
import com.google.android.exoplayer2.ui.spherical.SingleTapListener;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
public class f extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, OrientationListener.Listener {
    public final PointF a = new PointF();
    public final PointF b = new PointF();
    public final a c;
    public final float d;
    public final GestureDetector e;
    public volatile float f;
    @Nullable
    public SingleTapListener g;

    public interface a {
    }

    public f(Context context, a aVar, float f2) {
        this.c = aVar;
        this.d = f2;
        this.e = new GestureDetector(context, this);
        this.f = 3.1415927f;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener
    @BinderThread
    public void onOrientationChange(float[] fArr, float f2) {
        this.f = -f2;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float x = (motionEvent2.getX() - this.a.x) / this.d;
        float y = motionEvent2.getY();
        PointF pointF = this.a;
        float f4 = (y - pointF.y) / this.d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d2 = (double) this.f;
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        PointF pointF2 = this.b;
        pointF2.x -= (cos * x) - (sin * f4);
        float f5 = (cos * f4) + (sin * x) + pointF2.y;
        pointF2.y = f5;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f5));
        a aVar = this.c;
        PointF pointF3 = this.b;
        SphericalGLSurfaceView.a aVar2 = (SphericalGLSurfaceView.a) aVar;
        synchronized (aVar2) {
            aVar2.g = pointF3.y;
            aVar2.a();
            Matrix.setRotateM(aVar2.f, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        SingleTapListener singleTapListener = this.g;
        if (singleTapListener != null) {
            return singleTapListener.onSingleTapUp(motionEvent);
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.e.onTouchEvent(motionEvent);
    }
}
