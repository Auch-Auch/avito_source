package com.jakewharton.rxbinding4.widget;

import android.database.DataSetObserver;
import android.widget.Adapter;
import com.jakewharton.rxbinding4.InitialValueObservable;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class AdapterDataChangeObservable<T extends Adapter> extends InitialValueObservable<T> {
    public final T a;

    public static final class ObserverDisposable<T extends Adapter> extends MainThreadDisposable {
        @JvmField
        @NotNull
        public final DataSetObserver b;
        public final T c;

        public ObserverDisposable(@NotNull T t, @NotNull Observer<? super T> observer) {
            Intrinsics.checkParameterIsNotNull(t, "adapter");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.c = t;
            this.b = new AdapterDataChangeObservable$ObserverDisposable$dataSetObserver$1(this, observer);
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.c.unregisterDataSetObserver(this.b);
        }
    }

    public AdapterDataChangeObservable(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "adapter");
        this.a = t;
    }

    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public Object getInitialValue() {
        return this.a;
    }

    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super T> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            ObserverDisposable observerDisposable = new ObserverDisposable(this.a, observer);
            this.a.registerDataSetObserver(observerDisposable.b);
            observer.onSubscribe(observerDisposable);
        }
    }
}
