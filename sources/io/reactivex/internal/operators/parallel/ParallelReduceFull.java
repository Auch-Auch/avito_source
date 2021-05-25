package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class ParallelReduceFull<T> extends Flowable<T> {
    public final ParallelFlowable<? extends T> b;
    public final BiFunction<T, T, T> c;

    public static final class a<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        public final b<T> a;
        public final BiFunction<T, T, T> b;
        public T c;
        public boolean d;

        public a(b<T> bVar, BiFunction<T, T, T> biFunction) {
            this.a = bVar;
            this.b = biFunction;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x003f A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0039 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x002d A[SYNTHETIC] */
        @Override // org.reactivestreams.Subscriber
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r8 = this;
                boolean r0 = r8.d
                if (r0 != 0) goto L_0x0097
                r0 = 1
                r8.d = r0
                io.reactivex.internal.operators.parallel.ParallelReduceFull$b<T> r1 = r8.a
                T r2 = r8.c
                r3 = 0
                if (r2 == 0) goto L_0x0075
            L_0x000e:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$c<T>> r4 = r1.c
                java.lang.Object r4 = r4.get()
                io.reactivex.internal.operators.parallel.ParallelReduceFull$c r4 = (io.reactivex.internal.operators.parallel.ParallelReduceFull.c) r4
                if (r4 != 0) goto L_0x0026
                io.reactivex.internal.operators.parallel.ParallelReduceFull$c r4 = new io.reactivex.internal.operators.parallel.ParallelReduceFull$c
                r4.<init>()
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$c<T>> r5 = r1.c
                boolean r5 = r5.compareAndSet(r3, r4)
                if (r5 != 0) goto L_0x0026
                goto L_0x000e
            L_0x0026:
                int r5 = r4.get()
                r6 = 2
                if (r5 < r6) goto L_0x002f
                r5 = -1
                goto L_0x0037
            L_0x002f:
                int r7 = r5 + 1
                boolean r7 = r4.compareAndSet(r5, r7)
                if (r7 == 0) goto L_0x0026
            L_0x0037:
                if (r5 >= 0) goto L_0x003f
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$c<T>> r5 = r1.c
                r5.compareAndSet(r4, r3)
                goto L_0x000e
            L_0x003f:
                if (r5 != 0) goto L_0x0044
                r4.a = r2
                goto L_0x0046
            L_0x0044:
                r4.b = r2
            L_0x0046:
                java.util.concurrent.atomic.AtomicInteger r2 = r4.c
                int r2 = r2.incrementAndGet()
                if (r2 != r6) goto L_0x0050
                r2 = 1
                goto L_0x0051
            L_0x0050:
                r2 = 0
            L_0x0051:
                if (r2 == 0) goto L_0x0059
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$c<T>> r2 = r1.c
                r2.compareAndSet(r4, r3)
                goto L_0x005a
            L_0x0059:
                r4 = r3
            L_0x005a:
                if (r4 == 0) goto L_0x0075
                io.reactivex.functions.BiFunction<T, T, T> r2 = r1.b     // Catch:{ all -> 0x006d }
                T r5 = r4.a     // Catch:{ all -> 0x006d }
                T r4 = r4.b     // Catch:{ all -> 0x006d }
                java.lang.Object r2 = r2.apply(r5, r4)     // Catch:{ all -> 0x006d }
                java.lang.String r4 = "The reducer returned a null value"
                java.lang.Object r2 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r2, r4)     // Catch:{ all -> 0x006d }
                goto L_0x000e
            L_0x006d:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                r1.a(r0)
                goto L_0x0097
            L_0x0075:
                java.util.concurrent.atomic.AtomicInteger r0 = r1.d
                int r0 = r0.decrementAndGet()
                if (r0 != 0) goto L_0x0097
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$c<T>> r0 = r1.c
                java.lang.Object r0 = r0.get()
                io.reactivex.internal.operators.parallel.ParallelReduceFull$c r0 = (io.reactivex.internal.operators.parallel.ParallelReduceFull.c) r0
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$c<T>> r2 = r1.c
                r2.lazySet(r3)
                if (r0 == 0) goto L_0x0092
                T r0 = r0.a
                r1.complete(r0)
                goto L_0x0097
            L_0x0092:
                org.reactivestreams.Subscriber<? super T> r0 = r1.downstream
                r0.onComplete()
            L_0x0097:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelReduceFull.a.onComplete():void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            this.a.a(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.d) {
                T t2 = this.c;
                if (t2 == null) {
                    this.c = t;
                    return;
                }
                try {
                    this.c = (T) ObjectHelper.requireNonNull(this.b.apply(t2, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    ((Subscription) get()).cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class b<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        public final a<T>[] a;
        public final BiFunction<T, T, T> b;
        public final AtomicReference<c<T>> c = new AtomicReference<>();
        public final AtomicInteger d = new AtomicInteger();
        public final AtomicReference<Throwable> e = new AtomicReference<>();

        public b(Subscriber<? super T> subscriber, int i, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            a<T>[] aVarArr = new a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = new a<>(this, biFunction);
            }
            this.a = aVarArr;
            this.b = biFunction;
            this.d.lazySet(i);
        }

        public void a(Throwable th) {
            if (this.e.compareAndSet(null, th)) {
                cancel();
                this.downstream.onError(th);
            } else if (th != this.e.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            a<T>[] aVarArr = this.a;
            for (a<T> aVar : aVarArr) {
                Objects.requireNonNull(aVar);
                SubscriptionHelper.cancel(aVar);
            }
        }
    }

    public static final class c<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        public T a;
        public T b;
        public final AtomicInteger c = new AtomicInteger();
    }

    public ParallelReduceFull(ParallelFlowable<? extends T> parallelFlowable, BiFunction<T, T, T> biFunction) {
        this.b = parallelFlowable;
        this.c = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        b bVar = new b(subscriber, this.b.parallelism(), this.c);
        subscriber.onSubscribe(bVar);
        this.b.subscribe(bVar.a);
    }
}
