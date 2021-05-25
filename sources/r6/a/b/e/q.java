package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import r6.a.b.e.p;
public final class q<T> extends Single<T> implements ScalarSupplier<T> {
    public final SingleSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public q(SingleSource<T> singleSource) {
        this.a = singleSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.ScalarSupplier, io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return (T) ((ScalarSupplier) this.a).get();
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new p.a(singleObserver, this.b));
    }
}
