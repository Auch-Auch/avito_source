package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableObserveOn<T> extends s6.a.e.d.c.a.a<T, T> {
    public final Scheduler b;
    public final boolean c;
    public final int d;

    public static abstract class a<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        public final Scheduler.Worker a;
        public final boolean b;
        public final int c;
        public final int d;
        public final AtomicLong e = new AtomicLong();
        public Subscription f;
        public SimpleQueue<T> g;
        public volatile boolean h;
        public volatile boolean i;
        public Throwable j;
        public int k;
        public long l;
        public boolean m;

        public a(Scheduler.Worker worker, boolean z, int i2) {
            this.a = worker;
            this.b = z;
            this.c = i2;
            this.d = i2 - (i2 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (!this.h) {
                this.h = true;
                this.f.cancel();
                this.a.dispose();
                if (!this.m && getAndIncrement() == 0) {
                    this.g.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final void clear() {
            this.g.clear();
        }

        public final boolean d(boolean z, boolean z2, Subscriber<?> subscriber) {
            if (this.h) {
                this.g.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!this.b) {
                    Throwable th = this.j;
                    if (th != null) {
                        this.h = true;
                        this.g.clear();
                        subscriber.onError(th);
                        this.a.dispose();
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.h = true;
                        subscriber.onComplete();
                        this.a.dispose();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    this.h = true;
                    Throwable th2 = this.j;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                    }
                    this.a.dispose();
                    return true;
                }
            }
        }

        public abstract void h();

        public abstract void i();

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.g.isEmpty();
        }

        public abstract void j();

        public final void l() {
            if (getAndIncrement() == 0) {
                this.a.schedule(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (!this.i) {
                this.i = true;
                l();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.j = th;
            this.i = true;
            l();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (!this.i) {
                if (this.k == 2) {
                    l();
                    return;
                }
                if (!this.g.offer(t)) {
                    this.f.cancel();
                    this.j = new MissingBackpressureException("Queue is full?!");
                    this.i = true;
                }
                l();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.e, j2);
                l();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.m = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.m) {
                i();
            } else if (this.k == 1) {
                j();
            } else {
                h();
            }
        }
    }

    public static final class b<T> extends a<T> {
        private static final long serialVersionUID = 644624475404284533L;
        public final ConditionalSubscriber<? super T> n;
        public long o;

        public b(ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler.Worker worker, boolean z, int i) {
            super(worker, z, i);
            this.n = conditionalSubscriber;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn.a
        public void h() {
            int i;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.n;
            SimpleQueue<T> simpleQueue = this.g;
            long j = this.l;
            long j2 = this.o;
            int i2 = 1;
            do {
                long j3 = this.e.get();
                while (true) {
                    i = (j > j3 ? 1 : (j == j3 ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z = this.i;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z2 = poll == null;
                        if (!d(z, z2, conditionalSubscriber)) {
                            if (z2) {
                                break;
                            }
                            if (conditionalSubscriber.tryOnNext(poll)) {
                                j++;
                            }
                            j2++;
                            if (j2 == ((long) this.d)) {
                                this.f.request(j2);
                                j2 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.h = true;
                        this.f.cancel();
                        simpleQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.a.dispose();
                        return;
                    }
                }
                if (i != 0 || !d(this.i, simpleQueue.isEmpty(), conditionalSubscriber)) {
                    this.l = j;
                    this.o = j2;
                    i2 = addAndGet(-i2);
                } else {
                    return;
                }
            } while (i2 != 0);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn.a
        public void i() {
            int i = 1;
            while (!this.h) {
                boolean z = this.i;
                this.n.onNext(null);
                if (z) {
                    this.h = true;
                    Throwable th = this.j;
                    if (th != null) {
                        this.n.onError(th);
                    } else {
                        this.n.onComplete();
                    }
                    this.a.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn.a
        public void j() {
            ConditionalSubscriber<? super T> conditionalSubscriber = this.n;
            SimpleQueue<T> simpleQueue = this.g;
            long j = this.l;
            int i = 1;
            do {
                long j2 = this.e.get();
                while (j != j2) {
                    try {
                        T poll = simpleQueue.poll();
                        if (!this.h) {
                            if (poll == null) {
                                this.h = true;
                                conditionalSubscriber.onComplete();
                                this.a.dispose();
                                return;
                            } else if (conditionalSubscriber.tryOnNext(poll)) {
                                j++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.h = true;
                        this.f.cancel();
                        conditionalSubscriber.onError(th);
                        this.a.dispose();
                        return;
                    }
                }
                if (!this.h) {
                    if (simpleQueue.isEmpty()) {
                        this.h = true;
                        conditionalSubscriber.onComplete();
                        this.a.dispose();
                        return;
                    }
                    this.l = j;
                    i = addAndGet(-i);
                } else {
                    return;
                }
            } while (i != 0);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.k = 1;
                        this.g = queueSubscription;
                        this.i = true;
                        this.n.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.k = 2;
                        this.g = queueSubscription;
                        this.n.onSubscribe(this);
                        subscription.request((long) this.c);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.c);
                this.n.onSubscribe(this);
                subscription.request((long) this.c);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Throwable {
            T poll = this.g.poll();
            if (!(poll == null || this.k == 1)) {
                long j = this.o + 1;
                if (j == ((long) this.d)) {
                    this.o = 0;
                    this.f.request(j);
                } else {
                    this.o = j;
                }
            }
            return poll;
        }
    }

    public static final class c<T> extends a<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        public final Subscriber<? super T> n;

        public c(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean z, int i) {
            super(worker, z, i);
            this.n = subscriber;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn.a
        public void h() {
            int i;
            Subscriber<? super T> subscriber = this.n;
            SimpleQueue<T> simpleQueue = this.g;
            long j = this.l;
            int i2 = 1;
            while (true) {
                long j2 = this.e.get();
                while (true) {
                    i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z = this.i;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z2 = poll == null;
                        if (!d(z, z2, subscriber)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j++;
                            if (j == ((long) this.d)) {
                                if (j2 != Long.MAX_VALUE) {
                                    j2 = this.e.addAndGet(-j);
                                }
                                this.f.request(j);
                                j = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.h = true;
                        this.f.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th);
                        this.a.dispose();
                        return;
                    }
                }
                if (i != 0 || !d(this.i, simpleQueue.isEmpty(), subscriber)) {
                    int i3 = get();
                    if (i2 == i3) {
                        this.l = j;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        i2 = i3;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn.a
        public void i() {
            int i = 1;
            while (!this.h) {
                boolean z = this.i;
                this.n.onNext(null);
                if (z) {
                    this.h = true;
                    Throwable th = this.j;
                    if (th != null) {
                        this.n.onError(th);
                    } else {
                        this.n.onComplete();
                    }
                    this.a.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn.a
        public void j() {
            Subscriber<? super T> subscriber = this.n;
            SimpleQueue<T> simpleQueue = this.g;
            long j = this.l;
            int i = 1;
            do {
                long j2 = this.e.get();
                while (j != j2) {
                    try {
                        T poll = simpleQueue.poll();
                        if (!this.h) {
                            if (poll == null) {
                                this.h = true;
                                subscriber.onComplete();
                                this.a.dispose();
                                return;
                            }
                            subscriber.onNext(poll);
                            j++;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.h = true;
                        this.f.cancel();
                        subscriber.onError(th);
                        this.a.dispose();
                        return;
                    }
                }
                if (!this.h) {
                    if (simpleQueue.isEmpty()) {
                        this.h = true;
                        subscriber.onComplete();
                        this.a.dispose();
                        return;
                    }
                    this.l = j;
                    i = addAndGet(-i);
                } else {
                    return;
                }
            } while (i != 0);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.k = 1;
                        this.g = queueSubscription;
                        this.i = true;
                        this.n.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.k = 2;
                        this.g = queueSubscription;
                        this.n.onSubscribe(this);
                        subscription.request((long) this.c);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.c);
                this.n.onSubscribe(this);
                subscription.request((long) this.c);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Throwable {
            T poll = this.g.poll();
            if (!(poll == null || this.k == 1)) {
                long j = this.l + 1;
                if (j == ((long) this.d)) {
                    this.l = 0;
                    this.f.request(j);
                } else {
                    this.l = j;
                }
            }
            return poll;
        }
    }

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z, int i) {
        super(flowable);
        this.b = scheduler;
        this.c = z;
        this.d = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.b.createWorker();
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber) new b((ConditionalSubscriber) subscriber, createWorker, this.c, this.d));
        } else {
            this.source.subscribe((FlowableSubscriber) new c(subscriber, createWorker, this.c, this.d));
        }
    }
}
