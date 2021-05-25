package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;
public final class t1<T> extends Perhaps<T> implements Supplier<T> {
    public final Throwable b;

    public t1(Throwable th) {
        this.b = th;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        throw this.b;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        EmptySubscription.error(this.b, subscriber);
    }
}
