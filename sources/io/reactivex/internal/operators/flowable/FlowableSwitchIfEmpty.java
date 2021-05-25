package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableSwitchIfEmpty<T> extends s6.a.c.b.a.a<T, T> {
    public final Publisher<? extends T> b;

    public static final class a<T> implements FlowableSubscriber<T> {
        public final Subscriber<? super T> a;
        public final Publisher<? extends T> b;
        public final SubscriptionArbiter c = new SubscriptionArbiter(false);
        public boolean d = true;

        public a(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.a = subscriber;
            this.b = publisher;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.d) {
                this.d = false;
                this.b.subscribe(this);
                return;
            }
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.d) {
                this.d = false;
            }
            this.a.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.c.setSubscription(subscription);
        }
    }

    public FlowableSwitchIfEmpty(Flowable<T> flowable, Publisher<? extends T> publisher) {
        super(flowable);
        this.b = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.b);
        subscriber.onSubscribe(aVar.c);
        this.source.subscribe((FlowableSubscriber) aVar);
    }
}
