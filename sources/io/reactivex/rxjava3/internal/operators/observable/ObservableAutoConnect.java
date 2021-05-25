package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observables.ConnectableObservable;
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

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(observer);
        if (this.d.incrementAndGet() == this.b) {
            this.a.connect(this.c);
        }
    }
}
