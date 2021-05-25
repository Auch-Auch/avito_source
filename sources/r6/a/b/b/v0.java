package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.PublishProcessor;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class v0 extends Nono {
    public final Nono b;
    public final Function<? super Flowable<Object>, ? extends Publisher<?>> c;

    public static final class a extends AtomicReference<Subscription> implements Subscriber<Object>, Subscription {
        private static final long serialVersionUID = 3973630610536953229L;
        public final b a;
        public final AtomicLong b = new AtomicLong();

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            this.a.c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.b, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.b, j);
        }
    }

    public interface b {
        void a(Throwable th);

        void b();

        void c();
    }

    public static final class c extends b implements Subscriber<Void>, b {
        private static final long serialVersionUID = 6463015514357680572L;
        public final Subscriber<? super Void> a;
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final a c = new a(this);
        public final AtomicBoolean d = new AtomicBoolean();
        public final FlowableProcessor<Object> e;
        public final Nono f;
        public volatile boolean g;

        public c(Subscriber<? super Void> subscriber, FlowableProcessor<Object> flowableProcessor, Nono nono) {
            this.a = subscriber;
            this.e = flowableProcessor;
            this.f = nono;
        }

        @Override // r6.a.b.b.v0.b
        public void a(Throwable th) {
            SubscriptionHelper.cancel(this.b);
            if (this.d.compareAndSet(false, true)) {
                this.a.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // r6.a.b.b.v0.b
        public void b() {
            SubscriptionHelper.cancel(this.b);
            if (this.d.compareAndSet(false, true)) {
                this.a.onComplete();
            }
        }

        @Override // r6.a.b.b.v0.b
        public void c() {
            this.f.subscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.b);
            a aVar = this.c;
            Objects.requireNonNull(aVar);
            SubscriptionHelper.cancel(aVar);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.g = false;
            if (getAndIncrement() == 0) {
                while (SubscriptionHelper.CANCELLED != this.b.get()) {
                    if (!this.g) {
                        this.g = true;
                        a aVar = this.c;
                        SubscriptionHelper.deferredRequest(aVar, aVar.b, 1);
                        this.e.onNext(0);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            a aVar = this.c;
            Objects.requireNonNull(aVar);
            SubscriptionHelper.cancel(aVar);
            if (this.d.compareAndSet(false, true)) {
                this.a.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Void r1) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.b, subscription);
        }
    }

    public v0(Nono nono, Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        this.b = nono;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        FlowableProcessor serialized = PublishProcessor.create().toSerialized();
        try {
            Publisher publisher = (Publisher) this.c.apply(serialized);
            c cVar = new c(subscriber, serialized, this.b);
            subscriber.onSubscribe(cVar);
            publisher.subscribe(cVar.c);
            this.b.subscribe(cVar);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
