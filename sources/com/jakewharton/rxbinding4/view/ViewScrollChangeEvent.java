package com.jakewharton.rxbinding4.view;

import a2.b.a.a.a;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lcom/jakewharton/rxbinding4/view/ViewScrollChangeEvent;", "", "Landroid/view/View;", "component1", "()Landroid/view/View;", "", "component2", "()I", "component3", "component4", "component5", "view", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "copy", "(Landroid/view/View;IIII)Lcom/jakewharton/rxbinding4/view/ViewScrollChangeEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "I", "getOldScrollY", AuthSource.SEND_ABUSE, "Landroid/view/View;", "getView", "c", "getScrollY", AuthSource.BOOKING_ORDER, "getScrollX", "d", "getOldScrollX", "<init>", "(Landroid/view/View;IIII)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class ViewScrollChangeEvent {
    @NotNull
    public final View a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public ViewScrollChangeEvent(@NotNull View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.a = view;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public static /* synthetic */ ViewScrollChangeEvent copy$default(ViewScrollChangeEvent viewScrollChangeEvent, View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            view = viewScrollChangeEvent.a;
        }
        if ((i5 & 2) != 0) {
            i = viewScrollChangeEvent.b;
        }
        if ((i5 & 4) != 0) {
            i2 = viewScrollChangeEvent.c;
        }
        if ((i5 & 8) != 0) {
            i3 = viewScrollChangeEvent.d;
        }
        if ((i5 & 16) != 0) {
            i4 = viewScrollChangeEvent.e;
        }
        return viewScrollChangeEvent.copy(view, i, i2, i3, i4);
    }

    @NotNull
    public final View component1() {
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
    public final ViewScrollChangeEvent copy(@NotNull View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        return new ViewScrollChangeEvent(view, i, i2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewScrollChangeEvent)) {
            return false;
        }
        ViewScrollChangeEvent viewScrollChangeEvent = (ViewScrollChangeEvent) obj;
        return Intrinsics.areEqual(this.a, viewScrollChangeEvent.a) && this.b == viewScrollChangeEvent.b && this.c == viewScrollChangeEvent.c && this.d == viewScrollChangeEvent.d && this.e == viewScrollChangeEvent.e;
    }

    public final int getOldScrollX() {
        return this.d;
    }

    public final int getOldScrollY() {
        return this.e;
    }

    public final int getScrollX() {
        return this.b;
    }

    public final int getScrollY() {
        return this.c;
    }

    @NotNull
    public final View getView() {
        return this.a;
    }

    public int hashCode() {
        View view = this.a;
        return ((((((((view != null ? view.hashCode() : 0) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ViewScrollChangeEvent(view=");
        L.append(this.a);
        L.append(", scrollX=");
        L.append(this.b);
        L.append(", scrollY=");
        L.append(this.c);
        L.append(", oldScrollX=");
        L.append(this.d);
        L.append(", oldScrollY=");
        return a.j(L, this.e, ")");
    }
}
