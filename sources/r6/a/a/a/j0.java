package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncObservable;
import java.util.concurrent.Callable;
public class j0 implements Callable<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ AsyncObservable.w b;

    public j0(AsyncObservable.w wVar, Object obj) {
        this.b = wVar;
        this.a = obj;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.b.a.accept(this.a);
        return AnyValue.INSTANCE;
    }
}
