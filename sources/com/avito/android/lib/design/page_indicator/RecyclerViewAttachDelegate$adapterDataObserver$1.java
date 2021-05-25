package com.avito.android.lib.design.page_indicator;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\tJ'\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"com/avito/android/lib/design/page_indicator/RecyclerViewAttachDelegate$adapterDataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "()V", "", "positionStart", "itemCount", "onItemRangeChanged", "(II)V", "", "payload", "(IILjava/lang/Object;)V", "onItemRangeInserted", "fromPosition", "toPosition", "onItemRangeMoved", "(III)V", "onItemRangeRemoved", "components_release"}, k = 1, mv = {1, 4, 2})
public final class RecyclerViewAttachDelegate$adapterDataObserver$1 extends RecyclerView.AdapterDataObserver {
    public final /* synthetic */ RecyclerViewAttachDelegate a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public RecyclerViewAttachDelegate$adapterDataObserver$1(RecyclerViewAttachDelegate recyclerViewAttachDelegate) {
        this.a = recyclerViewAttachDelegate;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        this.a.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i, int i2) {
        this.a.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
        this.a.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeMoved(int i, int i2, int i3) {
        this.a.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int i, int i2) {
        this.a.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
        this.a.b();
    }
}
