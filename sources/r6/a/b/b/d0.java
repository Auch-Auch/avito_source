package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
public final class d0 extends Nono implements Supplier<Void> {
    public final Future<?> b;
    public final long c;
    public final TimeUnit d;

    public d0(Future<?> future, long j, TimeUnit timeUnit) {
        this.b = future;
        this.c = j;
        this.d = timeUnit;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.functions.Supplier
    public Void get() throws Throwable {
        long j = this.c;
        if (j > 0) {
            this.b.get(j, this.d);
            return null;
        }
        this.b.get();
        return null;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
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
