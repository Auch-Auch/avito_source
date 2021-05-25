package io.reactivex.rxjava3.internal.subscribers;

import a2.b.a.a.a;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;
    public final Subscriber<? super T> a;
    public final AtomicThrowable b = new AtomicThrowable();
    public final AtomicLong c = new AtomicLong();
    public final AtomicReference<Subscription> d = new AtomicReference<>();
    public final AtomicBoolean e = new AtomicBoolean();
    public volatile boolean f;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (!this.f) {
            SubscriptionHelper.cancel(this.d);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f = true;
        HalfSerializer.onComplete(this.a, this, this.b);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f = true;
        HalfSerializer.onError(this.a, th, this, this.b);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        HalfSerializer.onNext(this.a, t, this, this.b);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.e.compareAndSet(false, true)) {
            this.a.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.d, this.c, subscription);
            return;
        }
        subscription.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (j <= 0) {
            cancel();
            onError(new IllegalArgumentException(a.T2("§3.9 violated: positive request amount required but it was ", j)));
            return;
        }
        SubscriptionHelper.deferredRequest(this.d, this.c, j);
    }
}
