package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableWindowTimed<T> extends s6.a.e.d.c.a.a<T, Flowable<T>> {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final Scheduler e;
    public final long f;
    public final int g;
    public final boolean h;

    public static abstract class a<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5724293814035355511L;
        public final Subscriber<? super Flowable<T>> a;
        public final SimplePlainQueue<Object> b = new MpscLinkedQueue();
        public final long c;
        public final TimeUnit d;
        public final int e;
        public final AtomicLong f;
        public long g;
        public volatile boolean h;
        public Throwable i;
        public Subscription j;
        public final AtomicBoolean k;
        public volatile boolean l;
        public final AtomicInteger m;

        public a(Subscriber<? super Flowable<T>> subscriber, long j2, TimeUnit timeUnit, int i2) {
            this.a = subscriber;
            this.c = j2;
            this.d = timeUnit;
            this.e = i2;
            this.f = new AtomicLong();
            this.k = new AtomicBoolean();
            this.m = new AtomicInteger(1);
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.k.compareAndSet(false, true)) {
                d();
            }
        }

        public final void d() {
            if (this.m.decrementAndGet() == 0) {
                a();
                this.j.cancel();
                this.l = true;
                c();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.h = true;
            c();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.i = th;
            this.h = true;
            c();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.b.offer(t);
            c();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.j, subscription)) {
                this.j = subscription;
                this.a.onSubscribe(this);
                b();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.f, j2);
            }
        }
    }

    public static final class b<T> extends a<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        public final Scheduler n;
        public final boolean o;
        public final long p;
        public final Scheduler.Worker q;
        public long r;
        public UnicastProcessor<T> s;
        public final SequentialDisposable t;

        public static final class a implements Runnable {
            public final b<?> a;
            public final long b;

            public a(b<?> bVar, long j) {
                this.a = bVar;
                this.b = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                b<?> bVar = this.a;
                bVar.b.offer(this);
                bVar.c();
            }
        }

        public b(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(subscriber, j, timeUnit, i);
            this.n = scheduler;
            this.p = j2;
            this.o = z;
            if (z) {
                this.q = scheduler.createWorker();
            } else {
                this.q = null;
            }
            this.t = new SequentialDisposable();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.a
        public void a() {
            this.t.dispose();
            Scheduler.Worker worker = this.q;
            if (worker != null) {
                worker.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.a
        public void b() {
            if (this.k.get()) {
                return;
            }
            if (this.f.get() != 0) {
                this.g = 1;
                this.m.getAndIncrement();
                this.s = UnicastProcessor.create(this.e, this);
                s6.a.e.d.c.a.b bVar = new s6.a.e.d.c.a.b(this.s);
                this.a.onNext(bVar);
                a aVar = new a(this, 1);
                if (this.o) {
                    SequentialDisposable sequentialDisposable = this.t;
                    Scheduler.Worker worker = this.q;
                    long j = this.c;
                    sequentialDisposable.replace(worker.schedulePeriodically(aVar, j, j, this.d));
                } else {
                    SequentialDisposable sequentialDisposable2 = this.t;
                    Scheduler scheduler = this.n;
                    long j2 = this.c;
                    sequentialDisposable2.replace(scheduler.schedulePeriodicallyDirect(aVar, j2, j2, this.d));
                }
                if (bVar.f()) {
                    this.s.onComplete();
                }
                this.j.request(Long.MAX_VALUE);
                return;
            }
            this.j.cancel();
            this.a.onError(new MissingBackpressureException(FlowableWindowTimed.f(this.g)));
            a();
            this.l = true;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x000f */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x007c */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x000f */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.rxjava3.processors.UnicastProcessor<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.processors.UnicastProcessor<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: io.reactivex.rxjava3.processors.UnicastProcessor<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: io.reactivex.rxjava3.processors.UnicastProcessor<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: io.reactivex.rxjava3.processors.UnicastProcessor<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: io.reactivex.rxjava3.processors.UnicastProcessor<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: io.reactivex.rxjava3.processors.UnicastProcessor<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.a
        public void c() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.b;
                Subscriber<? super Flowable<T>> subscriber = this.a;
                UnicastProcessor<T> unicastProcessor = this.s;
                int i = 1;
                while (true) {
                    if (this.l) {
                        simplePlainQueue.clear();
                        this.s = null;
                        unicastProcessor = null;
                    } else {
                        boolean z = this.h;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.i;
                            if (th != null) {
                                if (unicastProcessor != 0) {
                                    unicastProcessor.onError(th);
                                }
                                subscriber.onError(th);
                            } else {
                                if (unicastProcessor != 0) {
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            a();
                            this.l = true;
                        } else if (!z2) {
                            if (poll instanceof a) {
                                if (((a) poll).b == this.g || !this.o) {
                                    this.r = 0;
                                    unicastProcessor = e(unicastProcessor);
                                }
                            } else if (unicastProcessor != null) {
                                unicastProcessor.onNext(poll);
                                long j = this.r + 1;
                                if (j == this.p) {
                                    this.r = 0;
                                    unicastProcessor = e(unicastProcessor);
                                } else {
                                    this.r = j;
                                }
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public UnicastProcessor<T> e(UnicastProcessor<T> unicastProcessor) {
            if (unicastProcessor != null) {
                unicastProcessor.onComplete();
                unicastProcessor = null;
            }
            if (this.k.get()) {
                a();
            } else {
                long j = this.g;
                if (this.f.get() == j) {
                    this.j.cancel();
                    a();
                    this.l = true;
                    this.a.onError(new MissingBackpressureException(FlowableWindowTimed.f(j)));
                } else {
                    long j2 = j + 1;
                    this.g = j2;
                    this.m.getAndIncrement();
                    unicastProcessor = UnicastProcessor.create(this.e, this);
                    this.s = unicastProcessor;
                    s6.a.e.d.c.a.b bVar = new s6.a.e.d.c.a.b(unicastProcessor);
                    this.a.onNext(bVar);
                    if (this.o) {
                        SequentialDisposable sequentialDisposable = this.t;
                        Scheduler.Worker worker = this.q;
                        a aVar = new a(this, j2);
                        long j3 = this.c;
                        sequentialDisposable.update(worker.schedulePeriodically(aVar, j3, j3, this.d));
                    }
                    if (bVar.f()) {
                        unicastProcessor.onComplete();
                    }
                }
            }
            return unicastProcessor;
        }

        @Override // java.lang.Runnable
        public void run() {
            d();
        }
    }

    public static final class c<T> extends a<T> implements Runnable {
        public static final Object r = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        public final Scheduler n;
        public UnicastProcessor<T> o;
        public final SequentialDisposable p = new SequentialDisposable();
        public final Runnable q = new a();

        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d();
            }
        }

        public c(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(subscriber, j, timeUnit, i);
            this.n = scheduler;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.a
        public void a() {
            this.p.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.a
        public void b() {
            if (this.k.get()) {
                return;
            }
            if (this.f.get() != 0) {
                this.m.getAndIncrement();
                this.o = UnicastProcessor.create(this.e, this.q);
                this.g = 1;
                s6.a.e.d.c.a.b bVar = new s6.a.e.d.c.a.b(this.o);
                this.a.onNext(bVar);
                SequentialDisposable sequentialDisposable = this.p;
                Scheduler scheduler = this.n;
                long j = this.c;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.d));
                if (bVar.f()) {
                    this.o.onComplete();
                }
                this.j.request(Long.MAX_VALUE);
                return;
            }
            this.j.cancel();
            this.a.onError(new MissingBackpressureException(FlowableWindowTimed.f(this.g)));
            this.p.dispose();
            this.l = true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: io.reactivex.rxjava3.processors.UnicastProcessor */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.a
        public void c() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.b;
                Subscriber<? super Flowable<T>> subscriber = this.a;
                UnicastProcessor<T> unicastProcessor = this.o;
                int i = 1;
                while (true) {
                    if (this.l) {
                        simplePlainQueue.clear();
                        this.o = null;
                        unicastProcessor = (UnicastProcessor<T>) null;
                    } else {
                        boolean z = this.h;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.i;
                            if (th != null) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onError(th);
                                }
                                subscriber.onError(th);
                            } else {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            this.p.dispose();
                            this.l = true;
                        } else if (!z2) {
                            if (poll == r) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                    this.o = null;
                                    unicastProcessor = (UnicastProcessor<T>) null;
                                }
                                if (this.k.get()) {
                                    this.p.dispose();
                                } else {
                                    long j = this.f.get();
                                    long j2 = this.g;
                                    if (j == j2) {
                                        this.j.cancel();
                                        this.p.dispose();
                                        this.l = true;
                                        subscriber.onError(new MissingBackpressureException(FlowableWindowTimed.f(this.g)));
                                    } else {
                                        this.g = j2 + 1;
                                        this.m.getAndIncrement();
                                        unicastProcessor = (UnicastProcessor<T>) UnicastProcessor.create(this.e, this.q);
                                        this.o = unicastProcessor;
                                        s6.a.e.d.c.a.b bVar = new s6.a.e.d.c.a.b(unicastProcessor);
                                        subscriber.onNext(bVar);
                                        if (bVar.f()) {
                                            unicastProcessor.onComplete();
                                        }
                                    }
                                }
                            } else if (unicastProcessor != null) {
                                unicastProcessor.onNext(poll);
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.offer(r);
            c();
        }
    }

    public static final class d<T> extends a<T> implements Runnable {
        public static final Object q = new Object();
        public static final Object r = new Object();
        private static final long serialVersionUID = -7852870764194095894L;
        public final long n;
        public final Scheduler.Worker o;
        public final List<UnicastProcessor<T>> p = new LinkedList();

        public static final class a implements Runnable {
            public final d<?> a;
            public final boolean b;

            public a(d<?> dVar, boolean z) {
                this.a = dVar;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                d<?> dVar = this.a;
                dVar.b.offer(this.b ? d.q : d.r);
                dVar.c();
            }
        }

        public d(Subscriber<? super Flowable<T>> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
            super(subscriber, j, timeUnit, i);
            this.n = j2;
            this.o = worker;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.a
        public void a() {
            this.o.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.a
        public void b() {
            if (this.k.get()) {
                return;
            }
            if (this.f.get() != 0) {
                this.g = 1;
                this.m.getAndIncrement();
                UnicastProcessor<T> create = UnicastProcessor.create(this.e, this);
                this.p.add(create);
                s6.a.e.d.c.a.b bVar = new s6.a.e.d.c.a.b(create);
                this.a.onNext(bVar);
                this.o.schedule(new a(this, false), this.c, this.d);
                Scheduler.Worker worker = this.o;
                a aVar = new a(this, true);
                long j = this.n;
                worker.schedulePeriodically(aVar, j, j, this.d);
                if (bVar.f()) {
                    create.onComplete();
                    this.p.remove(create);
                }
                this.j.request(Long.MAX_VALUE);
                return;
            }
            this.j.cancel();
            this.a.onError(new MissingBackpressureException(FlowableWindowTimed.f(this.g)));
            this.o.dispose();
            this.l = true;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed.a
        public void c() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.b;
                Subscriber<? super Flowable<T>> subscriber = this.a;
                List<UnicastProcessor<T>> list = this.p;
                int i = 1;
                while (true) {
                    if (this.l) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.h;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.i;
                            if (th != null) {
                                for (UnicastProcessor<T> unicastProcessor : list) {
                                    unicastProcessor.onError(th);
                                }
                                subscriber.onError(th);
                            } else {
                                for (UnicastProcessor<T> unicastProcessor2 : list) {
                                    unicastProcessor2.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            this.o.dispose();
                            this.l = true;
                        } else if (!z2) {
                            if (poll == q) {
                                if (!this.k.get()) {
                                    long j = this.g;
                                    if (this.f.get() != j) {
                                        this.g = j + 1;
                                        this.m.getAndIncrement();
                                        UnicastProcessor<T> create = UnicastProcessor.create(this.e, this);
                                        list.add(create);
                                        s6.a.e.d.c.a.b bVar = new s6.a.e.d.c.a.b(create);
                                        subscriber.onNext(bVar);
                                        this.o.schedule(new a(this, false), this.c, this.d);
                                        if (bVar.f()) {
                                            create.onComplete();
                                        }
                                    } else {
                                        this.j.cancel();
                                        MissingBackpressureException missingBackpressureException = new MissingBackpressureException(FlowableWindowTimed.f(j));
                                        for (UnicastProcessor<T> unicastProcessor3 : list) {
                                            unicastProcessor3.onError(missingBackpressureException);
                                        }
                                        subscriber.onError(missingBackpressureException);
                                        this.o.dispose();
                                        this.l = true;
                                    }
                                }
                            } else if (poll != r) {
                                for (UnicastProcessor<T> unicastProcessor4 : list) {
                                    unicastProcessor4.onNext(poll);
                                }
                            } else if (!list.isEmpty()) {
                                list.remove(0).onComplete();
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            d();
        }
    }

    public FlowableWindowTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(flowable);
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = j3;
        this.g = i;
        this.h = z;
    }

    public static String f(long j) {
        return a2.b.a.a.a.V2("Unable to emit the next window (#", j, ") due to lack of requests. Please make sure the downstream is ready to consume windows.");
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        if (this.b != this.c) {
            this.source.subscribe((FlowableSubscriber) new d(subscriber, this.b, this.c, this.d, this.e.createWorker(), this.g));
        } else if (this.f == Long.MAX_VALUE) {
            this.source.subscribe((FlowableSubscriber) new c(subscriber, this.b, this.d, this.e, this.g));
        } else {
            this.source.subscribe((FlowableSubscriber) new b(subscriber, this.b, this.d, this.e, this.g, this.f, this.h));
        }
    }
}
