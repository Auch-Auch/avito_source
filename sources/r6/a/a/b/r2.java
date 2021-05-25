package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class r2<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Function<? super Flowable<Throwable>, ? extends Publisher<?>> c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -1726278593241855499L;
        public final AtomicInteger a = new AtomicInteger();
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final Perhaps<T> c;
        public final FlowableProcessor<Throwable> d;
        public final a<T>.C0572a e = new C0572a();
        public final AtomicBoolean f = new AtomicBoolean();
        public volatile boolean g;

        /* renamed from: r6.a.a.b.r2$a$a  reason: collision with other inner class name */
        public final class C0572a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = -790600520757208416L;
            public final AtomicLong a = new AtomicLong();

            public C0572a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a.this.d();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.h(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                a.this.i();
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.deferredSetOnce(this, this.a, subscription);
            }
        }

        public a(Subscriber<? super T> subscriber, FlowableProcessor<Throwable> flowableProcessor, Perhaps<T> perhaps) {
            super(subscriber);
            this.d = flowableProcessor;
            this.c = perhaps;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            SubscriptionHelper.cancel(this.b);
            SubscriptionHelper.cancel(this.e);
        }

        public void d() {
            SubscriptionHelper.cancel(this.b);
            if (this.f.compareAndSet(false, true)) {
                this.actual.onError(new NoSuchElementException());
            }
        }

        public void h(Throwable th) {
            SubscriptionHelper.cancel(this.b);
            if (this.f.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        public void i() {
            if (this.a.getAndIncrement() == 0) {
                while (!SubscriptionHelper.isCancelled(this.b.get())) {
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
            a<T>.C0572a aVar = this.e;
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

    public r2(Perhaps<T> perhaps, Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        this.b = perhaps;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        FlowableProcessor<T> serialized = PublishProcessor.create().toSerialized();
        try {
            Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.c.apply(serialized), "The handler returned a null Publisher");
            a aVar = new a(subscriber, serialized, this.b);
            subscriber.onSubscribe(aVar);
            publisher.subscribe(aVar.e);
            aVar.i();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
