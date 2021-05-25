package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class j1<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Nono c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -7603167128015174475L;
        public final Nono a;
        public final a<T>.C0557a b = new C0557a();
        public Subscription c;

        /* renamed from: r6.a.a.b.j1$a$a  reason: collision with other inner class name */
        public final class C0557a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = -2562437629991690939L;

            public C0557a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a.this.d();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.h(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription);
            }
        }

        public a(Subscriber<? super T> subscriber, Nono nono) {
            super(subscriber);
            this.a = nono;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.c.cancel();
            SubscriptionHelper.cancel(this.b);
        }

        public void d() {
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
            }
        }

        public void h(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.subscribe(this.b);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
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

    public j1(Perhaps<T> perhaps, Nono nono) {
        this.b = perhaps;
        this.c = nono;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
