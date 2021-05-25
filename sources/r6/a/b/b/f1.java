package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.core.Scheduler;
import org.reactivestreams.Subscriber;
public final class f1 extends Nono {
    public final Nono b;
    public final Scheduler c;

    public static final class a extends c implements Runnable {
        public final Scheduler c;

        public a(Subscriber<? super Void> subscriber, Scheduler scheduler) {
            super(subscriber);
            this.c = scheduler;
        }

        @Override // r6.a.b.b.c, org.reactivestreams.Subscription
        public void cancel() {
            this.c.scheduleDirect(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.cancel();
        }
    }

    public f1(Nono nono, Scheduler scheduler) {
        this.b = nono;
        this.c = scheduler;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
