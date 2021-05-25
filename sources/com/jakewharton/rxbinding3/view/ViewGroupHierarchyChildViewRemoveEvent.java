package com.jakewharton.rxbinding3.view;

import a2.b.a.a.a;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChildViewRemoveEvent;", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEvent;", "Landroid/view/ViewGroup;", "component1", "()Landroid/view/ViewGroup;", "Landroid/view/View;", "component2", "()Landroid/view/View;", "view", VKApiUserFull.RelativeType.CHILD, "copy", "(Landroid/view/ViewGroup;Landroid/view/View;)Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChildViewRemoveEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "getView", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "getChild", "<init>", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class ViewGroupHierarchyChildViewRemoveEvent extends ViewGroupHierarchyChangeEvent {
    @NotNull
    public final ViewGroup a;
    @NotNull
    public final View b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewGroupHierarchyChildViewRemoveEvent(@NotNull ViewGroup viewGroup, @NotNull View view) {
        super(null);
        Intrinsics.checkParameterIsNotNull(viewGroup, "view");
        Intrinsics.checkParameterIsNotNull(view, VKApiUserFull.RelativeType.CHILD);
        this.a = viewGroup;
        this.b = view;
    }

    public static /* synthetic */ ViewGroupHierarchyChildViewRemoveEvent copy$default(ViewGroupHierarchyChildViewRemoveEvent viewGroupHierarchyChildViewRemoveEvent, ViewGroup viewGroup, View view, int i, Object obj) {
        if ((i & 1) != 0) {
            viewGroup = viewGroupHierarchyChildViewRemoveEvent.getView();
        }
        if ((i & 2) != 0) {
            view = viewGroupHierarchyChildViewRemoveEvent.getChild();
        }
        return viewGroupHierarchyChildViewRemoveEvent.copy(viewGroup, view);
    }

    @NotNull
    public final ViewGroup component1() {
        return getView();
    }

    @NotNull
    public final View component2() {
        return getChild();
    }

    @NotNull
    public final ViewGroupHierarchyChildViewRemoveEvent copy(@NotNull ViewGroup viewGroup, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "view");
        Intrinsics.checkParameterIsNotNull(view, VKApiUserFull.RelativeType.CHILD);
        return new ViewGroupHierarchyChildViewRemoveEvent(viewGroup, view);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewGroupHierarchyChildViewRemoveEvent)) {
            return false;
        }
        ViewGroupHierarchyChildViewRemoveEvent viewGroupHierarchyChildViewRemoveEvent = (ViewGroupHierarchyChildViewRemoveEvent) obj;
        return Intrinsics.areEqual(getView(), viewGroupHierarchyChildViewRemoveEvent.getView()) && Intrinsics.areEqual(getChild(), viewGroupHierarchyChildViewRemoveEvent.getChild());
    }

    @Override // com.jakewharton.rxbinding3.view.ViewGroupHierarchyChangeEvent
    @NotNull
    public View getChild() {
        return this.b;
    }

    @Override // com.jakewharton.rxbinding3.view.ViewGroupHierarchyChangeEvent
    @NotNull
    public ViewGroup getView() {
        return this.a;
    }

    public int hashCode() {
        ViewGroup view = getView();
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
        StringBuilder L = a.L("ViewGroupHierarchyChildViewRemoveEvent(view=");
        L.append(getView());
        L.append(", child=");
        L.append(getChild());
        L.append(")");
        return L.toString();
    }
}
