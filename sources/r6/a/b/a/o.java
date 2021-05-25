package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AsyncFlowable;
import io.reactivex.rxjava3.functions.Supplier;
public class o implements Supplier<R> {
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ AsyncFlowable.o b;

    public o(AsyncFlowable.o oVar, Object[] objArr) {
        this.b = oVar;
        this.a = objArr;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public R get() throws Throwable {
        return (R) this.b.a.apply(this.a);
    }
}
