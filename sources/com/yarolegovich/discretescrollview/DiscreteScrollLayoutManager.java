package com.yarolegovich.discretescrollview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer;
import java.util.Locale;
public class DiscreteScrollLayoutManager extends RecyclerView.LayoutManager {
    public int A;
    public int B;
    public int C = -1;
    public int D = -1;
    public SparseArray<View> E = new SparseArray<>();
    public DSVOrientation.c F;
    public boolean G;
    public Context H;
    public int I = 300;
    public int J;
    public int K;
    public boolean L;
    public int M = 2100;
    public boolean N = false;
    public int O;
    public int P;
    @NonNull
    public final ScrollStateListener Q;
    public DiscreteScrollItemTransformer R;
    public RecyclerViewProxy S;
    public Point s = new Point();
    public Point t = new Point();
    public Point u = new Point();
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public interface InitialPositionProvider {
        int getInitialPosition();
    }

    public interface ScrollStateListener {
        void onCurrentViewFirstLayout();

        void onDataSetChangeChangedPosition();

        void onIsBoundReachedFlagChange(boolean z);

        void onScroll(float f);

        void onScrollEnd();

        void onScrollStart();
    }

    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i) {
            DiscreteScrollLayoutManager discreteScrollLayoutManager = DiscreteScrollLayoutManager.this;
            return discreteScrollLayoutManager.F.getPendingDx(-discreteScrollLayoutManager.B);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i) {
            DiscreteScrollLayoutManager discreteScrollLayoutManager = DiscreteScrollLayoutManager.this;
            return discreteScrollLayoutManager.F.getPendingDy(-discreteScrollLayoutManager.B);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i) {
            return (int) (Math.max(0.01f, ((float) Math.min(Math.abs(i), DiscreteScrollLayoutManager.this.y)) / ((float) DiscreteScrollLayoutManager.this.y)) * ((float) DiscreteScrollLayoutManager.this.I));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        @Nullable
        public PointF computeScrollVectorForPosition(int i) {
            DiscreteScrollLayoutManager discreteScrollLayoutManager = DiscreteScrollLayoutManager.this;
            DiscreteScrollLayoutManager discreteScrollLayoutManager2 = DiscreteScrollLayoutManager.this;
            return new PointF((float) discreteScrollLayoutManager.F.getPendingDx(discreteScrollLayoutManager.B), (float) discreteScrollLayoutManager2.F.getPendingDy(discreteScrollLayoutManager2.B));
        }
    }

    public DiscreteScrollLayoutManager(@NonNull Context context, @NonNull ScrollStateListener scrollStateListener, @NonNull DSVOrientation dSVOrientation) {
        this.H = context;
        this.Q = scrollStateListener;
        this.F = dSVOrientation.a();
        this.S = new RecyclerViewProxy(this);
        this.K = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.F.canScrollHorizontally();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.F.canScrollVertically();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return o(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return p(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return o(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return p(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public void n() {
        if (this.R != null) {
            int i = this.y * this.K;
            for (int i2 = 0; i2 < this.S.getChildCount(); i2++) {
                View childAt = this.S.getChildAt(i2);
                this.R.transformItem(childAt, Math.min(Math.max(-1.0f, this.F.getDistanceFromCenter(this.t, getDecoratedLeft(childAt) + this.v, getDecoratedTop(childAt) + this.w) / ((float) i)), 1.0f));
            }
        }
    }

    public final int o(RecyclerView.State state) {
        if (getItemCount() == 0) {
            return 0;
        }
        return (int) (((float) q()) / ((float) getItemCount()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.D = -1;
        this.B = 0;
        this.A = 0;
        if (adapter2 instanceof InitialPositionProvider) {
            this.C = ((InitialPositionProvider) adapter2).getInitialPosition();
        } else {
            this.C = 0;
        }
        this.S.removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (this.S.getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            asRecord.setFromIndex(getPosition(s()));
            asRecord.setToIndex(getPosition(t()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        int i3 = this.C;
        if (i3 == -1) {
            i3 = 0;
        } else if (i3 >= i) {
            i3 = Math.min(i3 + i2, this.S.getItemCount() - 1);
        }
        if (this.C != i3) {
            this.C = i3;
            this.L = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.C = Math.min(Math.max(0, this.C), this.S.getItemCount() - 1);
        this.L = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        int i3 = this.C;
        if (this.S.getItemCount() == 0) {
            i3 = -1;
        } else {
            int i4 = this.C;
            if (i4 >= i) {
                if (i4 < i + i2) {
                    this.C = -1;
                }
                i3 = Math.max(0, this.C - i2);
            }
        }
        if (this.C != i3) {
            this.C = i3;
            this.L = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() == 0) {
            this.S.removeAndRecycleAllViews(recycler);
            this.D = -1;
            this.C = -1;
            this.B = 0;
            this.A = 0;
            return;
        }
        int i = this.C;
        if (i == -1 || i >= state.getItemCount()) {
            this.C = 0;
        }
        boolean z2 = true;
        if (!state.isMeasuring() && !(this.S.getWidth() == this.O && this.S.getHeight() == this.P)) {
            this.O = this.S.getWidth();
            this.P = this.S.getHeight();
            this.S.removeAllViews();
        }
        this.t.set(this.S.getWidth() / 2, this.S.getHeight() / 2);
        if (!this.G) {
            if (this.S.getChildCount() != 0) {
                z2 = false;
            }
            this.G = z2;
            if (z2) {
                View measuredChildForAdapterPosition = this.S.getMeasuredChildForAdapterPosition(0, recycler);
                int measuredWidthWithMargin = this.S.getMeasuredWidthWithMargin(measuredChildForAdapterPosition);
                int measuredHeightWithMargin = this.S.getMeasuredHeightWithMargin(measuredChildForAdapterPosition);
                this.v = measuredWidthWithMargin / 2;
                this.w = measuredHeightWithMargin / 2;
                int distanceToChangeCurrent = this.F.getDistanceToChangeCurrent(measuredWidthWithMargin, measuredHeightWithMargin);
                this.y = distanceToChangeCurrent;
                this.x = distanceToChangeCurrent * this.J;
                this.S.detachAndScrapView(measuredChildForAdapterPosition, recycler);
            }
        }
        this.S.detachAndScrapAttachedViews(recycler);
        r(recycler);
        n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        if (this.G) {
            this.Q.onCurrentViewFirstLayout();
            this.G = false;
        } else if (this.L) {
            this.Q.onDataSetChangeChangedPosition();
            this.L = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.C = ((Bundle) parcelable).getInt("extra_position");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        int i = this.D;
        if (i != -1) {
            this.C = i;
        }
        bundle.putInt("extra_position", this.C);
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        int i2 = this.z;
        if (i2 == 0 && i2 != i) {
            this.Q.onScrollStart();
        }
        boolean z2 = false;
        if (i == 0) {
            int i3 = this.D;
            if (i3 != -1) {
                this.C = i3;
                this.D = -1;
                this.A = 0;
            }
            a2.v.a.a b = a2.v.a.a.b(this.A);
            if (Math.abs(this.A) == this.y) {
                this.C = b.a(1) + this.C;
                this.A = 0;
            }
            if (u()) {
                this.B = a2.v.a.a.b(this.A).a(this.y - Math.abs(this.A));
            } else {
                this.B = -this.A;
            }
            if (this.B == 0) {
                z2 = true;
            } else {
                y();
            }
            if (z2) {
                this.Q.onScrollEnd();
            } else {
                return;
            }
        } else if (i == 1) {
            int abs = Math.abs(this.A);
            int i4 = this.y;
            if (abs > i4) {
                int i5 = this.A;
                int i6 = i5 / i4;
                this.C += i6;
                this.A = i5 - (i6 * i4);
            }
            if (u()) {
                this.C = a2.v.a.a.b(this.A).a(1) + this.C;
                this.A = -a2.v.a.a.b(this.A).a(this.y - Math.abs(this.A));
            }
            this.D = -1;
            this.B = 0;
        }
        this.z = i;
    }

    public final int p(RecyclerView.State state) {
        int o = o(state);
        return (this.C * o) + ((int) ((((float) this.A) / ((float) this.y)) * ((float) o)));
    }

    public final int q() {
        if (getItemCount() == 0) {
            return 0;
        }
        return (getItemCount() - 1) * this.y;
    }

    public void r(RecyclerView.Recycler recycler) {
        this.E.clear();
        for (int i = 0; i < this.S.getChildCount(); i++) {
            View childAt = this.S.getChildAt(i);
            this.E.put(this.S.getPosition(childAt), childAt);
        }
        for (int i2 = 0; i2 < this.E.size(); i2++) {
            this.S.detachView(this.E.valueAt(i2));
        }
        this.F.setCurrentViewCenter(this.t, this.A, this.u);
        int viewEnd = this.F.getViewEnd(this.S.getWidth(), this.S.getHeight());
        if (this.F.isViewVisible(this.u, this.v, this.w, viewEnd, this.x)) {
            v(recycler, this.C, this.u);
        }
        w(recycler, a2.v.a.a.START, viewEnd);
        w(recycler, a2.v.a.a.END, viewEnd);
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            this.S.recycleView(this.E.valueAt(i3), recycler);
        }
        this.E.clear();
    }

    public View s() {
        return this.S.getChildAt(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return x(i, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        if (this.C != i) {
            this.C = i;
            this.S.requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return x(i, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        if (this.C != i && this.D == -1) {
            if (i < 0 || i >= state.getItemCount()) {
                throw new IllegalArgumentException(String.format(Locale.US, "target position out of bounds: position=%d, itemCount=%d", Integer.valueOf(i), Integer.valueOf(state.getItemCount())));
            } else if (this.C == -1) {
                this.C = i;
            } else {
                z(i);
            }
        }
    }

    public View t() {
        RecyclerViewProxy recyclerViewProxy = this.S;
        return recyclerViewProxy.getChildAt(recyclerViewProxy.getChildCount() - 1);
    }

    public final boolean u() {
        return ((float) Math.abs(this.A)) >= ((float) this.y) * 0.6f;
    }

    public void v(RecyclerView.Recycler recycler, int i, Point point) {
        if (i >= 0) {
            View view = this.E.get(i);
            if (view == null) {
                View measuredChildForAdapterPosition = this.S.getMeasuredChildForAdapterPosition(i, recycler);
                RecyclerViewProxy recyclerViewProxy = this.S;
                int i2 = point.x;
                int i3 = this.v;
                int i4 = point.y;
                int i5 = this.w;
                recyclerViewProxy.layoutDecoratedWithMargins(measuredChildForAdapterPosition, i2 - i3, i4 - i5, i2 + i3, i4 + i5);
                return;
            }
            this.S.attachView(view);
            this.E.remove(i);
        }
    }

    public final void w(RecyclerView.Recycler recycler, a2.v.a.a aVar, int i) {
        int a3 = aVar.a(1);
        int i2 = this.D;
        boolean z2 = i2 == -1 || !aVar.c(i2 - this.C);
        Point point = this.s;
        Point point2 = this.u;
        point.set(point2.x, point2.y);
        int i3 = this.C;
        while (true) {
            i3 += a3;
            if (i3 >= 0 && i3 < this.S.getItemCount()) {
                if (i3 == this.D) {
                    z2 = true;
                }
                this.F.shiftViewCenter(aVar, this.y, this.s);
                if (this.F.isViewVisible(this.s, this.v, this.w, i, this.x)) {
                    v(recycler, i3, this.s);
                } else if (z2) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public int x(int i, RecyclerView.Recycler recycler) {
        int i2;
        if (this.S.getChildCount() == 0) {
            return 0;
        }
        a2.v.a.a b = a2.v.a.a.b(i);
        int i3 = this.B;
        if (i3 != 0) {
            i2 = Math.abs(i3);
        } else {
            boolean z2 = true;
            boolean z3 = b.a(this.A) > 0;
            if (b == a2.v.a.a.START && this.C == 0) {
                int i4 = this.A;
                if (i4 != 0) {
                    z2 = false;
                }
                if (!z2) {
                    i2 = Math.abs(i4);
                    this.Q.onIsBoundReachedFlagChange(z2);
                }
            } else if (b == a2.v.a.a.END && this.C == this.S.getItemCount() - 1) {
                int i5 = this.A;
                if (i5 != 0) {
                    z2 = false;
                }
                if (!z2) {
                    i2 = Math.abs(i5);
                    this.Q.onIsBoundReachedFlagChange(z2);
                }
            } else {
                if (z3) {
                    i2 = this.y - Math.abs(this.A);
                } else {
                    i2 = Math.abs(this.A) + this.y;
                }
                z2 = false;
                this.Q.onIsBoundReachedFlagChange(z2);
            }
            i2 = 0;
            this.Q.onIsBoundReachedFlagChange(z2);
        }
        if (i2 <= 0) {
            return 0;
        }
        int a3 = b.a(Math.min(i2, Math.abs(i)));
        this.A += a3;
        int i6 = this.B;
        if (i6 != 0) {
            this.B = i6 - a3;
        }
        this.F.offsetChildren(-a3, this.S);
        if (this.F.hasNewBecomeVisible(this)) {
            r(recycler);
        }
        this.Q.onScroll(-Math.min(Math.max(-1.0f, ((float) this.A) / ((float) (this.D != -1 ? Math.abs(this.A + this.B) : this.y))), 1.0f));
        n();
        return a3;
    }

    public final void y() {
        a aVar = new a(this.H);
        aVar.setTargetPosition(this.C);
        this.S.startSmoothScroll(aVar);
    }

    public final void z(int i) {
        int i2 = this.C;
        if (i2 != i) {
            this.B = -this.A;
            a2.v.a.a b = a2.v.a.a.b(i - i2);
            int abs = Math.abs(i - this.C) * this.y;
            this.B = b.a(abs) + this.B;
            this.D = i;
            y();
        }
    }
}
