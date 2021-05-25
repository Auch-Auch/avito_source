package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class a0<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Flowable<T> b;
    public final Publisher<?> c;

    public static final class a<T> implements FlowableSubscriber<T>, Subscription {
        public final Subscriber<? super T> a;
        public final AtomicLong b = new AtomicLong();
        public final AtomicLong c = new AtomicLong();
        public final AtomicReference<Subscription> d = new AtomicReference<>();
        public final C0641a e = new C0641a(this);
        public final AtomicInteger f = new AtomicInteger();
        public final AtomicThrowable g = new AtomicThrowable();
        public long h;
        public boolean i;

        /* renamed from: r6.a.b.i.a0$a$a  reason: collision with other inner class name */
        public static final class C0641a extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -9069889200779269650L;
            public final a<?> a;

            public C0641a(a<?> aVar) {
                this.a = aVar;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a<?> aVar = this.a;
                SubscriptionHelper.cancel(aVar.d);
                HalfSerializer.onComplete(aVar.a, aVar.f, aVar.g);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a<?> aVar = this.a;
                SubscriptionHelper.cancel(aVar.d);
                HalfSerializer.onError(aVar.a, th, aVar.f, aVar.g);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                a<?> aVar = this.a;
                SubscriptionHelper.deferredRequest(aVar.d, aVar.c, 1);
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.d);
            C0641a aVar = this.e;
            Objects.requireNonNull(aVar);
            SubscriptionHelper.cancel(aVar);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.i) {
                this.i = true;
                C0641a aVar = this.e;
                Objects.requireNonNull(aVar);
                SubscriptionHelper.cancel(aVar);
                HalfSerializer.onComplete(this.a, this.f, this.g);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.i) {
                this.i = true;
                C0641a aVar = this.e;
                Objects.requireNonNull(aVar);
                SubscriptionHelper.cancel(aVar);
                HalfSerializer.onError(this.a, th, this.f, this.g);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.i) {
                long j = this.h;
                if (this.b.get() != j) {
                    this.h = j + 1;
                    HalfSerializer.onNext(this.a, t, this.f, this.g);
                    return;
                }
                this.i = true;
                cancel();
                HalfSerializer.onError(this.a, new MissingBackpressureException("Downstream is not ready to receive the next upstream item."), this.f, this.g);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.d, this.c, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.b, j);
        }
    }

    public a0(Flowable<T> flowable, Publisher<?> publisher) {
        this.b = flowable;
        this.c = publisher;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new a0(flowable, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.e);
        this.b.subscribe((FlowableSubscriber) aVar);
    }
}
