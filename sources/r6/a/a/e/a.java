package r6.a.a.e;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class a<T> extends Flowable<T> {
    public final BooleanSupplier b;
    public final Publisher<? extends T> c;
    public final Publisher<? extends T> d;

    public a(BooleanSupplier booleanSupplier, Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        this.b = booleanSupplier;
        this.c = publisher;
        this.d = publisher2;
    }

    @Override // io.reactivex.Flowable
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
