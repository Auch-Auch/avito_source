package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import r6.a.b.e.h;
public final class i<T> extends Maybe<T> implements ScalarSupplier<T> {
    public final MaybeSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public i(MaybeSource<T> maybeSource) {
        this.a = maybeSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.ScalarSupplier, io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return (T) ((ScalarSupplier) this.a).get();
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new h.a(maybeObserver, this.b));
    }
}
