package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AsyncFlowable;
import io.reactivex.rxjava3.functions.Supplier;
public class s implements Supplier<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ AsyncFlowable.b0 c;

    public s(AsyncFlowable.b0 b0Var, Object obj, Object obj2) {
        this.c = b0Var;
        this.a = obj;
        this.b = obj2;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public R get() throws Throwable {
        return (R) this.c.a.apply(this.a, this.b);
    }
}
