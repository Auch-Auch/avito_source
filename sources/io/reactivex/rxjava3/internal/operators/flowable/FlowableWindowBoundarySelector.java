package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableWindowBoundarySelector<T, B, V> extends s6.a.e.d.c.a.a<T, Flowable<T>> {
    public final Publisher<B> b;
    public final Function<? super B, ? extends Publisher<V>> c;
    public final int d;

    public static final class a<T, B, V> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8646217640096099753L;
        public final Subscriber<? super Flowable<T>> a;
        public final Publisher<B> b;
        public final Function<? super B, ? extends Publisher<V>> c;
        public final int d;
        public final CompositeDisposable e;
        public final c<B> f;
        public final List<UnicastProcessor<T>> g;
        public final SimplePlainQueue<Object> h = new MpscLinkedQueue();
        public final AtomicLong i;
        public final AtomicBoolean j;
        public final AtomicLong k;
        public long l;
        public volatile boolean m;
        public volatile boolean n;
        public volatile boolean o;
        public final AtomicThrowable p;
        public Subscription q;

        /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowBoundarySelector$a$a  reason: collision with other inner class name */
        public static final class C0456a<T, V> extends Flowable<T> implements FlowableSubscriber<V>, Disposable {
            public final a<T, ?, V> b;
            public final UnicastProcessor<T> c;
            public final AtomicReference<Subscription> d = new AtomicReference<>();
            public final AtomicBoolean e = new AtomicBoolean();

            public C0456a(a<T, ?, V> aVar, UnicastProcessor<T> unicastProcessor) {
                this.b = aVar;
                this.c = unicastProcessor;
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                SubscriptionHelper.cancel(this.d);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return this.d.get() == SubscriptionHelper.CANCELLED;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a<T, ?, V> aVar = this.b;
                aVar.h.offer(this);
                aVar.a();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (isDisposed()) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                a<T, ?, V> aVar = this.b;
                aVar.q.cancel();
                c<B> cVar = aVar.f;
                Objects.requireNonNull(cVar);
                SubscriptionHelper.cancel(cVar);
                aVar.e.dispose();
                if (aVar.p.tryAddThrowableOrReport(th)) {
                    aVar.n = true;
                    aVar.a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(V v) {
                if (SubscriptionHelper.cancel(this.d)) {
                    a<T, ?, V> aVar = this.b;
                    aVar.h.offer(this);
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this.d, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }

            @Override // io.reactivex.rxjava3.core.Flowable
            public void subscribeActual(Subscriber<? super T> subscriber) {
                this.c.subscribe(subscriber);
                this.e.set(true);
            }
        }

        public static final class b<B> {
            public final B a;

            public b(B b) {
                this.a = b;
            }
        }

        public static final class c<B> extends AtomicReference<Subscription> implements FlowableSubscriber<B> {
            private static final long serialVersionUID = -3326496781427702834L;
            public final a<?, B, ?> a;

            public c(a<?, B, ?> aVar) {
                this.a = aVar;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a<?, B, ?> aVar = this.a;
                aVar.o = true;
                aVar.a();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a<?, B, ?> aVar = this.a;
                aVar.q.cancel();
                aVar.e.dispose();
                if (aVar.p.tryAddThrowableOrReport(th)) {
                    aVar.n = true;
                    aVar.a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(B b) {
                a<?, B, ?> aVar = this.a;
                aVar.h.offer(new b(b));
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i2) {
            this.a = subscriber;
            this.b = publisher;
            this.c = function;
            this.d = i2;
            this.e = new CompositeDisposable();
            this.g = new ArrayList();
            this.i = new AtomicLong(1);
            this.j = new AtomicBoolean();
            this.p = new AtomicThrowable();
            this.f = new c<>(this);
            this.k = new AtomicLong();
        }

        public void a() {
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.a;
                SimplePlainQueue<Object> simplePlainQueue = this.h;
                List<UnicastProcessor<T>> list = this.g;
                int i2 = 1;
                while (true) {
                    if (this.m) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.n;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = false;
                        boolean z3 = poll == null;
                        if (z && (z3 || this.p.get() != null)) {
                            b(subscriber);
                            this.m = true;
                        } else if (!z3) {
                            if (poll instanceof b) {
                                if (!this.j.get()) {
                                    long j2 = this.l;
                                    if (this.k.get() != j2) {
                                        this.l = j2 + 1;
                                        try {
                                            Object apply = this.c.apply(((b) poll).a);
                                            Objects.requireNonNull(apply, "The closingIndicator returned a null Publisher");
                                            Publisher publisher = (Publisher) apply;
                                            this.i.getAndIncrement();
                                            UnicastProcessor<T> create = UnicastProcessor.create(this.d, this);
                                            C0456a aVar = new C0456a(this, create);
                                            subscriber.onNext(aVar);
                                            if (!aVar.e.get() && aVar.e.compareAndSet(false, true)) {
                                                z2 = true;
                                            }
                                            if (z2) {
                                                create.onComplete();
                                            } else {
                                                list.add(create);
                                                this.e.add(aVar);
                                                publisher.subscribe(aVar);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            this.q.cancel();
                                            c<B> cVar = this.f;
                                            Objects.requireNonNull(cVar);
                                            SubscriptionHelper.cancel(cVar);
                                            this.e.dispose();
                                            Exceptions.throwIfFatal(th);
                                            this.p.tryAddThrowableOrReport(th);
                                            this.n = true;
                                        }
                                    } else {
                                        this.q.cancel();
                                        c<B> cVar2 = this.f;
                                        Objects.requireNonNull(cVar2);
                                        SubscriptionHelper.cancel(cVar2);
                                        this.e.dispose();
                                        this.p.tryAddThrowableOrReport(new MissingBackpressureException(FlowableWindowTimed.f(j2)));
                                        this.n = true;
                                    }
                                }
                            } else if (poll instanceof C0456a) {
                                UnicastProcessor<T> unicastProcessor = ((C0456a) poll).c;
                                list.remove(unicastProcessor);
                                this.e.delete((Disposable) poll);
                                unicastProcessor.onComplete();
                            } else {
                                for (UnicastProcessor<T> unicastProcessor2 : list) {
                                    unicastProcessor2.onNext(poll);
                                }
                            }
                        } else if (this.o && list.size() == 0) {
                            this.q.cancel();
                            c<B> cVar3 = this.f;
                            Objects.requireNonNull(cVar3);
                            SubscriptionHelper.cancel(cVar3);
                            this.e.dispose();
                            b(subscriber);
                            this.m = true;
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public void b(Subscriber<?> subscriber) {
            Throwable terminate = this.p.terminate();
            if (terminate == null) {
                for (UnicastProcessor<T> unicastProcessor : this.g) {
                    unicastProcessor.onComplete();
                }
                subscriber.onComplete();
            } else if (terminate != ExceptionHelper.TERMINATED) {
                for (UnicastProcessor<T> unicastProcessor2 : this.g) {
                    unicastProcessor2.onError(terminate);
                }
                subscriber.onError(terminate);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.j.compareAndSet(false, true)) {
                return;
            }
            if (this.i.decrementAndGet() == 0) {
                this.q.cancel();
                c<B> cVar = this.f;
                Objects.requireNonNull(cVar);
                SubscriptionHelper.cancel(cVar);
                this.e.dispose();
                this.p.tryTerminateAndReport();
                this.m = true;
                a();
                return;
            }
            c<B> cVar2 = this.f;
            Objects.requireNonNull(cVar2);
            SubscriptionHelper.cancel(cVar2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            c<B> cVar = this.f;
            Objects.requireNonNull(cVar);
            SubscriptionHelper.cancel(cVar);
            this.e.dispose();
            this.n = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            c<B> cVar = this.f;
            Objects.requireNonNull(cVar);
            SubscriptionHelper.cancel(cVar);
            this.e.dispose();
            if (this.p.tryAddThrowableOrReport(th)) {
                this.n = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.h.offer(t);
            a();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.q, subscription)) {
                this.q = subscription;
                this.a.onSubscribe(this);
                this.b.subscribe(this.f);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.k, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.i.decrementAndGet() == 0) {
                this.q.cancel();
                c<B> cVar = this.f;
                Objects.requireNonNull(cVar);
                SubscriptionHelper.cancel(cVar);
                this.e.dispose();
                this.p.tryTerminateAndReport();
                this.m = true;
                a();
            }
        }
    }

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
        super(flowable);
        this.b = publisher;
        this.c = function;
        this.d = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b, this.c, this.d));
    }
}
