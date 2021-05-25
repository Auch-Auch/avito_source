package com.jakewharton.rxbinding4.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import com.jakewharton.rxbinding4.recyclerview.RecyclerViewScrollEventObservable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/jakewharton/rxbinding4/recyclerview/RecyclerViewScrollEventObservable$Listener$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "rxbinding-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public final class RecyclerViewScrollEventObservable$Listener$scrollListener$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ RecyclerViewScrollEventObservable.Listener a;
    public final /* synthetic */ Observer b;

    public RecyclerViewScrollEventObservable$Listener$scrollListener$1(RecyclerViewScrollEventObservable.Listener listener, Observer observer) {
        this.a = listener;
        this.b = observer;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        if (!this.a.isDisposed()) {
            this.b.onNext(new RecyclerViewScrollEvent(recyclerView, i, i2));
        }
    }
}
