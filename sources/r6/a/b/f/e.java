package r6.a.b.f;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class e<T> extends Flowable<T> {
    public final Publisher<? extends T> b;
    public final BooleanSupplier c;
    public final BooleanSupplier d;

    public static final class a<T> extends SubscriptionArbiter implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -5255585317630843019L;
        public final Subscriber<? super T> h;
        public final AtomicInteger i = new AtomicInteger();
        public final BooleanSupplier j;
        public final Publisher<? extends T> k;
        public volatile boolean l;
        public long m;

        public a(Subscriber<? super T> subscriber, BooleanSupplier booleanSupplier, Publisher<? extends T> publisher) {
            super(false);
            this.h = subscriber;
            this.j = booleanSupplier;
            this.k = publisher;
        }

        public void e() {
            if (this.i.getAndIncrement() == 0) {
                while (!isCancelled()) {
                    if (!this.l) {
                        this.l = true;
                        this.k.subscribe(this);
                    }
                    if (this.i.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            try {
                if (this.j.getAsBoolean()) {
                    long j2 = this.m;
                    if (j2 != 0) {
                        produced(j2);
                    }
                    this.l = false;
                    e();
                    return;
                }
                this.h.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.h.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.h.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.m++;
            this.h.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            super.setSubscription(subscription);
        }
    }

    public e(Publisher<? extends T> publisher, BooleanSupplier booleanSupplier, BooleanSupplier booleanSupplier2) {
        this.b = publisher;
        this.c = booleanSupplier;
        this.d = booleanSupplier2;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            if (this.c.getAsBoolean()) {
                a aVar = new a(subscriber, this.d, this.b);
                subscriber.onSubscribe(aVar);
                aVar.e();
                return;
            }
            EmptySubscription.complete(subscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
