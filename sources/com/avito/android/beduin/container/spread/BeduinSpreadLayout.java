package com.avito.android.beduin.container.spread;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\u0004¢\u0006\u0004\b@\u0010AJ7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJM\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010 JK\u0010\b\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010!R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010#R6\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00108\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010#\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u0014R6\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00108\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\b\u0010#\u001a\u0004\b*\u0010'\"\u0004\b+\u0010\u0014R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010#R\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006B"}, d2 = {"Lcom/avito/android/beduin/container/spread/BeduinSpreadLayout;", "Landroid/view/ViewGroup;", "", "changed", "", "l", "t", "r", AuthSource.BOOKING_ORDER, "", "onLayout", "(ZIIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "Lcom/avito/android/beduin/container/spread/BeduinSpreadLayout$a;", "children", "d", "(Ljava/util/List;)V", "maxHeight", "e", "(III)V", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "f", "(II)Z", "Landroid/view/View;", "Lkotlin/Pair;", "range", ViewHierarchyConstants.DIMENSION_LEFT_KEY, AuthSource.SEND_ABUSE, "(Ljava/util/List;ILkotlin/Pair;Z)Lkotlin/Pair;", "(Ljava/util/List;ILkotlin/Pair;ZI)I", "", "Ljava/util/List;", "placementsRight", "value", "getLeftChildren", "()Ljava/util/List;", "setLeftChildren", "leftChildren", "getRightChildren", "setRightChildren", "rightChildren", "I", "getInterItemSpacingPx", "()I", "setInterItemSpacingPx", "(I)V", "interItemSpacingPx", "placementsLeft", "c", "Z", "getLeftPriority", "()Z", "setLeftPriority", "(Z)V", "leftPriority", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinSpreadLayout extends ViewGroup {
    @NotNull
    public List<? extends View> a;
    @NotNull
    public List<? extends View> b;
    public boolean c;
    public int d;
    public List<a> e;
    public List<a> f;

    public static final class a {
        @NotNull
        public final View a;
        public final int b;
        public final int c;

        public a(@NotNull View view, int i, int i2) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.a = view;
            this.b = i;
            this.c = i2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            View view = this.a;
            return ((((view != null ? view.hashCode() : 0) * 31) + this.b) * 31) + this.c;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ViewWithPosition(view=");
            L.append(this.a);
            L.append(", l=");
            L.append(this.b);
            L.append(", r=");
            return a2.b.a.a.a.j(L, this.c, ")");
        }
    }

    @JvmOverloads
    public BeduinSpreadLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public BeduinSpreadLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeduinSpreadLayout(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ int c(BeduinSpreadLayout beduinSpreadLayout, List list, int i, Pair pair, boolean z, int i2, int i3) {
        return beduinSpreadLayout.b(list, i, pair, z, (i3 & 16) != 0 ? 0 : i2);
    }

    public final Pair<Integer, Integer> a(List<? extends View> list, int i, Pair<Integer, Integer> pair, boolean z) {
        int i2;
        int i3;
        int i4;
        List<a> list2;
        if (list.isEmpty()) {
            return TuplesKt.to(0, 0);
        }
        if (z) {
            i3 = pair.getFirst().intValue();
            i2 = pair.getSecond().intValue();
        } else {
            i3 = pair.getSecond().intValue();
            i2 = pair.getFirst().intValue();
            list = CollectionsKt___CollectionsKt.reversed(list);
        }
        int i5 = 0;
        int i6 = 0;
        for (T t : list) {
            measureChild(t, View.MeasureSpec.makeMeasureSpec(Math.abs(i2 - i3), 0), i);
            if (z) {
                i4 = i3;
            } else {
                i4 = i3 - t.getMeasuredWidth();
            }
            int measuredWidth = z ? t.getMeasuredWidth() + i3 : i3;
            i5 = e.coerceAtLeast(i5, t.getMeasuredHeight());
            if (z) {
                list2 = this.e;
            } else {
                list2 = this.f;
            }
            list2.add(new a(t, i4, measuredWidth));
            int measuredWidth2 = t.getMeasuredWidth() + this.d;
            i3 += z ? measuredWidth2 : -measuredWidth2;
            i6 += measuredWidth2;
        }
        return TuplesKt.to(Integer.valueOf(i5), Integer.valueOf(i6 - this.d));
    }

    public final int b(List<? extends View> list, int i, Pair<Integer, Integer> pair, boolean z, int i2) {
        int i3;
        int i4;
        List<a> list2;
        Integer num;
        Integer num2;
        if (list.isEmpty()) {
            return i2;
        }
        int intValue = (((pair.getSecond().intValue() - pair.getFirst().intValue()) - ((list.size() - 1) * this.d)) / list.size()) + 1;
        if (z) {
            i3 = pair.getFirst().intValue();
        } else {
            i3 = pair.getSecond().intValue();
        }
        int i5 = i3;
        int i6 = 0;
        int i7 = i2;
        for (T t : list) {
            int i8 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            measureChild(t2, View.MeasureSpec.makeMeasureSpec(intValue, Integer.MIN_VALUE), i);
            if (z) {
                i4 = i5;
            } else {
                i4 = i5 - t2.getMeasuredWidth();
            }
            int measuredWidth = z ? t2.getMeasuredWidth() + i5 : i5;
            if (z) {
                list2 = this.e;
            } else {
                list2 = this.f;
            }
            list2.add(new a(t2, i4, measuredWidth));
            int coerceAtLeast = e.coerceAtLeast(i7, t2.getMeasuredHeight());
            int measuredWidth2 = t2.getMeasuredWidth() + this.d;
            if (!z) {
                measuredWidth2 = -measuredWidth2;
            }
            i5 += measuredWidth2;
            if (t2.getMeasuredWidth() < intValue) {
                List<? extends View> subList = list.subList(i8, list.size());
                if (z) {
                    num2 = Integer.valueOf(i5);
                    num = pair.getSecond();
                } else {
                    num2 = pair.getFirst();
                    num = Integer.valueOf(i5);
                }
                return b(subList, i, TuplesKt.to(num2, num), z, coerceAtLeast);
            }
            i6 = i8;
            i7 = coerceAtLeast;
        }
        return i7;
    }

    public final void d(List<a> list) {
        for (T t : list) {
            t.a.layout(t.b, getPaddingTop(), t.c, t.a.getMeasuredHeight() + getPaddingTop());
        }
    }

    public final void e(int i, int i2, int i3) {
        setMeasuredDimension(i, ViewGroup.resolveSize(getPaddingBottom() + getPaddingTop() + i2, i3));
    }

    public final boolean f(int i, int i2) {
        return getPaddingLeft() + (getPaddingRight() + i) < View.MeasureSpec.getSize(i2);
    }

    public final int getInterItemSpacingPx() {
        return this.d;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends android.view.View>, java.util.List<android.view.View> */
    @NotNull
    public final List<View> getLeftChildren() {
        return this.a;
    }

    public final boolean getLeftPriority() {
        return this.c;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends android.view.View>, java.util.List<android.view.View> */
    @NotNull
    public final List<View> getRightChildren() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        d(this.e);
        d(this.f);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        Pair<Integer, Integer> a3 = a(this.a, i2, TuplesKt.to(Integer.valueOf(getPaddingLeft()), Integer.valueOf(size)), true);
        int intValue = a3.component1().intValue();
        int intValue2 = a3.component2().intValue();
        if (!this.c || getPaddingRight() + intValue2 <= size) {
            int i3 = 0;
            Pair<Integer, Integer> a4 = a(this.b, i2, TuplesKt.to(Integer.valueOf(intValue2), Integer.valueOf(size - getPaddingRight())), false);
            int intValue3 = a4.component1().intValue();
            int intValue4 = a4.component2().intValue();
            if (this.c || getPaddingLeft() + intValue4 <= size) {
                int paddingRight = getPaddingRight() + getPaddingLeft() + intValue4 + intValue2;
                if ((!this.a.isEmpty()) && (true ^ this.b.isEmpty())) {
                    i3 = this.d;
                }
                if (paddingRight + i3 <= size) {
                    e(i, Math.max(intValue, intValue3), i2);
                } else if (this.c) {
                    if (f(intValue2, i)) {
                        this.f.clear();
                        e(i, Math.max(intValue, c(this, this.b, i2, TuplesKt.to(Integer.valueOf(intValue2), Integer.valueOf(View.MeasureSpec.getSize(i) - getPaddingRight())), false, 0, 16)), i2);
                        return;
                    }
                    e(i, intValue, i2);
                } else if (f(intValue4, i)) {
                    this.e.clear();
                    e(i, Math.max(intValue3, c(this, this.a, i2, TuplesKt.to(Integer.valueOf(getPaddingLeft()), Integer.valueOf((View.MeasureSpec.getSize(i) - getPaddingRight()) - intValue4)), true, 0, 16)), i2);
                } else {
                    e(i, intValue3, i2);
                }
            } else {
                this.e.clear();
                this.f.clear();
                e(i, a(this.b, i2, TuplesKt.to(Integer.valueOf(getPaddingLeft()), Integer.valueOf(size - getPaddingRight())), false).component1().intValue(), i2);
            }
        } else {
            e(i, intValue, i2);
        }
    }

    public final void setInterItemSpacingPx(int i) {
        this.d = i;
    }

    public final void setLeftChildren(@NotNull List<? extends View> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            addView(it.next());
        }
        this.a = list;
    }

    public final void setLeftPriority(boolean z) {
        this.c = z;
    }

    public final void setRightChildren(@NotNull List<? extends View> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            addView(it.next());
        }
        this.b = list;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BeduinSpreadLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = CollectionsKt__CollectionsKt.emptyList();
        this.b = CollectionsKt__CollectionsKt.emptyList();
        this.c = true;
        this.e = new ArrayList();
        this.f = new ArrayList();
    }
}
