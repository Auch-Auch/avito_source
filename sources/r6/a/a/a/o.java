package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class o implements Callable<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ AsyncFlowable.w b;

    public o(AsyncFlowable.w wVar, Object obj) {
        this.b = wVar;
        this.a = obj;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.b.a.accept(this.a);
        return AnyValue.INSTANCE;
    }
}
