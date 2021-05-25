package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import hu.akarnokd.rxjava3.util.CompositeSubscription;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import r6.a.b.b.n0;
public final class o0 extends Nono {
    public final Iterable<? extends Nono> b;
    public final boolean c;
    public final int d;

    public static final class a extends BasicIntQueueSubscription<Void> implements n0.c {
        private static final long serialVersionUID = -58058606508277827L;
        public final Subscriber<? super Void> a;
        public final AtomicThrowable b = new AtomicThrowable();
        public final boolean c;
        public final Iterator<? extends Nono> d;
        public final CompositeSubscription e;
        public final AtomicInteger f;
        public volatile boolean g;

        /* JADX WARN: Incorrect args count in method signature: (Lorg/reactivestreams/Subscriber<-Ljava/lang/Void;>;ZILjava/util/Iterator<+Lhu/akarnokd/rxjava3/basetypes/Nono;>;)V */
        public a(Subscriber subscriber, boolean z, Iterator it) {
            this.a = subscriber;
            this.c = z;
            this.d = it;
            this.e = new CompositeSubscription();
            this.f = new AtomicInteger();
            lazySet(1);
        }

        @Override // r6.a.b.b.n0.c
        public void b(n0.a aVar, Throwable th) {
            this.e.delete(aVar);
            if (!this.b.tryAddThrowableOrReport(th)) {
                return;
            }
            if (!this.c) {
                this.e.cancel();
                this.b.tryTerminateConsumer(this.a);
                return;
            }
            h(1);
            d();
        }

        @Override // r6.a.b.b.n0.c
        public void c(n0.a aVar) {
            this.e.delete(aVar);
            h(1);
            d();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.g = true;
            this.e.cancel();
            this.b.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
        }

        public void d() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.b.terminate();
                if (terminate != null) {
                    this.a.onError(terminate);
                } else {
                    this.a.onComplete();
                }
            }
        }

        public void h(int i) {
            int i2;
            int i3;
            do {
                i2 = this.f.get();
                i3 = Integer.MAX_VALUE;
                if (i2 != Integer.MAX_VALUE) {
                    int i4 = i2 + i;
                    if (i4 >= 0) {
                        i3 = i4;
                    }
                } else {
                    return;
                }
            } while (!this.f.compareAndSet(i2, i3));
            if (i2 == 0) {
                Iterator<? extends Nono> it = this.d;
                do {
                    int i5 = 0;
                    while (true) {
                        if (i5 == i) {
                            i = get();
                            if (i5 == i) {
                                i = addAndGet(-i5);
                            }
                        } else if (!this.g) {
                            Nono nono = null;
                            try {
                                boolean hasNext = it.hasNext();
                                if (hasNext) {
                                    nono = (Nono) it.next();
                                    Objects.requireNonNull(nono, "The iterator returned a null Nono");
                                }
                                if (hasNext) {
                                    n0.a aVar = new n0.a(this);
                                    this.e.add(aVar);
                                    getAndIncrement();
                                    nono.subscribe(aVar);
                                    i5++;
                                } else {
                                    d();
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.b.tryAddThrowableOrReport(th);
                                d();
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } while (i != 0);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public /* bridge */ /* synthetic */ Object poll() throws Throwable {
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return i & 2;
        }
    }

    public o0(Iterable<? extends Nono> iterable, boolean z, int i) {
        this.b = iterable;
        this.c = z;
        this.d = i;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        try {
            Iterator<? extends Nono> it = this.b.iterator();
            Objects.requireNonNull(it, "The source Iterable returned a null Iterator");
            a aVar = new a(subscriber, this.c, it);
            subscriber.onSubscribe(aVar);
            aVar.h(this.d);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
