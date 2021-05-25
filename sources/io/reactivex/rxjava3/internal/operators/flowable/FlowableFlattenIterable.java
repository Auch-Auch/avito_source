package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableFlattenIterable<T, R> extends s6.a.e.d.c.a.a<T, R> {
    public final Function<? super T, ? extends Iterable<? extends R>> b;
    public final int c;

    public static final class a<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends Iterable<? extends R>> b;
        public final int c;
        public final int d;
        public final AtomicLong e = new AtomicLong();
        public Subscription f;
        public SimpleQueue<T> g;
        public volatile boolean h;
        public volatile boolean i;
        public final AtomicReference<Throwable> j = new AtomicReference<>();
        public Iterator<? extends R> k;
        public int l;
        public int m;

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i2) {
            this.a = subscriber;
            this.b = function;
            this.c = i2;
            this.d = i2 - (i2 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.i) {
                this.i = true;
                this.f.cancel();
                if (getAndIncrement() == 0) {
                    this.g.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.k = null;
            this.g.clear();
        }

        public boolean d(boolean z, boolean z2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.i) {
                this.k = null;
                simpleQueue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (this.j.get() != null) {
                    Throwable terminate = ExceptionHelper.terminate(this.j);
                    this.k = null;
                    simpleQueue.clear();
                    subscriber.onError(terminate);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x0080 */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0120, code lost:
            if (r6 == null) goto L_0x012b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
            // Method dump skipped, instructions count: 302
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableFlattenIterable.a.drain():void");
        }

        public void h(boolean z) {
            if (z) {
                int i2 = this.l + 1;
                if (i2 == this.d) {
                    this.l = 0;
                    this.f.request((long) i2);
                    return;
                }
                this.l = i2;
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.k == null && this.g.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.h) {
                this.h = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.h || !ExceptionHelper.addThrowable(this.j, th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.h = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.h) {
                if (this.m != 0 || this.g.offer(t)) {
                    drain();
                } else {
                    onError(new MissingBackpressureException("Queue is full?!"));
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.m = requestFusion;
                        this.g = queueSubscription;
                        this.h = true;
                        this.a.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.m = requestFusion;
                        this.g = queueSubscription;
                        this.a.onSubscribe(this);
                        subscription.request((long) this.c);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.c);
                this.a.onSubscribe(this);
                subscription.request((long) this.c);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() throws Throwable {
            Iterator<T> it = this.k;
            while (true) {
                if (it == null) {
                    T poll = this.g.poll();
                    if (poll != null) {
                        it = ((Iterable) this.b.apply(poll)).iterator();
                        if (it.hasNext()) {
                            this.k = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R r = (R) it.next();
            Objects.requireNonNull(r, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.k = null;
            }
            return r;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.e, j2);
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            return ((i2 & 1) == 0 || this.m != 1) ? 0 : 1;
        }
    }

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        super(flowable);
        this.b = function;
        this.c = i;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        return new a(subscriber, function, i);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Flowable<T> flowable = this.source;
        if (flowable instanceof Supplier) {
            try {
                Object obj = ((Supplier) flowable).get();
                if (obj == null) {
                    EmptySubscription.complete(subscriber);
                    return;
                }
                try {
                    FlowableFromIterable.subscribe(subscriber, ((Iterable) this.b.apply(obj)).iterator());
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
            }
        } else {
            flowable.subscribe((FlowableSubscriber) new a(subscriber, this.b, this.c));
        }
    }
}
