package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;
public final class k0 extends Nono {
    public final Nono b;
    public final Function<Subscriber<? super Void>, Subscriber<? super Void>> c;

    public k0(Nono nono, Function<Subscriber<? super Void>, Subscriber<? super Void>> function) {
        this.b = nono;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        try {
            this.b.subscribe((Subscriber) ObjectHelper.requireNonNull(this.c.apply(subscriber), "The lifter returned a null Subscriber"));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
