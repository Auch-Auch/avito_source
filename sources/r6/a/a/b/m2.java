package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.Scheduler;
import org.reactivestreams.Subscriber;
import r6.a.a.b.f4;
public final class m2<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Scheduler c;

    public m2(Perhaps<T> perhaps, Scheduler scheduler) {
        this.b = perhaps;
        this.c = scheduler;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new f4.a(subscriber, this.c.createWorker()));
    }
}
