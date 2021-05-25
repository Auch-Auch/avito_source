package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableOnErrorNext<T> extends s6.a.e.d.c.a.a<T, T> {
    public final Function<? super Throwable, ? extends Publisher<? extends T>> b;

    public static final class a<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4063763155303814625L;
        public final Subscriber<? super T> h;
        public final Function<? super Throwable, ? extends Publisher<? extends T>> i;
        public boolean j;
        public boolean k;
        public long l;

        public a(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function) {
            super(false);
            this.h = subscriber;
            this.i = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.k) {
                this.k = true;
                this.j = true;
                this.h.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.j) {
                this.j = true;
                try {
                    Object apply = this.i.apply(th);
                    Objects.requireNonNull(apply, "The nextSupplier returned a null Publisher");
                    Publisher publisher = (Publisher) apply;
                    long j2 = this.l;
                    if (j2 != 0) {
                        produced(j2);
                    }
                    publisher.subscribe(this);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.h.onError(new CompositeException(th, th2));
                }
            } else if (this.k) {
                RxJavaPlugins.onError(th);
            } else {
                this.h.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.k) {
                if (!this.j) {
                    this.l++;
                }
                this.h.onNext(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableOnErrorNext(Flowable<T> flowable, Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        super(flowable);
        this.b = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.b);
        subscriber.onSubscribe(aVar);
        this.source.subscribe((FlowableSubscriber) aVar);
    }
}
