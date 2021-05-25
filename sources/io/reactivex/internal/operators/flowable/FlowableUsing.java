package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableUsing<T, D> extends Flowable<T> {
    public final Callable<? extends D> b;
    public final Function<? super D, ? extends Publisher<? extends T>> c;
    public final Consumer<? super D> d;
    public final boolean e;

    public static final class a<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5904473792286235046L;
        public final Subscriber<? super T> a;
        public final D b;
        public final Consumer<? super D> c;
        public final boolean d;
        public Subscription e;

        public a(Subscriber<? super T> subscriber, D d2, Consumer<? super D> consumer, boolean z) {
            this.a = subscriber;
            this.b = d2;
            this.c = consumer;
            this.d = z;
        }

        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.c.accept(this.b);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            a();
            this.e.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.c.accept(this.b);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.a.onError(th);
                        return;
                    }
                }
                this.e.cancel();
                this.a.onComplete();
                return;
            }
            this.a.onComplete();
            this.e.cancel();
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                Throwable th2 = null;
                if (compareAndSet(false, true)) {
                    try {
                        this.c.accept(this.b);
                    } catch (Throwable th3) {
                        th2 = th3;
                        Exceptions.throwIfFatal(th2);
                    }
                }
                this.e.cancel();
                if (th2 != null) {
                    this.a.onError(new CompositeException(th, th2));
                } else {
                    this.a.onError(th);
                }
            } else {
                this.a.onError(th);
                this.e.cancel();
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.e.request(j);
        }
    }

    public FlowableUsing(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.b = callable;
        this.c = function;
        this.d = consumer;
        this.e = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Object call = this.b.call();
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.c.apply(call), "The sourceSupplier returned a null Publisher")).subscribe(new a(subscriber, call, this.d, this.e));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(new CompositeException(th, th), subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
