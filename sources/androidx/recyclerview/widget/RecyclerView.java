package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import com.avito.android.lib.design.input.FormatterType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import l6.v.a.a;
import l6.v.a.b;
import l6.v.a.i;
import l6.v.a.q;
import l6.v.a.r;
import l6.v.a.s;
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    public static final boolean A0 = true;
    public static final boolean B0 = true;
    public static final Class<?>[] C0;
    public static final Interpolator D0 = new c();
    public static final int HORIZONTAL = 0;
    public static final int INVALID_TYPE = -1;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    public static final int[] y0 = {16843830};
    public static final boolean z0 = (Build.VERSION.SDK_INT >= 23);
    public boolean A;
    public final AccessibilityManager B;
    public List<OnChildAttachStateChangeListener> C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    @NonNull
    public EdgeEffectFactory H;
    public EdgeEffect I;
    public EdgeEffect J;
    public EdgeEffect K;
    public EdgeEffect L;
    public ItemAnimator M;
    public int N;
    public int O;
    public VelocityTracker P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public OnFlingListener V;
    public final int W;
    public final g a;
    public final int a0;
    public final Recycler b;
    public float b0;
    public SavedState c;
    public float c0;
    public l6.v.a.a d;
    public boolean d0;
    public l6.v.a.b e;
    public final h e0;
    public final s f;
    public i f0;
    public boolean g;
    public i.b g0;
    public final Runnable h;
    public final State h0;
    public final Rect i;
    public OnScrollListener i0;
    public final Rect j;
    public List<OnScrollListener> j0;
    public final RectF k;
    public boolean k0;
    public Adapter l;
    public boolean l0;
    @VisibleForTesting
    public LayoutManager m;
    public ItemAnimator.a m0;
    public RecyclerListener n;
    public boolean n0;
    public final ArrayList<ItemDecoration> o;
    public RecyclerViewAccessibilityDelegate o0;
    public final ArrayList<OnItemTouchListener> p;
    public ChildDrawingOrderCallback p0;
    public OnItemTouchListener q;
    public final int[] q0;
    public boolean r;
    public NestedScrollingChildHelper r0;
    public boolean s;
    public final int[] s0;
    public boolean t;
    public final int[] t0;
    @VisibleForTesting
    public boolean u;
    public final int[] u0;
    public int v;
    @VisibleForTesting
    public final List<ViewHolder> v0;
    public boolean w;
    public Runnable w0;
    public boolean x;
    public final s.b x0;
    public boolean y;
    public int z;

    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        @NonNull
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        public a a = null;
        public ArrayList<ItemAnimatorFinishedListener> b = new ArrayList<>();
        public long c = 120;
        public long d = 120;
        public long e = 250;
        public long f = 250;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder, int i) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        public interface a {
        }

        public static int a(ViewHolder viewHolder) {
            int i = viewHolder.i & 14;
            if (viewHolder.i()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = viewHolder.getOldPosition();
            int adapterPosition = viewHolder.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder) {
            return true;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }

        public final void dispatchAnimationFinished(@NonNull ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            a aVar = this.a;
            if (aVar != null) {
                f fVar = (f) aVar;
                Objects.requireNonNull(fVar);
                boolean z = true;
                viewHolder.setIsRecyclable(true);
                if (viewHolder.g != null && viewHolder.h == null) {
                    viewHolder.g = null;
                }
                viewHolder.h = null;
                if (!((viewHolder.i & 16) != 0)) {
                    RecyclerView recyclerView = RecyclerView.this;
                    View view = viewHolder.itemView;
                    recyclerView.Z();
                    l6.v.a.b bVar = recyclerView.e;
                    int indexOfChild = ((q) bVar.a).a.indexOfChild(view);
                    if (indexOfChild == -1) {
                        bVar.m(view);
                    } else if (bVar.b.d(indexOfChild)) {
                        bVar.b.f(indexOfChild);
                        bVar.m(view);
                        ((q) bVar.a).c(indexOfChild);
                    } else {
                        z = false;
                    }
                    if (z) {
                        ViewHolder D = RecyclerView.D(view);
                        recyclerView.b.i(D);
                        recyclerView.b.e(D);
                    }
                    recyclerView.a0(!z);
                    if (!z && viewHolder.l()) {
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                    }
                }
            }
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                this.b.get(i).onAnimationsFinished();
            }
            this.b.clear();
        }

        public abstract void endAnimation(@NonNull ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.c;
        }

        public long getChangeDuration() {
            return this.f;
        }

        public long getMoveDuration() {
            return this.e;
        }

        public long getRemoveDuration() {
            return this.d;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!isRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                } else {
                    this.b.add(itemAnimatorFinishedListener);
                }
            }
            return isRunning;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(@NonNull ViewHolder viewHolder) {
        }

        public void onAnimationStarted(@NonNull ViewHolder viewHolder) {
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j) {
            this.c = j;
        }

        public void setChangeDuration(long j) {
            this.f = j;
        }

        public void setMoveDuration(long j) {
            this.e = j;
        }

        public void setRemoveDuration(long j) {
            this.d = j;
        }
    }

    public static abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }
    }

    public static abstract class LayoutManager {
        public l6.v.a.b a;
        public RecyclerView b;
        public final ViewBoundsCheck.b c;
        public final ViewBoundsCheck.b d;
        public ViewBoundsCheck e;
        public ViewBoundsCheck f;
        @Nullable
        public SmoothScroller g;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = true;
        public boolean l = true;
        public int m;
        public boolean n;
        public int o;
        public int p;
        public int q;
        public int r;

        public interface LayoutPrefetchRegistry {
            void addPosition(int i, int i2);
        }

        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public class a implements ViewBoundsCheck.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.b
            public View a(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.b
            public int b() {
                return LayoutManager.this.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.b
            public int c() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.b
            public int d(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.b
            public int e(View view) {
                return LayoutManager.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
            }
        }

        public class b implements ViewBoundsCheck.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.b
            public View a(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.b
            public int b() {
                return LayoutManager.this.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.b
            public int c() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.b
            public int d(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.b
            public int e(View view) {
                return LayoutManager.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
            }
        }

        public LayoutManager() {
            a aVar = new a();
            this.c = aVar;
            b bVar = new b();
            this.d = bVar;
            this.e = new ViewBoundsCheck(aVar);
            this.f = new ViewBoundsCheck(bVar);
        }

        public static boolean c(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        public static int chooseSize(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i3, i4) : size;
            }
            return Math.min(size, Math.max(i3, i4));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x0011;
         */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L_0x000f
                if (r3 < 0) goto L_0x000d
                goto L_0x0011
            L_0x000d:
                r3 = 0
                goto L_0x0021
            L_0x000f:
                if (r3 < 0) goto L_0x0014
            L_0x0011:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L_0x0021
            L_0x0014:
                r4 = -1
                if (r3 != r4) goto L_0x001b
                r2 = 1073741824(0x40000000, float:2.0)
            L_0x0019:
                r3 = r1
                goto L_0x0021
            L_0x001b:
                r4 = -2
                if (r3 != r4) goto L_0x000d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0019
            L_0x0021:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        public static Properties getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i2, i3);
            properties.orientation = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        public final void a(View view, int i2, boolean z) {
            ViewHolder D = RecyclerView.D(view);
            if (z || D.j()) {
                this.b.f.a(D);
            } else {
                this.b.f.f(D);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (D.s() || D.k()) {
                if (D.k()) {
                    D.m.i(D);
                } else {
                    D.d();
                }
                this.a.b(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.b) {
                int j2 = this.a.j(view);
                if (i2 == -1) {
                    i2 = this.a.e();
                }
                if (j2 == -1) {
                    StringBuilder L = a2.b.a.a.a.L("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    L.append(this.b.indexOfChild(view));
                    throw new IllegalStateException(a2.b.a.a.a.v2(this.b, L));
                } else if (j2 != i2) {
                    this.b.m.moveView(j2, i2);
                }
            } else {
                this.a.a(view, i2, false);
                layoutParams.c = true;
                SmoothScroller smoothScroller = this.g;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.g.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.d) {
                D.itemView.invalidate();
                layoutParams.d = false;
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null && !recyclerView.isComputingLayout()) {
                if (str == null) {
                    throw new IllegalStateException(a2.b.a.a.a.v2(recyclerView, a2.b.a.a.a.L("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
                }
                throw new IllegalStateException(a2.b.a.a.a.v2(recyclerView, a2.b.a.a.a.L(str)));
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.f(str);
            }
        }

        public void attachView(@NonNull View view, int i2, LayoutParams layoutParams) {
            ViewHolder D = RecyclerView.D(view);
            if (D.j()) {
                this.b.f.a(D);
            } else {
                this.b.f.f(D);
            }
            this.a.b(view, i2, layoutParams, D.j());
        }

        public final void b(int i2) {
            this.a.c(i2);
        }

        public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.F(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i2, int i3, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void collectInitialPrefetchPositions(int i2, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State state) {
            return 0;
        }

        public void d(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder D = RecyclerView.D(view);
            if (D != null && !D.j() && !this.a.k(D.itemView)) {
                RecyclerView recyclerView = this.b;
                onInitializeAccessibilityNodeInfoForItem(recyclerView.b, recyclerView.h0, view, accessibilityNodeInfoCompat);
            }
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                f(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(@NonNull View view, @NonNull Recycler recycler) {
            f(recycler, this.a.j(view), view);
        }

        public void detachAndScrapViewAt(int i2, @NonNull Recycler recycler) {
            f(recycler, i2, getChildAt(i2));
        }

        public void detachView(@NonNull View view) {
            int j2 = this.a.j(view);
            if (j2 >= 0) {
                b(j2);
            }
        }

        public void detachViewAt(int i2) {
            getChildAt(i2);
            b(i2);
        }

        public void e(Recycler recycler) {
            int size = recycler.a.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                View view = recycler.a.get(i2).itemView;
                ViewHolder D = RecyclerView.D(view);
                if (!D.r()) {
                    D.setIsRecyclable(false);
                    if (D.l()) {
                        this.b.removeDetachedView(view, false);
                    }
                    ItemAnimator itemAnimator = this.b.M;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(D);
                    }
                    D.setIsRecyclable(true);
                    ViewHolder D2 = RecyclerView.D(view);
                    D2.m = null;
                    D2.n = false;
                    D2.d();
                    recycler.e(D2);
                }
            }
            recycler.a.clear();
            ArrayList<ViewHolder> arrayList = recycler.b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.b.invalidate();
            }
        }

        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.b.M;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.D(view));
            }
        }

        public final void f(Recycler recycler, int i2, View view) {
            ViewHolder D = RecyclerView.D(view);
            if (!D.r()) {
                if (!D.i() || D.j() || this.b.l.hasStableIds()) {
                    detachViewAt(i2);
                    recycler.f(view);
                    this.b.f.f(D);
                    return;
                }
                removeViewAt(i2);
                recycler.e(D);
            }
        }

        @Nullable
        public View findContainingItemView(@NonNull View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.a.c.contains(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        @Nullable
        public View findViewByPosition(int i2) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                ViewHolder D = RecyclerView.D(childAt);
                if (D != null && D.getLayoutPosition() == i2 && !D.r() && (this.b.h0.isPreLayout() || !D.j())) {
                    return childAt;
                }
            }
            return null;
        }

        public void g(RecyclerView recyclerView) {
            h(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).b.bottom;
        }

        @Nullable
        public View getChildAt(int i2) {
            l6.v.a.b bVar = this.a;
            if (bVar == null) {
                return null;
            }
            return ((q) bVar.a).a(bVar.f(i2));
        }

        public int getChildCount() {
            l6.v.a.b bVar = this.a;
            if (bVar != null) {
                return bVar.e();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.g;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.l == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.b.l.getItemCount();
        }

        public int getDecoratedBottom(@NonNull View view) {
            return getBottomDecorationHeight(view) + view.getBottom();
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.E(view, rect);
        }

        public int getDecoratedLeft(@NonNull View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(@NonNull View view) {
            return getRightDecorationWidth(view) + view.getRight();
        }

        public int getDecoratedTop(@NonNull View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        @Nullable
        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.a.c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        @Px
        public int getHeight() {
            return this.r;
        }

        public int getHeightMode() {
            return this.p;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(@NonNull View view) {
            return RecyclerView.D(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.b);
        }

        public int getLeftDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).b.left;
        }

        @Px
        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.b);
        }

        @Px
        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.b);
        }

        @Px
        public int getPaddingBottom() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        @Px
        public int getPaddingRight() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        @Px
        public int getPaddingStart() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingTop() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).b.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.l == null || !canScrollVertically()) {
                return 1;
            }
            return this.b.l.getItemCount();
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).b.top;
        }

        public void getTransformedBoundingBox(@NonNull View view, boolean z, @NonNull Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.b.k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        @Px
        public int getWidth() {
            return this.q;
        }

        public int getWidthMode() {
            return this.o;
        }

        public void h(int i2, int i3) {
            this.q = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.o = mode;
            if (mode == 0 && !RecyclerView.z0) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.p = mode2;
            if (mode2 == 0 && !RecyclerView.z0) {
                this.r = 0;
            }
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void i(int i2, int i3) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.b.l(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                Rect rect = this.b.i;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i9 = rect.left;
                if (i9 < i6) {
                    i6 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i7) {
                    i7 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i5) {
                    i5 = i12;
                }
            }
            this.b.i.set(i6, i7, i4, i5);
            setMeasuredDimension(this.b.i, i2, i3);
        }

        public void ignoreView(@NonNull View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.b;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException(a2.b.a.a.a.v2(this.b, a2.b.a.a.a.L("View should be fully attached to be ignored")));
            }
            ViewHolder D = RecyclerView.D(view);
            D.b(128);
            this.b.f.g(D);
        }

        public boolean isAttachedToWindow() {
            return this.i;
        }

        public boolean isAutoMeasureEnabled() {
            return this.j;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.l;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler recycler, @NonNull State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.k;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.g;
            return smoothScroller != null && smoothScroller.isRunning();
        }

        public boolean isViewPartiallyVisible(@NonNull View view, boolean z, boolean z2) {
            boolean z3 = this.e.b(view, 24579) && this.f.b(view, 24579);
            return z ? z3 : !z3;
        }

        public void j(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.b = null;
                this.a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.b = recyclerView;
                this.a = recyclerView.e;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public boolean k(View view, int i2, int i3, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.k || !c(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width) || !c(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height);
        }

        public boolean l() {
            return false;
        }

        public void layoutDecorated(@NonNull View view, int i2, int i3, int i4, int i5) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).b;
            view.layout(i2 + rect.left, i3 + rect.top, i4 - rect.right, i5 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View view, int i2, int i3, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public boolean m(View view, int i2, int i3, LayoutParams layoutParams) {
            return !this.k || !c(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width) || !c(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height);
        }

        public void measureChild(@NonNull View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect F = this.b.F(view);
            int i4 = F.left + F.right + i2;
            int i5 = F.top + F.bottom + i3;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i5, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (k(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(@NonNull View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect F = this.b.F(view);
            int i4 = F.left + F.right + i2;
            int i5 = F.top + F.bottom + i3;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (k(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i2, int i3) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                detachViewAt(i2);
                attachView(childAt, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.b.toString());
        }

        public void offsetChildrenHorizontal(@Px int i2) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i2);
            }
        }

        public void offsetChildrenVertical(@Px int i2) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i2);
            }
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @CallSuper
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View view, int i2, @NonNull Recycler recycler, @NonNull State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            onInitializeAccessibilityEvent(recyclerView.b, recyclerView.h0, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.b.canScrollVertically(-1) || this.b.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view, int i2) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i2, int i3, @Nullable Object obj) {
            onItemsUpdated(recyclerView, i2, i3);
        }

        public void onLayoutChildren(Recycler recycler, State state) {
        }

        public void onLayoutCompleted(State state) {
        }

        public void onMeasure(@NonNull Recycler recycler, @NonNull State state, int i2, int i3) {
            this.b.l(i2, i3);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i2) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Recycler r8, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State r9, int r10, @androidx.annotation.Nullable android.os.Bundle r11) {
            /*
                r7 = this;
                androidx.recyclerview.widget.RecyclerView r8 = r7.b
                r9 = 0
                if (r8 != 0) goto L_0x0006
                return r9
            L_0x0006:
                r11 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r10 == r11) goto L_0x0042
                r11 = 8192(0x2000, float:1.14794E-41)
                if (r10 == r11) goto L_0x0012
                r2 = 0
                r3 = 0
                goto L_0x0073
            L_0x0012:
                r10 = -1
                boolean r8 = r8.canScrollVertically(r10)
                if (r8 == 0) goto L_0x0029
                int r8 = r7.getHeight()
                int r11 = r7.getPaddingTop()
                int r8 = r8 - r11
                int r11 = r7.getPaddingBottom()
                int r8 = r8 - r11
                int r8 = -r8
                goto L_0x002a
            L_0x0029:
                r8 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r11 = r7.b
                boolean r10 = r11.canScrollHorizontally(r10)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.getWidth()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
                int r10 = -r10
                goto L_0x006e
            L_0x0042:
                boolean r8 = r8.canScrollVertically(r0)
                if (r8 == 0) goto L_0x0057
                int r8 = r7.getHeight()
                int r10 = r7.getPaddingTop()
                int r8 = r8 - r10
                int r10 = r7.getPaddingBottom()
                int r8 = r8 - r10
                goto L_0x0058
            L_0x0057:
                r8 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r10 = r7.b
                boolean r10 = r10.canScrollHorizontally(r0)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.getWidth()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
            L_0x006e:
                r3 = r8
                r2 = r10
                goto L_0x0073
            L_0x0071:
                r3 = r8
                r2 = 0
            L_0x0073:
                if (r3 != 0) goto L_0x0078
                if (r2 != 0) goto L_0x0078
                return r9
            L_0x0078:
                androidx.recyclerview.widget.RecyclerView r1 = r7.b
                r4 = 0
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = 1
                r1.Y(r2, r3, r4, r5, r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, int i2, @Nullable Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.a.l(childCount);
            }
        }

        public void removeAndRecycleAllViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.D(getChildAt(childCount)).r()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleView(@NonNull View view, @NonNull Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i2, @NonNull Recycler recycler) {
            View childAt = getChildAt(i2);
            removeViewAt(i2);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(@NonNull View view) {
            this.b.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            l6.v.a.b bVar = this.a;
            int indexOfChild = ((q) bVar.a).a.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (bVar.b.f(indexOfChild)) {
                    bVar.m(view);
                }
                ((q) bVar.a).c(indexOfChild);
            }
        }

        public void removeViewAt(int i2) {
            if (getChildAt(i2) != null) {
                this.a.l(i2);
            }
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0072: APUT  (r0v1 int[]), (0 ??[int, short, byte, char]), (r3v3 int) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bb, code lost:
            if (r14 == false) goto L_0x00c2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean requestChildRectangleOnScreen(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r10, @androidx.annotation.NonNull android.view.View r11, @androidx.annotation.NonNull android.graphics.Rect r12, boolean r13, boolean r14) {
            /*
                r9 = this;
                r0 = 2
                int[] r0 = new int[r0]
                int r1 = r9.getPaddingLeft()
                int r2 = r9.getPaddingTop()
                int r3 = r9.getWidth()
                int r4 = r9.getPaddingRight()
                int r3 = r3 - r4
                int r4 = r9.getHeight()
                int r5 = r9.getPaddingBottom()
                int r4 = r4 - r5
                int r5 = r11.getLeft()
                int r6 = r12.left
                int r5 = r5 + r6
                int r6 = r11.getScrollX()
                int r5 = r5 - r6
                int r6 = r11.getTop()
                int r7 = r12.top
                int r6 = r6 + r7
                int r11 = r11.getScrollY()
                int r6 = r6 - r11
                int r11 = r12.width()
                int r11 = r11 + r5
                int r12 = r12.height()
                int r12 = r12 + r6
                int r5 = r5 - r1
                r1 = 0
                int r7 = java.lang.Math.min(r1, r5)
                int r6 = r6 - r2
                int r2 = java.lang.Math.min(r1, r6)
                int r11 = r11 - r3
                int r3 = java.lang.Math.max(r1, r11)
                int r12 = r12 - r4
                int r12 = java.lang.Math.max(r1, r12)
                int r4 = r9.getLayoutDirection()
                r8 = 1
                if (r4 != r8) goto L_0x0063
                if (r3 == 0) goto L_0x005e
                goto L_0x006b
            L_0x005e:
                int r3 = java.lang.Math.max(r7, r11)
                goto L_0x006b
            L_0x0063:
                if (r7 == 0) goto L_0x0066
                goto L_0x006a
            L_0x0066:
                int r7 = java.lang.Math.min(r5, r3)
            L_0x006a:
                r3 = r7
            L_0x006b:
                if (r2 == 0) goto L_0x006e
                goto L_0x0072
            L_0x006e:
                int r2 = java.lang.Math.min(r6, r12)
            L_0x0072:
                r0[r1] = r3
                r0[r8] = r2
                r11 = r0[r1]
                r12 = r0[r8]
                if (r14 == 0) goto L_0x00bd
                android.view.View r14 = r10.getFocusedChild()
                if (r14 != 0) goto L_0x0084
            L_0x0082:
                r14 = 0
                goto L_0x00bb
            L_0x0084:
                int r0 = r9.getPaddingLeft()
                int r2 = r9.getPaddingTop()
                int r3 = r9.getWidth()
                int r4 = r9.getPaddingRight()
                int r3 = r3 - r4
                int r4 = r9.getHeight()
                int r5 = r9.getPaddingBottom()
                int r4 = r4 - r5
                androidx.recyclerview.widget.RecyclerView r5 = r9.b
                android.graphics.Rect r5 = r5.i
                r9.getDecoratedBoundsWithMargins(r14, r5)
                int r14 = r5.left
                int r14 = r14 - r11
                if (r14 >= r3) goto L_0x0082
                int r14 = r5.right
                int r14 = r14 - r11
                if (r14 <= r0) goto L_0x0082
                int r14 = r5.top
                int r14 = r14 - r12
                if (r14 >= r4) goto L_0x0082
                int r14 = r5.bottom
                int r14 = r14 - r12
                if (r14 > r2) goto L_0x00ba
                goto L_0x0082
            L_0x00ba:
                r14 = 1
            L_0x00bb:
                if (r14 == 0) goto L_0x00c2
            L_0x00bd:
                if (r11 != 0) goto L_0x00c3
                if (r12 == 0) goto L_0x00c2
                goto L_0x00c3
            L_0x00c2:
                return r1
            L_0x00c3:
                if (r13 == 0) goto L_0x00c9
                r10.scrollBy(r11, r12)
                goto L_0x00cc
            L_0x00c9:
                r10.smoothScrollBy(r11, r12)
            L_0x00cc:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.h = true;
        }

        public int scrollHorizontallyBy(int i2, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i2) {
        }

        public int scrollVerticallyBy(int i2, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.j = z;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.l) {
                this.l = z;
                this.m = 0;
                RecyclerView recyclerView = this.b;
                if (recyclerView != null) {
                    recyclerView.b.j();
                }
            }
        }

        public void setMeasuredDimension(Rect rect, int i2, int i3) {
            setMeasuredDimension(chooseSize(i2, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i3, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.k = z;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i2) {
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.g;
            if (!(smoothScroller2 == null || smoothScroller == smoothScroller2 || !smoothScroller2.isRunning())) {
                this.g.stop();
            }
            this.g = smoothScroller;
            RecyclerView recyclerView = this.b;
            Objects.requireNonNull(smoothScroller);
            recyclerView.e0.c();
            if (smoothScroller.h) {
                smoothScroller.getClass().getSimpleName();
                smoothScroller.getClass().getSimpleName();
            }
            smoothScroller.b = recyclerView;
            smoothScroller.c = this;
            int i2 = smoothScroller.a;
            if (i2 != -1) {
                recyclerView.h0.a = i2;
                smoothScroller.e = true;
                smoothScroller.d = true;
                smoothScroller.f = smoothScroller.findViewByPosition(smoothScroller.getTargetPosition());
                smoothScroller.onStart();
                smoothScroller.b.e0.a();
                smoothScroller.h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public void stopIgnoringView(@NonNull View view) {
            ViewHolder D = RecyclerView.D(view);
            D.i &= -129;
            D.p();
            D.b(4);
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addDisappearingView(View view, int i2) {
            a(view, i2, true);
        }

        public void addView(View view, int i2) {
            a(view, i2, false);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                Adapter adapter = this.b.l;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.getItemCount());
                }
            }
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view, @Nullable View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0021
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0021
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001f
            L_0x001c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L_0x0031
            L_0x001f:
                if (r7 != r1) goto L_0x0023
            L_0x0021:
                r7 = r4
                goto L_0x0031
            L_0x0023:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x002a
                goto L_0x002c
            L_0x002a:
                r5 = 0
                goto L_0x0021
            L_0x002c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0021
            L_0x002f:
                r5 = 0
                r7 = 0
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public void attachView(@NonNull View view, int i2) {
            attachView(view, i2, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i2, int i3) {
            this.b.setMeasuredDimension(i2, i3);
        }

        public void attachView(@NonNull View view) {
            attachView(view, -1);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View view);

        void onChildViewDetachedFromWindow(@NonNull View view);
    }

    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i, int i2);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
    }

    public static abstract class OnScrollListener {
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    public static class RecycledViewPool {
        public SparseArray<a> a = new SparseArray<>();
        public int b = 0;

        public static class a {
            public final ArrayList<ViewHolder> a = new ArrayList<>();
            public int b = 5;
            public long c = 0;
            public long d = 0;
        }

        public final a a(int i) {
            a aVar = this.a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.a.put(i, aVar2);
            return aVar2;
        }

        public long b(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }

        public void clear() {
            for (int i = 0; i < this.a.size(); i++) {
                this.a.valueAt(i).a.clear();
            }
        }

        @Nullable
        public ViewHolder getRecycledView(int i) {
            a aVar = this.a.get(i);
            if (aVar == null || aVar.a.isEmpty()) {
                return null;
            }
            ArrayList<ViewHolder> arrayList = aVar.a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).g()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public int getRecycledViewCount(int i) {
            return a(i).a.size();
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = a(itemViewType).a;
            if (this.a.get(itemViewType).b > arrayList.size()) {
                viewHolder.p();
                arrayList.add(viewHolder);
            }
        }

        public void setMaxRecycledViews(int i, int i2) {
            a a3 = a(i);
            a3.b = i2;
            ArrayList<ViewHolder> arrayList = a3.a;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    public final class Recycler {
        public final ArrayList<ViewHolder> a;
        public ArrayList<ViewHolder> b = null;
        public final ArrayList<ViewHolder> c = new ArrayList<>();
        public final List<ViewHolder> d;
        public int e;
        public int f;
        public RecycledViewPool g;
        public ViewCacheExtension h;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.a = arrayList;
            this.d = Collections.unmodifiableList(arrayList);
            this.e = 2;
            this.f = 2;
        }

        public void a(@NonNull ViewHolder viewHolder, boolean z) {
            RecyclerView.h(viewHolder);
            View view = viewHolder.itemView;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.o0;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                ViewCompat.setAccessibilityDelegate(view, itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).e.remove(view) : null);
            }
            if (z) {
                RecyclerListener recyclerListener = RecyclerView.this.n;
                if (recyclerListener != null) {
                    recyclerListener.onViewRecycled(viewHolder);
                }
                Adapter adapter = RecyclerView.this.l;
                if (adapter != null) {
                    adapter.onViewRecycled(viewHolder);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.h0 != null) {
                    recyclerView.f.g(viewHolder);
                }
            }
            viewHolder.q = null;
            b().putRecycledView(viewHolder);
        }

        public RecycledViewPool b() {
            if (this.g == null) {
                this.g = new RecycledViewPool();
            }
            return this.g;
        }

        public void bindViewToPosition(@NonNull View view, int i2) {
            LayoutParams layoutParams;
            ViewHolder D = RecyclerView.D(view);
            if (D != null) {
                boolean z = false;
                int f2 = RecyclerView.this.d.f(i2, 0);
                if (f2 < 0 || f2 >= RecyclerView.this.l.getItemCount()) {
                    StringBuilder N = a2.b.a.a.a.N("Inconsistency detected. Invalid item position ", i2, "(offset:", f2, ").state:");
                    N.append(RecyclerView.this.h0.getItemCount());
                    throw new IndexOutOfBoundsException(a2.b.a.a.a.v2(RecyclerView.this, N));
                }
                g(D, f2, i2, Long.MAX_VALUE);
                ViewGroup.LayoutParams layoutParams2 = D.itemView.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                    D.itemView.setLayoutParams(layoutParams);
                } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                    layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                    D.itemView.setLayoutParams(layoutParams);
                } else {
                    layoutParams = (LayoutParams) layoutParams2;
                }
                layoutParams.c = true;
                layoutParams.a = D;
                if (D.itemView.getParent() == null) {
                    z = true;
                }
                layoutParams.d = z;
                return;
            }
            throw new IllegalArgumentException(a2.b.a.a.a.v2(RecyclerView.this, a2.b.a.a.a.L("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter")));
        }

        public void c() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.c.clear();
            if (RecyclerView.B0) {
                i.b bVar = RecyclerView.this.g0;
                int[] iArr = bVar.c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                bVar.d = 0;
            }
        }

        public void clear() {
            this.a.clear();
            c();
        }

        public int convertPreLayoutPositionToPostLayout(int i2) {
            if (i2 < 0 || i2 >= RecyclerView.this.h0.getItemCount()) {
                StringBuilder M = a2.b.a.a.a.M("invalid position ", i2, ". State item count is ");
                M.append(RecyclerView.this.h0.getItemCount());
                throw new IndexOutOfBoundsException(a2.b.a.a.a.v2(RecyclerView.this, M));
            } else if (!RecyclerView.this.h0.isPreLayout()) {
                return i2;
            } else {
                return RecyclerView.this.d.f(i2, 0);
            }
        }

        public void d(int i2) {
            a(this.c.get(i2), true);
            this.c.remove(i2);
        }

        public void e(ViewHolder viewHolder) {
            boolean z = false;
            boolean z2 = true;
            if (viewHolder.k() || viewHolder.itemView.getParent() != null) {
                StringBuilder L = a2.b.a.a.a.L("Scrapped or attached views may not be recycled. isScrap:");
                L.append(viewHolder.k());
                L.append(" isAttached:");
                if (viewHolder.itemView.getParent() != null) {
                    z = true;
                }
                L.append(z);
                throw new IllegalArgumentException(a2.b.a.a.a.v2(RecyclerView.this, L));
            } else if (viewHolder.l()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(viewHolder);
                throw new IllegalArgumentException(a2.b.a.a.a.v2(RecyclerView.this, sb));
            } else if (!viewHolder.r()) {
                boolean z3 = (viewHolder.i & 16) == 0 && ViewCompat.hasTransientState(viewHolder.itemView);
                Adapter adapter = RecyclerView.this.l;
                if ((adapter != null && z3 && adapter.onFailedToRecycleView(viewHolder)) || viewHolder.isRecyclable()) {
                    if (this.f <= 0 || viewHolder.f(526)) {
                        z = false;
                    } else {
                        int size = this.c.size();
                        if (size >= this.f && size > 0) {
                            d(0);
                            size--;
                        }
                        if (RecyclerView.B0 && size > 0 && !RecyclerView.this.g0.b(viewHolder.b)) {
                            do {
                                size--;
                                if (size < 0) {
                                    break;
                                }
                            } while (RecyclerView.this.g0.b(this.c.get(size).b));
                            size++;
                        }
                        this.c.add(size, viewHolder);
                        z = true;
                    }
                    if (!z) {
                        a(viewHolder, true);
                        RecyclerView.this.f.g(viewHolder);
                        if (!z && !z2 && z3) {
                            viewHolder.q = null;
                            return;
                        }
                        return;
                    }
                }
                z2 = false;
                RecyclerView.this.f.g(viewHolder);
                if (!z) {
                }
            } else {
                throw new IllegalArgumentException(a2.b.a.a.a.v2(RecyclerView.this, a2.b.a.a.a.L("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
            }
        }

        public void f(View view) {
            ViewHolder D = RecyclerView.D(view);
            if (!D.f(12) && D.m()) {
                ItemAnimator itemAnimator = RecyclerView.this.M;
                if (!(itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(D, D.e()))) {
                    if (this.b == null) {
                        this.b = new ArrayList<>();
                    }
                    D.m = this;
                    D.n = true;
                    this.b.add(D);
                    return;
                }
            }
            if (!D.i() || D.j() || RecyclerView.this.l.hasStableIds()) {
                D.m = this;
                D.n = false;
                this.a.add(D);
                return;
            }
            throw new IllegalArgumentException(a2.b.a.a.a.v2(RecyclerView.this, a2.b.a.a.a.L("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }

        public final boolean g(@NonNull ViewHolder viewHolder, int i2, int i3, long j) {
            viewHolder.q = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            boolean z = false;
            if (j != Long.MAX_VALUE) {
                long j2 = this.g.a(itemViewType).d;
                if (!(j2 == 0 || j2 + nanoTime < j)) {
                    return false;
                }
            }
            RecyclerView.this.l.bindViewHolder(viewHolder, i2);
            long nanoTime2 = RecyclerView.this.getNanoTime();
            RecycledViewPool recycledViewPool = this.g;
            RecycledViewPool.a a3 = recycledViewPool.a(viewHolder.getItemViewType());
            a3.d = recycledViewPool.b(a3.d, nanoTime2 - nanoTime);
            AccessibilityManager accessibilityManager = RecyclerView.this.B;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                z = true;
            }
            if (z) {
                View view = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.o0;
                if (recyclerViewAccessibilityDelegate != null) {
                    AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                    if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                        RecyclerViewAccessibilityDelegate.ItemDelegate itemDelegate2 = (RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate;
                        Objects.requireNonNull(itemDelegate2);
                        AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(view);
                        if (!(accessibilityDelegate == null || accessibilityDelegate == itemDelegate2)) {
                            itemDelegate2.e.put(view, accessibilityDelegate);
                        }
                    }
                    ViewCompat.setAccessibilityDelegate(view, itemDelegate);
                }
            }
            if (RecyclerView.this.h0.isPreLayout()) {
                viewHolder.f = i3;
            }
            return true;
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.d;
        }

        @NonNull
        public View getViewForPosition(int i2) {
            return h(i2, false, Long.MAX_VALUE).itemView;
        }

        /* JADX WARNING: Removed duplicated region for block: B:123:0x0265  */
        /* JADX WARNING: Removed duplicated region for block: B:208:0x0422  */
        /* JADX WARNING: Removed duplicated region for block: B:211:0x0445  */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x047e  */
        /* JADX WARNING: Removed duplicated region for block: B:225:0x048c  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0099  */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder h(int r18, boolean r19, long r20) {
            /*
            // Method dump skipped, instructions count: 1232
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.h(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        public void i(ViewHolder viewHolder) {
            if (viewHolder.n) {
                this.b.remove(viewHolder);
            } else {
                this.a.remove(viewHolder);
            }
            viewHolder.m = null;
            viewHolder.n = false;
            viewHolder.d();
        }

        public void j() {
            LayoutManager layoutManager = RecyclerView.this.m;
            this.f = this.e + (layoutManager != null ? layoutManager.m : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f; size--) {
                d(size);
            }
        }

        public void recycleView(@NonNull View view) {
            ViewHolder D = RecyclerView.D(view);
            if (D.l()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (D.k()) {
                D.m.i(D);
            } else if (D.s()) {
                D.d();
            }
            e(D);
            if (RecyclerView.this.M != null && !D.isRecyclable()) {
                RecyclerView.this.M.endAnimation(D);
            }
        }

        public void setViewCacheSize(int i2) {
            this.e = i2;
            j();
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder viewHolder);
    }

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }

    public static abstract class SmoothScroller {
        public int a = -1;
        public RecyclerView b;
        public LayoutManager c;
        public boolean d;
        public boolean e;
        public View f;
        public final Action g = new Action(0, 0);
        public boolean h;

        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            public int a;
            public int b;
            public int c;
            public int d;
            public Interpolator e;
            public boolean f;
            public int g;

            public Action(@Px int i, @Px int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public void a(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.H(i);
                    this.f = false;
                } else if (this.f) {
                    Interpolator interpolator = this.e;
                    if (interpolator == null || this.c >= 1) {
                        int i2 = this.c;
                        if (i2 >= 1) {
                            recyclerView.e0.b(this.a, this.b, i2, interpolator);
                            this.g++;
                            this.f = false;
                            return;
                        }
                        throw new IllegalStateException("Scroll duration must be a positive number");
                    }
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else {
                    this.g = 0;
                }
            }

            public int getDuration() {
                return this.c;
            }

            @Px
            public int getDx() {
                return this.a;
            }

            @Px
            public int getDy() {
                return this.b;
            }

            @Nullable
            public Interpolator getInterpolator() {
                return this.e;
            }

            public void jumpTo(int i) {
                this.d = i;
            }

            public void setDuration(int i) {
                this.f = true;
                this.c = i;
            }

            public void setDx(@Px int i) {
                this.f = true;
                this.a = i;
            }

            public void setDy(@Px int i) {
                this.f = true;
                this.b = i;
            }

            public void setInterpolator(@Nullable Interpolator interpolator) {
                this.f = true;
                this.e = interpolator;
            }

            public void update(@Px int i, @Px int i2, int i3, @Nullable Interpolator interpolator) {
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
                this.f = true;
            }

            public Action(@Px int i, @Px int i2, int i3) {
                this(i, i2, i3, null);
            }

            public Action(@Px int i, @Px int i2, int i3, @Nullable Interpolator interpolator) {
                this.d = -1;
                this.f = false;
                this.g = 0;
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
            }
        }

        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int i);
        }

        public void a(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.b;
            if (this.a == -1 || recyclerView == null) {
                stop();
            }
            if (this.d && this.f == null && this.c != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.a)) != null) {
                float f2 = computeScrollVectorForPosition.x;
                if (!(f2 == 0.0f && computeScrollVectorForPosition.y == 0.0f)) {
                    recyclerView.V((int) Math.signum(f2), (int) Math.signum(computeScrollVectorForPosition.y), null);
                }
            }
            boolean z = false;
            this.d = false;
            View view = this.f;
            if (view != null) {
                if (getChildPosition(view) == this.a) {
                    onTargetFound(this.f, recyclerView.h0, this.g);
                    this.g.a(recyclerView);
                    stop();
                } else {
                    this.f = null;
                }
            }
            if (this.e) {
                onSeekTargetStep(i, i2, recyclerView.h0, this.g);
                Action action = this.g;
                if (action.d >= 0) {
                    z = true;
                }
                action.a(recyclerView);
                if (z && this.e) {
                    this.d = true;
                    recyclerView.e0.a();
                }
            }
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int i) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            return null;
        }

        public View findViewByPosition(int i) {
            return this.b.m.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.b.m.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.b.getChildLayoutPosition(view);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.c;
        }

        public int getTargetPosition() {
            return this.a;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.b.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.d;
        }

        public boolean isRunning() {
            return this.e;
        }

        public void normalize(@NonNull PointF pointF) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            float sqrt = (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.f = view;
            }
        }

        public abstract void onSeekTargetStep(@Px int i, @Px int i2, @NonNull State state, @NonNull Action action);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(@NonNull View view, @NonNull State state, @NonNull Action action);

        public void setTargetPosition(int i) {
            this.a = i;
        }

        public final void stop() {
            if (this.e) {
                this.e = false;
                onStop();
                this.b.h0.a = -1;
                this.f = null;
                this.a = -1;
                this.d = false;
                LayoutManager layoutManager = this.c;
                if (layoutManager.g == this) {
                    layoutManager.g = null;
                }
                this.c = null;
                this.b = null;
            }
        }
    }

    public static class State {
        public int a = -1;
        public SparseArray<Object> b;
        public int c = 0;
        public int d = 0;
        public int e = 1;
        public int f = 0;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public boolean l = false;
        public int m;
        public long n;
        public int o;
        public int p;
        public int q;

        public void a(int i2) {
            if ((this.e & i2) == 0) {
                StringBuilder L = a2.b.a.a.a.L("Layout state should be one of ");
                L.append(Integer.toBinaryString(i2));
                L.append(" but it is ");
                L.append(Integer.toBinaryString(this.e));
                throw new IllegalStateException(L.toString());
            }
        }

        public boolean didStructureChange() {
            return this.g;
        }

        public <T> T get(int i2) {
            SparseArray<Object> sparseArray = this.b;
            if (sparseArray == null) {
                return null;
            }
            return (T) sparseArray.get(i2);
        }

        public int getItemCount() {
            return this.h ? this.c - this.d : this.f;
        }

        public int getRemainingScrollHorizontal() {
            return this.p;
        }

        public int getRemainingScrollVertical() {
            return this.q;
        }

        public int getTargetScrollPosition() {
            return this.a;
        }

        public boolean hasTargetScrollPosition() {
            return this.a != -1;
        }

        public boolean isMeasuring() {
            return this.j;
        }

        public boolean isPreLayout() {
            return this.h;
        }

        public void put(int i2, Object obj) {
            if (this.b == null) {
                this.b = new SparseArray<>();
            }
            this.b.put(i2, obj);
        }

        public void remove(int i2) {
            SparseArray<Object> sparseArray = this.b;
            if (sparseArray != null) {
                sparseArray.remove(i2);
            }
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("State{mTargetPosition=");
            L.append(this.a);
            L.append(", mData=");
            L.append(this.b);
            L.append(", mItemCount=");
            L.append(this.f);
            L.append(", mIsMeasuring=");
            L.append(this.j);
            L.append(", mPreviousLayoutItemCount=");
            L.append(this.c);
            L.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            L.append(this.d);
            L.append(", mStructureChanged=");
            L.append(this.g);
            L.append(", mInPreLayout=");
            L.append(this.h);
            L.append(", mRunSimpleAnimations=");
            L.append(this.k);
            L.append(", mRunPredictiveAnimations=");
            return a2.b.a.a.a.A(L, this.l, '}');
        }

        public boolean willRunPredictiveAnimations() {
            return this.l;
        }

        public boolean willRunSimpleAnimations() {
            return this.k;
        }
    }

    public static abstract class ViewCacheExtension {
        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler recycler, int i, int i2);
    }

    public static abstract class ViewHolder {
        public static final List<Object> r = Collections.emptyList();
        public WeakReference<RecyclerView> a;
        public int b = -1;
        public int c = -1;
        public long d = -1;
        public int e = -1;
        public int f = -1;
        public ViewHolder g = null;
        public ViewHolder h = null;
        public int i;
        @NonNull
        public final View itemView;
        public List<Object> j = null;
        public List<Object> k = null;
        public int l = 0;
        public Recycler m = null;
        public boolean n = false;
        public int o = 0;
        @VisibleForTesting
        public int p = -1;
        public RecyclerView q;

        public ViewHolder(@NonNull View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.i) == 0) {
                if (this.j == null) {
                    ArrayList arrayList = new ArrayList();
                    this.j = arrayList;
                    this.k = Collections.unmodifiableList(arrayList);
                }
                this.j.add(obj);
            }
        }

        public void b(int i2) {
            this.i = i2 | this.i;
        }

        public void c() {
            this.c = -1;
            this.f = -1;
        }

        public void d() {
            this.i &= -33;
        }

        public List<Object> e() {
            if ((this.i & 1024) != 0) {
                return r;
            }
            List<Object> list = this.j;
            if (list == null || list.size() == 0) {
                return r;
            }
            return this.k;
        }

        public boolean f(int i2) {
            return (i2 & this.i) != 0;
        }

        public boolean g() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.q) ? false : true;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.q;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.B(this);
        }

        public final long getItemId() {
            return this.d;
        }

        public final int getItemViewType() {
            return this.e;
        }

        public final int getLayoutPosition() {
            int i2 = this.f;
            return i2 == -1 ? this.b : i2;
        }

        public final int getOldPosition() {
            return this.c;
        }

        @Deprecated
        public final int getPosition() {
            int i2 = this.f;
            return i2 == -1 ? this.b : i2;
        }

        public boolean h() {
            return (this.i & 1) != 0;
        }

        public boolean i() {
            return (this.i & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.i & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        public boolean j() {
            return (this.i & 8) != 0;
        }

        public boolean k() {
            return this.m != null;
        }

        public boolean l() {
            return (this.i & 256) != 0;
        }

        public boolean m() {
            return (this.i & 2) != 0;
        }

        public boolean n() {
            return (this.i & 2) != 0;
        }

        public void o(int i2, boolean z) {
            if (this.c == -1) {
                this.c = this.b;
            }
            if (this.f == -1) {
                this.f = this.b;
            }
            if (z) {
                this.f += i2;
            }
            this.b += i2;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).c = true;
            }
        }

        public void p() {
            this.i = 0;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.f = -1;
            this.l = 0;
            this.g = null;
            this.h = null;
            List<Object> list = this.j;
            if (list != null) {
                list.clear();
            }
            this.i &= -1025;
            this.o = 0;
            this.p = -1;
            RecyclerView.h(this);
        }

        public void q(int i2, int i3) {
            this.i = (i2 & i3) | (this.i & (~i3));
        }

        public boolean r() {
            return (this.i & 128) != 0;
        }

        public boolean s() {
            return (this.i & 32) != 0;
        }

        public final void setIsRecyclable(boolean z) {
            int i2 = this.l;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.l = i3;
            if (i3 < 0) {
                this.l = 0;
                String str = "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this;
            } else if (!z && i3 == 1) {
                this.i |= 16;
            } else if (z && i3 == 0) {
                this.i &= -17;
            }
        }

        public String toString() {
            StringBuilder Q = a2.b.a.a.a.Q(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            Q.append(Integer.toHexString(hashCode()));
            Q.append(" position=");
            Q.append(this.b);
            Q.append(" id=");
            Q.append(this.d);
            Q.append(", oldPos=");
            Q.append(this.c);
            Q.append(", pLpos:");
            Q.append(this.f);
            StringBuilder sb = new StringBuilder(Q.toString());
            if (k()) {
                sb.append(" scrap ");
                sb.append(this.n ? "[changeScrap]" : "[attachedScrap]");
            }
            if (i()) {
                sb.append(" invalid");
            }
            if (!h()) {
                sb.append(" unbound");
            }
            if (n()) {
                sb.append(" update");
            }
            if (j()) {
                sb.append(" removed");
            }
            if (r()) {
                sb.append(" ignored");
            }
            if (l()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder L = a2.b.a.a.a.L(" not recyclable(");
                L.append(this.l);
                L.append(")");
                sb.append(L.toString());
            }
            if ((this.i & 512) != 0 || i()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.u && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.r) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.x) {
                    recyclerView2.w = true;
                } else {
                    recyclerView2.k();
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ItemAnimator itemAnimator = RecyclerView.this.M;
            if (itemAnimator != null) {
                itemAnimator.runPendingAnimations();
            }
            RecyclerView.this.n0 = false;
        }
    }

    public static class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class d implements s.b {
        public d() {
        }

        public void a(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
            RecyclerView.this.b.i(viewHolder);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.e(viewHolder);
            viewHolder.setIsRecyclable(false);
            if (recyclerView.M.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                recyclerView.N();
            }
        }
    }

    public static class e extends Observable<AdapterDataObserver> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        public void d(int i, int i2, @Nullable Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public void e(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void f(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }
    }

    public class f implements ItemAnimator.a {
        public f() {
        }
    }

    public class g extends AdapterDataObserver {
        public g() {
        }

        public void a() {
            if (RecyclerView.A0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.s && recyclerView.r) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.A = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.this.f(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.h0.g = true;
            recyclerView.P(true);
            if (!RecyclerView.this.d.g()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.f(null);
            l6.v.a.a aVar = RecyclerView.this.d;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i2 >= 1) {
                aVar.b.add(aVar.h(4, i, i2, obj));
                aVar.f |= 4;
                if (aVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.f(null);
            l6.v.a.a aVar = RecyclerView.this.d;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i2 >= 1) {
                aVar.b.add(aVar.h(1, i, i2, null));
                aVar.f |= 1;
                if (aVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.f(null);
            l6.v.a.a aVar = RecyclerView.this.d;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i != i2) {
                if (i3 == 1) {
                    aVar.b.add(aVar.h(8, i, i2, null));
                    aVar.f |= 8;
                    if (aVar.b.size() == 1) {
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
                }
            }
            if (z) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.f(null);
            l6.v.a.a aVar = RecyclerView.this.d;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i2 >= 1) {
                aVar.b.add(aVar.h(2, i, i2, null));
                aVar.f |= 2;
                if (aVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                a();
            }
        }
    }

    public class h implements Runnable {
        public int a;
        public int b;
        public OverScroller c;
        public Interpolator d;
        public boolean e = false;
        public boolean f = false;

        public h() {
            Interpolator interpolator = RecyclerView.D0;
            this.d = interpolator;
            this.c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public void a() {
            if (this.e) {
                this.f = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void b(int i, int i2, int i3, @Nullable Interpolator interpolator) {
            int i4;
            if (i3 == Integer.MIN_VALUE) {
                int abs = Math.abs(i);
                int abs2 = Math.abs(i2);
                boolean z = abs > abs2;
                int sqrt = (int) Math.sqrt((double) 0);
                int sqrt2 = (int) Math.sqrt((double) ((i2 * i2) + (i * i)));
                RecyclerView recyclerView = RecyclerView.this;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                int i5 = width / 2;
                float f2 = (float) width;
                float f3 = (float) i5;
                float sin = (((float) Math.sin((double) ((Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2) - 0.5f) * 0.47123894f))) * f3) + f3;
                if (sqrt > 0) {
                    i4 = Math.round(Math.abs(sin / ((float) sqrt)) * 1000.0f) * 4;
                } else {
                    if (!z) {
                        abs = abs2;
                    }
                    i4 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
                }
                i3 = Math.min(i4, 2000);
            }
            if (interpolator == null) {
                interpolator = RecyclerView.D0;
            }
            if (this.d != interpolator) {
                this.d = interpolator;
                this.c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.b = 0;
            this.a = 0;
            RecyclerView.this.setScrollState(2);
            this.c.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.c.computeScrollOffset();
            }
            a();
        }

        public void c() {
            RecyclerView.this.removeCallbacks(this);
            this.c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.m == null) {
                c();
                return;
            }
            this.f = false;
            this.e = true;
            recyclerView.k();
            OverScroller overScroller = this.c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.a;
                int i4 = currY - this.b;
                this.a = currX;
                this.b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.u0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.u0;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.j(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.l != null) {
                    int[] iArr3 = recyclerView3.u0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.V(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.u0;
                    i = iArr4[0];
                    i2 = iArr4[1];
                    i3 -= i;
                    i4 -= i2;
                    SmoothScroller smoothScroller = recyclerView4.m.g;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.h0.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= itemCount) {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.a(i, i2);
                        } else {
                            smoothScroller.a(i, i2);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!RecyclerView.this.o.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.u0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i, i2, i3, i4, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.u0;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (!(i == 0 && i2 == 0)) {
                    recyclerView6.q(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                SmoothScroller smoothScroller2 = RecyclerView.this.m.g;
                if ((smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) || !z) {
                    a();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    i iVar = recyclerView7.f0;
                    if (iVar != null) {
                        iVar.a(recyclerView7, i, i2);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView recyclerView8 = RecyclerView.this;
                        Objects.requireNonNull(recyclerView8);
                        if (i7 < 0) {
                            recyclerView8.s();
                            if (recyclerView8.I.isFinished()) {
                                recyclerView8.I.onAbsorb(-i7);
                            }
                        } else if (i7 > 0) {
                            recyclerView8.t();
                            if (recyclerView8.K.isFinished()) {
                                recyclerView8.K.onAbsorb(i7);
                            }
                        }
                        if (currVelocity < 0) {
                            recyclerView8.u();
                            if (recyclerView8.J.isFinished()) {
                                recyclerView8.J.onAbsorb(-currVelocity);
                            }
                        } else if (currVelocity > 0) {
                            recyclerView8.r();
                            if (recyclerView8.L.isFinished()) {
                                recyclerView8.L.onAbsorb(currVelocity);
                            }
                        }
                        if (!(i7 == 0 && currVelocity == 0)) {
                            ViewCompat.postInvalidateOnAnimation(recyclerView8);
                        }
                    }
                    if (RecyclerView.B0) {
                        i.b bVar = RecyclerView.this.g0;
                        int[] iArr7 = bVar.c;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        bVar.d = 0;
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.m.g;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.a(0, 0);
            }
            this.e = false;
            if (this.f) {
                RecyclerView.this.removeCallbacks(this);
                ViewCompat.postOnAnimation(RecyclerView.this, this);
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        C0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public static ViewHolder D(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).a;
    }

    public static void E(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.r0 == null) {
            this.r0 = new NestedScrollingChildHelper(this);
        }
        return this.r0;
    }

    public static void h(@NonNull ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.a;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView != viewHolder.itemView) {
                    ViewParent parent = recyclerView.getParent();
                    recyclerView = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            viewHolder.a = null;
        }
    }

    @Nullable
    public static RecyclerView z(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView z2 = z(viewGroup.getChildAt(i2));
            if (z2 != null) {
                return z2;
            }
        }
        return null;
    }

    @Nullable
    public ViewHolder A(int i2, boolean z2) {
        int h2 = this.e.h();
        ViewHolder viewHolder = null;
        for (int i3 = 0; i3 < h2; i3++) {
            ViewHolder D2 = D(this.e.g(i3));
            if (D2 != null && !D2.j()) {
                if (z2) {
                    if (D2.b != i2) {
                        continue;
                    }
                } else if (D2.getLayoutPosition() != i2) {
                    continue;
                }
                if (!this.e.k(D2.itemView)) {
                    return D2;
                }
                viewHolder = D2;
            }
        }
        return viewHolder;
    }

    public int B(ViewHolder viewHolder) {
        if (!viewHolder.f(524) && viewHolder.h()) {
            l6.v.a.a aVar = this.d;
            int i2 = viewHolder.b;
            int size = aVar.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                a.b bVar = aVar.b.get(i3);
                int i4 = bVar.a;
                if (i4 != 1) {
                    if (i4 == 2) {
                        int i5 = bVar.b;
                        if (i5 <= i2) {
                            int i6 = bVar.d;
                            if (i5 + i6 <= i2) {
                                i2 -= i6;
                            }
                        } else {
                            continue;
                        }
                    } else if (i4 == 8) {
                        int i7 = bVar.b;
                        if (i7 == i2) {
                            i2 = bVar.d;
                        } else {
                            if (i7 < i2) {
                                i2--;
                            }
                            if (bVar.d <= i2) {
                                i2++;
                            }
                        }
                    }
                } else if (bVar.b <= i2) {
                    i2 += bVar.d;
                }
            }
            return i2;
        }
        return -1;
    }

    public long C(ViewHolder viewHolder) {
        return this.l.hasStableIds() ? viewHolder.getItemId() : (long) viewHolder.b;
    }

    public Rect F(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.c) {
            return layoutParams.b;
        }
        if (this.h0.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.b;
        }
        Rect rect = layoutParams.b;
        rect.set(0, 0, 0, 0);
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.i.set(0, 0, 0, 0);
            this.o.get(i2).getItemOffsets(this.i, view, this, this.h0);
            int i3 = rect.left;
            Rect rect2 = this.i;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.c = false;
        return rect;
    }

    public void G() {
        this.L = null;
        this.J = null;
        this.K = null;
        this.I = null;
    }

    public void H(int i2) {
        if (this.m != null) {
            setScrollState(2);
            this.m.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    public void I() {
        int h2 = this.e.h();
        for (int i2 = 0; i2 < h2; i2++) {
            ((LayoutParams) this.e.g(i2).getLayoutParams()).c = true;
        }
        Recycler recycler = this.b;
        int size = recycler.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            LayoutParams layoutParams = (LayoutParams) recycler.c.get(i3).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.c = true;
            }
        }
    }

    public void J(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int h2 = this.e.h();
        for (int i5 = 0; i5 < h2; i5++) {
            ViewHolder D2 = D(this.e.g(i5));
            if (D2 != null && !D2.r()) {
                int i6 = D2.b;
                if (i6 >= i4) {
                    D2.o(-i3, z2);
                    this.h0.g = true;
                } else if (i6 >= i2) {
                    D2.b(8);
                    D2.o(-i3, z2);
                    D2.b = i2 - 1;
                    this.h0.g = true;
                }
            }
        }
        Recycler recycler = this.b;
        int size = recycler.c.size();
        while (true) {
            size--;
            if (size >= 0) {
                ViewHolder viewHolder = recycler.c.get(size);
                if (viewHolder != null) {
                    int i7 = viewHolder.b;
                    if (i7 >= i4) {
                        viewHolder.o(-i3, z2);
                    } else if (i7 >= i2) {
                        viewHolder.b(8);
                        recycler.d(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    public void K() {
        this.F++;
    }

    public void L(boolean z2) {
        int i2;
        boolean z3 = true;
        int i3 = this.F - 1;
        this.F = i3;
        if (i3 < 1) {
            this.F = 0;
            if (z2) {
                int i4 = this.z;
                this.z = 0;
                if (i4 != 0) {
                    AccessibilityManager accessibilityManager = this.B;
                    if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                        z3 = false;
                    }
                    if (z3) {
                        AccessibilityEvent obtain = AccessibilityEvent.obtain();
                        obtain.setEventType(2048);
                        AccessibilityEventCompat.setContentChangeTypes(obtain, i4);
                        sendAccessibilityEventUnchecked(obtain);
                    }
                }
                for (int size = this.v0.size() - 1; size >= 0; size--) {
                    ViewHolder viewHolder = this.v0.get(size);
                    if (viewHolder.itemView.getParent() == this && !viewHolder.r() && (i2 = viewHolder.p) != -1) {
                        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i2);
                        viewHolder.p = -1;
                    }
                }
                this.v0.clear();
            }
        }
    }

    public final void M(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.O) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.O = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.S = x2;
            this.Q = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.T = y2;
            this.R = y2;
        }
    }

    public void N() {
        if (!this.n0 && this.r) {
            ViewCompat.postOnAnimation(this, this.w0);
            this.n0 = true;
        }
    }

    public final void O() {
        boolean z2;
        boolean z3 = false;
        if (this.D) {
            l6.v.a.a aVar = this.d;
            aVar.l(aVar.b);
            aVar.l(aVar.c);
            aVar.f = 0;
            if (this.E) {
                this.m.onItemsChanged(this);
            }
        }
        if (this.M != null && this.m.supportsPredictiveItemAnimations()) {
            this.d.j();
        } else {
            this.d.c();
        }
        boolean z4 = this.k0 || this.l0;
        this.h0.k = this.u && this.M != null && ((z2 = this.D) || z4 || this.m.h) && (!z2 || this.l.hasStableIds());
        State state = this.h0;
        if (state.k && z4 && !this.D) {
            if (this.M != null && this.m.supportsPredictiveItemAnimations()) {
                z3 = true;
            }
        }
        state.l = z3;
    }

    public void P(boolean z2) {
        this.E = z2 | this.E;
        this.D = true;
        int h2 = this.e.h();
        for (int i2 = 0; i2 < h2; i2++) {
            ViewHolder D2 = D(this.e.g(i2));
            if (D2 != null && !D2.r()) {
                D2.b(6);
            }
        }
        I();
        Recycler recycler = this.b;
        int size = recycler.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            ViewHolder viewHolder = recycler.c.get(i3);
            if (viewHolder != null) {
                viewHolder.b(6);
                viewHolder.a(null);
            }
        }
        Adapter adapter = RecyclerView.this.l;
        if (adapter == null || !adapter.hasStableIds()) {
            recycler.c();
        }
    }

    public void Q(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.q(0, 8192);
        if (this.h0.i && viewHolder.m() && !viewHolder.j() && !viewHolder.r()) {
            this.f.b.put(C(viewHolder), viewHolder);
        }
        this.f.c(viewHolder, itemHolderInfo);
    }

    public void R() {
        ItemAnimator itemAnimator = this.M;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.m;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.b);
            this.m.e(this.b);
        }
        this.b.clear();
    }

    public final void S(@NonNull View view, @Nullable View view2) {
        View view3 = view2 != null ? view2 : view;
        this.i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.c) {
                Rect rect = layoutParams2.b;
                Rect rect2 = this.i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.i);
            offsetRectIntoDescendantCoords(view, this.i);
        }
        this.m.requestChildRectangleOnScreen(this, view, this.i, !this.u, view2 == null);
    }

    public final void T() {
        VelocityTracker velocityTracker = this.P;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z2 = false;
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.I.isFinished();
        }
        EdgeEffect edgeEffect2 = this.J;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.L;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.L.isFinished();
        }
        if (z2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean U(int r19, int r20, android.view.MotionEvent r21) {
        /*
        // Method dump skipped, instructions count: 316
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.U(int, int, android.view.MotionEvent):boolean");
    }

    public void V(int i2, int i3, @Nullable int[] iArr) {
        ViewHolder viewHolder;
        Z();
        K();
        TraceCompat.beginSection("RV Scroll");
        w(this.h0);
        int scrollHorizontallyBy = i2 != 0 ? this.m.scrollHorizontallyBy(i2, this.b, this.h0) : 0;
        int scrollVerticallyBy = i3 != 0 ? this.m.scrollVerticallyBy(i3, this.b, this.h0) : 0;
        TraceCompat.endSection();
        int e2 = this.e.e();
        for (int i4 = 0; i4 < e2; i4++) {
            View d2 = this.e.d(i4);
            ViewHolder childViewHolder = getChildViewHolder(d2);
            if (!(childViewHolder == null || (viewHolder = childViewHolder.h) == null)) {
                View view = viewHolder.itemView;
                int left = d2.getLeft();
                int top = d2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        L(true);
        a0(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    public final void W(@Nullable Adapter adapter, boolean z2, boolean z3) {
        Adapter adapter2 = this.l;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.a);
            this.l.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            R();
        }
        l6.v.a.a aVar = this.d;
        aVar.l(aVar.b);
        aVar.l(aVar.c);
        aVar.f = 0;
        Adapter adapter3 = this.l;
        this.l = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.a);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.m;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.l);
        }
        Recycler recycler = this.b;
        Adapter adapter4 = this.l;
        recycler.clear();
        RecycledViewPool b2 = recycler.b();
        Objects.requireNonNull(b2);
        if (adapter3 != null) {
            b2.b--;
        }
        if (!z2 && b2.b == 0) {
            b2.clear();
        }
        if (adapter4 != null) {
            b2.b++;
        }
        this.h0.g = true;
    }

    @VisibleForTesting
    public boolean X(ViewHolder viewHolder, int i2) {
        if (isComputingLayout()) {
            viewHolder.p = i2;
            this.v0.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i2);
        return true;
    }

    public void Y(@Px int i2, @Px int i3, @Nullable Interpolator interpolator, int i4, boolean z2) {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null && !this.x) {
            int i5 = 0;
            if (!layoutManager.canScrollHorizontally()) {
                i2 = 0;
            }
            if (!this.m.canScrollVertically()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                if (i4 == Integer.MIN_VALUE || i4 > 0) {
                    if (z2) {
                        if (i2 != 0) {
                            i5 = 1;
                        }
                        if (i3 != 0) {
                            i5 |= 2;
                        }
                        startNestedScroll(i5, 1);
                    }
                    this.e0.b(i2, i3, i4, interpolator);
                    return;
                }
                scrollBy(i2, i3);
            }
        }
    }

    public void Z() {
        int i2 = this.v + 1;
        this.v = i2;
        if (i2 == 1 && !this.x) {
            this.w = false;
        }
    }

    public void a0(boolean z2) {
        if (this.v < 1) {
            this.v = 1;
        }
        if (!z2 && !this.x) {
            this.w = false;
        }
        if (this.v == 1) {
            if (z2 && this.w && !this.x && this.m != null && this.l != null) {
                n();
            }
            if (!this.x) {
                this.w = false;
            }
        }
        this.v--;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        LayoutManager layoutManager = this.m;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration, int i2) {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.o.add(itemDecoration);
        } else {
            this.o.add(i2, itemDecoration);
        }
        I();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.p.add(onItemTouchListener);
    }

    public void addOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        if (this.j0 == null) {
            this.j0 = new ArrayList();
        }
        this.j0.add(onScrollListener);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.m.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.C;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.j0;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.m.computeHorizontalScrollExtent(this.h0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.m.computeHorizontalScrollOffset(this.h0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.m.computeHorizontalScrollRange(this.h0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.m.computeVerticalScrollExtent(this.h0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.m.computeVerticalScrollOffset(this.h0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.m.computeVerticalScrollRange(this.h0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.o.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.o.get(i2).onDrawOver(canvas, this, this.h0);
        }
        EdgeEffect edgeEffect = this.I;
        boolean z4 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.I;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.g) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.J;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.K;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.K;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.L;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.g) {
                canvas.translate((float) (getPaddingRight() + (-getWidth())), (float) (getPaddingBottom() + (-getHeight())));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.L;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.M == null || this.o.size() <= 0 || !this.M.isRunning()) {
            z4 = z2;
        }
        if (z4) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public final void e(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z2 = view.getParent() == this;
        this.b.i(getChildViewHolder(view));
        if (viewHolder.l()) {
            this.e.b(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.e.a(view, -1, true);
        } else {
            l6.v.a.b bVar = this.e;
            int indexOfChild = ((q) bVar.a).a.indexOfChild(view);
            if (indexOfChild >= 0) {
                bVar.b.h(indexOfChild);
                bVar.i(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public void f(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(a2.b.a.a.a.v2(this, a2.b.a.a.a.L("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.G > 0) {
            new IllegalStateException(a2.b.a.a.a.v2(this, a2.b.a.a.a.L("")));
        }
    }

    @Nullable
    public View findChildViewUnder(float f2, float f3) {
        for (int e2 = this.e.e() - 1; e2 >= 0; e2--) {
            View d2 = this.e.d(e2);
            float translationX = d2.getTranslationX();
            float translationY = d2.getTranslationY();
            if (f2 >= ((float) d2.getLeft()) + translationX && f2 <= ((float) d2.getRight()) + translationX && f3 >= ((float) d2.getTop()) + translationY && f3 <= ((float) d2.getBottom()) + translationY) {
                return d2;
            }
        }
        return null;
    }

    @Nullable
    public View findContainingItemView(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int i2) {
        ViewHolder viewHolder = null;
        if (this.D) {
            return null;
        }
        int h2 = this.e.h();
        for (int i3 = 0; i3 < h2; i3++) {
            ViewHolder D2 = D(this.e.g(i3));
            if (D2 != null && !D2.j() && B(D2) == i2) {
                if (!this.e.k(D2.itemView)) {
                    return D2;
                }
                viewHolder = D2;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j2) {
        Adapter adapter = this.l;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int h2 = this.e.h();
            for (int i2 = 0; i2 < h2; i2++) {
                ViewHolder D2 = D(this.e.g(i2));
                if (D2 != null && !D2.j() && D2.getItemId() == j2) {
                    if (!this.e.k(D2.itemView)) {
                        return D2;
                    }
                    viewHolder = D2;
                }
            }
        }
        return viewHolder;
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int i2) {
        return A(i2, false);
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int i2) {
        return A(i2, false);
    }

    public boolean fling(int i2, int i3) {
        LayoutManager layoutManager = this.m;
        if (layoutManager == null || this.x) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.m.canScrollVertically();
        int i4 = (!canScrollHorizontally || Math.abs(i2) < this.W) ? 0 : i2;
        int i5 = (!canScrollVertically || Math.abs(i3) < this.W) ? 0 : i3;
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        float f2 = (float) i4;
        float f3 = (float) i5;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z2 = canScrollHorizontally || canScrollVertically;
            dispatchNestedFling(f2, f3, z2);
            OnFlingListener onFlingListener = this.V;
            if (onFlingListener != null && onFlingListener.onFling(i4, i5)) {
                return true;
            }
            if (z2) {
                int i6 = canScrollHorizontally ? 1 : 0;
                if (canScrollVertically) {
                    i6 |= 2;
                }
                startNestedScroll(i6, 1);
                int i7 = this.a0;
                int max = Math.max(-i7, Math.min(i4, i7));
                int i8 = this.a0;
                int max2 = Math.max(-i8, Math.min(i5, i8));
                h hVar = this.e0;
                RecyclerView.this.setScrollState(2);
                hVar.b = 0;
                hVar.a = 0;
                Interpolator interpolator = hVar.d;
                Interpolator interpolator2 = D0;
                if (interpolator != interpolator2) {
                    hVar.d = interpolator2;
                    hVar.c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
                }
                hVar.c.fling(0, 0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                hVar.a();
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0169, code lost:
        if (r3 > 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0183, code lost:
        if (r6 > 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0186, code lost:
        if (r3 < 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0189, code lost:
        if (r6 < 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0192, code lost:
        if ((r6 * r1) < 0) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x019b, code lost:
        if ((r6 * r1) > 0) goto L_0x019f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0075  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View focusSearch(android.view.View r14, int r15) {
        /*
        // Method dump skipped, instructions count: 424
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g() {
        T();
        setScrollState(0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(a2.b.a.a.a.v2(this, a2.b.a.a.a.L("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(a2.b.a.a.a.v2(this, a2.b.a.a.a.L("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.l;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public int getChildAdapterPosition(@NonNull View view) {
        ViewHolder D2 = D(view);
        if (D2 != null) {
            return D2.getAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.p0;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return childDrawingOrderCallback.onGetChildDrawingOrder(i2, i3);
    }

    public long getChildItemId(@NonNull View view) {
        ViewHolder D2;
        Adapter adapter = this.l;
        if (adapter == null || !adapter.hasStableIds() || (D2 = D(view)) == null) {
            return -1;
        }
        return D2.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view) {
        ViewHolder D2 = D(view);
        if (D2 != null) {
            return D2.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return D(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.g;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.o0;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        E(view, rect);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.H;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.M;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.o.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.o.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.m;
    }

    public int getMaxFlingVelocity() {
        return this.a0;
    }

    public int getMinFlingVelocity() {
        return this.W;
    }

    public long getNanoTime() {
        if (B0) {
            return System.nanoTime();
        }
        return 0;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.V;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.d0;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.b.b();
    }

    public int getScrollState() {
        return this.N;
    }

    public boolean hasFixedSize() {
        return this.s;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.u || this.D || this.d.g();
    }

    public void i() {
        int h2 = this.e.h();
        for (int i2 = 0; i2 < h2; i2++) {
            ViewHolder D2 = D(this.e.g(i2));
            if (!D2.r()) {
                D2.c();
            }
        }
        Recycler recycler = this.b;
        int size = recycler.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            recycler.c.get(i3).c();
        }
        int size2 = recycler.a.size();
        for (int i4 = 0; i4 < size2; i4++) {
            recycler.a.get(i4).c();
        }
        ArrayList<ViewHolder> arrayList = recycler.b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i5 = 0; i5 < size3; i5++) {
                recycler.b.get(i5).c();
            }
        }
    }

    public void invalidateItemDecorations() {
        if (this.o.size() != 0) {
            LayoutManager layoutManager = this.m;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            I();
            requestLayout();
        }
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.M;
        return itemAnimator != null && itemAnimator.isRunning();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.r;
    }

    public boolean isComputingLayout() {
        return this.F > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.x;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public void j(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.I.onRelease();
            z2 = this.I.isFinished();
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.K.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.J.onRelease();
            z2 |= this.J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.L;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.L.onRelease();
            z2 |= this.L.isFinished();
        }
        if (z2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void k() {
        if (!this.u || this.D) {
            TraceCompat.beginSection("RV FullInvalidate");
            n();
            TraceCompat.endSection();
        } else if (this.d.g()) {
            l6.v.a.a aVar = this.d;
            int i2 = aVar.f;
            boolean z2 = false;
            if ((i2 & 4) != 0) {
                if (!((i2 & 11) != 0)) {
                    TraceCompat.beginSection("RV PartialInvalidate");
                    Z();
                    K();
                    this.d.j();
                    if (!this.w) {
                        int e2 = this.e.e();
                        int i3 = 0;
                        while (true) {
                            if (i3 < e2) {
                                ViewHolder D2 = D(this.e.d(i3));
                                if (D2 != null && !D2.r() && D2.m()) {
                                    z2 = true;
                                    break;
                                }
                                i3++;
                            } else {
                                break;
                            }
                        }
                        if (z2) {
                            n();
                        } else {
                            this.d.b();
                        }
                    }
                    a0(true);
                    L(true);
                    TraceCompat.endSection();
                    return;
                }
            }
            if (aVar.g()) {
                TraceCompat.beginSection("RV FullInvalidate");
                n();
                TraceCompat.endSection();
            }
        }
    }

    public void l(int i2, int i3) {
        setMeasuredDimension(LayoutManager.chooseSize(i2, getPaddingRight() + getPaddingLeft(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i3, getPaddingBottom() + getPaddingTop(), ViewCompat.getMinimumHeight(this)));
    }

    public void m(View view) {
        ViewHolder D2 = D(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.l;
        if (!(adapter == null || D2 == null)) {
            adapter.onViewDetachedFromWindow(D2);
        }
        List<OnChildAttachStateChangeListener> list = this.C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.C.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x030f, code lost:
        if (r17.e.k(getFocusedChild()) == false) goto L_0x03a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x036c, code lost:
        r5 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n() {
        /*
        // Method dump skipped, instructions count: 945
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.n():void");
    }

    public final void o() {
        int i2;
        this.h0.a(1);
        w(this.h0);
        this.h0.j = false;
        Z();
        s sVar = this.f;
        sVar.a.clear();
        sVar.b.clear();
        K();
        O();
        ViewHolder viewHolder = null;
        View focusedChild = (!this.d0 || !hasFocus() || this.l == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            viewHolder = findContainingViewHolder(focusedChild);
        }
        long j2 = -1;
        if (viewHolder == null) {
            State state = this.h0;
            state.n = -1;
            state.m = -1;
            state.o = -1;
        } else {
            State state2 = this.h0;
            if (this.l.hasStableIds()) {
                j2 = viewHolder.getItemId();
            }
            state2.n = j2;
            State state3 = this.h0;
            if (this.D) {
                i2 = -1;
            } else if (viewHolder.j()) {
                i2 = viewHolder.c;
            } else {
                i2 = viewHolder.getAdapterPosition();
            }
            state3.m = i2;
            State state4 = this.h0;
            View view = viewHolder.itemView;
            int id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    id = view.getId();
                }
            }
            state4.o = id;
        }
        State state5 = this.h0;
        state5.i = state5.k && this.l0;
        this.l0 = false;
        this.k0 = false;
        state5.h = state5.l;
        state5.f = this.l.getItemCount();
        y(this.q0);
        if (this.h0.k) {
            int e2 = this.e.e();
            for (int i3 = 0; i3 < e2; i3++) {
                ViewHolder D2 = D(this.e.d(i3));
                if (!D2.r() && (!D2.i() || this.l.hasStableIds())) {
                    this.f.c(D2, this.M.recordPreLayoutInformation(this.h0, D2, ItemAnimator.a(D2), D2.e()));
                    if (this.h0.i && D2.m() && !D2.j() && !D2.r() && !D2.i()) {
                        this.f.b.put(C(D2), D2);
                    }
                }
            }
        }
        if (this.h0.l) {
            int h2 = this.e.h();
            for (int i4 = 0; i4 < h2; i4++) {
                ViewHolder D3 = D(this.e.g(i4));
                if (!D3.r() && D3.c == -1) {
                    D3.c = D3.b;
                }
            }
            State state6 = this.h0;
            boolean z2 = state6.g;
            state6.g = false;
            this.m.onLayoutChildren(this.b, state6);
            this.h0.g = z2;
            for (int i5 = 0; i5 < this.e.e(); i5++) {
                ViewHolder D4 = D(this.e.d(i5));
                if (!D4.r()) {
                    s.a aVar = this.f.a.get(D4);
                    if (!((aVar == null || (aVar.a & 4) == 0) ? false : true)) {
                        int a3 = ItemAnimator.a(D4);
                        boolean f2 = D4.f(8192);
                        if (!f2) {
                            a3 |= 4096;
                        }
                        ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.M.recordPreLayoutInformation(this.h0, D4, a3, D4.e());
                        if (f2) {
                            Q(D4, recordPreLayoutInformation);
                        } else {
                            s sVar2 = this.f;
                            s.a aVar2 = sVar2.a.get(D4);
                            if (aVar2 == null) {
                                aVar2 = s.a.a();
                                sVar2.a.put(D4, aVar2);
                            }
                            aVar2.a |= 2;
                            aVar2.b = recordPreLayoutInformation;
                        }
                    }
                }
            }
            i();
        } else {
            i();
        }
        L(true);
        a0(false);
        this.h0.e = 2;
    }

    public void offsetChildrenHorizontal(@Px int i2) {
        int e2 = this.e.e();
        for (int i3 = 0; i3 < e2; i3++) {
            this.e.d(i3).offsetLeftAndRight(i2);
        }
    }

    public void offsetChildrenVertical(@Px int i2) {
        int e2 = this.e.e();
        for (int i3 = 0; i3 < e2; i3++) {
            this.e.d(i3).offsetTopAndBottom(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.F = 0;
        this.r = true;
        this.u = this.u && !isLayoutRequested();
        LayoutManager layoutManager = this.m;
        if (layoutManager != null) {
            layoutManager.i = true;
            layoutManager.onAttachedToWindow(this);
        }
        this.n0 = false;
        if (B0) {
            ThreadLocal<i> threadLocal = i.e;
            i iVar = threadLocal.get();
            this.f0 = iVar;
            if (iVar == null) {
                this.f0 = new i();
                Display display = ViewCompat.getDisplay(this);
                float f2 = 60.0f;
                if (!isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                i iVar2 = this.f0;
                iVar2.c = (long) (1.0E9f / f2);
                threadLocal.set(iVar2);
            }
            this.f0.a.add(this);
        }
    }

    public void onChildAttachedToWindow(@NonNull View view) {
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        i iVar;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.M;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.r = false;
        LayoutManager layoutManager = this.m;
        if (layoutManager != null) {
            Recycler recycler = this.b;
            layoutManager.i = false;
            layoutManager.onDetachedFromWindow(this, recycler);
        }
        this.v0.clear();
        removeCallbacks(this.w0);
        Objects.requireNonNull(this.f);
        do {
        } while (s.a.d.acquire() != null);
        if (B0 && (iVar = this.f0) != null) {
            iVar.a.remove(this);
            this.f0 = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.o.get(i2).onDraw(canvas, this, this.h0);
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.m != null && !this.x && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.m.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.m.canScrollHorizontally()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == 0.0f && f2 == 0.0f)) {
                        U((int) (f2 * this.b0), (int) (f3 * this.c0), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.m.canScrollVertically()) {
                        f3 = -axisValue;
                    } else if (this.m.canScrollHorizontally()) {
                        f2 = axisValue;
                        f3 = 0.0f;
                        U((int) (f2 * this.b0), (int) (f3 * this.c0), motionEvent);
                    }
                }
                f3 = 0.0f;
            }
            f2 = 0.0f;
            U((int) (f2 * this.b0), (int) (f3 * this.c0), motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.x) {
            return false;
        }
        this.q = null;
        if (x(motionEvent)) {
            g();
            return true;
        }
        LayoutManager layoutManager = this.m;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.m.canScrollVertically();
        if (this.P == null) {
            this.P = VelocityTracker.obtain();
        }
        this.P.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.y) {
                this.y = false;
            }
            this.O = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.S = x2;
            this.Q = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.T = y2;
            this.R = y2;
            if (this.N == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.t0;
            iArr[1] = 0;
            iArr[0] = 0;
            if (canScrollVertically) {
                boolean z3 = canScrollHorizontally ? 1 : 0;
                char c2 = canScrollHorizontally ? 1 : 0;
                canScrollHorizontally = z3 | true;
            }
            int i2 = canScrollHorizontally ? 1 : 0;
            int i3 = canScrollHorizontally ? 1 : 0;
            int i4 = canScrollHorizontally ? 1 : 0;
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.P.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.O);
            if (findPointerIndex < 0) {
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.N != 1) {
                int i5 = x3 - this.Q;
                int i6 = y3 - this.R;
                if (!canScrollHorizontally || Math.abs(i5) <= this.U) {
                    z2 = false;
                } else {
                    this.S = x3;
                    z2 = true;
                }
                if (canScrollVertically && Math.abs(i6) > this.U) {
                    this.T = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            g();
        } else if (actionMasked == 5) {
            this.O = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.S = x4;
            this.Q = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.T = y4;
            this.R = y4;
        } else if (actionMasked == 6) {
            M(motionEvent);
        }
        if (this.N == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        TraceCompat.beginSection("RV OnLayout");
        n();
        TraceCompat.endSection();
        this.u = true;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        LayoutManager layoutManager = this.m;
        if (layoutManager == null) {
            l(i2, i3);
            return;
        }
        boolean z2 = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.m.onMeasure(this.b, this.h0, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (!z2 && this.l != null) {
                if (this.h0.e == 1) {
                    o();
                }
                this.m.h(i2, i3);
                this.h0.j = true;
                p();
                this.m.i(i2, i3);
                if (this.m.l()) {
                    this.m.h(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.h0.j = true;
                    p();
                    this.m.i(i2, i3);
                }
            }
        } else if (this.s) {
            this.m.onMeasure(this.b, this.h0, i2, i3);
        } else {
            if (this.A) {
                Z();
                K();
                O();
                L(true);
                State state = this.h0;
                if (state.l) {
                    state.h = true;
                } else {
                    this.d.c();
                    this.h0.h = false;
                }
                this.A = false;
                a0(false);
            } else if (this.h0.l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.l;
            if (adapter != null) {
                this.h0.f = adapter.getItemCount();
            } else {
                this.h0.f = 0;
            }
            Z();
            this.m.onMeasure(this.b, this.h0, i2, i3);
            a0(false);
            this.h0.h = false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.c = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        LayoutManager layoutManager = this.m;
        if (layoutManager != null && (parcelable2 = this.c.b) != null) {
            layoutManager.onRestoreInstanceState(parcelable2);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.c;
        if (savedState2 != null) {
            savedState.b = savedState2.b;
        } else {
            LayoutManager layoutManager = this.m;
            if (layoutManager != null) {
                savedState.b = layoutManager.onSaveInstanceState();
            } else {
                savedState.b = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(@Px int i2, @Px int i3) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            G();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f7  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
        // Method dump skipped, instructions count: 479
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        Z();
        K();
        this.h0.a(6);
        this.d.c();
        this.h0.f = this.l.getItemCount();
        State state = this.h0;
        state.d = 0;
        state.h = false;
        this.m.onLayoutChildren(this.b, state);
        State state2 = this.h0;
        state2.g = false;
        this.c = null;
        state2.k = state2.k && this.M != null;
        state2.e = 4;
        L(true);
        a0(false);
    }

    public void q(int i2, int i3) {
        this.G++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        OnScrollListener onScrollListener = this.i0;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i2, i3);
        }
        List<OnScrollListener> list = this.j0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.j0.get(size).onScrolled(this, i2, i3);
            }
        }
        this.G--;
    }

    public void r() {
        if (this.L == null) {
            EdgeEffect createEdgeEffect = this.H.createEdgeEffect(this, 3);
            this.L = createEdgeEffect;
            if (this.g) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        ViewHolder D2 = D(view);
        if (D2 != null) {
            if (D2.l()) {
                D2.i &= -257;
            } else if (!D2.r()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(D2);
                throw new IllegalArgumentException(a2.b.a.a.a.v2(this, sb));
            }
        }
        view.clearAnimation();
        m(view);
        super.removeDetachedView(view, z2);
    }

    public void removeItemDecoration(@NonNull ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.o.remove(itemDecoration);
        if (this.o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        I();
        requestLayout();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i2));
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.C;
        if (list != null) {
            list.remove(onChildAttachStateChangeListener);
        }
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.p.remove(onItemTouchListener);
        if (this.q == onItemTouchListener) {
            this.q = null;
        }
    }

    public void removeOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.j0;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.m.onRequestChildFocus(this, this.h0, view, view2) && view2 != null) {
            S(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.m.requestChildRectangleOnScreen(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).onRequestDisallowInterceptTouchEvent(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.ViewParent, android.view.View
    public void requestLayout() {
        if (this.v != 0 || this.x) {
            this.w = true;
        } else {
            super.requestLayout();
        }
    }

    public void s() {
        if (this.I == null) {
            EdgeEffect createEdgeEffect = this.H.createEdgeEffect(this, 0);
            this.I = createEdgeEffect;
            if (this.g) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null && !this.x) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.m.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i2 = 0;
                }
                if (!canScrollVertically) {
                    i3 = 0;
                }
                U(i2, i3, null);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
    }

    public void scrollToPosition(int i2) {
        if (!this.x) {
            stopScroll();
            LayoutManager layoutManager = this.m;
            if (layoutManager != null) {
                layoutManager.scrollToPosition(i2);
                awakenScrollBars();
            }
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i2 = 0;
        if (isComputingLayout()) {
            int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
            if (contentChangeTypes != 0) {
                i2 = contentChangeTypes;
            }
            this.z |= i2;
            i2 = 1;
        }
        if (i2 == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.o0 = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        W(adapter, false, true);
        P(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.p0) {
            this.p0 = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.g) {
            G();
        }
        this.g = z2;
        super.setClipToPadding(z2);
        if (this.u) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        Preconditions.checkNotNull(edgeEffectFactory);
        this.H = edgeEffectFactory;
        G();
    }

    public void setHasFixedSize(boolean z2) {
        this.s = z2;
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.M;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.M.a = null;
        }
        this.M = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.a = this.m0;
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.b.setViewCacheSize(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        if (layoutManager != this.m) {
            stopScroll();
            if (this.m != null) {
                ItemAnimator itemAnimator = this.M;
                if (itemAnimator != null) {
                    itemAnimator.endAnimations();
                }
                this.m.removeAndRecycleAllViews(this.b);
                this.m.e(this.b);
                this.b.clear();
                if (this.r) {
                    LayoutManager layoutManager2 = this.m;
                    Recycler recycler = this.b;
                    layoutManager2.i = false;
                    layoutManager2.onDetachedFromWindow(this, recycler);
                }
                this.m.j(null);
                this.m = null;
            } else {
                this.b.clear();
            }
            l6.v.a.b bVar = this.e;
            b.a aVar = bVar.b;
            aVar.a = 0;
            b.a aVar2 = aVar.b;
            if (aVar2 != null) {
                aVar2.g();
            }
            int size = bVar.c.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                q qVar = (q) bVar.a;
                Objects.requireNonNull(qVar);
                ViewHolder D2 = D(bVar.c.get(size));
                if (D2 != null) {
                    qVar.a.X(D2, D2.o);
                    D2.o = 0;
                }
                bVar.c.remove(size);
            }
            q qVar2 = (q) bVar.a;
            int b2 = qVar2.b();
            for (int i2 = 0; i2 < b2; i2++) {
                View a3 = qVar2.a(i2);
                qVar2.a.m(a3);
                a3.clearAnimation();
            }
            qVar2.a.removeAllViews();
            this.m = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.b == null) {
                    layoutManager.j(this);
                    if (this.r) {
                        LayoutManager layoutManager3 = this.m;
                        layoutManager3.i = true;
                        layoutManager3.onAttachedToWindow(this);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LayoutManager ");
                    sb.append(layoutManager);
                    sb.append(" is already attached to a RecyclerView:");
                    throw new IllegalArgumentException(a2.b.a.a.a.v2(layoutManager.b, sb));
                }
            }
            this.b.j();
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().setNestedScrollingEnabled(z2);
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        this.V = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.i0 = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.d0 = z2;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        Recycler recycler = this.b;
        RecycledViewPool recycledViewPool2 = recycler.g;
        if (recycledViewPool2 != null) {
            recycledViewPool2.b--;
        }
        recycler.g = recycledViewPool;
        if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
            recycler.g.b++;
        }
    }

    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        this.n = recyclerListener;
    }

    public void setScrollState(int i2) {
        SmoothScroller smoothScroller;
        if (i2 != this.N) {
            this.N = i2;
            if (i2 != 2) {
                this.e0.c();
                LayoutManager layoutManager = this.m;
                if (!(layoutManager == null || (smoothScroller = layoutManager.g) == null)) {
                    smoothScroller.stop();
                }
            }
            LayoutManager layoutManager2 = this.m;
            if (layoutManager2 != null) {
                layoutManager2.onScrollStateChanged(i2);
            }
            onScrollStateChanged(i2);
            OnScrollListener onScrollListener = this.i0;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(this, i2);
            }
            List<OnScrollListener> list = this.j0;
            if (list != null) {
                int size = list.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        this.j0.get(size).onScrollStateChanged(this, i2);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 1) {
            this.U = viewConfiguration.getScaledTouchSlop();
        } else {
            this.U = viewConfiguration.getScaledPagingTouchSlop();
        }
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
        this.b.h = viewCacheExtension;
    }

    public void smoothScrollBy(@Px int i2, @Px int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollToPosition(int i2) {
        LayoutManager layoutManager;
        if (!this.x && (layoutManager = this.m) != null) {
            layoutManager.smoothScrollToPosition(this, this.h0, i2);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        SmoothScroller smoothScroller;
        setScrollState(0);
        this.e0.c();
        LayoutManager layoutManager = this.m;
        if (layoutManager != null && (smoothScroller = layoutManager.g) != null) {
            smoothScroller.stop();
        }
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.x) {
            f("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.x = false;
                if (!(!this.w || this.m == null || this.l == null)) {
                    requestLayout();
                }
                this.w = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.x = true;
            this.y = true;
            stopScroll();
        }
    }

    public void swapAdapter(@Nullable Adapter adapter, boolean z2) {
        setLayoutFrozen(false);
        W(adapter, true, z2);
        P(true);
        requestLayout();
    }

    public void t() {
        if (this.K == null) {
            EdgeEffect createEdgeEffect = this.H.createEdgeEffect(this, 2);
            this.K = createEdgeEffect;
            if (this.g) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void u() {
        if (this.J == null) {
            EdgeEffect createEdgeEffect = this.H.createEdgeEffect(this, 1);
            this.J = createEdgeEffect;
            if (this.g) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public String v() {
        StringBuilder L2 = a2.b.a.a.a.L(" ");
        L2.append(super.toString());
        L2.append(", adapter:");
        L2.append(this.l);
        L2.append(", layout:");
        L2.append(this.m);
        L2.append(", context:");
        L2.append(getContext());
        return L2.toString();
    }

    public final void w(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.e0.c;
            state.p = overScroller.getFinalX() - overScroller.getCurrX();
            state.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        state.p = 0;
        state.q = 0;
    }

    public final boolean x(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            OnItemTouchListener onItemTouchListener = this.p.get(i2);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.q = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    public final void y(int[] iArr) {
        int e2 = this.e.e();
        if (e2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < e2; i4++) {
            ViewHolder D2 = D(this.e.d(i4));
            if (!D2.r()) {
                int layoutPosition = D2.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public static abstract class Adapter<VH extends ViewHolder> {
        public final e a = new e();
        public boolean b = false;

        public final void bindViewHolder(@NonNull VH vh, int i) {
            vh.b = i;
            if (hasStableIds()) {
                vh.d = getItemId(i);
            }
            vh.q(1, 519);
            TraceCompat.beginSection("RV OnBindView");
            onBindViewHolder(vh, i, vh.e());
            List<Object> list = vh.j;
            if (list != null) {
                list.clear();
            }
            vh.i &= -1025;
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).c = true;
            }
            TraceCompat.endSection();
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i) {
            try {
                TraceCompat.beginSection("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.e = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.endSection();
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.a.a();
        }

        public final boolean hasStableIds() {
            return this.b;
        }

        public final void notifyDataSetChanged() {
            this.a.b();
        }

        public final void notifyItemChanged(int i) {
            this.a.d(i, 1, null);
        }

        public final void notifyItemInserted(int i) {
            this.a.e(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.a.c(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.a.d(i, i2, null);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.a.e(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.a.f(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.a.f(i, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(@NonNull VH vh, int i);

        public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
            onBindViewHolder(vh, i);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(@NonNull VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH vh) {
        }

        public void onViewDetachedFromWindow(@NonNull VH vh) {
        }

        public void onViewRecycled(@NonNull VH vh) {
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.a.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.b = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.a.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i, @Nullable Object obj) {
            this.a.d(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
            this.a.d(i, i2, obj);
        }
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().hasNestedScrollingParent(i2);
    }

    public void smoothScrollBy(@Px int i2, @Px int i3, @Nullable Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().startNestedScroll(i2, i3);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().stopNestedScroll(i2);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArray;
        char c2;
        ClassLoader classLoader;
        Object[] objArr;
        Constructor<? extends U> constructor;
        this.a = new g();
        this.b = new Recycler();
        this.f = new s();
        this.h = new a();
        this.i = new Rect();
        this.j = new Rect();
        this.k = new RectF();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
        this.v = 0;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = new EdgeEffectFactory();
        this.M = new DefaultItemAnimator();
        this.N = 0;
        this.O = -1;
        this.b0 = Float.MIN_VALUE;
        this.c0 = Float.MIN_VALUE;
        this.d0 = true;
        this.e0 = new h();
        this.g0 = B0 ? new i.b() : null;
        this.h0 = new State();
        this.k0 = false;
        this.l0 = false;
        this.m0 = new f();
        this.n0 = false;
        this.q0 = new int[2];
        this.s0 = new int[2];
        this.t0 = new int[2];
        this.u0 = new int[2];
        this.v0 = new ArrayList();
        this.w0 = new b();
        this.x0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.U = viewConfiguration.getScaledTouchSlop();
        this.b0 = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.c0 = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.W = viewConfiguration.getScaledMinimumFlingVelocity();
        this.a0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.M.a = this.m0;
        this.d = new l6.v.a.a(new r(this));
        this.e = new l6.v.a.b(new q(this));
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.B = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] iArr = R.styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.g = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.t = z2;
        if (z2) {
            StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(a2.b.a.a.a.v2(this, a2.b.a.a.a.L("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            c2 = 2;
            typedArray = obtainStyledAttributes;
            new l6.v.a.h(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
        } else {
            typedArray = obtainStyledAttributes;
            c2 = 2;
        }
        typedArray.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = RecyclerView.class.getPackage().getName() + FormatterType.defaultDecimalSeparator + trim;
                }
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(trim, false, classLoader).asSubclass(LayoutManager.class);
                    try {
                        constructor = asSubclass.getConstructor(C0);
                        objArr = new Object[4];
                        objArr[0] = context;
                        objArr[1] = attributeSet;
                        objArr[c2] = Integer.valueOf(i2);
                        objArr[3] = 0;
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + trim, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + trim, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + trim, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + trim, e8);
                }
            }
        }
        int i3 = Build.VERSION.SDK_INT;
        int[] iArr2 = y0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
        if (i3 >= 29) {
            saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes2, i2, 0);
        }
        boolean z3 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, @NonNull int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void smoothScrollBy(@Px int i2, @Px int i3, @Nullable Interpolator interpolator, int i4) {
        Y(i2, i3, interpolator, i4, false);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public ViewHolder a;
        public final Rect b = new Rect();
        public boolean c = true;
        public boolean d = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getViewAdapterPosition() {
            return this.a.getAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.a.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.a.getPosition();
        }

        public boolean isItemChanged() {
            return this.a.m();
        }

        public boolean isItemRemoved() {
            return this.a.j();
        }

        public boolean isViewInvalid() {
            return this.a.i();
        }

        public boolean viewNeedsUpdate() {
            return this.a.n();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public Parcelable b;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.b, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.m;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(a2.b.a.a.a.v2(this, a2.b.a.a.a.L("RecyclerView has no LayoutManager")));
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }
}
