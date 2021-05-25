package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;
public final class y extends Nono implements Supplier<Void> {
    public final Throwable b;

    public y(Throwable th) {
        this.b = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.functions.Supplier
    public Void get() throws Throwable {
        throw this.b;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        EmptySubscription.error(this.b, subscriber);
    }
}
