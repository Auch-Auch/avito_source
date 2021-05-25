package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class o1<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Publisher<?> c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -9119999967998769573L;
        public final Publisher<?> a;
        public final a<T>.C0567a b = new C0567a();
        public Subscription c;
        public Throwable d;

        /* renamed from: r6.a.a.b.o1$a$a  reason: collision with other inner class name */
        public final class C0567a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = -6651374802328276829L;

            public C0567a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (get() != SubscriptionHelper.CANCELLED) {
                    a.this.h();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (get() != SubscriptionHelper.CANCELLED) {
                    a.this.d(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                ((Subscription) get()).cancel();
                lazySet(SubscriptionHelper.CANCELLED);
                a.this.h();
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber);
            this.a = publisher;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.c.cancel();
            SubscriptionHelper.cancel(this.b);
        }

        public void d(Throwable th) {
            Throwable th2 = this.d;
            if (th2 != null) {
                th = new CompositeException(th2, th);
            }
            this.actual.onError(th);
        }

        public void h() {
            Throwable th = this.d;
            if (th != null) {
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.subscribe(this.b);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.d = th;
            this.a.subscribe(this.b);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.value = t;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public o1(Perhaps<T> perhaps, Publisher<?> publisher) {
        this.b = perhaps;
        this.c = publisher;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
