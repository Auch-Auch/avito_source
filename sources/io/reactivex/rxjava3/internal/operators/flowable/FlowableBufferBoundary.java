package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends s6.a.e.d.c.a.a<T, U> {
    public final Supplier<U> b;
    public final Publisher<? extends Open> c;
    public final Function<? super Open, ? extends Publisher<? extends Close>> d;

    public static final class a<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8466418554264089604L;
        public final Subscriber<? super C> a;
        public final Supplier<C> b;
        public final Publisher<? extends Open> c;
        public final Function<? super Open, ? extends Publisher<? extends Close>> d;
        public final CompositeDisposable e = new CompositeDisposable();
        public final AtomicLong f = new AtomicLong();
        public final AtomicReference<Subscription> g = new AtomicReference<>();
        public final AtomicThrowable h = new AtomicThrowable();
        public volatile boolean i;
        public final SpscLinkedArrayQueue<C> j = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
        public volatile boolean k;
        public long l;
        public Map<Long, C> m = new LinkedHashMap();
        public long n;

        /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary$a$a  reason: collision with other inner class name */
        public static final class C0441a<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            public final a<?, ?, Open, ?> a;

            public C0441a(a<?, ?, Open, ?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                SubscriptionHelper.cancel(this);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return get() == SubscriptionHelper.CANCELLED;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                a<?, ?, Open, ?> aVar = this.a;
                aVar.e.delete(this);
                if (aVar.e.size() == 0) {
                    SubscriptionHelper.cancel(aVar.g);
                    aVar.i = true;
                    aVar.b();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                lazySet(SubscriptionHelper.CANCELLED);
                a<?, ?, Open, ?> aVar = this.a;
                SubscriptionHelper.cancel(aVar.g);
                aVar.e.delete(this);
                aVar.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Open open) {
                a<?, ?, Open, ?> aVar = this.a;
                Objects.requireNonNull(aVar);
                try {
                    C c = aVar.b.get();
                    Objects.requireNonNull(c, "The bufferSupplier returned a null Collection");
                    C c2 = c;
                    Object apply = aVar.d.apply(open);
                    Objects.requireNonNull(apply, "The bufferClose returned a null Publisher");
                    Publisher publisher = (Publisher) apply;
                    long j = aVar.l;
                    aVar.l = 1 + j;
                    synchronized (aVar) {
                        Map<Long, C> map = aVar.m;
                        if (map != null) {
                            map.put(Long.valueOf(j), c2);
                            b bVar = new b(aVar, j);
                            aVar.e.add(bVar);
                            publisher.subscribe(bVar);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    SubscriptionHelper.cancel(aVar.g);
                    aVar.onError(th);
                }
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public a(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Supplier<C> supplier) {
            this.a = subscriber;
            this.b = supplier;
            this.c = publisher;
            this.d = function;
        }

        public void a(b<T, C> bVar, long j2) {
            boolean z;
            this.e.delete(bVar);
            if (this.e.size() == 0) {
                SubscriptionHelper.cancel(this.g);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.m;
                if (map != null) {
                    this.j.offer(map.remove(Long.valueOf(j2)));
                } else {
                    return;
                }
            }
            if (z) {
                this.i = true;
            }
            b();
        }

        public void b() {
            int i2;
            if (getAndIncrement() == 0) {
                long j2 = this.n;
                Subscriber<? super C> subscriber = this.a;
                SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.j;
                int i3 = 1;
                do {
                    long j3 = this.f.get();
                    while (true) {
                        i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.k) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else {
                            boolean z = this.i;
                            if (!z || this.h.get() == null) {
                                C poll = spscLinkedArrayQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    subscriber.onComplete();
                                    return;
                                } else if (z2) {
                                    break;
                                } else {
                                    subscriber.onNext(poll);
                                    j2++;
                                }
                            } else {
                                spscLinkedArrayQueue.clear();
                                this.h.tryTerminateConsumer(subscriber);
                                return;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (this.k) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else if (this.i) {
                            if (this.h.get() != null) {
                                spscLinkedArrayQueue.clear();
                                this.h.tryTerminateConsumer(subscriber);
                                return;
                            } else if (spscLinkedArrayQueue.isEmpty()) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    this.n = j2;
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (SubscriptionHelper.cancel(this.g)) {
                this.k = true;
                this.e.dispose();
                synchronized (this) {
                    this.m = null;
                }
                if (getAndIncrement() != 0) {
                    this.j.clear();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.e.dispose();
            synchronized (this) {
                Map<Long, C> map = this.m;
                if (map != null) {
                    for (C c2 : map.values()) {
                        this.j.offer(c2);
                    }
                    this.m = null;
                    this.i = true;
                    b();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.h.tryAddThrowableOrReport(th)) {
                this.e.dispose();
                synchronized (this) {
                    this.m = null;
                }
                this.i = true;
                b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.m;
                if (map != null) {
                    for (C c2 : map.values()) {
                        c2.add(t);
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.g, subscription)) {
                C0441a aVar = new C0441a(this);
                this.e.add(aVar);
                this.c.subscribe(aVar);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            BackpressureHelper.add(this.f, j2);
            b();
        }
    }

    public static final class b<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        public final a<T, C, ?, ?> a;
        public final long b;

        public b(a<T, C, ?, ?> aVar, long j) {
            this.a = aVar;
            this.b = j;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.a.a(this, this.b);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                a<T, C, ?, ?> aVar = this.a;
                SubscriptionHelper.cancel(aVar.g);
                aVar.e.delete(this);
                aVar.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                this.a.a(this, this.b);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary(Flowable<T> flowable, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Supplier<U> supplier) {
        super(flowable);
        this.c = publisher;
        this.d = function;
        this.b = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        a aVar = new a(subscriber, this.c, this.d, this.b);
        subscriber.onSubscribe(aVar);
        this.source.subscribe((FlowableSubscriber) aVar);
    }
}
