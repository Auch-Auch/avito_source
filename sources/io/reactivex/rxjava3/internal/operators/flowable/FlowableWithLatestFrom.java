package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableWithLatestFrom<T, U, R> extends s6.a.e.d.c.a.a<T, R> {
    public final BiFunction<? super T, ? super U, ? extends R> b;
    public final Publisher<? extends U> c;

    public final class a implements FlowableSubscriber<U> {
        public final b<T, U, R> a;

        public a(FlowableWithLatestFrom flowableWithLatestFrom, b<T, U, R> bVar) {
            this.a = bVar;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            b<T, U, R> bVar = this.a;
            SubscriptionHelper.cancel(bVar.c);
            bVar.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            this.a.lazySet(u);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.a.e, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public static final class b<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -312246233408980075L;
        public final Subscriber<? super R> a;
        public final BiFunction<? super T, ? super U, ? extends R> b;
        public final AtomicReference<Subscription> c = new AtomicReference<>();
        public final AtomicLong d = new AtomicLong();
        public final AtomicReference<Subscription> e = new AtomicReference<>();

        public b(Subscriber<? super R> subscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.a = subscriber;
            this.b = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.c);
            SubscriptionHelper.cancel(this.e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.e);
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.e);
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.c.get().request(1);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.c, this.d, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.c, this.d, j);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    Object apply = this.b.apply(t, obj);
                    Objects.requireNonNull(apply, "The combiner returned a null value");
                    this.a.onNext(apply);
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    this.a.onError(th);
                }
            }
            return false;
        }
    }

    public FlowableWithLatestFrom(Flowable<T> flowable, BiFunction<? super T, ? super U, ? extends R> biFunction, Publisher<? extends U> publisher) {
        super(flowable);
        this.b = biFunction;
        this.c = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        b bVar = new b(serializedSubscriber, this.b);
        serializedSubscriber.onSubscribe(bVar);
        this.c.subscribe(new a(this, bVar));
        this.source.subscribe((FlowableSubscriber) bVar);
    }
}
