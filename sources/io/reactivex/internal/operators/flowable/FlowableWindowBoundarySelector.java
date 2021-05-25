package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableWindowBoundarySelector<T, B, V> extends s6.a.c.b.a.a<T, Flowable<T>> {
    public final Publisher<B> b;
    public final Function<? super B, ? extends Publisher<V>> c;
    public final int d;

    public static final class a<T, V> extends DisposableSubscriber<V> {
        public final c<T, ?, V> b;
        public final UnicastProcessor<T> c;
        public boolean d;

        public a(c<T, ?, V> cVar, UnicastProcessor<T> unicastProcessor) {
            this.b = cVar;
            this.c = unicastProcessor;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.d) {
                this.d = true;
                c<T, ?, V> cVar = this.b;
                cVar.f.delete(this);
                cVar.queue.offer((U) new d(this.c, null));
                if (cVar.enter()) {
                    cVar.a();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            c<T, ?, V> cVar = this.b;
            cVar.g.cancel();
            cVar.f.dispose();
            DisposableHelper.dispose(cVar.h);
            cVar.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(V v) {
            cancel();
            onComplete();
        }
    }

    public static final class b<T, B> extends DisposableSubscriber<B> {
        public final c<T, B, ?> b;

        public b(c<T, B, ?> cVar) {
            this.b = cVar;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            c<T, B, ?> cVar = this.b;
            cVar.g.cancel();
            cVar.f.dispose();
            DisposableHelper.dispose(cVar.h);
            cVar.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b2) {
            c<T, B, ?> cVar = this.b;
            cVar.queue.offer((U) new d(null, b2));
            if (cVar.enter()) {
                cVar.a();
            }
        }
    }

    public static final class c<T, B, V> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        public final Publisher<B> c;
        public final Function<? super B, ? extends Publisher<V>> d;
        public final int e;
        public final CompositeDisposable f;
        public Subscription g;
        public final AtomicReference<Disposable> h = new AtomicReference<>();
        public final List<UnicastProcessor<T>> i;
        public final AtomicLong j;
        public final AtomicBoolean k;

        public c(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i2) {
            super(subscriber, new MpscLinkedQueue());
            AtomicLong atomicLong = new AtomicLong();
            this.j = atomicLong;
            this.k = new AtomicBoolean();
            this.c = publisher;
            this.d = function;
            this.e = i2;
            this.f = new CompositeDisposable();
            this.i = new ArrayList();
            atomicLong.lazySet(1);
        }

        public void a() {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            Subscriber<? super V> subscriber = this.downstream;
            List<UnicastProcessor<T>> list = this.i;
            int i2 = 1;
            while (true) {
                boolean z = this.done;
                U poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    this.f.dispose();
                    DisposableHelper.dispose(this.h);
                    Throwable th = this.error;
                    if (th != null) {
                        for (UnicastProcessor<T> unicastProcessor : list) {
                            unicastProcessor.onError(th);
                        }
                    } else {
                        for (UnicastProcessor<T> unicastProcessor2 : list) {
                            unicastProcessor2.onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (z2) {
                    i2 = leave(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll instanceof d) {
                    U u = poll;
                    UnicastProcessor<T> unicastProcessor3 = u.a;
                    if (unicastProcessor3 != null) {
                        if (list.remove(unicastProcessor3)) {
                            u.a.onComplete();
                            if (this.j.decrementAndGet() == 0) {
                                this.f.dispose();
                                DisposableHelper.dispose(this.h);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.k.get()) {
                        UnicastProcessor<T> create = UnicastProcessor.create(this.e);
                        long requested = requested();
                        if (requested != 0) {
                            list.add(create);
                            subscriber.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1);
                            }
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.d.apply(u.b), "The publisher supplied is null");
                                a aVar = new a(this, create);
                                if (this.f.add(aVar)) {
                                    this.j.getAndIncrement();
                                    publisher.subscribe(aVar);
                                }
                            } catch (Throwable th2) {
                                cancel();
                                subscriber.onError(th2);
                            }
                        } else {
                            cancel();
                            subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    for (UnicastProcessor<T> unicastProcessor4 : list) {
                        unicastProcessor4.onNext((T) NotificationLite.getValue(poll));
                    }
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public boolean accept(Subscriber<? super Flowable<T>> subscriber, Object obj) {
            return false;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.k.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.h);
                if (this.j.decrementAndGet() == 0) {
                    this.g.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                if (enter()) {
                    a();
                }
                if (this.j.decrementAndGet() == 0) {
                    this.f.dispose();
                }
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            if (enter()) {
                a();
            }
            if (this.j.decrementAndGet() == 0) {
                this.f.dispose();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                if (fastEnter()) {
                    for (UnicastProcessor<T> unicastProcessor : this.i) {
                        unicastProcessor.onNext(t);
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer((U) NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                a();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.downstream.onSubscribe(this);
                if (!this.k.get()) {
                    b bVar = new b(this);
                    if (this.h.compareAndSet(null, bVar)) {
                        subscription.request(Long.MAX_VALUE);
                        this.c.subscribe(bVar);
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            requested(j2);
        }
    }

    public static final class d<T, B> {
        public final UnicastProcessor<T> a;
        public final B b;

        public d(UnicastProcessor<T> unicastProcessor, B b2) {
            this.a = unicastProcessor;
            this.b = b2;
        }
    }

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
        super(flowable);
        this.b = publisher;
        this.c = function;
        this.d = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new c(new SerializedSubscriber(subscriber), this.b, this.c, this.d));
    }
}
