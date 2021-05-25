package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableSubscribeOn<T> extends s6.a.e.d.c.a.a<T, T> {
    public final Scheduler b;
    public final boolean c;

    public static final class a<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        public final Subscriber<? super T> a;
        public final Scheduler.Worker b;
        public final AtomicReference<Subscription> c = new AtomicReference<>();
        public final AtomicLong d = new AtomicLong();
        public final boolean e;
        public Publisher<T> f;

        /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableSubscribeOn$a$a  reason: collision with other inner class name */
        public static final class RunnableC0453a implements Runnable {
            public final Subscription a;
            public final long b;

            public RunnableC0453a(Subscription subscription, long j) {
                this.a = subscription;
                this.b = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.request(this.b);
            }
        }

        public a(Subscriber<? super T> subscriber, Scheduler.Worker worker, Publisher<T> publisher, boolean z) {
            this.a = subscriber;
            this.b = worker;
            this.f = publisher;
            this.e = !z;
        }

        public void a(long j, Subscription subscription) {
            if (this.e || Thread.currentThread() == get()) {
                subscription.request(j);
            } else {
                this.b.schedule(new RunnableC0453a(subscription, j));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.c);
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.c, subscription)) {
                long andSet = this.d.getAndSet(0);
                if (andSet != 0) {
                    a(andSet, subscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                Subscription subscription = this.c.get();
                if (subscription != null) {
                    a(j, subscription);
                    return;
                }
                BackpressureHelper.add(this.d, j);
                Subscription subscription2 = this.c.get();
                if (subscription2 != null) {
                    long andSet = this.d.getAndSet(0);
                    if (andSet != 0) {
                        a(andSet, subscription2);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.f;
            this.f = null;
            publisher.subscribe(this);
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z) {
        super(flowable);
        this.b = scheduler;
        this.c = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.b.createWorker();
        a aVar = new a(subscriber, createWorker, this.source, this.c);
        subscriber.onSubscribe(aVar);
        createWorker.schedule(aVar);
    }
}
