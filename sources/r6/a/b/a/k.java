package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AsyncFlowable;
import io.reactivex.rxjava3.functions.Supplier;
public class k implements Supplier<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ AsyncFlowable.j i;

    public k(AsyncFlowable.j jVar, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        this.i = jVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
        this.e = obj5;
        this.f = obj6;
        this.g = obj7;
        this.h = obj8;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public R get() throws Throwable {
        return (R) this.i.a.apply(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
