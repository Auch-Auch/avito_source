package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowablePublishMulticast<T, R> extends s6.a.e.d.c.a.a<T, R> {
    public final Function<? super Flowable<T>, ? extends Publisher<? extends R>> b;
    public final int c;
    public final boolean d;

    public static final class a<T> extends Flowable<T> implements FlowableSubscriber<T> {
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

        public void dispose() {
            SimpleQueue<T> simpleQueue;
            if (!this.j) {
                SubscriptionHelper.cancel(this.g);
                if (this.b.getAndIncrement() == 0 && (simpleQueue = this.h) != null) {
                    simpleQueue.clear();
                }
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

        /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ff, code lost:
            if (r7 != 0) goto L_0x013a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0109, code lost:
            if (r24.g.get() != io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper.CANCELLED) goto L_0x010d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x010b, code lost:
            r5 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x010d, code lost:
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x010e, code lost:
            if (r5 == false) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0110, code lost:
            r0.clear();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0113, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0114, code lost:
            r5 = r24.j;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0116, code lost:
            if (r5 == false) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x011a, code lost:
            if (r24.f != false) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x011c, code lost:
            r6 = r24.k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x011e, code lost:
            if (r6 == null) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0120, code lost:
            h(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0123, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0124, code lost:
            if (r5 == false) goto L_0x013a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x012a, code lost:
            if (r0.isEmpty() == false) goto L_0x013a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x012c, code lost:
            r0 = r24.k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x012e, code lost:
            if (r0 == null) goto L_0x0134;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0130, code lost:
            h(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0134, code lost:
            f();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
            // Method dump skipped, instructions count: 342
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast.a.g():void");
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

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
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

        @Override // io.reactivex.rxjava3.core.Flowable
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

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
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

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        a aVar = new a(this.c, this.d);
        try {
            Object apply = this.b.apply(aVar);
            Objects.requireNonNull(apply, "selector returned a null Publisher");
            ((Publisher) apply).subscribe(new c(subscriber, aVar));
            this.source.subscribe((FlowableSubscriber) aVar);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
