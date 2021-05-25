package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableConcatArray<T> extends Flowable<T> {
    public final Publisher<? extends T>[] b;
    public final boolean c;

    public static final class a<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        public final Subscriber<? super T> h;
        public final Publisher<? extends T>[] i;
        public final boolean j;
        public final AtomicInteger k = new AtomicInteger();
        public int l;
        public List<Throwable> m;
        public long n;

        public a(Publisher<? extends T>[] publisherArr, boolean z, Subscriber<? super T> subscriber) {
            super(false);
            this.h = subscriber;
            this.i = publisherArr;
            this.j = z;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.k.getAndIncrement() == 0) {
                Publisher<? extends T>[] publisherArr = this.i;
                int length = publisherArr.length;
                int i2 = this.l;
                while (i2 != length) {
                    Publisher<? extends T> publisher = publisherArr[i2];
                    if (publisher == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (this.j) {
                            List list = this.m;
                            if (list == null) {
                                list = new ArrayList((length - i2) + 1);
                                this.m = list;
                            }
                            list.add(nullPointerException);
                            i2++;
                        } else {
                            this.h.onError(nullPointerException);
                            return;
                        }
                    } else {
                        long j2 = this.n;
                        if (j2 != 0) {
                            this.n = 0;
                            produced(j2);
                        }
                        publisher.subscribe(this);
                        i2++;
                        this.l = i2;
                        if (this.k.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.m;
                if (list2 == null) {
                    this.h.onComplete();
                } else if (list2.size() == 1) {
                    this.h.onError(list2.get(0));
                } else {
                    this.h.onError(new CompositeException(list2));
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.j) {
                List list = this.m;
                if (list == null) {
                    list = new ArrayList((this.i.length - this.l) + 1);
                    this.m = list;
                }
                list.add(th);
                onComplete();
                return;
            }
            this.h.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.n++;
            this.h.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z) {
        this.b = publisherArr;
        this.c = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(this.b, this.c, subscriber);
        subscriber.onSubscribe(aVar);
        aVar.onComplete();
    }
}
