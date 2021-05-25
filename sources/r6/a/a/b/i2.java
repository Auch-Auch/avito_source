package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;
public final class i2<T, R> extends Perhaps<R> {
    public final Perhaps<T> b;
    public final Function<Subscriber<? super R>, Subscriber<? super T>> c;

    public i2(Perhaps<T> perhaps, Function<Subscriber<? super R>, Subscriber<? super T>> function) {
        this.b = perhaps;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            this.b.subscribe((Subscriber) ObjectHelper.requireNonNull(this.c.apply(subscriber), "The onLift returned a null Subscriber"));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
