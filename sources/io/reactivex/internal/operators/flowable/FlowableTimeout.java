package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableTimeout<T, U, V> extends s6.a.c.b.a.a<T, T> {
    public final Publisher<U> b;
    public final Function<? super T, ? extends Publisher<V>> c;
    public final Publisher<? extends T> d;

    public static final class a extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;
        public final c a;
        public final long b;

        public a(long j, c cVar) {
            this.b = j;
            this.a = cVar;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.reactivex.internal.operators.flowable.FlowableTimeout$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.a.b(this.b);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.reactivex.internal.operators.flowable.FlowableTimeout$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.a.a(this.b, th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.internal.operators.flowable.FlowableTimeout$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                lazySet(subscriptionHelper);
                this.a.b(this.b);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class b<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, c {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Subscriber<? super T> h;
        public final Function<? super T, ? extends Publisher<?>> i;
        public final SequentialDisposable j = new SequentialDisposable();
        public final AtomicReference<Subscription> k = new AtomicReference<>();
        public final AtomicLong l;
        public Publisher<? extends T> m;
        public long n;

        public b(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function, Publisher<? extends T> publisher) {
            super(true);
            this.h = subscriber;
            this.i = function;
            this.m = publisher;
            this.l = new AtomicLong();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.c
        public void a(long j2, Throwable th) {
            if (this.l.compareAndSet(j2, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.k);
                this.h.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.d
        public void b(long j2) {
            if (this.l.compareAndSet(j2, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.k);
                Publisher<? extends T> publisher = this.m;
                this.m = null;
                long j3 = this.n;
                if (j3 != 0) {
                    produced(j3);
                }
                publisher.subscribe(new FlowableTimeoutTimed.a(this.h, this));
            }
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.j.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.l.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.j.dispose();
                this.h.onComplete();
                this.j.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.l.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.j.dispose();
                this.h.onError(th);
                this.j.dispose();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j2 = this.l.get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 + 1;
                if (this.l.compareAndSet(j2, j3)) {
                    Disposable disposable = (Disposable) this.j.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.n++;
                    this.h.onNext(t);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.i.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        a aVar = new a(j3, this);
                        if (this.j.replace(aVar)) {
                            publisher.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.k.get().cancel();
                        this.l.getAndSet(Long.MAX_VALUE);
                        this.h.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.k, subscription)) {
                setSubscription(subscription);
            }
        }
    }

    public interface c extends FlowableTimeoutTimed.d {
        void a(long j, Throwable th);
    }

    public static final class d<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, c {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Subscriber<? super T> a;
        public final Function<? super T, ? extends Publisher<?>> b;
        public final SequentialDisposable c = new SequentialDisposable();
        public final AtomicReference<Subscription> d = new AtomicReference<>();
        public final AtomicLong e = new AtomicLong();

        public d(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function) {
            this.a = subscriber;
            this.b = function;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.c
        public void a(long j, Throwable th) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.d);
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.d
        public void b(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.d);
                this.a.onError(new TimeoutException());
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.d);
            this.c.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.c.dispose();
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.c.dispose();
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    Disposable disposable = (Disposable) this.c.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.a.onNext(t);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        a aVar = new a(j2, this);
                        if (this.c.replace(aVar)) {
                            publisher.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.d.get().cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.a.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.d, this.e, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.d, this.e, j);
        }
    }

    public FlowableTimeout(Flowable<T> flowable, Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        super(flowable);
        this.b = publisher;
        this.c = function;
        this.d = publisher2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.d == null) {
            d dVar = new d(subscriber, this.c);
            subscriber.onSubscribe(dVar);
            Publisher<U> publisher = this.b;
            if (publisher != null) {
                a aVar = new a(0, dVar);
                if (dVar.c.replace(aVar)) {
                    publisher.subscribe(aVar);
                }
            }
            this.source.subscribe((FlowableSubscriber) dVar);
            return;
        }
        b bVar = new b(subscriber, this.c, this.d);
        subscriber.onSubscribe(bVar);
        Publisher<U> publisher2 = this.b;
        if (publisher2 != null) {
            a aVar2 = new a(0, bVar);
            if (bVar.j.replace(aVar2)) {
                publisher2.subscribe(aVar2);
            }
        }
        this.source.subscribe((FlowableSubscriber) bVar);
    }
}
