package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncObservable;
import java.util.concurrent.Callable;
public class h0 implements Callable<Object> {
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ AsyncObservable.m b;

    public h0(AsyncObservable.m mVar, Object[] objArr) {
        this.b = mVar;
        this.a = objArr;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.b.a.accept(this.a);
        return AnyValue.INSTANCE;
    }
}
