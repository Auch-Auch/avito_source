package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableWindowBoundarySupplier<T, B> extends s6.a.c.b.a.a<T, Flowable<T>> {
    public final Callable<? extends Publisher<B>> b;
    public final int c;

    public static final class a<T, B> extends DisposableSubscriber<B> {
        public final b<T, B> b;
        public boolean c;

        public a(b<T, B> bVar) {
            this.b = bVar;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.c) {
                this.c = true;
                b<T, B> bVar = this.b;
                bVar.j.cancel();
                bVar.k = true;
                bVar.b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.c = true;
            b<T, B> bVar = this.b;
            bVar.j.cancel();
            if (bVar.f.addThrowable(th)) {
                bVar.k = true;
                bVar.b();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b2) {
            if (!this.c) {
                this.c = true;
                dispose();
                b<T, B> bVar = this.b;
                bVar.c.compareAndSet(this, null);
                bVar.e.offer(b.o);
                bVar.b();
            }
        }
    }

    public static final class b<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final a<Object, Object> n = new a<>(null);
        public static final Object o = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final Subscriber<? super Flowable<T>> a;
        public final int b;
        public final AtomicReference<a<T, B>> c = new AtomicReference<>();
        public final AtomicInteger d = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> e = new MpscLinkedQueue<>();
        public final AtomicThrowable f = new AtomicThrowable();
        public final AtomicBoolean g = new AtomicBoolean();
        public final Callable<? extends Publisher<B>> h;
        public final AtomicLong i;
        public Subscription j;
        public volatile boolean k;
        public UnicastProcessor<T> l;
        public long m;

        public b(Subscriber<? super Flowable<T>> subscriber, int i2, Callable<? extends Publisher<B>> callable) {
            this.a = subscriber;
            this.b = i2;
            this.h = callable;
            this.i = new AtomicLong();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier$a<T, B>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            a<Object, Object> aVar = n;
            Disposable disposable = (Disposable) this.c.getAndSet(aVar);
            if (disposable != null && disposable != aVar) {
                disposable.dispose();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: io.reactivex.processors.UnicastProcessor<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void b() {
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.a;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.e;
                AtomicThrowable atomicThrowable = this.f;
                long j2 = this.m;
                int i2 = 1;
                while (this.d.get() != 0) {
                    UnicastProcessor<T> unicastProcessor = this.l;
                    boolean z = this.k;
                    if (!z || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (unicastProcessor != 0) {
                                    this.l = null;
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                                return;
                            }
                            if (unicastProcessor != 0) {
                                this.l = null;
                                unicastProcessor.onError(terminate);
                            }
                            subscriber.onError(terminate);
                            return;
                        } else if (z2) {
                            this.m = j2;
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != o) {
                            unicastProcessor.onNext(poll);
                        } else {
                            if (unicastProcessor != 0) {
                                this.l = null;
                                unicastProcessor.onComplete();
                            }
                            if (!this.g.get()) {
                                if (j2 != this.i.get()) {
                                    UnicastProcessor<T> create = UnicastProcessor.create(this.b, this);
                                    this.l = create;
                                    this.d.getAndIncrement();
                                    try {
                                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.h.call(), "The other Callable returned a null Publisher");
                                        a<T, B> aVar = new a<>(this);
                                        if (this.c.compareAndSet(null, aVar)) {
                                            publisher.subscribe(aVar);
                                            j2++;
                                            subscriber.onNext(create);
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        atomicThrowable.addThrowable(th);
                                        this.k = true;
                                    }
                                } else {
                                    this.j.cancel();
                                    a();
                                    atomicThrowable.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                    this.k = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastProcessor != 0) {
                            this.l = null;
                            unicastProcessor.onError(terminate2);
                        }
                        subscriber.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.l = null;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.g.compareAndSet(false, true)) {
                a();
                if (this.d.decrementAndGet() == 0) {
                    this.j.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            a();
            this.k = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            a();
            if (this.f.addThrowable(th)) {
                this.k = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.e.offer(t);
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.j, subscription)) {
                this.j = subscription;
                this.a.onSubscribe(this);
                this.e.offer(o);
                b();
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            BackpressureHelper.add(this.i, j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d.decrementAndGet() == 0) {
                this.j.cancel();
            }
        }
    }

    public FlowableWindowBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, int i) {
        super(flowable);
        this.b = callable;
        this.c = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new b(subscriber, this.c, this.b));
    }
}
