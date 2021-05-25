package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import r6.a.b.e.k;
public final class n<T> extends Observable<T> implements Supplier<T> {
    public final ObservableSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public n(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        try {
            return (T) ((Supplier) this.a).get();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw this.b.appendLast(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new k.a(observer, this.b));
    }
}
