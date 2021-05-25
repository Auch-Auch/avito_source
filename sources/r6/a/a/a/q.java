package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class q implements Callable<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ AsyncFlowable.y c;

    public q(AsyncFlowable.y yVar, Object obj, Object obj2) {
        this.c = yVar;
        this.a = obj;
        this.b = obj2;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.c.a.accept(this.a, this.b);
        return AnyValue.INSTANCE;
    }
}
