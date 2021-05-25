package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableRepeatWhen<T> extends s6.a.e.d.c.a.a<T, T> {
    public final Function<? super Flowable<Object>, ? extends Publisher<?>> b;

    public static final class a<T> extends c<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        public a(Subscriber<? super T> subscriber, FlowableProcessor<Object> flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            e(0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.j.cancel();
            this.h.onError(th);
        }
    }

    public static final class b<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
        private static final long serialVersionUID = 2827772011130406689L;
        public final Publisher<T> a;
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final AtomicLong c = new AtomicLong();
        public c<T, U> d;

        public b(Publisher<T> publisher) {
            this.a = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.b);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.d.cancel();
            this.d.h.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.d.cancel();
            this.d.h.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (this.b.get() != SubscriptionHelper.CANCELLED) {
                    this.a.subscribe(this.d);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.b, this.c, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.b, this.c, j);
        }
    }

    public static abstract class c<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        public final Subscriber<? super T> h;
        public final FlowableProcessor<U> i;
        public final Subscription j;
        public long k;

        public c(Subscriber<? super T> subscriber, FlowableProcessor<U> flowableProcessor, Subscription subscription) {
            super(false);
            this.h = subscriber;
            this.i = flowableProcessor;
            this.j = subscription;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public final void cancel() {
            super.cancel();
            this.j.cancel();
        }

        public final void e(U u) {
            setSubscription(EmptySubscription.INSTANCE);
            long j2 = this.k;
            if (j2 != 0) {
                this.k = 0;
                produced(j2);
            }
            this.j.request(1);
            this.i.onNext(u);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.k++;
            this.h.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableRepeatWhen(Flowable<T> flowable, Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        super(flowable);
        this.b = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor<T> serialized = UnicastProcessor.create(8).toSerialized();
        try {
            Object apply = this.b.apply(serialized);
            Objects.requireNonNull(apply, "handler returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            b bVar = new b(this.source);
            a aVar = new a(serializedSubscriber, serialized, bVar);
            bVar.d = aVar;
            subscriber.onSubscribe(aVar);
            publisher.subscribe(bVar);
            bVar.onNext(0);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
