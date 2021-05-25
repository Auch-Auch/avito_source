package r6.a.a.d.s;

import hu.akarnokd.rxjava2.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava2.functions.PlainConsumer;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import r6.a.a.d.s.f;
public final class c<T> extends ConnectableObservable<T> {
    public final ConnectableObservable<T> a;
    public final PlainConsumer<ProtocolNonConformanceException> b;

    public c(ConnectableObservable<T> connectableObservable, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.a = connectableObservable;
        this.b = plainConsumer;
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        this.a.connect(consumer);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new f.a(observer, this.b));
    }
}
