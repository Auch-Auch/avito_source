package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import io.reactivex.rxjava3.internal.subscriptions.ScalarSubscription;
import org.reactivestreams.Subscriber;
public final class h2<T> extends Perhaps<T> implements ScalarSupplier<T> {
    public final T b;

    public h2(T t) {
        this.b = t;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.ScalarSupplier, io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return this.b;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new ScalarSubscription(subscriber, this.b));
    }
}
