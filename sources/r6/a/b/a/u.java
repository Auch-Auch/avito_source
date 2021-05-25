package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AsyncFlowable;
import io.reactivex.rxjava3.functions.Supplier;
public class u implements Supplier<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ AsyncFlowable.d0 d;

    public u(AsyncFlowable.d0 d0Var, Object obj, Object obj2, Object obj3) {
        this.d = d0Var;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public R get() throws Throwable {
        return (R) this.d.a.apply(this.a, this.b, this.c);
    }
}
