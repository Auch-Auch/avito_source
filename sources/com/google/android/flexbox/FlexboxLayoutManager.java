package com.google.android.flexbox;

import a2.j.b.c.c;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements a2.j.b.c.a, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final Rect S = new Rect();
    public final a2.j.b.c.c A;
    public RecyclerView.Recycler B;
    public RecyclerView.State C;
    public c D;
    public b E;
    public OrientationHelper F;
    public OrientationHelper G;
    public d H;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public SparseArray<View> N;
    public final Context O;
    public View P;
    public int Q;
    public c.b R;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public List<FlexLine> z;

    public class b {
        public int a;
        public int b;
        public int c;
        public int d = 0;
        public boolean e;
        public boolean f;
        public boolean g;

        public b(a aVar) {
        }

        public static void a(b bVar) {
            int i;
            int i2;
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                if (flexboxLayoutManager.x) {
                    if (bVar.e) {
                        i2 = flexboxLayoutManager.F.getEndAfterPadding();
                    } else {
                        i2 = flexboxLayoutManager.getWidth() - FlexboxLayoutManager.this.F.getStartAfterPadding();
                    }
                    bVar.c = i2;
                    return;
                }
            }
            if (bVar.e) {
                i = FlexboxLayoutManager.this.F.getEndAfterPadding();
            } else {
                i = FlexboxLayoutManager.this.F.getStartAfterPadding();
            }
            bVar.c = i;
        }

        public static void b(b bVar) {
            bVar.a = -1;
            bVar.b = -1;
            bVar.c = Integer.MIN_VALUE;
            boolean z = false;
            bVar.f = false;
            bVar.g = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                int i = flexboxLayoutManager.t;
                if (i == 0) {
                    if (flexboxLayoutManager.s == 1) {
                        z = true;
                    }
                    bVar.e = z;
                    return;
                }
                if (i == 2) {
                    z = true;
                }
                bVar.e = z;
                return;
            }
            FlexboxLayoutManager flexboxLayoutManager2 = FlexboxLayoutManager.this;
            int i2 = flexboxLayoutManager2.t;
            if (i2 == 0) {
                if (flexboxLayoutManager2.s == 3) {
                    z = true;
                }
                bVar.e = z;
                return;
            }
            if (i2 == 2) {
                z = true;
            }
            bVar.e = z;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("AnchorInfo{mPosition=");
            L.append(this.a);
            L.append(", mFlexLinePosition=");
            L.append(this.b);
            L.append(", mCoordinate=");
            L.append(this.c);
            L.append(", mPerpendicularCoordinate=");
            L.append(this.d);
            L.append(", mLayoutFromEnd=");
            L.append(this.e);
            L.append(", mValid=");
            L.append(this.f);
            L.append(", mAssignedFromSavedState=");
            return a2.b.a.a.a.A(L, this.g, '}');
        }
    }

    public static class c {
        public int a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h = 1;
        public int i = 1;
        public boolean j;

        public c(a aVar) {
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("LayoutState{mAvailable=");
            L.append(this.a);
            L.append(", mFlexLinePosition=");
            L.append(this.c);
            L.append(", mPosition=");
            L.append(this.d);
            L.append(", mOffset=");
            L.append(this.e);
            L.append(", mScrollingOffset=");
            L.append(this.f);
            L.append(", mLastScrollDelta=");
            L.append(this.g);
            L.append(", mItemDirection=");
            L.append(this.h);
            L.append(", mLayoutDirection=");
            return a2.b.a.a.a.i(L, this.i, '}');
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();
        public int a;
        public int b;

        public static class a implements Parcelable.Creator<d> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, (a) null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("SavedState{mAnchorPosition=");
            L.append(this.a);
            L.append(", mAnchorOffset=");
            return a2.b.a.a.a.i(L, this.b, '}');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
        }

        public d(Parcel parcel, a aVar) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
        }

        public d(d dVar, a aVar) {
            this.a = dVar.a;
            this.b = dVar.b;
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public static boolean c(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    private boolean k(View view, int i, int i2, RecyclerView.LayoutParams layoutParams) {
        return view.isLayoutRequested() || !isMeasurementCacheEnabled() || !c(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) || !c(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height);
    }

    public final int A(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int i2;
        int startAfterPadding;
        if (isMainAxisDirectionHorizontal() || !this.x) {
            int startAfterPadding2 = i - this.F.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            i2 = -B(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.F.getEndAfterPadding() - i;
            if (endAfterPadding <= 0) {
                return 0;
            }
            i2 = B(-endAfterPadding, recycler, state);
        }
        int i3 = i + i2;
        if (!z2 || (startAfterPadding = i3 - this.F.getStartAfterPadding()) <= 0) {
            return i2;
        }
        this.F.offsetChildren(-startAfterPadding);
        return i2 - startAfterPadding;
    }

    public final int B(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        r();
        this.D.j = true;
        boolean z2 = !isMainAxisDirectionHorizontal() && this.x;
        int i3 = (!z2 ? i <= 0 : i >= 0) ? -1 : 1;
        int abs = Math.abs(i);
        this.D.i = i3;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z3 = !isMainAxisDirectionHorizontal && this.x;
        if (i3 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.D.e = this.F.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View w2 = w(childAt, this.z.get(this.A.c[position]));
            c cVar = this.D;
            cVar.h = 1;
            int i4 = position + 1;
            cVar.d = i4;
            int[] iArr = this.A.c;
            if (iArr.length <= i4) {
                cVar.c = -1;
            } else {
                cVar.c = iArr[i4];
            }
            if (z3) {
                cVar.e = this.F.getDecoratedStart(w2);
                this.D.f = this.F.getStartAfterPadding() + (-this.F.getDecoratedStart(w2));
                c cVar2 = this.D;
                int i5 = cVar2.f;
                if (i5 < 0) {
                    i5 = 0;
                }
                cVar2.f = i5;
            } else {
                cVar.e = this.F.getDecoratedEnd(w2);
                this.D.f = this.F.getDecoratedEnd(w2) - this.F.getEndAfterPadding();
            }
            int i6 = this.D.c;
            if ((i6 == -1 || i6 > this.z.size() - 1) && this.D.d <= getFlexItemCount()) {
                int i7 = abs - this.D.f;
                this.R.a();
                if (i7 > 0) {
                    if (isMainAxisDirectionHorizontal) {
                        this.A.b(this.R, makeMeasureSpec, makeMeasureSpec2, i7, this.D.d, -1, this.z);
                    } else {
                        this.A.b(this.R, makeMeasureSpec2, makeMeasureSpec, i7, this.D.d, -1, this.z);
                    }
                    this.A.h(makeMeasureSpec, makeMeasureSpec2, this.D.d);
                    this.A.A(this.D.d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.D.e = this.F.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View u2 = u(childAt2, this.z.get(this.A.c[position2]));
            c cVar3 = this.D;
            cVar3.h = 1;
            int i8 = this.A.c[position2];
            if (i8 == -1) {
                i8 = 0;
            }
            if (i8 > 0) {
                this.D.d = position2 - this.z.get(i8 - 1).getItemCount();
            } else {
                cVar3.d = -1;
            }
            c cVar4 = this.D;
            cVar4.c = i8 > 0 ? i8 - 1 : 0;
            if (z3) {
                cVar4.e = this.F.getDecoratedEnd(u2);
                this.D.f = this.F.getDecoratedEnd(u2) - this.F.getEndAfterPadding();
                c cVar5 = this.D;
                int i9 = cVar5.f;
                if (i9 < 0) {
                    i9 = 0;
                }
                cVar5.f = i9;
            } else {
                cVar4.e = this.F.getDecoratedStart(u2);
                this.D.f = this.F.getStartAfterPadding() + (-this.F.getDecoratedStart(u2));
            }
        }
        c cVar6 = this.D;
        int i10 = cVar6.f;
        cVar6.a = abs - i10;
        int s2 = s(recycler, state, cVar6) + i10;
        if (s2 < 0) {
            return 0;
        }
        if (z2) {
            if (abs > s2) {
                i2 = (-i3) * s2;
                this.F.offsetChildren(-i2);
                this.D.g = i2;
                return i2;
            }
        } else if (abs > s2) {
            i2 = i3 * s2;
            this.F.offsetChildren(-i2);
            this.D.g = i2;
            return i2;
        }
        i2 = i;
        this.F.offsetChildren(-i2);
        this.D.g = i2;
        return i2;
    }

    public final int C(int i) {
        int i2;
        boolean z2 = false;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        r();
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.P;
        int width = isMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = isMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            z2 = true;
        }
        if (z2) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.E.d) - width, abs);
            }
            i2 = this.E.d;
            if (i2 + i <= 0) {
                return i;
            }
        } else if (i > 0) {
            return Math.min((width2 - this.E.d) - width, i);
        } else {
            i2 = this.E.d;
            if (i2 + i >= 0) {
                return i;
            }
        }
        return -i2;
    }

    public final void D(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        if (cVar.j) {
            int i = -1;
            if (cVar.i == -1) {
                if (cVar.f >= 0) {
                    this.F.getEnd();
                    int childCount2 = getChildCount();
                    if (childCount2 != 0) {
                        int i2 = childCount2 - 1;
                        int i3 = this.A.c[getPosition(getChildAt(i2))];
                        if (i3 != -1) {
                            FlexLine flexLine = this.z.get(i3);
                            int i4 = i2;
                            while (true) {
                                if (i4 < 0) {
                                    break;
                                }
                                View childAt = getChildAt(i4);
                                int i5 = cVar.f;
                                if (!(isMainAxisDirectionHorizontal() || !this.x ? this.F.getDecoratedStart(childAt) >= this.F.getEnd() - i5 : this.F.getDecoratedEnd(childAt) <= i5)) {
                                    break;
                                }
                                if (flexLine.o == getPosition(childAt)) {
                                    if (i3 <= 0) {
                                        childCount2 = i4;
                                        break;
                                    }
                                    i3 += cVar.i;
                                    flexLine = this.z.get(i3);
                                    childCount2 = i4;
                                }
                                i4--;
                            }
                            while (i2 >= childCount2) {
                                removeAndRecycleViewAt(i2, recycler);
                                i2--;
                            }
                        }
                    }
                }
            } else if (cVar.f >= 0 && (childCount = getChildCount()) != 0) {
                int i6 = this.A.c[getPosition(getChildAt(0))];
                if (i6 != -1) {
                    FlexLine flexLine2 = this.z.get(i6);
                    int i7 = 0;
                    while (true) {
                        if (i7 >= childCount) {
                            break;
                        }
                        View childAt2 = getChildAt(i7);
                        int i8 = cVar.f;
                        if (!(isMainAxisDirectionHorizontal() || !this.x ? this.F.getDecoratedEnd(childAt2) <= i8 : this.F.getEnd() - this.F.getDecoratedStart(childAt2) <= i8)) {
                            break;
                        }
                        if (flexLine2.p == getPosition(childAt2)) {
                            if (i6 >= this.z.size() - 1) {
                                i = i7;
                                break;
                            }
                            i6 += cVar.i;
                            flexLine2 = this.z.get(i6);
                            i = i7;
                        }
                        i7++;
                    }
                    while (i >= 0) {
                        removeAndRecycleViewAt(i, recycler);
                        i--;
                    }
                }
            }
        }
    }

    public final void E() {
        int i;
        if (isMainAxisDirectionHorizontal()) {
            i = getHeightMode();
        } else {
            i = getWidthMode();
        }
        this.D.b = i == 0 || i == Integer.MIN_VALUE;
    }

    public final void F(int i) {
        if (i < findLastVisibleItemPosition()) {
            int childCount = getChildCount();
            this.A.j(childCount);
            this.A.k(childCount);
            this.A.i(childCount);
            if (i < this.A.c.length) {
                this.Q = i;
                View childAt = getChildAt(0);
                if (childAt != null) {
                    this.I = getPosition(childAt);
                    if (isMainAxisDirectionHorizontal() || !this.x) {
                        this.J = this.F.getDecoratedStart(childAt) - this.F.getStartAfterPadding();
                        return;
                    }
                    this.J = this.F.getEndPadding() + this.F.getDecoratedEnd(childAt);
                }
            }
        }
    }

    public final void G(b bVar, boolean z2, boolean z3) {
        int i;
        if (z3) {
            E();
        } else {
            this.D.b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.x) {
            this.D.a = this.F.getEndAfterPadding() - bVar.c;
        } else {
            this.D.a = bVar.c - getPaddingRight();
        }
        c cVar = this.D;
        cVar.d = bVar.a;
        cVar.h = 1;
        cVar.i = 1;
        cVar.e = bVar.c;
        cVar.f = Integer.MIN_VALUE;
        cVar.c = bVar.b;
        if (z2 && this.z.size() > 1 && (i = bVar.b) >= 0 && i < this.z.size() - 1) {
            c cVar2 = this.D;
            cVar2.c++;
            cVar2.d = this.z.get(bVar.b).getItemCount() + cVar2.d;
        }
    }

    public final void H(b bVar, boolean z2, boolean z3) {
        int i;
        if (z3) {
            E();
        } else {
            this.D.b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.x) {
            this.D.a = bVar.c - this.F.getStartAfterPadding();
        } else {
            this.D.a = (this.P.getWidth() - bVar.c) - this.F.getStartAfterPadding();
        }
        c cVar = this.D;
        cVar.d = bVar.a;
        cVar.h = 1;
        cVar.i = -1;
        cVar.e = bVar.c;
        cVar.f = Integer.MIN_VALUE;
        int i2 = bVar.b;
        cVar.c = i2;
        if (z2 && i2 > 0 && this.z.size() > (i = bVar.b)) {
            c cVar2 = this.D;
            cVar2.c--;
            cVar2.d -= this.z.get(i).getItemCount();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.t == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.P;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.t == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        View view = this.P;
        if (height > (view != null ? view.getHeight() : 0)) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
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
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (isMainAxisDirectionHorizontal()) {
            return new PointF(0.0f, (float) i2);
        }
        return new PointF((float) i2, 0.0f);
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
        View x2 = x(0, getChildCount(), true);
        if (x2 == null) {
            return -1;
        }
        return getPosition(x2);
    }

    public int findFirstVisibleItemPosition() {
        View x2 = x(0, getChildCount(), false);
        if (x2 == null) {
            return -1;
        }
        return getPosition(x2);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View x2 = x(getChildCount() - 1, -1, true);
        if (x2 == null) {
            return -1;
        }
        return getPosition(x2);
    }

    public int findLastVisibleItemPosition() {
        View x2 = x(getChildCount() - 1, -1, false);
        if (x2 == null) {
            return -1;
        }
        return getPosition(x2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // a2.j.b.c.a
    public int getAlignContent() {
        return 5;
    }

    @Override // a2.j.b.c.a
    public int getAlignItems() {
        return this.v;
    }

    @Override // a2.j.b.c.a
    public int getChildHeightMeasureSpec(int i, int i2, int i3) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // a2.j.b.c.a
    public int getChildWidthMeasureSpec(int i, int i2, int i3) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // a2.j.b.c.a
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return rightDecorationWidth + leftDecorationWidth;
    }

    @Override // a2.j.b.c.a
    public int getDecorationLengthMainAxis(View view, int i, int i2) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return bottomDecorationHeight + topDecorationHeight;
    }

    @Override // a2.j.b.c.a
    public int getFlexDirection() {
        return this.s;
    }

    @Override // a2.j.b.c.a
    public View getFlexItemAt(int i) {
        View view = this.N.get(i);
        if (view != null) {
            return view;
        }
        return this.B.getViewForPosition(i);
    }

    @Override // a2.j.b.c.a
    public int getFlexItemCount() {
        return this.C.getItemCount();
    }

    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.z.size());
        int size = this.z.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.z.get(i);
            if (flexLine.getItemCount() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // a2.j.b.c.a
    public List<FlexLine> getFlexLinesInternal() {
        return this.z;
    }

    @Override // a2.j.b.c.a
    public int getFlexWrap() {
        return this.t;
    }

    public int getJustifyContent() {
        return this.u;
    }

    @Override // a2.j.b.c.a
    public int getLargestMainSize() {
        if (this.z.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.z.get(i2).e);
        }
        return i;
    }

    @Override // a2.j.b.c.a
    public int getMaxLine() {
        return this.w;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.M;
    }

    @Override // a2.j.b.c.a
    public View getReorderedFlexItemAt(int i) {
        return getFlexItemAt(i);
    }

    @Override // a2.j.b.c.a
    public int getSumOfCrossSize() {
        int size = this.z.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.z.get(i2).g;
        }
        return i;
    }

    @Override // a2.j.b.c.a
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.s;
        return i == 0 || i == 1;
    }

    public final void n() {
        this.z.clear();
        b.b(this.E);
        this.E.d = 0;
    }

    public final int o(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        r();
        View t2 = t(itemCount);
        View v2 = v(itemCount);
        if (state.getItemCount() == 0 || t2 == null || v2 == null) {
            return 0;
        }
        return Math.min(this.F.getTotalSpace(), this.F.getDecoratedEnd(v2) - this.F.getDecoratedStart(t2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.P = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.M) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        F(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        F(Math.min(i, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        F(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        F(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0294  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r20, androidx.recyclerview.widget.RecyclerView.State r21) {
        /*
        // Method dump skipped, instructions count: 1146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.H = null;
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.Q = -1;
        b.b(this.E);
        this.N.clear();
    }

    @Override // a2.j.b.c.a
    public void onNewFlexItemAdded(View view, int i, int i2, FlexLine flexLine) {
        calculateItemDecorationsForChild(view, S);
        if (isMainAxisDirectionHorizontal()) {
            int rightDecorationWidth = getRightDecorationWidth(view) + getLeftDecorationWidth(view);
            flexLine.e += rightDecorationWidth;
            flexLine.f += rightDecorationWidth;
            return;
        }
        int bottomDecorationHeight = getBottomDecorationHeight(view) + getTopDecorationHeight(view);
        flexLine.e += bottomDecorationHeight;
        flexLine.f += bottomDecorationHeight;
    }

    @Override // a2.j.b.c.a
    public void onNewFlexLineAdded(FlexLine flexLine) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.H = (d) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        d dVar = this.H;
        if (dVar != null) {
            return new d(dVar, (a) null);
        }
        d dVar2 = new d();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            dVar2.a = getPosition(childAt);
            dVar2.b = this.F.getDecoratedStart(childAt) - this.F.getStartAfterPadding();
        } else {
            dVar2.a = -1;
        }
        return dVar2;
    }

    public final int p(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View t2 = t(itemCount);
        View v2 = v(itemCount);
        if (!(state.getItemCount() == 0 || t2 == null || v2 == null)) {
            int position = getPosition(t2);
            int position2 = getPosition(v2);
            int abs = Math.abs(this.F.getDecoratedEnd(v2) - this.F.getDecoratedStart(t2));
            int[] iArr = this.A.c;
            int i = iArr[position];
            if (!(i == 0 || i == -1)) {
                return Math.round((((float) i) * (((float) abs) / ((float) ((iArr[position2] - i) + 1)))) + ((float) (this.F.getStartAfterPadding() - this.F.getDecoratedStart(t2))));
            }
        }
        return 0;
    }

    public final int q(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View t2 = t(itemCount);
        View v2 = v(itemCount);
        if (state.getItemCount() == 0 || t2 == null || v2 == null) {
            return 0;
        }
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((((float) Math.abs(this.F.getDecoratedEnd(v2) - this.F.getDecoratedStart(t2))) / ((float) ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1))) * ((float) state.getItemCount()));
    }

    public final void r() {
        if (this.F == null) {
            if (isMainAxisDirectionHorizontal()) {
                if (this.t == 0) {
                    this.F = OrientationHelper.createHorizontalHelper(this);
                    this.G = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.F = OrientationHelper.createVerticalHelper(this);
                this.G = OrientationHelper.createHorizontalHelper(this);
            } else if (this.t == 0) {
                this.F = OrientationHelper.createVerticalHelper(this);
                this.G = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.F = OrientationHelper.createHorizontalHelper(this);
                this.G = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int s(androidx.recyclerview.widget.RecyclerView.Recycler r32, androidx.recyclerview.widget.RecyclerView.State r33, com.google.android.flexbox.FlexboxLayoutManager.c r34) {
        /*
        // Method dump skipped, instructions count: 1147
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.s(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal() || (this.t == 0 && isMainAxisDirectionHorizontal())) {
            int B2 = B(i, recycler, state);
            this.N.clear();
            return B2;
        }
        int C2 = C(i);
        this.E.d += C2;
        this.G.offsetChildren(-C2);
        return C2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.I = i;
        this.J = Integer.MIN_VALUE;
        d dVar = this.H;
        if (dVar != null) {
            dVar.a = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal() || (this.t == 0 && !isMainAxisDirectionHorizontal())) {
            int B2 = B(i, recycler, state);
            this.N.clear();
            return B2;
        }
        int C2 = C(i);
        this.E.d += C2;
        this.G.offsetChildren(-C2);
        return C2;
    }

    public void setAlignContent(int i) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    public void setAlignItems(int i) {
        int i2 = this.v;
        if (i2 != i) {
            if (i2 == 4 || i == 4) {
                removeAllViews();
                n();
            }
            this.v = i;
            requestLayout();
        }
    }

    public void setFlexDirection(int i) {
        if (this.s != i) {
            removeAllViews();
            this.s = i;
            this.F = null;
            this.G = null;
            n();
            requestLayout();
        }
    }

    @Override // a2.j.b.c.a
    public void setFlexLines(List<FlexLine> list) {
        this.z = list;
    }

    public void setFlexWrap(int i) {
        if (i != 2) {
            int i2 = this.t;
            if (i2 != i) {
                if (i2 == 0 || i == 0) {
                    removeAllViews();
                    n();
                }
                this.t = i;
                this.F = null;
                this.G = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    public void setJustifyContent(int i) {
        if (this.u != i) {
            this.u = i;
            requestLayout();
        }
    }

    public void setMaxLine(int i) {
        if (this.w != i) {
            this.w = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z2) {
        this.M = z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public final View t(int i) {
        int i2;
        View y2 = y(0, getChildCount(), i);
        if (y2 == null || (i2 = this.A.c[getPosition(y2)]) == -1) {
            return null;
        }
        return u(y2, this.z.get(i2));
    }

    public final View u(View view, FlexLine flexLine) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i = flexLine.h;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.x || isMainAxisDirectionHorizontal) {
                    if (this.F.getDecoratedStart(view) <= this.F.getDecoratedStart(childAt)) {
                    }
                } else if (this.F.getDecoratedEnd(view) >= this.F.getDecoratedEnd(childAt)) {
                }
                view = childAt;
            }
        }
        return view;
    }

    @Override // a2.j.b.c.a
    public void updateViewCache(int i, View view) {
        this.N.put(i, view);
    }

    public final View v(int i) {
        View y2 = y(getChildCount() - 1, -1, i);
        if (y2 == null) {
            return null;
        }
        return w(y2, this.z.get(this.A.c[getPosition(y2)]));
    }

    public final View w(View view, FlexLine flexLine) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - flexLine.h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.x || isMainAxisDirectionHorizontal) {
                    if (this.F.getDecoratedEnd(view) >= this.F.getDecoratedEnd(childAt)) {
                    }
                } else if (this.F.getDecoratedStart(view) <= this.F.getDecoratedStart(childAt)) {
                }
                view = childAt;
            }
        }
        return view;
    }

    public final View x(int i, int i2, boolean z2) {
        int i3 = i;
        int i4 = i2 > i3 ? 1 : -1;
        while (i3 != i2) {
            View childAt = getChildAt(i3);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int decoratedLeft = getDecoratedLeft(childAt) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).leftMargin;
            int decoratedTop = getDecoratedTop(childAt) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).topMargin;
            int decoratedRight = getDecoratedRight(childAt) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
            int decoratedBottom = getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            boolean z3 = false;
            boolean z4 = paddingLeft <= decoratedLeft && width >= decoratedRight;
            boolean z5 = decoratedLeft >= width || decoratedRight >= paddingLeft;
            boolean z7 = paddingTop <= decoratedTop && height >= decoratedBottom;
            boolean z8 = decoratedTop >= height || decoratedBottom >= paddingTop;
            if (!z2 ? !(!z5 || !z8) : !(!z4 || !z7)) {
                z3 = true;
            }
            if (z3) {
                return childAt;
            }
            i3 += i4;
        }
        return null;
    }

    public final View y(int i, int i2, int i3) {
        r();
        View view = null;
        if (this.D == null) {
            this.D = new c(null);
        }
        int startAfterPadding = this.F.getStartAfterPadding();
        int endAfterPadding = this.F.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.F.getDecoratedStart(childAt) >= startAfterPadding && this.F.getDecoratedEnd(childAt) <= endAfterPadding) {
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

    public final int z(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int i2;
        int endAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.x) {
            int startAfterPadding = i - this.F.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            i2 = B(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.F.getEndAfterPadding() - i;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            i2 = -B(-endAfterPadding2, recycler, state);
        }
        int i3 = i + i2;
        if (!z2 || (endAfterPadding = this.F.getEndAfterPadding() - i3) <= 0) {
            return i2;
        }
        this.F.offsetChildren(endAfterPadding);
        return endAfterPadding + i2;
    }

    public FlexboxLayoutManager(Context context, int i) {
        this(context, i, 1);
    }

    public FlexboxLayoutManager(Context context, int i, int i2) {
        this.w = -1;
        this.z = new ArrayList();
        this.A = new a2.j.b.c.c(this);
        this.E = new b(null);
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        this.L = Integer.MIN_VALUE;
        this.N = new SparseArray<>();
        this.Q = -1;
        this.R = new c.b();
        setFlexDirection(i);
        setFlexWrap(i2);
        setAlignItems(4);
        setAutoMeasureEnabled(true);
        this.O = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        F(i);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements a2.j.b.c.b {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        public float e = 0.0f;
        public float f = 1.0f;
        public int g = -1;
        public float h = -1.0f;
        public int i;
        public int j;
        public int k = ViewCompat.MEASURED_SIZE_MASK;
        public int l = ViewCompat.MEASURED_SIZE_MASK;
        public boolean m;

        public static class a implements Parcelable.Creator<LayoutParams> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // a2.j.b.c.b
        public int getAlignSelf() {
            return this.g;
        }

        @Override // a2.j.b.c.b
        public float getFlexBasisPercent() {
            return this.h;
        }

        @Override // a2.j.b.c.b
        public float getFlexGrow() {
            return this.e;
        }

        @Override // a2.j.b.c.b
        public float getFlexShrink() {
            return this.f;
        }

        @Override // a2.j.b.c.b
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // a2.j.b.c.b
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // a2.j.b.c.b
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // a2.j.b.c.b
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // a2.j.b.c.b
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // a2.j.b.c.b
        public int getMaxHeight() {
            return this.l;
        }

        @Override // a2.j.b.c.b
        public int getMaxWidth() {
            return this.k;
        }

        @Override // a2.j.b.c.b
        public int getMinHeight() {
            return this.j;
        }

        @Override // a2.j.b.c.b
        public int getMinWidth() {
            return this.i;
        }

        @Override // a2.j.b.c.b
        public int getOrder() {
            return 1;
        }

        @Override // a2.j.b.c.b
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // a2.j.b.c.b
        public boolean isWrapBefore() {
            return this.m;
        }

        public void setAlignSelf(int i2) {
            this.g = i2;
        }

        public void setFlexBasisPercent(float f2) {
            this.h = f2;
        }

        public void setFlexGrow(float f2) {
            this.e = f2;
        }

        public void setFlexShrink(float f2) {
            this.f = f2;
        }

        public void setHeight(int i2) {
            ((ViewGroup.MarginLayoutParams) this).height = i2;
        }

        public void setMaxHeight(int i2) {
            this.l = i2;
        }

        public void setMaxWidth(int i2) {
            this.k = i2;
        }

        @Override // a2.j.b.c.b
        public void setMinHeight(int i2) {
            this.j = i2;
        }

        @Override // a2.j.b.c.b
        public void setMinWidth(int i2) {
            this.i = i2;
        }

        public void setOrder(int i2) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        public void setWidth(int i2) {
            ((ViewGroup.MarginLayoutParams) this).width = i2;
        }

        public void setWrapBefore(boolean z) {
            this.m = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeFloat(this.e);
            parcel.writeFloat(this.f);
            parcel.writeInt(this.g);
            parcel.writeFloat(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
            parcel.writeInt(this.l);
            parcel.writeByte(this.m ? (byte) 1 : 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
            this.e = layoutParams.e;
            this.f = layoutParams.f;
            this.g = layoutParams.g;
            this.h = layoutParams.h;
            this.i = layoutParams.i;
            this.j = layoutParams.j;
            this.k = layoutParams.k;
            this.l = layoutParams.l;
            this.m = layoutParams.m;
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.e = parcel.readFloat();
            this.f = parcel.readFloat();
            this.g = parcel.readInt();
            this.h = parcel.readFloat();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
            this.l = parcel.readInt();
            this.m = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.w = -1;
        this.z = new ArrayList();
        this.A = new a2.j.b.c.c(this);
        this.E = new b(null);
        this.I = -1;
        this.J = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        this.L = Integer.MIN_VALUE;
        this.N = new SparseArray<>();
        this.Q = -1;
        this.R = new c.b();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 != 0) {
            if (i3 == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        setAutoMeasureEnabled(true);
        this.O = context;
    }
}
