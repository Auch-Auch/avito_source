package r6.a.a.a;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
public final class q0<T> extends Flowable<T> implements Callable<T> {
    public final Callable<? extends T> b;

    public static final class a<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -7088349936918117528L;

        public a(Subscriber<? super T> subscriber) {
            super(subscriber);
        }
    }

    public q0(Callable<? extends T> callable) {
        this.b = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) this.b.call();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: r6.a.a.a.q0$a */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        if (!aVar.isCancelled()) {
            try {
                Object call = this.b.call();
                if (aVar.isCancelled()) {
                    return;
                }
                if (call == null) {
                    subscriber.onComplete();
                } else {
                    aVar.complete(call);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!aVar.isCancelled()) {
                    subscriber.onError(th);
                }
            }
        }
    }
}
