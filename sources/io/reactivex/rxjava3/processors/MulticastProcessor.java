package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    public static final a[] m = new a[0];
    public static final a[] n = new a[0];
    public final AtomicInteger b = new AtomicInteger();
    public final AtomicReference<Subscription> c = new AtomicReference<>();
    public final AtomicReference<a<T>[]> d = new AtomicReference<>(m);
    public final int e;
    public final int f;
    public final boolean g;
    public volatile SimpleQueue<T> h;
    public volatile boolean i;
    public volatile Throwable j;
    public int k;
    public int l;

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
            if (SubscriptionHelper.validate(j)) {
                long addCancel = BackpressureHelper.addCancel(this, j);
                if (addCancel != Long.MIN_VALUE && addCancel != Long.MAX_VALUE) {
                    this.b.f();
                }
            }
        }
    }

    public MulticastProcessor(int i2, boolean z) {
        this.e = i2;
        this.f = i2 - (i2 >> 2);
        this.g = z;
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
        r10 = io.reactivex.rxjava3.processors.MulticastProcessor.n;
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
        if (r24.i == false) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0121, code lost:
        if (r7.isEmpty() == false) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0123, code lost:
        r0 = r24.j;
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.MulticastProcessor.f():void");
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
                    } else if (this.g) {
                        if (this.d.compareAndSet(aVarArr, n)) {
                            SubscriptionHelper.cancel(this.c);
                            this.i = true;
                            return;
                        }
                    } else if (this.d.compareAndSet(aVarArr, m)) {
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

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.i) {
            return this.j;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        return this.i && this.j == null;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.d.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        return this.i && this.j != null;
    }

    @CheckReturnValue
    public boolean offer(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "offer called with a null value.");
        if (this.i) {
            return false;
        }
        if (this.l != 0) {
            throw new IllegalStateException("offer() should not be called in fusion mode!");
        } else if (!this.h.offer(t)) {
            return false;
        } else {
            f();
            return true;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.i = true;
        f();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(@NonNull Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (!this.i) {
            this.j = th;
            this.i = true;
            f();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(@NonNull T t) {
        if (!this.i) {
            if (this.l == 0) {
                ExceptionHelper.nullCheck(t, "onNext called with a null value.");
                if (!this.h.offer(t)) {
                    SubscriptionHelper.cancel(this.c);
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            f();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.c, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.l = requestFusion;
                    this.h = queueSubscription;
                    this.i = true;
                    f();
                    return;
                } else if (requestFusion == 2) {
                    this.l = requestFusion;
                    this.h = queueSubscription;
                    subscription.request((long) this.e);
                    return;
                }
            }
            this.h = new SpscArrayQueue(this.e);
            subscription.request((long) this.e);
        }
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.c, EmptySubscription.INSTANCE)) {
            this.h = new SpscArrayQueue(this.e);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.c, EmptySubscription.INSTANCE)) {
            this.h = new SpscLinkedArrayQueue(this.e);
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        boolean z;
        Throwable th;
        a<T> aVar = new a<>(subscriber, this);
        subscriber.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.d.get();
            z = false;
            if (aVarArr != n) {
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
        } else if (!this.i || (th = this.j) == null) {
            subscriber.onComplete();
        } else {
            subscriber.onError(th);
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
        ObjectHelper.verifyPositive(i2, "bufferSize");
        return new MulticastProcessor<>(i2, false);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i2, boolean z) {
        ObjectHelper.verifyPositive(i2, "bufferSize");
        return new MulticastProcessor<>(i2, z);
    }
}
