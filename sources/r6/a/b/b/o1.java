package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
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
        public final a<T>.C0618a b = new C0618a();
        public Subscription c;
        public Throwable d;

        /* renamed from: r6.a.b.b.o1$a$a  reason: collision with other inner class name */
        public final class C0618a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = -6651374802328276829L;

            public C0618a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (get() != SubscriptionHelper.CANCELLED) {
                    a.this.d();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (get() != SubscriptionHelper.CANCELLED) {
                    a aVar = a.this;
                    Throwable th2 = aVar.d;
                    if (th2 != null) {
                        th = new CompositeException(th2, th);
                    }
                    aVar.downstream.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                ((Subscription) get()).cancel();
                lazySet(SubscriptionHelper.CANCELLED);
                a.this.d();
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

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.c.cancel();
            SubscriptionHelper.cancel(this.b);
        }

        public void d() {
            Throwable th = this.d;
            if (th != null) {
                this.downstream.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.downstream.onComplete();
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
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public o1(Perhaps<T> perhaps, Publisher<?> publisher) {
        this.b = perhaps;
        this.c = publisher;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
