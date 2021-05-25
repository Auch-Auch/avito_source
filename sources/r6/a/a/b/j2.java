package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.functions.Function;
import org.reactivestreams.Subscriber;
import r6.a.a.b.c4;
public final class j2<T, R> extends Perhaps<R> {
    public final Perhaps<T> b;
    public final Function<? super T, ? extends R> c;

    public j2(Perhaps<T> perhaps, Function<? super T, ? extends R> function) {
        this.b = perhaps;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new c4.a(subscriber, this.c));
    }
}
