package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AsyncObservable;
import java.util.concurrent.Callable;
public class m0 implements Callable<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ AsyncObservable.z c;

    public m0(AsyncObservable.z zVar, Object obj, Object obj2) {
        this.c = zVar;
        this.a = obj;
        this.b = obj2;
    }

    @Override // java.util.concurrent.Callable
    public R call() throws Exception {
        return (R) this.c.a.apply(this.a, this.b);
    }
}
