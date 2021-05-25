package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import r6.a.b.e.p;
public final class r<T> extends Single<T> implements Supplier<T> {
    public final SingleSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public r(SingleSource<T> singleSource) {
        this.a = singleSource;
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

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new p.a(singleObserver, this.b));
    }
}
