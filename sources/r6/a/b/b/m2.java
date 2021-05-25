package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.core.Scheduler;
import org.reactivestreams.Subscriber;
import r6.a.b.b.f4;
public final class m2<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Scheduler c;

    public m2(Perhaps<T> perhaps, Scheduler scheduler) {
        this.b = perhaps;
        this.c = scheduler;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new f4.a(subscriber, this.c.createWorker()));
    }
}
