package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableUsing<T, D> extends Flowable<T> {
    public final Supplier<? extends D> b;
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
            if (this.d) {
                a();
                this.e.cancel();
                this.e = SubscriptionHelper.CANCELLED;
                return;
            }
            this.e.cancel();
            this.e = SubscriptionHelper.CANCELLED;
            a();
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

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
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

    public FlowableUsing(Supplier<? extends D> supplier, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.b = supplier;
        this.c = function;
        this.d = consumer;
        this.e = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Object obj = this.b.get();
            try {
                Object apply = this.c.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null Publisher");
                ((Publisher) apply).subscribe(new a(subscriber, obj, this.d, this.e));
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
