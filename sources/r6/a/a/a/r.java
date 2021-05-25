package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class r implements Callable<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ AsyncFlowable.z c;

    public r(AsyncFlowable.z zVar, Object obj, Object obj2) {
        this.c = zVar;
        this.a = obj;
        this.b = obj2;
    }

    @Override // java.util.concurrent.Callable
    public R call() throws Exception {
        return (R) this.c.a.apply(this.a, this.b);
    }
}
