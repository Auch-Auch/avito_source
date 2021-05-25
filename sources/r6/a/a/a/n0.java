package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncObservable;
import java.util.concurrent.Callable;
public class n0 implements Callable<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ AsyncObservable.a0 d;

    public n0(AsyncObservable.a0 a0Var, Object obj, Object obj2, Object obj3) {
        this.d = a0Var;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.d.a.accept(this.a, this.b, this.c);
        return AnyValue.INSTANCE;
    }
}
