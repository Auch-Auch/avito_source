package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class d implements Callable<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ AsyncFlowable.c f;

    public d(AsyncFlowable.c cVar, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.f = cVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
        this.e = obj5;
    }

    @Override // java.util.concurrent.Callable
    public R call() throws Exception {
        return (R) this.f.a.apply(this.a, this.b, this.c, this.d, this.e);
    }
}
