package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncObservable;
import java.util.concurrent.Callable;
public class p0 implements Callable<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ AsyncObservable.c0 e;

    public p0(AsyncObservable.c0 c0Var, Object obj, Object obj2, Object obj3, Object obj4) {
        this.e = c0Var;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.e.a.accept(this.a, this.b, this.c, this.d);
        return AnyValue.INSTANCE;
    }
}
