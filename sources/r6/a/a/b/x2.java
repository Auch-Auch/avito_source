package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.Scheduler;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import r6.a.a.b.p4;
public final class x2 extends Perhaps<Long> {
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;

    public x2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        p4.a aVar = new p4.a(subscriber);
        subscriber.onSubscribe(aVar);
        DisposableHelper.replace(aVar.a, this.d.scheduleDirect(aVar, this.b, this.c));
    }
}
