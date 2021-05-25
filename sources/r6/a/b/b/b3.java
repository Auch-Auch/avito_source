package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.core.Scheduler;
import org.reactivestreams.Subscriber;
import r6.a.b.b.t4;
public final class b3<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Scheduler c;

    public b3(Perhaps<T> perhaps, Scheduler scheduler) {
        this.b = perhaps;
        this.c = scheduler;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new t4.a(subscriber, this.c));
    }
}
