package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AsyncObservable;
import java.util.concurrent.Callable;
public class o0 implements Callable<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ AsyncObservable.b0 d;

    public o0(AsyncObservable.b0 b0Var, Object obj, Object obj2, Object obj3) {
        this.d = b0Var;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    @Override // java.util.concurrent.Callable
    public R call() throws Exception {
        return (R) this.d.a.apply(this.a, this.b, this.c);
    }
}
