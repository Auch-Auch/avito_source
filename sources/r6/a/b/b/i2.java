package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class i2<T, R> extends Perhaps<R> {
    public final Perhaps<T> b;
    public final Function<Subscriber<? super R>, Subscriber<? super T>> c;

    public i2(Perhaps<T> perhaps, Function<Subscriber<? super R>, Subscriber<? super T>> function) {
        this.b = perhaps;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            Subscriber<? super T> apply = this.c.apply(subscriber);
            Objects.requireNonNull(apply, "The onLift returned a null Subscriber");
            this.b.subscribe(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
