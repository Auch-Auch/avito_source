package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class p implements Callable<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ AsyncFlowable.x b;

    public p(AsyncFlowable.x xVar, Object obj) {
        this.b = xVar;
        this.a = obj;
    }

    @Override // java.util.concurrent.Callable
    public R call() throws Exception {
        return (R) this.b.a.apply(this.a);
    }
}
