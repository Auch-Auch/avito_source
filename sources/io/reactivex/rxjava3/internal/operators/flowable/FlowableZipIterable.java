package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableZipIterable<T, U, V> extends s6.a.e.d.c.a.a<T, V> {
    public final Iterable<U> b;
    public final BiFunction<? super T, ? super U, ? extends V> c;

    public static final class a<T, U, V> implements FlowableSubscriber<T>, Subscription {
        public final Subscriber<? super V> a;
        public final Iterator<U> b;
        public final BiFunction<? super T, ? super U, ? extends V> c;
        public Subscription d;
        public boolean e;

        public a(Subscriber<? super V> subscriber, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.a = subscriber;
            this.b = it;
            this.c = biFunction;
        }

        public void a(Throwable th) {
            Exceptions.throwIfFatal(th);
            this.e = true;
            this.d.cancel();
            this.a.onError(th);
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
            if (!this.e) {
                try {
                    U next = this.b.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    try {
                        Object apply = this.c.apply(t, next);
                        Objects.requireNonNull(apply, "The zipper function returned a null value");
                        this.a.onNext(apply);
                        try {
                            if (!this.b.hasNext()) {
                                this.e = true;
                                this.d.cancel();
                                this.a.onComplete();
                            }
                        } catch (Throwable th) {
                            a(th);
                        }
                    } catch (Throwable th2) {
                        a(th2);
                    }
                } catch (Throwable th3) {
                    a(th3);
                }
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
    }

    public FlowableZipIterable(Flowable<T> flowable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        super(flowable);
        this.b = iterable;
        this.c = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super V> subscriber) {
        try {
            Iterator<U> it = this.b.iterator();
            Objects.requireNonNull(it, "The iterator returned by other is null");
            Iterator<U> it2 = it;
            try {
                if (!it2.hasNext()) {
                    EmptySubscription.complete(subscriber);
                } else {
                    this.source.subscribe((FlowableSubscriber) new a(subscriber, it2, this.c));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
