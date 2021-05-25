package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class i<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Publisher<T> b;
    public final long c;
    public final TimeUnit d;
    public final Scheduler e;

    public static final class a<T> implements ConditionalSubscriber<T>, Subscription {
        public final Subscriber<? super T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public Subscription e;
        public long f;

        public a(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e.cancel();
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
            if (!tryOnNext(t)) {
                this.e.request(1);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.f = this.d.now(this.c);
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.e.request(j);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            long now = this.d.now(this.c);
            long j = this.f;
            this.f = this.b + now;
            if (now < j) {
                return false;
            }
            this.a.onNext(t);
            return true;
        }
    }

    public i(Publisher<T> publisher, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.b = publisher;
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new i(flowable, this.c, this.d, this.e);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d, this.e));
    }
}
