package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import hu.akarnokd.rxjava2.util.SneakyThrows;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
public final class q3<T> extends Solo<T> implements Callable<T> {
    public final Callable<? extends Throwable> b;

    public q3(Callable<? extends Throwable> callable) {
        this.b = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        throw ((RuntimeException) SneakyThrows.justThrow((Throwable) ObjectHelper.requireNonNull(this.b.call(), "The errorSupplier returned a null Throwable")));
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Throwable th;
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.b.call(), "The errorSupplier returned a null Throwable");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        EmptySubscription.error(th, subscriber);
    }
}
