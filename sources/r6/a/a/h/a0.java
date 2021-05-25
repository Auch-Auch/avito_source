package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class a0<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Flowable<T> b;
    public final Publisher<? extends T>[] c;

    public static final class a<T> extends AtomicInteger implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -174718617614474267L;
        public final Subscriber<? super T> a;
        public final AtomicLong b = new AtomicLong();
        public final AtomicReference<Subscription> c = new AtomicReference<>();
        public final Publisher<? extends T>[] d;
        public int e;
        public boolean f;
        public volatile boolean g;

        public a(Subscriber<? super T> subscriber, Publisher<? extends T>[] publisherArr) {
            this.a = subscriber;
            this.d = publisherArr;
        }

        public void a(Publisher<? extends T> publisher) {
            if (getAndIncrement() == 0) {
                while (!SubscriptionHelper.isCancelled(this.c.get())) {
                    if (!this.g) {
                        if (publisher == null) {
                            int i = this.e;
                            Publisher<? extends T>[] publisherArr = this.d;
                            if (i == publisherArr.length) {
                                this.a.onComplete();
                                return;
                            }
                            Publisher<? extends T> publisher2 = publisherArr[i];
                            if (publisher2 == null) {
                                this.a.onError(new NullPointerException(a2.b.a.a.a.Q2("The ", i, "th alternative Publisher is null")));
                                return;
                            } else {
                                this.e = i + 1;
                                publisher = publisher2;
                            }
                        }
                        this.g = true;
                        publisher.subscribe(this);
                        publisher = null;
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f) {
                this.a.onComplete();
                return;
            }
            this.g = false;
            a(null);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.f) {
                this.f = true;
            }
            this.a.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.replace(this.c, subscription)) {
                long j = this.b.get();
                if (j != 0) {
                    subscription.request(j);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.b, j);
                Subscription subscription = this.c.get();
                if (subscription != null) {
                    subscription.request(j);
                }
            }
        }
    }

    public a0(Flowable<T> flowable, Publisher<? extends T>[] publisherArr) {
        this.b = flowable;
        this.c = publisherArr;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new a0(flowable, this.c);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.c);
        subscriber.onSubscribe(aVar);
        aVar.a(this.b);
    }
}
