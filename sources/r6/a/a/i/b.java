package r6.a.a.i;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.parallel.ParallelTransformer;
import java.lang.Number;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class b<T extends Number> extends ParallelFlowable<Double> implements ParallelTransformer<T, Double> {
    public final ParallelFlowable<? extends Number> a;

    public static final class a extends DeferredScalarSubscription<Double> implements FlowableSubscriber<Number> {
        private static final long serialVersionUID = -1502296701568087162L;
        public double a;
        public boolean b;
        public Subscription c;

        public a(Subscriber<? super Double> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.b) {
                complete(Double.valueOf(this.a));
            } else {
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Number number = (Number) obj;
            if (!this.b) {
                this.b = true;
            }
            this.a = number.doubleValue() + this.a;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public b(ParallelFlowable<? extends Number> parallelFlowable) {
        this.a = parallelFlowable;
    }

    @Override // io.reactivex.parallel.ParallelTransformer
    public ParallelFlowable<Double> apply(ParallelFlowable<T> parallelFlowable) {
        return new b(parallelFlowable);
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super Double>[] subscriberArr) {
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
