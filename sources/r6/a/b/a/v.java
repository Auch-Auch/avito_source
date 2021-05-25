package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AnyValue;
import hu.akarnokd.rxjava3.async.AsyncObservable;
import io.reactivex.rxjava3.functions.Supplier;
public class v implements Supplier<Object> {
    public final /* synthetic */ AsyncObservable.k a;

    public v(AsyncObservable.k kVar) {
        this.a = kVar;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Throwable {
        this.a.a.run();
        return AnyValue.INSTANCE;
    }
}
