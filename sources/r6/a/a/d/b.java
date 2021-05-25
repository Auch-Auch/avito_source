package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;
import r6.a.a.d.a;
public final class b extends Completable implements Callable<Object> {
    public final CompletableSource a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public b(CompletableSource completableSource) {
        this.a = completableSource;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        try {
            return ((Callable) this.a).call();
        } catch (Exception e) {
            Exceptions.throwIfFatal(e);
            throw ((Exception) this.b.appendLast(e));
        }
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a.C0584a(completableObserver, this.b));
    }
}
