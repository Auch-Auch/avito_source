package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import r6.a.b.e.k;
public final class l<T> extends ConnectableObservable<T> {
    public final ConnectableObservable<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public l(ConnectableObservable<T> connectableObservable) {
        this.a = connectableObservable;
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
        this.a.subscribe(new k.a(observer, this.b));
    }
}
