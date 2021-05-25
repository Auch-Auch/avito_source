package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncObservable;
import java.util.concurrent.Callable;
public class v implements Callable<Object> {
    public final /* synthetic */ AsyncObservable.k a;

    public v(AsyncObservable.k kVar) {
        this.a = kVar;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.a.a.run();
        return AnyValue.INSTANCE;
    }
}
