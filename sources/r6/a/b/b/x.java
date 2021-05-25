package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class x extends Nono {
    public final Nono b;
    public final Consumer<? super Throwable> c;
    public final Action d;
    public final Action e;
    public final Consumer<? super Subscription> f;
    public final LongConsumer g;
    public final Action h;
    public boolean i;

    public final class a extends c {
        public a(Subscriber<? super Void> subscriber) {
            super(subscriber);
        }

        @Override // r6.a.b.b.c, org.reactivestreams.Subscription
        public void cancel() {
            try {
                x.this.h.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.b.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            x xVar = x.this;
            if (!xVar.i) {
                xVar.i = true;
                try {
                    xVar.d.run();
                    this.a.onComplete();
                    try {
                        x.this.e.run();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        RxJavaPlugins.onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.a.onError(th2);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            x xVar = x.this;
            if (xVar.i) {
                RxJavaPlugins.onError(th);
                return;
            }
            xVar.i = true;
            try {
                xVar.c.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.a.onError(th);
            try {
                x.this.e.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
        }

        @Override // r6.a.b.b.c, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                try {
                    x.this.f.accept(subscription);
                    this.a.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    subscription.cancel();
                    this.a.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // r6.a.b.b.a, org.reactivestreams.Subscription
        public void request(long j) {
            try {
                x.this.g.accept(j);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.b.request(j);
        }
    }

    public x(Nono nono, Consumer<? super Throwable> consumer, Action action, Action action2, Consumer<? super Subscription> consumer2, LongConsumer longConsumer, Action action3) {
        this.b = nono;
        this.c = consumer;
        this.d = action;
        this.e = action2;
        this.f = consumer2;
        this.g = longConsumer;
        this.h = action3;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber));
    }
}
