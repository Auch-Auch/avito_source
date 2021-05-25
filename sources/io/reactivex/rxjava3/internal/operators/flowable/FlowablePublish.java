package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    public final Publisher<T> b;
    public final int c;
    public final AtomicReference<b<T>> d = new AtomicReference<>();

    public static final class a<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 2845000326761540265L;
        public final Subscriber<? super T> a;
        public final b<T> b;
        public long c;

        public a(Subscriber<? super T> subscriber, b<T> bVar) {
            this.a = subscriber;
            this.b = bVar;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.b.c(this);
                this.b.b();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.b.b();
            }
        }
    }

    public static final class b<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        public static final a[] k = new a[0];
        public static final a[] l = new a[0];
        private static final long serialVersionUID = -1672047311619175801L;
        public final AtomicReference<b<T>> a;
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final AtomicBoolean c = new AtomicBoolean();
        public final AtomicReference<a<T>[]> d;
        public final int e;
        public volatile SimpleQueue<T> f;
        public int g;
        public volatile boolean h;
        public Throwable i;
        public int j;

        public b(AtomicReference<b<T>> atomicReference, int i2) {
            this.a = atomicReference;
            this.e = i2;
            this.d = new AtomicReference<>(k);
        }

        public boolean a(boolean z, boolean z2) {
            if (!z || !z2) {
                return false;
            }
            Throwable th = this.i;
            if (th != null) {
                e(th);
                return true;
            }
            a<T>[] andSet = this.d.getAndSet(l);
            for (a<T> aVar : andSet) {
                if (!aVar.a()) {
                    aVar.a.onComplete();
                }
            }
            return true;
        }

        public void b() {
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.f;
                int i2 = this.j;
                int i3 = this.e;
                int i4 = i3 - (i3 >> 2);
                boolean z = this.g != 1;
                int i5 = 1;
                SimpleQueue<T> simpleQueue2 = simpleQueue;
                int i6 = i2;
                while (true) {
                    if (simpleQueue2 != null) {
                        long j2 = Long.MAX_VALUE;
                        a<T>[] aVarArr = this.d.get();
                        boolean z2 = false;
                        for (a<T> aVar : aVarArr) {
                            long j3 = aVar.get();
                            if (j3 != Long.MIN_VALUE) {
                                j2 = Math.min(j3 - aVar.c, j2);
                                z2 = true;
                            }
                        }
                        long j4 = 0;
                        if (!z2) {
                            j2 = 0;
                        }
                        while (true) {
                            if (j2 == j4) {
                                break;
                            }
                            boolean z3 = this.h;
                            try {
                                T poll = simpleQueue2.poll();
                                boolean z4 = poll == null;
                                if (!a(z3, z4)) {
                                    if (z4) {
                                        break;
                                    }
                                    for (a<T> aVar2 : aVarArr) {
                                        if (!aVar2.a()) {
                                            aVar2.a.onNext(poll);
                                            aVar2.c++;
                                        }
                                    }
                                    if (z && (i6 = i6 + 1) == i4) {
                                        this.b.get().request((long) i4);
                                        i6 = 0;
                                    }
                                    j2--;
                                    if (aVarArr != this.d.get()) {
                                        break;
                                    }
                                    j4 = 0;
                                } else {
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.b.get().cancel();
                                simpleQueue2.clear();
                                this.h = true;
                                e(th);
                                return;
                            }
                        }
                        if (a(this.h, simpleQueue2.isEmpty())) {
                            return;
                        }
                    }
                    this.j = i6;
                    i5 = addAndGet(-i5);
                    if (i5 == 0) {
                        return;
                    }
                    if (simpleQueue2 == null) {
                        simpleQueue2 = this.f;
                    }
                }
            }
        }

        public void c(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.d.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (aVarArr[i2] == aVar) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            aVarArr2 = k;
                        } else {
                            a<T>[] aVarArr3 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                            System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.d.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.d.getAndSet(l);
            this.a.compareAndSet(this, null);
            SubscriptionHelper.cancel(this.b);
        }

        public void e(Throwable th) {
            a<T>[] andSet = this.d.getAndSet(l);
            for (a<T> aVar : andSet) {
                if (!aVar.a()) {
                    aVar.a.onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.d.get() == l;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.h = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.i = th;
            this.h = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g != 0 || this.f.offer(t)) {
                b();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.b, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.g = requestFusion;
                        this.f = queueSubscription;
                        this.h = true;
                        b();
                        return;
                    } else if (requestFusion == 2) {
                        this.g = requestFusion;
                        this.f = queueSubscription;
                        subscription.request((long) this.e);
                        return;
                    }
                }
                this.f = new SpscArrayQueue(this.e);
                subscription.request((long) this.e);
            }
        }
    }

    public FlowablePublish(Publisher<T> publisher, int i) {
        this.b = publisher;
        this.c = i;
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        b<T> bVar;
        while (true) {
            bVar = this.d.get();
            if (bVar != null && !bVar.isDisposed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.d, this.c);
            if (this.d.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = true;
        if (bVar.c.get() || !bVar.c.compareAndSet(false, true)) {
            z = false;
        }
        try {
            consumer.accept(bVar);
            if (z) {
                this.b.subscribe(bVar);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void reset() {
        b<T> bVar = this.d.get();
        if (bVar != null && bVar.isDisposed()) {
            this.d.compareAndSet(bVar, null);
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.b;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        b<T> bVar;
        boolean z;
        while (true) {
            bVar = this.d.get();
            if (bVar != null) {
                break;
            }
            b<T> bVar2 = new b<>(this.d, this.c);
            if (this.d.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        a<T> aVar = new a<>(subscriber, bVar);
        subscriber.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = bVar.d.get();
            z = false;
            if (aVarArr != b.l) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (bVar.d.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            Throwable th = bVar.i;
            if (th != null) {
                aVar.a.onError(th);
            } else {
                aVar.a.onComplete();
            }
        } else if (aVar.a()) {
            bVar.c(aVar);
        } else {
            bVar.b();
        }
    }
}
