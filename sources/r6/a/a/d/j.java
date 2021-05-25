package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.internal.fuseable.ScalarCallable;
import r6.a.a.d.h;
public final class j<T> extends Maybe<T> implements ScalarCallable<T> {
    public final MaybeSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public j(MaybeSource<T> maybeSource) {
        this.a = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return (T) ((ScalarCallable) this.a).call();
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new h.a(maybeObserver, this.b));
    }
}
