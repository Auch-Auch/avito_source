package com.jakewharton.rxbinding3.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class RecyclerAdapterDataChangeObservable<T extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> extends InitialValueObservable<T> {
    public final T a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0010\b\u0001\u0010\u0003*\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00012\u00020\u0004B\u001f\u0012\u0006\u0010\n\u001a\u00028\u0001\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00028\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/jakewharton/rxbinding3/recyclerview/RecyclerAdapterDataChangeObservable$Listener;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "T", "Lio/reactivex/android/MainThreadDisposable;", "", "onDispose", "()V", "c", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "recyclerAdapter", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getDataObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "dataObserver", "Lio/reactivex/Observer;", "observer", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Lio/reactivex/Observer;)V", "rxbinding-recyclerview_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener<T extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> extends MainThreadDisposable {
        @NotNull
        public final RecyclerView.AdapterDataObserver b;
        public final T c;

        public Listener(@NotNull T t, @NotNull Observer<? super T> observer) {
            Intrinsics.checkParameterIsNotNull(t, "recyclerAdapter");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.c = t;
            this.b = new RecyclerAdapterDataChangeObservable$Listener$dataObserver$1(this, observer);
        }

        @NotNull
        public final RecyclerView.AdapterDataObserver getDataObserver() {
            return this.b;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.c.unregisterAdapterDataObserver(this.b);
        }
    }

    public RecyclerAdapterDataChangeObservable(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "adapter");
        this.a = t;
    }

    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public Object getInitialValue() {
        return this.a;
    }

    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super T> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.a, observer);
            observer.onSubscribe(listener);
            this.a.registerAdapterDataObserver(listener.getDataObserver());
        }
    }
}
