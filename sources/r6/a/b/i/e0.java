package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class e0<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Flowable<T> b;
    public final Iterable<? extends Publisher<? extends T>> c;

    public static final class a<T> extends AtomicInteger implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -174718617614474267L;
        public final Subscriber<? super T> a;
        public final AtomicLong b = new AtomicLong();
        public final AtomicReference<Subscription> c = new AtomicReference<>();
        public final Iterator<? extends Publisher<? extends T>> d;
        public boolean e;
        public volatile boolean f;

        public a(Subscriber<? super T> subscriber, Iterator<? extends Publisher<? extends T>> it) {
            this.a = subscriber;
            this.d = it;
        }

        public void a(Publisher<? extends T> publisher) {
            if (getAndIncrement() == 0) {
                while (SubscriptionHelper.CANCELLED != this.c.get()) {
                    if (!this.f) {
                        if (publisher == null) {
                            try {
                                boolean hasNext = this.d.hasNext();
                                if (hasNext) {
                                    publisher = (Publisher) this.d.next();
                                }
                                if (!hasNext) {
                                    this.a.onComplete();
                                    return;
                                } else if (publisher == null) {
                                    this.a.onError(new NullPointerException("The alternative Publisher is null"));
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.a.onError(th);
                                return;
                            }
                        }
                        this.f = true;
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
            if (this.e) {
                this.a.onComplete();
                return;
            }
            this.f = false;
            a(null);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.e) {
                this.e = true;
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

    public e0(Flowable<T> flowable, Iterable<? extends Publisher<? extends T>> iterable) {
        this.b = flowable;
        this.c = iterable;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new e0(flowable, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            a aVar = new a(subscriber, this.c.iterator());
            subscriber.onSubscribe(aVar);
            aVar.a(this.b);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
