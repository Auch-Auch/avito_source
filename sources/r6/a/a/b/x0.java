package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import r6.a.a.b.v0;
public final class x0 extends Nono {
    public final Nono b;
    public final Function<? super Flowable<Throwable>, ? extends Publisher<?>> c;

    public static final class a extends b implements Subscriber<Void>, v0.b {
        private static final long serialVersionUID = 6463015514357680572L;
        public final Subscriber<? super Void> a;
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final v0.a c = new v0.a(this);
        public final AtomicBoolean d = new AtomicBoolean();
        public final FlowableProcessor<Throwable> e;
        public final Nono f;
        public volatile boolean g;

        public a(Subscriber<? super Void> subscriber, FlowableProcessor<Throwable> flowableProcessor, Nono nono) {
            this.a = subscriber;
            this.e = flowableProcessor;
            this.f = nono;
        }

        @Override // r6.a.a.b.v0.b
        public void a(Throwable th) {
            SubscriptionHelper.cancel(this.b);
            if (this.d.compareAndSet(false, true)) {
                this.a.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // r6.a.a.b.v0.b
        public void b() {
            SubscriptionHelper.cancel(this.b);
            if (this.d.compareAndSet(false, true)) {
                this.a.onComplete();
            }
        }

        @Override // r6.a.a.b.v0.b
        public void c() {
            this.f.subscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.b);
            v0.a aVar = this.c;
            Objects.requireNonNull(aVar);
            SubscriptionHelper.cancel(aVar);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            v0.a aVar = this.c;
            Objects.requireNonNull(aVar);
            SubscriptionHelper.cancel(aVar);
            if (this.d.compareAndSet(false, true)) {
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.g = false;
            if (getAndIncrement() == 0) {
                while (!SubscriptionHelper.isCancelled(this.b.get())) {
                    if (!this.g) {
                        this.g = true;
                        v0.a aVar = this.c;
                        SubscriptionHelper.deferredRequest(aVar, aVar.b, 1);
                        this.e.onNext(th);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Void r1) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.replace(this.b, subscription);
        }
    }

    public x0(Nono nono, Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        this.b = nono;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        FlowableProcessor serialized = PublishProcessor.create().toSerialized();
        try {
            Publisher publisher = (Publisher) this.c.apply(serialized);
            a aVar = new a(subscriber, serialized, this.b);
            subscriber.onSubscribe(aVar);
            publisher.subscribe(aVar.c);
            this.b.subscribe(aVar);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
