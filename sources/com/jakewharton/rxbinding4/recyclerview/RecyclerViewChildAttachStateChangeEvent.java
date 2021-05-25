package com.jakewharton.rxbinding4.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/jakewharton/rxbinding4/recyclerview/RecyclerViewChildAttachStateChangeEvent;", "", "Landroidx/recyclerview/widget/RecyclerView;", "getView", "()Landroidx/recyclerview/widget/RecyclerView;", "view", "Landroid/view/View;", "getChild", "()Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "<init>", "()V", "Lcom/jakewharton/rxbinding4/recyclerview/RecyclerViewChildAttachEvent;", "Lcom/jakewharton/rxbinding4/recyclerview/RecyclerViewChildDetachEvent;", "rxbinding-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public abstract class RecyclerViewChildAttachStateChangeEvent {
    public RecyclerViewChildAttachStateChangeEvent() {
    }

    @NotNull
    public abstract View getChild();

    @NotNull
    public abstract RecyclerView getView();

    public RecyclerViewChildAttachStateChangeEvent(j jVar) {
    }
}
