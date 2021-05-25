package com.jakewharton.rxbinding3.view;

import android.view.View;
import android.view.ViewGroup;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEvent;", "", "Landroid/view/View;", "getChild", "()Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "view", "<init>", "()V", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChildViewAddEvent;", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChildViewRemoveEvent;", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public abstract class ViewGroupHierarchyChangeEvent {
    public ViewGroupHierarchyChangeEvent() {
    }

    @NotNull
    public abstract View getChild();

    @NotNull
    public abstract ViewGroup getView();

    public ViewGroupHierarchyChangeEvent(j jVar) {
    }
}
