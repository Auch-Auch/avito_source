package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends s6.a.c.b.a.a<TLeft, R> {
    public final Publisher<? extends TRight> b;
    public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> c;
    public final Function<? super TRight, ? extends Publisher<TRightEnd>> d;
    public final BiFunction<? super TLeft, ? super TRight, ? extends R> e;

    public static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.b {
        public static final Integer o = 1;
        public static final Integer p = 2;
        public static final Integer q = 3;
        public static final Integer r = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        public final Subscriber<? super R> a;
        public final AtomicLong b = new AtomicLong();
        public final SpscLinkedArrayQueue<Object> c = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
        public final CompositeDisposable d = new CompositeDisposable();
        public final Map<Integer, TLeft> e = new LinkedHashMap();
        public final Map<Integer, TRight> f = new LinkedHashMap();
        public final AtomicReference<Throwable> g = new AtomicReference<>();
        public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> h;
        public final Function<? super TRight, ? extends Publisher<TRightEnd>> i;
        public final BiFunction<? super TLeft, ? super TRight, ? extends R> j;
        public final AtomicInteger k;
        public int l;
        public int m;
        public volatile boolean n;

        public a(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.a = subscriber;
            this.h = function;
            this.i = function2;
            this.j = biFunction;
            this.k = new AtomicInteger(2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.b
        public void a(Throwable th) {
            if (ExceptionHelper.addThrowable(this.g, th)) {
                this.k.decrementAndGet();
                f();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.b
        public void b(Throwable th) {
            if (ExceptionHelper.addThrowable(this.g, th)) {
                f();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.b
        public void c(boolean z, Object obj) {
            synchronized (this) {
                this.c.offer(z ? o : p, obj);
            }
            f();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.n) {
                this.n = true;
                this.d.dispose();
                if (getAndIncrement() == 0) {
                    this.c.clear();
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.b
        public void d(boolean z, FlowableGroupJoin.c cVar) {
            synchronized (this) {
                this.c.offer(z ? q : r, cVar);
            }
            f();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.b
        public void e(FlowableGroupJoin.d dVar) {
            this.d.delete(dVar);
            this.k.decrementAndGet();
            f();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: java.util.Map<java.lang.Integer, TRight> */
        /* JADX DEBUG: Multi-variable search result rejected for r7v9, resolved type: java.util.Map<java.lang.Integer, TLeft> */
        /* JADX WARN: Multi-variable type inference failed */
        public void f() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.c;
                Subscriber<?> subscriber = this.a;
                boolean z = true;
                int i2 = 1;
                while (!this.n) {
                    if (this.g.get() != null) {
                        spscLinkedArrayQueue.clear();
                        this.d.dispose();
                        h(subscriber);
                        return;
                    }
                    boolean z2 = this.k.get() == 0;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z3 = num == null;
                    if (z2 && z3) {
                        this.e.clear();
                        this.f.clear();
                        this.d.dispose();
                        subscriber.onComplete();
                        return;
                    } else if (z3) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == o) {
                            int i3 = this.l;
                            this.l = i3 + 1;
                            this.e.put(Integer.valueOf(i3), poll);
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.h.apply(poll), "The leftEnd returned a null Publisher");
                                FlowableGroupJoin.c cVar = new FlowableGroupJoin.c(this, z, i3);
                                this.d.add(cVar);
                                publisher.subscribe(cVar);
                                if (this.g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.d.dispose();
                                    h(subscriber);
                                    return;
                                }
                                long j2 = this.b.get();
                                long j3 = 0;
                                for (TRight tright : this.f.values()) {
                                    try {
                                        Object obj = (Object) ObjectHelper.requireNonNull(this.j.apply(poll, tright), "The resultSelector returned a null value");
                                        if (j3 != j2) {
                                            subscriber.onNext(obj);
                                            j3++;
                                        } else {
                                            ExceptionHelper.addThrowable(this.g, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            spscLinkedArrayQueue.clear();
                                            this.d.dispose();
                                            h(subscriber);
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        i(th, subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                if (j3 != 0) {
                                    BackpressureHelper.produced(this.b, j3);
                                }
                            } catch (Throwable th2) {
                                i(th2, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == p) {
                            int i4 = this.m;
                            this.m = i4 + 1;
                            this.f.put(Integer.valueOf(i4), poll);
                            try {
                                Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(this.i.apply(poll), "The rightEnd returned a null Publisher");
                                FlowableGroupJoin.c cVar2 = new FlowableGroupJoin.c(this, false, i4);
                                this.d.add(cVar2);
                                publisher2.subscribe(cVar2);
                                if (this.g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.d.dispose();
                                    h(subscriber);
                                    return;
                                }
                                long j4 = this.b.get();
                                long j5 = 0;
                                for (TLeft tleft : this.e.values()) {
                                    try {
                                        Object obj2 = (Object) ObjectHelper.requireNonNull(this.j.apply(tleft, poll), "The resultSelector returned a null value");
                                        if (j5 != j4) {
                                            subscriber.onNext(obj2);
                                            j5++;
                                        } else {
                                            ExceptionHelper.addThrowable(this.g, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            spscLinkedArrayQueue.clear();
                                            this.d.dispose();
                                            h(subscriber);
                                            return;
                                        }
                                    } catch (Throwable th3) {
                                        i(th3, subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                if (j5 != 0) {
                                    BackpressureHelper.produced(this.b, j5);
                                }
                            } catch (Throwable th4) {
                                i(th4, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == q) {
                            FlowableGroupJoin.c cVar3 = (FlowableGroupJoin.c) poll;
                            this.e.remove(Integer.valueOf(cVar3.c));
                            this.d.remove(cVar3);
                        } else if (num == r) {
                            FlowableGroupJoin.c cVar4 = (FlowableGroupJoin.c) poll;
                            this.f.remove(Integer.valueOf(cVar4.c));
                            this.d.remove(cVar4);
                        }
                        z = true;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void h(Subscriber<?> subscriber) {
            Throwable terminate = ExceptionHelper.terminate(this.g);
            this.e.clear();
            this.f.clear();
            subscriber.onError(terminate);
        }

        public void i(Throwable th, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.throwIfFatal(th);
            ExceptionHelper.addThrowable(this.g, th);
            simpleQueue.clear();
            this.d.dispose();
            h(subscriber);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.b, j2);
            }
        }
    }

    public FlowableJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flowable);
        this.b = publisher;
        this.c = function;
        this.d = function2;
        this.e = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        a aVar = new a(subscriber, this.c, this.d, this.e);
        subscriber.onSubscribe(aVar);
        FlowableGroupJoin.d dVar = new FlowableGroupJoin.d(aVar, true);
        aVar.d.add(dVar);
        FlowableGroupJoin.d dVar2 = new FlowableGroupJoin.d(aVar, false);
        aVar.d.add(dVar2);
        this.source.subscribe((FlowableSubscriber) dVar);
        this.b.subscribe(dVar2);
    }
}
