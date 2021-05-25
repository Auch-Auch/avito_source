package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class ParallelCollector<T, A, R> extends Flowable<R> {
    public final ParallelFlowable<? extends T> b;
    public final Collector<T, A, R> c;

    public static final class a<T, A, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        public final b<T, A, R> a;
        public final BiConsumer<A, T> b;
        public final BinaryOperator<A> c;
        public A d;
        public boolean e;

        public a(b<T, A, R> bVar, A a3, BiConsumer<A, T> biConsumer, BinaryOperator<A> binaryOperator) {
            this.a = bVar;
            this.b = biConsumer;
            this.c = binaryOperator;
            this.d = a3;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0010 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x0010 */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: A */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: T */
        /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: T */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX DEBUG: Type inference failed for r0v20. Raw type applied. Possible types: T, A */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0041 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x003b A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x002f A[SYNTHETIC] */
        @Override // org.reactivestreams.Subscriber
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r9 = this;
                boolean r0 = r9.e
                if (r0 != 0) goto L_0x009c
                A r0 = r9.d
                r1 = 0
                r9.d = r1
                r2 = 1
                r9.e = r2
                io.reactivex.rxjava3.internal.jdk8.ParallelCollector$b<T, A, R> r3 = r9.a
                java.util.function.BinaryOperator<A> r4 = r9.c
            L_0x0010:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$c<A>> r5 = r3.b
                java.lang.Object r5 = r5.get()
                io.reactivex.rxjava3.internal.jdk8.ParallelCollector$c r5 = (io.reactivex.rxjava3.internal.jdk8.ParallelCollector.c) r5
                if (r5 != 0) goto L_0x0028
                io.reactivex.rxjava3.internal.jdk8.ParallelCollector$c r5 = new io.reactivex.rxjava3.internal.jdk8.ParallelCollector$c
                r5.<init>()
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$c<A>> r6 = r3.b
                boolean r6 = r6.compareAndSet(r1, r5)
                if (r6 != 0) goto L_0x0028
                goto L_0x0010
            L_0x0028:
                int r6 = r5.get()
                r7 = 2
                if (r6 < r7) goto L_0x0031
                r6 = -1
                goto L_0x0039
            L_0x0031:
                int r8 = r6 + 1
                boolean r8 = r5.compareAndSet(r6, r8)
                if (r8 == 0) goto L_0x0028
            L_0x0039:
                if (r6 >= 0) goto L_0x0041
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$c<A>> r6 = r3.b
                r6.compareAndSet(r5, r1)
                goto L_0x0010
            L_0x0041:
                if (r6 != 0) goto L_0x0046
                r5.a = r0
                goto L_0x0048
            L_0x0046:
                r5.b = r0
            L_0x0048:
                java.util.concurrent.atomic.AtomicInteger r0 = r5.c
                int r0 = r0.incrementAndGet()
                if (r0 != r7) goto L_0x0052
                r0 = 1
                goto L_0x0053
            L_0x0052:
                r0 = 0
            L_0x0053:
                if (r0 == 0) goto L_0x005b
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$c<A>> r0 = r3.b
                r0.compareAndSet(r5, r1)
                goto L_0x005c
            L_0x005b:
                r5 = r1
            L_0x005c:
                if (r5 == 0) goto L_0x006f
                T r0 = r5.a     // Catch:{ all -> 0x0067 }
                T r5 = r5.b     // Catch:{ all -> 0x0067 }
                java.lang.Object r0 = r4.apply(r0, r5)     // Catch:{ all -> 0x0067 }
                goto L_0x0010
            L_0x0067:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r3.a(r0)
                goto L_0x009c
            L_0x006f:
                java.util.concurrent.atomic.AtomicInteger r0 = r3.c
                int r0 = r0.decrementAndGet()
                if (r0 != 0) goto L_0x009c
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$c<A>> r0 = r3.b
                java.lang.Object r0 = r0.get()
                io.reactivex.rxjava3.internal.jdk8.ParallelCollector$c r0 = (io.reactivex.rxjava3.internal.jdk8.ParallelCollector.c) r0
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$c<A>> r2 = r3.b
                r2.lazySet(r1)
                java.util.function.Function<A, R> r1 = r3.e     // Catch:{ all -> 0x0095 }
                T r0 = r0.a     // Catch:{ all -> 0x0095 }
                java.lang.Object r0 = r1.apply(r0)     // Catch:{ all -> 0x0095 }
                java.lang.String r1 = "The finisher returned a null value"
                java.util.Objects.requireNonNull(r0, r1)     // Catch:{ all -> 0x0095 }
                r3.complete(r0)
                goto L_0x009c
            L_0x0095:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r3.a(r0)
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelCollector.a.onComplete():void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = null;
            this.e = true;
            this.a.a(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.e) {
                try {
                    this.b.accept(this.d, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    ((Subscription) get()).cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class b<T, A, R> extends DeferredScalarSubscription<R> {
        private static final long serialVersionUID = -5370107872170712765L;
        public final a<T, A, R>[] a;
        public final AtomicReference<c<A>> b = new AtomicReference<>();
        public final AtomicInteger c = new AtomicInteger();
        public final AtomicThrowable d = new AtomicThrowable();
        public final Function<A, R> e;

        public b(Subscriber<? super R> subscriber, int i, Collector<T, A, R> collector) {
            super(subscriber);
            this.e = collector.finisher();
            a<T, A, R>[] aVarArr = new a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = new a<>(this, collector.supplier().get(), collector.accumulator(), collector.combiner());
            }
            this.a = aVarArr;
            this.c.lazySet(i);
        }

        public void a(Throwable th) {
            if (this.d.compareAndSet(null, th)) {
                cancel();
                this.downstream.onError(th);
            } else if (th != this.d.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            a<T, A, R>[] aVarArr = this.a;
            for (a<T, A, R> aVar : aVarArr) {
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

    public ParallelCollector(ParallelFlowable<? extends T> parallelFlowable, Collector<T, A, R> collector) {
        this.b = parallelFlowable;
        this.c = collector;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            b bVar = new b(subscriber, this.b.parallelism(), this.c);
            subscriber.onSubscribe(bVar);
            this.b.subscribe(bVar.a);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
