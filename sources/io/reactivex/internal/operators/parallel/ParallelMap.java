package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class ParallelMap<T, R> extends ParallelFlowable<R> {
    public final ParallelFlowable<T> a;
    public final Function<? super T, ? extends R> b;

    public static final class a<T, R> implements ConditionalSubscriber<T>, Subscription {
        public final ConditionalSubscriber<? super R> a;
        public final Function<? super T, ? extends R> b;
        public Subscription c;
        public boolean d;

        public a(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function) {
            this.a = conditionalSubscriber;
            this.b = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.d) {
                this.d = true;
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.d) {
                try {
                    this.a.onNext(ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null value"));
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

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.d) {
                return false;
            }
            try {
                return this.a.tryOnNext(ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.c.cancel();
                onError(th);
                return false;
            }
        }
    }

    public static final class b<T, R> implements FlowableSubscriber<T>, Subscription {
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends R> b;
        public Subscription c;
        public boolean d;

        public b(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function) {
            this.a = subscriber;
            this.b = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.d) {
                this.d = true;
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.d) {
                try {
                    this.a.onNext(ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null value"));
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

    public ParallelMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function) {
        this.a = parallelFlowable;
        this.b = function;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber<? super R> subscriber = subscriberArr[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new a((ConditionalSubscriber) subscriber, this.b);
                } else {
                    subscriberArr2[i] = new b(subscriber, this.b);
                }
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
