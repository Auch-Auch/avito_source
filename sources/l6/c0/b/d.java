package l6.c0.b;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
public final class d {
    public final ViewPager2 a;
    public final f b;
    public final RecyclerView c;
    public VelocityTracker d;
    public int e;
    public float f;
    public int g;
    public long h;

    public d(ViewPager2 viewPager2, f fVar, RecyclerView recyclerView) {
        this.a = viewPager2;
        this.b = fVar;
        this.c = recyclerView;
    }

    public final void a(long j, int i, float f2, float f3) {
        MotionEvent obtain = MotionEvent.obtain(this.h, j, i, f2, f3, 0);
        this.d.addMovement(obtain);
        obtain.recycle();
    }
}
