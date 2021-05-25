package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.functions.Action;
import org.reactivestreams.Subscriber;
import r6.a.a.b.n3;
public final class q1<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Action c;

    public q1(Perhaps<T> perhaps, Action action) {
        this.b = perhaps;
        this.c = action;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new n3.a(subscriber, this.c));
    }
}
