package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableScan<T> extends s6.a.c.b.a.a<T, T> {
    public final BiFunction<T, T, T> b;

    public static final class a<T> implements FlowableSubscriber<T>, Subscription {
        public final Subscriber<? super T> a;
        public final BiFunction<T, T, T> b;
        public Subscription c;
        public T d;
        public boolean e;

        public a(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            this.a = subscriber;
            this.b = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.e) {
                this.e = true;
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.e = true;
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.e) {
                Subscriber<? super T> subscriber = this.a;
                T t2 = this.d;
                if (t2 == null) {
                    this.d = t;
                    subscriber.onNext(t);
                    return;
                }
                try {
                    T t3 = (T) ObjectHelper.requireNonNull(this.b.apply(t2, t), "The value returned by the accumulator is null");
                    this.d = t3;
                    subscriber.onNext(t3);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.c.cancel();
                    onError(th);
                }
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

    public FlowableScan(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.b = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b));
    }
}
