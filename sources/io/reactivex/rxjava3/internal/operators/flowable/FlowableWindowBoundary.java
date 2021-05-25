package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableWindowBoundary<T, B> extends s6.a.e.d.c.a.a<T, Flowable<T>> {
    public final Publisher<B> b;
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
                SubscriptionHelper.cancel(bVar.d);
                bVar.j = true;
                bVar.a();
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
            SubscriptionHelper.cancel(bVar.d);
            if (bVar.g.tryAddThrowableOrReport(th)) {
                bVar.j = true;
                bVar.a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b2) {
            if (!this.c) {
                b<T, B> bVar = this.b;
                bVar.f.offer(b.m);
                bVar.a();
            }
        }
    }

    public static final class b<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final Object m = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final Subscriber<? super Flowable<T>> a;
        public final int b;
        public final a<T, B> c = new a<>(this);
        public final AtomicReference<Subscription> d = new AtomicReference<>();
        public final AtomicInteger e = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> f = new MpscLinkedQueue<>();
        public final AtomicThrowable g = new AtomicThrowable();
        public final AtomicBoolean h = new AtomicBoolean();
        public final AtomicLong i = new AtomicLong();
        public volatile boolean j;
        public UnicastProcessor<T> k;
        public long l;

        public b(Subscriber<? super Flowable<T>> subscriber, int i2) {
            this.a = subscriber;
            this.b = i2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: io.reactivex.rxjava3.processors.UnicastProcessor<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.a;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.f;
                AtomicThrowable atomicThrowable = this.g;
                long j2 = this.l;
                int i2 = 1;
                while (this.e.get() != 0) {
                    UnicastProcessor<T> unicastProcessor = this.k;
                    boolean z = this.j;
                    if (!z || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (unicastProcessor != 0) {
                                    this.k = null;
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                                return;
                            }
                            if (unicastProcessor != 0) {
                                this.k = null;
                                unicastProcessor.onError(terminate);
                            }
                            subscriber.onError(terminate);
                            return;
                        } else if (z2) {
                            this.l = j2;
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != m) {
                            unicastProcessor.onNext(poll);
                        } else {
                            if (unicastProcessor != 0) {
                                this.k = null;
                                unicastProcessor.onComplete();
                            }
                            if (!this.h.get()) {
                                UnicastProcessor<T> create = UnicastProcessor.create(this.b, this);
                                this.k = create;
                                this.e.getAndIncrement();
                                if (j2 != this.i.get()) {
                                    j2++;
                                    s6.a.e.d.c.a.b bVar = new s6.a.e.d.c.a.b(create);
                                    subscriber.onNext(bVar);
                                    if (bVar.f()) {
                                        create.onComplete();
                                    }
                                } else {
                                    SubscriptionHelper.cancel(this.d);
                                    this.c.dispose();
                                    atomicThrowable.tryAddThrowableOrReport(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                    this.j = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastProcessor != 0) {
                            this.k = null;
                            unicastProcessor.onError(terminate2);
                        }
                        subscriber.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.k = null;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.h.compareAndSet(false, true)) {
                this.c.dispose();
                if (this.e.decrementAndGet() == 0) {
                    SubscriptionHelper.cancel(this.d);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.c.dispose();
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.c.dispose();
            if (this.g.tryAddThrowableOrReport(th)) {
                this.j = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f.offer(t);
            a();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.d, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            BackpressureHelper.add(this.i, j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.e.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.d);
            }
        }
    }

    public FlowableWindowBoundary(Flowable<T> flowable, Publisher<B> publisher, int i) {
        super(flowable);
        this.b = publisher;
        this.c = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        b bVar = new b(subscriber, this.c);
        subscriber.onSubscribe(bVar);
        bVar.f.offer(b.m);
        bVar.a();
        this.b.subscribe(bVar.c);
        this.source.subscribe((FlowableSubscriber) bVar);
    }
}
