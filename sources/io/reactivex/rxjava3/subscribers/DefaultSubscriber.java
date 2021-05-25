package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;
public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    public Subscription a;

    public final void cancel() {
        Subscription subscription = this.a;
        this.a = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.validate(this.a, subscription, getClass())) {
            this.a = subscription;
            onStart();
        }
    }

    public final void request(long j) {
        Subscription subscription = this.a;
        if (subscription != null) {
            subscription.request(j);
        }
    }
}
