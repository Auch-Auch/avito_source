package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
public final class d0 extends Nono implements Callable<Void> {
    public final Future<?> b;
    public final long c;
    public final TimeUnit d;

    public d0(Future<?> future, long j, TimeUnit timeUnit) {
        this.b = future;
        this.c = j;
        this.d = timeUnit;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        long j = this.c;
        if (j > 0) {
            this.b.get(j, this.d);
            return null;
        }
        this.b.get();
        return null;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        subscriber.onSubscribe(EmptySubscription.INSTANCE);
        try {
            long j = this.c;
            if (j <= 0) {
                this.b.get();
            } else {
                this.b.get(j, this.d);
            }
            subscriber.onComplete();
        } catch (ExecutionException e) {
            subscriber.onError(e.getCause());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onError(th);
        }
    }
}
