package com.jakewharton.rxbinding4.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import com.jakewharton.rxbinding4.recyclerview.RecyclerAdapterDataChangeObservable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/jakewharton/rxbinding4/recyclerview/RecyclerAdapterDataChangeObservable$Listener$dataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "()V", "rxbinding-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public final class RecyclerAdapterDataChangeObservable$Listener$dataObserver$1 extends RecyclerView.AdapterDataObserver {
    public final /* synthetic */ RecyclerAdapterDataChangeObservable.Listener a;
    public final /* synthetic */ Observer b;

    public RecyclerAdapterDataChangeObservable$Listener$dataObserver$1(RecyclerAdapterDataChangeObservable.Listener listener, Observer observer) {
        this.a = listener;
        this.b = observer;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        if (!this.a.isDisposed()) {
            this.b.onNext(RecyclerAdapterDataChangeObservable.Listener.access$getRecyclerAdapter$p(this.a));
        }
    }
}
