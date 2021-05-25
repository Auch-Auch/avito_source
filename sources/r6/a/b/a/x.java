package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AsyncObservable;
import io.reactivex.rxjava3.functions.Supplier;
public class x implements Supplier<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ AsyncObservable.b e;

    public x(AsyncObservable.b bVar, Object obj, Object obj2, Object obj3, Object obj4) {
        this.e = bVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public R get() throws Throwable {
        return (R) this.e.a.apply(this.a, this.b, this.c, this.d);
    }
}
