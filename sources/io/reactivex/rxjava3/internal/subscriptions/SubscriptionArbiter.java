package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    public Subscription a;
    public long b;
    public final AtomicReference<Subscription> c = new AtomicReference<>();
    public final AtomicLong d = new AtomicLong();
    public final AtomicLong e = new AtomicLong();
    public final boolean f;
    public volatile boolean g;
    public boolean unbounded;

    public SubscriptionArbiter(boolean z) {
        this.f = z;
    }

    public final void c() {
        if (getAndIncrement() == 0) {
            d();
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (!this.g) {
            this.g = true;
            c();
        }
    }

    public final void d() {
        int i = 1;
        Subscription subscription = null;
        long j = 0;
        do {
            Subscription subscription2 = this.c.get();
            if (subscription2 != null) {
                subscription2 = this.c.getAndSet(null);
            }
            long j2 = this.d.get();
            if (j2 != 0) {
                j2 = this.d.getAndSet(0);
            }
            long j3 = this.e.get();
            if (j3 != 0) {
                j3 = this.e.getAndSet(0);
            }
            Subscription subscription3 = this.a;
            if (this.g) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.a = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j4 = this.b;
                if (j4 != Long.MAX_VALUE) {
                    j4 = BackpressureHelper.addCap(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        j4 -= j3;
                        if (j4 < 0) {
                            SubscriptionHelper.reportMoreProduced(j4);
                            j4 = 0;
                        }
                    }
                    this.b = j4;
                }
                if (subscription2 != null) {
                    if (subscription3 != null && this.f) {
                        subscription3.cancel();
                    }
                    this.a = subscription2;
                    if (j4 != 0) {
                        j = BackpressureHelper.addCap(j, j4);
                        subscription = subscription2;
                    }
                } else if (!(subscription3 == null || j2 == 0)) {
                    j = BackpressureHelper.addCap(j, j2);
                    subscription = subscription3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            subscription.request(j);
        }
    }

    public final boolean isCancelled() {
        return this.g;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j) {
        if (!this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.add(this.e, j);
                c();
                return;
            }
            long j2 = this.b;
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 - j;
                if (j3 < 0) {
                    SubscriptionHelper.reportMoreProduced(j3);
                    j3 = 0;
                }
                this.b = j3;
            }
            if (decrementAndGet() != 0) {
                d();
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && !this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.add(this.d, j);
                c();
                return;
            }
            long j2 = this.b;
            if (j2 != Long.MAX_VALUE) {
                long addCap = BackpressureHelper.addCap(j2, j);
                this.b = addCap;
                if (addCap == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            Subscription subscription = this.a;
            if (decrementAndGet() != 0) {
                d();
            }
            if (subscription != null) {
                subscription.request(j);
            }
        }
    }

    public final void setSubscription(Subscription subscription) {
        if (this.g) {
            subscription.cancel();
            return;
        }
        Objects.requireNonNull(subscription, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Subscription andSet = this.c.getAndSet(subscription);
            if (andSet != null && this.f) {
                andSet.cancel();
            }
            c();
            return;
        }
        Subscription subscription2 = this.a;
        if (subscription2 != null && this.f) {
            subscription2.cancel();
        }
        this.a = subscription;
        long j = this.b;
        if (decrementAndGet() != 0) {
            d();
        }
        if (j != 0) {
            subscription.request(j);
        }
    }
}
