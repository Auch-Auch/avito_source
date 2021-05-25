package com.avito.android.favorite_sellers;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/favorite_sellers/ViewPortState;", "", "", "component1", "()I", "component2", "component3", "firstVisible", "lastVisible", "lastCompletelyVisible", "copy", "(III)Lcom/avito/android/favorite_sellers/ViewPortState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "I", "getLastCompletelyVisible", AuthSource.SEND_ABUSE, "getFirstVisible", AuthSource.BOOKING_ORDER, "getLastVisible", "<init>", "(III)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class ViewPortState {
    public final int a;
    public final int b;
    public final int c;

    public ViewPortState(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static /* synthetic */ ViewPortState copy$default(ViewPortState viewPortState, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = viewPortState.a;
        }
        if ((i4 & 2) != 0) {
            i2 = viewPortState.b;
        }
        if ((i4 & 4) != 0) {
            i3 = viewPortState.c;
        }
        return viewPortState.copy(i, i2, i3);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @NotNull
    public final ViewPortState copy(int i, int i2, int i3) {
        return new ViewPortState(i, i2, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewPortState)) {
            return false;
        }
        ViewPortState viewPortState = (ViewPortState) obj;
        return this.a == viewPortState.a && this.b == viewPortState.b && this.c == viewPortState.c;
    }

    public final int getFirstVisible() {
        return this.a;
    }

    public final int getLastCompletelyVisible() {
        return this.c;
    }

    public final int getLastVisible() {
        return this.b;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ViewPortState(firstVisible=");
        L.append(this.a);
        L.append(", lastVisible=");
        L.append(this.b);
        L.append(", lastCompletelyVisible=");
        return a.j(L, this.c, ")");
    }
}
