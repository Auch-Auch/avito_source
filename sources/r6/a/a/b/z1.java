package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
public final class z1<T> extends Perhaps<T> implements Callable<T> {
    public final Action b;

    public z1(Action action) {
        this.b = action;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        this.b.run();
        return null;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(EmptySubscription.INSTANCE);
        try {
            call();
            subscriber.onComplete();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onError(th);
        }
    }
}
