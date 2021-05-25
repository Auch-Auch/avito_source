package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class t0 extends Nono {
    public final Nono b;
    public final long c;

    public static abstract class a extends b implements Subscriber<Void> {
        private static final long serialVersionUID = -3208438978515192633L;
        public final Subscriber<? super Void> a;
        public final Nono b;
        public long c;
        public final AtomicReference<Subscription> d = new AtomicReference<>();
        public volatile boolean e;
        public boolean f;

        public a(Subscriber<? super Void> subscriber, long j, Nono nono) {
            this.a = subscriber;
            this.c = j;
            this.b = nono;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.d);
        }

        public final void d(Throwable th) {
            long j = this.c;
            if (j != 1) {
                if (j != Long.MAX_VALUE) {
                    this.c = j - 1;
                }
                if (getAndIncrement() == 0) {
                    while (SubscriptionHelper.CANCELLED != this.d.get()) {
                        if (!this.e) {
                            this.e = true;
                            this.b.subscribe(this);
                        }
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            } else if (th != null) {
                this.a.onError(th);
            } else {
                this.a.onComplete();
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Void r1) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.replace(this.d, subscription);
            if (!this.f) {
                this.f = true;
                this.a.onSubscribe(this);
            }
        }
    }

    public static final class b extends a {
        private static final long serialVersionUID = 3432411068139897716L;

        public b(Subscriber<? super Void> subscriber, long j, Nono nono) {
            super(subscriber, j, nono);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.e = false;
            d(null);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }
    }

    public t0(Nono nono, long j) {
        this.b = nono;
        this.c = j;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new b(subscriber, this.c, this.b));
    }
}
