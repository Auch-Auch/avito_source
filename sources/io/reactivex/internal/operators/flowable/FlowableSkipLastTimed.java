package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableSkipLastTimed<T> extends s6.a.c.b.a.a<T, T> {
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;
    public final int e;
    public final boolean f;

    public static final class a<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        public final Subscriber<? super T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public final SpscLinkedArrayQueue<Object> e;
        public final boolean f;
        public Subscription g;
        public final AtomicLong h = new AtomicLong();
        public volatile boolean i;
        public volatile boolean j;
        public Throwable k;

        public a(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
            this.a = subscriber;
            this.b = j2;
            this.c = timeUnit;
            this.d = scheduler;
            this.e = new SpscLinkedArrayQueue<>(i2);
            this.f = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0078 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r24 = this;
                r0 = r24
                int r1 = r24.getAndIncrement()
                if (r1 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super T> r1 = r0.a
                io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> r2 = r0.e
                boolean r3 = r0.f
                java.util.concurrent.TimeUnit r4 = r0.c
                io.reactivex.Scheduler r5 = r0.d
                long r6 = r0.b
                r9 = 1
            L_0x0016:
                java.util.concurrent.atomic.AtomicLong r10 = r0.h
                long r10 = r10.get()
                r14 = 0
            L_0x001e:
                int r16 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
                if (r16 == 0) goto L_0x008a
                boolean r8 = r0.j
                java.lang.Object r17 = r2.peek()
                java.lang.Long r17 = (java.lang.Long) r17
                r18 = 0
                if (r17 != 0) goto L_0x0031
                r19 = 1
                goto L_0x0033
            L_0x0031:
                r19 = 0
            L_0x0033:
                long r20 = r5.now(r4)
                if (r19 != 0) goto L_0x0045
                long r22 = r17.longValue()
                long r20 = r20 - r6
                int r17 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
                if (r17 <= 0) goto L_0x0045
                r19 = 1
            L_0x0045:
                boolean r12 = r0.i
                if (r12 == 0) goto L_0x0051
                io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> r8 = r0.e
                r8.clear()
            L_0x004e:
                r18 = 1
                goto L_0x0076
            L_0x0051:
                if (r8 == 0) goto L_0x0076
                if (r3 == 0) goto L_0x0063
                if (r19 == 0) goto L_0x0076
                java.lang.Throwable r8 = r0.k
                if (r8 == 0) goto L_0x005f
                r1.onError(r8)
                goto L_0x004e
            L_0x005f:
                r1.onComplete()
                goto L_0x004e
            L_0x0063:
                java.lang.Throwable r8 = r0.k
                if (r8 == 0) goto L_0x0070
                io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> r12 = r0.e
                r12.clear()
                r1.onError(r8)
                goto L_0x004e
            L_0x0070:
                if (r19 == 0) goto L_0x0076
                r1.onComplete()
                goto L_0x004e
            L_0x0076:
                if (r18 == 0) goto L_0x0079
                return
            L_0x0079:
                if (r19 == 0) goto L_0x007c
                goto L_0x008a
            L_0x007c:
                r2.poll()
                java.lang.Object r8 = r2.poll()
                r1.onNext(r8)
                r12 = 1
                long r14 = r14 + r12
                goto L_0x001e
            L_0x008a:
                r10 = 0
                int r8 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
                if (r8 == 0) goto L_0x0095
                java.util.concurrent.atomic.AtomicLong r8 = r0.h
                io.reactivex.internal.util.BackpressureHelper.produced(r8, r14)
            L_0x0095:
                int r8 = -r9
                int r9 = r0.addAndGet(r8)
                if (r9 != 0) goto L_0x0016
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableSkipLastTimed.a.a():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.i) {
                this.i = true;
                this.g.cancel();
                if (getAndIncrement() == 0) {
                    this.e.clear();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.k = th;
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.e.offer(Long.valueOf(this.d.now(this.c)), t);
            a();
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
                BackpressureHelper.add(this.h, j2);
                a();
            }
        }
    }

    public FlowableSkipLastTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = i;
        this.f = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b, this.c, this.d, this.e, this.f));
    }
}
