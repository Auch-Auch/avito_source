package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class r extends Flowable<Long> {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final Scheduler e;

    public static final class a extends AtomicInteger implements Subscription, Runnable {
        private static final long serialVersionUID = -3871976901922172519L;
        public final Subscriber<? super Long> a;
        public final SequentialDisposable b = new SequentialDisposable();
        public final AtomicLong c = new AtomicLong();
        public final AtomicLong d = new AtomicLong(-1);
        public long e;

        public a(Subscriber<? super Long> subscriber) {
            this.a = subscriber;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                SequentialDisposable sequentialDisposable = this.b;
                AtomicLong atomicLong = this.d;
                long j = this.e;
                Subscriber<? super Long> subscriber = this.a;
                do {
                    long j2 = this.c.get();
                    while (j != j2) {
                        if (!sequentialDisposable.isDisposed()) {
                            if (atomicLong.get() < j) {
                                break;
                            }
                            subscriber.onNext(Long.valueOf(j));
                            j++;
                        } else {
                            return;
                        }
                    }
                    if (!sequentialDisposable.isDisposed()) {
                        this.e = j;
                        i = addAndGet(-i);
                    } else {
                        return;
                    }
                } while (i != 0);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.c, j);
                a();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.d.getAndIncrement();
            a();
        }
    }

    public r(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.e = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        aVar.b.replace(this.e.schedulePeriodicallyDirect(aVar, this.b, this.c, this.d));
    }
}
