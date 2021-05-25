package r6.a.b.f;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Map;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class d<T, K> extends Flowable<T> {
    public final Supplier<? extends K> b;
    public final Map<? super K, ? extends Publisher<? extends T>> c;
    public final Publisher<? extends T> d;

    public d(Supplier<? extends K> supplier, Map<? super K, ? extends Publisher<? extends T>> map, Publisher<? extends T> publisher) {
        this.b = supplier;
        this.c = map;
        this.d = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Publisher<? extends T> publisher = (Publisher) this.c.get(this.b.get());
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
