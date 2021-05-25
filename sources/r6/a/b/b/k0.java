package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class k0 extends Nono {
    public final Nono b;
    public final Function<Subscriber<? super Void>, Subscriber<? super Void>> c;

    public k0(Nono nono, Function<Subscriber<? super Void>, Subscriber<? super Void>> function) {
        this.b = nono;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        try {
            Subscriber<? super Void> apply = this.c.apply(subscriber);
            Objects.requireNonNull(apply, "The lifter returned a null Subscriber");
            this.b.subscribe(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
