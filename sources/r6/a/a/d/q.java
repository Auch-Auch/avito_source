package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;
import r6.a.a.d.p;
public final class q<T> extends Single<T> implements Callable<T> {
    public final SingleSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public q(SingleSource<T> singleSource) {
        this.a = singleSource;
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

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new p.a(singleObserver, this.b));
    }
}
