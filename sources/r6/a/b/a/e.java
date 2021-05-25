package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AsyncFlowable;
import io.reactivex.rxjava3.functions.Supplier;
public class e implements Supplier<R> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ AsyncFlowable.d f;

    public e(AsyncFlowable.d dVar, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.f = dVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
        this.e = obj5;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public R get() throws Throwable {
        return (R) this.f.a.apply(this.a, this.b, this.c, this.d, this.e);
    }
}
