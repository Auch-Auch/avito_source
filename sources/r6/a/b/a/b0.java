package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AsyncObservable;
import io.reactivex.rxjava3.functions.Supplier;
public class b0 implements Supplier<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ AsyncObservable.f g;

    public b0(AsyncObservable.f fVar, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        this.g = fVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
        this.e = obj5;
        this.f = obj6;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public R get() throws Throwable {
        return (R) this.g.a.apply(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
