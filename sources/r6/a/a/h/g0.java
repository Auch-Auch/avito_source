package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class g0<T, R> extends Flowable<R> {
    public final Publisher<? extends T>[] b;
    public final Iterable<? extends Publisher<? extends T>> c;
    public final Function<? super Object[], ? extends R> d;
    public final Scheduler e;

    public static final class a<T, R> extends AtomicReferenceArray<T> implements Subscription, Runnable {
        private static final long serialVersionUID = -8321911708267957704L;
        public final Subscriber<? super R> a;
        public final C0590a<T>[] b;
        public final AtomicInteger c = new AtomicInteger();
        public final AtomicLong d = new AtomicLong();
        public final Scheduler.Worker e;
        public final AtomicThrowable f = new AtomicThrowable();
        public final Function<? super Object[], ? extends R> g;
        public volatile boolean h;
        public long i;

        /* renamed from: r6.a.a.h.g0$a$a  reason: collision with other inner class name */
        public static final class C0590a<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
            private static final long serialVersionUID = -5384962852497888461L;
            public final a<T, ?> a;
            public final int b;
            public volatile boolean c;

            public C0590a(a<T, ?> aVar, int i) {
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
                if (aVar.f.addThrowable(th)) {
                    lazySet(SubscriptionHelper.CANCELLED);
                    this.c = true;
                    aVar.c();
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                a<T, ?> aVar = this.a;
                aVar.lazySet(this.b, t);
                aVar.c();
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super R> subscriber, int i2, Scheduler.Worker worker, Function<? super Object[], ? extends R> function) {
            super(i2);
            this.a = subscriber;
            this.b = new C0590a[i2];
            this.e = worker;
            for (int i3 = 0; i3 < i2; i3++) {
                this.b[i3] = new C0590a<>(this, i3);
            }
            this.g = function;
        }

        public void a() {
            C0590a<T>[] aVarArr = this.b;
            for (C0590a<T> aVar : aVarArr) {
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
            C0590a<T>[] aVarArr = this.b;
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
                                Throwable terminate = this.f.terminate();
                                if (terminate == null) {
                                    subscriber.onComplete();
                                } else {
                                    subscriber.onError(terminate);
                                }
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
                            subscriber.onNext((Object) ObjectHelper.requireNonNull(this.g.apply(objArr), "The combiner returned a null value"));
                            j++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.f.addThrowable(th);
                            this.h = true;
                            a();
                            b();
                            subscriber.onError(this.f.terminate());
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
                            Throwable terminate2 = this.f.terminate();
                            if (terminate2 == null) {
                                subscriber.onComplete();
                            } else {
                                subscriber.onError(terminate2);
                            }
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

    public g0(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, Scheduler scheduler) {
        this.b = publisherArr;
        this.c = iterable;
        this.d = function;
        this.e = scheduler;
    }

    @Override // io.reactivex.Flowable
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
