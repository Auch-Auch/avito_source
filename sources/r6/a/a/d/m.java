package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import r6.a.a.d.k;
public final class m<T> extends ConnectableObservable<T> {
    public final ConnectableObservable<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public m(ConnectableObservable<T> connectableObservable) {
        this.a = connectableObservable;
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        this.a.connect(consumer);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new k.a(observer, this.b));
    }
}
