package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableIntervalRange extends Flowable<Long> {
    public final Scheduler b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final TimeUnit g;

    public static final class a extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public final Subscriber<? super Long> a;
        public final long b;
        public long c;
        public final AtomicReference<Disposable> d = new AtomicReference<>();

        public a(Subscriber<? super Long> subscriber, long j, long j2) {
            this.a = subscriber;
            this.c = j;
            this.b = j2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this.d);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable disposable = this.d.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                long j = get();
                if (j != 0) {
                    long j2 = this.c;
                    this.a.onNext(Long.valueOf(j2));
                    if (j2 == this.b) {
                        if (this.d.get() != disposableHelper) {
                            this.a.onComplete();
                        }
                        DisposableHelper.dispose(this.d);
                        return;
                    }
                    this.c = j2 + 1;
                    if (j != Long.MAX_VALUE) {
                        decrementAndGet();
                        return;
                    }
                    return;
                }
                this.a.onError(new MissingBackpressureException(a2.b.a.a.a.l(a2.b.a.a.a.L("Can't deliver value "), this.c, " due to lack of requests")));
                DisposableHelper.dispose(this.d);
            }
        }
    }

    public FlowableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.e = j3;
        this.f = j4;
        this.g = timeUnit;
        this.b = scheduler;
        this.c = j;
        this.d = j2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        a aVar = new a(subscriber, this.c, this.d);
        subscriber.onSubscribe(aVar);
        Scheduler scheduler = this.b;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            DisposableHelper.setOnce(aVar.d, createWorker);
            createWorker.schedulePeriodically(aVar, this.e, this.f, this.g);
            return;
        }
        DisposableHelper.setOnce(aVar.d, scheduler.schedulePeriodicallyDirect(aVar, this.e, this.f, this.g));
    }
}
