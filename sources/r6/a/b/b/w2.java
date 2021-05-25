package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class w2<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Publisher<?> c;
    public final Perhaps<? extends T> d;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -2613153829201889588L;
        public final AtomicReference<Subscription> a = new AtomicReference<>();
        public final Perhaps<? extends T> b;
        public final a<T>.b c;
        public final a<T>.C0632a d;
        public final AtomicBoolean e;

        /* renamed from: r6.a.b.b.w2$a$a  reason: collision with other inner class name */
        public final class C0632a extends AtomicReference<Subscription> implements Subscriber<T> {
            private static final long serialVersionUID = -1360947483517311225L;
            public T a;

            public C0632a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                T t = this.a;
                this.a = null;
                a aVar = a.this;
                if (t != null) {
                    aVar.complete(t);
                } else {
                    aVar.downstream.onComplete();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.downstream.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                this.a = t;
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public final class b extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = -8725214806550415150L;
            public boolean a;

            public b() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (!this.a) {
                    this.a = true;
                    a.this.d();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (!this.a) {
                    this.a = true;
                    a aVar = a.this;
                    if (aVar.e.compareAndSet(false, true)) {
                        SubscriptionHelper.cancel(aVar.a);
                        aVar.downstream.onError(th);
                        return;
                    }
                    RxJavaPlugins.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                if (!this.a) {
                    this.a = true;
                    ((Subscription) get()).cancel();
                    a.this.d();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super T> subscriber, Perhaps<? extends T> perhaps) {
            super(subscriber);
            this.b = perhaps;
            this.e = new AtomicBoolean();
            this.c = new b();
            this.d = perhaps != null ? new C0632a() : null;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            SubscriptionHelper.cancel(this.a);
            SubscriptionHelper.cancel(this.c);
            a<T>.C0632a aVar = this.d;
            if (aVar != null) {
                SubscriptionHelper.cancel(aVar);
            }
        }

        public void d() {
            SubscriptionHelper.cancel(this.a);
            if (this.e.compareAndSet(false, true)) {
                Perhaps<? extends T> perhaps = this.b;
                if (perhaps != null) {
                    perhaps.subscribe(this.d);
                } else {
                    this.downstream.onError(new TimeoutException());
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.e.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.c);
                T t = this.value;
                if (t != null) {
                    complete(t);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.e.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.c);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.value = t;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.a, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public w2(Perhaps<T> perhaps, Publisher<?> publisher, Perhaps<? extends T> perhaps2) {
        this.b = perhaps;
        this.c = publisher;
        this.d = perhaps2;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.d);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.c);
        this.b.subscribe(aVar);
    }
}
