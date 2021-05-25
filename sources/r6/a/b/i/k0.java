package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableOperator;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class k0<T> extends Flowable<T> implements FlowableOperator<T, T>, FlowableTransformer<T, T> {
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
        public final a<T>.C0655a e = new C0655a();
        public final AtomicThrowable f = new AtomicThrowable();
        public volatile boolean g;
        public volatile boolean h;
        public volatile boolean i;

        /* renamed from: r6.a.b.i.k0$a$a  reason: collision with other inner class name */
        public final class C0655a extends AtomicReference<Subscription> implements FlowableSubscriber<Boolean> {
            private static final long serialVersionUID = -3076915855750118155L;

            public C0655a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (aVar.f.tryAddThrowableOrReport(new IllegalStateException("The valve source completed unexpectedly."))) {
                    aVar.a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a aVar = a.this;
                if (aVar.f.tryAddThrowableOrReport(th)) {
                    aVar.a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                a aVar = a.this;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                aVar.h = booleanValue;
                if (booleanValue) {
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
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
                        simplePlainQueue.clear();
                        SubscriptionHelper.cancel(this.b);
                        SubscriptionHelper.cancel(this.e);
                        atomicThrowable.tryTerminateConsumer(subscriber);
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
            this.f.tryTerminateAndReport();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.g = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f.tryAddThrowableOrReport(th)) {
                a();
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

    public k0(Publisher<? extends T> publisher, Publisher<Boolean> publisher2, boolean z, int i) {
        this.b = publisher;
        this.c = publisher2;
        this.d = z;
        this.e = i;
    }

    @Override // io.reactivex.rxjava3.core.FlowableOperator
    public Subscriber<? super T> apply(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.e, this.d);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.e);
        return aVar;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.e, this.d);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.e);
        this.b.subscribe(aVar);
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new k0(flowable, this.c, this.d, this.e);
    }
}
