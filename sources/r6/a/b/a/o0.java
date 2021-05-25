package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AnyValue;
import hu.akarnokd.rxjava3.async.AsyncObservable;
import io.reactivex.rxjava3.functions.Supplier;
public class o0 implements Supplier<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ AsyncObservable.c0 d;

    public o0(AsyncObservable.c0 c0Var, Object obj, Object obj2, Object obj3) {
        this.d = c0Var;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Throwable {
        this.d.a.accept(this.a, this.b, this.c);
        return AnyValue.INSTANCE;
    }
}
