package ru.rambler.libs.swipe_layout;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.rds.swipelayout.R;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
public class SwipeLayout extends ViewGroup {
    public static final String p = SwipeLayout.class.getSimpleName();
    public ViewDragHelper a;
    public View b;
    public View c;
    public View d;
    public float e;
    public float f;
    public OnSwipeListener g;
    public WeakReference<ObjectAnimator> h;
    public final Map<View, Boolean> i = new WeakHashMap();
    public boolean j = true;
    public boolean k = true;
    public int l = 0;
    public float m;
    public float n;
    public final ViewDragHelper.Callback o = new a();

    public interface OnSwipeListener {
        void onBeginSwipe(SwipeLayout swipeLayout, boolean z);

        void onLeftStickyEdge(SwipeLayout swipeLayout, boolean z);

        void onRightStickyEdge(SwipeLayout swipeLayout, boolean z);

        void onSwipeClampReached(SwipeLayout swipeLayout, boolean z);
    }

    public class a extends ViewDragHelper.Callback {
        public int a;

        public a() {
        }

        public final int a(View view, int i) {
            int i2;
            SwipeLayout swipeLayout = SwipeLayout.this;
            View view2 = swipeLayout.c;
            if (view2 == null) {
                if (view == swipeLayout.d) {
                    i2 = 0;
                } else {
                    i2 = -view.getWidth();
                }
                return Math.max(i, i2);
            }
            LayoutParams a3 = SwipeLayout.a(swipeLayout, view2);
            int i3 = a3.d;
            if (i3 == -2) {
                return Math.max(i, (view.getLeft() + (SwipeLayout.this.getWidth() - SwipeLayout.this.c.getLeft())) - SwipeLayout.this.c.getWidth());
            } else if (i3 == -1) {
                return Math.max(view.getLeft() - SwipeLayout.this.c.getLeft(), i);
            } else {
                return Math.max(i, (view.getLeft() + (SwipeLayout.this.getWidth() - SwipeLayout.this.c.getLeft())) - a3.d);
            }
        }

        public final int b(View view, int i) {
            int i2;
            SwipeLayout swipeLayout = SwipeLayout.this;
            View view2 = swipeLayout.b;
            if (view2 == null) {
                if (view == swipeLayout.d) {
                    i2 = 0;
                } else {
                    i2 = swipeLayout.getWidth();
                }
                return Math.min(i, i2);
            }
            LayoutParams a3 = SwipeLayout.a(swipeLayout, view2);
            int i3 = a3.d;
            if (i3 == -2) {
                return Math.min(i, view.getLeft() - SwipeLayout.this.b.getLeft());
            }
            if (i3 != -1) {
                return Math.min(i, (view.getLeft() - SwipeLayout.this.b.getRight()) + a3.d);
            }
            return Math.min(i, (view.getLeft() + SwipeLayout.this.getWidth()) - SwipeLayout.this.b.getRight());
        }

