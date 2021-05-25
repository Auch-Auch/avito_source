package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import r6.a.b.b.p4;
public final class x2 extends Perhaps<Long> {
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;

    public x2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        p4.a aVar = new p4.a(subscriber);
        subscriber.onSubscribe(aVar);
        DisposableHelper.replace(aVar.a, this.d.scheduleDirect(aVar, this.b, this.c));
    }
}
