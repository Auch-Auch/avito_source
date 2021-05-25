package com.jakewharton.rxbinding3.recyclerview;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lcom/jakewharton/rxbinding3/recyclerview/RecyclerViewScrollEvent;", "", "Landroidx/recyclerview/widget/RecyclerView;", "component1", "()Landroidx/recyclerview/widget/RecyclerView;", "", "component2", "()I", "component3", "view", "dx", "dy", "copy", "(Landroidx/recyclerview/widget/RecyclerView;II)Lcom/jakewharton/rxbinding3/recyclerview/RecyclerViewScrollEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getDx", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "getView", "c", "getDy", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "rxbinding-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public final class RecyclerViewScrollEvent {
    @NotNull
    public final RecyclerView a;
    public final int b;
    public final int c;

    public RecyclerViewScrollEvent(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        this.a = recyclerView;
        this.b = i;
        this.c = i2;
    }

    public static /* synthetic */ RecyclerViewScrollEvent copy$default(RecyclerViewScrollEvent recyclerViewScrollEvent, RecyclerView recyclerView, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            recyclerView = recyclerViewScrollEvent.a;
        }
        if ((i3 & 2) != 0) {
            i = recyclerViewScrollEvent.b;
        }
        if ((i3 & 4) != 0) {
            i2 = recyclerViewScrollEvent.c;
        }
        return recyclerViewScrollEvent.copy(recyclerView, i, i2);
    }

    @NotNull
    public final RecyclerView component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @NotNull
    public final RecyclerViewScrollEvent copy(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        return new RecyclerViewScrollEvent(recyclerView, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RecyclerViewScrollEvent) {
                RecyclerViewScrollEvent recyclerViewScrollEvent = (RecyclerViewScrollEvent) obj;
                if (Intrinsics.areEqual(this.a, recyclerViewScrollEvent.a)) {
                    if (this.b == recyclerViewScrollEvent.b) {
                        if (this.c == recyclerViewScrollEvent.c) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getDx() {
        return this.b;
    }

    public final int getDy() {
        return this.c;
    }

    @NotNull
    public final RecyclerView getView() {
        return this.a;
    }

    public int hashCode() {
        RecyclerView recyclerView = this.a;
        return ((((recyclerView != null ? recyclerView.hashCode() : 0) * 31) + this.b) * 31) + this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RecyclerViewScrollEvent(view=");
        L.append(this.a);
        L.append(", dx=");
        L.append(this.b);
        L.append(", dy=");
        return a.j(L, this.c, ")");
    }
}
