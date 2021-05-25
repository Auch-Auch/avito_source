package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class e implements Callable<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ AsyncFlowable.d g;

    public e(AsyncFlowable.d dVar, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        this.g = dVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
        this.e = obj5;
        this.f = obj6;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.g.a.accept(this.a, this.b, this.c, this.d, this.e, this.f);
        return AnyValue.INSTANCE;
    }
}
