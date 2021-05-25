package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class g1<R> extends Nono {
    public final Callable<R> b;
    public final Function<? super R, ? extends Nono> c;
    public final Consumer<? super R> d;
    public final boolean e;

    public static final class a<R> extends b implements Subscriber<Void> {
        private static final long serialVersionUID = 5500674592438910341L;
        public final Subscriber<? super Void> a;
        public final Consumer<? super R> b;
        public final boolean c;
        public Subscription d;
        public R e;

        public a(Subscriber<? super Void> subscriber, R r, Consumer<? super R> consumer, boolean z) {
            this.a = subscriber;
            this.e = r;
            this.b = consumer;
            this.c = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(0, 1)) {
                d();
            }
        }

        public void d() {
            try {
                this.b.accept(this.e);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.c && compareAndSet(0, 1)) {
                try {
                    this.b.accept(this.e);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.a.onError(th);
                    return;
                }
            }
            this.a.onComplete();
            if (!this.c && compareAndSet(0, 1)) {
                d();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.c && compareAndSet(0, 1)) {
                try {
                    this.b.accept(this.e);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.a.onError(th);
            if (!this.c && compareAndSet(0, 1)) {
                d();
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Void r1) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }
    }

    public g1(Callable<R> callable, Function<? super R, ? extends Nono> function, Consumer<? super R> consumer, boolean z) {
        this.b = callable;
        this.c = function;
        this.d = consumer;
        this.e = z;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        try {
            R call = this.b.call();
            try {
                ((Nono) ObjectHelper.requireNonNull(this.c.apply(call), "The sourceSupplier returned a null Nono")).subscribe(new a(subscriber, call, this.d, this.e));
                return;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
                return;
            }
            EmptySubscription.error(th, subscriber);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
