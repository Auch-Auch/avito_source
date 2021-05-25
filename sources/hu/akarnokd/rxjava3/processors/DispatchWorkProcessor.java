package hu.akarnokd.rxjava3.processors;

import hu.akarnokd.rxjava3.util.SpmcLinkedArrayQueue;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class DispatchWorkProcessor<T> extends FlowableProcessor<T> implements Disposable {
    public static final a[] k = new a[0];
    public static final a[] l = new a[0];
    public final SimplePlainQueue<T> b;
    public final AtomicReference<Subscription> c = new AtomicReference<>();
    public final AtomicReference<Throwable> d = new AtomicReference<>();
    public final boolean e;
    public final AtomicReference<a<T>[]> f = new AtomicReference<>(k);
    public final Scheduler g;
    public final long h;
    public final AtomicLong i;
    public final AtomicLong j;

    public static final class a<T> extends AtomicInteger implements Subscription, Runnable {
        private static final long serialVersionUID = 7597704795244221647L;
        public final Subscriber<? super T> a;
        public final DispatchWorkProcessor<T> b;
        public final Scheduler.Worker c;
        public final boolean d;
        public final AtomicLong e = new AtomicLong();
        public long f;
        public volatile boolean g;

        public a(Subscriber<? super T> subscriber, DispatchWorkProcessor<T> dispatchWorkProcessor, Scheduler.Worker worker, boolean z) {
            this.a = subscriber;
            this.b = dispatchWorkProcessor;
            this.c = worker;
            this.d = z;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                this.c.schedule(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.g = true;
            this.b.f(this);
            this.c.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.e, j);
            a();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            int i;
            DispatchWorkProcessor<T> dispatchWorkProcessor = this.b;
            SimplePlainQueue<T> simplePlainQueue = dispatchWorkProcessor.b;
            Subscriber<? super T> subscriber = this.a;
            AtomicReference<Throwable> atomicReference = dispatchWorkProcessor.d;
            boolean z2 = this.d;
            long j = this.f;
            AtomicLong atomicLong = this.e;
            int i2 = 1;
            do {
                long j2 = atomicLong.get();
                long j3 = 0;
                while (true) {
                    z = false;
                    i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (!this.g) {
                        Throwable th = atomicReference.get();
                        boolean z3 = th != null;
                        if (!z3 || z2 || th == ExceptionHelper.TERMINATED) {
                            T poll = simplePlainQueue.poll();
                            boolean z4 = poll == null;
                            if (z3 && z4) {
                                if (th == ExceptionHelper.TERMINATED) {
                                    subscriber.onComplete();
                                } else {
                                    subscriber.onError(th);
                                }
                                this.c.dispose();
                                return;
                            } else if (z4) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j++;
                                j3++;
                            }
                        } else {
                            simplePlainQueue.clear();
                            subscriber.onError(th);
                            this.c.dispose();
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j3 != 0) {
                    long j4 = dispatchWorkProcessor.h;
                    Subscription subscription = dispatchWorkProcessor.c.get();
                    if (j4 != Long.MAX_VALUE && subscription != null) {
                        long j5 = j4 - (j4 >> 2);
                        AtomicLong atomicLong2 = dispatchWorkProcessor.i;
                        BackpressureHelper.add(atomicLong2, j3);
                        AtomicLong atomicLong3 = dispatchWorkProcessor.j;
                        while (true) {
                            long j6 = atomicLong2.get();
                            long j7 = atomicLong3.get();
                            if (j6 - j7 < j5) {
                                break;
                            }
                            if (atomicLong3.compareAndSet(j7, BackpressureHelper.addCap(j7, j5))) {
                                subscription.request(j5);
                            }
                            atomicLong2 = atomicLong2;
                            j = j;
                        }
                    }
                }
                if (i == 0) {
                    if (!this.g) {
                        Throwable th2 = atomicReference.get();
                        if (th2 != null) {
                            z = true;
                        }
                        if (!z || z2 || th2 == ExceptionHelper.TERMINATED) {
                            boolean isEmpty = simplePlainQueue.isEmpty();
                            if (z && isEmpty) {
                                if (th2 == ExceptionHelper.TERMINATED) {
                                    subscriber.onComplete();
                                } else {
                                    subscriber.onError(th2);
                                }
                                this.c.dispose();
                                return;
                            }
                        } else {
                            simplePlainQueue.clear();
                            subscriber.onError(th2);
                            this.c.dispose();
                            return;
                        }
                    } else {
                        return;
                    }
                }
                j = j;
                this.f = j;
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    public DispatchWorkProcessor(int i2, boolean z, Scheduler scheduler, boolean z2) {
        this.b = new SpmcLinkedArrayQueue(i2);
        this.e = z;
        new AtomicInteger();
        this.g = scheduler;
        this.h = z2 ? Long.MAX_VALUE : (long) i2;
        this.j = new AtomicLong();
        this.i = new AtomicLong();
    }

    public static <T> DispatchWorkProcessor<T> create(Scheduler scheduler) {
        return create(scheduler, Flowable.bufferSize(), true);
    }

    public static <T> DispatchWorkProcessor<T> createUnbounded(Scheduler scheduler) {
        return createUnbounded(scheduler, Flowable.bufferSize(), true);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this.c);
    }

    public void f(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f.get();
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
        } while (!this.f.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    public Throwable getThrowable() {
        Throwable th = this.d.get();
        if (th != ExceptionHelper.TERMINATED) {
            return th;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.d.get() == ExceptionHelper.TERMINATED;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.f.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    public boolean hasThrowable() {
        Throwable th = this.d.get();
        return (th == null || th == ExceptionHelper.TERMINATED) ? false : true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return SubscriptionHelper.CANCELLED == this.c.get();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.d.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            for (a<T> aVar : this.f.getAndSet(l)) {
                aVar.a();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Objects.requireNonNull(th, "e is null");
        if (this.d.compareAndSet(null, th)) {
            for (a<T> aVar : this.f.getAndSet(l)) {
                aVar.a();
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.d.get() == null) {
            this.b.offer(t);
            for (a<T> aVar : this.f.get()) {
                aVar.a();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.c, subscription)) {
            subscription.request(this.h);
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        a<T> aVar = new a<>(subscriber, this, this.g.createWorker(), this.e);
        subscriber.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.f.get();
            z = false;
            if (aVarArr != l) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.f.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z || !aVar.g) {
            aVar.a();
        } else {
            f(aVar);
        }
    }

    public static <T> DispatchWorkProcessor<T> create(Scheduler scheduler, int i2) {
        return create(scheduler, i2, true);
    }

    public static <T> DispatchWorkProcessor<T> createUnbounded(Scheduler scheduler, int i2, boolean z) {
        return new DispatchWorkProcessor<>(i2, z, scheduler, true);
    }

    public static <T> DispatchWorkProcessor<T> create(Scheduler scheduler, boolean z) {
        return create(scheduler, Flowable.bufferSize(), z);
    }

    public static <T> DispatchWorkProcessor<T> create(Scheduler scheduler, int i2, boolean z) {
        return new DispatchWorkProcessor<>(i2, z, scheduler, false);
    }
}
