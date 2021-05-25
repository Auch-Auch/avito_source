package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class a implements Callable<Object> {
    public final /* synthetic */ AsyncFlowable.k a;

    public a(AsyncFlowable.k kVar) {
        this.a = kVar;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.a.a.run();
        return AnyValue.INSTANCE;
    }
}
