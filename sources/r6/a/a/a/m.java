package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class m implements Callable<Object> {
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ AsyncFlowable.m b;

    public m(AsyncFlowable.m mVar, Object[] objArr) {
        this.b = mVar;
        this.a = objArr;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.b.a.accept(this.a);
        return AnyValue.INSTANCE;
    }
}
