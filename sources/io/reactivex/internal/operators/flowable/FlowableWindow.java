package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableWindow<T> extends s6.a.c.b.a.a<T, Flowable<T>> {
    public final long b;
    public final long c;
    public final int d;

    public static final class a<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        public final Subscriber<? super Flowable<T>> a;
        public final long b;
        public final AtomicBoolean c = new AtomicBoolean();
        public final int d;
        public long e;
        public Subscription f;
        public UnicastProcessor<T> g;

        public a(Subscriber<? super Flowable<T>> subscriber, long j, int i) {
            super(1);
            this.a = subscriber;
            this.b = j;
            this.d = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.c.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.g;
            if (unicastProcessor != null) {
                this.g = null;
                unicastProcessor.onComplete();
            }
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.g;
            if (unicastProcessor != null) {
                this.g = null;
                unicastProcessor.onError(th);
            }
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.e;
            UnicastProcessor<T> unicastProcessor = this.g;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.d, this);
                this.g = unicastProcessor;
                this.a.onNext(unicastProcessor);
            }
            long j2 = j + 1;
            unicastProcessor.onNext(t);
            if (j2 == this.b) {
                this.e = 0;
                this.g = null;
                unicastProcessor.onComplete();
                return;
            }
            this.e = j2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.f.request(BackpressureHelper.multiplyCap(this.b, j));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f.cancel();
            }
        }
    }

    public static final class b<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        public final Subscriber<? super Flowable<T>> a;
        public final SpscLinkedArrayQueue<UnicastProcessor<T>> b;
        public final long c;
        public final long d;
        public final ArrayDeque<UnicastProcessor<T>> e = new ArrayDeque<>();
        public final AtomicBoolean f = new AtomicBoolean();
        public final AtomicBoolean g = new AtomicBoolean();
        public final AtomicLong h = new AtomicLong();
        public final AtomicInteger i = new AtomicInteger();
        public final int j;
        public long k;
        public long l;
        public Subscription m;
        public volatile boolean n;
        public Throwable o;
        public volatile boolean p;

        public b(Subscriber<? super Flowable<T>> subscriber, long j2, long j3, int i2) {
            super(1);
            this.a = subscriber;
            this.c = j2;
            this.d = j3;
            this.b = new SpscLinkedArrayQueue<>(i2);
            this.j = i2;
        }

        public boolean a(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.p) {
                spscLinkedArrayQueue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.o;
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public void b() {
            int i2;
            if (this.i.getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.a;
                SpscLinkedArrayQueue<UnicastProcessor<T>> spscLinkedArrayQueue = this.b;
                int i3 = 1;
                do {
                    long j2 = this.h.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.n;
                        UnicastProcessor<T> poll = spscLinkedArrayQueue.poll();
                        boolean z2 = poll == null;
                        if (!a(z, z2, subscriber, spscLinkedArrayQueue)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j3++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !a(this.n, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                        if (!(j3 == 0 || j2 == Long.MAX_VALUE)) {
                            this.h.addAndGet(-j3);
                        }
                        i3 = this.i.addAndGet(-i3);
                    } else {
                        return;
                    }
                } while (i3 != 0);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.p = true;
            if (this.f.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.n) {
                Iterator<UnicastProcessor<T>> it = this.e.iterator();
                while (it.hasNext()) {
                    it.next().onComplete();
                }
                this.e.clear();
                this.n = true;
                b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.n) {
                RxJavaPlugins.onError(th);
                return;
            }
            Iterator<UnicastProcessor<T>> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.e.clear();
            this.o = th;
            this.n = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.n) {
                long j2 = this.k;
                if (j2 == 0 && !this.p) {
                    getAndIncrement();
                    UnicastProcessor<T> create = UnicastProcessor.create(this.j, this);
                    this.e.offer(create);
                    this.b.offer(create);
                    b();
                }
                long j3 = j2 + 1;
                Iterator<UnicastProcessor<T>> it = this.e.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                long j4 = this.l + 1;
                if (j4 == this.c) {
                    this.l = j4 - this.d;
                    UnicastProcessor<T> poll = this.e.poll();
                    if (poll != null) {
                        poll.onComplete();
                    }
                } else {
                    this.l = j4;
                }
                if (j3 == this.d) {
                    this.k = 0;
                } else {
                    this.k = j3;
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.m, subscription)) {
                this.m = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.h, j2);
                if (this.g.get() || !this.g.compareAndSet(false, true)) {
                    this.m.request(BackpressureHelper.multiplyCap(this.d, j2));
                } else {
                    this.m.request(BackpressureHelper.addCap(this.c, BackpressureHelper.multiplyCap(this.d, j2 - 1)));
                }
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.m.cancel();
            }
        }
    }

    public static final class c<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        public final Subscriber<? super Flowable<T>> a;
        public final long b;
        public final long c;
        public final AtomicBoolean d = new AtomicBoolean();
        public final AtomicBoolean e = new AtomicBoolean();
        public final int f;
        public long g;
        public Subscription h;
        public UnicastProcessor<T> i;

        public c(Subscriber<? super Flowable<T>> subscriber, long j, long j2, int i2) {
            super(1);
            this.a = subscriber;
            this.b = j;
            this.c = j2;
            this.f = i2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.d.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.i;
            if (unicastProcessor != null) {
                this.i = null;
                unicastProcessor.onComplete();
            }
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.i;
            if (unicastProcessor != null) {
                this.i = null;
                unicastProcessor.onError(th);
            }
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.g;
            UnicastProcessor<T> unicastProcessor = this.i;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.f, this);
                this.i = unicastProcessor;
                this.a.onNext(unicastProcessor);
            }
            long j2 = j + 1;
            if (unicastProcessor != null) {
                unicastProcessor.onNext(t);
            }
            if (j2 == this.b) {
                this.i = null;
                unicastProcessor.onComplete();
            }
            if (j2 == this.c) {
                this.g = 0;
            } else {
                this.g = j2;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (!SubscriptionHelper.validate(j)) {
                return;
            }
            if (this.e.get() || !this.e.compareAndSet(false, true)) {
                this.h.request(BackpressureHelper.multiplyCap(this.c, j));
                return;
            }
            this.h.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(this.b, j), BackpressureHelper.multiplyCap(this.c - this.b, j - 1)));
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.h.cancel();
            }
        }
    }

    public FlowableWindow(Flowable<T> flowable, long j, long j2, int i) {
        super(flowable);
        this.b = j;
        this.c = j2;
        this.d = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        long j = this.c;
        long j2 = this.b;
        if (j == j2) {
            this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b, this.d));
        } else if (j > j2) {
            this.source.subscribe((FlowableSubscriber) new c(subscriber, this.b, this.c, this.d));
        } else {
            this.source.subscribe((FlowableSubscriber) new b(subscriber, this.b, this.c, this.d));
        }
    }
}
