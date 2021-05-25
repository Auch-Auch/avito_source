package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Iterator;
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
                while (!SubscriptionHelper.isCancelled((Subscription) get())) {
                    if (!this.e) {
                        try {
                            boolean hasNext = this.c.hasNext();
                            Throwable th = null;
                            Nono nono = hasNext ? (Nono) ObjectHelper.requireNonNull(this.c.next(), "The iterator returned a null Nono") : null;
                            if (!hasNext) {
                                AtomicThrowable atomicThrowable = this.b;
                                if (atomicThrowable != null) {
                                    th = atomicThrowable.terminate();
                                }
                                if (th != null) {
                                    this.a.onError(th);
                                    return;
                                } else {
                                    this.a.onComplete();
                                    return;
                                }
                            } else {
                                this.e = true;
                                nono.subscribe(this);
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            AtomicThrowable atomicThrowable2 = this.b;
                            if (atomicThrowable2 != null) {
                                atomicThrowable2.addThrowable(th2);
                                this.a.onError(this.b.terminate());
                                return;
                            }
                            this.a.onError(th2);
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
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.e = false;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            AtomicThrowable atomicThrowable = this.b;
            if (atomicThrowable != null) {
                atomicThrowable.addThrowable(th);
                this.e = false;
                a();
                return;
            }
            this.a.onError(th);
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

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        try {
            a aVar = new a(subscriber, (Iterator) ObjectHelper.requireNonNull(this.b.iterator(), "The sources Iterable returned a null Iterator"), this.c);
            subscriber.onSubscribe(aVar);
            aVar.a();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
