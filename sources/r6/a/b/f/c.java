package r6.a.b.f;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class c<T> extends Flowable<T> {
    public final BooleanSupplier b;
    public final Publisher<? extends T> c;
    public final Publisher<? extends T> d;

    public c(BooleanSupplier booleanSupplier, Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        this.b = booleanSupplier;
        this.c = publisher;
        this.d = publisher2;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            if (this.b.getAsBoolean()) {
                this.c.subscribe(subscriber);
            } else {
                this.d.subscribe(subscriber);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
