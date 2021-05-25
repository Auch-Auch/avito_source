package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import hu.akarnokd.rxjava2.util.SneakyThrows;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
public final class z extends Nono implements Callable<Void> {
    public final Callable<? extends Throwable> b;

    public z(Callable<? extends Throwable> callable) {
        this.b = callable;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Throwable th;
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.b.call(), "The errorSupplier returned a null Throwable");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        throw ((RuntimeException) SneakyThrows.justThrow(th));
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
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
