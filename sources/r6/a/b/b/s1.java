package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;
public final class s1 extends Perhaps<Object> implements Supplier<Object> {
    public static final s1 b = new s1();

    @Override // io.reactivex.rxjava3.functions.Supplier
    public Object get() throws Exception {
        return null;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super Object> subscriber) {
        EmptySubscription.complete(subscriber);
    }
}
