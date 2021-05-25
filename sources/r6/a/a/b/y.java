package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import hu.akarnokd.rxjava2.util.SneakyThrows;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
public final class y extends Nono implements Callable<Void> {
    public final Throwable b;

    public y(Throwable th) {
        this.b = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        throw ((RuntimeException) SneakyThrows.justThrow(this.b));
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        EmptySubscription.error(this.b, subscriber);
    }
}
