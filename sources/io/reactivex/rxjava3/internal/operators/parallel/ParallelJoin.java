package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class ParallelJoin<T> extends Flowable<T> {
    public final ParallelFlowable<? extends T> b;
    public final int c;
    public final boolean d;

    public static final class a<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        public final c<T> a;
        public final int b;
        public final int c;
        public long d;
        public volatile SimplePlainQueue<T> e;

        public a(c<T> cVar, int i) {
            this.a = cVar;
            this.b = i;
            this.c = i - (i >> 2);
        }

        public SimplePlainQueue<T> a() {
            SimplePlainQueue<T> simplePlainQueue = this.e;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.b);
            this.e = spscArrayQueue;
            return spscArrayQueue;
        }

        public void b(long j) {
            long j2 = this.d + j;
            if (j2 >= ((long) this.c)) {
                this.d = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.d = j2;
        }

        public void c() {
            long j = this.d + 1;
            if (j == ((long) this.c)) {
                this.d = 0;
                ((Subscription) get()).request(j);
                return;
            }
            this.d = j;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.d();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.e(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.f(this, t);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, (long) this.b);
        }
    }

    public static final class b<T> extends c<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        public b(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.c
        public void c() {
            if (getAndIncrement() == 0) {
                h();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.c
        public void d() {
            this.f.decrementAndGet();
            c();
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.c
        public void e(Throwable th) {
            if (this.c.compareAndSet(null, th)) {
                a();
                c();
            } else if (th != this.c.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.c
        public void f(a<T> aVar, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.d.get() != 0) {
                    this.a.onNext(t);
                    if (this.d.get() != Long.MAX_VALUE) {
                        this.d.decrementAndGet();
                    }
                    aVar.b(1);
                } else if (!aVar.a().offer(t)) {
                    a();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.c.compareAndSet(null, missingBackpressureException)) {
                        this.a.onError(missingBackpressureException);
                        return;
                    } else {
                        RxJavaPlugins.onError(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!aVar.a().offer(t)) {
                a();
                e(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
            if (r13 == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
            if (r15 == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
            if (r15 == false) goto L_0x0011;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h() {
            /*
                r18 = this;
                r0 = r18
                io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin$a<T>[] r1 = r0.b
                int r2 = r1.length
                org.reactivestreams.Subscriber<? super T> r3 = r0.a
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.d
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r13 == 0) goto L_0x0067
                boolean r13 = r0.e
                if (r13 == 0) goto L_0x001d
                r18.b()
                return
            L_0x001d:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r13 = r0.c
                java.lang.Object r13 = r13.get()
                java.lang.Throwable r13 = (java.lang.Throwable) r13
                if (r13 == 0) goto L_0x002e
                r18.b()
                r3.onError(r13)
                return
            L_0x002e:
                java.util.concurrent.atomic.AtomicInteger r13 = r0.f
                int r13 = r13.get()
                if (r13 != 0) goto L_0x0038
                r13 = 1
                goto L_0x0039
            L_0x0038:
                r13 = 0
            L_0x0039:
                r14 = 0
                r15 = 1
            L_0x003b:
                int r4 = r1.length
                if (r14 >= r4) goto L_0x005d
                r4 = r1[r14]
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<T> r12 = r4.e
                if (r12 == 0) goto L_0x005a
                java.lang.Object r12 = r12.poll()
                if (r12 == 0) goto L_0x005a
                r3.onNext(r12)
                r4.c()
                r16 = 1
                long r10 = r10 + r16
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0059
                goto L_0x0067
            L_0x0059:
                r15 = 0
            L_0x005a:
                int r14 = r14 + 1
                goto L_0x003b
            L_0x005d:
                if (r13 == 0) goto L_0x0065
                if (r15 == 0) goto L_0x0065
                r3.onComplete()
                return
            L_0x0065:
                if (r15 == 0) goto L_0x0011
            L_0x0067:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x00ac
                boolean r4 = r0.e
                if (r4 == 0) goto L_0x0073
                r18.b()
                return
            L_0x0073:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r4 = r0.c
                java.lang.Object r4 = r4.get()
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                if (r4 == 0) goto L_0x0084
                r18.b()
                r3.onError(r4)
                return
            L_0x0084:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.f
                int r4 = r4.get()
                if (r4 != 0) goto L_0x008e
                r4 = 1
                goto L_0x008f
            L_0x008e:
                r4 = 0
            L_0x008f:
                r6 = 0
            L_0x0090:
                if (r6 >= r2) goto L_0x00a3
                r7 = r1[r6]
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<T> r7 = r7.e
                if (r7 == 0) goto L_0x00a0
                boolean r7 = r7.isEmpty()
                if (r7 != 0) goto L_0x00a0
                r12 = 0
                goto L_0x00a4
            L_0x00a0:
                int r6 = r6 + 1
                goto L_0x0090
            L_0x00a3:
                r12 = 1
            L_0x00a4:
                if (r4 == 0) goto L_0x00ac
                if (r12 == 0) goto L_0x00ac
                r3.onComplete()
                return
            L_0x00ac:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00b5
                java.util.concurrent.atomic.AtomicLong r4 = r0.d
                io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r4, r10)
            L_0x00b5:
                int r4 = -r5
                int r5 = r0.addAndGet(r4)
                if (r5 != 0) goto L_0x0008
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.b.h():void");
        }
    }

    public static abstract class c<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        public final Subscriber<? super T> a;
        public final a<T>[] b;
        public final AtomicThrowable c = new AtomicThrowable();
        public final AtomicLong d = new AtomicLong();
        public volatile boolean e;
        public final AtomicInteger f = new AtomicInteger();

        public c(Subscriber<? super T> subscriber, int i, int i2) {
            this.a = subscriber;
            a<T>[] aVarArr = new a[i];
            for (int i3 = 0; i3 < i; i3++) {
                aVarArr[i3] = new a<>(this, i2);
            }
            this.b = aVarArr;
            this.f.lazySet(i);
        }

        public void a() {
            a<T>[] aVarArr = this.b;
            for (a<T> aVar : aVarArr) {
                Objects.requireNonNull(aVar);
                SubscriptionHelper.cancel(aVar);
            }
        }

        public void b() {
            for (a<T> aVar : this.b) {
                aVar.e = null;
            }
        }

        public abstract void c();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.e) {
                this.e = true;
                a();
                if (getAndIncrement() == 0) {
                    b();
                }
            }
        }

        public abstract void d();

        public abstract void e(Throwable th);

        public abstract void f(a<T> aVar, T t);

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.d, j);
                c();
            }
        }
    }

    public static final class d<T> extends c<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        public d(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.c
        public void c() {
            if (getAndIncrement() == 0) {
                h();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.c
        public void d() {
            this.f.decrementAndGet();
            c();
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.c
        public void e(Throwable th) {
            if (this.c.tryAddThrowableOrReport(th)) {
                this.f.decrementAndGet();
                c();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.c
        public void f(a<T> aVar, T t) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                if (!aVar.a().offer(t)) {
                    SubscriptionHelper.cancel(aVar);
                    this.c.tryAddThrowableOrReport(new MissingBackpressureException("Queue full?!"));
                    this.f.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                if (this.d.get() != 0) {
                    this.a.onNext(t);
                    if (this.d.get() != Long.MAX_VALUE) {
                        this.d.decrementAndGet();
                    }
                    aVar.b(1);
                } else if (!aVar.a().offer(t)) {
                    SubscriptionHelper.cancel(aVar);
                    this.c.tryAddThrowableOrReport(new MissingBackpressureException("Queue full?!"));
                    this.f.decrementAndGet();
                    h();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
            if (r13 == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            if (r15 == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
            r18.c.tryTerminateConsumer(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
            if (r15 == false) goto L_0x0011;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h() {
            /*
                r18 = this;
                r0 = r18
                io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin$a<T>[] r1 = r0.b
                int r2 = r1.length
                org.reactivestreams.Subscriber<? super T> r3 = r0.a
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.d
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r13 == 0) goto L_0x0057
                boolean r13 = r0.e
                if (r13 == 0) goto L_0x001d
                r18.b()
                return
            L_0x001d:
                java.util.concurrent.atomic.AtomicInteger r13 = r0.f
                int r13 = r13.get()
                if (r13 != 0) goto L_0x0027
                r13 = 1
                goto L_0x0028
            L_0x0027:
                r13 = 0
            L_0x0028:
                r14 = 0
                r15 = 1
            L_0x002a:
                if (r14 >= r2) goto L_0x004b
                r4 = r1[r14]
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<T> r12 = r4.e
                if (r12 == 0) goto L_0x0048
                java.lang.Object r12 = r12.poll()
                if (r12 == 0) goto L_0x0048
                r3.onNext(r12)
                r4.c()
                r16 = 1
                long r10 = r10 + r16
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0047
                goto L_0x0057
            L_0x0047:
                r15 = 0
            L_0x0048:
                int r14 = r14 + 1
                goto L_0x002a
            L_0x004b:
                if (r13 == 0) goto L_0x0055
                if (r15 == 0) goto L_0x0055
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r0.c
                r1.tryTerminateConsumer(r3)
                return
            L_0x0055:
                if (r15 == 0) goto L_0x0011
            L_0x0057:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x008d
                boolean r4 = r0.e
                if (r4 == 0) goto L_0x0063
                r18.b()
                return
            L_0x0063:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.f
                int r4 = r4.get()
                if (r4 != 0) goto L_0x006d
                r4 = 1
                goto L_0x006e
            L_0x006d:
                r4 = 0
            L_0x006e:
                r6 = 0
            L_0x006f:
                if (r6 >= r2) goto L_0x0082
                r7 = r1[r6]
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<T> r7 = r7.e
                if (r7 == 0) goto L_0x007f
                boolean r7 = r7.isEmpty()
                if (r7 != 0) goto L_0x007f
                r12 = 0
                goto L_0x0083
            L_0x007f:
                int r6 = r6 + 1
                goto L_0x006f
            L_0x0082:
                r12 = 1
            L_0x0083:
                if (r4 == 0) goto L_0x008d
                if (r12 == 0) goto L_0x008d
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r0.c
                r1.tryTerminateConsumer(r3)
                return
            L_0x008d:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x0096
                java.util.concurrent.atomic.AtomicLong r4 = r0.d
                io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r4, r10)
            L_0x0096:
                int r4 = -r5
                int r5 = r0.addAndGet(r4)
                if (r5 != 0) goto L_0x0008
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin.d.h():void");
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i, boolean z) {
        this.b = parallelFlowable;
        this.c = i;
        this.d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        c cVar;
        if (this.d) {
            cVar = new d(subscriber, this.b.parallelism(), this.c);
        } else {
            cVar = new b(subscriber, this.b.parallelism(), this.c);
        }
        subscriber.onSubscribe(cVar);
        this.b.subscribe(cVar.b);
    }
}
