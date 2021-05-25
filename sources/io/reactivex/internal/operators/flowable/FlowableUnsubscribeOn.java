package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableUnsubscribeOn<T> extends s6.a.c.b.a.a<T, T> {
    public final Scheduler b;

    public static final class a<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1015244841293359600L;
        public final Subscriber<? super T> a;
        public final Scheduler b;
        public Subscription c;

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn$a$a  reason: collision with other inner class name */
        public final class RunnableC0391a implements Runnable {
            public RunnableC0391a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c.cancel();
            }
        }

        public a(Subscriber<? super T> subscriber, Scheduler scheduler) {
            this.a = subscriber;
            this.b = scheduler;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.b.scheduleDirect(new RunnableC0391a());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!get()) {
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.onError(th);
            } else {
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!get()) {
                this.a.onNext(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.c.request(j);
        }
    }

    public FlowableUnsubscribeOn(Flowable<T> flowable, Scheduler scheduler) {
        super(flowable);
        this.b = scheduler;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b));
    }
}
