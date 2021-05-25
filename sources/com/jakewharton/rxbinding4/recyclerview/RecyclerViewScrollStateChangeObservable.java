package com.jakewharton.rxbinding4.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class RecyclerViewScrollStateChangeObservable extends Observable<Integer> {
    public final RecyclerView a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/jakewharton/rxbinding4/recyclerview/RecyclerViewScrollStateChangeObservable$Listener;", "Lio/reactivex/rxjava3/android/MainThreadDisposable;", "", "onDispose", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scrollListener", "Lio/reactivex/rxjava3/core/Observer;", "", "observer", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lio/reactivex/rxjava3/core/Observer;)V", "rxbinding-recyclerview_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable {
        @NotNull
        public final RecyclerView.OnScrollListener b;
        public final RecyclerView c;

        public Listener(@NotNull RecyclerView recyclerView, @NotNull Observer<? super Integer> observer) {
            Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.c = recyclerView;
            this.b = new RecyclerViewScrollStateChangeObservable$Listener$scrollListener$1(this, observer);
        }

        @NotNull
        public final RecyclerView.OnScrollListener getScrollListener() {
            return this.b;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.c.removeOnScrollListener(this.b);
        }
    }

    public RecyclerViewScrollStateChangeObservable(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        this.a = recyclerView;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.a, observer);
            observer.onSubscribe(listener);
            this.a.addOnScrollListener(listener.getScrollListener());
        }
    }
}
