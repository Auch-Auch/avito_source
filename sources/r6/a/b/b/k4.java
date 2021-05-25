package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.PublishProcessor;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class k4<T> extends Solo<T> {
    public final Solo<T> b;
    public final Function<? super Flowable<Throwable>, ? extends Publisher<?>> c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -1726278593241855499L;
        public final AtomicInteger a = new AtomicInteger();
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final Solo<T> c;
        public final FlowableProcessor<Throwable> d;
        public final a<T>.C0610a e = new C0610a();
        public final AtomicBoolean f = new AtomicBoolean();
        public volatile boolean g;

        /* renamed from: r6.a.b.b.k4$a$a  reason: collision with other inner class name */
        public final class C0610a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = -790600520757208416L;
            public final AtomicLong a = new AtomicLong();

            public C0610a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a aVar = a.this;
                SubscriptionHelper.cancel(aVar.b);
                if (aVar.f.compareAndSet(false, true)) {
                    aVar.downstream.onError(new NoSuchElementException());
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a aVar = a.this;
                SubscriptionHelper.cancel(aVar.b);
                if (aVar.f.compareAndSet(false, true)) {
                    aVar.downstream.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                a.this.d();
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.deferredSetOnce(this, this.a, subscription);
            }
        }

        public a(Subscriber<? super T> subscriber, FlowableProcessor<Throwable> flowableProcessor, Solo<T> solo) {
            super(subscriber);
            this.d = flowableProcessor;
            this.c = solo;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            SubscriptionHelper.cancel(this.b);
            SubscriptionHelper.cancel(this.e);
        }

        public void d() {
            if (this.a.getAndIncrement() == 0) {
                while (SubscriptionHelper.CANCELLED != this.b.get()) {
                    if (!this.g) {
                        this.g = true;
                        this.c.subscribe(this);
                    }
                    if (this.a.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.e);
            if (this.f.compareAndSet(false, true)) {
                T t = this.value;
                this.value = null;
                complete(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.g = false;
            a<T>.C0610a aVar = this.e;
            SubscriptionHelper.deferredRequest(aVar, aVar.a, 1);
            this.d.onNext(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.value = t;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.replace(this.b, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public k4(Solo<T> solo, Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        this.b = solo;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        FlowableProcessor<T> serialized = PublishProcessor.create().toSerialized();
        try {
            Publisher publisher = (Publisher) this.c.apply(serialized);
            Objects.requireNonNull(publisher, "The handler returned a null Publisher");
            Publisher publisher2 = publisher;
            a aVar = new a(subscriber, serialized, this.b);
            subscriber.onSubscribe(aVar);
            publisher2.subscribe(aVar.e);
            aVar.d();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
