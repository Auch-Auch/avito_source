package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class l3<T> extends Solo<T> {
    public final Solo<T> b;
    public final Publisher<?> c;

    public static final class a<T> extends AtomicReference<Subscription> implements QueueSubscription<T>, Subscriber<T> {
        private static final long serialVersionUID = 511073038536312798L;
        public final Subscriber<? super T> a;
        public final Publisher<?> b;
        public Subscription c;
        public T d;
        public Throwable e;
        public volatile boolean f;
        public boolean g;

        /* renamed from: r6.a.a.b.l3$a$a  reason: collision with other inner class name */
        public final class C0561a implements Subscriber<Object> {
            public boolean a;

            public C0561a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (!this.a) {
                    this.a = true;
                    a.this.a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (this.a) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                a aVar = a.this;
                Throwable th2 = aVar.e;
                if (th2 == null) {
                    aVar.e = th;
                } else {
                    aVar.e = new CompositeException(th2, th);
                }
                aVar.a();
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                SubscriptionHelper.cancel(a.this);
                onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (SubscriptionHelper.setOnce(aVar, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            this.a = subscriber;
            this.b = publisher;
        }

        public void a() {
            Subscriber<? super T> subscriber = this.a;
            Throwable th = this.e;
            if (th != null) {
                subscriber.onError(th);
                return;
            }
            if (this.g) {
                this.f = true;
                subscriber.onNext(null);
            } else {
                T t = this.d;
                this.d = null;
                if (t != null) {
                    subscriber.onNext(t);
                }
            }
            subscriber.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c.cancel();
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.d = null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return !this.f || this.d == null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t) {
            throw new UnsupportedOperationException();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.b.subscribe(new C0561a());
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.e = th;
            onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.d = t;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            if (!this.f) {
                return null;
            }
            T t = this.d;
            this.d = null;
            return t;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.c.request(j);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.g = true;
            return 2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }
    }

    public l3(Solo<T> solo, Publisher<?> publisher) {
        this.b = solo;
        this.c = publisher;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
