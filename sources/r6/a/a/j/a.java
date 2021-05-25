package r6.a.a.j;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.FlowableProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class a<T> extends FlowableProcessor<T> {
    public final Processor<T, T> b;
    public volatile boolean c;
    public Throwable d;

    /* renamed from: r6.a.a.j.a$a  reason: collision with other inner class name */
    public final class C0598a extends AtomicBoolean implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -6891177704330298695L;
        public final Subscriber<? super T> a;
        public Subscription b;

        public C0598a(a aVar, Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.b.cancel();
                this.b = SubscriptionHelper.CANCELLED;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.b = SubscriptionHelper.CANCELLED;
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.b = SubscriptionHelper.CANCELLED;
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.b = subscription;
            this.a.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.b.request(j);
        }
    }

    public a(Processor<T, T> processor) {
        this.b = processor;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.c) {
            return this.d;
        }
        return null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.c && this.d == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        throw new UnsupportedOperationException();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.c && this.d != null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.c = true;
        this.b.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.d = th;
        this.c = true;
        this.b.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.b.onNext(t);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        this.b.onSubscribe(subscription);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new C0598a(this, subscriber));
    }
}
