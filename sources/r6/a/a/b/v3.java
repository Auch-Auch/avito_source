package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
public final class v3<T> extends Solo<T> implements Callable<T> {
    public final Callable<T> b;

    public v3(Callable<T> callable) {
        this.b = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) ObjectHelper.requireNonNull(this.b.call(), "The callable returned a null value");
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            T call = call();
            if (call != null) {
                deferredScalarSubscription.complete(call);
            } else {
                subscriber.onError(new NoSuchElementException());
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onError(th);
        }
    }
}
