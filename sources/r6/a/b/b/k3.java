package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class k3<T> extends Solo<T> {
    public final Supplier<? extends Solo<T>> b;

    public k3(Supplier<? extends Solo<T>> supplier) {
        this.b = supplier;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Solo solo = (Solo) this.b.get();
            Objects.requireNonNull(solo, "The supplier returned a null Solo");
            solo.subscribe(subscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
