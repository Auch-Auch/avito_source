package r6.a.b.j;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.parallel.ParallelTransformer;
import java.lang.Number;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class c<T extends Number> extends ParallelFlowable<Integer> implements ParallelTransformer<T, Integer> {
    public final ParallelFlowable<? extends Number> a;

    public static final class a extends DeferredScalarSubscription<Integer> implements FlowableSubscriber<Number> {
        private static final long serialVersionUID = -1502296701568087162L;
        public int a;
        public boolean b;
        public Subscription c;

        public a(Subscriber<? super Integer> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.b) {
                complete(Integer.valueOf(this.a));
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Number number = (Number) obj;
            if (!this.b) {
                this.b = true;
            }
            this.a = number.intValue() + this.a;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public c(ParallelFlowable<? extends Number> parallelFlowable) {
        this.a = parallelFlowable;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelTransformer
    public ParallelFlowable<Integer> apply(ParallelFlowable<T> parallelFlowable) {
        return new c(parallelFlowable);
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super Integer>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super Object>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = new a(subscriberArr[i]);
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
