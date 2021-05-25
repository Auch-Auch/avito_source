package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableMergeWithSingle<T> extends s6.a.e.d.c.a.a<T, T> {
    public final SingleSource<? extends T> b;

    public static final class a<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        public final Subscriber<? super T> a;
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final C0451a<T> c = new C0451a<>(this);
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicLong e = new AtomicLong();
        public final int f;
        public final int g;
        public volatile SimplePlainQueue<T> h;
        public T i;
        public volatile boolean j;
        public volatile boolean k;
        public volatile int l;
        public long m;
        public int n;

        /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableMergeWithSingle$a$a  reason: collision with other inner class name */
        public static final class C0451a<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            public final a<T> a;

            public C0451a(a<T> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                a<T> aVar = this.a;
                if (aVar.d.tryAddThrowableOrReport(th)) {
                    SubscriptionHelper.cancel(aVar.b);
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(T t) {
                a<T> aVar = this.a;
                if (aVar.compareAndSet(0, 1)) {
                    long j = aVar.m;
                    if (aVar.e.get() != j) {
                        aVar.m = j + 1;
                        aVar.a.onNext(t);
                        aVar.l = 2;
                    } else {
                        aVar.i = t;
                        aVar.l = 1;
                        if (aVar.decrementAndGet() == 0) {
                            return;
                        }
                    }
                } else {
                    aVar.i = t;
                    aVar.l = 1;
                    if (aVar.getAndIncrement() != 0) {
                        return;
                    }
                }
                aVar.b();
            }
        }

        public a(Subscriber<? super T> subscriber) {
            this.a = subscriber;
            int bufferSize = Flowable.bufferSize();
            this.f = bufferSize;
            this.g = bufferSize - (bufferSize >> 2);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            int i2;
            Subscriber<? super T> subscriber = this.a;
            long j2 = this.m;
            int i3 = this.n;
            int i4 = this.g;
            int i5 = 1;
            int i6 = 1;
            while (true) {
                long j3 = this.e.get();
                while (true) {
                    i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.j) {
                        this.i = null;
                        this.h = null;
                        return;
                    } else if (this.d.get() != null) {
                        this.i = null;
                        this.h = null;
                        this.d.tryTerminateConsumer(this.a);
                        return;
                    } else {
                        int i7 = this.l;
                        if (i7 == i5) {
                            T t = this.i;
                            this.i = null;
                            this.l = 2;
                            subscriber.onNext(t);
                            j2++;
                        } else {
                            boolean z = this.k;
                            SimplePlainQueue<T> simplePlainQueue = this.h;
                            T poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                            boolean z2 = poll == null;
                            if (z && z2 && i7 == 2) {
                                this.h = null;
                                subscriber.onComplete();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j2++;
                                i3++;
                                if (i3 == i4) {
                                    this.b.get().request((long) i4);
                                    i3 = 0;
                                }
                                i5 = 1;
                            }
                        }
                    }
                }
                if (i2 == 0) {
                    if (this.j) {
                        this.i = null;
                        this.h = null;
                        return;
                    } else if (this.d.get() != null) {
                        this.i = null;
                        this.h = null;
                        this.d.tryTerminateConsumer(this.a);
                        return;
                    } else {
                        boolean z3 = this.k;
                        SimplePlainQueue<T> simplePlainQueue2 = this.h;
                        boolean z4 = simplePlainQueue2 == null || simplePlainQueue2.isEmpty();
                        if (z3 && z4 && this.l == 2) {
                            this.h = null;
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.m = j2;
                this.n = i3;
                i6 = addAndGet(-i6);
                if (i6 != 0) {
                    i5 = 1;
                } else {
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.j = true;
            SubscriptionHelper.cancel(this.b);
            DisposableHelper.dispose(this.c);
            this.d.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.h = null;
                this.i = null;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.k = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                DisposableHelper.dispose(this.c);
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j2 = this.m;
                if (this.e.get() != j2) {
                    SimplePlainQueue<T> simplePlainQueue = this.h;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.m = j2 + 1;
                        this.a.onNext(t);
                        int i2 = this.n + 1;
                        if (i2 == this.g) {
                            this.n = 0;
                            this.b.get().request((long) i2);
                        } else {
                            this.n = i2;
                        }
                    } else {
                        simplePlainQueue.offer(t);
                    }
                } else {
                    SpscArrayQueue spscArrayQueue = this.h;
                    if (spscArrayQueue == null) {
                        spscArrayQueue = new SpscArrayQueue(Flowable.bufferSize());
                        this.h = spscArrayQueue;
                    }
                    spscArrayQueue.offer(t);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SpscArrayQueue spscArrayQueue2 = this.h;
                if (spscArrayQueue2 == null) {
                    spscArrayQueue2 = new SpscArrayQueue(Flowable.bufferSize());
                    this.h = spscArrayQueue2;
                }
                spscArrayQueue2.offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.b, subscription, (long) this.f);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            BackpressureHelper.add(this.e, j2);
            a();
        }
    }

    public FlowableMergeWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.b = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        this.source.subscribe((FlowableSubscriber) aVar);
        this.b.subscribe(aVar.c);
    }
}
