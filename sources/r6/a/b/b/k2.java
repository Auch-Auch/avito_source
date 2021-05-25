package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Subscriber;
import r6.a.b.b.d4;
public final class k2<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Function<? super Throwable, ? extends Throwable> c;

    public k2(Perhaps<T> perhaps, Function<? super Throwable, ? extends Throwable> function) {
        this.b = perhaps;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new d4.a(subscriber, this.c));
    }
}
