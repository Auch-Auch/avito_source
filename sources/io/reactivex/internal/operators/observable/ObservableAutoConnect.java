package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;
public final class ObservableAutoConnect<T> extends Observable<T> {
    public final ConnectableObservable<? extends T> a;
    public final int b;
    public final Consumer<? super Disposable> c;
    public final AtomicInteger d = new AtomicInteger();

    public ObservableAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i, Consumer<? super Disposable> consumer) {
        this.a = connectableObservable;
        this.b = i;
        this.c = consumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(observer);
        if (this.d.incrementAndGet() == this.b) {
            this.a.connect(this.c);
        }
    }
}
