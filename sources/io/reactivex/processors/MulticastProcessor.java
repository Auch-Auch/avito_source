package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@SchedulerSupport("none")
@BackpressureSupport(BackpressureKind.FULL)
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    public static final a[] n = new a[0];
    public static final a[] o = new a[0];
    public final AtomicInteger b = new AtomicInteger();
    public final AtomicReference<Subscription> c = new AtomicReference<>();
    public final AtomicReference<a<T>[]> d = new AtomicReference<>(n);
    public final AtomicBoolean e;
    public final int f;
    public final int g;
    public final boolean h;
    public volatile SimpleQueue<T> i;
    public volatile boolean j;
    public volatile Throwable k;
    public int l;
    public int m;

    public static final class a<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        public final Subscriber<? super T> a;
        public final MulticastProcessor<T> b;
        public long c;

        public a(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.a = subscriber;
            this.b = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.b.g(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            long j2;
            long j3;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        j3 = Long.MAX_VALUE;
                        if (j2 != Long.MAX_VALUE) {
                            long j4 = j2 + j;
                            if (j4 >= 0) {
                                j3 = j4;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.b.f();
            }
        }
    }

    public MulticastProcessor(int i2, boolean z) {
        ObjectHelper.verifyPositive(i2, "bufferSize");
        this.f = i2;
        this.g = i2 - (i2 >> 2);
        this.h = z;
        this.e = new AtomicBoolean();
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(Flowable.bufferSize(), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0104, code lost:
        if (r12 != 0) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0106, code lost:
        r0 = r2.get();
        r10 = io.reactivex.processors.MulticastProcessor.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010e, code lost:
        if (r0 != r10) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0110, code lost:
        r7.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0113, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0114, code lost:
        if (r8 == r0) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011b, code lost:
        if (r24.j == false) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0121, code lost:
        if (r7.isEmpty() == false) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0123, code lost:
        r0 = r24.k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0125, code lost:
        if (r0 == null) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0127, code lost:
        r2 = r2.getAndSet(r10);
        r3 = r2.length;
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x012f, code lost:
        if (r12 >= r3) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0131, code lost:
        r4 = r2[r12];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013b, code lost:
        if (r4.get() == Long.MIN_VALUE) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x013d, code lost:
        r4.a.onError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0142, code lost:
        r12 = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0145, code lost:
        r0 = r2.getAndSet(r10);
        r2 = r0.length;
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x014d, code lost:
        if (r12 >= r2) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x014f, code lost:
        r3 = r0[r12];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0159, code lost:
        if (r3.get() == Long.MIN_VALUE) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x015b, code lost:
        r3.a.onComplete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0160, code lost:
        r12 = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0164, code lost:
        r0 = r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
        // Method dump skipped, instructions count: 369
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.MulticastProcessor.f():void");
    }

    public void g(a<T> aVar) {
        while (true) {
            a<T>[] aVarArr = this.d.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (aVarArr[i2] == aVar) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length != 1) {
                        a<T>[] aVarArr2 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, i2);
                        System.arraycopy(aVarArr, i2 + 1, aVarArr2, i2, (length - i2) - 1);
                        if (this.d.compareAndSet(aVarArr, aVarArr2)) {
                            return;
                        }
                    } else if (this.h) {
                        if (this.d.compareAndSet(aVarArr, o)) {
                            SubscriptionHelper.cancel(this.c);
                            this.e.set(true);
                            return;
                        }
                    } else if (this.d.compareAndSet(aVarArr, n)) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.e.get()) {
            return this.k;
        }
        return null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.e.get() && this.k == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.d.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.e.get() && this.k != null;
    }

    public boolean offer(T t) {
        if (this.e.get()) {
            return false;
        }
        ObjectHelper.requireNonNull(t, "offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.m != 0 || !this.i.offer(t)) {
            return false;
        }
        f();
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.e.compareAndSet(false, true)) {
            this.j = true;
            f();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e.compareAndSet(false, true)) {
            this.k = th;
            this.j = true;
            f();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (!this.e.get()) {
            if (this.m == 0) {
                ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                if (!this.i.offer(t)) {
                    SubscriptionHelper.cancel(this.c);
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            f();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.c, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.m = requestFusion;
                    this.i = queueSubscription;
                    this.j = true;
                    f();
                    return;
                } else if (requestFusion == 2) {
                    this.m = requestFusion;
                    this.i = queueSubscription;
                    subscription.request((long) this.f);
                    return;
                }
            }
            this.i = new SpscArrayQueue(this.f);
            subscription.request((long) this.f);
        }
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.c, EmptySubscription.INSTANCE)) {
            this.i = new SpscArrayQueue(this.f);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.c, EmptySubscription.INSTANCE)) {
            this.i = new SpscLinkedArrayQueue(this.f);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        Throwable th;
        a<T> aVar = new a<>(subscriber, this);
        subscriber.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.d.get();
            z = false;
            if (aVarArr != o) {
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
        if (z) {
            if (aVar.get() == Long.MIN_VALUE) {
                g(aVar);
            } else {
                f();
            }
        } else if ((this.e.get() || !this.h) && (th = this.k) != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(boolean z) {
        return new MulticastProcessor<>(Flowable.bufferSize(), z);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i2) {
        return new MulticastProcessor<>(i2, false);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i2, boolean z) {
        return new MulticastProcessor<>(i2, z);
    }
}
