package com.jakewharton.rxbinding3.recyclerview;

import a2.b.a.a.a;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/jakewharton/rxbinding3/recyclerview/RecyclerViewChildDetachEvent;", "Lcom/jakewharton/rxbinding3/recyclerview/RecyclerViewChildAttachStateChangeEvent;", "Landroidx/recyclerview/widget/RecyclerView;", "component1", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "component2", "()Landroid/view/View;", "view", VKApiUserFull.RelativeType.CHILD, "copy", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)Lcom/jakewharton/rxbinding3/recyclerview/RecyclerViewChildDetachEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "getView", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "getChild", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)V", "rxbinding-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public final class RecyclerViewChildDetachEvent extends RecyclerViewChildAttachStateChangeEvent {
    @NotNull
    public final RecyclerView a;
    @NotNull
    public final View b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerViewChildDetachEvent(@NotNull RecyclerView recyclerView, @NotNull View view) {
        super(null);
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        Intrinsics.checkParameterIsNotNull(view, VKApiUserFull.RelativeType.CHILD);
        this.a = recyclerView;
        this.b = view;
    }

    public static /* synthetic */ RecyclerViewChildDetachEvent copy$default(RecyclerViewChildDetachEvent recyclerViewChildDetachEvent, RecyclerView recyclerView, View view, int i, Object obj) {
        if ((i & 1) != 0) {
            recyclerView = recyclerViewChildDetachEvent.getView();
        }
        if ((i & 2) != 0) {
            view = recyclerViewChildDetachEvent.getChild();
        }
        return recyclerViewChildDetachEvent.copy(recyclerView, view);
    }

    @NotNull
    public final RecyclerView component1() {
        return getView();
    }

    @NotNull
    public final View component2() {
        return getChild();
    }

    @NotNull
    public final RecyclerViewChildDetachEvent copy(@NotNull RecyclerView recyclerView, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        Intrinsics.checkParameterIsNotNull(view, VKApiUserFull.RelativeType.CHILD);
        return new RecyclerViewChildDetachEvent(recyclerView, view);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecyclerViewChildDetachEvent)) {
            return false;
        }
        RecyclerViewChildDetachEvent recyclerViewChildDetachEvent = (RecyclerViewChildDetachEvent) obj;
        return Intrinsics.areEqual(getView(), recyclerViewChildDetachEvent.getView()) && Intrinsics.areEqual(getChild(), recyclerViewChildDetachEvent.getChild());
    }

    @Override // com.jakewharton.rxbinding3.recyclerview.RecyclerViewChildAttachStateChangeEvent
    @NotNull
    public View getChild() {
        return this.b;
    }

    @Override // com.jakewharton.rxbinding3.recyclerview.RecyclerViewChildAttachStateChangeEvent
    @NotNull
    public RecyclerView getView() {
        return this.a;
    }

    public int hashCode() {
        RecyclerView view = getView();
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        View child = getChild();
        if (child != null) {
            i = child.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RecyclerViewChildDetachEvent(view=");
        L.append(getView());
        L.append(", child=");
        L.append(getChild());
        L.append(")");
        return L.toString();
    }
}
