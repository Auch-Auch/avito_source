package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class u0 extends Nono {
    public final Nono b;
    public final BooleanSupplier c;

    public static final class a extends b implements Subscriber<Void> {
        private static final long serialVersionUID = -3208438978515192633L;
        public final Subscriber<? super Void> a;
        public final Nono b;
        public final BooleanSupplier c;
        public final AtomicReference<Subscription> d = new AtomicReference<>();
        public volatile boolean e;
        public boolean f;

        public a(Subscriber<? super Void> subscriber, BooleanSupplier booleanSupplier, Nono nono) {
            this.a = subscriber;
            this.c = booleanSupplier;
            this.b = nono;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.d);
        }

        public void d() {
            try {
                if (this.c.getAsBoolean()) {
                    this.a.onComplete();
                } else if (getAndIncrement() == 0) {
                    while (!SubscriptionHelper.isCancelled(this.d.get())) {
                        if (!this.e) {
                            this.e = true;
                            this.b.subscribe(this);
                        }
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.e = false;
            d();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
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

    public u0(Nono nono, BooleanSupplier booleanSupplier) {
        this.b = nono;
        this.c = booleanSupplier;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.b));
    }
}
