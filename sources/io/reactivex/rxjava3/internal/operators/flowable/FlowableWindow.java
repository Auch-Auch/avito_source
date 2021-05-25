package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableWindow<T> extends s6.a.e.d.c.a.a<T, Flowable<T>> {
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
            s6.a.e.d.c.a.b bVar;
            long j = this.e;
            UnicastProcessor<T> unicastProcessor = this.g;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.d, this);
                this.g = unicastProcessor;
                bVar = new s6.a.e.d.c.a.b(unicastProcessor);
                this.a.onNext(bVar);
            } else {
                bVar = null;
            }
            long j2 = j + 1;
            unicastProcessor.onNext(t);
            if (j2 == this.b) {
                this.e = 0;
                this.g = null;
                unicastProcessor.onComplete();
            } else {
                this.e = j2;
            }
            if (bVar != null && bVar.f()) {
                bVar.b.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
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
            if (!z) {
                return false;
            }
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

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
            if (r10 != 0) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
            if (r15.p == false) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x006e, code lost:
            if (a(r15.n, r1.isEmpty(), r0, r1) == false) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
            if (r8 == 0) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x007c, code lost:
            if (r4 == Long.MAX_VALUE) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x007e, code lost:
            r15.h.addAndGet(-r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x000f, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r15 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r15.i
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super io.reactivex.rxjava3.core.Flowable<T>> r0 = r15.a
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<io.reactivex.rxjava3.processors.UnicastProcessor<T>> r1 = r15.b
                r2 = 1
                r3 = 1
            L_0x000f:
                boolean r4 = r15.p
                if (r4 == 0) goto L_0x001f
            L_0x0013:
                java.lang.Object r4 = r1.poll()
                io.reactivex.rxjava3.processors.UnicastProcessor r4 = (io.reactivex.rxjava3.processors.UnicastProcessor) r4
                if (r4 == 0) goto L_0x0084
                r4.onComplete()
                goto L_0x0013
            L_0x001f:
                java.util.concurrent.atomic.AtomicLong r4 = r15.h
                long r4 = r4.get()
                r6 = 0
                r8 = r6
            L_0x0028:
                int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r10 == 0) goto L_0x005d
                boolean r11 = r15.n
                java.lang.Object r12 = r1.poll()
                io.reactivex.rxjava3.processors.UnicastProcessor r12 = (io.reactivex.rxjava3.processors.UnicastProcessor) r12
                if (r12 != 0) goto L_0x0038
                r13 = 1
                goto L_0x0039
            L_0x0038:
                r13 = 0
            L_0x0039:
                boolean r14 = r15.p
                if (r14 == 0) goto L_0x003e
                goto L_0x000f
            L_0x003e:
                boolean r11 = r15.a(r11, r13, r0, r1)
                if (r11 == 0) goto L_0x0045
                return
            L_0x0045:
                if (r13 == 0) goto L_0x0048
                goto L_0x005d
            L_0x0048:
                s6.a.e.d.c.a.b r10 = new s6.a.e.d.c.a.b
                r10.<init>(r12)
                r0.onNext(r10)
                boolean r10 = r10.f()
                if (r10 == 0) goto L_0x0059
                r12.onComplete()
            L_0x0059:
                r10 = 1
                long r8 = r8 + r10
                goto L_0x0028
            L_0x005d:
                if (r10 != 0) goto L_0x0071
                boolean r10 = r15.p
                if (r10 == 0) goto L_0x0064
                goto L_0x000f
            L_0x0064:
                boolean r10 = r15.n
                boolean r11 = r1.isEmpty()
                boolean r10 = r15.a(r10, r11, r0, r1)
                if (r10 == 0) goto L_0x0071
                return
            L_0x0071:
                int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r10 == 0) goto L_0x0084
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r10 == 0) goto L_0x0084
                java.util.concurrent.atomic.AtomicLong r4 = r15.h
                long r5 = -r8
                r4.addAndGet(r5)
            L_0x0084:
                java.util.concurrent.atomic.AtomicInteger r4 = r15.i
                int r3 = -r3
                int r3 = r4.addAndGet(r3)
                if (r3 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow.b.b():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.p = true;
            if (this.f.compareAndSet(false, true)) {
                run();
            }
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Iterator<UnicastProcessor<T>> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.e.clear();
            this.n = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
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
            UnicastProcessor<T> unicastProcessor;
            long j2 = this.k;
            if (j2 != 0 || this.p) {
                unicastProcessor = null;
            } else {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.j, this);
                this.e.offer(unicastProcessor);
            }
            long j3 = j2 + 1;
            Iterator<UnicastProcessor<T>> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (unicastProcessor != null) {
                this.b.offer(unicastProcessor);
                b();
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

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
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
            s6.a.e.d.c.a.b bVar;
            long j = this.g;
            UnicastProcessor<T> unicastProcessor = this.i;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.f, this);
                this.i = unicastProcessor;
                bVar = new s6.a.e.d.c.a.b(unicastProcessor);
                this.a.onNext(bVar);
            } else {
                bVar = null;
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
            if (bVar != null && bVar.f()) {
                bVar.b.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
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

    @Override // io.reactivex.rxjava3.core.Flowable
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
