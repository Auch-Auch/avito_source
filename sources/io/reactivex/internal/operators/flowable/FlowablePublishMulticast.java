package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowablePublishMulticast<T, R> extends s6.a.c.b.a.a<T, R> {
    public final Function<? super Flowable<T>, ? extends Publisher<? extends R>> b;
    public final int c;
    public final boolean d;

    public static final class a<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        public static final b[] m = new b[0];
        public static final b[] n = new b[0];
        public final AtomicInteger b = new AtomicInteger();
        public final AtomicReference<b<T>[]> c = new AtomicReference<>(m);
        public final int d;
        public final int e;
        public final boolean f;
        public final AtomicReference<Subscription> g = new AtomicReference<>();
        public volatile SimpleQueue<T> h;
        public int i;
        public volatile boolean j;
        public Throwable k;
        public int l;

        public a(int i2, boolean z) {
            this.d = i2;
            this.e = i2 - (i2 >> 2);
            this.f = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SimpleQueue<T> simpleQueue;
            SubscriptionHelper.cancel(this.g);
            if (this.b.getAndIncrement() == 0 && (simpleQueue = this.h) != null) {
                simpleQueue.clear();
            }
        }

        public void f() {
            b<T>[] andSet = this.c.getAndSet(n);
            for (b<T> bVar : andSet) {
                if (bVar.get() != Long.MIN_VALUE) {
                    bVar.a.onComplete();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f8, code lost:
            if (r7 != 0) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00fe, code lost:
            if (isDisposed() == false) goto L_0x0104;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0100, code lost:
            r0.clear();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0103, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0104, code lost:
            r5 = r24.j;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0106, code lost:
            if (r5 == false) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x010a, code lost:
            if (r24.f != false) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x010c, code lost:
            r6 = r24.k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x010e, code lost:
            if (r6 == null) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0110, code lost:
            h(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0113, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0114, code lost:
            if (r5 == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x011a, code lost:
            if (r0.isEmpty() == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x011c, code lost:
            r0 = r24.k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x011e, code lost:
            if (r0 == null) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0120, code lost:
            h(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0124, code lost:
            f();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
            // Method dump skipped, instructions count: 326
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublishMulticast.a.g():void");
        }

        public void h(Throwable th) {
            b<T>[] andSet = this.c.getAndSet(n);
            for (b<T> bVar : andSet) {
                if (bVar.get() != Long.MIN_VALUE) {
                    bVar.a.onError(th);
                }
            }
        }

        public void i(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.c.get();
                int length = bVarArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (bVarArr[i2] == bVar) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            bVarArr2 = m;
                        } else {
                            b<T>[] bVarArr3 = new b[(length - 1)];
                            System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                            System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                            bVarArr2 = bVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.c.compareAndSet(bVarArr, bVarArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.j) {
                this.j = true;
                g();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.j) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.k = th;
            this.j = true;
            g();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.j) {
                if (this.i != 0 || this.h.offer(t)) {
                    g();
                    return;
                }
                this.g.get().cancel();
                onError(new MissingBackpressureException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.g, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.i = requestFusion;
                        this.h = queueSubscription;
                        this.j = true;
                        g();
                        return;
                    } else if (requestFusion == 2) {
                        this.i = requestFusion;
                        this.h = queueSubscription;
                        QueueDrainHelper.request(subscription, this.d);
                        return;
                    }
                }
                this.h = QueueDrainHelper.createQueue(this.d);
                QueueDrainHelper.request(subscription, this.d);
            }
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super T> subscriber) {
            boolean z;
            boolean z2;
            b<T> bVar = new b<>(subscriber, this);
            subscriber.onSubscribe(bVar);
            while (true) {
                b<T>[] bVarArr = this.c.get();
                z = false;
                if (bVarArr != n) {
                    int length = bVarArr.length;
                    b<T>[] bVarArr2 = new b[(length + 1)];
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                    bVarArr2[length] = bVar;
                    if (this.c.compareAndSet(bVarArr, bVarArr2)) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                if (bVar.get() == Long.MIN_VALUE) {
                    z = true;
                }
                if (z) {
                    i(bVar);
                } else {
                    g();
                }
            } else {
                Throwable th = this.k;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }

    public static final class b<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        public final Subscriber<? super T> a;
        public final a<T> b;
        public long c;

        public b(Subscriber<? super T> subscriber, a<T> aVar) {
            this.a = subscriber;
            this.b = aVar;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.b.i(this);
                this.b.g();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.b.g();
            }
        }
    }

    public static final class c<R> implements FlowableSubscriber<R>, Subscription {
        public final Subscriber<? super R> a;
        public final a<?> b;
        public Subscription c;

        public c(Subscriber<? super R> subscriber, a<?> aVar) {
            this.a = subscriber;
            this.b = aVar;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c.cancel();
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            this.a.onNext(r);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.c.request(j);
        }
    }

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.b = function;
        this.c = i;
        this.d = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        a aVar = new a(this.c, this.d);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.b.apply(aVar), "selector returned a null Publisher")).subscribe(new c(subscriber, aVar));
            this.source.subscribe((FlowableSubscriber) aVar);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
