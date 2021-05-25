package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class q extends Nono {
    public final Nono[] b;
    public final boolean c;

    public static final class a extends e<Void, Subscription> implements Subscriber<Void> {
        private static final long serialVersionUID = -4926738846855955051L;
        public final Subscriber<? super Void> a;
        public final AtomicThrowable b;
        public final Nono[] c;
        public final AtomicInteger d;
        public int e;
        public volatile boolean f;

        public a(Subscriber<? super Void> subscriber, Nono[] nonoArr, boolean z) {
            this.a = subscriber;
            this.c = nonoArr;
            this.b = z ? new AtomicThrowable() : null;
            this.d = new AtomicInteger();
        }

        public void a() {
            if (this.d.getAndIncrement() == 0) {
                while (SubscriptionHelper.CANCELLED != get()) {
                    if (!this.f) {
                        int i = this.e;
                        Nono[] nonoArr = this.c;
                        if (i == nonoArr.length) {
                            AtomicThrowable atomicThrowable = this.b;
                            if (atomicThrowable != null) {
                                atomicThrowable.tryTerminateConsumer(this.a);
                                return;
                            } else {
                                this.a.onComplete();
                                return;
                            }
                        } else {
                            Nono nono = nonoArr[i];
                            this.e = i + 1;
                            if (nono == null) {
                                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                                AtomicThrowable atomicThrowable2 = this.b;
                                if (atomicThrowable2 != null) {
                                    atomicThrowable2.tryAddThrowableOrReport(nullPointerException);
                                    this.b.tryTerminateConsumer(this.a);
                                    return;
                                }
                                this.a.onError(nullPointerException);
                                return;
                            }
                            this.f = true;
                            nono.subscribe(this);
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
            this.f = false;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            AtomicThrowable atomicThrowable = this.b;
            if (atomicThrowable == null) {
                this.a.onError(th);
            } else if (atomicThrowable.tryAddThrowableOrReport(th)) {
                this.f = false;
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

    public q(Nono[] nonoArr, boolean z) {
        this.b = nonoArr;
        this.c = z;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        a aVar = new a(subscriber, this.b, this.c);
        subscriber.onSubscribe(aVar);
        aVar.a();
    }
}
