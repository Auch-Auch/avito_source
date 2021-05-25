package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableTake<T> extends s6.a.e.d.c.a.a<T, T> {
    public final long b;

    public static final class a<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2288246011222124525L;
        public final Subscriber<? super T> a;
        public long b;
        public Subscription c;

        public a(Subscriber<? super T> subscriber, long j) {
            this.a = subscriber;
            this.b = j;
            lazySet(j);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.b > 0) {
                this.b = 0;
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.b > 0) {
                this.b = 0;
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.b;
            if (j > 0) {
                long j2 = j - 1;
                this.b = j2;
                this.a.onNext(t);
                if (j2 == 0) {
                    this.c.cancel();
                    this.a.onComplete();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (!SubscriptionHelper.validate(this.c, subscription)) {
                return;
            }
            if (this.b == 0) {
                subscription.cancel();
                EmptySubscription.complete(this.a);
                return;
            }
            this.c = subscription;
            this.a.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            long j2;
            long min;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != 0) {
                        min = Math.min(j2, j);
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j2 - min));
                this.c.request(min);
            }
        }
    }

    public FlowableTake(Flowable<T> flowable, long j) {
        super(flowable);
        this.b = j;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b));
    }
}
