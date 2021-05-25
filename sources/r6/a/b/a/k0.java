package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AnyValue;
import hu.akarnokd.rxjava3.async.AsyncObservable;
import io.reactivex.rxjava3.functions.Supplier;
public class k0 implements Supplier<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ AsyncObservable.y b;

    public k0(AsyncObservable.y yVar, Object obj) {
        this.b = yVar;
        this.a = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Throwable {
        this.b.a.accept(this.a);
        return AnyValue.INSTANCE;
    }
}
