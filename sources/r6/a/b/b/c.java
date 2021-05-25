package r6.a.b.b;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public abstract class c extends a implements Subscriber<Object> {
    public final Subscriber<? super Void> a;
    public Subscription b;

    public c(Subscriber<? super Void> subscriber) {
        this.a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.b.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.b, subscription)) {
            this.b = subscription;
            this.a.onSubscribe(this);
        }
    }
}
