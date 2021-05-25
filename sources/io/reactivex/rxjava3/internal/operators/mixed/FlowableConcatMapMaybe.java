package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {
    public final Flowable<T> b;
    public final Function<? super T, ? extends MaybeSource<? extends R>> c;
    public final ErrorMode d;
    public final int e;

    public static final class a<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9140123220065488293L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends MaybeSource<? extends R>> b;
        public final int c;
        public final AtomicLong d = new AtomicLong();
        public final AtomicThrowable e = new AtomicThrowable();
        public final C0466a<R> f = new C0466a<>(this);
        public final SimplePlainQueue<T> g;
        public final ErrorMode h;
        public Subscription i;
        public volatile boolean j;
        public volatile boolean k;
        public long l;
        public int m;
        public R n;
        public volatile int o;

        /* renamed from: io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapMaybe$a$a  reason: collision with other inner class name */
        public static final class C0466a<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            public final a<?, R> a;

            public C0466a(a<?, R> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                a<?, R> aVar = this.a;
                aVar.o = 0;
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                a<?, R> aVar = this.a;
                if (aVar.e.tryAddThrowableOrReport(th)) {
                    if (aVar.h != ErrorMode.END) {
                        aVar.i.cancel();
                    }
                    aVar.o = 0;
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R r) {
                a<?, R> aVar = this.a;
                aVar.n = r;
                aVar.o = 2;
                aVar.a();
            }
        }

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, int i2, ErrorMode errorMode) {
            this.a = subscriber;
            this.b = function;
            this.c = i2;
            this.h = errorMode;
            this.g = new SpscArrayQueue(i2);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.a;
                ErrorMode errorMode = this.h;
                SimplePlainQueue<T> simplePlainQueue = this.g;
                AtomicThrowable atomicThrowable = this.e;
                AtomicLong atomicLong = this.d;
                int i2 = this.c;
                int i3 = i2 - (i2 >> 1);
                int i4 = 1;
                while (true) {
                    if (this.k) {
                        simplePlainQueue.clear();
                        this.n = null;
                    } else {
                        int i5 = this.o;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i5 == 0))) {
                            if (i5 == 0) {
                                boolean z = this.j;
                                T poll = simplePlainQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    atomicThrowable.tryTerminateConsumer(subscriber);
                                    return;
                                } else if (!z2) {
                                    int i6 = this.m + 1;
                                    if (i6 == i3) {
                                        this.m = 0;
                                        this.i.request((long) i3);
                                    } else {
                                        this.m = i6;
                                    }
                                    try {
                                        Object apply = this.b.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                                        MaybeSource maybeSource = (MaybeSource) apply;
                                        this.o = 1;
                                        maybeSource.subscribe(this.f);
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.i.cancel();
                                        simplePlainQueue.clear();
                                        atomicThrowable.tryAddThrowableOrReport(th);
                                        atomicThrowable.tryTerminateConsumer(subscriber);
                                        return;
                                    }
                                }
                            } else if (i5 == 2) {
                                long j2 = this.l;
                                if (j2 != atomicLong.get()) {
                                    R r = this.n;
                                    this.n = null;
                                    subscriber.onNext(r);
                                    this.l = j2 + 1;
                                    this.o = 0;
                                }
                            }
                        }
                    }
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.n = null;
                atomicThrowable.tryTerminateConsumer(subscriber);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.k = true;
            this.i.cancel();
            C0466a<R> aVar = this.f;
            Objects.requireNonNull(aVar);
            DisposableHelper.dispose(aVar);
            this.e.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.g.clear();
                this.n = null;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.e.tryAddThrowableOrReport(th)) {
                if (this.h == ErrorMode.IMMEDIATE) {
                    C0466a<R> aVar = this.f;
                    Objects.requireNonNull(aVar);
                    DisposableHelper.dispose(aVar);
                }
                this.j = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.g.offer(t)) {
                this.i.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
            a();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                this.a.onSubscribe(this);
                subscription.request((long) this.c);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            BackpressureHelper.add(this.d, j2);
            a();
        }
    }

    public FlowableConcatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.b = flowable;
        this.c = function;
        this.d = errorMode;
        this.e = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe((FlowableSubscriber) new a(subscriber, this.c, this.e, this.d));
    }
}
