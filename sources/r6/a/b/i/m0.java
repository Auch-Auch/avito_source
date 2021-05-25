package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class m0<T, R> extends Flowable<R> {
    public final Publisher<? extends T>[] b;
    public final Iterable<? extends Publisher<? extends T>> c;
    public final Function<? super Object[], ? extends R> d;
    public final Scheduler e;

    public static final class a<T, R> extends AtomicReferenceArray<T> implements Subscription, Runnable {
        private static final long serialVersionUID = -8321911708267957704L;
        public final Subscriber<? super R> a;
        public final C0656a<T>[] b;
        public final AtomicInteger c = new AtomicInteger();
        public final AtomicLong d = new AtomicLong();
        public final Scheduler.Worker e;
        public final AtomicThrowable f = new AtomicThrowable();
        public final Function<? super Object[], ? extends R> g;
        public volatile boolean h;
        public long i;

        /* renamed from: r6.a.b.i.m0$a$a  reason: collision with other inner class name */
        public static final class C0656a<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
            private static final long serialVersionUID = -5384962852497888461L;
            public final a<T, ?> a;
            public final int b;
            public volatile boolean c;

            public C0656a(a<T, ?> aVar, int i) {
                this.b = i;
                this.a = aVar;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.c = true;
                this.a.c();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a<T, ?> aVar = this.a;
                if (aVar.f.tryAddThrowableOrReport(th)) {
                    lazySet(SubscriptionHelper.CANCELLED);
                    this.c = true;
                    aVar.c();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                a<T, ?> aVar = this.a;
                aVar.lazySet(this.b, t);
                aVar.c();
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super R> subscriber, int i2, Scheduler.Worker worker, Function<? super Object[], ? extends R> function) {
            super(i2);
            this.a = subscriber;
            this.b = new C0656a[i2];
            this.e = worker;
            for (int i3 = 0; i3 < i2; i3++) {
                this.b[i3] = new C0656a<>(this, i3);
            }
            this.g = function;
        }

        public void a() {
            C0656a<T>[] aVarArr = this.b;
            for (C0656a<T> aVar : aVarArr) {
                Objects.requireNonNull(aVar);
                SubscriptionHelper.cancel(aVar);
            }
        }

        public void b() {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                lazySet(i2, null);
            }
        }

        public void c() {
            if (this.c.getAndIncrement() == 0) {
                this.e.schedule(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.h = true;
            a();
            this.f.tryTerminateAndReport();
            if (this.c.getAndIncrement() == 0) {
                b();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.d, j);
                c();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int i3;
            long j = this.i;
            C0656a<T>[] aVarArr = this.b;
            int length = aVarArr.length;
            Subscriber<? super R> subscriber = this.a;
            int i4 = 1;
            do {
                long j2 = this.d.get();
                while (true) {
                    i2 = 0;
                    i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i3 == 0) {
                        break;
                    } else if (this.h) {
                        b();
                        return;
                    } else {
                        boolean z = false;
                        for (int i5 = 0; i5 < length; i5++) {
                            boolean z2 = aVarArr[i5].c;
                            Object obj = get(i5);
                            if (!z2 || obj != null) {
                                if (obj == null) {
                                    z = true;
                                }
                            } else {
                                this.h = true;
                                a();
                                b();
                                this.f.tryTerminateConsumer(subscriber);
                                this.e.dispose();
                                return;
                            }
                        }
                        if (z) {
                            break;
                        }
                        Object[] objArr = new Object[length];
                        while (i2 < length) {
                            objArr[i2] = getAndSet(i2, null);
                            i2++;
                        }
                        try {
                            Object obj2 = (Object) this.g.apply(objArr);
                            Objects.requireNonNull(obj2, "The combiner returned a null value");
                            subscriber.onNext(obj2);
                            j++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.f.tryAddThrowableOrReport(th);
                            this.h = true;
                            a();
                            b();
                            this.f.tryTerminateConsumer(subscriber);
                            this.e.dispose();
                            return;
                        }
                    }
                }
                if (i3 == 0) {
                    if (this.h) {
                        b();
                        return;
                    }
                    while (i2 < length) {
                        if (!aVarArr[i2].c || get(i2) != null) {
                            i2++;
                        } else {
                            this.h = true;
                            a();
                            b();
                            this.f.tryTerminateConsumer(subscriber);
                            this.e.dispose();
                            return;
                        }
                    }
                }
                this.i = j;
                i4 = this.c.addAndGet(-i4);
            } while (i4 != 0);
        }
    }

    public m0(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, Scheduler scheduler) {
        this.b = publisherArr;
        this.c = iterable;
        this.d = function;
        this.e = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i;
        Publisher<? extends T>[] publisherArr = this.b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            i = 0;
            for (Publisher<? extends T> publisher : this.c) {
                if (i == publisherArr.length) {
                    publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, (i >> 1) + i);
                }
                publisherArr[i] = publisher;
                i++;
            }
        } else {
            i = publisherArr.length;
        }
        if (i == 0) {
            Flowable.empty().observeOn(this.e).subscribe(subscriber);
            return;
        }
        a aVar = new a(subscriber, i, this.e.createWorker(), this.d);
        subscriber.onSubscribe(aVar);
        for (int i2 = 0; i2 < i && !aVar.h; i2++) {
            publisherArr[i2].subscribe(aVar.b[i2]);
        }
    }
}
