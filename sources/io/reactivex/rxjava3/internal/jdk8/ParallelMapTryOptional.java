package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.Optional;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class ParallelMapTryOptional<T, R> extends ParallelFlowable<R> {
    public final ParallelFlowable<T> a;
    public final Function<? super T, Optional<? extends R>> b;
    public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> c;

    public static final class a<T, R> implements ConditionalSubscriber<T>, Subscription {
        public final ConditionalSubscriber<? super R> a;
        public final Function<? super T, Optional<? extends R>> b;
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> c;
        public Subscription d;
        public boolean e;

        public a(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, Optional<? extends R>> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.a = conditionalSubscriber;
            this.b = function;
            this.c = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
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
            if (!tryOnNext(t) && !this.e) {
                this.d.request(1);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.d.request(j);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.e) {
                return false;
            }
            long j = 0;
            while (true) {
                try {
                    Optional<? extends R> apply = this.b.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null Optional");
                    Optional<? extends R> optional = apply;
                    if (!optional.isPresent() || !this.a.tryOnNext((Object) optional.get())) {
                        return false;
                    }
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.d.cancel();
                    onError(new CompositeException(th, th));
                    return false;
                }
            }
            return false;
        }
    }

    public static final class b<T, R> implements ConditionalSubscriber<T>, Subscription {
        public final Subscriber<? super R> a;
        public final Function<? super T, Optional<? extends R>> b;
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> c;
        public Subscription d;
        public boolean e;

        public b(Subscriber<? super R> subscriber, Function<? super T, Optional<? extends R>> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.a = subscriber;
            this.b = function;
            this.c = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
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
            if (!tryOnNext(t) && !this.e) {
                this.d.request(1);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.d.request(j);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.e) {
                return false;
            }
            long j = 0;
            while (true) {
                try {
                    Optional<? extends R> apply = this.b.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null Optional");
                    Optional<? extends R> optional = apply;
                    if (!optional.isPresent()) {
                        return false;
                    }
                    this.a.onNext((Object) optional.get());
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.d.cancel();
                    onError(new CompositeException(th, th));
                    return false;
                }
            }
            return false;
        }
    }

    public ParallelMapTryOptional(ParallelFlowable<T> parallelFlowable, Function<? super T, Optional<? extends R>> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.a = parallelFlowable;
        this.b = function;
        this.c = biFunction;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber<? super R> subscriber = subscriberArr[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new a((ConditionalSubscriber) subscriber, this.b, this.c);
                } else {
                    subscriberArr2[i] = new b(subscriber, this.b, this.c);
                }
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
