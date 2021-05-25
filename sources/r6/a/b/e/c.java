package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import r6.a.b.e.a;
public final class c extends Completable implements Supplier<Object> {
    public final CompletableSource a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public c(CompletableSource completableSource) {
        this.a = completableSource;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Throwable {
        try {
            return ((Supplier) this.a).get();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw this.b.appendLast(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a.C0636a(completableObserver, this.b));
    }
}
