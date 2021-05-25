package com.jakewharton.rxbinding4.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import com.jakewharton.rxbinding4.recyclerview.RecyclerViewFlingEventObservable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/jakewharton/rxbinding4/recyclerview/RecyclerViewFlingEventObservable$Listener$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnFlingListener;", "", "velocityX", "velocityY", "", "onFling", "(II)Z", "rxbinding-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public final class RecyclerViewFlingEventObservable$Listener$scrollListener$1 extends RecyclerView.OnFlingListener {
    public final /* synthetic */ RecyclerViewFlingEventObservable.Listener a;
    public final /* synthetic */ Observer b;

    public RecyclerViewFlingEventObservable$Listener$scrollListener$1(RecyclerViewFlingEventObservable.Listener listener, Observer observer) {
        this.a = listener;
        this.b = observer;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i, int i2) {
        if (this.a.isDisposed()) {
            return false;
        }
        this.b.onNext(new RecyclerViewFlingEvent(RecyclerViewFlingEventObservable.Listener.access$getRecyclerView$p(this.a), i, i2));
        return false;
    }
}
