package com.jakewharton.rxbinding4.view;

import a2.b.a.a.a;
import a2.g.r.g;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007Jj\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0007J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b-\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010&\u001a\u0004\b/\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b3\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b5\u0010\u0007¨\u00068"}, d2 = {"Lcom/jakewharton/rxbinding4/view/ViewLayoutChangeEvent;", "", "Landroid/view/View;", "component1", "()Landroid/view/View;", "", "component2", "()I", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "view", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "copy", "(Landroid/view/View;IIIIIIII)Lcom/jakewharton/rxbinding4/view/ViewLayoutChangeEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/view/View;", "getView", AuthSource.BOOKING_ORDER, "I", "getLeft", "d", "getRight", "i", "getOldBottom", "c", "getTop", "e", "getBottom", g.a, "getOldTop", "f", "getOldLeft", "h", "getOldRight", "<init>", "(Landroid/view/View;IIIIIIII)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class ViewLayoutChangeEvent {
    @NotNull
    public final View a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public ViewLayoutChangeEvent(@NotNull View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.a = view;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
        this.i = i9;
    }

    public static /* synthetic */ ViewLayoutChangeEvent copy$default(ViewLayoutChangeEvent viewLayoutChangeEvent, View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Object obj) {
        return viewLayoutChangeEvent.copy((i10 & 1) != 0 ? viewLayoutChangeEvent.a : view, (i10 & 2) != 0 ? viewLayoutChangeEvent.b : i2, (i10 & 4) != 0 ? viewLayoutChangeEvent.c : i3, (i10 & 8) != 0 ? viewLayoutChangeEvent.d : i4, (i10 & 16) != 0 ? viewLayoutChangeEvent.e : i5, (i10 & 32) != 0 ? viewLayoutChangeEvent.f : i6, (i10 & 64) != 0 ? viewLayoutChangeEvent.g : i7, (i10 & 128) != 0 ? viewLayoutChangeEvent.h : i8, (i10 & 256) != 0 ? viewLayoutChangeEvent.i : i9);
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

    public final int component6() {
        return this.f;
    }

    public final int component7() {
        return this.g;
    }

    public final int component8() {
        return this.h;
    }

    public final int component9() {
        return this.i;
    }

    @NotNull
    public final ViewLayoutChangeEvent copy(@NotNull View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        return new ViewLayoutChangeEvent(view, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewLayoutChangeEvent)) {
            return false;
        }
        ViewLayoutChangeEvent viewLayoutChangeEvent = (ViewLayoutChangeEvent) obj;
        return Intrinsics.areEqual(this.a, viewLayoutChangeEvent.a) && this.b == viewLayoutChangeEvent.b && this.c == viewLayoutChangeEvent.c && this.d == viewLayoutChangeEvent.d && this.e == viewLayoutChangeEvent.e && this.f == viewLayoutChangeEvent.f && this.g == viewLayoutChangeEvent.g && this.h == viewLayoutChangeEvent.h && this.i == viewLayoutChangeEvent.i;
    }

    public final int getBottom() {
        return this.e;
    }

    public final int getLeft() {
        return this.b;
    }

    public final int getOldBottom() {
        return this.i;
    }

    public final int getOldLeft() {
        return this.f;
    }

    public final int getOldRight() {
        return this.h;
    }

    public final int getOldTop() {
        return this.g;
    }

    public final int getRight() {
        return this.d;
    }

    public final int getTop() {
        return this.c;
    }

    @NotNull
    public final View getView() {
        return this.a;
    }

    public int hashCode() {
        View view = this.a;
        return ((((((((((((((((view != null ? view.hashCode() : 0) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ViewLayoutChangeEvent(view=");
        L.append(this.a);
        L.append(", left=");
        L.append(this.b);
        L.append(", top=");
        L.append(this.c);
        L.append(", right=");
        L.append(this.d);
        L.append(", bottom=");
        L.append(this.e);
        L.append(", oldLeft=");
        L.append(this.f);
        L.append(", oldTop=");
        L.append(this.g);
        L.append(", oldRight=");
        L.append(this.h);
        L.append(", oldBottom=");
        return a.j(L, this.i, ")");
    }
}
