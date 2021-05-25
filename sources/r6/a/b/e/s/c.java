package r6.a.b.e.s;

import hu.akarnokd.rxjava3.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava3.functions.PlainConsumer;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import r6.a.b.e.s.f;
public final class c<T> extends ConnectableObservable<T> {
    public final ConnectableObservable<T> a;
    public final PlainConsumer<ProtocolNonConformanceException> b;

    public c(ConnectableObservable<T> connectableObservable, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.a = connectableObservable;
        this.b = plainConsumer;
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        this.a.connect(consumer);
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void reset() {
        this.a.reset();
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new f.a(observer, this.b));
    }
}
