package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;
import r6.a.a.d.k;
public final class l<T> extends Observable<T> implements Callable<T> {
    public final ObservableSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public l(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        try {
            return (T) ((Callable) this.a).call();
        } catch (Exception e) {
            Exceptions.throwIfFatal(e);
            throw ((Exception) this.b.appendLast(e));
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new k.a(observer, this.b));
    }
}
