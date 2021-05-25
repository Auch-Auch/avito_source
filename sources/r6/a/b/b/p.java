package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class p extends Nono {
    public final Publisher<? extends Nono> b;
    public final int c;
    public final ErrorMode d;

    public static abstract class a extends BasicIntQueueSubscription<Void> implements Subscriber<Nono> {
        private static final long serialVersionUID = -2273338080908719181L;
        public final Subscriber<? super Void> a;
        public final int b;
        public final int c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final C0621a e = new C0621a();
        public Subscription f;
        public SimpleQueue<Nono> g;
        public int h;
        public int i;
        public volatile boolean j;
        public volatile boolean k;
        public volatile boolean l;

        /* renamed from: r6.a.b.b.p$a$a  reason: collision with other inner class name */
        public final class C0621a extends AtomicReference<Subscription> implements Subscriber<Void> {
            private static final long serialVersionUID = -1235060320533681511L;

            public C0621a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a.this.j = false;
                a.this.drain();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.a(th);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // org.reactivestreams.Subscriber
            public void onNext(Void r1) {
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.replace(this, subscription);
            }
        }

        public a(Subscriber<? super Void> subscriber, int i2) {
            this.a = subscriber;
            this.b = i2;
            this.c = i2 - (i2 >> 2);
        }

        public abstract void a(Throwable th);

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final void clear() {
        }

        public final void d() {
            if (this.h != 1 && this.b != Integer.MAX_VALUE) {
                int i2 = this.i + 1;
                if (i2 == this.c) {
                    this.i = 0;
                    this.f.request((long) i2);
                    return;
                }
                this.i = i2;
            }
        }

        public abstract void drain();

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return true;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Nono nono) {
            Nono nono2 = nono;
            if (this.h != 0 || this.g.offer(nono2)) {
                drain();
                return;
            }
            this.f.cancel();
            onError(new MissingBackpressureException());
        }

        @Override // org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                long j2 = Long.MAX_VALUE;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.h = requestFusion;
                        this.g = queueSubscription;
                        this.k = true;
                        this.a.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.h = requestFusion;
                        this.g = queueSubscription;
                        this.a.onSubscribe(this);
                        int i2 = this.b;
                        if (i2 != Integer.MAX_VALUE) {
                            j2 = (long) i2;
                        }
                        subscription.request(j2);
                        return;
                    }
                }
                if (this.b == Integer.MAX_VALUE) {
                    this.g = new SpscLinkedArrayQueue(Nono.bufferSize());
                    this.a.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    return;
                }
                this.g = new SpscArrayQueue(this.b);
                this.a.onSubscribe(this);
                subscription.request((long) this.b);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public /* bridge */ /* synthetic */ Object poll() throws Throwable {
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j2) {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public final int requestFusion(int i2) {
            return i2 & 2;
        }
    }

    public static final class b extends a {
        private static final long serialVersionUID = -3402839602492103389L;
        public final boolean m;

        public b(Subscriber<? super Void> subscriber, int i, boolean z) {
            super(subscriber, i);
            this.m = z;
        }

        @Override // r6.a.b.b.p.a
        public void a(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                if (!this.m) {
                    this.f.cancel();
                }
                this.j = false;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.l = true;
            this.f.cancel();
            a.C0621a aVar = this.e;
            Objects.requireNonNull(aVar);
            SubscriptionHelper.cancel(aVar);
            this.d.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // r6.a.b.b.p.a
        public void drain() {
            if (getAndIncrement() == 0) {
                while (!this.l) {
                    if (!this.j) {
                        if (this.m || this.d.get() == null) {
                            boolean z = this.k;
                            try {
                                Nono poll = this.g.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    this.d.tryTerminateConsumer(this.a);
                                    return;
                                } else if (!z2) {
                                    d();
                                    this.j = true;
                                    poll.subscribe(this.e);
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.f.cancel();
                                this.g.clear();
                                this.d.tryAddThrowableOrReport(th);
                                this.d.tryTerminateConsumer(this.a);
                                return;
                            }
                        } else {
                            this.g.clear();
                            this.d.tryTerminateConsumer(this.a);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.g.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.k = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                this.k = true;
                drain();
            }
        }
    }

    public static final class c extends a {
        private static final long serialVersionUID = 6000895759062406410L;
        public final AtomicInteger m = new AtomicInteger();

        public c(Subscriber<? super Void> subscriber, int i) {
            super(subscriber, i);
        }

        @Override // r6.a.b.b.p.a
        public void a(Throwable th) {
            h(true);
            HalfSerializer.onError(this.a, th, this, this.d);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            h(false);
        }

        @Override // r6.a.b.b.p.a
        public void drain() {
            if (this.m.getAndIncrement() == 0) {
                while (!this.l) {
                    if (!this.j) {
                        boolean z = this.k;
                        try {
                            Nono poll = this.g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                HalfSerializer.onComplete(this.a, this, this.d);
                                return;
                            } else if (!z2) {
                                d();
                                this.j = true;
                                poll.subscribe(this.e);
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.f.cancel();
                            this.g.clear();
                            HalfSerializer.onError(this.a, th, this, this.d);
                            return;
                        }
                    }
                    if (this.m.decrementAndGet() == 0) {
                        return;
                    }
                }
                this.g.clear();
            }
        }

        public void h(boolean z) {
            this.l = true;
            this.f.cancel();
            a.C0621a aVar = this.e;
            Objects.requireNonNull(aVar);
            SubscriptionHelper.cancel(aVar);
            if (!z) {
                this.d.tryTerminateAndReport();
            }
            if (this.m.getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.k = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            h(true);
            HalfSerializer.onError(this.a, th, this, this.d);
        }
    }

    public p(Publisher<? extends Nono> publisher, int i, ErrorMode errorMode) {
        this.b = publisher;
        this.c = i;
        this.d = errorMode;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        if (this.d == ErrorMode.IMMEDIATE) {
            this.b.subscribe(new c(subscriber, this.c));
        } else {
            this.b.subscribe(new b(subscriber, this.c, this.d == ErrorMode.END));
        }
    }
}
