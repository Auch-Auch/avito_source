package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AnyValue;
import hu.akarnokd.rxjava3.async.AsyncFlowable;
import io.reactivex.rxjava3.functions.Supplier;
public class n implements Supplier<Object> {
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ AsyncFlowable.n b;

    public n(AsyncFlowable.n nVar, Object[] objArr) {
        this.b = nVar;
        this.a = objArr;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Throwable {
        this.b.a.accept(this.a);
        return AnyValue.INSTANCE;
    }
}
