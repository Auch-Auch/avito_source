package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;
public final class p0 extends Nono {
    public static final p0 b = new p0();

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        subscriber.onSubscribe(EmptySubscription.INSTANCE);
    }
}
