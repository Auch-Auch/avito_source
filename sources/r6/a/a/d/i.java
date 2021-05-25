package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;
import r6.a.a.d.h;
public final class i<T> extends Maybe<T> implements Callable<T> {
    public final MaybeSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public i(MaybeSource<T> maybeSource) {
        this.a = maybeSource;
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

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new h.a(maybeObserver, this.b));
    }
}
