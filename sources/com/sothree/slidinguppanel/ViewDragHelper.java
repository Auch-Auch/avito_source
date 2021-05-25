package com.sothree.slidinguppanel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
import java.util.Arrays;
public class ViewDragHelper {
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final Interpolator w = new a();
    public int a;
    public int b;
    public int c = -1;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public int p;
    public ScrollerCompat q;
    public final Callback r;
    public View s;
    public boolean t;
    public final ViewGroup u;
    public final Runnable v = new b();

    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    public static class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.m(0);
        }
    }

    public ViewDragHelper(Context context, ViewGroup viewGroup, Interpolator interpolator, Callback callback) {
        if (callback != null) {
            this.u = viewGroup;
            this.r = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.q = ScrollerCompat.create(context, interpolator == null ? w : interpolator);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, null, callback);
    }

    public final boolean a(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.h[i2] & i3) != i3 || (this.p & i3) == 0 || (this.j[i2] & i3) == i3 || (this.i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.r.onEdgeLock(i3)) {
            int[] iArr = this.j;
            iArr[i2] = iArr[i2] | i3;
            return false;
        } else if ((this.i[i2] & i3) != 0 || abs <= ((float) this.b)) {
            return false;
        } else {
            return true;
        }
    }

    public void abort() {
        cancel();
        if (this.a == 2) {
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            this.q.abortAnimation();
            int currX2 = this.q.getCurrX();
            int currY2 = this.q.getCurrY();
            this.r.onViewPositionChanged(this.s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        m(0);
    }

    public final boolean b(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.r.getViewVerticalDragRange(view) > 0;
        if (z && z2) {
            float f4 = f3 * f3;
            int i2 = this.b;
            if (f4 + (f2 * f2) > ((float) (i2 * i2))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f2) > ((float) this.b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f3) <= ((float) this.b)) {
            return false;
        } else {
            return true;
        }
    }

    public final float c(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        if (abs > f4) {
            return f2 > 0.0f ? f4 : -f4;
        }
        return f2;
    }

    public boolean canScroll(View view, boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i7 = i4 + scrollX;
                if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && (i6 = i5 + scrollY) >= childAt.getTop() && i6 < childAt.getBottom() && canScroll(childAt, true, i2, i3, i7 - childAt.getLeft(), i6 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (!z || (!ViewCompat.canScrollHorizontally(view, -i2) && !ViewCompat.canScrollVertically(view, -i3))) {
            return false;
        }
        return true;
    }

    public void cancel() {
        this.c = -1;
        float[] fArr = this.d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public void captureChildView(View view, int i2) {
        if (view.getParent() == this.u) {
            this.s = view;
            this.c = i2;
            this.r.onViewCaptured(view, i2);
            m(1);
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        L.append(this.u);
        L.append(")");
        throw new IllegalArgumentException(L.toString());
    }

    public boolean checkTouchSlop(int i2) {
        int length = this.d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (checkTouchSlop(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean continueSettling(boolean z) {
        if (this.s == null) {
            return false;
        }
        if (this.a == 2) {
            boolean computeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (computeScrollOffset || top == 0) {
                if (left != 0) {
                    this.s.offsetLeftAndRight(left);
                }
                if (top != 0) {
                    this.s.offsetTopAndBottom(top);
                }
                if (!(left == 0 && top == 0)) {
                    this.r.onViewPositionChanged(this.s, currX, currY, left, top);
                }
                if (computeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                    this.q.abortAnimation();
                    computeScrollOffset = this.q.isFinished();
                }
                if (!computeScrollOffset) {
                    if (z) {
                        this.u.post(this.v);
                    } else {
                        m(0);
                    }
                }
            } else {
                this.s.setTop(0);
                return true;
            }
        }
        if (this.a == 2) {
            return true;
        }
        return false;
    }

    public final int d(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        if (abs > i4) {
            return i2 > 0 ? i4 : -i4;
        }
        return i2;
    }

    public final void e(int i2) {
        float[] fArr = this.d;
        if (fArr != null && fArr.length > i2) {
            fArr[i2] = 0.0f;
            this.e[i2] = 0.0f;
            this.f[i2] = 0.0f;
            this.g[i2] = 0.0f;
            this.h[i2] = 0;
            this.i[i2] = 0;
            this.j[i2] = 0;
            this.k = (~(1 << i2)) & this.k;
        }
    }

    public final int f(int i2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f2 = (float) (width / 2);
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * f2) + f2;
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        return Math.min(i5, 600);
    }

    public View findTopChildUnder(int i2, int i3) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(this.r.getOrderedChildIndex(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i2, int i3, int i4, int i5) {
        if (this.t) {
            this.q.fling(this.s.getLeft(), this.s.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.l, this.c), (int) VelocityTrackerCompat.getYVelocity(this.l, this.c), i2, i4, i3, i5);
            m(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public final void g(float f2, float f3) {
        this.t = true;
        this.r.onViewReleased(this.s, f2, f3);
        this.t = false;
        if (this.a == 1) {
            m(0);
        }
    }

    public int getActivePointerId() {
        return this.c;
    }

    public View getCapturedView() {
        return this.s;
    }

    public int getEdgeSize() {
        return this.o;
    }

    public float getMinVelocity() {
        return this.n;
    }

    public int getTouchSlop() {
        return this.b;
    }

    public int getViewDragState() {
        return this.a;
    }

    public final boolean h(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.q.abortAnimation();
            m(0);
            return false;
        }
        View view = this.s;
        int d2 = d(i4, (int) this.n, (int) this.m);
        int d3 = d(i5, (int) this.n, (int) this.m);
        int abs = Math.abs(i6);
        int abs2 = Math.abs(i7);
        int abs3 = Math.abs(d2);
        int abs4 = Math.abs(d3);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (d2 != 0) {
            f2 = (float) abs3;
            f3 = (float) i8;
        } else {
            f2 = (float) abs;
            f3 = (float) i9;
        }
        float f6 = f2 / f3;
        if (d3 != 0) {
            f5 = (float) abs4;
            f4 = (float) i8;
        } else {
            f5 = (float) abs2;
            f4 = (float) i9;
        }
        int f7 = f(i6, d2, this.r.getViewHorizontalDragRange(view));
        float f8 = ((float) f(i7, d3, this.r.getViewVerticalDragRange(view))) * (f5 / f4);
        this.q.startScroll(left, top, i6, i7, (int) (f8 + (((float) f7) * f6)));
        m(2);
        return true;
    }

    public final void i() {
        this.l.computeCurrentVelocity(1000, this.m);
        g(c(VelocityTrackerCompat.getXVelocity(this.l, this.c), this.n, this.m), c(VelocityTrackerCompat.getYVelocity(this.l, this.c), this.n, this.m));
    }

    public boolean isCapturedViewUnder(int i2, int i3) {
        return isViewUnder(this.s, i2, i3);
    }

    public boolean isDragging() {
        return this.a == 1;
    }

    public boolean isEdgeTouched(int i2) {
        int length = this.h.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (isEdgeTouched(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i2) {
        return ((1 << i2) & this.k) != 0;
    }

    public boolean isViewUnder(View view, int i2, int i3) {
        if (view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final void j(float f2, float f3, int i2) {
        int i3 = 1;
        if (!a(f2, f3, i2, 1)) {
            i3 = 0;
        }
        if (a(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (a(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (a(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.i;
            iArr[i2] = iArr[i2] | i3;
            this.r.onEdgeDragStarted(i3, i2);
        }
    }

    public final void k(float f2, float f3, int i2) {
        float[] fArr = this.d;
        int i3 = 0;
        if (fArr == null || fArr.length <= i2) {
            int i4 = i2 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
        float[] fArr9 = this.d;
        this.f[i2] = f2;
        fArr9[i2] = f2;
        float[] fArr10 = this.e;
        this.g[i2] = f3;
        fArr10[i2] = f3;
        int[] iArr7 = this.h;
        int i5 = (int) f2;
        int i6 = (int) f3;
        if (i5 < this.u.getLeft() + this.o) {
            i3 = 1;
        }
        if (i6 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i5 > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        if (i6 > this.u.getBottom() - this.o) {
            i3 |= 8;
        }
        iArr7[i2] = i3;
        this.k |= 1 << i2;
    }

    public final void l(MotionEvent motionEvent) {
        float[] fArr;
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i2);
            float x = MotionEventCompat.getX(motionEvent, i2);
            float y = MotionEventCompat.getY(motionEvent, i2);
            float[] fArr2 = this.f;
            if (fArr2 != null && (fArr = this.g) != null && fArr2.length > pointerId && fArr.length > pointerId) {
                fArr2[pointerId] = x;
                fArr[pointerId] = y;
            }
        }
    }

    public void m(int i2) {
        if (this.a != i2) {
            this.a = i2;
            this.r.onViewDragStateChanged(i2);
            if (this.a == 0) {
                this.s = null;
            }
        }
    }

    public boolean n(View view, int i2) {
        if (view == this.s && this.c == i2) {
            return true;
        }
        if (view == null || !this.r.tryCaptureView(view, i2)) {
            return false;
        }
        this.c = i2;
        captureChildView(view, i2);
        return true;
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int i2;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            k(x, y, pointerId);
            n(findTopChildUnder, pointerId);
            int i4 = this.h[pointerId];
            int i5 = this.p;
            if ((i4 & i5) != 0) {
                this.r.onEdgeTouched(i4 & i5, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.a == 1) {
                i();
            }
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.a == 1) {
                    g(0.0f, 0.0f);
                }
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                float x2 = MotionEventCompat.getX(motionEvent, actionIndex);
                float y2 = MotionEventCompat.getY(motionEvent, actionIndex);
                k(x2, y2, pointerId2);
                if (this.a == 0) {
                    n(findTopChildUnder((int) x2, (int) y2), pointerId2);
                    int i6 = this.h[pointerId2];
                    int i7 = this.p;
                    if ((i6 & i7) != 0) {
                        this.r.onEdgeTouched(i6 & i7, pointerId2);
                    }
                } else if (isCapturedViewUnder((int) x2, (int) y2)) {
                    n(this.s, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (this.a == 1 && pointerId3 == this.c) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    while (true) {
                        if (i3 >= pointerCount) {
                            i2 = -1;
                            break;
                        }
                        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, i3);
                        if (pointerId4 != this.c) {
                            View findTopChildUnder2 = findTopChildUnder((int) MotionEventCompat.getX(motionEvent, i3), (int) MotionEventCompat.getY(motionEvent, i3));
                            View view = this.s;
                            if (findTopChildUnder2 == view && n(view, pointerId4)) {
                                i2 = this.c;
                                break;
                            }
                        }
                        i3++;
                    }
                    if (i2 == -1) {
                        i();
                    }
                }
                e(pointerId3);
            }
        } else if (this.a == 1) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.c);
            float x3 = MotionEventCompat.getX(motionEvent, findPointerIndex);
            float y3 = MotionEventCompat.getY(motionEvent, findPointerIndex);
            float[] fArr = this.f;
            int i8 = this.c;
            int i9 = (int) (x3 - fArr[i8]);
            int i10 = (int) (y3 - this.g[i8]);
            int left = this.s.getLeft() + i9;
            int top = this.s.getTop() + i10;
            int left2 = this.s.getLeft();
            int top2 = this.s.getTop();
            if (i9 != 0) {
                left = this.r.clampViewPositionHorizontal(this.s, left, i9);
                this.s.offsetLeftAndRight(left - left2);
            }
            if (i10 != 0) {
                top = this.r.clampViewPositionVertical(this.s, top, i10);
                this.s.offsetTopAndBottom(top - top2);
            }
            if (!(i9 == 0 && i10 == 0)) {
                this.r.onViewPositionChanged(this.s, left, top, left - left2, top - top2);
            }
            l(motionEvent);
        } else {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (i3 < pointerCount2) {
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i3);
                float x4 = MotionEventCompat.getX(motionEvent, i3);
                float y4 = MotionEventCompat.getY(motionEvent, i3);
                float f2 = x4 - this.d[pointerId5];
                float f3 = y4 - this.e[pointerId5];
                j(f2, f3, pointerId5);
                if (this.a != 1) {
                    View findTopChildUnder3 = findTopChildUnder((int) this.d[pointerId5], (int) this.e[pointerId5]);
                    if (b(findTopChildUnder3, f2, f3) && n(findTopChildUnder3, pointerId5)) {
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            l(motionEvent);
        }
    }

    public void setEdgeTrackingEnabled(int i2) {
        this.p = i2;
    }

    public void setMinVelocity(float f2) {
        this.n = f2;
    }

    public boolean settleCapturedViewAt(int i2, int i3) {
        if (this.t) {
            return h(i2, i3, (int) VelocityTrackerCompat.getXVelocity(this.l, this.c), (int) VelocityTrackerCompat.getYVelocity(this.l, this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        View findTopChildUnder;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    for (int i2 = 0; i2 < pointerCount && this.d != null && this.e != null; i2++) {
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, i2);
                        if (pointerId < this.d.length && pointerId < this.e.length) {
                            float x = MotionEventCompat.getX(motionEvent, i2);
                            float y = MotionEventCompat.getY(motionEvent, i2);
                            float f2 = x - this.d[pointerId];
                            float f3 = y - this.e[pointerId];
                            j(f2, f3, pointerId);
                            if (this.a == 1) {
                                break;
                            }
                            View findTopChildUnder2 = findTopChildUnder((int) this.d[pointerId], (int) this.e[pointerId]);
                            if (findTopChildUnder2 != null && b(findTopChildUnder2, f2, f3) && n(findTopChildUnder2, pointerId)) {
                                break;
                            }
                        }
                    }
                    l(motionEvent);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        float x2 = MotionEventCompat.getX(motionEvent, actionIndex);
                        float y2 = MotionEventCompat.getY(motionEvent, actionIndex);
                        k(x2, y2, pointerId2);
                        int i3 = this.a;
                        if (i3 == 0) {
                            int i4 = this.h[pointerId2];
                            int i5 = this.p;
                            if ((i4 & i5) != 0) {
                                this.r.onEdgeTouched(i4 & i5, pointerId2);
                            }
                        } else if (i3 == 2 && (findTopChildUnder = findTopChildUnder((int) x2, (int) y2)) == this.s) {
                            n(findTopChildUnder, pointerId2);
                        }
                    } else if (actionMasked == 6) {
                        e(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                    }
                }
            }
            cancel();
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, 0);
            k(x3, y3, pointerId3);
            View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
            if (findTopChildUnder3 == this.s && this.a == 2) {
                n(findTopChildUnder3, pointerId3);
            }
            int i6 = this.h[pointerId3];
            int i7 = this.p;
            if ((i6 & i7) != 0) {
                this.r.onEdgeTouched(i6 & i7, pointerId3);
            }
        }
        if (this.a == 1) {
            return true;
        }
        return false;
    }

    public boolean smoothSlideViewTo(View view, int i2, int i3) {
        this.s = view;
        this.c = -1;
        return h(i2, i3, 0, 0);
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Interpolator interpolator, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, interpolator, callback);
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f2, Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.b = (int) ((1.0f / f2) * ((float) create.b));
        return create;
    }

    public boolean checkTouchSlop(int i2, int i3) {
        if (!isPointerDown(i3)) {
            return false;
        }
        boolean z = (i2 & 1) == 1;
        boolean z2 = (i2 & 2) == 2;
        float f2 = this.f[i3] - this.d[i3];
        float f3 = this.g[i3] - this.e[i3];
        if (z && z2) {
            float f4 = f3 * f3;
            int i4 = this.b;
            if (f4 + (f2 * f2) > ((float) (i4 * i4))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f2) > ((float) this.b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f3) <= ((float) this.b)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isEdgeTouched(int i2, int i3) {
        return isPointerDown(i3) && (i2 & this.h[i3]) != 0;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f2, Interpolator interpolator, Callback callback) {
        ViewDragHelper create = create(viewGroup, interpolator, callback);
        create.b = (int) ((1.0f / f2) * ((float) create.b));
        return create;
    }
}
