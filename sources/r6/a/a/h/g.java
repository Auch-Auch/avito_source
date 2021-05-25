package r6.a.a.h;

import hu.akarnokd.rxjava2.operators.ExpandStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.FlowableTransformer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class g<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Flowable<T> b;
    public final Function<? super T, ? extends Publisher<? extends T>> c;
    public final ExpandStrategy d;
    public final int e;
    public final boolean f;

    public static final class a<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8200116117441115256L;
        public final Subscriber<? super T> h;
        public final Function<? super T, ? extends Publisher<? extends T>> i;
        public final SimplePlainQueue<Publisher<? extends T>> j;
        public final AtomicInteger k = new AtomicInteger();
        public final boolean l;
        public final AtomicThrowable m;
        public volatile boolean n;
        public long o;

        public a(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<? extends T>> function, int i2, boolean z) {
            this.h = subscriber;
            this.i = function;
            this.j = new SpscLinkedArrayQueue(i2);
            this.m = new AtomicThrowable();
            this.l = z;
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            e();
        }

        public void e() {
            if (this.k.getAndIncrement() == 0) {
                do {
                    SimplePlainQueue<Publisher<? extends T>> simplePlainQueue = this.j;
                    if (isCancelled()) {
                        simplePlainQueue.clear();
                    } else if (!this.n) {
                        if (simplePlainQueue.isEmpty()) {
                            setSubscription(SubscriptionHelper.CANCELLED);
                            super.cancel();
                            Throwable terminate = this.m.terminate();
                            if (terminate == null) {
                                this.h.onComplete();
                            } else {
                                this.h.onError(terminate);
                            }
                        } else {
                            Publisher<? extends T> poll = simplePlainQueue.poll();
                            long j2 = this.o;
                            if (j2 != 0) {
                                this.o = 0;
                                produced(j2);
                            }
                            this.n = true;
                            poll.subscribe(this);
                        }
                    }
                } while (this.k.decrementAndGet() != 0);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.n = false;
            e();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            setSubscription(SubscriptionHelper.CANCELLED);
            if (this.l) {
                this.m.addThrowable(th);
                this.n = false;
            } else {
                super.cancel();
                this.h.onError(th);
            }
            e();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.o++;
            this.h.onNext(t);
            try {
                this.j.offer((Publisher) ObjectHelper.requireNonNull(this.i.apply(t), "The expander returned a null Publisher"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                super.cancel();
                this.h.onError(th);
                e();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public static final class b<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2126738751597075165L;
        public final Subscriber<? super T> a;
        public final Function<? super T, ? extends Publisher<? extends T>> b;
        public final AtomicThrowable c = new AtomicThrowable();
        public final AtomicInteger d = new AtomicInteger();
        public final AtomicLong e = new AtomicLong();
        public final AtomicReference<Object> f = new AtomicReference<>();
        public final boolean g;
        public ArrayDeque<b<T>.a> h = new ArrayDeque<>();
        public volatile boolean i;
        public Publisher<? extends T> j;
        public long k;

        public final class a extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
            private static final long serialVersionUID = 4198645419772153739L;
            public volatile boolean a;
            public volatile T b;

            public a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (!SubscriptionHelper.isCancelled((Subscription) get())) {
                    b bVar = b.this;
                    Objects.requireNonNull(bVar);
                    this.a = true;
                    bVar.a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (!SubscriptionHelper.isCancelled((Subscription) get())) {
                    b bVar = b.this;
                    bVar.c.addThrowable(th);
                    this.a = true;
                    bVar.a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                if (!SubscriptionHelper.isCancelled((Subscription) get())) {
                    this.b = t;
                    b.this.a();
                }
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(1);
                }
            }
        }

        /* JADX WARN: Incorrect args count in method signature: (Lorg/reactivestreams/Subscriber<-TT;>;Lio/reactivex/functions/Function<-TT;+Lorg/reactivestreams/Publisher<+TT;>;>;IZ)V */
        public b(Subscriber subscriber, Function function, boolean z) {
            this.a = subscriber;
            this.b = function;
            this.g = z;
        }

        public void a() {
            Publisher publisher;
            boolean z;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.a;
                long j2 = this.k;
                AtomicInteger atomicInteger = this.d;
                int i2 = 1;
                while (true) {
                    Object obj = this.f.get();
                    b<T>.a aVar = null;
                    if (this.i || obj == this) {
                        break;
                    }
                    b<T>.a aVar2 = (a) obj;
                    Publisher<? extends T> publisher2 = this.j;
                    if (aVar2 != null || publisher2 == null) {
                        boolean z2 = aVar2.a;
                        if (this.g || this.c.get() == null) {
                            T t = aVar2.b;
                            boolean z3 = false;
                            if (!(t == null || j2 == this.e.get())) {
                                aVar2.b = null;
                                subscriber.onNext(t);
                                j2++;
                                try {
                                    publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(t), "The expander returned a null Publisher");
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    SubscriptionHelper.cancel(aVar2);
                                    aVar2.a = true;
                                    this.c.addThrowable(th);
                                    t = null;
                                    publisher = null;
                                    z2 = true;
                                }
                                if (publisher != null) {
                                    synchronized (this) {
                                        ArrayDeque<b<T>.a> arrayDeque = this.h;
                                        if (arrayDeque != null) {
                                            arrayDeque.offerFirst(aVar2);
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                    }
                                    if (z) {
                                        atomicInteger.getAndIncrement();
                                        a aVar3 = new a();
                                        if (b(aVar3)) {
                                            publisher.subscribe(aVar3);
                                            z3 = true;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                            }
                            if (!z3 && z2 && t == null) {
                                if (atomicInteger.decrementAndGet() == 0) {
                                    Throwable terminate = this.c.terminate();
                                    if (terminate != null) {
                                        subscriber.onError(terminate);
                                        return;
                                    } else {
                                        subscriber.onComplete();
                                        return;
                                    }
                                } else {
                                    synchronized (this) {
                                        ArrayDeque<b<T>.a> arrayDeque2 = this.h;
                                        if (arrayDeque2 != null) {
                                            aVar = arrayDeque2.pollFirst();
                                        }
                                    }
                                    if (aVar != null && b(aVar)) {
                                        ((Subscription) aVar.get()).request(1);
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } else {
                            cancel();
                            subscriber.onError(this.c.terminate());
                            return;
                        }
                    } else {
                        this.j = null;
                        atomicInteger.getAndIncrement();
                        a aVar4 = new a();
                        if (b(aVar4)) {
                            publisher2.subscribe(aVar4);
                        } else {
                            return;
                        }
                    }
                    int i3 = get();
                    if (i2 == i3) {
                        this.k = j2;
                        i3 = addAndGet(-i2);
                        if (i3 == 0) {
                            return;
                        }
                    }
                    i2 = i3;
                }
                this.j = null;
            }
        }

        public boolean b(b<T>.a aVar) {
            Object obj;
            do {
                obj = this.f.get();
                if (obj == this) {
                    if (aVar == null) {
                        return false;
                    }
                    SubscriptionHelper.cancel(aVar);
                    return false;
                }
            } while (!this.f.compareAndSet(obj, aVar));
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            ArrayDeque<b<T>.a> arrayDeque;
            if (!this.i) {
                this.i = true;
                synchronized (this) {
                    arrayDeque = this.h;
                    this.h = null;
                }
                if (arrayDeque != null) {
                    while (!arrayDeque.isEmpty()) {
                        b<T>.a poll = arrayDeque.poll();
                        Objects.requireNonNull(poll);
                        SubscriptionHelper.cancel(poll);
                    }
                }
                Object andSet = this.f.getAndSet(this);
                if (andSet != this && andSet != null) {
                    SubscriptionHelper.cancel((a) andSet);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.e, j2);
                a();
            }
        }
    }

    public g(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends T>> function, ExpandStrategy expandStrategy, int i, boolean z) {
        this.b = flowable;
        this.c = function;
        this.d = expandStrategy;
        this.e = i;
        this.f = z;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new g(flowable, this.c, this.d, this.e, this.f);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.d != ExpandStrategy.DEPTH_FIRST) {
            a aVar = new a(subscriber, this.c, this.e, this.f);
            aVar.j.offer(this.b);
            subscriber.onSubscribe(aVar);
            aVar.e();
            return;
        }
        b bVar = new b(subscriber, this.c, this.f);
        bVar.j = this.b;
        subscriber.onSubscribe(bVar);
    }
}
