package com.jakewharton.rxbinding4.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class RecyclerViewChildAttachStateChangeEventObservable extends Observable<RecyclerViewChildAttachStateChangeEvent> {
    public final RecyclerView a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/jakewharton/rxbinding4/recyclerview/RecyclerViewChildAttachStateChangeEventObservable$Listener;", "Lio/reactivex/rxjava3/android/MainThreadDisposable;", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "Landroid/view/View;", "childView", "", "onChildViewAttachedToWindow", "(Landroid/view/View;)V", "onChildViewDetachedFromWindow", "onDispose", "()V", "Lio/reactivex/rxjava3/core/Observer;", "Lcom/jakewharton/rxbinding4/recyclerview/RecyclerViewChildAttachStateChangeEvent;", "c", "Lio/reactivex/rxjava3/core/Observer;", "observer", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lio/reactivex/rxjava3/core/Observer;)V", "rxbinding-recyclerview_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements RecyclerView.OnChildAttachStateChangeListener {
        public final RecyclerView b;
        public final Observer<? super RecyclerViewChildAttachStateChangeEvent> c;

        public Listener(@NotNull RecyclerView recyclerView, @NotNull Observer<? super RecyclerViewChildAttachStateChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = recyclerView;
            this.c = observer;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "childView");
            if (!isDisposed()) {
                this.c.onNext(new RecyclerViewChildAttachEvent(this.b, view));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "childView");
            if (!isDisposed()) {
                this.c.onNext(new RecyclerViewChildDetachEvent(this.b, view));
            }
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.removeOnChildAttachStateChangeListener(this);
        }
    }

    public RecyclerViewChildAttachStateChangeEventObservable(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        this.a = recyclerView;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super RecyclerViewChildAttachStateChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.a, observer);
            observer.onSubscribe(listener);
            this.a.addOnChildAttachStateChangeListener(listener);
        }
    }
}
