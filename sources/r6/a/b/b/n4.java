package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class n4<T> extends Solo<T> {
    public final Solo<T> b;
    public final Publisher<?> c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -3094876274753374720L;
        public final AtomicReference<Subscription> a = new AtomicReference<>();
        public final a<T>.C0617a b = new C0617a();
        public final AtomicBoolean c = new AtomicBoolean();

        /* renamed from: r6.a.b.b.n4$a$a  reason: collision with other inner class name */
        public final class C0617a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = -7055801798042780544L;
            public boolean a;

            public C0617a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (!this.a) {
                    this.a = true;
                    a.this.d(new NoSuchElementException());
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (this.a) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.a = true;
                a.this.d(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                if (!this.a) {
                    ((Subscription) get()).cancel();
                    onComplete();
                }
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

        public void d(Throwable th) {
            SubscriptionHelper.cancel(this.a);
            if (this.c.compareAndSet(false, true)) {
                this.value = null;
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.b);
            if (this.c.compareAndSet(false, true)) {
                T t = this.value;
                if (t != null) {
                    this.value = null;
                    complete(t);
                    return;
                }
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.b);
            if (this.c.compareAndSet(false, true)) {
                this.value = null;
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

    public n4(Solo<T> solo, Publisher<?> publisher) {
        this.b = solo;
        this.c = publisher;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.b);
        this.b.subscribe(aVar);
    }
}
