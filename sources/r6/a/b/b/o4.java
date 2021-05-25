package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class o4<T> extends Solo<T> {
    public final Solo<T> b;
    public final Publisher<?> c;
    public final Solo<T> d;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -2613153829201889588L;
        public final AtomicReference<Subscription> a = new AtomicReference<>();
        public final Solo<T> b;
        public final a<T>.b c;
        public final a<T>.C0620a d;
        public final AtomicBoolean e;

        /* renamed from: r6.a.b.b.o4$a$a  reason: collision with other inner class name */
        public final class C0620a extends AtomicReference<Subscription> implements Subscriber<T> {
            private static final long serialVersionUID = -1360947483517311225L;
            public T a;

            public C0620a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                T t = this.a;
                this.a = null;
                a.this.complete(t);
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
                    SubscriptionHelper.cancel(aVar.a);
                    if (aVar.e.compareAndSet(false, true)) {
                        aVar.downstream.onError(th);
                    } else {
                        RxJavaPlugins.onError(th);
                    }
                } else {
                    RxJavaPlugins.onError(th);
                }
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

        public a(Subscriber<? super T> subscriber, Solo<T> solo) {
            super(subscriber);
            this.b = solo;
            this.e = new AtomicBoolean();
            this.c = new b();
            this.d = solo != null ? new C0620a() : null;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            SubscriptionHelper.cancel(this.a);
            SubscriptionHelper.cancel(this.c);
            a<T>.C0620a aVar = this.d;
            if (aVar != null) {
                SubscriptionHelper.cancel(aVar);
            }
        }

        public void d() {
            SubscriptionHelper.cancel(this.a);
            if (this.e.compareAndSet(false, true)) {
                Solo<T> solo = this.b;
                if (solo != null) {
                    solo.subscribe(this.d);
                } else {
                    this.downstream.onError(new TimeoutException());
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.c);
            if (this.e.compareAndSet(false, true)) {
                complete(this.value);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.c);
            if (this.e.compareAndSet(false, true)) {
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
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

    public o4(Solo<T> solo, Publisher<?> publisher, Solo<T> solo2) {
        this.b = solo;
        this.c = publisher;
        this.d = solo2;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.d);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.c);
        this.b.subscribe(aVar);
    }
}
