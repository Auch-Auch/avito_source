package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class u4<T, R> extends Solo<T> {
    public final Supplier<R> b;
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

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
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
                    this.downstream.onError(th);
                    return;
                }
            }
            T t = this.value;
            if (t == null) {
                this.downstream.onComplete();
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
            this.downstream.onError(th);
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
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public u4(Supplier<R> supplier, Function<? super R, ? extends Solo<T>> function, Consumer<? super R> consumer, boolean z) {
        this.b = supplier;
        this.c = function;
        this.d = consumer;
        this.e = z;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            R r = this.b.get();
            try {
                Solo solo = (Solo) this.c.apply(r);
                Objects.requireNonNull(solo, "The sourceSupplier returned a null Nono");
                solo.subscribe(new a(subscriber, r, this.d, this.e));
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
