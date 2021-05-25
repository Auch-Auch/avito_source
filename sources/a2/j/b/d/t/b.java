package a2.j.b.d.t;

import android.view.ViewTreeObserver;
import com.google.android.material.timepicker.ClockFaceView;
import com.google.android.material.timepicker.ClockHandView;
public class b implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ClockFaceView a;

    public b(ClockFaceView clockFaceView) {
        this.a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (!this.a.isShown()) {
            return true;
        }
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        ClockFaceView clockFaceView = this.a;
        int height = ((this.a.getHeight() / 2) - clockFaceView.t.h) - clockFaceView.A;
        if (height != clockFaceView.r) {
            clockFaceView.r = height;
            clockFaceView.b();
            ClockHandView clockHandView = clockFaceView.t;
            clockHandView.q = clockFaceView.r;
            clockHandView.invalidate();
        }
        return true;
    }
}
