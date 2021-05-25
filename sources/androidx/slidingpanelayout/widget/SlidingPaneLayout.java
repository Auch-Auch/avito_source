package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.Objects;
public class SlidingPaneLayout extends ViewGroup {
    public int a;
    public int b;
    public Drawable c;
    public Drawable d;
    public final int e;
    public boolean f;
    public View g;
    public float h;
    public float i;
    public int j;
    public boolean k;
    public int l;
    public float m;
    public float n;
    public PanelSlideListener o;
    public final ViewDragHelper p;
    public boolean q;
    public boolean r;
    public final Rect s;
    public final ArrayList<b> t;

    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f);
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f) {
        }
    }

    public class a extends AccessibilityDelegateCompat {
        public final Rect d = new Rect();

        public a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            Rect rect = this.d;
            obtain.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            obtain.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(obtain.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(obtain.getPackageName());
            accessibilityNodeInfoCompat.setClassName(obtain.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(obtain.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(obtain.isEnabled());
            accessibilityNodeInfoCompat.setClickable(obtain.isClickable());
            accessibilityNodeInfoCompat.setFocusable(obtain.isFocusable());
            accessibilityNodeInfoCompat.setFocused(obtain.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(obtain.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(obtain.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(obtain.isLongClickable());
            accessibilityNodeInfoCompat.addAction(obtain.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(obtain.getMovementGranularities());
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!SlidingPaneLayout.this.c(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!SlidingPaneLayout.this.c(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public final View a;

        public b(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getParent() == SlidingPaneLayout.this) {
                this.a.setLayerType(0, null);
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                View view = this.a;
                Objects.requireNonNull(slidingPaneLayout);
                ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).c);
            }
            SlidingPaneLayout.this.t.remove(this);
        }
    }

    public class c extends ViewDragHelper.Callback {
        public c() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.g.getLayoutParams();
            if (SlidingPaneLayout.this.d()) {
                int width = SlidingPaneLayout.this.getWidth() - (SlidingPaneLayout.this.g.getWidth() + (SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.j + paddingLeft);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.j;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.p.captureChildView(slidingPaneLayout.g, i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.g();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.p.getViewDragState() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.h == 0.0f) {
                    slidingPaneLayout.i(slidingPaneLayout.g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    View view = slidingPaneLayout2.g;
                    PanelSlideListener panelSlideListener = slidingPaneLayout2.o;
                    if (panelSlideListener != null) {
                        panelSlideListener.onPanelClosed(view);
                    }
                    slidingPaneLayout2.sendAccessibilityEvent(32);
                    SlidingPaneLayout.this.q = false;
                    return;
                }
                View view2 = slidingPaneLayout.g;
                PanelSlideListener panelSlideListener2 = slidingPaneLayout.o;
                if (panelSlideListener2 != null) {
                    panelSlideListener2.onPanelOpened(view2);
                }
                slidingPaneLayout.sendAccessibilityEvent(32);
                SlidingPaneLayout.this.q = true;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.g == null) {
                slidingPaneLayout.h = 0.0f;
            } else {
                boolean d = slidingPaneLayout.d();
                LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.g.getLayoutParams();
                int width = slidingPaneLayout.g.getWidth();
                if (d) {
                    i = (slidingPaneLayout.getWidth() - i) - width;
                }
                float paddingRight = ((float) (i - ((d ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft()) + (d ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin)))) / ((float) slidingPaneLayout.j);
                slidingPaneLayout.h = paddingRight;
                if (slidingPaneLayout.l != 0) {
                    slidingPaneLayout.f(paddingRight);
                }
                if (layoutParams.b) {
                    slidingPaneLayout.b(slidingPaneLayout.g, slidingPaneLayout.h, slidingPaneLayout.a);
                }
                View view2 = slidingPaneLayout.g;
                PanelSlideListener panelSlideListener = slidingPaneLayout.o;
                if (panelSlideListener != null) {
                    panelSlideListener.onPanelSlide(view2, slidingPaneLayout.h);
                }
            }
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.d()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.j;
                }
                i = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.g.getWidth();
            } else {
                i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 > 0 || (i2 == 0 && SlidingPaneLayout.this.h > 0.5f)) {
                    i += SlidingPaneLayout.this.j;
                }
            }
            SlidingPaneLayout.this.p.settleCapturedViewAt(i, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            if (SlidingPaneLayout.this.k) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).a;
        }
    }

    public static class d extends AbsSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();
        public boolean b;

        public static class a implements Parcelable.ClassLoaderCreator<d> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new d[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, null);
            this.b = parcel.readInt() != 0;
        }
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, null);
    }

    public final boolean a(int i2) {
        if (!this.r && !h(0.0f)) {
            return false;
        }
        this.q = false;
        return true;
    }

    public final void b(View view, float f2, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 > 0.0f && i2 != 0) {
            int i3 = (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24) | (i2 & ViewCompat.MEASURED_SIZE_MASK);
            if (layoutParams.c == null) {
                layoutParams.c = new Paint();
            }
            layoutParams.c.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.c);
            }
            ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).c);
        } else if (view.getLayerType() != 0) {
            Paint paint = layoutParams.c;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            b bVar = new b(view);
            this.t.add(bVar);
            ViewCompat.postOnAnimation(this, bVar);
        }
    }

    public boolean c(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.f || !layoutParams.b || this.h <= 0.0f) {
            return false;
        }
        return true;
    }

    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && canScroll(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z) {
            if (view.canScrollHorizontally(d() ? i2 : -i2)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.f;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean closePane() {
        return a(0);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.p.continueSettling(true)) {
            return;
        }
        if (!this.f) {
            this.p.abort();
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean d() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        int i2;
        int i3;
        super.draw(canvas);
        if (d()) {
            drawable = this.d;
        } else {
            drawable = this.c;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (d()) {
                i3 = childAt.getRight();
                i2 = intrinsicWidth + i3;
            } else {
                int left = childAt.getLeft();
                int i4 = left - intrinsicWidth;
                i2 = left;
                i3 = i4;
            }
            drawable.setBounds(i3, top, i2, bottom);
            drawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.f && !layoutParams.a && this.g != null) {
            canvas.getClipBounds(this.s);
            if (d()) {
                Rect rect = this.s;
                rect.left = Math.max(rect.left, this.g.getRight());
            } else {
                Rect rect2 = this.s;
                rect2.right = Math.min(rect2.right, this.g.getLeft());
            }
            canvas.clipRect(this.s);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        return drawChild;
    }

    public final boolean e(int i2) {
        if (!this.r && !h(1.0f)) {
            return false;
        }
        this.q = true;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.d()
            android.view.View r1 = r9.g
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.b
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x0059
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.g
            if (r4 != r5) goto L_0x002c
            goto L_0x0056
        L_0x002c:
            float r5 = r9.i
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.l
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.i = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0044
            int r5 = -r5
        L_0x0044:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0056
            float r5 = r9.i
            if (r0 == 0) goto L_0x004f
            float r5 = r5 - r6
            goto L_0x0051
        L_0x004f:
            float r5 = r6 - r5
        L_0x0051:
            int r6 = r9.b
            r9.b(r4, r5, r6)
        L_0x0056:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.f(float):void");
    }

    public void g() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.b;
    }

    @Px
    public int getParallaxDistance() {
        return this.l;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.a;
    }

    public boolean h(float f2) {
        int i2;
        if (!this.f) {
            return false;
        }
        boolean d2 = d();
        LayoutParams layoutParams = (LayoutParams) this.g.getLayoutParams();
        if (d2) {
            int paddingRight = getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int width = this.g.getWidth();
            i2 = (int) (((float) getWidth()) - (((f2 * ((float) this.j)) + ((float) paddingRight)) + ((float) width)));
        } else {
            i2 = (int) ((f2 * ((float) this.j)) + ((float) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin)));
        }
        ViewDragHelper viewDragHelper = this.p;
        View view = this.g;
        if (!viewDragHelper.smoothSlideViewTo(view, i2, view.getTop())) {
            return false;
        }
        g();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    public void i(View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        View childAt;
        boolean z;
        View view2 = view;
        boolean d2 = d();
        int width = d2 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = d2 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !view.isOpaque()) {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        } else {
            i5 = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount && (childAt = getChildAt(i6)) != view2) {
            if (childAt.getVisibility() == 8) {
                z = d2;
            } else {
                z = d2;
                childAt.setVisibility((Math.max(d2 ? paddingLeft : width, childAt.getLeft()) < i5 || Math.max(paddingTop, childAt.getTop()) < i3 || Math.min(d2 ? width : paddingLeft, childAt.getRight()) > i4 || Math.min(height, childAt.getBottom()) > i2) ? 0 : 4);
            }
            i6++;
            view2 = view;
            d2 = z;
        }
    }

    public boolean isOpen() {
        return !this.f || this.h == 1.0f;
    }

    public boolean isSlideable() {
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = true;
        int size = this.t.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.t.get(i2).run();
        }
        this.t.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.q = !this.p.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f || (this.k && actionMasked != 0)) {
            this.p.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.p.cancel();
            return false;
        } else {
            if (actionMasked == 0) {
                this.k = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.m = x;
                this.n = y;
                if (this.p.isViewUnder(this.g, (int) x, (int) y) && c(this.g)) {
                    z = true;
                    if (this.p.shouldInterceptTouchEvent(motionEvent) && !z) {
                        return false;
                    }
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.m);
                float abs2 = Math.abs(y2 - this.n);
                if (abs > ((float) this.p.getTouchSlop()) && abs2 > abs) {
                    this.p.cancel();
                    this.k = true;
                    return false;
                }
            }
            z = false;
            return this.p.shouldInterceptTouchEvent(motionEvent) ? true : true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean d2 = d();
        if (d2) {
            this.p.setEdgeTrackingEnabled(2);
        } else {
            this.p.setEdgeTrackingEnabled(1);
        }
        int i11 = i4 - i2;
        int paddingRight = d2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = d2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.r) {
            this.h = (!this.f || !this.q) ? 0.0f : 1.0f;
        }
        int i12 = paddingRight;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.a) {
                    int i14 = i11 - paddingLeft;
                    int min = (Math.min(paddingRight, i14 - this.e) - i12) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.j = min;
                    int i15 = d2 ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    layoutParams.b = (measuredWidth / 2) + ((i12 + i15) + min) > i14;
                    int i16 = (int) (((float) min) * this.h);
                    i7 = i15 + i16 + i12;
                    this.h = ((float) i16) / ((float) min);
                    i6 = 0;
                } else if (!this.f || (i10 = this.l) == 0) {
                    i7 = paddingRight;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.h) * ((float) i10));
                    i7 = paddingRight;
                }
                if (d2) {
                    i8 = (i11 - i7) + i6;
                    i9 = i8 - measuredWidth;
                } else {
                    i9 = i7 - i6;
                    i8 = i9 + measuredWidth;
                }
                childAt.layout(i9, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                i12 = i7;
                paddingRight = childAt.getWidth() + paddingRight;
            }
        }
        if (this.r) {
            if (this.f) {
                if (this.l != 0) {
                    f(this.h);
                }
                if (((LayoutParams) this.g.getLayoutParams()).b) {
                    b(this.g, this.h, this.a);
                }
            } else {
                for (int i17 = 0; i17 < childCount; i17++) {
                    b(getChildAt(i17), 0.0f, this.a);
                }
            }
            i(this.g);
        }
        this.r = false;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float f2;
        int i12;
        int i13;
        int i14;
        int i15;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i5 = 0;
        } else if (mode2 != 1073741824) {
            i5 = 0;
            i4 = 0;
        } else {
            i5 = (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = i5;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.g = null;
        int i16 = paddingLeft;
        int i17 = 0;
        boolean z2 = false;
        float f3 = 0.0f;
        while (true) {
            i6 = 8;
            if (i17 >= childCount) {
                break;
            }
            View childAt = getChildAt(i17);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.b = z;
            } else {
                float f4 = layoutParams.weight;
                if (f4 > 0.0f) {
                    f3 += f4;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                    }
                }
                int i18 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int i19 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i19 == -2) {
                    i12 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i18, Integer.MIN_VALUE);
                    f2 = f3;
                    i13 = Integer.MIN_VALUE;
                } else {
                    f2 = f3;
                    i13 = Integer.MIN_VALUE;
                    if (i19 == -1) {
                        i12 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i18, 1073741824);
                    } else {
                        i12 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                    }
                }
                int i20 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i20 == -2) {
                    i14 = View.MeasureSpec.makeMeasureSpec(i4, i13);
                } else {
                    if (i20 == -1) {
                        i15 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    } else {
                        i15 = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
                    }
                    i14 = i15;
                }
                childAt.measure(i12, i14);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == i13 && measuredHeight > i5) {
                    i5 = Math.min(measuredHeight, i4);
                }
                i16 -= measuredWidth;
                boolean z3 = i16 < 0;
                layoutParams.a = z3;
                z2 |= z3;
                if (z3) {
                    this.g = childAt;
                }
                f3 = f2;
            }
            i17++;
            z = false;
        }
        if (z2 || f3 > 0.0f) {
            int i21 = paddingLeft - this.e;
            int i22 = 0;
            while (i22 < childCount) {
                View childAt2 = getChildAt(i22);
                if (childAt2.getVisibility() != i6) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i6) {
                        boolean z4 = ((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.weight > 0.0f;
                        if (z4) {
                            i8 = 0;
                        } else {
                            i8 = childAt2.getMeasuredWidth();
                        }
                        if (!z2 || childAt2 == this.g) {
                            if (layoutParams2.weight > 0.0f) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                    int i23 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (i23 == -2) {
                                        i9 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                    } else if (i23 == -1) {
                                        i9 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                    } else {
                                        i9 = View.MeasureSpec.makeMeasureSpec(i23, 1073741824);
                                    }
                                } else {
                                    i9 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z2) {
                                    int i24 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                    i7 = i21;
                                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i24, 1073741824);
                                    if (i8 != i24) {
                                        childAt2.measure(makeMeasureSpec, i9);
                                    }
                                    i22++;
                                    i21 = i7;
                                    i6 = 8;
                                } else {
                                    i7 = i21;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i8 + ((int) ((layoutParams2.weight * ((float) Math.max(0, i16))) / f3)), 1073741824), i9);
                                    i22++;
                                    i21 = i7;
                                    i6 = 8;
                                }
                            }
                        } else if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (i8 > i21 || layoutParams2.weight > 0.0f)) {
                            if (z4) {
                                int i25 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                if (i25 == -2) {
                                    i11 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                    i10 = 1073741824;
                                } else if (i25 == -1) {
                                    i10 = 1073741824;
                                    i11 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                } else {
                                    i10 = 1073741824;
                                    i11 = View.MeasureSpec.makeMeasureSpec(i25, 1073741824);
                                }
                            } else {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i21, i10), i11);
                        }
                    }
                }
                i7 = i21;
                i22++;
                i21 = i7;
                i6 = 8;
            }
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i5);
        this.f = z2;
        if (this.p.getViewDragState() != 0 && !z2) {
            this.p.abort();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        if (dVar.b) {
            openPane();
        } else {
            closePane();
        }
        this.q = dVar.b;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.b = isSlideable() ? isOpen() : this.q;
        return dVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.r = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f) {
            return super.onTouchEvent(motionEvent);
        }
        this.p.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.m = x;
            this.n = y;
        } else if (actionMasked == 1 && c(this.g)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x2 - this.m;
            float f3 = y2 - this.n;
            int touchSlop = this.p.getTouchSlop();
            if ((f3 * f3) + (f2 * f2) < ((float) (touchSlop * touchSlop)) && this.p.isViewUnder(this.g, (int) x2, (int) y2)) {
                a(0);
            }
        }
        return true;
    }

    public boolean openPane() {
        return e(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f) {
            this.q = view == this.g;
        }
    }

    public void setCoveredFadeColor(@ColorInt int i2) {
        this.b = i2;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        this.o = panelSlideListener;
    }

    public void setParallaxDistance(@Px int i2) {
        this.l = i2;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.c = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.d = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setShadowResourceLeft(int i2) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setShadowResourceRight(int i2) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setSliderFadeColor(@ColorInt int i2) {
        this.a = i2;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int[] d = {16843137};
        public boolean a;
        public boolean b;
        public Paint c;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.weight = layoutParams.weight;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = -858993460;
        this.r = true;
        this.s = new Rect();
        this.t = new ArrayList<>();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.e = (int) ((32.0f * f2) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new a());
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new c());
        this.p = create;
        create.setMinVelocity(f2 * 400.0f);
    }
}
