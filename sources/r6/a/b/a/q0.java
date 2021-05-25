package r6.a.b.a;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
public final class q0<T> extends Flowable<T> implements Supplier<T> {
    public final Supplier<? extends T> b;

    public static final class a<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -7088349936918117528L;

        public a(Subscriber<? super T> subscriber) {
            super(subscriber);
        }
    }

    public q0(Supplier<? extends T> supplier) {
        this.b = supplier;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        return (T) this.b.get();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: r6.a.b.a.q0$a */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        if (!aVar.isCancelled()) {
            try {
                Object obj = this.b.get();
                if (aVar.isCancelled()) {
                    return;
                }
                if (obj == null) {
                    subscriber.onComplete();
                } else {
                    aVar.complete(obj);
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
