package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class b1 extends Nono {
    public final Nono b;
    public final Publisher<?> c;
    public final Nono d;

    public static final class a extends e<Void, Subscription> implements Subscriber<Void> {
        private static final long serialVersionUID = 5699062216456523328L;
        public final Subscriber<? super Void> a;
        public final Nono b;
        public final b c = new b();
        public final AtomicBoolean d = new AtomicBoolean();

        /* renamed from: r6.a.a.b.b1$a$a  reason: collision with other inner class name */
        public final class C0552a implements Subscriber<Void> {
            public C0552a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a.this.a.onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.a.onError(th);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // org.reactivestreams.Subscriber
            public void onNext(Void r1) {
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                SubscriptionHelper.replace(aVar, subscription);
            }
        }

        public final class b extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = -7257274632636068061L;

            public b() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                SubscriptionHelper.cancel(aVar);
                if (aVar.d.compareAndSet(false, true)) {
                    Nono nono = aVar.b;
                    if (nono == null) {
                        aVar.a.onError(new TimeoutException());
                    } else {
                        nono.subscribe(new C0552a());
                    }
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                SubscriptionHelper.cancel(aVar);
                if (aVar.d.compareAndSet(false, true)) {
                    aVar.a.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super Void> subscriber, Nono nono) {
            this.a = subscriber;
            this.b = nono;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
            SubscriptionHelper.cancel(this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.c);
            if (this.d.compareAndSet(false, true)) {
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.c);
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
            SubscriptionHelper.setOnce(this, subscription);
        }
    }

    public b1(Nono nono, Publisher<?> publisher, Nono nono2) {
        this.b = nono;
        this.c = publisher;
        this.d = nono2;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        a aVar = new a(subscriber, this.d);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.c);
        this.b.subscribe(aVar);
    }
}
