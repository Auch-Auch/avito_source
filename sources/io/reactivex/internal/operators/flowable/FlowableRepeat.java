package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableRepeat<T> extends s6.a.c.b.a.a<T, T> {
    public final long b;

    public static final class a<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final Subscriber<? super T> a;
        public final SubscriptionArbiter b;
        public final Publisher<? extends T> c;
        public long d;
        public long e;

        public a(Subscriber<? super T> subscriber, long j, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.a = subscriber;
            this.b = subscriptionArbiter;
            this.c = publisher;
            this.d = j;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.b.isCancelled()) {
                    long j = this.e;
                    if (j != 0) {
                        this.e = 0;
                        this.b.produced(j);
                    }
                    this.c.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long j = this.d;
            if (j != Long.MAX_VALUE) {
                this.d = j - 1;
            }
            if (j != 0) {
                a();
            } else {
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.e++;
            this.a.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.b.setSubscription(subscription);
        }
    }

    public FlowableRepeat(Flowable<T> flowable, long j) {
        super(flowable);
        this.b = j;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        long j = this.b;
        long j2 = Long.MAX_VALUE;
        if (j != Long.MAX_VALUE) {
            j2 = j - 1;
        }
        new a(subscriber, j2, subscriptionArbiter, this.source).a();
    }
}
