package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    public final SpscLinkedArrayQueue<T> b;
    public final AtomicReference<Runnable> c;
    public final boolean d;
    public volatile boolean e;
    public Throwable f;
    public final AtomicReference<Subscriber<? super T>> g = new AtomicReference<>();
    public volatile boolean h;
    public final AtomicBoolean i = new AtomicBoolean();
    public final BasicIntQueueSubscription<T> j = new a();
    public final AtomicLong k = new AtomicLong();
    public boolean l;

    public final class a extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        public a() {
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!UnicastProcessor.this.h) {
                UnicastProcessor.this.h = true;
                UnicastProcessor.this.g();
                UnicastProcessor.this.g.lazySet(null);
                if (UnicastProcessor.this.j.getAndIncrement() == 0) {
                    UnicastProcessor.this.g.lazySet(null);
                    UnicastProcessor unicastProcessor = UnicastProcessor.this;
                    if (!unicastProcessor.l) {
                        unicastProcessor.b.clear();
                    }
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.b.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.b.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return UnicastProcessor.this.b.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(UnicastProcessor.this.k, j);
                UnicastProcessor.this.h();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.l = true;
            return 2;
        }
    }

    public UnicastProcessor(int i2, Runnable runnable, boolean z) {
        this.b = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i2, "capacityHint"));
        this.c = new AtomicReference<>(runnable);
        this.d = z;
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(Flowable.bufferSize(), null, true);
    }

    public boolean f(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.h) {
            spscLinkedArrayQueue.clear();
            this.g.lazySet(null);
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (z && this.f != null) {
                spscLinkedArrayQueue.clear();
                this.g.lazySet(null);
                subscriber.onError(this.f);
                return true;
            } else if (!z3) {
                return false;
            } else {
                Throwable th = this.f;
                this.g.lazySet(null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    public void g() {
        Runnable andSet = this.c.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @Nullable
    public Throwable getThrowable() {
        if (this.e) {
            return this.f;
        }
        return null;
    }

    public void h() {
        int i2;
        long j2;
        if (this.j.getAndIncrement() == 0) {
            int i3 = 1;
            Subscriber<? super T> subscriber = this.g.get();
            int i4 = 1;
            while (subscriber == null) {
                i4 = this.j.addAndGet(-i4);
                if (i4 != 0) {
                    subscriber = this.g.get();
                    i3 = 1;
                } else {
                    return;
                }
            }
            if (this.l) {
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.b;
                int i5 = (this.d ? 1 : 0) ^ i3;
                while (!this.h) {
                    boolean z = this.e;
                    if (i5 == 0 || !z || this.f == null) {
                        subscriber.onNext(null);
                        if (z) {
                            this.g.lazySet(null);
                            Throwable th = this.f;
                            if (th != null) {
                                subscriber.onError(th);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        } else {
                            i3 = this.j.addAndGet(-i3);
                            if (i3 == 0) {
                                return;
                            }
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        this.g.lazySet(null);
                        subscriber.onError(this.f);
                        return;
                    }
                }
                this.g.lazySet(null);
                return;
            }
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = this.b;
            boolean z2 = !this.d;
            int i6 = 1;
            while (true) {
                long j3 = this.k.get();
                long j4 = 0;
                while (true) {
                    i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
                    if (i2 == 0) {
                        j2 = j4;
                        break;
                    }
                    boolean z3 = this.e;
                    T poll = spscLinkedArrayQueue2.poll();
                    boolean z4 = poll == null;
                    j2 = j4;
                    if (!f(z2, z3, z4, subscriber, spscLinkedArrayQueue2)) {
                        if (z4) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j4 = j2 + 1;
                    } else {
                        return;
                    }
                }
                if (i2 != 0 || !f(z2, this.e, spscLinkedArrayQueue2.isEmpty(), subscriber, spscLinkedArrayQueue2)) {
                    if (!(j2 == 0 || j3 == Long.MAX_VALUE)) {
                        this.k.addAndGet(-j2);
                    }
                    i6 = this.j.addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.e && this.f == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.g.get() != null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.e && this.f != null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.e && !this.h) {
            this.e = true;
            g();
            h();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e || this.h) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f = th;
        this.e = true;
        g();
        h();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.e && !this.h) {
            this.b.offer(t);
            h();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.e || this.h) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.i.get() || !this.i.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.j);
        this.g.set(subscriber);
        if (this.h) {
            this.g.lazySet(null);
        } else {
            h();
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i2) {
        return new UnicastProcessor<>(i2, null, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(boolean z) {
        return new UnicastProcessor<>(Flowable.bufferSize(), null, z);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i2, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i2, runnable, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i2, Runnable runnable, boolean z) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i2, runnable, z);
    }
}
