package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import l6.v.a.l;
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public boolean A = false;
    public BitSet B;
    public int C = -1;
    public int D = Integer.MIN_VALUE;
    public c E = new c();
    public int F = 2;
    public boolean G;
    public boolean H;
    public SavedState I;
    public int J;
    public final Rect K = new Rect();
    public final b L = new b();
    public boolean M = false;
    public boolean N = true;
    public int[] O;
    public final Runnable P = new a();
    public int s = -1;
    public d[] t;
    @NonNull
    public OrientationHelper u;
    @NonNull
    public OrientationHelper v;
    public int w;
    public int x;
    @NonNull
    public final l y;
    public boolean z = false;

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        public d e;
        public boolean f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int getSpanIndex() {
            d dVar = this.e;
            if (dVar == null) {
                return -1;
            }
            return dVar.e;
        }

        public boolean isFullSpan() {
            return this.f;
        }

        public void setFullSpan(boolean z) {
            this.f = z;
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

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int a;
        public int b;
        public int c;
        public int[] d;
        public int e;
        public int[] f;
        public List<c.a> g;
        public boolean h;
        public boolean i;
        public boolean j;

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

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }

        public SavedState(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            int readInt = parcel.readInt();
            this.c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1 ? true : z;
            this.g = parcel.readArrayList(c.a.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.a = savedState.a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.o();
        }
    }

    public class b {
        public int a;
        public int b;
        public boolean c;
        public boolean d;
        public boolean e;
        public int[] f;

        public b() {
            b();
        }

        public void a() {
            int i;
            if (this.c) {
                i = StaggeredGridLayoutManager.this.u.getEndAfterPadding();
            } else {
                i = StaggeredGridLayoutManager.this.u.getStartAfterPadding();
            }
            this.b = i;
        }

        public void b() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public class d {
        public ArrayList<View> a = new ArrayList<>();
        public int b = Integer.MIN_VALUE;
        public int c = Integer.MIN_VALUE;
        public int d = 0;
        public final int e;

        public d(int i) {
            this.e = i;
        }

        public void a(View view) {
            LayoutParams l = l(view);
            l.e = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d = StaggeredGridLayoutManager.this.u.getDecoratedMeasurement(view) + this.d;
            }
        }

        public void b() {
            c.a f2;
            ArrayList<View> arrayList = this.a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams l = l(view);
            this.c = StaggeredGridLayoutManager.this.u.getDecoratedEnd(view);
            if (l.f && (f2 = StaggeredGridLayoutManager.this.E.f(l.getViewLayoutPosition())) != null && f2.b == 1) {
                int i = this.c;
                int i2 = this.e;
                int[] iArr = f2.c;
                this.c = i + (iArr == null ? 0 : iArr[i2]);
            }
        }

        public void c() {
            c.a f2;
            int i = 0;
            View view = this.a.get(0);
            LayoutParams l = l(view);
            this.b = StaggeredGridLayoutManager.this.u.getDecoratedStart(view);
            if (l.f && (f2 = StaggeredGridLayoutManager.this.E.f(l.getViewLayoutPosition())) != null && f2.b == -1) {
                int i2 = this.b;
                int i3 = this.e;
                int[] iArr = f2.c;
                if (iArr != null) {
                    i = iArr[i3];
                }
                this.b = i2 - i;
            }
        }

        public void d() {
            this.a.clear();
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
            this.d = 0;
        }

        public int e() {
            if (StaggeredGridLayoutManager.this.z) {
                return h(this.a.size() - 1, -1, true);
            }
            return h(0, this.a.size(), true);
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.z) {
                return h(0, this.a.size(), true);
            }
            return h(this.a.size() - 1, -1, true);
        }

        public int g(int i, int i2, boolean z, boolean z2, boolean z3) {
            int startAfterPadding = StaggeredGridLayoutManager.this.u.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.u.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.a.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.u.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.u.getDecoratedEnd(view);
                boolean z4 = false;
                boolean z5 = !z3 ? decoratedStart < endAfterPadding : decoratedStart <= endAfterPadding;
                if (!z3 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        public int h(int i, int i2, boolean z) {
            return g(i, i2, false, false, z);
        }

        public int i(int i, int i2, boolean z) {
            return g(i, i2, z, true, false);
        }

        public int j(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            b();
            return this.c;
        }

        public View k(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    View view2 = this.a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.getPosition(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.getPosition(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.getPosition(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.getPosition(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        public LayoutParams l(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        public int m(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            c();
            return this.b;
        }

        public void n() {
            int size = this.a.size();
            View remove = this.a.remove(size - 1);
            LayoutParams l = l(remove);
            l.e = null;
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d -= StaggeredGridLayoutManager.this.u.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        public void o() {
            View remove = this.a.remove(0);
            LayoutParams l = l(remove);
            l.e = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d -= StaggeredGridLayoutManager.this.u.getDecoratedMeasurement(remove);
            }
            this.b = Integer.MIN_VALUE;
        }

        public void p(View view) {
            LayoutParams l = l(view);
            l.e = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d = StaggeredGridLayoutManager.this.u.getDecoratedMeasurement(view) + this.d;
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.y = new l();
        this.u = OrientationHelper.createOrientationHelper(this, this.w);
        this.v = OrientationHelper.createOrientationHelper(this, 1 - this.w);
    }

    public final int A(int i) {
        int m = this.t[0].m(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int m2 = this.t[i2].m(i);
            if (m2 < m) {
                m = m2;
            }
        }
        return m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void B(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L_0x0009
            int r0 = r6.y()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.x()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r4 = r6.E
            r4.g(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r6.E
            r9.i(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r7 = r6.E
            r7.h(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r6.E
            r9.i(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r6.E
            r9.h(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.A
            if (r7 == 0) goto L_0x004d
            int r7 = r6.x()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.y()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.requestLayout()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.B(int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c1, code lost:
        if (r11 == r12) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        if (r11 == r12) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        r11 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0099 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View C() {
        /*
        // Method dump skipped, instructions count: 251
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.C():android.view.View");
    }

    public final void D(View view, int i, int i2, boolean z2) {
        boolean z3;
        calculateItemDecorationsForChild(view, this.K);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.K;
        int Q = Q(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.K;
        int Q2 = Q(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z2) {
            z3 = m(view, Q, Q2, layoutParams);
        } else {
            z3 = k(view, Q, Q2, layoutParams);
        }
        if (z3) {
            view.measure(Q, Q2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:231:0x041b, code lost:
        if (o() != false) goto L_0x041f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(androidx.recyclerview.widget.RecyclerView.Recycler r12, androidx.recyclerview.widget.RecyclerView.State r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 1087
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.E(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    public final boolean F(int i) {
        if (this.w == 0) {
            if ((i == -1) != this.A) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.A) == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    public void G(int i, RecyclerView.State state) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = y();
            i2 = 1;
        } else {
            i3 = x();
            i2 = -1;
        }
        this.y.a = true;
        O(i3, state);
        M(i2);
        l lVar = this.y;
        lVar.c = i3 + lVar.d;
        lVar.b = Math.abs(i);
    }

    public final void H(RecyclerView.Recycler recycler, l lVar) {
        int i;
        int i2;
        if (lVar.a && !lVar.i) {
            if (lVar.b != 0) {
                int i3 = 1;
                if (lVar.e == -1) {
                    int i4 = lVar.f;
                    int m = this.t[0].m(i4);
                    while (i3 < this.s) {
                        int m2 = this.t[i3].m(i4);
                        if (m2 > m) {
                            m = m2;
                        }
                        i3++;
                    }
                    int i5 = i4 - m;
                    if (i5 < 0) {
                        i2 = lVar.g;
                    } else {
                        i2 = lVar.g - Math.min(i5, lVar.b);
                    }
                    I(recycler, i2);
                    return;
                }
                int i6 = lVar.g;
                int j = this.t[0].j(i6);
                while (i3 < this.s) {
                    int j2 = this.t[i3].j(i6);
                    if (j2 < j) {
                        j = j2;
                    }
                    i3++;
                }
                int i7 = j - lVar.g;
                if (i7 < 0) {
                    i = lVar.f;
                } else {
                    i = Math.min(i7, lVar.b) + lVar.f;
                }
                J(recycler, i);
            } else if (lVar.e == -1) {
                I(recycler, lVar.g);
            } else {
                J(recycler, lVar.f);
            }
        }
    }

    public final void I(RecyclerView.Recycler recycler, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.u.getDecoratedStart(childAt) >= i && this.u.getTransformedStartWithDecoration(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f) {
                    for (int i2 = 0; i2 < this.s; i2++) {
                        if (this.t[i2].a.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.s; i3++) {
                        this.t[i3].n();
                    }
                } else if (layoutParams.e.a.size() != 1) {
                    layoutParams.e.n();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    public final void J(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.u.getDecoratedEnd(childAt) <= i && this.u.getTransformedEndWithDecoration(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f) {
                    for (int i2 = 0; i2 < this.s; i2++) {
                        if (this.t[i2].a.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.s; i3++) {
                        this.t[i3].o();
                    }
                } else if (layoutParams.e.a.size() != 1) {
                    layoutParams.e.o();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    public final void K() {
        if (this.w == 1 || !isLayoutRTL()) {
            this.A = this.z;
        } else {
            this.A = !this.z;
        }
    }

    public int L(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        G(i, state);
        int s2 = s(recycler, this.y, state);
        if (this.y.b >= s2) {
            i = i < 0 ? -s2 : s2;
        }
        this.u.offsetChildren(-i);
        this.G = this.A;
        l lVar = this.y;
        lVar.b = 0;
        H(recycler, lVar);
        return i;
    }

    public final void M(int i) {
        l lVar = this.y;
        lVar.e = i;
        int i2 = 1;
        if (this.A != (i == -1)) {
            i2 = -1;
        }
        lVar.d = i2;
    }

    public final void N(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].a.isEmpty()) {
                P(this.t[i3], i, i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void O(int r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            r4 = this;
            l6.v.a.l r0 = r4.y
            r1 = 0
            r0.b = r1
            r0.c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r6 = r6.getTargetScrollPosition()
            r0 = -1
            if (r6 == r0) goto L_0x002e
            boolean r0 = r4.A
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0025
            androidx.recyclerview.widget.OrientationHelper r5 = r4.u
            int r5 = r5.getTotalSpace()
            goto L_0x002f
        L_0x0025:
            androidx.recyclerview.widget.OrientationHelper r5 = r4.u
            int r5 = r5.getTotalSpace()
            r6 = r5
            r5 = 0
            goto L_0x0030
        L_0x002e:
            r5 = 0
        L_0x002f:
            r6 = 0
        L_0x0030:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L_0x004d
            l6.v.a.l r0 = r4.y
            androidx.recyclerview.widget.OrientationHelper r3 = r4.u
            int r3 = r3.getStartAfterPadding()
            int r3 = r3 - r6
            r0.f = r3
            l6.v.a.l r6 = r4.y
            androidx.recyclerview.widget.OrientationHelper r0 = r4.u
            int r0 = r0.getEndAfterPadding()
            int r0 = r0 + r5
            r6.g = r0
            goto L_0x005d
        L_0x004d:
            l6.v.a.l r0 = r4.y
            androidx.recyclerview.widget.OrientationHelper r3 = r4.u
            int r3 = r3.getEnd()
            int r3 = r3 + r5
            r0.g = r3
            l6.v.a.l r5 = r4.y
            int r6 = -r6
            r5.f = r6
        L_0x005d:
            l6.v.a.l r5 = r4.y
            r5.h = r1
            r5.a = r2
            androidx.recyclerview.widget.OrientationHelper r6 = r4.u
            int r6 = r6.getMode()
            if (r6 != 0) goto L_0x0074
            androidx.recyclerview.widget.OrientationHelper r6 = r4.u
            int r6 = r6.getEnd()
            if (r6 != 0) goto L_0x0074
            r1 = 1
        L_0x0074:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.O(int, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    public final void P(d dVar, int i, int i2) {
        int i3 = dVar.d;
        if (i == -1) {
            int i4 = dVar.b;
            if (i4 == Integer.MIN_VALUE) {
                dVar.c();
                i4 = dVar.b;
            }
            if (i4 + i3 <= i2) {
                this.B.set(dVar.e, false);
                return;
            }
            return;
        }
        int i5 = dVar.c;
        if (i5 == Integer.MIN_VALUE) {
            dVar.b();
            i5 = dVar.c;
        }
        if (i5 - i3 >= i2) {
            this.B.set(dVar.e, false);
        }
    }

    public final int Q(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.I == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3;
        int i4;
        if (this.w != 0) {
            i = i2;
        }
        if (!(getChildCount() == 0 || i == 0)) {
            G(i, state);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.s) {
                this.O = new int[this.s];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.s; i6++) {
                l lVar = this.y;
                if (lVar.d == -1) {
                    i4 = lVar.f;
                    i3 = this.t[i6].m(i4);
                } else {
                    i4 = this.t[i6].j(lVar.g);
                    i3 = this.y.g;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.O[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.O, 0, i5);
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = this.y.c;
                if (i9 >= 0 && i9 < state.getItemCount()) {
                    layoutPrefetchRegistry.addPosition(this.y.c, this.O[i8]);
                    l lVar2 = this.y;
                    lVar2.c += lVar2.d;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return p(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return q(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return r(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        int n = n(i);
        PointF pointF = new PointF();
        if (n == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = (float) n;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) n;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return p(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return q(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return r(state);
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        int i;
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            StringBuilder L2 = a2.b.a.a.a.L("Provided int[]'s size must be more than or equal to span count. Expected:");
            L2.append(this.s);
            L2.append(", array size:");
            L2.append(iArr.length);
            throw new IllegalArgumentException(L2.toString());
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            d dVar = this.t[i2];
            if (StaggeredGridLayoutManager.this.z) {
                i = dVar.i(dVar.a.size() - 1, -1, true);
            } else {
                i = dVar.i(0, dVar.a.size(), true);
            }
            iArr[i2] = i;
        }
        return iArr;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        int i;
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            StringBuilder L2 = a2.b.a.a.a.L("Provided int[]'s size must be more than or equal to span count. Expected:");
            L2.append(this.s);
            L2.append(", array size:");
            L2.append(iArr.length);
            throw new IllegalArgumentException(L2.toString());
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            d dVar = this.t[i2];
            if (StaggeredGridLayoutManager.this.z) {
                i = dVar.i(dVar.a.size() - 1, -1, false);
            } else {
                i = dVar.i(0, dVar.a.size(), false);
            }
            iArr[i2] = i;
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        int i;
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            StringBuilder L2 = a2.b.a.a.a.L("Provided int[]'s size must be more than or equal to span count. Expected:");
            L2.append(this.s);
            L2.append(", array size:");
            L2.append(iArr.length);
            throw new IllegalArgumentException(L2.toString());
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            d dVar = this.t[i2];
            if (StaggeredGridLayoutManager.this.z) {
                i = dVar.i(0, dVar.a.size(), true);
            } else {
                i = dVar.i(dVar.a.size() - 1, -1, true);
            }
            iArr[i2] = i;
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        int i;
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            StringBuilder L2 = a2.b.a.a.a.L("Provided int[]'s size must be more than or equal to span count. Expected:");
            L2.append(this.s);
            L2.append(", array size:");
            L2.append(iArr.length);
            throw new IllegalArgumentException(L2.toString());
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            d dVar = this.t[i2];
            if (StaggeredGridLayoutManager.this.z) {
                i = dVar.i(0, dVar.a.size(), false);
            } else {
                i = dVar.i(dVar.a.size() - 1, -1, false);
            }
            iArr[i2] = i;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.w == 0) {
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
        if (this.w == 1) {
            return this.s;
        }
        return super.getColumnCountForAccessibility(recycler, state);
    }

    public int getGapStrategy() {
        return this.F;
    }

    public int getOrientation() {
        return this.w;
    }

    public boolean getReverseLayout() {
        return this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.w == 0) {
            return this.s;
        }
        return super.getRowCountForAccessibility(recycler, state);
    }

    public int getSpanCount() {
        return this.s;
    }

    public void invalidateSpanAssignments() {
        this.E.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return this.F != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public final int n(int i) {
        if (getChildCount() != 0) {
            if ((i < x()) != this.A) {
                return -1;
            }
            return 1;
        } else if (this.A) {
            return 1;
        } else {
            return -1;
        }
    }

    public boolean o() {
        int i;
        int i2;
        if (getChildCount() == 0 || this.F == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.A) {
            i2 = y();
            i = x();
        } else {
            i2 = x();
            i = y();
        }
        if (i2 == 0 && C() != null) {
            this.E.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.M) {
            return false;
        } else {
            int i3 = this.A ? -1 : 1;
            int i4 = i + 1;
            c.a e = this.E.e(i2, i4, i3, true);
            if (e == null) {
                this.M = false;
                this.E.d(i4);
                return false;
            }
            c.a e2 = this.E.e(i2, e.a, i3 * -1, true);
            if (e2 == null) {
                this.E.d(e.a);
            } else {
                this.E.d(e2.a + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            d dVar = this.t[i2];
            int i3 = dVar.b;
            if (i3 != Integer.MIN_VALUE) {
                dVar.b = i3 + i;
            }
            int i4 = dVar.c;
            if (i4 != Integer.MIN_VALUE) {
                dVar.c = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            d dVar = this.t[i2];
            int i3 = dVar.b;
            if (i3 != Integer.MIN_VALUE) {
                dVar.b = i3 + i;
            }
            int i4 = dVar.c;
            if (i4 != Integer.MIN_VALUE) {
                dVar.c = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].d();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
        if (r9.w == 1) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
        if (r9.w == 0) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004e, code lost:
        if (isLayoutRTL() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005a, code lost:
        if (isLayoutRTL() == false) goto L_0x003e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0060  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r10, int r11, androidx.recyclerview.widget.RecyclerView.Recycler r12, androidx.recyclerview.widget.RecyclerView.State r13) {
        /*
        // Method dump skipped, instructions count: 336
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View u2 = u(false);
            View t2 = t(false);
            if (u2 != null && t2 != null) {
                int position = getPosition(u2);
                int position2 = getPosition(t2);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            d(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.w == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.f ? this.s : 1, -1, -1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, layoutParams2.getSpanIndex(), layoutParams2.f ? this.s : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        B(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.E.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        B(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        B(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        B(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        E(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.I = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int i;
        View view;
        int i2;
        int i3;
        int[] iArr;
        SavedState savedState = this.I;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.h = this.z;
        savedState2.i = this.G;
        savedState2.j = this.H;
        c cVar = this.E;
        if (cVar == null || (iArr = cVar.a) == null) {
            savedState2.e = 0;
        } else {
            savedState2.f = iArr;
            savedState2.e = iArr.length;
            savedState2.g = cVar.b;
        }
        int i4 = -1;
        if (getChildCount() > 0) {
            if (this.G) {
                i = y();
            } else {
                i = x();
            }
            savedState2.a = i;
            if (this.A) {
                view = t(true);
            } else {
                view = u(true);
            }
            if (view != null) {
                i4 = getPosition(view);
            }
            savedState2.b = i4;
            int i5 = this.s;
            savedState2.c = i5;
            savedState2.d = new int[i5];
            for (int i6 = 0; i6 < this.s; i6++) {
                if (this.G) {
                    i2 = this.t[i6].j(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.u.getEndAfterPadding();
                    } else {
                        savedState2.d[i6] = i2;
                    }
                } else {
                    i2 = this.t[i6].m(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.u.getStartAfterPadding();
                    } else {
                        savedState2.d[i6] = i2;
                    }
                }
                i2 -= i3;
                savedState2.d[i6] = i2;
            }
        } else {
            savedState2.a = -1;
            savedState2.b = -1;
            savedState2.c = 0;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            o();
        }
    }

    public final int p(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return AppCompatDelegateImpl.i.L(state, this.u, u(!this.N), t(!this.N), this, this.N);
    }

    public final int q(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return AppCompatDelegateImpl.i.M(state, this.u, u(!this.N), t(!this.N), this, this.N, this.A);
    }

    public final int r(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return AppCompatDelegateImpl.i.N(state, this.u, u(!this.N), t(!this.N), this, this.N);
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x036b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int s(androidx.recyclerview.widget.RecyclerView.Recycler r19, l6.v.a.l r20, androidx.recyclerview.widget.RecyclerView.State r21) {
        /*
        // Method dump skipped, instructions count: 953
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.s(androidx.recyclerview.widget.RecyclerView$Recycler, l6.v.a.l, androidx.recyclerview.widget.RecyclerView$State):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return L(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.a == i)) {
            savedState.d = null;
            savedState.c = 0;
            savedState.a = -1;
            savedState.b = -1;
        }
        this.C = i;
        this.D = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        SavedState savedState = this.I;
        if (savedState != null) {
            savedState.d = null;
            savedState.c = 0;
            savedState.a = -1;
            savedState.b = -1;
        }
        this.C = i;
        this.D = i2;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return L(i, recycler, state);
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.F) {
            if (i == 0 || i == 2) {
                this.F = i;
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.w == 1) {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            i3 = RecyclerView.LayoutManager.chooseSize(i, (this.x * this.s) + paddingRight, getMinimumWidth());
        } else {
            i3 = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            i4 = RecyclerView.LayoutManager.chooseSize(i2, (this.x * this.s) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll(null);
            if (i != this.w) {
                this.w = i;
                OrientationHelper orientationHelper = this.u;
                this.u = this.v;
                this.v = orientationHelper;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z2) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.h == z2)) {
            savedState.h = z2;
        }
        this.z = z2;
        requestLayout();
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.s) {
            invalidateSpanAssignments();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new d[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new d(i2);
            }
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
        return this.I == null;
    }

    public View t(boolean z2) {
        int startAfterPadding = this.u.getStartAfterPadding();
        int endAfterPadding = this.u.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.u.getDecoratedStart(childAt);
            int decoratedEnd = this.u.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z2) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View u(boolean z2) {
        int startAfterPadding = this.u.getStartAfterPadding();
        int endAfterPadding = this.u.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.u.getDecoratedStart(childAt);
            if (this.u.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z2) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void v(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int endAfterPadding;
        int z3 = z(Integer.MIN_VALUE);
        if (z3 != Integer.MIN_VALUE && (endAfterPadding = this.u.getEndAfterPadding() - z3) > 0) {
            int i = endAfterPadding - (-L(-endAfterPadding, recycler, state));
            if (z2 && i > 0) {
                this.u.offsetChildren(i);
            }
        }
    }

    public final void w(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int startAfterPadding;
        int A2 = A(Integer.MAX_VALUE);
        if (A2 != Integer.MAX_VALUE && (startAfterPadding = A2 - this.u.getStartAfterPadding()) > 0) {
            int L2 = startAfterPadding - L(startAfterPadding, recycler, state);
            if (z2 && L2 > 0) {
                this.u.offsetChildren(-L2);
            }
        }
    }

    public int x() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int y() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int z(int i) {
        int j = this.t[0].j(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int j2 = this.t[i2].j(i);
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class c {
        public int[] a;
        public List<a> b;

        public void a(a aVar) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.b.get(i);
                if (aVar2.a == aVar.a) {
                    this.b.remove(i);
                }
                if (aVar2.a >= aVar.a) {
                    this.b.add(i, aVar);
                    return;
                }
            }
            this.b.add(aVar);
        }

        public void b() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        public void c(int i) {
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i, 10) + 1)];
                this.a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int length = iArr.length;
                while (length <= i) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i) {
            List<a> list = this.b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.b.get(size).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return g(i);
        }

        public a e(int i, int i2, int i3, boolean z) {
            List<a> list = this.b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.b.get(i4);
                int i5 = aVar.a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.b == i3 || (z && aVar.d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i) {
            List<a> list = this.b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                if (aVar.a == i) {
                    return aVar;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int g(int r5) {
            /*
                r4 = this;
                int[] r0 = r4.a
                r1 = -1
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                int r0 = r0.length
                if (r5 < r0) goto L_0x000a
                return r1
            L_0x000a:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a> r0 = r4.b
                if (r0 != 0) goto L_0x0010
            L_0x000e:
                r0 = -1
                goto L_0x0046
            L_0x0010:
                androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a r0 = r4.f(r5)
                if (r0 == 0) goto L_0x001b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a> r2 = r4.b
                r2.remove(r0)
            L_0x001b:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a> r0 = r4.b
                int r0 = r0.size()
                r2 = 0
            L_0x0022:
                if (r2 >= r0) goto L_0x0034
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a> r3 = r4.b
                java.lang.Object r3 = r3.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c.a) r3
                int r3 = r3.a
                if (r3 < r5) goto L_0x0031
                goto L_0x0035
            L_0x0031:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0034:
                r2 = -1
            L_0x0035:
                if (r2 == r1) goto L_0x000e
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a> r0 = r4.b
                java.lang.Object r0 = r0.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c.a) r0
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a> r3 = r4.b
                r3.remove(r2)
                int r0 = r0.a
            L_0x0046:
                if (r0 != r1) goto L_0x0052
                int[] r0 = r4.a
                int r2 = r0.length
                java.util.Arrays.fill(r0, r5, r2, r1)
                int[] r5 = r4.a
                int r5 = r5.length
                return r5
            L_0x0052:
                int[] r2 = r4.a
                int r0 = r0 + 1
                java.util.Arrays.fill(r2, r5, r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c.g(int):int");
        }

        public void h(int i, int i2) {
            int[] iArr = this.a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                c(i3);
                int[] iArr2 = this.a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.a, i, i3, -1);
                List<a> list = this.b;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        a aVar = this.b.get(size);
                        int i4 = aVar.a;
                        if (i4 >= i) {
                            aVar.a = i4 + i2;
                        }
                    }
                }
            }
        }

        public void i(int i, int i2) {
            int[] iArr = this.a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                c(i3);
                int[] iArr2 = this.a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                List<a> list = this.b;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        a aVar = this.b.get(size);
                        int i4 = aVar.a;
                        if (i4 >= i) {
                            if (i4 < i3) {
                                this.b.remove(size);
                            } else {
                                aVar.a = i4 - i2;
                            }
                        }
                    }
                }
            }
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0122a();
            public int a;
            public int b;
            public int[] c;
            public boolean d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a$a  reason: collision with other inner class name */
            public static class C0122a implements Parcelable.Creator<a> {
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public a[] newArray(int i) {
                    return new a[i];
                }
            }

            public a(Parcel parcel) {
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                this.d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("FullSpanItem{mPosition=");
                L.append(this.a);
                L.append(", mGapDir=");
                L.append(this.b);
                L.append(", mHasUnwantedGapAfter=");
                L.append(this.d);
                L.append(", mGapPerSpan=");
                L.append(Arrays.toString(this.c));
                L.append('}');
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d ? 1 : 0);
                int[] iArr = this.c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.c);
            }

            public a() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.w = i2;
        setSpanCount(i);
        this.y = new l();
        this.u = OrientationHelper.createOrientationHelper(this, this.w);
        this.v = OrientationHelper.createOrientationHelper(this, 1 - this.w);
    }
}
