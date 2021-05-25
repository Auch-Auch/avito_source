package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AnyValue;
import hu.akarnokd.rxjava3.async.AsyncFlowable;
import io.reactivex.rxjava3.functions.Supplier;
public class r implements Supplier<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ AsyncFlowable.a0 c;

    public r(AsyncFlowable.a0 a0Var, Object obj, Object obj2) {
        this.c = a0Var;
        this.a = obj;
        this.b = obj2;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Throwable {
        this.c.a.accept(this.a, this.b);
        return AnyValue.INSTANCE;
    }
}
