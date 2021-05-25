package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AsyncObservable;
import java.util.concurrent.Callable;
public class k0 implements Callable<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ AsyncObservable.x b;

    public k0(AsyncObservable.x xVar, Object obj) {
        this.b = xVar;
        this.a = obj;
    }

    @Override // java.util.concurrent.Callable
    public R call() throws Exception {
        return (R) this.b.a.apply(this.a);
    }
}
