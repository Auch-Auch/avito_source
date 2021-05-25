package r6.a.a.e;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Map;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class b<T, K> extends Flowable<T> {
    public final Callable<? extends K> b;
    public final Map<? super K, ? extends Publisher<? extends T>> c;
    public final Publisher<? extends T> d;

    public b(Callable<? extends K> callable, Map<? super K, ? extends Publisher<? extends T>> map, Publisher<? extends T> publisher) {
        this.b = callable;
        this.c = map;
        this.d = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Publisher<? extends T> publisher = (Publisher) this.c.get(this.b.call());
            if (publisher == null) {
                publisher = this.d;
            }
            publisher.subscribe(subscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
