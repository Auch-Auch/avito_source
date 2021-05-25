package androidx.recyclerview.widget;

import a2.b.a.a.a;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
public class GridLayoutManager extends LinearLayoutManager {
    public static final int DEFAULT_SPAN_COUNT = -1;
    public boolean I = false;
    public int J = -1;
    public int[] K;
    public View[] L;
    public final SparseIntArray M = new SparseIntArray();
    public final SparseIntArray N = new SparseIntArray();
    public SpanSizeLookup O = new DefaultSpanSizeLookup();
    public final Rect P = new Rect();
    public boolean Q;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }
    }

    public static abstract class SpanSizeLookup {
        public final SparseIntArray a = new SparseIntArray();
        public final SparseIntArray b = new SparseIntArray();
        public boolean c = false;
        public boolean d = false;

        public static int a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        public int b(int i, int i2) {
            if (!this.d) {
                return getSpanGroupIndex(i, i2);
            }
            int i3 = this.b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanGroupIndex = getSpanGroupIndex(i, i2);
            this.b.put(i, spanGroupIndex);
            return spanGroupIndex;
        }

        public int c(int i, int i2) {
            if (!this.c) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.a.put(i, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int a3;
            if (!this.d || (a3 = a(this.b, i)) == -1) {
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                i4 = this.b.get(a3);
                i3 = a3 + 1;
                i5 = getSpanSize(a3) + c(a3, i2);
                if (i5 == i2) {
                    i4++;
                    i5 = 0;
                }
            }
            int spanSize = getSpanSize(i);
            while (i3 < i) {
                int spanSize2 = getSpanSize(i3);
                i5 += spanSize2;
                if (i5 == i2) {
                    i4++;
                    i5 = 0;
                } else if (i5 > i2) {
                    i4++;
                    i5 = spanSize2;
                }
                i3++;
            }
            return i5 + spanSize > i2 ? i4 + 1 : i4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.c
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.a
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r4 = r4 + r3
                goto L_0x0030
            L_0x0020:
                r2 = 0
                r4 = 0
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r3 = r5.getSpanSize(r2)
                int r4 = r4 + r3
                if (r4 != r7) goto L_0x002d
                r4 = 0
                goto L_0x0030
            L_0x002d:
                if (r4 <= r7) goto L_0x0030
                r4 = r3
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r4
                if (r0 > r7) goto L_0x0037
                return r4
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanGroupIndexCache() {
            this.b.clear();
        }

        public void invalidateSpanIndexCache() {
            this.a.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.d;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.c;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.b.clear();
            }
            this.d = z;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.b.clear();
            }
            this.c = z;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2).spanCount);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (position >= 0 && position < i3 && V(recycler, state, position) == 0) {
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

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void F(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.b bVar, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z;
        View c;
        int modeInOther = this.u.getModeInOther();
        boolean z2 = modeInOther != 1073741824;
        int i15 = getChildCount() > 0 ? this.K[this.J] : 0;
        if (z2) {
            Z();
        }
        boolean z3 = bVar.e == 1;
        int i16 = this.J;
        if (!z3) {
            i16 = V(recycler, state, bVar.d) + W(recycler, state, bVar.d);
        }
        int i17 = 0;
        while (i17 < this.J && bVar.b(state) && i16 > 0) {
            int i18 = bVar.d;
            int W = W(recycler, state, i18);
            if (W <= this.J) {
                i16 -= W;
                if (i16 < 0 || (c = bVar.c(recycler)) == null) {
                    break;
                }
                this.L[i17] = c;
                i17++;
            } else {
                throw new IllegalArgumentException(a.j(a.N("Item at position ", i18, " requires ", W, " spans but GridLayoutManager has only "), this.J, " spans."));
            }
        }
        if (i17 == 0) {
            layoutChunkResult.mFinished = true;
            return;
        }
        if (z3) {
            i4 = 0;
            i3 = i17;
            i2 = 0;
            i = 1;
        } else {
            i4 = i17 - 1;
            i3 = -1;
            i2 = 0;
            i = -1;
        }
        while (i4 != i3) {
            View view = this.L[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int W2 = W(recycler, state, getPosition(view));
            layoutParams.f = W2;
            layoutParams.e = i2;
            i2 += W2;
            i4 += i;
        }
        float f = 0.0f;
        int i19 = 0;
        for (int i20 = 0; i20 < i17; i20++) {
            View view2 = this.L[i20];
            if (bVar.k != null) {
                z = false;
                if (z3) {
                    addDisappearingView(view2);
                } else {
                    addDisappearingView(view2, 0);
                }
            } else if (z3) {
                addView(view2);
                z = false;
            } else {
                z = false;
                addView(view2, 0);
            }
            calculateItemDecorationsForChild(view2, this.P);
            X(view2, modeInOther, z);
            int decoratedMeasurement = this.u.getDecoratedMeasurement(view2);
            if (decoratedMeasurement > i19) {
                i19 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (((float) this.u.getDecoratedMeasurementInOther(view2)) * 1.0f) / ((float) ((LayoutParams) view2.getLayoutParams()).f);
            if (decoratedMeasurementInOther > f) {
                f = decoratedMeasurementInOther;
            }
        }
        if (z2) {
            P(Math.max(Math.round(f * ((float) this.J)), i15));
            i19 = 0;
            for (int i21 = 0; i21 < i17; i21++) {
                View view3 = this.L[i21];
                X(view3, 1073741824, true);
                int decoratedMeasurement2 = this.u.getDecoratedMeasurement(view3);
                if (decoratedMeasurement2 > i19) {
                    i19 = decoratedMeasurement2;
                }
            }
        }
        for (int i22 = 0; i22 < i17; i22++) {
            View view4 = this.L[i22];
            if (this.u.getDecoratedMeasurement(view4) != i19) {
                LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
                Rect rect = layoutParams2.b;
                int i23 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                int i24 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                int T = T(layoutParams2.e, layoutParams2.f);
                if (this.s == 1) {
                    i14 = RecyclerView.LayoutManager.getChildMeasureSpec(T, 1073741824, i24, ((ViewGroup.MarginLayoutParams) layoutParams2).width, false);
                    i13 = View.MeasureSpec.makeMeasureSpec(i19 - i23, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i19 - i24, 1073741824);
                    i13 = RecyclerView.LayoutManager.getChildMeasureSpec(T, 1073741824, i23, ((ViewGroup.MarginLayoutParams) layoutParams2).height, false);
                    i14 = makeMeasureSpec;
                }
                Y(view4, i14, i13, true);
            }
        }
        layoutChunkResult.mConsumed = i19;
        if (this.s == 1) {
            if (bVar.f == -1) {
                i8 = bVar.b;
                i7 = i8 - i19;
            } else {
                i7 = bVar.b;
                i8 = i19 + i7;
            }
            i6 = 0;
            i5 = 0;
        } else {
            if (bVar.f == -1) {
                int i25 = bVar.b;
                i6 = i25;
                i5 = i25 - i19;
            } else {
                int i26 = bVar.b;
                i5 = i26;
                i6 = i19 + i26;
            }
            i7 = 0;
            i8 = 0;
        }
        int i27 = 0;
        while (i27 < i17) {
            View view5 = this.L[i27];
            LayoutParams layoutParams3 = (LayoutParams) view5.getLayoutParams();
            if (this.s != 1) {
                i7 = this.K[layoutParams3.e] + getPaddingTop();
                i8 = this.u.getDecoratedMeasurementInOther(view5) + i7;
            } else if (isLayoutRTL()) {
                i6 = getPaddingLeft() + this.K[this.J - layoutParams3.e];
                i5 = i6 - this.u.getDecoratedMeasurementInOther(view5);
            } else {
                int paddingLeft = getPaddingLeft() + this.K[layoutParams3.e];
                i12 = i8;
                i11 = i7;
                i9 = paddingLeft;
                i10 = this.u.getDecoratedMeasurementInOther(view5) + paddingLeft;
                layoutDecoratedWithMargins(view5, i9, i11, i10, i12);
                if (!layoutParams3.isItemRemoved() || layoutParams3.isItemChanged()) {
                    layoutChunkResult.mIgnoreConsumed = true;
                }
                layoutChunkResult.mFocusable |= view5.hasFocusable();
                i27++;
                i8 = i12;
                i7 = i11;
                i6 = i10;
                i5 = i9;
            }
            i12 = i8;
            i11 = i7;
            i10 = i6;
            i9 = i5;
            layoutDecoratedWithMargins(view5, i9, i11, i10, i12);
            if (!layoutParams3.isItemRemoved()) {
            }
            layoutChunkResult.mIgnoreConsumed = true;
            layoutChunkResult.mFocusable |= view5.hasFocusable();
            i27++;
            i8 = i12;
            i7 = i11;
            i6 = i10;
            i5 = i9;
        }
        Arrays.fill(this.L, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void G(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.a aVar, int i) {
        Z();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            boolean z = i == 1;
            int V = V(recycler, state, aVar.b);
            if (z) {
                while (V > 0) {
                    int i2 = aVar.b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    aVar.b = i3;
                    V = V(recycler, state, i3);
                }
            } else {
                int itemCount = state.getItemCount() - 1;
                int i4 = aVar.b;
                while (i4 < itemCount) {
                    int i5 = i4 + 1;
                    int V2 = V(recycler, state, i5);
                    if (V2 <= V) {
                        break;
                    }
                    i4 = i5;
                    V = V2;
                }
                aVar.b = i4;
            }
        }
        S();
    }

    public final void P(int i) {
        int i2;
        int[] iArr = this.K;
        int i3 = this.J;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i3 + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.K = iArr;
    }

    public final int Q(RecyclerView.State state) {
        int i;
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            s();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View w = w(!isSmoothScrollbarEnabled, true);
            View v = v(!isSmoothScrollbarEnabled, true);
            if (!(w == null || v == null)) {
                int b = this.O.b(getPosition(w), this.J);
                int b2 = this.O.b(getPosition(v), this.J);
                int min = Math.min(b, b2);
                int max = Math.max(b, b2);
                int b3 = this.O.b(state.getItemCount() - 1, this.J) + 1;
                if (this.x) {
                    i = Math.max(0, (b3 - max) - 1);
                } else {
                    i = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i;
                }
                return Math.round((((float) i) * (((float) Math.abs(this.u.getDecoratedEnd(v) - this.u.getDecoratedStart(w))) / ((float) ((this.O.b(getPosition(v), this.J) - this.O.b(getPosition(w), this.J)) + 1)))) + ((float) (this.u.getStartAfterPadding() - this.u.getDecoratedStart(w))));
            }
        }
        return 0;
    }

    public final int R(RecyclerView.State state) {
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            s();
            View w = w(!isSmoothScrollbarEnabled(), true);
            View v = v(!isSmoothScrollbarEnabled(), true);
            if (!(w == null || v == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.O.b(state.getItemCount() - 1, this.J) + 1;
                }
                int decoratedEnd = this.u.getDecoratedEnd(v) - this.u.getDecoratedStart(w);
                int b = this.O.b(getPosition(w), this.J);
                return (int) ((((float) decoratedEnd) / ((float) ((this.O.b(getPosition(v), this.J) - b) + 1))) * ((float) (this.O.b(state.getItemCount() - 1, this.J) + 1)));
            }
        }
        return 0;
    }

    public final void S() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    public int T(int i, int i2) {
        if (this.s != 1 || !isLayoutRTL()) {
            int[] iArr = this.K;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.K;
        int i3 = this.J;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int U(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.O.b(i, this.J);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return this.O.b(convertPreLayoutPositionToPostLayout, this.J);
    }

    public final int V(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.O.c(i, this.J);
        }
        int i2 = this.N.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return this.O.c(convertPreLayoutPositionToPostLayout, this.J);
    }

    public final int W(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.O.getSpanSize(i);
        }
        int i2 = this.M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 1;
        }
        return this.O.getSpanSize(convertPreLayoutPositionToPostLayout);
    }

    public final void X(View view, int i, boolean z) {
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int T = T(layoutParams.e, layoutParams.f);
        if (this.s == 1) {
            i2 = RecyclerView.LayoutManager.getChildMeasureSpec(T, i, i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i3 = RecyclerView.LayoutManager.getChildMeasureSpec(this.u.getTotalSpace(), getHeightMode(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(T, i, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.u.getTotalSpace(), getWidthMode(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i3 = childMeasureSpec;
            i2 = childMeasureSpec2;
        }
        Y(view, i2, i3, z);
    }

    public final void Y(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            z2 = m(view, i, i2, layoutParams);
        } else {
            z2 = k(view, i, i2, layoutParams);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    public final void Z() {
        int i;
        int i2;
        if (getOrientation() == 1) {
            i2 = getWidth() - getPaddingRight();
            i = getPaddingLeft();
        } else {
            i2 = getHeight() - getPaddingBottom();
            i = getPaddingTop();
        }
        P(i2 - i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (this.Q) {
            return Q(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (this.Q) {
            return R(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (this.Q) {
            return Q(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.Q) {
            return R(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.s == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.s == 1) {
            return this.J;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return U(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.s == 0) {
            return this.J;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return U(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getSpanCount() {
        return this.J;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.O;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.Q;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void n(RecyclerView.State state, LinearLayoutManager.b bVar, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.J;
        for (int i2 = 0; i2 < this.J && bVar.b(state) && i > 0; i2++) {
            int i3 = bVar.d;
            layoutPrefetchRegistry.addPosition(i3, Math.max(0, bVar.g));
            i -= this.O.getSpanSize(i3);
            bVar.d += bVar.e;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == (r2 > r15)) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
        // Method dump skipped, instructions count: 337
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            d(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int U = U(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.s == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), U, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(U, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.O.invalidateSpanIndexCache();
        this.O.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.O.invalidateSpanIndexCache();
        this.O.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.O.invalidateSpanIndexCache();
        this.O.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.O.invalidateSpanIndexCache();
        this.O.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.O.invalidateSpanIndexCache();
        this.O.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int viewLayoutPosition = layoutParams.getViewLayoutPosition();
                this.M.put(viewLayoutPosition, layoutParams.getSpanSize());
                this.N.put(viewLayoutPosition, layoutParams.getSpanIndex());
            }
        }
        super.onLayoutChildren(recycler, state);
        this.M.clear();
        this.N.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.I = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Z();
        S();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Z();
        S();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.K == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.s == 1) {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.K;
            i3 = RecyclerView.LayoutManager.chooseSize(i, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            i3 = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.K;
            i4 = RecyclerView.LayoutManager.chooseSize(i2, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public void setSpanCount(int i) {
        if (i != this.J) {
            this.I = true;
            if (i >= 1) {
                this.J = i;
                this.O.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException(a.M2("Span count should be at least 1. Provided ", i));
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.O = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z) {
        this.Q = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.D == null && !this.I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        public int e = -1;
        public int f = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getSpanIndex() {
            return this.e;
        }

        public int getSpanSize() {
            return this.f;
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

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        setSpanCount(i);
    }
}
