package r6.a.b.b;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public abstract class d<R> extends e<Void, R> implements Subscriber<Void> {
    private static final long serialVersionUID = -3157015053656142804L;
    public final Subscriber<? super Void> a;
    public Subscription b;

    public d(Subscriber<? super Void> subscriber) {
        this.a = subscriber;
    }

    @Override // r6.a.b.b.e, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public final void clear() {
    }

    @Override // r6.a.b.b.e, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // org.reactivestreams.Subscriber
    public void onNext(Void r1) {
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.b, subscription)) {
            this.b = subscription;
            this.a.onSubscribe(this);
        }
    }

    @Override // r6.a.b.b.e, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public /* bridge */ /* synthetic */ Object poll() throws Exception {
        return null;
    }

    @Override // r6.a.b.b.e, org.reactivestreams.Subscription
    public final void request(long j) {
    }

    @Override // r6.a.b.b.e, io.reactivex.rxjava3.internal.fuseable.QueueFuseable
    public final int requestFusion(int i) {
        return i & 2;
    }
}
