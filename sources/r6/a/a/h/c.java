package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.FlowableTransformer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class c<T, R> extends Flowable<R> implements FlowableTransformer<T, R> {
    public final Publisher<T> b;
    public final Callable<R> c;
    public final BiConsumer<R, T> d;
    public final int e;

    public static final class a<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6157179110480235565L;
        public final Subscriber<? super R> a;
        public final Callable<R> b;
        public final BiConsumer<R, T> c;
        public final AtomicLong d = new AtomicLong();
        public final int e;
        public volatile SimplePlainQueue<T> f;
        public Subscription g;
        public R h;
        public volatile boolean i;
        public volatile boolean j;
        public Throwable k;
        public long l;

        public a(Subscriber<? super R> subscriber, Callable<R> callable, BiConsumer<R, T> biConsumer, int i2) {
            this.a = subscriber;
            this.b = callable;
            this.c = biConsumer;
            this.e = i2;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            long j2 = this.l;
            R r = this.h;
            Subscriber<? super R> subscriber = this.a;
            int i2 = 1;
            while (!this.j) {
                boolean z = this.i;
                SimplePlainQueue<T> simplePlainQueue = this.f;
                if (!(simplePlainQueue == null || simplePlainQueue.isEmpty())) {
                    if (r == null) {
                        try {
                            r = this.b.call();
                            this.h = r;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.h = null;
                            subscriber.onError(th);
                            return;
                        }
                    }
                    while (true) {
                        T poll = simplePlainQueue.poll();
                        if (poll == null) {
                            break;
                        }
                        this.c.accept(r, poll);
                    }
                }
                if (!(r == null || j2 == this.d.get())) {
                    subscriber.onNext(r);
                    this.h = null;
                    j2++;
                    r = null;
                }
                if (!z || r != null) {
                    this.l = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    Throwable th2 = this.k;
                    this.h = null;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
            this.h = null;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.j = true;
            this.g.cancel();
            if (getAndIncrement() == 0) {
                this.h = null;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.k = th;
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f;
                if (spscLinkedArrayQueue == null) {
                    spscLinkedArrayQueue = new SpscLinkedArrayQueue(this.e);
                    this.f = spscLinkedArrayQueue;
                }
                spscLinkedArrayQueue.offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                SimplePlainQueue<T> simplePlainQueue = this.f;
                if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                    R r = this.h;
                    if (r == null) {
                        try {
                            r = this.b.call();
                            this.h = r;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.g.cancel();
                            this.h = null;
                            this.a.onError(th);
                            return;
                        }
                    }
                    this.c.accept(r, t);
                    long j2 = this.d.get();
                    long j3 = this.l;
                    if (j3 != j2) {
                        this.h = null;
                        this.a.onNext(r);
                        this.l = j3 + 1;
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.d, j2);
                a();
            }
        }
    }

    public c(Publisher<T> publisher, Callable<R> callable, BiConsumer<R, T> biConsumer, int i) {
        this.b = publisher;
        this.c = callable;
        this.d = biConsumer;
        this.e = i;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<R> apply(Flowable<T> flowable) {
        return new c(flowable, this.c, this.d, this.e);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d, this.e));
    }
}
