package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class r extends Nono {
    public final Iterable<? extends Nono> b;
    public final boolean c;

    public static final class a extends e<Void, Subscription> implements Subscriber<Void> {
        private static final long serialVersionUID = -4926738846855955051L;
        public final Subscriber<? super Void> a;
        public final AtomicThrowable b;
        public final Iterator<? extends Nono> c;
        public final AtomicInteger d;
        public volatile boolean e;

        public a(Subscriber<? super Void> subscriber, Iterator<? extends Nono> it, boolean z) {
            this.a = subscriber;
            this.c = it;
            this.b = z ? new AtomicThrowable() : null;
            this.d = new AtomicInteger();
        }

        public void a() {
            if (this.d.getAndIncrement() == 0) {
                while (SubscriptionHelper.CANCELLED != get()) {
                    if (!this.e) {
                        Nono nono = null;
                        try {
                            boolean hasNext = this.c.hasNext();
                            if (hasNext) {
                                Nono nono2 = (Nono) this.c.next();
                                Objects.requireNonNull(nono2, "The iterator returned a null Nono");
                                nono = nono2;
                            }
                            if (!hasNext) {
                                AtomicThrowable atomicThrowable = this.b;
                                if (atomicThrowable != null) {
                                    atomicThrowable.tryTerminateConsumer(this.a);
                                    return;
                                } else {
                                    this.a.onComplete();
                                    return;
                                }
                            } else {
                                this.e = true;
                                nono.subscribe(this);
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            AtomicThrowable atomicThrowable2 = this.b;
                            if (atomicThrowable2 != null) {
                                atomicThrowable2.tryAddThrowableOrReport(th);
                                this.b.tryTerminateConsumer(this.a);
                                return;
                            }
                            this.a.onError(th);
                            return;
                        }
                    }
                    if (this.d.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
            AtomicThrowable atomicThrowable = this.b;
            if (atomicThrowable != null) {
                atomicThrowable.tryTerminateAndReport();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.e = false;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            AtomicThrowable atomicThrowable = this.b;
            if (atomicThrowable == null) {
                this.a.onError(th);
            } else if (atomicThrowable.tryAddThrowableOrReport(th)) {
                this.e = false;
                a();
            }
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

    public r(Iterable<? extends Nono> iterable, boolean z) {
        this.b = iterable;
        this.c = z;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        try {
            Iterator<? extends Nono> it = this.b.iterator();
            Objects.requireNonNull(it, "The sources Iterable returned a null Iterator");
            a aVar = new a(subscriber, it, this.c);
            subscriber.onSubscribe(aVar);
            aVar.a();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
