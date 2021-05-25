package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableTakeLast<T> extends s6.a.e.d.c.a.a<T, T> {
    public final int b;

    public static final class a<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7240042530241604978L;
        public final Subscriber<? super T> a;
        public final int b;
        public Subscription c;
        public volatile boolean d;
        public volatile boolean e;
        public final AtomicLong f = new AtomicLong();
        public final AtomicInteger g = new AtomicInteger();

        public a(Subscriber<? super T> subscriber, int i) {
            this.a = subscriber;
            this.b = i;
        }

        public void a() {
            if (this.g.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.a;
                long j = this.f.get();
                while (!this.e) {
                    if (this.d) {
                        long j2 = 0;
                        while (j2 != j) {
                            if (!this.e) {
                                Object obj = (Object) poll();
                                if (obj == 0) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onNext(obj);
                                    j2++;
                                }
                            } else {
                                return;
                            }
                        }
                        if (isEmpty()) {
                            subscriber.onComplete();
                            return;
                        } else if (j2 != 0) {
                            j = BackpressureHelper.produced(this.f, j2);
                        }
                    }
                    if (this.g.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e = true;
            this.c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.d = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.b == size()) {
                poll();
            }
            offer(t);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.f, j);
                a();
            }
        }
    }

    public FlowableTakeLast(Flowable<T> flowable, int i) {
        super(flowable);
        this.b = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b));
    }
}
