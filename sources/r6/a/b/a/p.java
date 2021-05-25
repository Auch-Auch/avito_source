package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AnyValue;
import hu.akarnokd.rxjava3.async.AsyncFlowable;
import io.reactivex.rxjava3.functions.Supplier;
public class p implements Supplier<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ AsyncFlowable.y b;

    public p(AsyncFlowable.y yVar, Object obj) {
        this.b = yVar;
        this.a = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Throwable {
        this.b.a.accept(this.a);
        return AnyValue.INSTANCE;
    }
}
