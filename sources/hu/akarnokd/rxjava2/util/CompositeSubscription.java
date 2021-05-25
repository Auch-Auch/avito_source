package hu.akarnokd.rxjava2.util;

import io.reactivex.internal.util.OpenHashSet;
import org.reactivestreams.Subscription;
public final class CompositeSubscription implements Subscription {
    public OpenHashSet<Subscription> a;
    public volatile boolean b;

    public boolean add(Subscription subscription) {
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    OpenHashSet<Subscription> openHashSet = this.a;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.a = openHashSet;
                    }
                    openHashSet.add(subscription);
                    return true;
                }
            }
        }
        subscription.cancel();
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        OpenHashSet<Subscription> openHashSet;
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    openHashSet = this.a;
                    this.a = null;
                    this.b = true;
                } else {
                    return;
                }
            }
            if (openHashSet != null) {
                Object[] keys = openHashSet.keys();
                for (Object obj : keys) {
                    if (obj != null) {
                        ((Subscription) obj).cancel();
                    }
                }
            }
        }
    }

    public void delete(Subscription subscription) {
        OpenHashSet<Subscription> openHashSet;
        if (!this.b) {
            synchronized (this) {
                if (!this.b && (openHashSet = this.a) != null) {
                    openHashSet.remove(subscription);
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }
}
