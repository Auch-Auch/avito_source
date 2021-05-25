package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMap;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    @Nullable
    public final Publisher<? extends T>[] b;
    @Nullable
    public final Iterable<? extends Publisher<? extends T>> c;
    public final Function<? super Object[], ? extends R> d;
    public final int e;
    public final boolean f;

    public static final class a<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        public final Subscriber<? super R> a;
        public final Function<? super Object[], ? extends R> b;
        public final b<T>[] c;
        public final SpscLinkedArrayQueue<Object> d;
        public final Object[] e;
        public final boolean f;
        public boolean g;
        public int h;
        public int i;
        public volatile boolean j;
        public final AtomicLong k;
        public volatile boolean l;
        public final AtomicThrowable m;

        public a(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z) {
            this.a = subscriber;
            this.b = function;
            b<T>[] bVarArr = new b[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                bVarArr[i4] = new b<>(this, i4, i3);
            }
            this.c = bVarArr;
            this.e = new Object[i2];
            this.d = new SpscLinkedArrayQueue<>(i3);
            this.k = new AtomicLong();
            this.m = new AtomicThrowable();
            this.f = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.j = true;
            d();
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.d.clear();
        }

        public void d() {
            b<T>[] bVarArr = this.c;
            for (b<T> bVar : bVarArr) {
                Objects.requireNonNull(bVar);
                SubscriptionHelper.cancel(bVar);
            }
        }

        public void drain() {
            int i2;
            if (getAndIncrement() == 0) {
                int i3 = 1;
                if (this.g) {
                    Subscriber<? super R> subscriber = this.a;
                    SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.d;
                    while (!this.j) {
                        Throwable th = (Throwable) this.m.get();
                        if (th != null) {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(th);
                            return;
                        }
                        boolean z = this.l;
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (!isEmpty) {
                            subscriber.onNext(null);
                        }
                        if (!z || !isEmpty) {
                            i3 = addAndGet(-i3);
                            if (i3 == 0) {
                                return;
                            }
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    spscLinkedArrayQueue.clear();
                    return;
                }
                Subscriber<? super R> subscriber2 = this.a;
                SpscLinkedArrayQueue<?> spscLinkedArrayQueue2 = this.d;
                int i4 = 1;
                do {
                    long j2 = this.k.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z2 = this.l;
                        Object poll = spscLinkedArrayQueue2.poll();
                        boolean z3 = poll == null;
                        if (!h(z2, z3, subscriber2, spscLinkedArrayQueue2)) {
                            if (z3) {
                                break;
                            }
                            try {
                                Object obj = (Object) this.b.apply((Object[]) spscLinkedArrayQueue2.poll());
                                Objects.requireNonNull(obj, "The combiner returned a null value");
                                subscriber2.onNext(obj);
                                ((b) poll).a();
                                j3++;
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                d();
                                ExceptionHelper.addThrowable(this.m, th2);
                                subscriber2.onError(ExceptionHelper.terminate(this.m));
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !h(this.l, spscLinkedArrayQueue2.isEmpty(), subscriber2, spscLinkedArrayQueue2)) {
                        if (!(j3 == 0 || j2 == Long.MAX_VALUE)) {
                            this.k.addAndGet(-j3);
                        }
                        i4 = addAndGet(-i4);
                    } else {
                        return;
                    }
                } while (i4 != 0);
            }
        }

        public boolean h(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.j) {
                d();
                spscLinkedArrayQueue.clear();
                this.m.tryTerminateAndReport();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!this.f) {
                    Throwable terminate = ExceptionHelper.terminate(this.m);
                    if (terminate != null && terminate != ExceptionHelper.TERMINATED) {
                        d();
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(terminate);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        d();
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    d();
                    this.m.tryTerminateConsumer(subscriber);
                    return true;
                }
            }
        }

        public void i(int i2) {
            synchronized (this) {
                Object[] objArr = this.e;
                if (objArr[i2] != null) {
                    int i3 = this.i + 1;
                    if (i3 == objArr.length) {
                        this.l = true;
                    } else {
                        this.i = i3;
                        return;
                    }
                } else {
                    this.l = true;
                }
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.d.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() throws Throwable {
            Object poll = this.d.poll();
            if (poll == null) {
                return null;
            }
            R r = (R) this.b.apply((Object[]) this.d.poll());
            Objects.requireNonNull(r, "The combiner returned a null value");
            ((b) poll).a();
            return r;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.k, j2);
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            boolean z = false;
            if ((i2 & 4) != 0) {
                return 0;
            }
            int i3 = i2 & 2;
            if (i3 != 0) {
                z = true;
            }
            this.g = z;
            return i3;
        }
    }

    public static final class b<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        public final a<T, ?> a;
        public final int b;
        public final int c;
        public final int d;
        public int e;

        public b(a<T, ?> aVar, int i, int i2) {
            this.a = aVar;
            this.b = i;
            this.c = i2;
            this.d = i2 - (i2 >> 2);
        }

        public void a() {
            int i = this.e + 1;
            if (i == this.d) {
                this.e = 0;
                ((Subscription) get()).request((long) i);
                return;
            }
            this.e = i;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.i(this.b);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            a<T, ?> aVar = this.a;
            int i = this.b;
            if (!ExceptionHelper.addThrowable(aVar.m, th)) {
                RxJavaPlugins.onError(th);
            } else if (!aVar.f) {
                aVar.d();
                aVar.l = true;
                aVar.drain();
            } else {
                aVar.i(i);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            boolean z;
            a<T, ?> aVar = this.a;
            int i = this.b;
            synchronized (aVar) {
                Object[] objArr = aVar.e;
                int i2 = aVar.h;
                if (objArr[i] == null) {
                    i2++;
                    aVar.h = i2;
                }
                objArr[i] = t;
                if (objArr.length == i2) {
                    aVar.d.offer(aVar.c[i], objArr.clone());
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                aVar.c[i].a();
            } else {
                aVar.drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, (long) this.c);
        }
    }

    public final class c implements Function<T, R> {
        public c() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.rxjava3.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public R apply(T r4) throws java.lang.Throwable {
            /*
                r3 = this;
                io.reactivex.rxjava3.internal.operators.flowable.FlowableCombineLatest r0 = io.reactivex.rxjava3.internal.operators.flowable.FlowableCombineLatest.this
                io.reactivex.rxjava3.functions.Function<? super java.lang.Object[], ? extends R> r0 = r0.d
                r1 = 1
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                r1[r2] = r4
                java.lang.Object r4 = r0.apply(r1)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableCombineLatest.c.apply(java.lang.Object):java.lang.Object");
        }
    }

    public FlowableCombineLatest(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.b = publisherArr;
        this.c = null;
        this.d = function;
        this.e = i;
        this.f = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i;
        Publisher<? extends T>[] publisherArr = this.b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i = 0;
                for (Publisher<? extends T> publisher : this.c) {
                    if (i == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[((i >> 2) + i)];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, i);
                        publisherArr = publisherArr2;
                    }
                    int i2 = i + 1;
                    Objects.requireNonNull(publisher, "The Iterator returned a null Publisher");
                    publisherArr[i] = publisher;
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            i = publisherArr.length;
        }
        if (i == 0) {
            EmptySubscription.complete(subscriber);
        } else if (i == 1) {
            publisherArr[0].subscribe(new FlowableMap.b(subscriber, new c()));
        } else {
            a aVar = new a(subscriber, this.d, i, this.e, this.f);
            subscriber.onSubscribe(aVar);
            b<T>[] bVarArr = aVar.c;
            for (int i3 = 0; i3 < i && !aVar.l && !aVar.j; i3++) {
                publisherArr[i3].subscribe(bVarArr[i3]);
            }
        }
    }

    public FlowableCombineLatest(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.b = null;
        this.c = iterable;
        this.d = function;
        this.e = i;
        this.f = z;
    }
}
