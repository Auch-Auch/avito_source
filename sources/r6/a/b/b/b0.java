package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;
public final class b0 extends Nono implements Supplier<Void> {
    public final Action b;

    public b0(Action action) {
        this.b = action;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.functions.Supplier
    public Void get() throws Throwable {
        this.b.run();
        return null;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        subscriber.onSubscribe(EmptySubscription.INSTANCE);
        try {
            this.b.run();
            subscriber.onComplete();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onError(th);
        }
    }
}