        public final int c(View view) {
            int i = SwipeLayout.a(SwipeLayout.this, view).b;
            if (i == -2) {
                return -2;
            }
            return i == -1 ? view.getWidth() : i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (i2 > 0) {
                return b(view, i);
            }
            return a(view, i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x009f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean d(android.view.View r9, int r10, float r11) {
            /*
            // Method dump skipped, instructions count: 349
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.rambler.libs.swipe_layout.SwipeLayout.a.d(android.view.View, int, float):boolean");
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean e(android.view.View r9, int r10, float r11) {
            /*
            // Method dump skipped, instructions count: 316
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.rambler.libs.swipe_layout.SwipeLayout.a.e(android.view.View, int, float):boolean");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SwipeLayout.this.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            int c;
            int c2;
            int c3;
            int c4;
            SwipeLayout swipeLayout = SwipeLayout.this;
            String str = SwipeLayout.p;
            swipeLayout.f(view, i3);
            SwipeLayout swipeLayout2 = SwipeLayout.this;
            if (swipeLayout2.g != null) {
                if (i3 > 0) {
                    View view2 = swipeLayout2.b;
                    if (view2 != null && (c4 = c(view2)) != -2 && SwipeLayout.this.b.getRight() - c4 > 0 && (SwipeLayout.this.b.getRight() - c4) - i3 <= 0) {
                        SwipeLayout swipeLayout3 = SwipeLayout.this;
                        swipeLayout3.g.onLeftStickyEdge(swipeLayout3, true);
                    }
                    View view3 = SwipeLayout.this.c;
                    if (view3 != null && (c3 = c(view3)) != -2 && SwipeLayout.this.c.getLeft() + c3 > SwipeLayout.this.getWidth() && (SwipeLayout.this.c.getLeft() + c3) - i3 <= SwipeLayout.this.getWidth()) {
                        SwipeLayout swipeLayout4 = SwipeLayout.this;
                        swipeLayout4.g.onRightStickyEdge(swipeLayout4, true);
                    }
                } else if (i3 < 0) {
                    View view4 = swipeLayout2.b;
                    if (view4 != null && (c2 = c(view4)) != -2 && SwipeLayout.this.b.getRight() - c2 <= 0 && (SwipeLayout.this.b.getRight() - c2) - i3 > 0) {
                        SwipeLayout swipeLayout5 = SwipeLayout.this;
                        swipeLayout5.g.onLeftStickyEdge(swipeLayout5, false);
                    }
                    View view5 = SwipeLayout.this.c;
                    if (view5 != null && (c = c(view5)) != -2 && SwipeLayout.this.c.getLeft() + c <= SwipeLayout.this.getWidth() && (SwipeLayout.this.c.getLeft() + c) - i3 > SwipeLayout.this.getWidth()) {
                        SwipeLayout swipeLayout6 = SwipeLayout.this;
                        swipeLayout6.g.onRightStickyEdge(swipeLayout6, false);
                    }
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            boolean z;
            String str = SwipeLayout.p;
            String str2 = SwipeLayout.p;
            float f3 = SwipeLayout.this.e;
            int left = view.getLeft() - this.a;
            if (left != 0) {
                if (left > 0) {
                    z = f >= 0.0f ? e(view, left, f) : d(view, left, f);
                } else {
                    z = f <= 0.0f ? d(view, left, f) : e(view, left, f);
                }
                if (!z) {
                    SwipeLayout.b(SwipeLayout.this, view, view.getLeft() - SwipeLayout.this.d.getLeft(), false, left > 0);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            this.a = view.getLeft();
            return true;
        }
    }

    public class b implements Runnable {
        public final View a;
        public final boolean b;
        public final boolean c;

        public b(View view, boolean z, boolean z2) {
            this.a = view;
            this.b = z;
            this.c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwipeLayout swipeLayout;
            OnSwipeListener onSwipeListener;
            ViewDragHelper viewDragHelper = SwipeLayout.this.a;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                String str = SwipeLayout.p;
                String str2 = SwipeLayout.p;
                boolean z = this.b;
                boolean z2 = this.c;
                if (z && (onSwipeListener = (swipeLayout = SwipeLayout.this).g) != null) {
                    onSwipeListener.onSwipeClampReached(swipeLayout, z2);
                    return;
                }
                return;
            }
            ViewCompat.postOnAnimation(this.a, this);
        }
    }

    public SwipeLayout(Context context) {
        super(context);
        d(context, null);
    }

    public static LayoutParams a(SwipeLayout swipeLayout, View view) {
        Objects.requireNonNull(swipeLayout);
        return (LayoutParams) view.getLayoutParams();
    }

    public static void b(SwipeLayout swipeLayout, View view, int i2, boolean z, boolean z2) {
        OnSwipeListener onSwipeListener;
        if (swipeLayout.a.settleCapturedViewAt(i2, view.getTop())) {
            ViewCompat.postOnAnimation(view, new b(view, z, z2));
        } else if (z && (onSwipeListener = swipeLayout.g) != null) {
            onSwipeListener.onSwipeClampReached(swipeLayout, z2);
        }
    }

    public void animateReset() {
        if (this.d != null) {
            c();
            this.a.abort();
            ObjectAnimator objectAnimator = new ObjectAnimator();
            objectAnimator.setTarget(this);
            objectAnimator.setPropertyName("offset");
            objectAnimator.setInterpolator(new AccelerateInterpolator());
            objectAnimator.setIntValues(this.d.getLeft(), 0);
            objectAnimator.setDuration(200L);
            objectAnimator.start();
            this.h = new WeakReference<>(objectAnimator);
        }
    }

    public final void c() {
        ObjectAnimator objectAnimator;
        WeakReference<ObjectAnimator> weakReference = this.h;
        if (weakReference != null && (objectAnimator = weakReference.get()) != null) {
            this.h.clear();
            if (objectAnimator.isRunning()) {
                objectAnimator.end();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void d(Context context, AttributeSet attributeSet) {
        this.a = ViewDragHelper.create(this, 1.0f, this.o);
        this.e = TypedValue.applyDimension(1, 1500.0f, getResources().getDisplayMetrics());
        this.f = (float) ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeLayout);
            int i2 = R.styleable.SwipeLayout_swipe_enabled;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.j = obtainStyledAttributes.getBoolean(i2, true);
                this.k = obtainStyledAttributes.getBoolean(i2, true);
            }
            int i3 = R.styleable.SwipeLayout_left_swipe_enabled;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.j = obtainStyledAttributes.getBoolean(i3, true);
            }
            int i4 = R.styleable.SwipeLayout_right_swipe_enabled;
            if (obtainStyledAttributes.hasValue(i4)) {
                this.k = obtainStyledAttributes.getBoolean(i4, true);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void e() {
        int i2;
        int childCount = getChildCount();
        int paddingTop = getPaddingTop();
        this.d = null;
        this.b = null;
        this.c = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int i4 = ((LayoutParams) childAt.getLayoutParams()).a;
                if (i4 == -1) {
                    this.b = childAt;
                } else if (i4 == 0) {
                    this.d = childAt;
                } else if (i4 == 1) {
                    this.c = childAt;
                }
            }
        }
        if (this.d != null) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getVisibility() != 8) {
                    int measuredWidth = childAt2.getMeasuredWidth();
                    int measuredHeight = childAt2.getMeasuredHeight();
                    int i6 = ((LayoutParams) childAt2.getLayoutParams()).a;
                    if (i6 == -1) {
                        i2 = this.d.getLeft() - measuredWidth;
                    } else if (i6 != 1) {
                        i2 = childAt2.getLeft();
                    } else {
                        i2 = this.d.getRight();
                    }
                    childAt2.layout(i2, paddingTop, measuredWidth + i2, measuredHeight + paddingTop);
                }
            }
            return;
        }
        throw new RuntimeException("Center view must be added");
    }

    public final void f(View view, int i2) {
        if (i2 != 0) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view) {
                    childAt.offsetLeftAndRight(i2);
                    invalidate(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                }
            }
        }
    }

    public int getOffset() {
        View view = this.d;
        if (view == null) {
            return 0;
        }
        return view.getLeft();
    }

    public boolean isLeftSwipeEnabled() {
        return this.j;
    }

    public boolean isRightSwipeEnabled() {
        return this.k;
    }

    public boolean isSwipeEnabled() {
        return this.j || this.k;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isSwipeEnabled()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0) {
            this.l = 0;
            this.m = motionEvent.getX();
            this.n = motionEvent.getY();
        }
        return this.a.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        e();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int childCount = getChildCount();
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            measureChildren(i2, i3);
            i4 = 0;
        } else {
            i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                measureChild(childAt, i2, i3);
                i4 = Math.max(i4, childAt.getMeasuredHeight());
            }
            if (i4 > 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                measureChildren(i2, i3);
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            if (childAt2.getVisibility() != 8) {
                i4 = Math.max(i4, childAt2.getMeasuredHeight());
            }
        }
        setMeasuredDimension(ViewGroup.resolveSize(getSuggestedMinimumWidth(), i2), ViewGroup.resolveSize(Math.max(getPaddingBottom() + getPaddingTop() + i4, getSuggestedMinimumHeight()), i3));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r1 != 3) goto L_0x00f4;
     */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
        // Method dump skipped, instructions count: 260
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.rambler.libs.swipe_layout.SwipeLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void reset() {
        if (this.d != null) {
            c();
            this.a.abort();
            f(null, -this.d.getLeft());
        }
    }

    public void setLeftSwipeEnabled(boolean z) {
        this.j = z;
    }

    public void setOffset(int i2) {
        View view = this.d;
        if (view != null) {
            f(null, i2 - view.getLeft());
        }
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener) {
        this.g = onSwipeListener;
    }

    public void setRightSwipeEnabled(boolean z) {
        this.k = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.j = z;
        this.k = z;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context, attributeSet);
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d(context, attributeSet);
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static final int BRING_TO_CLAMP_NO = -1;
        public static final int CENTER = 0;
        public static final int CLAMP_PARENT = -1;
        public static final int CLAMP_SELF = -2;
        public static final int LEFT = -1;
        public static final int RIGHT = 1;
        public static final int STICKY_NONE = -2;
        public static final int STICKY_SELF = -1;
        public int a = 0;
        public int b;
        public float c = 0.9f;
        public int d = -2;
        public int e = -1;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.SwipeLayout_gravity) {
                    this.a = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.SwipeLayout_sticky) {
                    this.b = obtainStyledAttributes.getLayoutDimension(index, -1);
                } else if (index == R.styleable.SwipeLayout_clamp) {
                    this.d = obtainStyledAttributes.getLayoutDimension(index, -2);
                } else if (index == R.styleable.SwipeLayout_bring_to_clamp) {
                    this.e = obtainStyledAttributes.getLayoutDimension(index, -1);
                } else if (index == R.styleable.SwipeLayout_sticky_sensitivity) {
                    this.c = obtainStyledAttributes.getFloat(index, 0.9f);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }
}
