package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {
    public final Publisher<? extends T> b;
    public final Publisher<? extends T> c;
    public final BiPredicate<? super T, ? super T> d;
    public final int e;

    public static final class a<T> extends DeferredScalarSubscription<Boolean> implements b {
        private static final long serialVersionUID = -6178010334400373240L;
        public final BiPredicate<? super T, ? super T> a;
        public final c<T> b;
        public final c<T> c;
        public final AtomicThrowable d;
        public final AtomicInteger e = new AtomicInteger();
        public T f;
        public T g;

        public a(Subscriber<? super Boolean> subscriber, int i, BiPredicate<? super T, ? super T> biPredicate) {
            super(subscriber);
            this.a = biPredicate;
            this.b = new c<>(this, i);
            this.c = new c<>(this, i);
            this.d = new AtomicThrowable();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual.b
        public void a(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            c<T> cVar = this.b;
            Objects.requireNonNull(cVar);
            SubscriptionHelper.cancel(cVar);
            c<T> cVar2 = this.c;
            Objects.requireNonNull(cVar2);
            SubscriptionHelper.cancel(cVar2);
            this.d.tryTerminateAndReport();
            if (this.e.getAndIncrement() == 0) {
                this.b.a();
                this.c.a();
            }
        }

        public void d() {
            c<T> cVar = this.b;
            Objects.requireNonNull(cVar);
            SubscriptionHelper.cancel(cVar);
            this.b.a();
            c<T> cVar2 = this.c;
            Objects.requireNonNull(cVar2);
            SubscriptionHelper.cancel(cVar2);
            this.c.a();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual.b
        public void drain() {
            if (this.e.getAndIncrement() == 0) {
                int i = 1;
                do {
                    SimpleQueue<T> simpleQueue = this.b.e;
                    SimpleQueue<T> simpleQueue2 = this.c.e;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!isCancelled()) {
                            if (((Throwable) this.d.get()) != null) {
                                d();
                                this.d.tryTerminateConsumer(this.downstream);
                                return;
                            }
                            boolean z = this.b.f;
                            T t = this.f;
                            if (t == null) {
                                try {
                                    t = simpleQueue.poll();
                                    this.f = t;
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    d();
                                    this.d.tryAddThrowableOrReport(th);
                                    this.d.tryTerminateConsumer(this.downstream);
                                    return;
                                }
                            }
                            boolean z2 = false;
                            boolean z3 = t == null;
                            boolean z4 = this.c.f;
                            T t2 = this.g;
                            if (t2 == null) {
                                try {
                                    t2 = simpleQueue2.poll();
                                    this.g = t2;
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    d();
                                    this.d.tryAddThrowableOrReport(th2);
                                    this.d.tryTerminateConsumer(this.downstream);
                                    return;
                                }
                            }
                            if (t2 == null) {
                                z2 = true;
                            }
                            if (z && z4 && z3 && z2) {
                                complete(Boolean.TRUE);
                                return;
                            } else if (z && z4 && z3 != z2) {
                                d();
                                complete(Boolean.FALSE);
                                return;
                            } else if (!z3 && !z2) {
                                try {
                                    if (!this.a.test(t, t2)) {
                                        d();
                                        complete(Boolean.FALSE);
                                        return;
                                    }
                                    this.f = null;
                                    this.g = null;
                                    this.b.b();
                                    this.c.b();
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    d();
                                    this.d.tryAddThrowableOrReport(th3);
                                    this.d.tryTerminateConsumer(this.downstream);
                                    return;
                                }
                            }
                        }
                        this.b.a();
                        this.c.a();
                        return;
                    } else if (isCancelled()) {
                        this.b.a();
                        this.c.a();
                        return;
                    } else if (((Throwable) this.d.get()) != null) {
                        d();
                        this.d.tryTerminateConsumer(this.downstream);
                        return;
                    }
                    i = this.e.addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    public interface b {
        void a(Throwable th);

        void drain();
    }

    public static final class c<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        public final b a;
        public final int b;
        public final int c;
        public long d;
        public volatile SimpleQueue<T> e;
        public volatile boolean f;
        public int g;

        public c(b bVar, int i) {
            this.a = bVar;
            this.c = i - (i >> 2);
            this.b = i;
        }

        public void a() {
            SimpleQueue<T> simpleQueue = this.e;
            if (simpleQueue != null) {
                simpleQueue.clear();
            }
        }

        public void b() {
            if (this.g != 1) {
                long j = this.d + 1;
                if (j >= ((long) this.c)) {
                    this.d = 0;
                    ((Subscription) get()).request(j);
                    return;
                }
                this.d = j;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            this.a.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g != 0 || this.e.offer(t)) {
                this.a.drain();
                return;
            }
            this.a.a(new MissingBackpressureException());
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.g = requestFusion;
                        this.e = queueSubscription;
                        this.f = true;
                        this.a.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.g = requestFusion;
                        this.e = queueSubscription;
                        subscription.request((long) this.b);
                        return;
                    }
                }
                this.e = new SpscArrayQueue(this.b);
                subscription.request((long) this.b);
            }
        }
    }

    public FlowableSequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.b = publisher;
        this.c = publisher2;
        this.d = biPredicate;
        this.e = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        a aVar = new a(subscriber, this.e, this.d);
        subscriber.onSubscribe(aVar);
        Publisher<? extends T> publisher = this.b;
        Publisher<? extends T> publisher2 = this.c;
        publisher.subscribe(aVar.b);
        publisher2.subscribe(aVar.c);
    }
}
