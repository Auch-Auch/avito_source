package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class n1<T> extends Perhaps<T> {
    public final Supplier<? extends Perhaps<? extends T>> b;

    public n1(Supplier<? extends Perhaps<? extends T>> supplier) {
        this.b = supplier;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Perhaps perhaps = (Perhaps) this.b.get();
            Objects.requireNonNull(perhaps, "The supplier returned a null Solo");
            perhaps.subscribe(subscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
