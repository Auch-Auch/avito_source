package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AsyncObservable;
import io.reactivex.rxjava3.functions.Supplier;
public class l0 implements Supplier<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ AsyncObservable.z b;

    public l0(AsyncObservable.z zVar, Object obj) {
        this.b = zVar;
        this.a = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public R get() throws Throwable {
        return (R) this.b.a.apply(this.a);
    }
}
