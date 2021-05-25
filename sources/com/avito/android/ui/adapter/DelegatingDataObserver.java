package com.avito.android.ui.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\tJ'\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tR\u001e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/ui/adapter/DelegatingDataObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "()V", "", "positionStart", "itemCount", "onItemRangeChanged", "(II)V", "", "payload", "(IILjava/lang/Object;)V", "onItemRangeInserted", "fromPosition", "toPosition", "onItemRangeMoved", "(III)V", "onItemRangeRemoved", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "delegate", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "appending-list_release"}, k = 1, mv = {1, 4, 2})
public final class DelegatingDataObserver extends RecyclerView.AdapterDataObserver {
    public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> a;

    public DelegatingDataObserver(@NotNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "delegate");
        this.a = adapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        this.a.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i, int i2) {
        this.a.notifyItemRangeChanged(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
        this.a.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeMoved(int i, int i2, int i3) {
        this.a.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int i, int i2) {
        this.a.notifyItemRangeRemoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
        this.a.notifyItemRangeChanged(i, i2, obj);
    }
}
