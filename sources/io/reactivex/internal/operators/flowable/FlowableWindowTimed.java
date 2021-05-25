package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableWindowTimed<T> extends s6.a.c.b.a.a<T, Flowable<T>> {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final Scheduler e;
    public final long f;
    public final int g;
    public final boolean h;

    public static final class a<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        public final long c;
        public final TimeUnit d;
        public final Scheduler e;
        public final int f;
        public final boolean g;
        public final long h;
        public final Scheduler.Worker i;
        public long j;
        public long k;
        public Subscription l;
        public UnicastProcessor<T> m;
        public volatile boolean n;
        public final SequentialDisposable o = new SequentialDisposable();

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableWindowTimed$a$a  reason: collision with other inner class name */
        public static final class RunnableC0392a implements Runnable {
            public final long a;
            public final a<?> b;

            public RunnableC0392a(long j, a<?> aVar) {
                this.a = j;
                this.b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.b;
                if (!aVar.cancelled) {
                    aVar.queue.offer(this);
                } else {
                    aVar.n = true;
                }
                if (aVar.enter()) {
                    aVar.b();
                }
            }
        }

        public a(Subscriber<? super Flowable<T>> subscriber, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, long j3, boolean z) {
            super(subscriber, new MpscLinkedQueue());
            this.c = j2;
            this.d = timeUnit;
            this.e = scheduler;
            this.f = i2;
            this.h = j3;
            this.g = z;
            if (z) {
                this.i = scheduler.createWorker();
            } else {
                this.i = null;
            }
        }

        public void a() {
            this.o.dispose();
            Scheduler.Worker worker = this.i;
            if (worker != null) {
                worker.dispose();
            }
        }

        public void b() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            Subscriber<? super V> subscriber = this.downstream;
            UnicastProcessor<T> unicastProcessor = this.m;
            int i2 = 1;
            while (!this.n) {
                boolean z = this.done;
                U poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof RunnableC0392a;
                if (z && (z2 || z3)) {
                    this.m = null;
                    simplePlainQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        unicastProcessor.onError(th);
                    } else {
                        unicastProcessor.onComplete();
                    }
                    a();
                    return;
                } else if (z2) {
                    i2 = leave(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    if (z3) {
                        U u = poll;
                        if (!this.g || this.k == u.a) {
                            unicastProcessor.onComplete();
                            this.j = 0;
                            unicastProcessor = UnicastProcessor.create(this.f);
                            this.m = unicastProcessor;
                            long requested = requested();
                            if (requested != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (requested != Long.MAX_VALUE) {
                                    produced(1);
                                }
                            } else {
                                this.m = null;
                                this.queue.clear();
                                this.l.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                a();
                                return;
                            }
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                        long j2 = this.j + 1;
                        if (j2 >= this.h) {
                            this.k++;
                            this.j = 0;
                            unicastProcessor.onComplete();
                            long requested2 = requested();
                            if (requested2 != 0) {
                                UnicastProcessor<T> create = UnicastProcessor.create(this.f);
                                this.m = create;
                                this.downstream.onNext(create);
                                if (requested2 != Long.MAX_VALUE) {
                                    produced(1);
                                }
                                if (this.g) {
                                    ((Disposable) this.o.get()).dispose();
                                    Scheduler.Worker worker = this.i;
                                    RunnableC0392a aVar = new RunnableC0392a(this.k, this);
                                    long j3 = this.c;
                                    this.o.replace(worker.schedulePeriodically(aVar, j3, j3, this.d));
                                }
                                unicastProcessor = create;
                            } else {
                                this.m = null;
                                this.l.cancel();
                                this.downstream.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                                a();
                                return;
                            }
                        } else {
                            this.j = j2;
                        }
                    }
                    i2 = i2;
                }
            }
            this.l.cancel();
            simplePlainQueue.clear();
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                b();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                b();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.n) {
                if (fastEnter()) {
                    UnicastProcessor<T> unicastProcessor = this.m;
                    unicastProcessor.onNext(t);
                    long j2 = this.j + 1;
                    if (j2 >= this.h) {
                        this.k++;
                        this.j = 0;
                        unicastProcessor.onComplete();
                        long requested = requested();
                        if (requested != 0) {
                            UnicastProcessor<T> create = UnicastProcessor.create(this.f);
                            this.m = create;
                            this.downstream.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1);
                            }
                            if (this.g) {
                                ((Disposable) this.o.get()).dispose();
                                Scheduler.Worker worker = this.i;
                                RunnableC0392a aVar = new RunnableC0392a(this.k, this);
                                long j3 = this.c;
                                this.o.replace(worker.schedulePeriodically(aVar, j3, j3, this.d));
                            }
                        } else {
                            this.m = null;
                            this.l.cancel();
                            this.downstream.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                            a();
                            return;
                        }
                    } else {
                        this.j = j2;
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer((U) NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                b();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Disposable disposable;
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                Subscriber<? super V> subscriber = this.downstream;
                subscriber.onSubscribe(this);
                if (!this.cancelled) {
                    UnicastProcessor<T> create = UnicastProcessor.create(this.f);
                    this.m = create;
                    long requested = requested();
                    if (requested != 0) {
                        subscriber.onNext(create);
                        if (requested != Long.MAX_VALUE) {
                            produced(1);
                        }
                        RunnableC0392a aVar = new RunnableC0392a(this.k, this);
                        if (this.g) {
                            Scheduler.Worker worker = this.i;
                            long j2 = this.c;
                            disposable = worker.schedulePeriodically(aVar, j2, j2, this.d);
                        } else {
                            Scheduler scheduler = this.e;
                            long j3 = this.c;
                            disposable = scheduler.schedulePeriodicallyDirect(aVar, j3, j3, this.d);
                        }
                        if (this.o.replace(disposable)) {
                            subscription.request(Long.MAX_VALUE);
                            return;
                        }
                        return;
                    }
                    this.cancelled = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            requested(j2);
        }
    }

    public static final class b<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final Object k = new Object();
        public final long c;
        public final TimeUnit d;
        public final Scheduler e;
        public final int f;
        public Subscription g;
        public UnicastProcessor<T> h;
        public final SequentialDisposable i = new SequentialDisposable();
        public volatile boolean j;

        public b(Subscriber<? super Flowable<T>> subscriber, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2) {
            super(subscriber, new MpscLinkedQueue());
            this.c = j2;
            this.d = timeUnit;
            this.e = scheduler;
            this.f = i2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: io.reactivex.processors.UnicastProcessor */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            Subscriber<? super V> subscriber = this.downstream;
            UnicastProcessor<T> unicastProcessor = this.h;
            int i2 = 1;
            while (true) {
                boolean z = this.j;
                boolean z2 = this.done;
                U poll = simplePlainQueue.poll();
                if (!z2 || !(poll == null || poll == k)) {
                    if (poll == null) {
                        i2 = leave(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else if (poll == k) {
                        unicastProcessor.onComplete();
                        if (!z) {
                            unicastProcessor = (UnicastProcessor<T>) UnicastProcessor.create(this.f);
                            this.h = unicastProcessor;
                            long requested = requested();
                            if (requested != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (requested != Long.MAX_VALUE) {
                                    produced(1);
                                }
                            } else {
                                this.h = null;
                                this.queue.clear();
                                this.g.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                this.i.dispose();
                                return;
                            }
                        } else {
                            this.g.cancel();
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.h = null;
            simplePlainQueue.clear();
            Throwable th = this.error;
            if (th != null) {
                unicastProcessor.onError(th);
            } else {
                unicastProcessor.onComplete();
            }
            this.i.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.j) {
                if (fastEnter()) {
                    this.h.onNext(t);
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer((U) NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                a();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.h = UnicastProcessor.create(this.f);
                Subscriber<? super V> subscriber = this.downstream;
                subscriber.onSubscribe(this);
                long requested = requested();
                if (requested != 0) {
                    subscriber.onNext(this.h);
                    if (requested != Long.MAX_VALUE) {
                        produced(1);
                    }
                    if (!this.cancelled) {
                        SequentialDisposable sequentialDisposable = this.i;
                        Scheduler scheduler = this.e;
                        long j2 = this.c;
                        if (sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j2, j2, this.d))) {
                            subscription.request(Long.MAX_VALUE);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.cancelled = true;
                subscription.cancel();
                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            requested(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.j = true;
            }
            this.queue.offer((U) k);
            if (enter()) {
                a();
            }
        }
    }

    public static final class c<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {
        public final long c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler.Worker f;
        public final int g;
        public final List<UnicastProcessor<T>> h = new LinkedList();
        public Subscription i;
        public volatile boolean j;

        public final class a implements Runnable {
            public final UnicastProcessor<T> a;

            public a(UnicastProcessor<T> unicastProcessor) {
                this.a = unicastProcessor;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.queue.offer((U) new b(this.a, false));
                if (cVar.enter()) {
                    cVar.a();
                }
            }
        }

        public static final class b<T> {
            public final UnicastProcessor<T> a;
            public final boolean b;

            public b(UnicastProcessor<T> unicastProcessor, boolean z) {
                this.a = unicastProcessor;
                this.b = z;
            }
        }

        public c(Subscriber<? super Flowable<T>> subscriber, long j2, long j3, TimeUnit timeUnit, Scheduler.Worker worker, int i2) {
            super(subscriber, new MpscLinkedQueue());
            this.c = j2;
            this.d = j3;
            this.e = timeUnit;
            this.f = worker;
            this.g = i2;
        }

        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
        public void a() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            Subscriber<? super V> subscriber = this.downstream;
            List<UnicastProcessor<T>> list = this.h;
            int i2 = 1;
            while (!this.j) {
                boolean z = this.done;
                U poll = simplePlainQueue.poll();
                boolean z2 = poll == 0;
                boolean z3 = poll instanceof b;
                if (z && (z2 || z3)) {
                    simplePlainQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        for (UnicastProcessor<T> unicastProcessor : list) {
                            unicastProcessor.onError(th);
                        }
                    } else {
                        for (UnicastProcessor<T> unicastProcessor2 : list) {
                            unicastProcessor2.onComplete();
                        }
                    }
                    list.clear();
                    this.f.dispose();
                    return;
                } else if (z2) {
                    i2 = leave(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    U u = poll;
                    if (!u.b) {
                        list.remove(u.a);
                        u.a.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.j = true;
                        }
                    } else if (!this.cancelled) {
                        long requested = requested();
                        if (requested != 0) {
                            UnicastProcessor<T> create = UnicastProcessor.create(this.g);
                            list.add(create);
                            subscriber.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1);
                            }
                            this.f.schedule(new a(create), this.c, this.e);
                        } else {
                            subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    for (UnicastProcessor<T> unicastProcessor3 : list) {
                        unicastProcessor3.onNext(poll);
                    }
                }
            }
            this.i.cancel();
            simplePlainQueue.clear();
            list.clear();
            this.f.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (fastEnter()) {
                for (UnicastProcessor<T> unicastProcessor : this.h) {
                    unicastProcessor.onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t);
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                this.downstream.onSubscribe(this);
                if (!this.cancelled) {
                    long requested = requested();
                    if (requested != 0) {
                        UnicastProcessor<T> create = UnicastProcessor.create(this.g);
                        this.h.add(create);
                        this.downstream.onNext(create);
                        if (requested != Long.MAX_VALUE) {
                            produced(1);
                        }
                        this.f.schedule(new a(create), this.c, this.e);
                        Scheduler.Worker worker = this.f;
                        long j2 = this.d;
                        worker.schedulePeriodically(this, j2, j2, this.e);
                        subscription.request(Long.MAX_VALUE);
                        return;
                    }
                    subscription.cancel();
                    this.downstream.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            requested(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(UnicastProcessor.create(this.g), true);
            if (!this.cancelled) {
                this.queue.offer(bVar);
            }
            if (enter()) {
                a();
            }
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

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        long j = this.b;
        long j2 = this.c;
        if (j == j2) {
            long j3 = this.f;
            if (j3 == Long.MAX_VALUE) {
                this.source.subscribe((FlowableSubscriber) new b(serializedSubscriber, this.b, this.d, this.e, this.g));
            } else {
                this.source.subscribe((FlowableSubscriber) new a(serializedSubscriber, j, this.d, this.e, this.g, j3, this.h));
            }
        } else {
            this.source.subscribe((FlowableSubscriber) new c(serializedSubscriber, j, j2, this.d, this.e.createWorker(), this.g));
        }
    }
}
