package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import io.reactivex.FlowableTransformer;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class e0<T> extends Flowable<T> implements FlowableOperator<T, T>, FlowableTransformer<T, T> {
    public final Publisher<? extends T> b;
    public final Publisher<Boolean> c;
    public final boolean d;
    public final int e;

    public static final class a<T> extends AtomicInteger implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -2233734924340471378L;
        public final Subscriber<? super T> a;
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final AtomicLong c = new AtomicLong();
        public final SimplePlainQueue<T> d;
        public final a<T>.C0589a e = new C0589a();
        public final AtomicThrowable f = new AtomicThrowable();
        public volatile boolean g;
        public volatile boolean h;
        public volatile boolean i;

        /* renamed from: r6.a.a.h.e0$a$a  reason: collision with other inner class name */
        public final class C0589a extends AtomicReference<Subscription> implements Subscriber<Boolean> {
            private static final long serialVersionUID = -3076915855750118155L;

            public C0589a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                aVar.onError(new IllegalStateException("The valve source completed unexpectedly."));
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.onError(th);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // org.reactivestreams.Subscriber
            public void onNext(Boolean bool) {
                a aVar = a.this;
                boolean booleanValue = bool.booleanValue();
                aVar.h = booleanValue;
                if (booleanValue) {
                    aVar.a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super T> subscriber, int i2, boolean z) {
            this.a = subscriber;
            this.d = new SpscLinkedArrayQueue(i2);
            this.h = z;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<T> simplePlainQueue = this.d;
                Subscriber<? super T> subscriber = this.a;
                AtomicThrowable atomicThrowable = this.f;
                int i2 = 1;
                while (!this.i) {
                    if (atomicThrowable.get() != null) {
                        Throwable terminate = atomicThrowable.terminate();
                        simplePlainQueue.clear();
                        SubscriptionHelper.cancel(this.b);
                        SubscriptionHelper.cancel(this.e);
                        subscriber.onError(terminate);
                        return;
                    }
                    if (this.h) {
                        boolean z = this.g;
                        T poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            SubscriptionHelper.cancel(this.e);
                            subscriber.onComplete();
                            return;
                        } else if (!z2) {
                            subscriber.onNext(poll);
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.i = true;
            SubscriptionHelper.cancel(this.b);
            SubscriptionHelper.cancel(this.e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.g = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f.addThrowable(th)) {
                a();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.d.offer(t);
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.b, this.c, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.b, this.c, j);
        }
    }

    public e0(Publisher<? extends T> publisher, Publisher<Boolean> publisher2, boolean z, int i) {
        this.b = publisher;
        this.c = publisher2;
        this.d = z;
        this.e = i;
    }

    @Override // io.reactivex.FlowableOperator
    public Subscriber<? super T> apply(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.e, this.d);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.e);
        return aVar;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.e, this.d);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.e);
        this.b.subscribe(aVar);
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new e0(flowable, this.c, this.d, this.e);
    }
}
