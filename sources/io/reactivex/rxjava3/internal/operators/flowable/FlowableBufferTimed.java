package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends s6.a.e.d.c.a.a<T, U> {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final Scheduler e;
    public final Supplier<U> f;
    public final int g;
    public final boolean h;

    public static final class a<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        public final Supplier<U> c;
        public final long d;
        public final TimeUnit e;
        public final int f;
        public final boolean g;
        public final Scheduler.Worker h;
        public U i;
        public Disposable j;
        public Subscription k;
        public long l;
        public long m;

        public a(Subscriber<? super U> subscriber, Supplier<U> supplier, long j2, TimeUnit timeUnit, int i2, boolean z, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.c = supplier;
            this.d = j2;
            this.e = timeUnit;
            this.f = i2;
            this.g = z;
            this.h = worker;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.reactivestreams.Subscriber */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
        public boolean accept(Subscriber subscriber, Object obj) {
            subscriber.onNext((Collection) obj);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            synchronized (this) {
                this.i = null;
            }
            this.k.cancel();
            this.h.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.h.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.i;
                this.i = null;
            }
            if (u != null) {
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
                }
                this.h.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            synchronized (this) {
                this.i = null;
            }
            this.downstream.onError(th);
            this.h.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            U u;
            synchronized (this) {
                u = this.i;
                if (u != null) {
                    u.add(t);
                    if (u.size() >= this.f) {
                        this.i = null;
                        this.l++;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.g) {
                this.j.dispose();
            }
            fastPathOrderedEmitMax(u, false, this);
            try {
                U u2 = this.c.get();
                Objects.requireNonNull(u2, "The supplied buffer is null");
                U u3 = u2;
                synchronized (this) {
                    this.i = u3;
                    this.m++;
                }
                if (this.g) {
                    Scheduler.Worker worker = this.h;
                    long j2 = this.d;
                    this.j = worker.schedulePeriodically(this, j2, j2, this.e);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.k, subscription)) {
                this.k = subscription;
                try {
                    U u = this.c.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    this.i = u;
                    this.downstream.onSubscribe(this);
                    Scheduler.Worker worker = this.h;
                    long j2 = this.d;
                    this.j = worker.schedulePeriodically(this, j2, j2, this.e);
                    subscription.request(Long.MAX_VALUE);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.h.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            requested(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = this.c.get();
                Objects.requireNonNull(u, "The supplied buffer is null");
                U u2 = u;
                synchronized (this) {
                    U u3 = this.i;
                    if (u3 != null) {
                        if (this.l == this.m) {
                            this.i = u2;
                            fastPathOrderedEmitMax(u3, false, this);
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }
    }

    public static final class b<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        public final Supplier<U> c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler f;
        public Subscription g;
        public U h;
        public final AtomicReference<Disposable> i = new AtomicReference<>();

        public b(Subscriber<? super U> subscriber, Supplier<U> supplier, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.c = supplier;
            this.d = j;
            this.e = timeUnit;
            this.f = scheduler;
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
        public boolean accept(Subscriber subscriber, Object obj) {
            this.downstream.onNext((Collection) obj);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.g.cancel();
            DisposableHelper.dispose(this.i);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.i.get() == DisposableHelper.DISPOSED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            U u;
            DisposableHelper.dispose(this.i);
            synchronized (this) {
                u = this.h;
                if (u != null) {
                    this.h = null;
                } else {
                    return;
                }
            }
            this.queue.offer(u);
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, null, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.i);
            synchronized (this) {
                this.h = null;
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.h;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                try {
                    U u = this.c.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    this.h = u;
                    this.downstream.onSubscribe(this);
                    if (!this.cancelled) {
                        subscription.request(Long.MAX_VALUE);
                        Scheduler scheduler = this.f;
                        long j = this.d;
                        Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.e);
                        if (!this.i.compareAndSet(null, schedulePeriodicallyDirect)) {
                            schedulePeriodicallyDirect.dispose();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = this.c.get();
                Objects.requireNonNull(u, "The supplied buffer is null");
                U u2 = u;
                synchronized (this) {
                    U u3 = this.h;
                    if (u3 != null) {
                        this.h = u2;
                        fastPathEmitMax(u3, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }
    }

    public static final class c<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        public final Supplier<U> c;
        public final long d;
        public final long e;
        public final TimeUnit f;
        public final Scheduler.Worker g;
        public final List<U> h = new LinkedList();
        public Subscription i;

        /* JADX WARN: Field signature parse error: a */
        public final class a implements Runnable {
            public final Collection a;

            /* JADX WARN: Failed to parse method signature: (TU)V */
            public a(Collection collection) {
                this.a = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.h.remove(this.a);
                }
                c cVar = c.this;
                cVar.fastPathOrderedEmitMax(this.a, false, cVar.g);
            }
        }

        public c(Subscriber<? super U> subscriber, Supplier<U> supplier, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.c = supplier;
            this.d = j;
            this.e = j2;
            this.f = timeUnit;
            this.g = worker;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.reactivestreams.Subscriber */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
        public boolean accept(Subscriber subscriber, Object obj) {
            subscriber.onNext((Collection) obj);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.i.cancel();
            this.g.dispose();
            synchronized (this) {
                this.h.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.h);
                this.h.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.queue.offer((Collection) it.next());
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this.g, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.done = true;
            this.g.dispose();
            synchronized (this) {
                this.h.clear();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                for (U u : this.h) {
                    u.add(t);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                try {
                    U u = this.c.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    U u2 = u;
                    this.h.add(u2);
                    this.downstream.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    Scheduler.Worker worker = this.g;
                    long j = this.e;
                    worker.schedulePeriodically(this, j, j, this.f);
                    this.g.schedule(new a(u2), this.d, this.f);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.g.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cancelled) {
                try {
                    U u = this.c.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    U u2 = u;
                    synchronized (this) {
                        if (!this.cancelled) {
                            this.h.add(u2);
                            this.g.schedule(new a(u2), this.d, this.f);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    this.downstream.onError(th);
                }
            }
        }
    }

    public FlowableBufferTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Supplier<U> supplier, int i, boolean z) {
        super(flowable);
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = supplier;
        this.g = i;
        this.h = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.b == this.c && this.g == Integer.MAX_VALUE) {
            this.source.subscribe((FlowableSubscriber) new b(new SerializedSubscriber(subscriber), this.f, this.b, this.d, this.e));
            return;
        }
        Scheduler.Worker createWorker = this.e.createWorker();
        if (this.b == this.c) {
            this.source.subscribe((FlowableSubscriber) new a(new SerializedSubscriber(subscriber), this.f, this.b, this.d, this.g, this.h, createWorker));
        } else {
            this.source.subscribe((FlowableSubscriber) new c(new SerializedSubscriber(subscriber), this.f, this.b, this.c, this.d, createWorker));
        }
    }
}
