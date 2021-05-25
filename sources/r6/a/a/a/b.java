package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class b implements Callable<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ AsyncFlowable.a e;

    public b(AsyncFlowable.a aVar, Object obj, Object obj2, Object obj3, Object obj4) {
        this.e = aVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
    }

    @Override // java.util.concurrent.Callable
    public R call() throws Exception {
        return (R) this.e.a.apply(this.a, this.b, this.c, this.d);
    }
}
