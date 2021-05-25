package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncObservable;
import java.util.concurrent.Callable;
public class b0 implements Callable<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ AsyncObservable.f h;

    public b0(AsyncObservable.f fVar, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        this.h = fVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
        this.e = obj5;
        this.f = obj6;
        this.g = obj7;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.h.a.accept(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        return AnyValue.INSTANCE;
    }
}
