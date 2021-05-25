package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
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

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
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

        public void b() {
            boolean z;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.a;
                List<T>[] listArr = this.c;
                int[] iArr = this.d;
                int length = iArr.length;
                int i2 = 1;
                do {
                    long j = this.f.get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.g) {
                            Arrays.fill(listArr, (Object) null);
                            return;
                        }
                        Throwable th = this.i.get();
                        if (th != null) {
                            a();
                            Arrays.fill(listArr, (Object) null);
                            subscriber.onError(th);
                            return;
                        }
                        int i3 = -1;
                        T t = null;
                        for (int i4 = 0; i4 < length; i4++) {
                            List<T> list = listArr[i4];
                            int i5 = iArr[i4];
                            if (list.size() != i5) {
                                if (t == null) {
                                    t = list.get(i5);
                                } else {
                                    T t2 = list.get(i5);
                                    try {
                                        if (this.e.compare(t, t2) > 0) {
                                            t = t2;
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        a();
                                        Arrays.fill(listArr, (Object) null);
                                        if (!this.i.compareAndSet(null, th2)) {
                                            RxJavaPlugins.onError(th2);
                                        }
                                        subscriber.onError(this.i.get());
                                        return;
                                    }
                                }
                                i3 = i4;
                            }
                        }
                        if (t == null) {
                            Arrays.fill(listArr, (Object) null);
                            subscriber.onComplete();
                            return;
                        }
                        subscriber.onNext(t);
                        iArr[i3] = iArr[i3] + 1;
                        j2++;
                    }
                    if (this.g) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th3 = this.i.get();
                    if (th3 != null) {
                        a();
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onError(th3);
                        return;
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            z = true;
                            break;
                        } else if (iArr[i6] != listArr[i6].size()) {
                            z = false;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (z) {
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onComplete();
                        return;
                    }
                    if (j2 != 0) {
                        BackpressureHelper.produced(this.f, j2);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
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

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        b bVar = new b(subscriber, this.b.parallelism(), this.c);
        subscriber.onSubscribe(bVar);
        this.b.subscribe(bVar.b);
    }
}
