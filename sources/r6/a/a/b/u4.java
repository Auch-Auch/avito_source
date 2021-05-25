package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class u4<T, R> extends Solo<T> {
    public final Callable<R> b;
    public final Function<? super R, ? extends Solo<T>> c;
    public final Consumer<? super R> d;
    public final boolean e;

    public static final class a<T, R> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = 5500674592438910341L;
        public final Consumer<? super R> a;
        public final boolean b;
        public final AtomicBoolean c = new AtomicBoolean();
        public Subscription d;
        public R e;

        public a(Subscriber<? super T> subscriber, R r, Consumer<? super R> consumer, boolean z) {
            super(subscriber);
            this.e = r;
            this.a = consumer;
            this.b = z;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            if (this.c.compareAndSet(false, true)) {
                d();
            }
        }

        public void d() {
            try {
                this.a.accept(this.e);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.b && this.c.compareAndSet(false, true)) {
                try {
                    this.a.accept(this.e);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.actual.onError(th);
                    return;
                }
            }
            T t = this.value;
            if (t == null) {
                this.actual.onComplete();
            } else {
                complete(t);
            }
            if (!this.b && this.c.compareAndSet(false, true)) {
                d();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.b && this.c.compareAndSet(false, true)) {
                try {
                    this.a.accept(this.e);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.actual.onError(th);
            if (!this.b && this.c.compareAndSet(false, true)) {
                d();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.value = t;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public u4(Callable<R> callable, Function<? super R, ? extends Solo<T>> function, Consumer<? super R> consumer, boolean z) {
        this.b = callable;
        this.c = function;
        this.d = consumer;
        this.e = z;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            R call = this.b.call();
            try {
                ((Solo) ObjectHelper.requireNonNull(this.c.apply(call), "The sourceSupplier returned a null Nono")).subscribe(new a(subscriber, call, this.d, this.e));
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
