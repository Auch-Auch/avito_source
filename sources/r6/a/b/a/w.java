package r6.a.b.a;

import hu.akarnokd.rxjava3.async.AnyValue;
import hu.akarnokd.rxjava3.async.AsyncObservable;
import io.reactivex.rxjava3.functions.Supplier;
public class w implements Supplier<Object> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ AsyncObservable.a e;

    public w(AsyncObservable.a aVar, Object obj, Object obj2, Object obj3, Object obj4) {
        this.e = aVar;
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Throwable {
        this.e.a.accept(this.a, this.b, this.c, this.d);
        return AnyValue.INSTANCE;
    }
}
