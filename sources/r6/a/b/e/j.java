package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import r6.a.b.e.h;
public final class j<T> extends Maybe<T> implements Supplier<T> {
    public final MaybeSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public j(MaybeSource<T> maybeSource) {
        this.a = maybeSource;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        try {
            return (T) ((Supplier) this.a).get();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ((Exception) this.b.appendLast(th));
        }
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new h.a(maybeObserver, this.b));
    }
}
