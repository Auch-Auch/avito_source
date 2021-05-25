package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableFlatMapMaybe<T, R> extends s6.a.c.b.a.a<T, R> {
    public final Function<? super T, ? extends MaybeSource<? extends R>> b;
    public final boolean c;
    public final int d;

    public static final class a<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;
        public final Subscriber<? super R> a;
        public final boolean b;
        public final int c;
        public final AtomicLong d = new AtomicLong();
        public final CompositeDisposable e = new CompositeDisposable();
        public final AtomicInteger f = new AtomicInteger(1);
        public final AtomicThrowable g = new AtomicThrowable();
        public final Function<? super T, ? extends MaybeSource<? extends R>> h;
        public final AtomicReference<SpscLinkedArrayQueue<R>> i = new AtomicReference<>();
        public Subscription j;
        public volatile boolean k;

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe$a$a  reason: collision with other inner class name */
        public final class C0383a extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            public C0383a() {
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                a aVar = a.this;
                aVar.e.delete(this);
                if (aVar.get() == 0) {
                    boolean z = false;
                    if (aVar.compareAndSet(0, 1)) {
                        if (aVar.f.decrementAndGet() == 0) {
                            z = true;
                        }
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = aVar.i.get();
                        if (!z || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                            if (aVar.c != Integer.MAX_VALUE) {
                                aVar.j.request(1);
                            }
                            if (aVar.decrementAndGet() != 0) {
                                aVar.c();
                                return;
                            }
                            return;
                        }
                        Throwable terminate = aVar.g.terminate();
                        if (terminate != null) {
                            aVar.a.onError(terminate);
                            return;
                        } else {
                            aVar.a.onComplete();
                            return;
                        }
                    }
                }
                aVar.f.decrementAndGet();
                if (aVar.c != Integer.MAX_VALUE) {
                    aVar.j.request(1);
                }
                aVar.b();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                a aVar = a.this;
                aVar.e.delete(this);
                if (aVar.g.addThrowable(th)) {
                    if (!aVar.b) {
                        aVar.j.cancel();
                        aVar.e.dispose();
                    } else if (aVar.c != Integer.MAX_VALUE) {
                        aVar.j.request(1);
                    }
                    aVar.f.decrementAndGet();
                    aVar.b();
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                a aVar = a.this;
                aVar.e.delete(this);
                if (aVar.get() == 0) {
                    boolean z = false;
                    if (aVar.compareAndSet(0, 1)) {
                        if (aVar.f.decrementAndGet() == 0) {
                            z = true;
                        }
                        if (aVar.d.get() != 0) {
                            aVar.a.onNext(r);
                            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = aVar.i.get();
                            if (!z || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                                BackpressureHelper.produced(aVar.d, 1);
                                if (aVar.c != Integer.MAX_VALUE) {
                                    aVar.j.request(1);
                                }
                            } else {
                                Throwable terminate = aVar.g.terminate();
                                if (terminate != null) {
                                    aVar.a.onError(terminate);
                                    return;
                                } else {
                                    aVar.a.onComplete();
                                    return;
                                }
                            }
                        } else {
                            SpscLinkedArrayQueue<R> d = aVar.d();
                            synchronized (d) {
                                d.offer(r);
                            }
                        }
                        if (aVar.decrementAndGet() == 0) {
                            return;
                        }
                        aVar.c();
                    }
                }
                SpscLinkedArrayQueue<R> d2 = aVar.d();
                synchronized (d2) {
                    d2.offer(r);
                }
                aVar.f.decrementAndGet();
                if (aVar.getAndIncrement() != 0) {
                    return;
                }
                aVar.c();
            }
        }

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
            this.a = subscriber;
            this.h = function;
            this.b = z;
            this.c = i2;
        }

        public void a() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.i.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        public void c() {
            boolean z;
            int i2;
            Subscriber<? super R> subscriber = this.a;
            AtomicInteger atomicInteger = this.f;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.i;
            int i3 = 1;
            do {
                long j2 = this.d.get();
                long j3 = 0;
                while (true) {
                    z = false;
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.k) {
                        a();
                        return;
                    } else if (this.b || ((Throwable) this.g.get()) == null) {
                        boolean z2 = atomicInteger.get() == 0;
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = atomicReference.get();
                        R poll = spscLinkedArrayQueue != null ? spscLinkedArrayQueue.poll() : null;
                        boolean z3 = poll == null;
                        if (z2 && z3) {
                            Throwable terminate = this.g.terminate();
                            if (terminate != null) {
                                subscriber.onError(terminate);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        } else if (z3) {
                            break;
                        } else {
                            subscriber.onNext(poll);
                            j3++;
                        }
                    } else {
                        Throwable terminate2 = this.g.terminate();
                        a();
                        subscriber.onError(terminate2);
                        return;
                    }
                }
                if (i2 == 0) {
                    if (this.k) {
                        a();
                        return;
                    } else if (this.b || ((Throwable) this.g.get()) == null) {
                        boolean z4 = atomicInteger.get() == 0;
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = atomicReference.get();
                        if (spscLinkedArrayQueue2 == null || spscLinkedArrayQueue2.isEmpty()) {
                            z = true;
                        }
                        if (z4 && z) {
                            Throwable terminate3 = this.g.terminate();
                            if (terminate3 != null) {
                                subscriber.onError(terminate3);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    } else {
                        Throwable terminate4 = this.g.terminate();
                        a();
                        subscriber.onError(terminate4);
                        return;
                    }
                }
                if (j3 != 0) {
                    BackpressureHelper.produced(this.d, j3);
                    if (this.c != Integer.MAX_VALUE) {
                        this.j.request(j3);
                    }
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.k = true;
            this.j.cancel();
            this.e.dispose();
        }

        public SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.i.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
            } while (!this.i.compareAndSet(null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f.decrementAndGet();
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f.decrementAndGet();
            if (this.g.addThrowable(th)) {
                if (!this.b) {
                    this.e.dispose();
                }
                b();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.h.apply(t), "The mapper returned a null MaybeSource");
                this.f.getAndIncrement();
                C0383a aVar = new C0383a();
                if (!this.k && this.e.add(aVar)) {
                    maybeSource.subscribe(aVar);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.j.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.j, subscription)) {
                this.j = subscription;
                this.a.onSubscribe(this);
                int i2 = this.c;
                if (i2 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i2);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.d, j2);
                b();
            }
        }
    }

    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
        super(flowable);
        this.b = function;
        this.c = z;
        this.d = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b, this.c, this.d));
    }
}
