package r6.a.a.a;

import hu.akarnokd.rxjava2.async.AnyValue;
import hu.akarnokd.rxjava2.async.AsyncFlowable;
import java.util.concurrent.Callable;
public class c implements Callable<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ AsyncFlowable.b f;

    public c(AsyncFlowable.b bVar, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.f = bVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
        this.e = obj5;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.f.a.accept(this.a, this.b, this.c, this.d, this.e);
        return AnyValue.INSTANCE;
    }
}
