package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class a1 extends Nono {
    public final Nono b;
    public final Publisher<?> c;

    public static final class a extends e<Void, Subscription> implements Subscriber<Void> {
        private static final long serialVersionUID = 5812459132190733401L;
        public final Subscriber<? super Void> a;
        public final AtomicBoolean b = new AtomicBoolean();
        public final C0602a c = new C0602a();

        /* renamed from: r6.a.b.b.a1$a$a  reason: collision with other inner class name */
        public final class C0602a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = 9056087023210091030L;

            public C0602a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a aVar = a.this;
                if (aVar.b.compareAndSet(false, true)) {
                    SubscriptionHelper.cancel(aVar);
                    aVar.a.onComplete();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a aVar = a.this;
                if (aVar.b.compareAndSet(false, true)) {
                    SubscriptionHelper.cancel(aVar);
                    aVar.a.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                ((Subscription) get()).cancel();
                a aVar = a.this;
                if (aVar.b.compareAndSet(false, true)) {
                    SubscriptionHelper.cancel(aVar);
                    aVar.a.onComplete();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super Void> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
            SubscriptionHelper.cancel(this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.b.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.c);
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.b.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.c);
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
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

    public a1(Nono nono, Publisher<?> publisher) {
        this.b = nono;
        this.c = publisher;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.c);
        this.b.subscribe(aVar);
    }
}
