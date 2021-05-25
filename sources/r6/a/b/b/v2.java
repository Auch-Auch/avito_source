package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class v2<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Publisher<?> c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = 8414575379623209938L;
        public final AtomicBoolean a = new AtomicBoolean();
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final a<T>.C0629a c = new C0629a();

        /* renamed from: r6.a.b.b.v2$a$a  reason: collision with other inner class name */
        public final class C0629a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = 8999579172944042558L;

            public C0629a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a.this.d();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a aVar = a.this;
                if (aVar.a.compareAndSet(false, true)) {
                    SubscriptionHelper.cancel(aVar.b);
                    aVar.downstream.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                ((Subscription) get()).cancel();
                a.this.d();
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            SubscriptionHelper.cancel(this.b);
            SubscriptionHelper.cancel(this.c);
        }

        public void d() {
            if (this.a.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.b);
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.a.get() && this.a.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.c);
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.a.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.c);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.a.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.c);
                complete(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.b, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public v2(Perhaps<T> perhaps, Publisher<?> publisher) {
        this.b = perhaps;
        this.c = publisher;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.c);
        this.b.subscribe(aVar);
    }
}
