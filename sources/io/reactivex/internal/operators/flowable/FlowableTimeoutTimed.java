package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableTimeoutTimed<T> extends s6.a.c.b.a.a<T, T> {
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;
    public final Publisher<? extends T> e;

    public static final class a<T> implements FlowableSubscriber<T> {
        public final Subscriber<? super T> a;
        public final SubscriptionArbiter b;

        public a(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
            this.a = subscriber;
            this.b = subscriptionArbiter;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.b.setSubscription(subscription);
        }
    }

    public static final class b<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, d {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Subscriber<? super T> h;
        public final long i;
        public final TimeUnit j;
        public final Scheduler.Worker k;
        public final SequentialDisposable l = new SequentialDisposable();
        public final AtomicReference<Subscription> m = new AtomicReference<>();
        public final AtomicLong n = new AtomicLong();
        public long o;
        public Publisher<? extends T> p;

        public b(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler.Worker worker, Publisher<? extends T> publisher) {
            super(true);
            this.h = subscriber;
            this.i = j2;
            this.j = timeUnit;
            this.k = worker;
            this.p = publisher;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.d
        public void b(long j2) {
            if (this.n.compareAndSet(j2, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.m);
                long j3 = this.o;
                if (j3 != 0) {
                    produced(j3);
                }
                Publisher<? extends T> publisher = this.p;
                this.p = null;
                publisher.subscribe(new a(this.h, this));
                this.k.dispose();
            }
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.k.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.l.dispose();
                this.h.onComplete();
                this.k.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.l.dispose();
                this.h.onError(th);
                this.k.dispose();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j2 = this.n.get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 + 1;
                if (this.n.compareAndSet(j2, j3)) {
                    ((Disposable) this.l.get()).dispose();
                    this.o++;
                    this.h.onNext(t);
                    this.l.replace(this.k.schedule(new e(j3, this), this.i, this.j));
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.m, subscription)) {
                setSubscription(subscription);
            }
        }
    }

    public static final class c<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, d {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Subscriber<? super T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler.Worker d;
        public final SequentialDisposable e = new SequentialDisposable();
        public final AtomicReference<Subscription> f = new AtomicReference<>();
        public final AtomicLong g = new AtomicLong();

        public c(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.d
        public void b(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f);
                this.a.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.b, this.c)));
                this.d.dispose();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.f);
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.a.onComplete();
                this.d.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.a.onError(th);
                this.d.dispose();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    ((Disposable) this.e.get()).dispose();
                    this.a.onNext(t);
                    this.e.replace(this.d.schedule(new e(j2, this), this.b, this.c));
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f, this.g, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.f, this.g, j);
        }
    }

    public interface d {
        void b(long j);
    }

    public static final class e implements Runnable {
        public final d a;
        public final long b;

        public e(long j, d dVar) {
            this.b = j;
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    public FlowableTimeoutTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        super(flowable);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.e == null) {
            c cVar = new c(subscriber, this.b, this.c, this.d.createWorker());
            subscriber.onSubscribe(cVar);
            cVar.e.replace(cVar.d.schedule(new e(0, cVar), cVar.b, cVar.c));
            this.source.subscribe((FlowableSubscriber) cVar);
            return;
        }
        b bVar = new b(subscriber, this.b, this.c, this.d.createWorker(), this.e);
        subscriber.onSubscribe(bVar);
        bVar.l.replace(bVar.k.schedule(new e(0, bVar), bVar.i, bVar.j));
        this.source.subscribe((FlowableSubscriber) bVar);
    }
}
