package r6.a.a.c;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
public final class d<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = 8924480688481408726L;
    public final AtomicReference<CompositeDisposable> a;
    public final Consumer<? super T> b;
    public final Consumer<? super Throwable> c;
    public final Action d;

    public d(CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        this.b = consumer;
        this.c = consumer2;
        this.d = action;
        this.a = new AtomicReference<>(compositeDisposable);
    }

    public void a() {
        CompositeDisposable andSet = this.a.getAndSet(null);
        if (andSet != null) {
            andSet.delete(this);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this);
        a();
    }

    @Override // io.reactivex.observers.LambdaConsumerIntrospection
    public boolean hasCustomOnError() {
        return this.c != null;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return SubscriptionHelper.isCancelled((Subscription) get());
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.d.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
        a();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            Consumer<? super Throwable> consumer = this.c;
            if (consumer != null) {
                try {
                    consumer.accept(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, th2));
                }
            } else {
                RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
            }
        } else {
            RxJavaPlugins.onError(th);
        }
        a();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (get() != SubscriptionHelper.CANCELLED) {
            try {
                this.b.accept(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                ((Subscription) get()).cancel();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            subscription.request(Long.MAX_VALUE);
        }
    }
}
