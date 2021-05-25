package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class n implements Callable<R> {
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ AsyncFlowable.n b;

    public n(AsyncFlowable.n nVar, Object[] objArr) {
        this.b = nVar;
        this.a = objArr;
    }

    @Override // java.util.concurrent.Callable
    public R call() throws Exception {
        return (R) this.b.a.apply(this.a);
    }
}
