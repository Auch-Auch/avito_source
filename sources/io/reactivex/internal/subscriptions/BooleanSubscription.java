package io.reactivex.internal.subscriptions;

import a2.b.a.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;
public final class BooleanSubscription extends AtomicBoolean implements Subscription {
    private static final long serialVersionUID = -8127758972444290902L;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean, java.lang.Object
    public String toString() {
        StringBuilder L = a.L("BooleanSubscription(cancelled=");
        L.append(get());
        L.append(")");
        return L.toString();
    }
}
