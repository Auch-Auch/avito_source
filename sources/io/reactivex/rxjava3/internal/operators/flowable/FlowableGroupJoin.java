package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends s6.a.e.d.c.a.a<TLeft, R> {
    public final Publisher<? extends TRight> b;
    public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> c;
    public final Function<? super TRight, ? extends Publisher<TRightEnd>> d;
    public final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> e;

    public static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, b {
        public static final Integer o = 1;
        public static final Integer p = 2;
        public static final Integer q = 3;
        public static final Integer r = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        public final Subscriber<? super R> a;
        public final AtomicLong b = new AtomicLong();
        public final SpscLinkedArrayQueue<Object> c = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
        public final CompositeDisposable d = new CompositeDisposable();
        public final Map<Integer, UnicastProcessor<TRight>> e = new LinkedHashMap();
        public final Map<Integer, TRight> f = new LinkedHashMap();
        public final AtomicReference<Throwable> g = new AtomicReference<>();
        public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> h;
        public final Function<? super TRight, ? extends Publisher<TRightEnd>> i;
        public final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> j;
        public final AtomicInteger k;
        public int l;
        public int m;
        public volatile boolean n;

        public a(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
            this.a = subscriber;
            this.h = function;
            this.i = function2;
            this.j = biFunction;
            this.k = new AtomicInteger(2);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin.b
        public void a(Throwable th) {
            if (ExceptionHelper.addThrowable(this.g, th)) {
                this.k.decrementAndGet();
                f();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin.b
        public void b(Throwable th) {
            if (ExceptionHelper.addThrowable(this.g, th)) {
                f();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin.b
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

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin.b
        public void d(d dVar) {
            this.d.delete(dVar);
            this.k.decrementAndGet();
            f();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin.b
        public void e(boolean z, c cVar) {
            synchronized (this) {
                this.c.offer(z ? q : r, cVar);
            }
            f();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v9, resolved type: java.util.Map<java.lang.Integer, TRight> */
        /* JADX WARN: Multi-variable type inference failed */
        public void f() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.c;
                Subscriber<?> subscriber = this.a;
                int i2 = 1;
                while (!this.n) {
                    if (this.g.get() != null) {
                        spscLinkedArrayQueue.clear();
                        this.d.dispose();
                        h(subscriber);
                        return;
                    }
                    boolean z = this.k.get() == 0;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        for (UnicastProcessor<TRight> unicastProcessor : this.e.values()) {
                            unicastProcessor.onComplete();
                        }
                        this.e.clear();
                        this.f.clear();
                        this.d.dispose();
                        subscriber.onComplete();
                        return;
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == o) {
                            UnicastProcessor<TRight> create = UnicastProcessor.create();
                            int i3 = this.l;
                            this.l = i3 + 1;
                            this.e.put(Integer.valueOf(i3), create);
                            try {
                                Object apply = this.h.apply(poll);
                                Objects.requireNonNull(apply, "The leftEnd returned a null Publisher");
                                Publisher publisher = (Publisher) apply;
                                c cVar = new c(this, true, i3);
                                this.d.add(cVar);
                                publisher.subscribe(cVar);
                                if (this.g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.d.dispose();
                                    h(subscriber);
                                    return;
                                }
                                try {
                                    Object obj = (Object) this.j.apply(poll, create);
                                    Objects.requireNonNull(obj, "The resultSelector returned a null value");
                                    if (this.b.get() != 0) {
                                        subscriber.onNext(obj);
                                        BackpressureHelper.produced(this.b, 1);
                                        for (TRight tright : this.f.values()) {
                                            create.onNext(tright);
                                        }
                                    } else {
                                        i(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    i(th, subscriber, spscLinkedArrayQueue);
                                    return;
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
                                Object apply2 = this.i.apply(poll);
                                Objects.requireNonNull(apply2, "The rightEnd returned a null Publisher");
                                Publisher publisher2 = (Publisher) apply2;
                                c cVar2 = new c(this, false, i4);
                                this.d.add(cVar2);
                                publisher2.subscribe(cVar2);
                                if (this.g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.d.dispose();
                                    h(subscriber);
                                    return;
                                }
                                for (UnicastProcessor<TRight> unicastProcessor2 : this.e.values()) {
                                    unicastProcessor2.onNext(poll);
                                }
                            } catch (Throwable th3) {
                                i(th3, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == q) {
                            c cVar3 = (c) poll;
                            UnicastProcessor<TRight> remove = this.e.remove(Integer.valueOf(cVar3.c));
                            this.d.remove(cVar3);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else {
                            c cVar4 = (c) poll;
                            this.f.remove(Integer.valueOf(cVar4.c));
                            this.d.remove(cVar4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void h(Subscriber<?> subscriber) {
            Throwable terminate = ExceptionHelper.terminate(this.g);
            for (UnicastProcessor<TRight> unicastProcessor : this.e.values()) {
                unicastProcessor.onError(terminate);
            }
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

    public interface b {
        void a(Throwable th);

        void b(Throwable th);

        void c(boolean z, Object obj);

        void d(d dVar);

        void e(boolean z, c cVar);
    }

    public static final class c extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        public final b a;
        public final boolean b;
        public final int c;

        public c(b bVar, boolean z, int i) {
            this.a = bVar;
            this.b = z;
            this.c = i;
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
            this.a.e(this.b, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.b(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.a.e(this.b, this);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class d extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        public final b a;
        public final boolean b;

        public d(b bVar, boolean z) {
            this.a = bVar;
            this.b = z;
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
            this.a.d(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            this.a.c(this.b, obj);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableGroupJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
        super(flowable);
        this.b = publisher;
        this.c = function;
        this.d = function2;
        this.e = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        a aVar = new a(subscriber, this.c, this.d, this.e);
        subscriber.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.d.add(dVar);
        d dVar2 = new d(aVar, false);
        aVar.d.add(dVar2);
        this.source.subscribe((FlowableSubscriber) dVar);
        this.b.subscribe(dVar2);
    }
}
