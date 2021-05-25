package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import hu.akarnokd.rxjava2.util.SneakyThrows;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
public final class t1<T> extends Perhaps<T> implements Callable<T> {
    public final Throwable b;

    public t1(Throwable th) {
        this.b = th;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        throw ((RuntimeException) SneakyThrows.justThrow(this.b));
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        EmptySubscription.error(this.b, subscriber);
    }
}
