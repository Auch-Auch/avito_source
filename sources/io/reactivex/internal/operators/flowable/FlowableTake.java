package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableTake<T> extends s6.a.c.b.a.a<T, T> {
    public final long b;

    public static final class a<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5636543848937116287L;
        public final Subscriber<? super T> a;
        public final long b;
        public boolean c;
        public Subscription d;
        public long e;

        public a(Subscriber<? super T> subscriber, long j) {
            this.a = subscriber;
            this.b = j;
            this.e = j;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.c) {
                this.c = true;
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.c) {
                this.c = true;
                this.d.cancel();
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.c) {
                long j = this.e;
                long j2 = j - 1;
                this.e = j2;
                if (j > 0) {
                    boolean z = j2 == 0;
                    this.a.onNext(t);
                    if (z) {
                        this.d.cancel();
                        onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                if (this.b == 0) {
                    subscription.cancel();
                    this.c = true;
                    EmptySubscription.complete(this.a);
                    return;
                }
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (get() || !compareAndSet(false, true) || j < this.b) {
                    this.d.request(j);
                } else {
                    this.d.request(Long.MAX_VALUE);
                }
            }
        }
    }

    public FlowableTake(Flowable<T> flowable, long j) {
        super(flowable);
        this.b = j;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b));
    }
}
