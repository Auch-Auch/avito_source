package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import r6.a.b.b.m4;
public final class t2<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Scheduler c;

    public t2(Perhaps<T> perhaps, Scheduler scheduler) {
        this.b = perhaps;
        this.c = scheduler;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.c.createWorker();
        m4.a aVar = new m4.a(subscriber, createWorker, this.b);
        subscriber.onSubscribe(aVar);
        DisposableHelper.replace(aVar.c, createWorker.schedule(aVar));
    }
}
