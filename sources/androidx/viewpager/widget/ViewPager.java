package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class ViewPager extends ViewGroup {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final int[] g0 = {16842931};
    public static final Comparator<e> h0 = new a();
    public static final Interpolator i0 = new b();
    public static final h j0 = new h();
    public int A;
    public int B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G = -1;
    public VelocityTracker H;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public long N;
    public EdgeEffect O;
    public EdgeEffect P;
    public boolean Q = true;
    public boolean R;
    public int S;
    public List<OnPageChangeListener> T;
    public OnPageChangeListener U;
    public OnPageChangeListener V;
    public List<OnAdapterChangeListener> W;
    public int a;
    public PageTransformer a0;
    public final ArrayList<e> b = new ArrayList<>();
    public int b0;
    public final e c = new e();
    public int c0;
    public final Rect d = new Rect();
    public ArrayList<View> d0;
    public PagerAdapter e;
    public final Runnable e0 = new c();
    public int f;
    public int f0 = 0;
    public int g = -1;
    public Parcelable h = null;
    public ClassLoader i = null;
    public Scroller j;
    public boolean k;
    public g l;
    public int m;
    public Drawable n;
    public int o;
    public int p;
    public float q = -3.4028235E38f;
    public float r = Float.MAX_VALUE;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w = 1;
    public boolean x;
    public boolean y;
    public int z;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, @Px int i2);

        void onPageSelected(int i);
    }

    public interface PageTransformer {
        void transformPage(@NonNull View view, float f);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int b;
        public Parcelable c;
        public ClassLoader d;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("FragmentPager.SavedState{");
            L.append(Integer.toHexString(System.identityHashCode(this)));
            L.append(" position=");
            return a2.b.a.a.a.j(L, this.b, "}");
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.b = parcel.readInt();
            this.c = parcel.readParcelable(classLoader);
            this.d = classLoader;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    public static class a implements Comparator<e> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(e eVar, e eVar2) {
            return eVar.b - eVar2.b;
        }
    }

    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager viewPager = ViewPager.this;
            viewPager.p(viewPager.f);
        }
    }

    public class d implements OnApplyWindowInsetsListener {
        public final Rect a = new Rect();

        public d() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
            if (onApplyWindowInsets.isConsumed()) {
                return onApplyWindowInsets;
            }
            Rect rect = this.a;
            rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
            rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
            rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
            rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i), onApplyWindowInsets);
                rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
            }
            return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public static class e {
        public Object a;
        public int b;
        public boolean c;
        public float d;
        public float e;
    }

    public class f extends AccessibilityDelegateCompat {
        public f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            PagerAdapter pagerAdapter2 = ViewPager.this.e;
            boolean z = true;
            if (pagerAdapter2 == null || pagerAdapter2.getCount() <= 1) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (accessibilityEvent.getEventType() == 4096 && (pagerAdapter = ViewPager.this.e) != null) {
                accessibilityEvent.setItemCount(pagerAdapter.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.f);
                accessibilityEvent.setToIndex(ViewPager.this.f);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            PagerAdapter pagerAdapter = ViewPager.this.e;
            accessibilityNodeInfoCompat.setScrollable(pagerAdapter != null && pagerAdapter.getCount() > 1);
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.f + 1);
                return true;
            }
        }
    }

    public class g extends DataSetObserver {
        public g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.c();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.c();
        }
    }

    public static class h implements Comparator<View> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.isDecor;
            if (z != layoutParams2.isDecor) {
                return z ? 1 : -1;
            }
            return layoutParams.c - layoutParams2.c;
        }
    }

    public ViewPager(@NonNull Context context) {
        super(context);
        j();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.u != z2) {
            this.u = z2;
        }
    }

    public e a(int i2, int i3) {
        e eVar = new e();
        eVar.b = i2;
        eVar.a = this.e.instantiateItem((ViewGroup) this, i2);
        eVar.d = this.e.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.b.size()) {
            this.b.add(eVar);
        } else {
            this.b.add(i3, eVar);
        }
        return eVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        e g2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (g2 = g(childAt)) != null && g2.b == this.f) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.W == null) {
            this.W = new ArrayList();
        }
        this.W.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        if (this.T == null) {
            this.T = new ArrayList();
        }
        this.T.add(onPageChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        e g2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (g2 = g(childAt)) != null && g2.b == this.f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z2 = layoutParams2.isDecor | (view.getClass().getAnnotation(DecorView.class) != null);
        layoutParams2.isDecor = z2;
        if (!this.t) {
            super.addView(view, i2, layoutParams);
        } else if (!z2) {
            layoutParams2.b = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto L_0x000b
        L_0x0009:
            r0 = r3
            goto L_0x0052
        L_0x000b:
            if (r0 == 0) goto L_0x0052
            android.view.ViewParent r4 = r0.getParent()
        L_0x0011:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x001e
            if (r4 != r6) goto L_0x0019
            r4 = 1
            goto L_0x001f
        L_0x0019:
            android.view.ViewParent r4 = r4.getParent()
            goto L_0x0011
        L_0x001e:
            r4 = 0
        L_0x001f:
            if (r4 != 0) goto L_0x0052
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L_0x0035:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x004e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0035
        L_0x004e:
            r4.toString()
            goto L_0x0009
        L_0x0052:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto L_0x00a3
            if (r3 == r0) goto L_0x00a3
            if (r7 != r5) goto L_0x0083
            android.graphics.Rect r1 = r6.d
            android.graphics.Rect r1 = r6.f(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.d
            android.graphics.Rect r2 = r6.f(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x007d
            if (r1 < r2) goto L_0x007d
            boolean r0 = r6.l()
            goto L_0x0081
        L_0x007d:
            boolean r0 = r3.requestFocus()
        L_0x0081:
            r2 = r0
            goto L_0x00b6
        L_0x0083:
            if (r7 != r4) goto L_0x00b6
            android.graphics.Rect r1 = r6.d
            android.graphics.Rect r1 = r6.f(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.d
            android.graphics.Rect r2 = r6.f(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x009e
            if (r1 > r2) goto L_0x009e
            boolean r0 = r6.m()
            goto L_0x0081
        L_0x009e:
            boolean r0 = r3.requestFocus()
            goto L_0x0081
        L_0x00a3:
            if (r7 == r5) goto L_0x00b2
            if (r7 != r1) goto L_0x00a8
            goto L_0x00b2
        L_0x00a8:
            if (r7 == r4) goto L_0x00ad
            r0 = 2
            if (r7 != r0) goto L_0x00b6
        L_0x00ad:
            boolean r2 = r6.m()
            goto L_0x00b6
        L_0x00b2:
            boolean r2 = r6.l()
        L_0x00b6:
            if (r2 == 0) goto L_0x00bf
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        L_0x00bf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.arrowScroll(int):boolean");
    }

    public final void b(boolean z2) {
        boolean z3 = this.f0 == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.j.isFinished()) {
                this.j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.j.getCurrX();
                int currY = this.j.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        n(currX);
                    }
                }
            }
        }
        this.v = false;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            e eVar = this.b.get(i2);
            if (eVar.c) {
                eVar.c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z2) {
            ViewCompat.postOnAnimation(this, this.e0);
        } else {
            this.e0.run();
        }
    }

    public boolean beginFakeDrag() {
        if (this.x) {
            return false;
        }
        this.M = true;
        setScrollState(1);
        this.C = 0.0f;
        this.E = 0.0f;
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker == null) {
            this.H = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.H.addMovement(obtain);
        obtain.recycle();
        this.N = uptimeMillis;
        return true;
    }

    public void c() {
        int count = this.e.getCount();
        this.a = count;
        boolean z2 = this.b.size() < (this.w * 2) + 1 && this.b.size() < count;
        int i2 = this.f;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.b.size()) {
            e eVar = this.b.get(i3);
            int itemPosition = this.e.getItemPosition(eVar.a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.b.remove(i3);
                    i3--;
                    if (!z3) {
                        this.e.startUpdate((ViewGroup) this);
                        z3 = true;
                    }
                    this.e.destroyItem((ViewGroup) this, eVar.b, eVar.a);
                    int i4 = this.f;
                    if (i4 == eVar.b) {
                        i2 = Math.max(0, Math.min(i4, count - 1));
                    }
                } else {
                    int i5 = eVar.b;
                    if (i5 != itemPosition) {
                        if (i5 == this.f) {
                            i2 = itemPosition;
                        }
                        eVar.b = itemPosition;
                    }
                }
                z2 = true;
            }
            i3++;
        }
        if (z3) {
            this.e.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.b, h0);
        if (z2) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.a = 0.0f;
                }
            }
            u(i2, false, true, 0);
            requestLayout();
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
        if (!z2 || !view.canScrollHorizontally(-i2)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.q))) {
                return true;
            }
            return false;
        } else if (i2 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.r))) {
            return false;
        } else {
            return true;
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.T;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.k = true;
        if (this.j.isFinished() || !this.j.computeScrollOffset()) {
            b(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.j.getCurrX();
        int currY = this.j.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!n(currX)) {
                this.j.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public final int d(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.K || Math.abs(i3) <= this.I) {
            i2 += (int) (f2 + (i2 >= this.f ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.b.size() <= 0) {
            return i2;
        }
        ArrayList<e> arrayList = this.b;
        return Math.max(this.b.get(0).b, Math.min(i2, arrayList.get(arrayList.size() - 1).b));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        e g2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (g2 = g(childAt)) != null && g2.b == this.f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z2 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.e) != null && pagerAdapter.getCount() > 1)) {
            if (!this.O.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) (getPaddingTop() + (-height)), this.q * ((float) width));
                this.O.setSize(height, width);
                z2 = false | this.O.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.P.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.r + 1.0f)) * ((float) width2));
                this.P.setSize(height2, width2);
                z2 |= this.P.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.O.finish();
            this.P.finish();
        }
        if (z2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.n;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public final void e(int i2) {
        OnPageChangeListener onPageChangeListener = this.U;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i2);
        }
        List<OnPageChangeListener> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener2 = this.T.get(i3);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.V;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageSelected(i2);
        }
    }

    public void endFakeDrag() {
        if (this.M) {
            if (this.e != null) {
                VelocityTracker velocityTracker = this.H;
                velocityTracker.computeCurrentVelocity(1000, (float) this.J);
                int xVelocity = (int) velocityTracker.getXVelocity(this.G);
                this.v = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                e h2 = h();
                u(d(h2.b, ((((float) scrollX) / ((float) clientWidth)) - h2.e) / h2.d, xVelocity, (int) (this.C - this.E)), true, true, xVelocity);
            }
            this.x = false;
            this.y = false;
            VelocityTracker velocityTracker2 = this.H;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.H = null;
            }
            this.M = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return m();
                } else {
                    return arrowScroll(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return l();
            } else {
                return arrowScroll(17);
            }
        }
        return false;
    }

    public final Rect f(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public void fakeDragBy(float f2) {
        if (!this.M) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.e != null) {
            this.C += f2;
            float scrollX = ((float) getScrollX()) - f2;
            float clientWidth = (float) getClientWidth();
            float f3 = this.q * clientWidth;
            float f4 = this.r * clientWidth;
            e eVar = this.b.get(0);
            ArrayList<e> arrayList = this.b;
            e eVar2 = arrayList.get(arrayList.size() - 1);
            if (eVar.b != 0) {
                f3 = eVar.e * clientWidth;
            }
            if (eVar2.b != this.e.getCount() - 1) {
                f4 = eVar2.e * clientWidth;
            }
            if (scrollX < f3) {
                scrollX = f3;
            } else if (scrollX > f4) {
                scrollX = f4;
            }
            int i2 = (int) scrollX;
            this.C = (scrollX - ((float) i2)) + this.C;
            scrollTo(i2, getScrollY());
            n(i2);
            MotionEvent obtain = MotionEvent.obtain(this.N, SystemClock.uptimeMillis(), 2, this.C, 0.0f, 0);
            this.H.addMovement(obtain);
            obtain.recycle();
        }
    }

    public e g(View view) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            e eVar = this.b.get(i2);
            if (this.e.isViewFromObject(view, eVar.a)) {
                return eVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.c0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((LayoutParams) this.d0.get(i3).getLayoutParams()).d;
    }

    public int getCurrentItem() {
        return this.f;
    }

    public int getOffscreenPageLimit() {
        return this.w;
    }

    public int getPageMargin() {
        return this.m;
    }

    public final e h() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f3 = clientWidth > 0 ? ((float) this.m) / ((float) clientWidth) : 0.0f;
        e eVar = null;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z2 = true;
        while (i4 < this.b.size()) {
            e eVar2 = this.b.get(i4);
            if (!z2 && eVar2.b != (i2 = i3 + 1)) {
                eVar2 = this.c;
                eVar2.e = f2 + f4 + f3;
                eVar2.b = i2;
                eVar2.d = this.e.getPageWidth(i2);
                i4--;
            }
            f2 = eVar2.e;
            float f5 = eVar2.d + f2 + f3;
            if (!z2 && scrollX < f2) {
                return eVar;
            }
            if (scrollX < f5 || i4 == this.b.size() - 1) {
                return eVar2;
            }
            i3 = eVar2.b;
            f4 = eVar2.d;
            i4++;
            eVar = eVar2;
            z2 = false;
        }
        return eVar;
    }

    public e i(int i2) {
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            e eVar = this.b.get(i3);
            if (eVar.b == i2) {
                return eVar;
            }
        }
        return null;
    }

    public boolean isFakeDragging() {
        return this.M;
    }

    public void j() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.j = new Scroller(context, i0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.B = viewConfiguration.getScaledPagingTouchSlop();
        this.I = (int) (400.0f * f2);
        this.J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O = new EdgeEffect(context);
        this.P = new EdgeEffect(context);
        this.K = (int) (25.0f * f2);
        this.L = (int) (2.0f * f2);
        this.z = (int) (f2 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new f());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new d());
    }

    public final void k(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.G) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.C = motionEvent.getX(i2);
            this.G = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.H;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean l() {
        int i2 = this.f;
        if (i2 <= 0) {
            return false;
        }
        setCurrentItem(i2 - 1, true);
        return true;
    }

    public boolean m() {
        PagerAdapter pagerAdapter = this.e;
        if (pagerAdapter == null || this.f >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f + 1, true);
        return true;
    }

    public final boolean n(int i2) {
        if (this.b.size() != 0) {
            e h2 = h();
            int clientWidth = getClientWidth();
            int i3 = this.m;
            int i4 = clientWidth + i3;
            float f2 = (float) clientWidth;
            int i5 = h2.b;
            float f3 = ((((float) i2) / f2) - h2.e) / (h2.d + (((float) i3) / f2));
            this.R = false;
            onPageScrolled(i5, f3, (int) (((float) i4) * f3));
            if (this.R) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.Q) {
            return false;
        } else {
            this.R = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.R) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    public final boolean o(float f2) {
        boolean z2;
        boolean z3;
        float f3 = this.C - f2;
        this.C = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.q * clientWidth;
        float f5 = this.r * clientWidth;
        boolean z4 = false;
        e eVar = this.b.get(0);
        ArrayList<e> arrayList = this.b;
        e eVar2 = arrayList.get(arrayList.size() - 1);
        if (eVar.b != 0) {
            f4 = eVar.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (eVar2.b != this.e.getCount() - 1) {
            f5 = eVar2.e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f4) {
            if (z2) {
                this.O.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z3) {
                this.P.onPull(Math.abs(scrollX - f5) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.C = (scrollX - ((float) i2)) + this.C;
        scrollTo(i2, getScrollY());
        n(i2);
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.e0);
        Scroller scroller = this.j;
        if (scroller != null && !scroller.isFinished()) {
            this.j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.m > 0 && this.n != null && this.b.size() > 0 && this.e != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f4 = (float) width;
            float f5 = ((float) this.m) / f4;
            int i3 = 0;
            e eVar = this.b.get(0);
            float f6 = eVar.e;
            int size = this.b.size();
            int i4 = eVar.b;
            int i5 = this.b.get(size - 1).b;
            while (i4 < i5) {
                while (true) {
                    i2 = eVar.b;
                    if (i4 <= i2 || i3 >= size) {
                        break;
                    }
                    i3++;
                    eVar = this.b.get(i3);
                }
                if (i4 == i2) {
                    float f7 = eVar.e;
                    float f8 = eVar.d;
                    f2 = (f7 + f8) * f4;
                    f6 = f7 + f8 + f5;
                } else {
                    float pageWidth = this.e.getPageWidth(i4);
                    f2 = (f6 + pageWidth) * f4;
                    f6 = pageWidth + f5 + f6;
                }
                if (((float) this.m) + f2 > ((float) scrollX)) {
                    f3 = f5;
                    this.n.setBounds(Math.round(f2), this.o, Math.round(((float) this.m) + f2), this.p);
                    this.n.draw(canvas);
                } else {
                    f3 = f5;
                }
                if (f2 <= ((float) (scrollX + width))) {
                    i4++;
                    f5 = f3;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            s();
            return false;
        }
        if (action != 0) {
            if (this.x) {
                return true;
            }
            if (this.y) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.E = x2;
            this.C = x2;
            float y2 = motionEvent.getY();
            this.F = y2;
            this.D = y2;
            this.G = motionEvent.getPointerId(0);
            this.y = false;
            this.k = true;
            this.j.computeScrollOffset();
            if (this.f0 != 2 || Math.abs(this.j.getFinalX() - this.j.getCurrX()) <= this.L) {
                b(false);
                this.x = false;
            } else {
                this.j.abortAnimation();
                this.v = false;
                p(this.f);
                this.x = true;
                r(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.G;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                float x3 = motionEvent.getX(findPointerIndex);
                float f2 = x3 - this.C;
                float abs = Math.abs(f2);
                float y3 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y3 - this.F);
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 != 0) {
                    float f3 = this.C;
                    if (!((f3 < ((float) this.A) && i3 > 0) || (f3 > ((float) (getWidth() - this.A)) && f2 < 0.0f)) && canScroll(this, false, (int) f2, (int) x3, (int) y3)) {
                        this.C = x3;
                        this.D = y3;
                        this.y = true;
                        return false;
                    }
                }
                int i4 = this.B;
                if (abs > ((float) i4) && abs * 0.5f > abs2) {
                    this.x = true;
                    r(true);
                    setScrollState(1);
                    float f4 = this.E;
                    float f5 = (float) this.B;
                    this.C = i3 > 0 ? f4 + f5 : f4 - f5;
                    this.D = y3;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) i4)) {
                    this.y = true;
                }
                if (this.x && o(x3)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (action == 6) {
            k(motionEvent);
        }
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
        return this.x;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 243
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageScrolled(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.S
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = 0
        L_0x001b:
            if (r7 >= r6) goto L_0x006b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.isDecor
            if (r10 != 0) goto L_0x002c
            goto L_0x0068
        L_0x002c:
            int r9 = r9.gravity
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004d
            r10 = 3
            if (r9 == r10) goto L_0x0047
            r10 = 5
            if (r9 == r10) goto L_0x003a
            r9 = r3
            goto L_0x005c
        L_0x003a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L_0x0059
        L_0x0047:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L_0x005c
        L_0x004d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L_0x0059:
            r11 = r9
            r9 = r3
            r3 = r11
        L_0x005c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L_0x0067
            r8.offsetLeftAndRight(r3)
        L_0x0067:
            r3 = r9
        L_0x0068:
            int r7 = r7 + 1
            goto L_0x001b
        L_0x006b:
            androidx.viewpager.widget.ViewPager$OnPageChangeListener r0 = r12.U
            if (r0 == 0) goto L_0x0072
            r0.onPageScrolled(r13, r14, r15)
        L_0x0072:
            java.util.List<androidx.viewpager.widget.ViewPager$OnPageChangeListener> r0 = r12.T
            if (r0 == 0) goto L_0x008d
            int r0 = r0.size()
            r3 = 0
        L_0x007b:
            if (r3 >= r0) goto L_0x008d
            java.util.List<androidx.viewpager.widget.ViewPager$OnPageChangeListener> r4 = r12.T
            java.lang.Object r4 = r4.get(r3)
            androidx.viewpager.widget.ViewPager$OnPageChangeListener r4 = (androidx.viewpager.widget.ViewPager.OnPageChangeListener) r4
            if (r4 == 0) goto L_0x008a
            r4.onPageScrolled(r13, r14, r15)
        L_0x008a:
            int r3 = r3 + 1
            goto L_0x007b
        L_0x008d:
            androidx.viewpager.widget.ViewPager$OnPageChangeListener r0 = r12.V
            if (r0 == 0) goto L_0x0094
            r0.onPageScrolled(r13, r14, r15)
        L_0x0094:
            androidx.viewpager.widget.ViewPager$PageTransformer r13 = r12.a0
            if (r13 == 0) goto L_0x00c5
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x00a0:
            if (r1 >= r14) goto L_0x00c5
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.isDecor
            if (r0 == 0) goto L_0x00b1
            goto L_0x00c2
        L_0x00b1:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$PageTransformer r3 = r12.a0
            r3.transformPage(r15, r0)
        L_0x00c2:
            int r1 = r1 + 1
            goto L_0x00a0
        L_0x00c5:
            r12.R = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onPageScrolled(int, float, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        e g2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (g2 = g(childAt)) != null && g2.b == this.f && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.e;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.c, savedState.d);
            u(savedState.b, false, true, 0);
            return;
        }
        this.g = savedState.b;
        this.h = savedState.c;
        this.i = savedState.d;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.b = this.f;
        PagerAdapter pagerAdapter = this.e;
        if (pagerAdapter != null) {
            savedState.c = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.m;
            q(i2, i4, i6, i6);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        if (this.M) {
            return true;
        }
        boolean z2 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.e) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.j.abortAnimation();
            this.v = false;
            p(this.f);
            float x2 = motionEvent.getX();
            this.E = x2;
            this.C = x2;
            float y2 = motionEvent.getY();
            this.F = y2;
            this.D = y2;
            this.G = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.x) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.G);
                    if (findPointerIndex == -1) {
                        z2 = s();
                    } else {
                        float x3 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x3 - this.C);
                        float y3 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y3 - this.D);
                        if (abs > ((float) this.B) && abs > abs2) {
                            this.x = true;
                            r(true);
                            float f2 = this.E;
                            this.C = x3 - f2 > 0.0f ? f2 + ((float) this.B) : f2 - ((float) this.B);
                            this.D = y3;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.x) {
                    z2 = false | o(motionEvent.getX(motionEvent.findPointerIndex(this.G)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.C = motionEvent.getX(actionIndex);
                    this.G = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    k(motionEvent);
                    this.C = motionEvent.getX(motionEvent.findPointerIndex(this.G));
                }
            } else if (this.x) {
                t(this.f, true, 0, false);
                z2 = s();
            }
        } else if (this.x) {
            VelocityTracker velocityTracker = this.H;
            velocityTracker.computeCurrentVelocity(1000, (float) this.J);
            int xVelocity = (int) velocityTracker.getXVelocity(this.G);
            this.v = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            e h2 = h();
            float f3 = (float) clientWidth;
            u(d(h2.b, ((((float) scrollX) / f3) - h2.e) / (h2.d + (((float) this.m) / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.G)) - this.E)), true, true, xVelocity);
            z2 = s();
        }
        if (z2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        if (r5 == r6) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p(int r15) {
        /*
        // Method dump skipped, instructions count: 925
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.p(int):void");
    }

    public final void q(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.b.isEmpty()) {
            e i6 = i(this.f);
            int min = (int) ((i6 != null ? Math.min(i6.e, this.r) : 0.0f) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                b(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.j.isFinished()) {
            this.j.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))), getScrollY());
        }
    }

    public final void r(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.W;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.T;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.t) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final boolean s() {
        this.G = -1;
        this.x = false;
        this.y = false;
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.H = null;
        }
        this.O.onRelease();
        this.P.onRelease();
        if (this.O.isFinished() || this.P.isFinished()) {
            return true;
        }
        return false;
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.e;
        if (pagerAdapter2 != null) {
            synchronized (pagerAdapter2) {
                pagerAdapter2.b = null;
            }
            this.e.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                e eVar = this.b.get(i2);
                this.e.destroyItem((ViewGroup) this, eVar.b, eVar.a);
            }
            this.e.finishUpdate((ViewGroup) this);
            this.b.clear();
            int i3 = 0;
            while (i3 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i3).getLayoutParams()).isDecor) {
                    removeViewAt(i3);
                    i3--;
                }
                i3++;
            }
            this.f = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.e;
        this.e = pagerAdapter;
        this.a = 0;
        if (pagerAdapter != null) {
            if (this.l == null) {
                this.l = new g();
            }
            PagerAdapter pagerAdapter4 = this.e;
            g gVar = this.l;
            synchronized (pagerAdapter4) {
                pagerAdapter4.b = gVar;
            }
            this.v = false;
            boolean z2 = this.Q;
            this.Q = true;
            this.a = this.e.getCount();
            if (this.g >= 0) {
                this.e.restoreState(this.h, this.i);
                u(this.g, false, true, 0);
                this.g = -1;
                this.h = null;
                this.i = null;
            } else if (!z2) {
                p(this.f);
            } else {
                requestLayout();
            }
        }
        List<OnAdapterChangeListener> list = this.W;
        if (!(list == null || list.isEmpty())) {
            int size = this.W.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.W.get(i4).onAdapterChanged(this, pagerAdapter3, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.v = false;
        u(i2, !this.Q, false, 0);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            i2 = 1;
        }
        if (i2 != this.w) {
            this.w = i2;
            p(this.f);
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.U = onPageChangeListener;
    }

    public void setPageMargin(int i2) {
        int i3 = this.m;
        this.m = i2;
        int width = getWidth();
        q(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z2, @Nullable PageTransformer pageTransformer) {
        setPageTransformer(z2, pageTransformer, 2);
    }

    public void setScrollState(int i2) {
        if (this.f0 != i2) {
            this.f0 = i2;
            if (this.a0 != null) {
                boolean z2 = i2 != 0;
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    getChildAt(i3).setLayerType(z2 ? this.b0 : 0, null);
                }
            }
            OnPageChangeListener onPageChangeListener = this.U;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
            List<OnPageChangeListener> list = this.T;
            if (list != null) {
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    OnPageChangeListener onPageChangeListener2 = this.T.get(i4);
                    if (onPageChangeListener2 != null) {
                        onPageChangeListener2.onPageScrollStateChanged(i2);
                    }
                }
            }
            OnPageChangeListener onPageChangeListener3 = this.V;
            if (onPageChangeListener3 != null) {
                onPageChangeListener3.onPageScrollStateChanged(i2);
            }
        }
    }

    public final void t(int i2, boolean z2, int i3, boolean z3) {
        int i4;
        int i5;
        e i6 = i(i2);
        int max = i6 != null ? (int) (Math.max(this.q, Math.min(i6.e, this.r)) * ((float) getClientWidth())) : 0;
        if (z2) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                Scroller scroller = this.j;
                if (scroller != null && !scroller.isFinished()) {
                    i4 = this.k ? this.j.getCurrX() : this.j.getStartX();
                    this.j.abortAnimation();
                    setScrollingCacheEnabled(false);
                } else {
                    i4 = getScrollX();
                }
                int scrollY = getScrollY();
                int i7 = max - i4;
                int i8 = 0 - scrollY;
                if (i7 == 0 && i8 == 0) {
                    b(false);
                    p(this.f);
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    int clientWidth = getClientWidth();
                    int i9 = clientWidth / 2;
                    float f2 = (float) clientWidth;
                    float f3 = (float) i9;
                    float sin = (((float) Math.sin((double) ((Math.min(1.0f, (((float) Math.abs(i7)) * 1.0f) / f2) - 0.5f) * 0.47123894f))) * f3) + f3;
                    int abs = Math.abs(i3);
                    if (abs > 0) {
                        i5 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
                    } else {
                        i5 = (int) (((((float) Math.abs(i7)) / ((this.e.getPageWidth(this.f) * f2) + ((float) this.m))) + 1.0f) * 100.0f);
                    }
                    int min = Math.min(i5, 600);
                    this.k = false;
                    this.j.startScroll(i4, scrollY, i7, i8, min);
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
            if (z3) {
                e(i2);
                return;
            }
            return;
        }
        if (z3) {
            e(i2);
        }
        b(false);
        scrollTo(max, 0);
        n(max);
    }

    public void u(int i2, boolean z2, boolean z3, int i3) {
        PagerAdapter pagerAdapter = this.e;
        boolean z4 = false;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.f != i2 || this.b.size() == 0) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.e.getCount()) {
                i2 = this.e.getCount() - 1;
            }
            int i4 = this.w;
            int i5 = this.f;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.b.size(); i6++) {
                    this.b.get(i6).c = true;
                }
            }
            if (this.f != i2) {
                z4 = true;
            }
            if (this.Q) {
                this.f = i2;
                if (z4) {
                    e(i2);
                }
                requestLayout();
                return;
            }
            p(i2);
            t(i2, z2, i3, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public final void v() {
        if (this.c0 != 0) {
            ArrayList<View> arrayList = this.d0;
            if (arrayList == null) {
                this.d0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.d0.add(getChildAt(i2));
            }
            Collections.sort(this.d0, j0);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public float a = 0.0f;
        public boolean b;
        public int c;
        public int d;
        public int gravity;
        public boolean isDecor;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.g0);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageTransformer(boolean z2, @Nullable PageTransformer pageTransformer, int i2) {
        int i3 = 1;
        boolean z3 = pageTransformer != null;
        boolean z4 = z3 != (this.a0 != null);
        this.a0 = pageTransformer;
        setChildrenDrawingOrderEnabled(z3);
        if (z3) {
            if (z2) {
                i3 = 2;
            }
            this.c0 = i3;
            this.b0 = i2;
        } else {
            this.c0 = 0;
        }
        if (z4) {
            p(this.f);
        }
    }

    public void setCurrentItem(int i2, boolean z2) {
        this.v = false;
        u(i2, z2, false, 0);
    }

    public void setPageMarginDrawable(@DrawableRes int i2) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i2));
    }

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }
}
