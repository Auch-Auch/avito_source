package com.sothree.slidinguppanel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.sothree.slidinguppanel.ViewDragHelper;
import java.util.List;
public class SlidingUpPanelLayout extends ViewGroup {
    public static final String I = SlidingUpPanelLayout.class.getSimpleName();
    public static PanelState J = PanelState.COLLAPSED;
    public static final int[] K = {16842927};
    public static final String SLIDING_STATE = "sliding_state";
    public float A;
    public float B;
    public boolean C;
    public final List<PanelSlideListener> D;
    public View.OnClickListener E;
    public final ViewDragHelper F;
    public boolean G;
    public final Rect H;
    public int a;
    public int b;
    public final Paint c;
    public final Drawable d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public View k;
    public int l;
    public View m;
    public int n;
    public ScrollableViewHelper o;
    public View p;
    public View q;
    public PanelState r;
    public PanelState s;
    public float t;
    public int u;
    public float v;
    public boolean w;
    public boolean x;
    public float y;
    public float z;

    public interface PanelSlideListener {
        void onPanelSlide(View view, float f);

        void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2);
    }

    public enum PanelState {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
        public void onPanelSlide(View view, float f) {
        }

        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
        public void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2) {
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PanelState panelState;
            if (SlidingUpPanelLayout.this.isEnabled() && SlidingUpPanelLayout.this.isTouchEnabled()) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                PanelState panelState2 = slidingUpPanelLayout.r;
                PanelState panelState3 = PanelState.EXPANDED;
                if (panelState2 == panelState3 || panelState2 == (panelState = PanelState.ANCHORED)) {
                    slidingUpPanelLayout.setPanelState(PanelState.COLLAPSED);
                } else if (slidingUpPanelLayout.v < 1.0f) {
                    slidingUpPanelLayout.setPanelState(panelState);
                } else {
                    slidingUpPanelLayout.setPanelState(panelState3);
                }
            }
        }
    }

    public class b extends ViewDragHelper.Callback {
        public b(a aVar) {
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
            String str = SlidingUpPanelLayout.I;
            int d = slidingUpPanelLayout.d(0.0f);
            int d2 = SlidingUpPanelLayout.this.d(1.0f);
            if (SlidingUpPanelLayout.this.h) {
                return Math.min(Math.max(i, d2), d);
            }
            return Math.min(Math.max(i, d), d2);
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return SlidingUpPanelLayout.this.u;
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            SlidingUpPanelLayout.this.g();
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            ViewDragHelper viewDragHelper = SlidingUpPanelLayout.this.F;
            if (viewDragHelper != null && viewDragHelper.getViewDragState() == 0) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                slidingUpPanelLayout.t = slidingUpPanelLayout.e(slidingUpPanelLayout.p.getTop());
                SlidingUpPanelLayout.this.c();
                SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                float f = slidingUpPanelLayout2.t;
                if (f == 1.0f) {
                    slidingUpPanelLayout2.i();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.EXPANDED);
                } else if (f == 0.0f) {
                    slidingUpPanelLayout2.setPanelStateInternal(PanelState.COLLAPSED);
                } else if (f < 0.0f) {
                    slidingUpPanelLayout2.setPanelStateInternal(PanelState.HIDDEN);
                    SlidingUpPanelLayout.this.p.setVisibility(4);
                } else {
                    slidingUpPanelLayout2.i();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.ANCHORED);
                }
            }
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.a(SlidingUpPanelLayout.this, i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewReleased(android.view.View r6, float r7, float r8) {
            /*
                r5 = this;
                com.sothree.slidinguppanel.SlidingUpPanelLayout r7 = com.sothree.slidinguppanel.SlidingUpPanelLayout.this
                boolean r0 = r7.h
                if (r0 == 0) goto L_0x0007
                float r8 = -r8
            L_0x0007:
                r0 = 0
                int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r1 <= 0) goto L_0x0019
                float r2 = r7.t
                float r3 = r7.v
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 > 0) goto L_0x0019
                int r7 = r7.d(r3)
                goto L_0x006b
            L_0x0019:
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r1 <= 0) goto L_0x002a
                float r1 = r7.t
                float r3 = r7.v
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 <= 0) goto L_0x002a
                int r7 = r7.d(r2)
                goto L_0x006b
            L_0x002a:
                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r8 >= 0) goto L_0x003b
                float r1 = r7.t
                float r3 = r7.v
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 < 0) goto L_0x003b
                int r7 = r7.d(r3)
                goto L_0x006b
            L_0x003b:
                if (r8 >= 0) goto L_0x004a
                float r8 = r7.t
                float r1 = r7.v
                int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r8 >= 0) goto L_0x004a
                int r7 = r7.d(r0)
                goto L_0x006b
            L_0x004a:
                float r8 = r7.t
                float r1 = r7.v
                float r3 = r1 + r2
                r4 = 1073741824(0x40000000, float:2.0)
                float r3 = r3 / r4
                int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r3 < 0) goto L_0x005c
                int r7 = r7.d(r2)
                goto L_0x006b
            L_0x005c:
                float r2 = r1 / r4
                int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r8 < 0) goto L_0x0067
                int r7 = r7.d(r1)
                goto L_0x006b
            L_0x0067:
                int r7 = r7.d(r0)
            L_0x006b:
                com.sothree.slidinguppanel.SlidingUpPanelLayout r8 = com.sothree.slidinguppanel.SlidingUpPanelLayout.this
                com.sothree.slidinguppanel.ViewDragHelper r8 = r8.F
                if (r8 == 0) goto L_0x0078
                int r6 = r6.getLeft()
                r8.settleCapturedViewAt(r6, r7)
            L_0x0078:
                com.sothree.slidinguppanel.SlidingUpPanelLayout r6 = com.sothree.slidinguppanel.SlidingUpPanelLayout.this
                r6.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.b.onViewReleased(android.view.View, float, float):void");
        }

        @Override // com.sothree.slidinguppanel.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
            return !slidingUpPanelLayout.w && view == slidingUpPanelLayout.p;
        }
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, null);
    }

    public static void a(SlidingUpPanelLayout slidingUpPanelLayout, int i2) {
        PanelState panelState = slidingUpPanelLayout.r;
        PanelState panelState2 = PanelState.DRAGGING;
        if (panelState != panelState2) {
            slidingUpPanelLayout.s = panelState;
        }
        slidingUpPanelLayout.setPanelStateInternal(panelState2);
        slidingUpPanelLayout.t = slidingUpPanelLayout.e(i2);
        slidingUpPanelLayout.c();
        View view = slidingUpPanelLayout.p;
        synchronized (slidingUpPanelLayout.D) {
            for (PanelSlideListener panelSlideListener : slidingUpPanelLayout.D) {
                panelSlideListener.onPanelSlide(view, slidingUpPanelLayout.t);
            }
        }
        LayoutParams layoutParams = (LayoutParams) slidingUpPanelLayout.q.getLayoutParams();
        int height = ((slidingUpPanelLayout.getHeight() - slidingUpPanelLayout.getPaddingBottom()) - slidingUpPanelLayout.getPaddingTop()) - slidingUpPanelLayout.e;
        if (slidingUpPanelLayout.t <= 0.0f && !slidingUpPanelLayout.i) {
            int paddingBottom = slidingUpPanelLayout.h ? i2 - slidingUpPanelLayout.getPaddingBottom() : ((slidingUpPanelLayout.getHeight() - slidingUpPanelLayout.getPaddingBottom()) - slidingUpPanelLayout.p.getMeasuredHeight()) - i2;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = paddingBottom;
            if (paddingBottom == height) {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
            }
            slidingUpPanelLayout.q.requestLayout();
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).height != -1 && !slidingUpPanelLayout.i) {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
            slidingUpPanelLayout.q.requestLayout();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPanelStateInternal(PanelState panelState) {
        PanelState panelState2 = this.r;
        if (panelState2 != panelState) {
            this.r = panelState;
            synchronized (this.D) {
                for (PanelSlideListener panelSlideListener : this.D) {
                    panelSlideListener.onPanelStateChanged(this, panelState2, panelState);
                }
            }
            sendAccessibilityEvent(32);
        }
    }

    public void addPanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.D) {
            this.D.add(panelSlideListener);
        }
    }

    @SuppressLint({"NewApi"})
    public final void c() {
        if (this.g > 0) {
            ViewCompat.setTranslationY(this.q, (float) getCurrentParallaxOffset());
        }
    }

    public boolean canScroll(View view, boolean z2, int i2, int i3, int i4) {
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
        if (!z2 || !ViewCompat.canScrollHorizontally(view, -i2)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.F;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            if (!isEnabled()) {
                this.F.abort();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    public final int d(float f2) {
        View view = this.p;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int i2 = (int) (f2 * ((float) this.u));
        if (this.h) {
            return ((getMeasuredHeight() - getPaddingBottom()) - this.e) - i2;
        }
        return (getPaddingTop() - measuredHeight) + this.e + i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (!isEnabled() || !isTouchEnabled() || (this.w && actionMasked != 0)) {
            this.F.abort();
            return super.dispatchTouchEvent(motionEvent);
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (actionMasked == 0) {
            this.C = false;
            this.y = x2;
            this.z = y2;
        } else if (actionMasked == 2) {
            float f2 = y2 - this.z;
            this.y = x2;
            this.z = y2;
            if (Math.abs(x2 - this.y) > Math.abs(f2)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (!f(this.m, (int) this.A, (int) this.B)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            boolean z2 = this.h;
            int i2 = -1;
            if (((float) (z2 ? 1 : -1)) * f2 <= 0.0f) {
                if (z2) {
                    i2 = 1;
                }
                if (f2 * ((float) i2) < 0.0f) {
                    if (this.t < 1.0f) {
                        this.C = false;
                        return onTouchEvent(motionEvent);
                    }
                    if (!this.C && this.F.isDragging()) {
                        this.F.cancel();
                        motionEvent.setAction(0);
                    }
                    this.C = true;
                    return super.dispatchTouchEvent(motionEvent);
                }
            } else if (this.o.getScrollableViewScrollPosition(this.m, z2) > 0) {
                this.C = true;
                return super.dispatchTouchEvent(motionEvent);
            } else {
                if (this.C) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.dispatchTouchEvent(obtain);
                    obtain.recycle();
                    motionEvent.setAction(0);
                }
                this.C = false;
                return onTouchEvent(motionEvent);
            }
        } else if (actionMasked == 1 && this.C) {
            this.F.m(0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        View view;
        int i2;
        int i3;
        super.draw(canvas);
        if (this.d != null && (view = this.p) != null) {
            int right = view.getRight();
            if (this.h) {
                i3 = this.p.getTop() - this.f;
                i2 = this.p.getTop();
            } else {
                i3 = this.p.getBottom();
                i2 = this.p.getBottom() + this.f;
            }
            this.d.setBounds(this.p.getLeft(), i3, right, i2);
            this.d.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z2;
        int save = canvas.save(2);
        View view2 = this.p;
        if (view2 == null || view2 == view) {
            z2 = super.drawChild(canvas, view, j2);
        } else {
            canvas.getClipBounds(this.H);
            if (!this.i) {
                if (this.h) {
                    Rect rect = this.H;
                    rect.bottom = Math.min(rect.bottom, this.p.getTop());
                } else {
                    Rect rect2 = this.H;
                    rect2.top = Math.max(rect2.top, this.p.getBottom());
                }
            }
            if (this.j) {
                canvas.clipRect(this.H);
            }
            z2 = super.drawChild(canvas, view, j2);
            int i2 = this.b;
            if (i2 != 0) {
                float f2 = this.t;
                if (f2 > 0.0f) {
                    this.c.setColor((i2 & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24));
                    canvas.drawRect(this.H, this.c);
                }
            }
        }
        canvas.restoreToCount(save);
        return z2;
    }

    public final float e(int i2) {
        int d2 = d(0.0f);
        return (this.h ? (float) (d2 - i2) : (float) (i2 - d2)) / ((float) this.u);
    }

    public final boolean f(View view, int i2, int i3) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i4 = iArr2[0] + i2;
        int i5 = iArr2[1] + i3;
        if (i4 < iArr[0]) {
            return false;
        }
        if (i4 >= view.getWidth() + iArr[0] || i5 < iArr[1]) {
            return false;
        }
        if (i5 < view.getHeight() + iArr[1]) {
            return true;
        }
        return false;
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

    public float getAnchorPoint() {
        return this.v;
    }

    public int getCoveredFadeColor() {
        return this.b;
    }

    public int getCurrentParallaxOffset() {
        int max = (int) (Math.max(this.t, 0.0f) * ((float) this.g));
        return this.h ? -max : max;
    }

    public int getMinFlingVelocity() {
        return this.a;
    }

    public int getPanelHeight() {
        return this.e;
    }

    public PanelState getPanelState() {
        return this.r;
    }

    public int getShadowHeight() {
        return this.f;
    }

    public boolean h(float f2) {
        if (isEnabled() && this.p != null) {
            int d2 = d(f2);
            ViewDragHelper viewDragHelper = this.F;
            View view = this.p;
            if (viewDragHelper.smoothSlideViewTo(view, view.getLeft(), d2)) {
                g();
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
        }
        return false;
    }

    public void i() {
        int i2;
        int i3;
        int i4;
        int i5;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            View view = this.p;
            int i6 = 0;
            if (view != null) {
                Drawable background = view.getBackground();
                if (background != null && background.getOpacity() == -1) {
                    i5 = this.p.getLeft();
                    i4 = this.p.getRight();
                    i3 = this.p.getTop();
                    i2 = this.p.getBottom();
                    View childAt = getChildAt(0);
                    int max = Math.max(paddingLeft, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    int min = Math.min(width, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max >= i5 && max2 >= i3 && min <= i4 && min2 <= i2) {
                        i6 = 4;
                    }
                    childAt.setVisibility(i6);
                }
            }
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            View childAt = getChildAt(0);
            int max = Math.max(paddingLeft, childAt.getLeft());
            int max2 = Math.max(paddingTop, childAt.getTop());
            int min = Math.min(width, childAt.getRight());
            int min2 = Math.min(height, childAt.getBottom());
            i6 = 4;
            childAt.setVisibility(i6);
        }
    }

    public boolean isClipPanel() {
        return this.j;
    }

    public boolean isOverlayed() {
        return this.i;
    }

    public boolean isTouchEnabled() {
        return (!this.x || this.p == null || this.r == PanelState.HIDDEN) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.G = true;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.l;
        if (i2 != -1) {
            setDragView(findViewById(i2));
        }
        int i3 = this.n;
        if (i3 != -1) {
            setScrollableView(findViewById(i3));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r0 != 3) goto L_0x009d;
     */
    @Override // android.view.ViewGroup
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.C
            r1 = 0
            if (r0 != 0) goto L_0x00a4
            boolean r0 = r8.isTouchEnabled()
            if (r0 != 0) goto L_0x000d
            goto L_0x00a4
        L_0x000d:
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r9)
            float r2 = r9.getX()
            float r3 = r9.getY()
            float r4 = r8.A
            float r4 = r2 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r8.B
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            com.sothree.slidinguppanel.ViewDragHelper r6 = r8.F
            int r6 = r6.getTouchSlop()
            r7 = 1
            if (r0 == 0) goto L_0x0085
            if (r0 == r7) goto L_0x004c
            r2 = 2
            if (r0 == r2) goto L_0x003b
            r2 = 3
            if (r0 == r2) goto L_0x004c
            goto L_0x009d
        L_0x003b:
            float r0 = (float) r6
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            int r0 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            com.sothree.slidinguppanel.ViewDragHelper r9 = r8.F
            r9.cancel()
            r8.w = r7
            return r1
        L_0x004c:
            com.sothree.slidinguppanel.ViewDragHelper r0 = r8.F
            boolean r0 = r0.isDragging()
            if (r0 == 0) goto L_0x005a
            com.sothree.slidinguppanel.ViewDragHelper r0 = r8.F
            r0.processTouchEvent(r9)
            return r7
        L_0x005a:
            float r0 = (float) r6
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x009d
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x009d
            float r0 = r8.t
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            android.view.View r0 = r8.p
            float r2 = r8.A
            int r2 = (int) r2
            float r3 = r8.B
            int r3 = (int) r3
            boolean r0 = r8.f(r0, r2, r3)
            if (r0 != 0) goto L_0x009d
            android.view.View$OnClickListener r0 = r8.E
            if (r0 == 0) goto L_0x009d
            r8.playSoundEffect(r1)
            android.view.View$OnClickListener r9 = r8.E
            r9.onClick(r8)
            return r7
        L_0x0085:
            r8.w = r1
            r8.A = r2
            r8.B = r3
            android.view.View r0 = r8.k
            int r2 = (int) r2
            int r3 = (int) r3
            boolean r0 = r8.f(r0, r2, r3)
            if (r0 != 0) goto L_0x009d
            com.sothree.slidinguppanel.ViewDragHelper r9 = r8.F
            r9.cancel()
            r8.w = r7
            return r1
        L_0x009d:
            com.sothree.slidinguppanel.ViewDragHelper r0 = r8.F
            boolean r9 = r0.shouldInterceptTouchEvent(r9)
            return r9
        L_0x00a4:
            com.sothree.slidinguppanel.ViewDragHelper r9 = r8.F
            r9.abort()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.G) {
            int ordinal = this.r.ordinal();
            if (ordinal == 0) {
                this.t = 1.0f;
            } else if (ordinal == 2) {
                this.t = this.v;
            } else if (ordinal != 3) {
                this.t = 0.0f;
            } else {
                this.t = e(d(0.0f) + (this.h ? this.e : -this.e));
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i6 != 0 && !this.G)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int d2 = childAt == this.p ? d(this.t) : paddingTop;
                if (!this.h && childAt == this.q && !this.i) {
                    d2 = d(this.t) + this.p.getMeasuredHeight();
                }
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                childAt.layout(i7, d2, childAt.getMeasuredWidth() + i7, measuredHeight + d2);
            }
        }
        if (this.G) {
            i();
        }
        c();
        this.G = false;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
            int childCount = getChildCount();
            if (childCount == 2) {
                this.q = getChildAt(0);
                View childAt = getChildAt(1);
                this.p = childAt;
                if (this.k == null) {
                    setDragView(childAt);
                }
                if (this.p.getVisibility() != 0) {
                    this.r = PanelState.HIDDEN;
                }
                int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt2 = getChildAt(i8);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8 || i8 != 0) {
                        if (childAt2 == this.q) {
                            i5 = (this.i || this.r == PanelState.HIDDEN) ? paddingTop : paddingTop - this.e;
                            i4 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                        } else {
                            i5 = childAt2 == this.p ? paddingTop - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin : paddingTop;
                            i4 = paddingLeft;
                        }
                        int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                        if (i9 == -2) {
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                        } else if (i9 == -1) {
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                        } else {
                            i6 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
                        }
                        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        if (i10 == -2) {
                            i7 = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
                        } else {
                            float f2 = layoutParams.weight;
                            if (f2 > 0.0f && f2 < 1.0f) {
                                i5 = (int) (((float) i5) * f2);
                            } else if (i10 != -1) {
                                i5 = i10;
                            }
                            i7 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                        }
                        childAt2.measure(i6, i7);
                        View view = this.p;
                        if (childAt2 == view) {
                            this.u = view.getMeasuredHeight() - this.e;
                        }
                    }
                }
                setMeasuredDimension(size, size2);
                return;
            }
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        } else {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            PanelState panelState = (PanelState) bundle.getSerializable(SLIDING_STATE);
            this.r = panelState;
            if (panelState == null) {
                panelState = J;
            }
            this.r = panelState;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        PanelState panelState = this.r;
        if (panelState == PanelState.DRAGGING) {
            panelState = this.s;
        }
        bundle.putSerializable(SLIDING_STATE, panelState);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i3 != i5) {
            this.G = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isTouchEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.F.processTouchEvent(motionEvent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void removePanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.D) {
            this.D.remove(panelSlideListener);
        }
    }

    public void setAnchorPoint(float f2) {
        if (f2 > 0.0f && f2 <= 1.0f) {
            this.v = f2;
            this.G = true;
            requestLayout();
        }
    }

    public void setClipPanel(boolean z2) {
        this.j = z2;
    }

    public void setCoveredFadeColor(int i2) {
        this.b = i2;
        requestLayout();
    }

    public void setDragView(View view) {
        View view2 = this.k;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        this.k = view;
        if (view != null) {
            view.setClickable(true);
            this.k.setFocusable(false);
            this.k.setFocusableInTouchMode(false);
            this.k.setOnClickListener(new a());
        }
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.E = onClickListener;
    }

    public void setGravity(int i2) {
        if (i2 == 48 || i2 == 80) {
            this.h = i2 == 80;
            if (!this.G) {
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("gravity must be set to either top or bottom");
    }

    public void setMinFlingVelocity(int i2) {
        this.a = i2;
    }

    public void setOverlayed(boolean z2) {
        this.i = z2;
    }

    public void setPanelHeight(int i2) {
        if (getPanelHeight() != i2) {
            this.e = i2;
            if (!this.G) {
                requestLayout();
            }
            if (getPanelState() == PanelState.COLLAPSED) {
                smoothToBottom();
                invalidate();
            }
        }
    }

    public void setPanelState(PanelState panelState) {
        PanelState panelState2;
        PanelState panelState3;
        if (this.F.getViewDragState() == 2) {
            this.F.abort();
        }
        if (panelState == null || panelState == (panelState2 = PanelState.DRAGGING)) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        } else if (isEnabled()) {
            boolean z2 = this.G;
            if ((z2 || this.p != null) && panelState != (panelState3 = this.r) && panelState3 != panelState2) {
                if (z2) {
                    setPanelStateInternal(panelState);
                    return;
                }
                if (panelState3 == PanelState.HIDDEN) {
                    this.p.setVisibility(0);
                    requestLayout();
                }
                int ordinal = panelState.ordinal();
                if (ordinal == 0) {
                    h(1.0f);
                } else if (ordinal == 1) {
                    h(0.0f);
                } else if (ordinal == 2) {
                    h(this.v);
                } else if (ordinal == 3) {
                    h(e(d(0.0f) + (this.h ? this.e : -this.e)));
                }
            }
        }
    }

    public void setParallaxOffset(int i2) {
        this.g = i2;
        if (!this.G) {
            requestLayout();
        }
    }

    public void setScrollableView(View view) {
        this.m = view;
    }

    public void setScrollableViewHelper(ScrollableViewHelper scrollableViewHelper) {
        this.o = scrollableViewHelper;
    }

    public void setShadowHeight(int i2) {
        this.f = i2;
        if (!this.G) {
            invalidate();
        }
    }

    public void setTouchEnabled(boolean z2) {
        this.x = z2;
    }

    public void smoothToBottom() {
        h(0.0f);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int[] a = {16843137};
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.weight = f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a);
            if (obtainStyledAttributes != null) {
                this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
                obtainStyledAttributes.recycle();
            }
        }
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SlidingUpPanelLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setDragView(int i2) {
        this.l = i2;
        setDragView(findViewById(i2));
    }
}
