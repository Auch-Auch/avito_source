package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AsyncFlowable;
import io.reactivex.rxjava3.functions.Supplier;
public class q implements Supplier<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ AsyncFlowable.z b;

    public q(AsyncFlowable.z zVar, Object obj) {
        this.b = zVar;
        this.a = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public R get() throws Throwable {
        return (R) this.b.a.apply(this.a);
    }
}
