package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AsyncObservable;
import java.util.concurrent.Callable;
public class i0 implements Callable<R> {
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ AsyncObservable.n b;

    public i0(AsyncObservable.n nVar, Object[] objArr) {
        this.b = nVar;
        this.a = objArr;
    }

    @Override // java.util.concurrent.Callable
    public R call() throws Exception {
        return (R) this.b.a.apply(this.a);
    }
}
