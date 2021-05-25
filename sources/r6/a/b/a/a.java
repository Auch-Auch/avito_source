package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AnyValue;
import hu.akarnokd.rxjava3.async.AsyncFlowable;
import io.reactivex.rxjava3.functions.Supplier;
public class a implements Supplier<Object> {
    public final /* synthetic */ AsyncFlowable.k a;

    public a(AsyncFlowable.k kVar) {
        this.a = kVar;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Throwable {
        this.a.a.run();
        return AnyValue.INSTANCE;
    }
}
