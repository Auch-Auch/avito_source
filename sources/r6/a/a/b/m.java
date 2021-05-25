package r6.a.a.b;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class m extends CountDownLatch implements Subscriber<Void> {
    public Throwable a;
    public Subscription b;
    public volatile boolean c;

    public m() {
        super(1);
    }

    public void a() {
        this.c = true;
        Subscription subscription = this.b;
        if (subscription != null) {
            subscription.cancel();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.a = th;
        countDown();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // org.reactivestreams.Subscriber
    public void onNext(Void r1) {
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.b, subscription)) {
            this.b = subscription;
            if (this.c) {
                subscription.cancel();
            }
        }
    }
}
