package r6.a.a.j;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.FlowableProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class b<T> extends FlowableProcessor<T> implements Subscription {
    public static final a[] e = new a[0];
    public static final a[] f = new a[0];
    public final FlowableProcessor<T> b;
    public final AtomicReference<Subscription> c = new AtomicReference<>();
    public final AtomicReference<a<T>[]> d = new AtomicReference<>(e);

    public static final class a<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4317488092687530631L;
        public final Subscriber<? super T> a;
        public final b<T> b;
        public Subscription c;

        public a(Subscriber<? super T> subscriber, b<T> bVar) {
            this.a = subscriber;
            this.b = bVar;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            lazySet(true);
            this.c.cancel();
            b<T> bVar = this.b;
            do {
                aVarArr = bVar.d.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (this == aVarArr[i]) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            aVarArr2 = b.f;
                        } else {
                            a<T>[] aVarArr3 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                            System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!bVar.d.compareAndSet(aVarArr, aVarArr2));
            if (aVarArr2 == b.f) {
                SubscriptionHelper.cancel(bVar.c);
            }
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
            this.a.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.c = subscription;
            this.a.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.c.request(j);
        }
    }

    public b(FlowableProcessor<T> flowableProcessor) {
        this.b = flowableProcessor;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.c);
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        return this.b.getThrowable();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.b.hasComplete();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.b.hasSubscribers();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.b.hasThrowable();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.c.lazySet(SubscriptionHelper.CANCELLED);
        this.b.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.c.lazySet(SubscriptionHelper.CANCELLED);
        this.b.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.b.onNext(t);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.c, subscription)) {
            this.b.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.c.get().request(j);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        a<T> aVar = new a<>(subscriber, this);
        while (true) {
            a<T>[] aVarArr = this.d.get();
            z = false;
            if (aVarArr != f) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.d.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            EmptySubscription.error(new IllegalStateException("RefCountProcessor terminated"), subscriber);
        } else {
            this.b.subscribe((FlowableSubscriber) aVar);
        }
    }
}
