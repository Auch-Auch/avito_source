package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class b4<T, R> extends Solo<R> {
    public final Solo<T> b;
    public final Function<Subscriber<? super R>, Subscriber<? super T>> c;

    public b4(Solo<T> solo, Function<Subscriber<? super R>, Subscriber<? super T>> function) {
        this.b = solo;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
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
