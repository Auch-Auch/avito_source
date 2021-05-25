package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class s implements Callable<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ AsyncFlowable.a0 d;

    public s(AsyncFlowable.a0 a0Var, Object obj, Object obj2, Object obj3) {
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
