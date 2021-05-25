package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R;
import androidx.viewpager2.adapter.StatefulAdapter;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import l6.c0.b.f;
public final class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public final Rect a = new Rect();
    public final Rect b = new Rect();
    public l6.c0.b.c c = new l6.c0.b.c(3);
    public int d;
    public boolean e = false;
    public RecyclerView.AdapterDataObserver f = new a();
    public LinearLayoutManager g;
    public int h = -1;
    public Parcelable i;
    public RecyclerView j;
    public PagerSnapHelper k;
    public l6.c0.b.f l;
    public l6.c0.b.c m;
    public l6.c0.b.d n;
    public l6.c0.b.e o;
    public RecyclerView.ItemAnimator p = null;
    public boolean q = false;
    public boolean r = true;
    public int s = -1;
    public d t;

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OffscreenPageLimit {
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, @Px int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    public interface PageTransformer {
        void transformPage(@NonNull View view, float f);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollState {
    }

    public class a extends e {
        public a() {
            super(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.e = true;
            viewPager2.l.l = true;
        }
    }

    public class b extends OnPageChangeCallback {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                ViewPager2.this.e();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.d != i) {
                viewPager2.d = i;
                ((g) viewPager2.t).c();
            }
        }
    }

    public class c extends OnPageChangeCallback {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.j.requestFocus(2);
            }
        }
    }

    public abstract class d {
        public d(ViewPager2 viewPager2, a aVar) {
        }

        public abstract void a(@NonNull l6.c0.b.c cVar, @NonNull RecyclerView recyclerView);
    }

    public static abstract class e extends RecyclerView.AdapterDataObserver {
        public e(a aVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onChanged();
        }
    }

    public class f extends LinearLayoutManager {
        public f(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            Objects.requireNonNull(ViewPager2.this.t);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i, @Nullable Bundle bundle) {
            Objects.requireNonNull(ViewPager2.this.t);
            return super.performAccessibilityAction(recycler, state, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    public class g extends d {
        public final AccessibilityViewCommand a = new a();
        public final AccessibilityViewCommand b = new b();
        public RecyclerView.AdapterDataObserver c;

        public class a implements AccessibilityViewCommand {
            public a() {
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                g.this.b(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        public class b implements AccessibilityViewCommand {
            public b() {
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                g.this.b(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        public class c extends e {
            public c() {
                super(null);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                g.this.c();
            }
        }

        public g() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.d
        public void a(@NonNull l6.c0.b.c cVar, @NonNull RecyclerView recyclerView) {
            ViewCompat.setImportantForAccessibility(recyclerView, 2);
            this.c = new c();
            if (ViewCompat.getImportantForAccessibility(ViewPager2.this) == 0) {
                ViewCompat.setImportantForAccessibility(ViewPager2.this, 1);
            }
        }

        public void b(int i) {
            if (ViewPager2.this.isUserInputEnabled()) {
                ViewPager2.this.d(i, true);
            }
        }

        public void c() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = 16908360;
            ViewCompat.removeAccessibilityAction(viewPager2, 16908360);
            ViewCompat.removeAccessibilityAction(viewPager2, 16908361);
            ViewCompat.removeAccessibilityAction(viewPager2, 16908358);
            ViewCompat.removeAccessibilityAction(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.isUserInputEnabled()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean b2 = ViewPager2.this.b();
                    int i2 = b2 ? 16908360 : 16908361;
                    if (b2) {
                        i = 16908361;
                    }
                    if (ViewPager2.this.d < itemCount - 1) {
                        ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, null), null, this.a);
                    }
                    if (ViewPager2.this.d > 0) {
                        ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, null), null, this.b);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.d < itemCount - 1) {
                    ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, null), null, this.a);
                }
                if (ViewPager2.this.d > 0) {
                    ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, null), null, this.b);
                }
            }
        }
    }

    public class h extends PagerSnapHelper {
        public h() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    public class i extends RecyclerView {
        public i(@NonNull Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            Objects.requireNonNull(ViewPager2.this.t);
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.d);
            accessibilityEvent.setToIndex(ViewPager2.this.d);
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    public static class k implements Runnable {
        public final int a;
        public final RecyclerView b;

        public k(int i, RecyclerView recyclerView) {
            this.a = i;
            this.b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.smoothScrollToPosition(this.a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        a(context, null);
    }

    /* JADX INFO: finally extract failed */
    public final void a(Context context, AttributeSet attributeSet) {
        this.t = new g();
        i iVar = new i(context);
        this.j = iVar;
        iVar.setId(ViewCompat.generateViewId());
        this.j.setDescendantFocusability(131072);
        f fVar = new f(context);
        this.g = fVar;
        this.j.setLayoutManager(fVar);
        this.j.setScrollingTouchSlop(1);
        int[] iArr = R.styleable.ViewPager2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R.styleable.ViewPager2_android_orientation, 0));
            obtainStyledAttributes.recycle();
            this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.j.addOnChildAttachStateChangeListener(new l6.c0.b.g(this));
            l6.c0.b.f fVar2 = new l6.c0.b.f(this);
            this.l = fVar2;
            this.n = new l6.c0.b.d(this, fVar2, this.j);
            h hVar = new h();
            this.k = hVar;
            hVar.attachToRecyclerView(this.j);
            this.j.addOnScrollListener(this.l);
            l6.c0.b.c cVar = new l6.c0.b.c(3);
            this.m = cVar;
            this.l.a = cVar;
            b bVar = new b();
            c cVar2 = new c();
            this.m.a.add(bVar);
            this.m.a.add(cVar2);
            this.t.a(this.m, this.j);
            l6.c0.b.c cVar3 = this.m;
            cVar3.a.add(this.c);
            l6.c0.b.e eVar = new l6.c0.b.e(this.g);
            this.o = eVar;
            this.m.a.add(eVar);
            RecyclerView recyclerView = this.j;
            attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.j.addItemDecoration(itemDecoration);
    }

    public boolean b() {
        return this.g.getLayoutDirection() == 1;
    }

    public boolean beginFakeDrag() {
        l6.c0.b.d dVar = this.n;
        if (dVar.b.f == 1) {
            return false;
        }
        dVar.g = 0;
        dVar.f = (float) 0;
        dVar.h = SystemClock.uptimeMillis();
        VelocityTracker velocityTracker = dVar.d;
        if (velocityTracker == null) {
            dVar.d = VelocityTracker.obtain();
            dVar.e = ViewConfiguration.get(dVar.a.getContext()).getScaledMaximumFlingVelocity();
        } else {
            velocityTracker.clear();
        }
        l6.c0.b.f fVar = dVar.b;
        fVar.e = 4;
        fVar.e(true);
        if (!dVar.b.c()) {
            dVar.c.stopScroll();
        }
        dVar.a(dVar.h, 0, 0.0f, 0.0f);
        return true;
    }

    public final void c() {
        RecyclerView.Adapter adapter;
        if (this.h != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.i;
            if (parcelable != null) {
                if (adapter instanceof StatefulAdapter) {
                    ((StatefulAdapter) adapter).restoreState(parcelable);
                }
                this.i = null;
            }
            int max = Math.max(0, Math.min(this.h, adapter.getItemCount() - 1));
            this.d = max;
            this.h = -1;
            this.j.scrollToPosition(max);
            ((g) this.t).c();
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return this.j.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.j.canScrollVertically(i2);
    }

    public void d(int i2, boolean z) {
        OnPageChangeCallback onPageChangeCallback;
        RecyclerView.Adapter adapter = getAdapter();
        boolean z2 = false;
        if (adapter == null) {
            if (this.h != -1) {
                this.h = Math.max(i2, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
            if (min != this.d || !this.l.c()) {
                int i3 = this.d;
                if (min != i3 || !z) {
                    double d2 = (double) i3;
                    this.d = min;
                    ((g) this.t).c();
                    if (!this.l.c()) {
                        l6.c0.b.f fVar = this.l;
                        fVar.f();
                        f.a aVar = fVar.g;
                        d2 = ((double) aVar.a) + ((double) aVar.b);
                    }
                    l6.c0.b.f fVar2 = this.l;
                    fVar2.e = z ? 2 : 3;
                    fVar2.m = false;
                    if (fVar2.i != min) {
                        z2 = true;
                    }
                    fVar2.i = min;
                    fVar2.b(2);
                    if (z2 && (onPageChangeCallback = fVar2.a) != null) {
                        onPageChangeCallback.onPageSelected(min);
                    }
                    if (!z) {
                        this.j.scrollToPosition(min);
                        return;
                    }
                    double d3 = (double) min;
                    if (Math.abs(d3 - d2) > 3.0d) {
                        this.j.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
                        RecyclerView recyclerView = this.j;
                        recyclerView.post(new k(min, recyclerView));
                        return;
                    }
                    this.j.smoothScrollToPosition(min);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof j) {
            int i2 = ((j) parcelable).a;
            sparseArray.put(this.j.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        c();
    }

    public void e() {
        PagerSnapHelper pagerSnapHelper = this.k;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.g);
            if (findSnapView != null) {
                int position = this.g.getPosition(findSnapView);
                if (position != this.d && getScrollState() == 0) {
                    this.m.onPageSelected(position);
                }
                this.e = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean endFakeDrag() {
        l6.c0.b.d dVar = this.n;
        l6.c0.b.f fVar = dVar.b;
        boolean z = fVar.m;
        if (!z) {
            return false;
        }
        if (!(fVar.f == 1) || z) {
            fVar.m = false;
            fVar.f();
            f.a aVar = fVar.g;
            if (aVar.c == 0) {
                int i2 = aVar.a;
                if (i2 != fVar.h) {
                    fVar.a(i2);
                }
                fVar.b(0);
                fVar.d();
            } else {
                fVar.b(2);
            }
        }
        VelocityTracker velocityTracker = dVar.d;
        velocityTracker.computeCurrentVelocity(1000, (float) dVar.e);
        if (dVar.c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        ViewPager2 viewPager2 = dVar.a;
        View findSnapView = viewPager2.k.findSnapView(viewPager2.g);
        if (findSnapView == null) {
            return true;
        }
        int[] calculateDistanceToFinalSnap = viewPager2.k.calculateDistanceToFinalSnap(viewPager2.g, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return true;
        }
        viewPager2.j.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
        return true;
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float f2) {
        l6.c0.b.d dVar = this.n;
        int i2 = 0;
        if (!dVar.b.m) {
            return false;
        }
        float f3 = dVar.f - f2;
        dVar.f = f3;
        int round = Math.round(f3 - ((float) dVar.g));
        dVar.g += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = dVar.a.getOrientation() == 0;
        int i3 = z ? round : 0;
        if (!z) {
            i2 = round;
        }
        float f4 = 0.0f;
        float f5 = z ? dVar.f : 0.0f;
        if (!z) {
            f4 = dVar.f;
        }
        dVar.c.scrollBy(i3, i2);
        dVar.a(uptimeMillis, 2, f5, f4);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        Objects.requireNonNull(this.t);
        Objects.requireNonNull(this.t);
        return "androidx.viewpager.widget.ViewPager";
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.j.getAdapter();
    }

    public int getCurrentItem() {
        return this.d;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i2) {
        return this.j.getItemDecorationAt(i2);
    }

    public int getItemDecorationCount() {
        return this.j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.s;
    }

    public int getOrientation() {
        return this.g.getOrientation();
    }

    public int getPageSize() {
        int i2;
        int i3;
        RecyclerView recyclerView = this.j;
        if (getOrientation() == 0) {
            i2 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i3 = recyclerView.getPaddingRight();
        } else {
            i2 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i3 = recyclerView.getPaddingBottom();
        }
        return i2 - i3;
    }

    public int getScrollState() {
        return this.l.f;
    }

    public void invalidateItemDecorations() {
        this.j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.n.b.m;
    }

    public boolean isUserInputEnabled() {
        return this.r;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo r7) {
        /*
            r6 = this;
            super.onInitializeAccessibilityNodeInfo(r7)
            androidx.viewpager2.widget.ViewPager2$d r0 = r6.t
            androidx.viewpager2.widget.ViewPager2$g r0 = (androidx.viewpager2.widget.ViewPager2.g) r0
            androidx.viewpager2.widget.ViewPager2 r1 = androidx.viewpager2.widget.ViewPager2.this
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0031
            androidx.viewpager2.widget.ViewPager2 r1 = androidx.viewpager2.widget.ViewPager2.this
            int r1 = r1.getOrientation()
            if (r1 != r2) goto L_0x0024
            androidx.viewpager2.widget.ViewPager2 r1 = androidx.viewpager2.widget.ViewPager2.this
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
            int r1 = r1.getItemCount()
            goto L_0x0032
        L_0x0024:
            androidx.viewpager2.widget.ViewPager2 r1 = androidx.viewpager2.widget.ViewPager2.this
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
            int r1 = r1.getItemCount()
            r4 = r1
            r1 = 0
            goto L_0x0033
        L_0x0031:
            r1 = 0
        L_0x0032:
            r4 = 0
        L_0x0033:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r5 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(r7)
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat r1 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r1, r4, r3, r3)
            r5.setCollectionInfo(r1)
            androidx.viewpager2.widget.ViewPager2 r1 = androidx.viewpager2.widget.ViewPager2.this
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
            if (r1 != 0) goto L_0x0047
            goto L_0x0070
        L_0x0047:
            int r1 = r1.getItemCount()
            if (r1 == 0) goto L_0x0070
            androidx.viewpager2.widget.ViewPager2 r3 = androidx.viewpager2.widget.ViewPager2.this
            boolean r3 = r3.isUserInputEnabled()
            if (r3 != 0) goto L_0x0056
            goto L_0x0070
        L_0x0056:
            androidx.viewpager2.widget.ViewPager2 r3 = androidx.viewpager2.widget.ViewPager2.this
            int r3 = r3.d
            if (r3 <= 0) goto L_0x0061
            r3 = 8192(0x2000, float:1.14794E-41)
            r7.addAction(r3)
        L_0x0061:
            androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
            int r0 = r0.d
            int r1 = r1 - r2
            if (r0 >= r1) goto L_0x006d
            r0 = 4096(0x1000, float:5.74E-42)
            r7.addAction(r0)
        L_0x006d:
            r7.setScrollable(r2)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ViewPager2.onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        this.a.left = getPaddingLeft();
        this.a.right = (i4 - i2) - getPaddingRight();
        this.a.top = getPaddingTop();
        this.a.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.a, this.b);
        RecyclerView recyclerView = this.j;
        Rect rect = this.b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.e) {
            e();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        measureChild(this.j, i2, i3);
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        int measuredState = this.j.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingTop = getPaddingTop();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, measuredState), ViewGroup.resolveSizeAndState(Math.max(getPaddingBottom() + paddingTop + measuredHeight, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof j)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.getSuperState());
        this.h = jVar.b;
        this.i = jVar.c;
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        j jVar = new j(super.onSaveInstanceState());
        jVar.a = this.j.getId();
        int i2 = this.h;
        if (i2 == -1) {
            i2 = this.d;
        }
        jVar.b = i2;
        Parcelable parcelable = this.i;
        if (parcelable != null) {
            jVar.c = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.j.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                jVar.c = ((StatefulAdapter) adapter).saveState();
            }
        }
        return jVar;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(a2.b.a.a.a.E2(ViewPager2.class, new StringBuilder(), " does not support direct child views"));
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        int i3;
        Objects.requireNonNull((g) this.t);
        boolean z = false;
        if (!(i2 == 8192 || i2 == 4096)) {
            return super.performAccessibilityAction(i2, bundle);
        }
        g gVar = (g) this.t;
        Objects.requireNonNull(gVar);
        if (i2 == 8192 || i2 == 4096) {
            z = true;
        }
        if (z) {
            if (i2 == 8192) {
                i3 = ViewPager2.this.getCurrentItem() - 1;
            } else {
                i3 = ViewPager2.this.getCurrentItem() + 1;
            }
            gVar.b(i3);
            return true;
        }
        throw new IllegalStateException();
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.c.a.add(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.j.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i2) {
        this.j.removeItemDecorationAt(i2);
    }

    public void requestTransform() {
        if (this.o.b != null) {
            l6.c0.b.f fVar = this.l;
            fVar.f();
            f.a aVar = fVar.g;
            double d2 = ((double) aVar.a) + ((double) aVar.b);
            int i2 = (int) d2;
            float f2 = (float) (d2 - ((double) i2));
            this.o.onPageScrolled(i2, f2, Math.round(((float) getPageSize()) * f2));
        }
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.j.getAdapter();
        g gVar = (g) this.t;
        Objects.requireNonNull(gVar);
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(gVar.c);
        }
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f);
        }
        this.j.setAdapter(adapter);
        this.d = 0;
        c();
        g gVar2 = (g) this.t;
        gVar2.c();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(gVar2.c);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f);
        }
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        ((g) this.t).c();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 >= 1 || i2 == -1) {
            this.s = i2;
            this.j.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i2) {
        this.g.setOrientation(i2);
        ((g) this.t).c();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.q) {
                this.p = this.j.getItemAnimator();
                this.q = true;
            }
            this.j.setItemAnimator(null);
        } else if (this.q) {
            this.j.setItemAnimator(this.p);
            this.p = null;
            this.q = false;
        }
        l6.c0.b.e eVar = this.o;
        if (pageTransformer != eVar.b) {
            eVar.b = pageTransformer;
            requestTransform();
        }
    }

    public void setUserInputEnabled(boolean z) {
        this.r = z;
        ((g) this.t).c();
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.c.a.remove(onPageChangeCallback);
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i2) {
        this.j.addItemDecoration(itemDecoration, i2);
    }

    public void setCurrentItem(int i2, boolean z) {
        if (!isFakeDragging()) {
            d(i2, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public static class j extends View.BaseSavedState {
        public static final Parcelable.Creator<j> CREATOR = new a();
        public int a;
        public int b;
        public Parcelable c;

        public static class a implements Parcelable.ClassLoaderCreator<j> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return Build.VERSION.SDK_INT >= 24 ? new j(parcel, null) : new j(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new j[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public j createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new j(parcel, classLoader) : new j(parcel);
            }
        }

        @RequiresApi(24)
        public j(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, i);
        }

        public j(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readParcelable(null);
        }

        public j(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }
}
