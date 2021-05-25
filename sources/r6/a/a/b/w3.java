package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.reactivestreams.Subscriber;
public final class w3<T> extends Solo<T> {
    public final Future<? extends T> b;
    public final long c;
    public final TimeUnit d;

    public w3(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.b = future;
        this.c = j;
        this.d = timeUnit;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.internal.subscriptions.DeferredScalarSubscription */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Object obj;
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            long j = this.c;
            if (j <= 0) {
                obj = this.b.get();
            } else {
                obj = this.b.get(j, this.d);
            }
            if (obj != null) {
                deferredScalarSubscription.complete(obj);
            } else {
                subscriber.onError(new NoSuchElementException());
            }
        } catch (InterruptedException e) {
            subscriber.onError(e);
        } catch (ExecutionException e2) {
            subscriber.onError(e2.getCause());
        } catch (TimeoutException e3) {
            subscriber.onError(e3);
        }
    }
}
