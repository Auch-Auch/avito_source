package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableSkipUntil<T, U> extends s6.a.c.b.a.a<T, T> {
    public final Publisher<U> b;

    public static final class a<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6270983465606289181L;
        public final Subscriber<? super T> a;
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final AtomicLong c = new AtomicLong();
        public final a<T>.C0388a d = new C0388a();
        public final AtomicThrowable e = new AtomicThrowable();
        public volatile boolean f;

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableSkipUntil$a$a  reason: collision with other inner class name */
        public final class C0388a extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            public C0388a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a.this.f = true;
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                SubscriptionHelper.cancel(a.this.b);
                a aVar = a.this;
                HalfSerializer.onError(aVar.a, th, aVar, aVar.e);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                a.this.f = true;
                ((Subscription) get()).cancel();
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public a(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.b);
            SubscriptionHelper.cancel(this.d);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.d);
            HalfSerializer.onComplete(this.a, this, this.e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.d);
            HalfSerializer.onError(this.a, th, this, this.e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.b.get().request(1);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.b, this.c, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.b, this.c, j);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (!this.f) {
                return false;
            }
            HalfSerializer.onNext(this.a, t, this, this.e);
            return true;
        }
    }

    public FlowableSkipUntil(Flowable<T> flowable, Publisher<U> publisher) {
        super(flowable);
        this.b = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        this.b.subscribe(aVar.d);
        this.source.subscribe((FlowableSubscriber) aVar);
    }
}
