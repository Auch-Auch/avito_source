package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    public int A;
    public int B;
    public boolean C;
    public SavedState D;
    public final a E;
    public final LayoutChunkResult F;
    public int G;
    public int[] H;
    public int s;
    public b t;
    public OrientationHelper u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int a;
        public int b;
        public boolean c;

        public static class a implements Parcelable.Creator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        public boolean a() {
            return this.a >= 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }
    }

    public static class a {
        public OrientationHelper a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;

        public a() {
            d();
        }

        public void a() {
            int i;
            if (this.d) {
                i = this.a.getEndAfterPadding();
            } else {
                i = this.a.getStartAfterPadding();
            }
            this.c = i;
        }

        public void b(View view, int i) {
            if (this.d) {
                this.c = this.a.getTotalSpaceChange() + this.a.getDecoratedEnd(view);
            } else {
                this.c = this.a.getDecoratedStart(view);
            }
            this.b = i;
        }

        public void c(View view, int i) {
            int totalSpaceChange = this.a.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            if (this.d) {
                int endAfterPadding = (this.a.getEndAfterPadding() - totalSpaceChange) - this.a.getDecoratedEnd(view);
                this.c = this.a.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.c - this.a.getDecoratedMeasurement(view);
                    int startAfterPadding = this.a.getStartAfterPadding();
                    int min = decoratedMeasurement - (Math.min(this.a.getDecoratedStart(view) - startAfterPadding, 0) + startAfterPadding);
                    if (min < 0) {
                        this.c = Math.min(endAfterPadding, -min) + this.c;
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = this.a.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - this.a.getStartAfterPadding();
            this.c = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (this.a.getEndAfterPadding() - Math.min(0, (this.a.getEndAfterPadding() - totalSpaceChange) - this.a.getDecoratedEnd(view))) - (this.a.getDecoratedMeasurement(view) + decoratedStart);
                if (endAfterPadding2 < 0) {
                    this.c -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        public void d() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("AnchorInfo{mPosition=");
            L.append(this.b);
            L.append(", mCoordinate=");
            L.append(this.c);
            L.append(", mLayoutFromEnd=");
            L.append(this.d);
            L.append(", mValid=");
            return a2.b.a.a.a.A(L, this.e, '}');
        }
    }

    public static class b {
        public boolean a = true;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h = 0;
        public int i = 0;
        public int j;
        public List<RecyclerView.ViewHolder> k = null;
        public boolean l;

        public void a(View view) {
            int viewLayoutPosition;
            int size = this.k.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.k.get(i3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.d) * this.e) >= 0 && viewLayoutPosition < i2) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i2 = viewLayoutPosition;
                }
            }
            if (view2 == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.LayoutParams) view2.getLayoutParams()).getViewLayoutPosition();
            }
        }

        public boolean b(RecyclerView.State state) {
            int i2 = this.d;
            return i2 >= 0 && i2 < state.getItemCount();
        }

        public View c(RecyclerView.Recycler recycler) {
            List<RecyclerView.ViewHolder> list = this.k;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view = this.k.get(i2).itemView;
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    if (!layoutParams.isItemRemoved() && this.d == layoutParams.getViewLayoutPosition()) {
                        a(view);
                        return view;
                    }
                }
                return null;
            }
            View viewForPosition = recycler.getViewForPosition(this.d);
            this.d += this.e;
            return viewForPosition;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public View A(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        s();
        int startAfterPadding = this.u.getStartAfterPadding();
        int endAfterPadding = this.u.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.u.getDecoratedStart(childAt) < endAfterPadding && this.u.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    public final int B(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int endAfterPadding;
        int endAfterPadding2 = this.u.getEndAfterPadding() - i;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -L(-endAfterPadding2, recycler, state);
        int i3 = i + i2;
        if (!z2 || (endAfterPadding = this.u.getEndAfterPadding() - i3) <= 0) {
            return i2;
        }
        this.u.offsetChildren(endAfterPadding);
        return endAfterPadding + i2;
    }

    public final int C(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int startAfterPadding;
        int startAfterPadding2 = i - this.u.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -L(startAfterPadding2, recycler, state);
        int i3 = i + i2;
        if (!z2 || (startAfterPadding = i3 - this.u.getStartAfterPadding()) <= 0) {
            return i2;
        }
        this.u.offsetChildren(-startAfterPadding);
        return i2 - startAfterPadding;
    }

    public final View D() {
        return getChildAt(this.x ? 0 : getChildCount() - 1);
    }

    public final View E() {
        return getChildAt(this.x ? getChildCount() - 1 : 0);
    }

    public void F(RecyclerView.Recycler recycler, RecyclerView.State state, b bVar, LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View c = bVar.c(recycler);
        if (c == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) c.getLayoutParams();
        if (bVar.k == null) {
            if (this.x == (bVar.f == -1)) {
                addView(c);
            } else {
                addView(c, 0);
            }
        } else {
            if (this.x == (bVar.f == -1)) {
                addDisappearingView(c);
            } else {
                addDisappearingView(c, 0);
            }
        }
        measureChildWithMargins(c, 0, 0);
        layoutChunkResult.mConsumed = this.u.getDecoratedMeasurement(c);
        if (this.s == 1) {
            if (isLayoutRTL()) {
                i5 = getWidth() - getPaddingRight();
                i4 = i5 - this.u.getDecoratedMeasurementInOther(c);
            } else {
                i4 = getPaddingLeft();
                i5 = this.u.getDecoratedMeasurementInOther(c) + i4;
            }
            if (bVar.f == -1) {
                int i6 = bVar.b;
                i = i6;
                i2 = i5;
                i3 = i6 - layoutChunkResult.mConsumed;
            } else {
                int i7 = bVar.b;
                i3 = i7;
                i2 = i5;
                i = layoutChunkResult.mConsumed + i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther = this.u.getDecoratedMeasurementInOther(c) + paddingTop;
            if (bVar.f == -1) {
                int i8 = bVar.b;
                i2 = i8;
                i3 = paddingTop;
                i = decoratedMeasurementInOther;
                i4 = i8 - layoutChunkResult.mConsumed;
            } else {
                int i9 = bVar.b;
                i3 = paddingTop;
                i2 = layoutChunkResult.mConsumed + i9;
                i = decoratedMeasurementInOther;
                i4 = i9;
            }
        }
        layoutDecoratedWithMargins(c, i4, i3, i2, i);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = c.hasFocusable();
    }

    public void G(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar, int i) {
    }

    public final void H(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.a && !bVar.l) {
            int i = bVar.g;
            int i2 = bVar.i;
            if (bVar.f == -1) {
                int childCount = getChildCount();
                if (i >= 0) {
                    int end = (this.u.getEnd() - i) + i2;
                    if (this.x) {
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt = getChildAt(i3);
                            if (this.u.getDecoratedStart(childAt) < end || this.u.getTransformedStartWithDecoration(childAt) < end) {
                                I(recycler, 0, i3);
                                return;
                            }
                        }
                        return;
                    }
                    int i4 = childCount - 1;
                    for (int i5 = i4; i5 >= 0; i5--) {
                        View childAt2 = getChildAt(i5);
                        if (this.u.getDecoratedStart(childAt2) < end || this.u.getTransformedStartWithDecoration(childAt2) < end) {
                            I(recycler, i4, i5);
                            return;
                        }
                    }
                }
            } else if (i >= 0) {
                int i6 = i - i2;
                int childCount2 = getChildCount();
                if (this.x) {
                    int i7 = childCount2 - 1;
                    for (int i8 = i7; i8 >= 0; i8--) {
                        View childAt3 = getChildAt(i8);
                        if (this.u.getDecoratedEnd(childAt3) > i6 || this.u.getTransformedEndWithDecoration(childAt3) > i6) {
                            I(recycler, i7, i8);
                            return;
                        }
                    }
                    return;
                }
                for (int i9 = 0; i9 < childCount2; i9++) {
                    View childAt4 = getChildAt(i9);
                    if (this.u.getDecoratedEnd(childAt4) > i6 || this.u.getTransformedEndWithDecoration(childAt4) > i6) {
                        I(recycler, 0, i9);
                        return;
                    }
                }
            }
        }
    }

    public final void I(RecyclerView.Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, recycler);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
        }
    }

    public boolean J() {
        return this.u.getMode() == 0 && this.u.getEnd() == 0;
    }

    public final void K() {
        if (this.s == 1 || !isLayoutRTL()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    public int L(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        s();
        this.t.a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        M(i2, abs, true, state);
        b bVar = this.t;
        int t2 = t(recycler, bVar, state, false) + bVar.g;
        if (t2 < 0) {
            return 0;
        }
        if (abs > t2) {
            i = i2 * t2;
        }
        this.u.offsetChildren(-i);
        this.t.j = i;
        return i;
    }

    public final void M(int i, int i2, boolean z2, RecyclerView.State state) {
        int i3;
        this.t.l = J();
        this.t.f = i;
        int[] iArr = this.H;
        boolean z3 = false;
        iArr[0] = 0;
        int i4 = 1;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.H[0]);
        int max2 = Math.max(0, this.H[1]);
        if (i == 1) {
            z3 = true;
        }
        b bVar = this.t;
        int i5 = z3 ? max2 : max;
        bVar.h = i5;
        if (!z3) {
            max = max2;
        }
        bVar.i = max;
        if (z3) {
            bVar.h = this.u.getEndPadding() + i5;
            View D2 = D();
            b bVar2 = this.t;
            if (this.x) {
                i4 = -1;
            }
            bVar2.e = i4;
            int position = getPosition(D2);
            b bVar3 = this.t;
            bVar2.d = position + bVar3.e;
            bVar3.b = this.u.getDecoratedEnd(D2);
            i3 = this.u.getDecoratedEnd(D2) - this.u.getEndAfterPadding();
        } else {
            View E2 = E();
            b bVar4 = this.t;
            bVar4.h = this.u.getStartAfterPadding() + bVar4.h;
            b bVar5 = this.t;
            if (!this.x) {
                i4 = -1;
            }
            bVar5.e = i4;
            int position2 = getPosition(E2);
            b bVar6 = this.t;
            bVar5.d = position2 + bVar6.e;
            bVar6.b = this.u.getDecoratedStart(E2);
            i3 = (-this.u.getDecoratedStart(E2)) + this.u.getStartAfterPadding();
        }
        b bVar7 = this.t;
        bVar7.c = i2;
        if (z2) {
            bVar7.c = i2 - i3;
        }
        bVar7.g = i3;
    }

    public final void N(int i, int i2) {
        this.t.c = this.u.getEndAfterPadding() - i2;
        b bVar = this.t;
        bVar.e = this.x ? -1 : 1;
        bVar.d = i;
        bVar.f = 1;
        bVar.b = i2;
        bVar.g = Integer.MIN_VALUE;
    }

    public final void O(int i, int i2) {
        this.t.c = i2 - this.u.getStartAfterPadding();
        b bVar = this.t;
        bVar.d = i;
        bVar.e = this.x ? 1 : -1;
        bVar.f = -1;
        bVar.b = i2;
        bVar.g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.D == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.t.f == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.s != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            s();
            M(i > 0 ? 1 : -1, Math.abs(i), true, state);
            n(state, this.t, layoutPrefetchRegistry);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int i, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z2;
        int i2;
        SavedState savedState = this.D;
        int i3 = -1;
        if (savedState == null || !savedState.a()) {
            K();
            z2 = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z2 ? i - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z2 = savedState2.c;
            i2 = savedState2.a;
        }
        if (!z2) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.G && i2 >= 0 && i2 < i; i4++) {
            layoutPrefetchRegistry.addPosition(i2, 0);
            i2 += i3;
        }
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
        return q(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z2 = false;
        int i2 = 1;
        if (i < getPosition(getChildAt(0))) {
            z2 = true;
        }
        if (z2 != this.x) {
            i2 = -1;
        }
        if (this.s == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
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
        return q(state);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View z2 = z(0, getChildCount(), true, false);
        if (z2 == null) {
            return -1;
        }
        return getPosition(z2);
    }

    public int findFirstVisibleItemPosition() {
        View z2 = z(0, getChildCount(), false, true);
        if (z2 == null) {
            return -1;
        }
        return getPosition(z2);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View z2 = z(getChildCount() - 1, -1, true, false);
        if (z2 == null) {
            return -1;
        }
        return getPosition(z2);
    }

    public int findLastVisibleItemPosition() {
        View z2 = z(getChildCount() - 1, -1, false, true);
        if (z2 == null) {
            return -1;
        }
        return getPosition(z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.u.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.G;
    }

    public int getOrientation() {
        return this.s;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.C;
    }

    public boolean getReverseLayout() {
        return this.w;
    }

    public boolean getStackFromEnd() {
        return this.y;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean l() {
        boolean z2;
        if (!(getHeightMode() == 1073741824 || getWidthMode() == 1073741824)) {
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    z2 = false;
                    break;
                }
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z2 = true;
                    break;
                }
                i++;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public void n(RecyclerView.State state, b bVar, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = bVar.d;
        if (i >= 0 && i < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(i, Math.max(0, bVar.g));
        }
    }

    public final int o(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        s();
        return AppCompatDelegateImpl.i.L(state, this.u, w(!this.z, true), v(!this.z, true), this, this.z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.C) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int r;
        View view2;
        View view3;
        K();
        if (getChildCount() == 0 || (r = r(i)) == Integer.MIN_VALUE) {
            return null;
        }
        s();
        M(r, (int) (((float) this.u.getTotalSpace()) * 0.33333334f), false, state);
        b bVar = this.t;
        bVar.g = Integer.MIN_VALUE;
        bVar.a = false;
        t(recycler, bVar, state, true);
        if (r == -1) {
            if (this.x) {
                view2 = y(getChildCount() - 1, -1);
            } else {
                view2 = y(0, getChildCount());
            }
        } else if (this.x) {
            view2 = y(0, getChildCount());
        } else {
            view2 = y(getChildCount() - 1, -1);
        }
        if (r == -1) {
            view3 = E();
        } else {
            view3 = D();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0182  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r17, androidx.recyclerview.widget.RecyclerView.State r18) {
        /*
        // Method dump skipped, instructions count: 1105
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.D = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.D;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            s();
            boolean z2 = this.v ^ this.x;
            savedState2.c = z2;
            if (z2) {
                View D2 = D();
                savedState2.b = this.u.getEndAfterPadding() - this.u.getDecoratedEnd(D2);
                savedState2.a = getPosition(D2);
            } else {
                View E2 = E();
                savedState2.a = getPosition(E2);
                savedState2.b = this.u.getDecoratedStart(E2) - this.u.getStartAfterPadding();
            }
        } else {
            savedState2.a = -1;
        }
        return savedState2;
    }

    public final int p(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        s();
        return AppCompatDelegateImpl.i.M(state, this.u, w(!this.z, true), v(!this.z, true), this, this.z, this.x);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        s();
        K();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c = position < position2 ? (char) 1 : 65535;
        if (this.x) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.u.getEndAfterPadding() - (this.u.getDecoratedMeasurement(view) + this.u.getDecoratedStart(view2)));
            } else {
                scrollToPositionWithOffset(position2, this.u.getEndAfterPadding() - this.u.getDecoratedEnd(view2));
            }
        } else if (c == 65535) {
            scrollToPositionWithOffset(position2, this.u.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.u.getDecoratedEnd(view2) - this.u.getDecoratedMeasurement(view));
        }
    }

    public final int q(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        s();
        return AppCompatDelegateImpl.i.N(state, this.u, w(!this.z, true), v(!this.z, true), this, this.z);
    }

    public int r(int i) {
        if (i == 1) {
            return (this.s != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.s != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    return (i == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE;
                }
                if (this.s == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            } else if (this.s == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.s == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public void s() {
        if (this.t == null) {
            this.t = new b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.s == 1) {
            return 0;
        }
        return L(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.A = i;
        this.B = Integer.MIN_VALUE;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.a = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.A = i;
        this.B = i2;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.a = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.s == 0) {
            return 0;
        }
        return L(i, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.G = i;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll(null);
            if (i != this.s || this.u == null) {
                OrientationHelper createOrientationHelper = OrientationHelper.createOrientationHelper(this, i);
                this.u = createOrientationHelper;
                this.E.a = createOrientationHelper;
                this.s = i;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.M2("invalid orientation:", i));
    }

    public void setRecycleChildrenOnDetach(boolean z2) {
        this.C = z2;
    }

    public void setReverseLayout(boolean z2) {
        assertNotInLayoutOrScroll(null);
        if (z2 != this.w) {
            this.w = z2;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z2) {
        this.z = z2;
    }

    public void setStackFromEnd(boolean z2) {
        assertNotInLayoutOrScroll(null);
        if (this.y != z2) {
            this.y = z2;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.D == null && this.v == this.y;
    }

    public int t(RecyclerView.Recycler recycler, b bVar, RecyclerView.State state, boolean z2) {
        int i = bVar.c;
        int i2 = bVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                bVar.g = i2 + i;
            }
            H(recycler, bVar);
        }
        int i3 = bVar.c + bVar.h;
        LayoutChunkResult layoutChunkResult = this.F;
        while (true) {
            if ((!bVar.l && i3 <= 0) || !bVar.b(state)) {
                break;
            }
            layoutChunkResult.mConsumed = 0;
            layoutChunkResult.mFinished = false;
            layoutChunkResult.mIgnoreConsumed = false;
            layoutChunkResult.mFocusable = false;
            F(recycler, state, bVar, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                bVar.b = (layoutChunkResult.mConsumed * bVar.f) + bVar.b;
                if (!layoutChunkResult.mIgnoreConsumed || bVar.k != null || !state.isPreLayout()) {
                    int i4 = bVar.c;
                    int i5 = layoutChunkResult.mConsumed;
                    bVar.c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = bVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + layoutChunkResult.mConsumed;
                    bVar.g = i7;
                    int i8 = bVar.c;
                    if (i8 < 0) {
                        bVar.g = i7 + i8;
                    }
                    H(recycler, bVar);
                }
                if (z2 && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - bVar.c;
    }

    public final View u(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return A(recycler, state, 0, getChildCount(), state.getItemCount());
    }

    public View v(boolean z2, boolean z3) {
        if (this.x) {
            return z(0, getChildCount(), z2, z3);
        }
        return z(getChildCount() - 1, -1, z2, z3);
    }

    public View w(boolean z2, boolean z3) {
        if (this.x) {
            return z(getChildCount() - 1, -1, z2, z3);
        }
        return z(0, getChildCount(), z2, z3);
    }

    public final View x(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return A(recycler, state, getChildCount() - 1, -1, state.getItemCount());
    }

    public View y(int i, int i2) {
        int i3;
        int i4;
        s();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return getChildAt(i);
        }
        if (this.u.getDecoratedStart(getChildAt(i)) < this.u.getStartAfterPadding()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        if (this.s == 0) {
            return this.e.a(i, i2, i4, i3);
        }
        return this.f.a(i, i2, i4, i3);
    }

    public View z(int i, int i2, boolean z2, boolean z3) {
        s();
        int i3 = 320;
        int i4 = z2 ? 24579 : 320;
        if (!z3) {
            i3 = 0;
        }
        if (this.s == 0) {
            return this.e.a(i, i2, i4, i3);
        }
        return this.f.a(i, i2, i4, i3);
    }

    public LinearLayoutManager(Context context, int i, boolean z2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new LayoutChunkResult();
        this.G = 2;
        this.H = new int[2];
        setOrientation(i);
        setReverseLayout(z2);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new LayoutChunkResult();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }
}
