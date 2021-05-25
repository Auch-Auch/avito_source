package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableSwitchMap<T, R> extends s6.a.c.b.a.a<T, R> {
    public final Function<? super T, ? extends Publisher<? extends R>> b;
    public final int c;
    public final boolean d;

    public static final class a<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        public final b<T, R> a;
        public final long b;
        public final int c;
        public volatile SimpleQueue<R> d;
        public volatile boolean e;
        public int f;

        public a(b<T, R> bVar, long j, int i) {
            this.a = bVar;
            this.b = j;
            this.c = i;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            b<T, R> bVar = this.a;
            if (this.b == bVar.k) {
                this.e = true;
                bVar.b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            b<T, R> bVar = this.a;
            if (this.b != bVar.k || !bVar.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!bVar.d) {
                bVar.h.cancel();
                bVar.e = true;
            }
            this.e = true;
            bVar.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            b<T, R> bVar = this.a;
            if (this.b != bVar.k) {
                return;
            }
            if (this.f != 0 || this.d.offer(r)) {
                bVar.b();
            } else {
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f = requestFusion;
                        this.d = queueSubscription;
                        this.e = true;
                        this.a.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f = requestFusion;
                        this.d = queueSubscription;
                        subscription.request((long) this.c);
                        return;
                    }
                }
                this.d = new SpscArrayQueue(this.c);
                subscription.request((long) this.c);
            }
        }
    }

    public static final class b<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final a<Object, Object> l;
        private static final long serialVersionUID = -3491074160481096299L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends Publisher<? extends R>> b;
        public final int c;
        public final boolean d;
        public volatile boolean e;
        public final AtomicThrowable f;
        public volatile boolean g;
        public Subscription h;
        public final AtomicReference<a<T, R>> i = new AtomicReference<>();
        public final AtomicLong j = new AtomicLong();
        public volatile long k;

        static {
            a<Object, Object> aVar = new a<>(null, -1, 1);
            l = aVar;
            SubscriptionHelper.cancel(aVar);
        }

        public b(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
            this.a = subscriber;
            this.b = function;
            this.c = i2;
            this.d = z;
            this.f = new AtomicThrowable();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$a<T, R>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            a<Object, Object> aVar;
            a<T, R> aVar2 = this.i.get();
            a<Object, Object> aVar3 = l;
            if (aVar2 != aVar3 && (aVar = (a) this.i.getAndSet(aVar3)) != aVar3 && aVar != null) {
                SubscriptionHelper.cancel(aVar);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0116, code lost:
            r14 = false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
            // Method dump skipped, instructions count: 327
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableSwitchMap.b.b():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.g) {
                this.g = true;
                this.h.cancel();
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.e) {
                this.e = true;
                b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.e || !this.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.d) {
                a();
            }
            this.e = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            a<T, R> aVar;
            if (!this.e) {
                long j2 = this.k + 1;
                this.k = j2;
                a<T, R> aVar2 = this.i.get();
                if (aVar2 != null) {
                    SubscriptionHelper.cancel(aVar2);
                }
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(t), "The publisher returned is null");
                    a<T, R> aVar3 = new a<>(this, j2, this.c);
                    do {
                        aVar = this.i.get();
                        if (aVar == l) {
                            return;
                        }
                    } while (!this.i.compareAndSet(aVar, aVar3));
                    publisher.subscribe(aVar3);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.h.cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.j, j2);
                if (this.k == 0) {
                    this.h.request(Long.MAX_VALUE);
                } else {
                    b();
                }
            }
        }
    }

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.b = function;
        this.c = i;
        this.d = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.b)) {
            this.source.subscribe((FlowableSubscriber) new b(subscriber, this.b, this.c, this.d));
        }
    }
}
