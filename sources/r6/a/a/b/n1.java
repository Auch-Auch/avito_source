package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
public final class n1<T> extends Perhaps<T> {
    public final Callable<? extends Perhaps<? extends T>> b;

    public n1(Callable<? extends Perhaps<? extends T>> callable) {
        this.b = callable;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            ((Perhaps) ObjectHelper.requireNonNull(this.b.call(), "The supplier returned a null Solo")).subscribe(subscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
