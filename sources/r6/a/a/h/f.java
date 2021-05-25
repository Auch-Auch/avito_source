package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class f<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Publisher<T> b;
    public final long c;

    public static final class a<T> implements Subscriber<T>, Subscription {
        public final Subscriber<? super T> a;
        public final long b;
        public long c;
        public Subscription d;

        public a(Subscriber<? super T> subscriber, long j) {
            this.a = subscriber;
            this.b = j;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.c + 1;
            if (j == this.b) {
                this.c = 0;
                this.a.onNext(t);
                return;
            }
            this.c = j;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.d.request(BackpressureHelper.multiplyCap(j, this.b));
            }
        }
    }

    public f(Publisher<T> publisher, long j) {
        this.b = publisher;
        this.c = j;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new f(flowable, this.c);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
