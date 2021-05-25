package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.ScalarCallable;
import r6.a.a.d.k;
public final class n<T> extends Observable<T> implements ScalarCallable<T> {
    public final ObservableSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public n(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return (T) ((ScalarCallable) this.a).call();
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new k.a(observer, this.b));
    }
}
