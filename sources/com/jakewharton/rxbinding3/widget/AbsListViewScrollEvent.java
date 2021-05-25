package com.jakewharton.rxbinding3.widget;

import a2.b.a.a.a;
import android.widget.AbsListView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEvent;", "", "Landroid/widget/AbsListView;", "component1", "()Landroid/widget/AbsListView;", "", "component2", "()I", "component3", "component4", "component5", "view", "scrollState", "firstVisibleItem", "visibleItemCount", "totalItemCount", "copy", "(Landroid/widget/AbsListView;IIII)Lcom/jakewharton/rxbinding3/widget/AbsListViewScrollEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "I", "getFirstVisibleItem", AuthSource.SEND_ABUSE, "Landroid/widget/AbsListView;", "getView", "e", "getTotalItemCount", "d", "getVisibleItemCount", AuthSource.BOOKING_ORDER, "getScrollState", "<init>", "(Landroid/widget/AbsListView;IIII)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class AbsListViewScrollEvent {
    @NotNull
    public final AbsListView a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public AbsListViewScrollEvent(@NotNull AbsListView absListView, int i, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(absListView, "view");
        this.a = absListView;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public static /* synthetic */ AbsListViewScrollEvent copy$default(AbsListViewScrollEvent absListViewScrollEvent, AbsListView absListView, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            absListView = absListViewScrollEvent.a;
        }
        if ((i5 & 2) != 0) {
            i = absListViewScrollEvent.b;
        }
        if ((i5 & 4) != 0) {
            i2 = absListViewScrollEvent.c;
        }
        if ((i5 & 8) != 0) {
            i3 = absListViewScrollEvent.d;
        }
        if ((i5 & 16) != 0) {
            i4 = absListViewScrollEvent.e;
        }
        return absListViewScrollEvent.copy(absListView, i, i2, i3, i4);
    }

    @NotNull
    public final AbsListView component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    public final int component5() {
        return this.e;
    }

    @NotNull
    public final AbsListViewScrollEvent copy(@NotNull AbsListView absListView, int i, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(absListView, "view");
        return new AbsListViewScrollEvent(absListView, i, i2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AbsListViewScrollEvent) {
                AbsListViewScrollEvent absListViewScrollEvent = (AbsListViewScrollEvent) obj;
                if (Intrinsics.areEqual(this.a, absListViewScrollEvent.a)) {
                    if (this.b == absListViewScrollEvent.b) {
                        if (this.c == absListViewScrollEvent.c) {
                            if (this.d == absListViewScrollEvent.d) {
                                if (this.e == absListViewScrollEvent.e) {
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getFirstVisibleItem() {
        return this.c;
    }

    public final int getScrollState() {
        return this.b;
    }

    public final int getTotalItemCount() {
        return this.e;
    }

    @NotNull
    public final AbsListView getView() {
        return this.a;
    }

    public final int getVisibleItemCount() {
        return this.d;
    }

    public int hashCode() {
        AbsListView absListView = this.a;
        return ((((((((absListView != null ? absListView.hashCode() : 0) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AbsListViewScrollEvent(view=");
        L.append(this.a);
        L.append(", scrollState=");
        L.append(this.b);
        L.append(", firstVisibleItem=");
        L.append(this.c);
        L.append(", visibleItemCount=");
        L.append(this.d);
        L.append(", totalItemCount=");
        return a.j(L, this.e, ")");
    }
}
