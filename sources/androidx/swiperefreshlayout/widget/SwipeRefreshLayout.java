package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import ru.sravni.android.bankproduct.utils.components.wraprefreshlayout.WrapContentableSwipeRefreshLayout;
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int DEFAULT = 1;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    public static final String L = SwipeRefreshLayout.class.getSimpleName();
    public static final int LARGE = 0;
    public static final int[] M = {16842766};
    public Animation A;
    public Animation B;
    public Animation C;
    public Animation D;
    public boolean E;
    public int F;
    public boolean G;
    public OnChildScrollUpCallback H;
    public Animation.AnimationListener I;
    public final Animation J;
    public final Animation K;
    public View a;
    public OnRefreshListener b;
    public boolean c;
    public int d;
    public float e;
    public float f;
    public final NestedScrollingParentHelper g;
    public final NestedScrollingChildHelper h;
    public final int[] i;
    public final int[] j;
    public boolean k;
    public int l;
    public int m;
    public int mFrom;
    public int mOriginalOffsetTop;
    public float n;
    public float o;
    public boolean p;
    public int q;
    public boolean r;
    public final DecelerateInterpolator s;
    public l6.y.a.a t;
    public int u;
    public float v;
    public int w;
    public int x;
    public CircularProgressDrawable y;
    public Animation z;

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(@NonNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            OnRefreshListener onRefreshListener;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.c) {
                swipeRefreshLayout.y.setAlpha(255);
                SwipeRefreshLayout.this.y.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.E && (onRefreshListener = swipeRefreshLayout2.b) != null) {
                    onRefreshListener.onRefresh();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.m = swipeRefreshLayout3.t.getTop();
                return;
            }
            swipeRefreshLayout.g();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
        }
    }

    public class c extends Animation {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.y;
            int i = this.a;
            circularProgressDrawable.setAlpha((int) ((((float) (this.b - i)) * f) + ((float) i)));
        }
    }

    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.r) {
                swipeRefreshLayout.k(null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class e extends Animation {
        public e() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            int i;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.G) {
                i = swipeRefreshLayout.w - Math.abs(swipeRefreshLayout.mOriginalOffsetTop);
            } else {
                i = swipeRefreshLayout.w;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i2 = swipeRefreshLayout2.mFrom;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i2 + ((int) (((float) (i - i2)) * f))) - swipeRefreshLayout2.t.getTop());
            SwipeRefreshLayout.this.y.setArrowScale(1.0f - f);
        }
    }

    public class f extends Animation {
        public f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.e(f);
        }
    }

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, null);
    }

    private void setColorViewAlpha(int i2) {
        this.t.getBackground().setAlpha(i2);
        this.y.setAlpha(i2);
    }

    public final void a() {
        if (this.a == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.t)) {
                    this.a = childAt;
                    return;
                }
            }
        }
    }

    public final void b(float f2) {
        if (f2 > this.e) {
            h(true, true);
            return;
        }
        this.c = false;
        this.y.setStartEndTrim(0.0f, 0.0f);
        d dVar = null;
        boolean z2 = this.r;
        if (!z2) {
            dVar = new d();
        }
        int i2 = this.m;
        if (z2) {
            this.mFrom = i2;
            this.v = this.t.getScaleX();
            l6.y.a.e eVar = new l6.y.a.e(this);
            this.D = eVar;
            eVar.setDuration(150);
            if (dVar != null) {
                this.t.a = dVar;
            }
            this.t.clearAnimation();
            this.t.startAnimation(this.D);
        } else {
            this.mFrom = i2;
            this.K.reset();
            this.K.setDuration(200);
            this.K.setInterpolator(this.s);
            if (dVar != null) {
                this.t.a = dVar;
            }
            this.t.clearAnimation();
            this.t.startAnimation(this.K);
        }
        this.y.setArrowEnabled(false);
    }

    public final boolean c(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.H;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.canChildScrollUp(this, this.a);
        }
        View view = this.a;
        if (view instanceof ListView) {
            return ListViewCompat.canScrollList((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public final void d(float f2) {
        this.y.setArrowEnabled(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.e));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.e;
        int i2 = this.x;
        if (i2 <= 0) {
            i2 = this.G ? this.w - this.mOriginalOffsetTop : this.w;
        }
        float f3 = (float) i2;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i3 = this.mOriginalOffsetTop + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.t.getVisibility() != 0) {
            this.t.setVisibility(0);
        }
        if (!this.r) {
            this.t.setScaleX(1.0f);
            this.t.setScaleY(1.0f);
        }
        if (this.r) {
            setAnimationProgress(Math.min(1.0f, f2 / this.e));
        }
        if (f2 < this.e) {
            if (this.y.getAlpha() > 76 && !c(this.B)) {
                this.B = i(this.y.getAlpha(), 76);
            }
        } else if (this.y.getAlpha() < 255 && !c(this.C)) {
            this.C = i(this.y.getAlpha(), 255);
        }
        this.y.setStartEndTrim(0.0f, Math.min(0.8f, max * 0.8f));
        this.y.setArrowScale(Math.min(1.0f, max));
        this.y.setProgressRotation(((pow * 2.0f) + ((max * 0.4f) - 16.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.m);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.h.dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.h.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.h.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.h.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    public void e(float f2) {
        int i2 = this.mFrom;
        setTargetOffsetTopAndBottom((i2 + ((int) (((float) (this.mOriginalOffsetTop - i2)) * f2))) - this.t.getTop());
    }

    public final void f(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.q) {
            this.q = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public void g() {
        this.t.clearAnimation();
        this.y.stop();
        this.t.setVisibility(8);
        setColorViewAlpha(255);
        if (this.r) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.m);
        }
        this.m = this.t.getTop();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.u;
        if (i4 < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return i4;
        }
        return i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.g.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.F;
    }

    public int getProgressViewEndOffset() {
        return this.w;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public final void h(boolean z2, boolean z3) {
        if (this.c != z2) {
            this.E = z3;
            a();
            this.c = z2;
            if (z2) {
                int i2 = this.m;
                Animation.AnimationListener animationListener = this.I;
                this.mFrom = i2;
                this.J.reset();
                this.J.setDuration(200);
                this.J.setInterpolator(this.s);
                if (animationListener != null) {
                    this.t.a = animationListener;
                }
                this.t.clearAnimation();
                this.t.startAnimation(this.J);
                return;
            }
            k(this.I);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.h.hasNestedScrollingParent();
    }

    public final Animation i(int i2, int i3) {
        c cVar = new c(i2, i3);
        cVar.setDuration(300);
        l6.y.a.a aVar = this.t;
        aVar.a = null;
        aVar.clearAnimation();
        this.t.startAnimation(cVar);
        return cVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.h.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.c;
    }

    public final void j(float f2) {
        float f3 = this.o;
        int i2 = this.d;
        if (f2 - f3 > ((float) i2) && !this.p) {
            this.n = f3 + ((float) i2);
            this.p = true;
            this.y.setAlpha(76);
        }
    }

    public void k(Animation.AnimationListener animationListener) {
        b bVar = new b();
        this.A = bVar;
        bVar.setDuration(150);
        l6.y.a.a aVar = this.t;
        aVar.a = animationListener;
        aVar.clearAnimation();
        this.t.startAnimation(this.A);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        a();
        int actionMasked = motionEvent.getActionMasked();
        if (!isEnabled() || canChildScrollUp() || this.c || this.k) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.q;
                    if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                        return false;
                    }
                    j(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        f(motionEvent);
                    }
                }
            }
            this.p = false;
            this.q = -1;
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.t.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.q = pointerId;
            this.p = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.o = motionEvent.getY(findPointerIndex2);
        }
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.a == null) {
                a();
            }
            View view = this.a;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.t.getMeasuredWidth();
                int measuredHeight2 = this.t.getMeasuredHeight();
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.m;
                this.t.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.a == null) {
            a();
        }
        View view = this.a;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.t.measure(View.MeasureSpec.makeMeasureSpec(this.F, 1073741824), View.MeasureSpec.makeMeasureSpec(this.F, 1073741824));
            this.u = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.t) {
                    this.u = i4;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f;
            if (f2 > 0.0f) {
                float f3 = (float) i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f = 0.0f;
                } else {
                    this.f = f2 - f3;
                    iArr[1] = i3;
                }
                d(this.f);
            }
        }
        if (this.G && i3 > 0 && this.f == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.t.setVisibility(8);
        }
        int[] iArr2 = this.i;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.j);
        int i6 = i5 + this.j[1];
        if (i6 < 0 && !canChildScrollUp()) {
            float abs = this.f + ((float) Math.abs(i6));
            this.f = abs;
            d(abs);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.g.onNestedScrollAccepted(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f = 0.0f;
        this.k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && !this.c && (i2 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.g.onStopNestedScroll(view);
        this.k = false;
        float f2 = this.f;
        if (f2 > 0.0f) {
            b(f2);
            this.f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!isEnabled() || canChildScrollUp() || this.c || this.k) {
            return false;
        }
        if (actionMasked == 0) {
            this.q = motionEvent.getPointerId(0);
            this.p = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.q);
            if (findPointerIndex < 0) {
                return false;
            }
            if (this.p) {
                this.p = false;
                b((motionEvent.getY(findPointerIndex) - this.n) * 0.5f);
            }
            this.q = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.q);
            if (findPointerIndex2 < 0) {
                return false;
            }
            float y2 = motionEvent.getY(findPointerIndex2);
            j(y2);
            if (this.p) {
                float f2 = (y2 - this.n) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                d(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    return false;
                }
                this.q = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                f(motionEvent);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        View view = this.a;
        if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
            super.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public void setAnimationProgress(float f2) {
        this.t.setScaleX(f2);
        this.t.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        a();
        this.y.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = ContextCompat.getColor(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.e = (float) i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!z2) {
            g();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z2) {
        this.h.setNestedScrollingEnabled(z2);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback onChildScrollUpCallback) {
        this.H = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener) {
        this.b = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i2) {
        this.t.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i2) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setProgressViewEndTarget(boolean z2, int i2) {
        this.w = i2;
        this.r = z2;
        this.t.invalidate();
    }

    public void setProgressViewOffset(boolean z2, int i2, int i3) {
        this.r = z2;
        this.mOriginalOffsetTop = i2;
        this.w = i3;
        this.G = true;
        g();
        this.c = false;
    }

    public void setRefreshing(boolean z2) {
        int i2;
        if (!z2 || this.c == z2) {
            h(z2, false);
            return;
        }
        this.c = z2;
        if (!this.G) {
            i2 = this.w + this.mOriginalOffsetTop;
        } else {
            i2 = this.w;
        }
        setTargetOffsetTopAndBottom(i2 - this.m);
        this.E = false;
        Animation.AnimationListener animationListener = this.I;
        this.t.setVisibility(0);
        this.y.setAlpha(255);
        l6.y.a.d dVar = new l6.y.a.d(this);
        this.z = dVar;
        dVar.setDuration((long) this.l);
        if (animationListener != null) {
            this.t.a = animationListener;
        }
        this.t.clearAnimation();
        this.t.startAnimation(this.z);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.F = (int) (displayMetrics.density * 56.0f);
            } else {
                this.F = (int) (displayMetrics.density * 40.0f);
            }
            this.t.setImageDrawable(null);
            this.y.setStyle(i2);
            this.t.setImageDrawable(this.y);
        }
    }

    public void setSlingshotDistance(@Px int i2) {
        this.x = i2;
    }

    public void setTargetOffsetTopAndBottom(int i2) {
        this.t.bringToFront();
        ViewCompat.offsetTopAndBottom(this.t, i2);
        this.m = this.t.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.h.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.h.stopNestedScroll();
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.e = -1.0f;
        this.i = new int[2];
        this.j = new int[2];
        this.q = -1;
        this.u = -1;
        this.I = new a();
        this.J = new e();
        this.K = new f();
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.l = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.s = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.F = (int) (displayMetrics.density * 40.0f);
        this.t = new l6.y.a.a(getContext(), WrapContentableSwipeRefreshLayout.e0);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.y = circularProgressDrawable;
        circularProgressDrawable.setStyle(1);
        this.t.setImageDrawable(this.y);
        this.t.setVisibility(8);
        addView(this.t);
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.w = i2;
        this.e = (float) i2;
        this.g = new NestedScrollingParentHelper(this);
        this.h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.F;
        this.m = i3;
        this.mOriginalOffsetTop = i3;
        e(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, M);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
}
