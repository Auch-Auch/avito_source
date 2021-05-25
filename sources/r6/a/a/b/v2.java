package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
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
        public final a<T>.C0578a c = new C0578a();

        /* renamed from: r6.a.a.b.v2$a$a  reason: collision with other inner class name */
        public final class C0578a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = 8999579172944042558L;

            public C0578a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a.this.h();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.d(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                ((Subscription) get()).cancel();
                a.this.h();
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

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            SubscriptionHelper.cancel(this.b);
            SubscriptionHelper.cancel(this.c);
        }

        public void d(Throwable th) {
            if (this.a.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.b);
                this.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void h() {
            if (this.a.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.b);
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.a.get() && this.a.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.c);
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.a.compareAndSet(false, true)) {
                SubscriptionHelper.cancel(this.c);
                this.actual.onError(th);
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

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.c);
        this.b.subscribe(aVar);
    }
}
