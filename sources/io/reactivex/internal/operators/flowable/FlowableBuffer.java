package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableBuffer<T, C extends Collection<? super T>> extends s6.a.c.b.a.a<T, C> {
    public final int b;
    public final int c;
    public final Callable<C> d;

    public static final class a<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        public final Subscriber<? super C> a;
        public final Callable<C> b;
        public final int c;
        public C d;
        public Subscription e;
        public boolean f;
        public int g;

        public a(Subscriber<? super C> subscriber, int i, Callable<C> callable) {
            this.a = subscriber;
            this.c = i;
            this.b = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.f) {
                this.f = true;
                C c2 = this.d;
                if (c2 != null && !c2.isEmpty()) {
                    this.a.onNext(c2);
                }
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f = true;
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.f) {
                C c2 = this.d;
                if (c2 == null) {
                    try {
                        c2 = (C) ((Collection) ObjectHelper.requireNonNull(this.b.call(), "The bufferSupplier returned a null buffer"));
                        this.d = c2;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.e.cancel();
                        onError(th);
                        return;
                    }
                }
                c2.add(t);
                int i = this.g + 1;
                if (i == this.c) {
                    this.g = 0;
                    this.d = null;
                    this.a.onNext(c2);
                    return;
                }
                this.g = i;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.e.request(BackpressureHelper.multiplyCap(j, (long) this.c));
            }
        }
    }

    public static final class b<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;
        public final Subscriber<? super C> a;
        public final Callable<C> b;
        public final int c;
        public final int d;
        public final ArrayDeque<C> e = new ArrayDeque<>();
        public final AtomicBoolean f = new AtomicBoolean();
        public Subscription g;
        public boolean h;
        public int i;
        public volatile boolean j;
        public long k;

        public b(Subscriber<? super C> subscriber, int i2, int i3, Callable<C> callable) {
            this.a = subscriber;
            this.c = i2;
            this.d = i3;
            this.b = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.j = true;
            this.g.cancel();
        }

        @Override // io.reactivex.functions.BooleanSupplier
        public boolean getAsBoolean() {
            return this.j;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.h) {
                this.h = true;
                long j2 = this.k;
                if (j2 != 0) {
                    BackpressureHelper.produced(this, j2);
                }
                QueueDrainHelper.postComplete(this.a, this.e, this, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.h = true;
            this.e.clear();
            this.a.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.ArrayDeque<C extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.h) {
                ArrayDeque<C> arrayDeque = this.e;
                int i2 = this.i;
                int i3 = i2 + 1;
                if (i2 == 0) {
                    try {
                        arrayDeque.offer((Collection) ObjectHelper.requireNonNull(this.b.call(), "The bufferSupplier returned a null buffer"));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                Collection collection = (Collection) arrayDeque.peek();
                if (collection != null && collection.size() + 1 == this.c) {
                    arrayDeque.poll();
                    collection.add(t);
                    this.k++;
                    this.a.onNext(collection);
                }
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(t);
                }
                if (i3 == this.d) {
                    i3 = 0;
                }
                this.i = i3;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2) && !QueueDrainHelper.postCompleteRequest(j2, this.a, this.e, this, this)) {
                if (this.f.get() || !this.f.compareAndSet(false, true)) {
                    this.g.request(BackpressureHelper.multiplyCap((long) this.d, j2));
                    return;
                }
                this.g.request(BackpressureHelper.addCap((long) this.c, BackpressureHelper.multiplyCap((long) this.d, j2 - 1)));
            }
        }
    }

    public static final class c<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        public final Subscriber<? super C> a;
        public final Callable<C> b;
        public final int c;
        public final int d;
        public C e;
        public Subscription f;
        public boolean g;
        public int h;

        public c(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.a = subscriber;
            this.c = i;
            this.d = i2;
            this.b = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.g) {
                this.g = true;
                C c2 = this.e;
                this.e = null;
                if (c2 != null) {
                    this.a.onNext(c2);
                }
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = true;
            this.e = null;
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.g) {
                C c2 = this.e;
                int i = this.h;
                int i2 = i + 1;
                if (i == 0) {
                    try {
                        c2 = (C) ((Collection) ObjectHelper.requireNonNull(this.b.call(), "The bufferSupplier returned a null buffer"));
                        this.e = c2;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f.cancel();
                        onError(th);
                        return;
                    }
                }
                if (c2 != null) {
                    c2.add(t);
                    if (c2.size() == this.c) {
                        this.e = null;
                        this.a.onNext(c2);
                    }
                }
                if (i2 == this.d) {
                    i2 = 0;
                }
                this.h = i2;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (!SubscriptionHelper.validate(j)) {
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                this.f.request(BackpressureHelper.multiplyCap((long) this.d, j));
                return;
            }
            this.f.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(j, (long) this.c), BackpressureHelper.multiplyCap((long) (this.d - this.c), j - 1)));
        }
    }

    public FlowableBuffer(Flowable<T> flowable, int i, int i2, Callable<C> callable) {
        super(flowable);
        this.b = i;
        this.c = i2;
        this.d = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super C> subscriber) {
        int i = this.b;
        int i2 = this.c;
        if (i == i2) {
            this.source.subscribe((FlowableSubscriber) new a(subscriber, i, this.d));
        } else if (i2 > i) {
            this.source.subscribe((FlowableSubscriber) new c(subscriber, this.b, this.c, this.d));
        } else {
            this.source.subscribe((FlowableSubscriber) new b(subscriber, this.b, this.c, this.d));
        }
    }
}
