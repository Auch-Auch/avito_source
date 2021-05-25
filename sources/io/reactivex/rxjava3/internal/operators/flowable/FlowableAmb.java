package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableAmb<T> extends Flowable<T> {
    public final Publisher<? extends T>[] b;
    public final Iterable<? extends Publisher<? extends T>> c;

    public static final class a<T> implements Subscription {
        public final Subscriber<? super T> a;
        public final b<T>[] b;
        public final AtomicInteger c = new AtomicInteger();

        public a(Subscriber<? super T> subscriber, int i) {
            this.a = subscriber;
            this.b = new b[i];
        }

        public boolean a(int i) {
            int i2 = 0;
            if (this.c.get() != 0 || !this.c.compareAndSet(0, i)) {
                return false;
            }
            b<T>[] bVarArr = this.b;
            int length = bVarArr.length;
            while (i2 < length) {
                int i3 = i2 + 1;
                if (i3 != i) {
                    b<T> bVar = bVarArr[i2];
                    Objects.requireNonNull(bVar);
                    SubscriptionHelper.cancel(bVar);
                }
                i2 = i3;
            }
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.c.get() != -1) {
                this.c.lazySet(-1);
                b<T>[] bVarArr = this.b;
                for (b<T> bVar : bVarArr) {
                    Objects.requireNonNull(bVar);
                    SubscriptionHelper.cancel(bVar);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                int i = this.c.get();
                if (i > 0) {
                    b<T> bVar = this.b[i - 1];
                    SubscriptionHelper.deferredRequest(bVar, bVar.e, j);
                } else if (i == 0) {
                    b<T>[] bVarArr = this.b;
                    for (b<T> bVar2 : bVarArr) {
                        SubscriptionHelper.deferredRequest(bVar2, bVar2.e, j);
                    }
                }
            }
        }
    }

    public static final class b<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1185974347409665484L;
        public final a<T> a;
        public final int b;
        public final Subscriber<? super T> c;
        public boolean d;
        public final AtomicLong e = new AtomicLong();

        public b(a<T> aVar, int i, Subscriber<? super T> subscriber) {
            this.a = aVar;
            this.b = i;
            this.c = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.d) {
                this.c.onComplete();
            } else if (this.a.a(this.b)) {
                this.d = true;
                this.c.onComplete();
            } else {
                ((Subscription) get()).cancel();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                this.c.onError(th);
            } else if (this.a.a(this.b)) {
                this.d = true;
                this.c.onError(th);
            } else {
                ((Subscription) get()).cancel();
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.d) {
                this.c.onNext(t);
            } else if (this.a.a(this.b)) {
                this.d = true;
                this.c.onNext(t);
            } else {
                ((Subscription) get()).cancel();
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.e, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.e, j);
        }
    }

    public FlowableAmb(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable) {
        this.b = publisherArr;
        this.c = iterable;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int i;
        Publisher<? extends T>[] publisherArr = this.b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i = 0;
                for (Publisher<? extends T> publisher : this.c) {
                    if (publisher == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (i == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[((i >> 2) + i)];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, i);
                        publisherArr = publisherArr2;
                    }
                    int i2 = i + 1;
                    publisherArr[i] = publisher;
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            i = publisherArr.length;
        }
        if (i == 0) {
            EmptySubscription.complete(subscriber);
        } else if (i == 1) {
            publisherArr[0].subscribe(subscriber);
        } else {
            a aVar = new a(subscriber, i);
            b<T>[] bVarArr = aVar.b;
            int length = bVarArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                bVarArr[i3] = new b<>(aVar, i4, aVar.a);
                i3 = i4;
            }
            aVar.c.lazySet(0);
            aVar.a.onSubscribe(aVar);
            for (int i5 = 0; i5 < length && aVar.c.get() == 0; i5++) {
                publisherArr[i5].subscribe(bVarArr[i5]);
            }
        }
    }
}
