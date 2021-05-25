package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AnyValue;
import hu.akarnokd.rxjava3.async.AsyncObservable;
import io.reactivex.rxjava3.functions.Supplier;
public class c0 implements Supplier<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ AsyncObservable.g h;

    public c0(AsyncObservable.g gVar, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        this.h = gVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
        this.e = obj5;
        this.f = obj6;
        this.g = obj7;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Throwable {
        this.h.a.accept(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        return AnyValue.INSTANCE;
    }
}
