package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AsyncObservable;
import io.reactivex.rxjava3.functions.Supplier;
public class j0 implements Supplier<R> {
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ AsyncObservable.o b;

    public j0(AsyncObservable.o oVar, Object[] objArr) {
        this.b = oVar;
        this.a = objArr;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public R get() throws Throwable {
        return (R) this.b.a.apply(this.a);
    }
}
