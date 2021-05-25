package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    public final InnerQueuedSubscriberSupport<T> a;
    public final int b;
    public final int c;
    public volatile SimpleQueue<T> d;
    public volatile boolean e;
    public long f;
    public int g;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int i) {
        this.a = innerQueuedSubscriberSupport;
        this.b = i;
        this.c = i - (i >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.e;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.a.innerComplete(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.a.innerError(this, th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.g == 0) {
            this.a.innerNext(this, t);
        } else {
            this.a.drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.g = requestFusion;
                    this.d = queueSubscription;
                    this.e = true;
                    this.a.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.g = requestFusion;
                    this.d = queueSubscription;
                    QueueDrainHelper.request(subscription, this.b);
                    return;
                }
            }
            this.d = QueueDrainHelper.createQueue(this.b);
            QueueDrainHelper.request(subscription, this.b);
        }
    }

    public SimpleQueue<T> queue() {
        return this.d;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (this.g != 1) {
            long j2 = this.f + j;
            if (j2 >= ((long) this.c)) {
                this.f = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.f = j2;
        }
    }

    public void setDone() {
        this.e = true;
    }
}
