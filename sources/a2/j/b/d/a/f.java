package a2.j.b.d.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;
public abstract class f<V extends View> extends h<V> {
    @Nullable
    public Runnable d;
    public OverScroller e;
    public boolean f;
    public int g = -1;
    public int h;
    public int i = -1;
    @Nullable
    public VelocityTracker j;

    /* JADX WARN: Field signature parse error: b */
    public class a implements Runnable {
        public final CoordinatorLayout a;
        public final View b;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.a = coordinatorLayout;
            this.b = v;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: a2.j.b.d.a.f */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: a2.j.b.d.a.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.b != null && (overScroller = f.this.e) != null) {
                if (overScroller.computeScrollOffset()) {
                    f fVar = f.this;
                    fVar.d(this.a, this.b, fVar.e.getCurrY());
                    ViewCompat.postOnAnimation(this.b, this);
                    return;
                }
                f.this.b(this.a, this.b);
            }
        }
    }

    public f() {
    }

    public abstract int a();

    public abstract void b(CoordinatorLayout coordinatorLayout, V v);

    public final int c(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return e(coordinatorLayout, v, a() - i2, i3, i4);
    }

    public int d(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return e(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int e(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        boolean z;
        View view;
        int findPointerIndex;
        if (this.i < 0) {
            this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f) {
            int i2 = this.g;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.h) > this.i) {
                this.h = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.g = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) this;
            AppBarLayout appBarLayout = (AppBarLayout) v;
            AppBarLayout.BaseBehavior.BaseDragCallback baseDragCallback = baseBehavior.r;
            if (baseDragCallback != null) {
                z = baseDragCallback.canDrag(appBarLayout);
            } else {
                WeakReference<View> weakReference = baseBehavior.q;
                z = weakReference == null || ((view = weakReference.get()) != null && view.isShown() && !view.canScrollVertically(-1));
            }
            boolean z2 = z && coordinatorLayout.isPointInChildBounds(v, x, y2);
            this.f = z2;
            if (z2) {
                this.h = y2;
                this.g = motionEvent.getPointerId(0);
                if (this.j == null) {
                    this.j = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00de A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r20, @androidx.annotation.NonNull V r21, @androidx.annotation.NonNull android.view.MotionEvent r22) {
        /*
        // Method dump skipped, instructions count: 227
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.d.a.f.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
