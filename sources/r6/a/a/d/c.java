package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.internal.fuseable.ScalarCallable;
import r6.a.a.d.a;
public final class c extends Completable implements ScalarCallable<Object> {
    public final CompletableSource a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public c(CompletableSource completableSource) {
        this.a = completableSource;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public Object call() {
        return ((ScalarCallable) this.a).call();
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a.C0584a(completableObserver, this.b));
    }
}
