package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import hu.akarnokd.rxjava2.util.SneakyThrows;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
public final class p3<T> extends Solo<T> implements Callable<T> {
    public final Throwable b;

    public p3(Throwable th) {
        this.b = th;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        throw ((RuntimeException) SneakyThrows.justThrow(this.b));
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        EmptySubscription.error(this.b, subscriber);
    }
}
