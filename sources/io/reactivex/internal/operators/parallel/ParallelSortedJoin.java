package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class ParallelSortedJoin<T> extends Flowable<T> {
    public final ParallelFlowable<List<T>> b;
    public final Comparator<? super T> c;

    public static final class a<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        public final b<T> a;
        public final int b;

        public a(b<T> bVar, int i) {
            this.a = bVar;
            this.b = i;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            b<T> bVar = this.a;
            if (bVar.i.compareAndSet(null, th)) {
                bVar.b();
            } else if (th != bVar.i.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            b<T> bVar = this.a;
            int i = this.b;
            bVar.c[i] = (List) obj;
            if (bVar.h.decrementAndGet() == 0) {
                bVar.b();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class b<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        public final Subscriber<? super T> a;
        public final a<T>[] b;
        public final List<T>[] c;
        public final int[] d;
        public final Comparator<? super T> e;
        public final AtomicLong f = new AtomicLong();
        public volatile boolean g;
        public final AtomicInteger h = new AtomicInteger();
        public final AtomicReference<Throwable> i = new AtomicReference<>();

        public b(Subscriber<? super T> subscriber, int i2, Comparator<? super T> comparator) {
            this.a = subscriber;
            this.e = comparator;
            a<T>[] aVarArr = new a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = new a<>(this, i3);
            }
            this.b = aVarArr;
            this.c = new List[i2];
            this.d = new int[i2];
            this.h.lazySet(i2);
        }

        public void a() {
            a<T>[] aVarArr = this.b;
            for (a<T> aVar : aVarArr) {
                Objects.requireNonNull(aVar);
                SubscriptionHelper.cancel(aVar);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a3, code lost:
            if (r15 != 0) goto L_0x00e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a7, code lost:
            if (r16.g == false) goto L_0x00ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a9, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ad, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ae, code lost:
            r10 = r16.i.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b7, code lost:
            if (r10 == null) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b9, code lost:
            a();
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onError(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c2, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c3, code lost:
            r5 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c4, code lost:
            if (r5 >= r4) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ce, code lost:
            if (r0[r5] == r3[r5].size()) goto L_0x00d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d0, code lost:
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d2, code lost:
            r5 = r5 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d5, code lost:
            r13 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d6, code lost:
            if (r13 == false) goto L_0x00e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d8, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00df, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e4, code lost:
            if (r11 == 0) goto L_0x00f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ed, code lost:
            if (r7 == Long.MAX_VALUE) goto L_0x00f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ef, code lost:
            r16.f.addAndGet(-r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f5, code lost:
            r5 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f9, code lost:
            if (r5 != r6) goto L_0x0103;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00fb, code lost:
            r5 = addAndGet(-r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0100, code lost:
            if (r5 != 0) goto L_0x0103;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0102, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
            // Method dump skipped, instructions count: 262
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelSortedJoin.b.b():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.g) {
                this.g = true;
                a();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.c, (Object) null);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.f, j);
                if (this.h.get() == 0) {
                    b();
                }
            }
        }
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        this.b = parallelFlowable;
        this.c = comparator;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        b bVar = new b(subscriber, this.b.parallelism(), this.c);
        subscriber.onSubscribe(bVar);
        this.b.subscribe(bVar.b);
    }
}
