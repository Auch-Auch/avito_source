package io.reactivex.processors;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    public static final Object[] e = new Object[0];
    public static final c[] f = new c[0];
    public static final c[] g = new c[0];
    public final b<T> b;
    public boolean c;
    public final AtomicReference<c<T>[]> d = new AtomicReference<>(f);

    public static final class a<T> extends AtomicReference<a<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final T a;

        public a(T t) {
            this.a = t;
        }
    }

    public interface b<T> {
        T[] a(T[] tArr);

        void b(Throwable th);

        void c();

        void complete();

        void d(c<T> cVar);

        Throwable getError();

        @Nullable
        T getValue();

        boolean isDone();

        void next(T t);

        int size();
    }

    public static final class c<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        public final Subscriber<? super T> a;
        public final ReplayProcessor<T> b;
        public Object c;
        public final AtomicLong d = new AtomicLong();
        public volatile boolean e;
        public long f;

        public c(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
            this.a = subscriber;
            this.b = replayProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.e) {
                this.e = true;
                this.b.f(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.d, j);
                this.b.b.d(this);
            }
        }
    }

    public static final class d<T> implements b<T> {
        public final int a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public int e;
        public volatile f<T> f;
        public f<T> g;
        public Throwable h;
        public volatile boolean i;

        public d(int i2, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = ObjectHelper.verifyPositive(i2, SDKConstants.PARAM_CONTEXT_MAX_SIZE);
            this.b = ObjectHelper.verifyPositive(j, "maxAge");
            this.c = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.d = (Scheduler) ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            f<T> fVar = new f<>(null, 0);
            this.g = fVar;
            this.f = fVar;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public T[] a(T[] tArr) {
            f<T> e2 = e();
            int f2 = f(e2);
            if (f2 != 0) {
                if (tArr.length < f2) {
                    tArr = (T[]) ((Object[]) a2.b.a.a.a.k2(tArr, f2));
                }
                for (int i2 = 0; i2 != f2; i2++) {
                    e2 = (f) e2.get();
                    tArr[i2] = e2.a;
                }
                if (tArr.length > f2) {
                    tArr[f2] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void b(Throwable th) {
            g();
            this.h = th;
            this.i = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void c() {
            if (this.f.a != null) {
                f<T> fVar = new f<>(null, 0);
                fVar.lazySet(this.f.get());
                this.f = fVar;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void complete() {
            g();
            this.i = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void d(c<T> cVar) {
            int i2;
            if (cVar.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = cVar.a;
                f<T> fVar = (f) cVar.c;
                if (fVar == null) {
                    fVar = e();
                }
                long j = cVar.f;
                int i3 = 1;
                do {
                    long j2 = cVar.d.get();
                    while (true) {
                        i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (cVar.e) {
                            cVar.c = null;
                            return;
                        } else {
                            boolean z = this.i;
                            f<T> fVar2 = (f) fVar.get();
                            boolean z2 = fVar2 == null;
                            if (z && z2) {
                                cVar.c = null;
                                cVar.e = true;
                                Throwable th = this.h;
                                if (th == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(th);
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(fVar2.a);
                                j++;
                                fVar = fVar2;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (cVar.e) {
                            cVar.c = null;
                            return;
                        } else if (this.i && fVar.get() == null) {
                            cVar.c = null;
                            cVar.e = true;
                            Throwable th2 = this.h;
                            if (th2 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    cVar.c = fVar;
                    cVar.f = j;
                    i3 = cVar.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public f<T> e() {
            f<T> fVar = this.f;
            long now = this.d.now(this.c) - this.b;
            Object obj = fVar.get();
            while (true) {
                fVar = (f) obj;
                if (fVar == null || fVar.b > now) {
                    break;
                }
                obj = fVar.get();
            }
            return fVar;
        }

        public int f(f<T> fVar) {
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE && (fVar = (f) fVar.get()) != null) {
                i2++;
            }
            return i2;
        }

        public void g() {
            long now = this.d.now(this.c) - this.b;
            f<T> fVar = this.f;
            while (true) {
                f<T> fVar2 = (f) fVar.get();
                if (fVar2 == null) {
                    if (fVar.a != null) {
                        this.f = new f<>(null, 0);
                        return;
                    } else {
                        this.f = fVar;
                        return;
                    }
                } else if (fVar2.b <= now) {
                    fVar = fVar2;
                } else if (fVar.a != null) {
                    f<T> fVar3 = new f<>(null, 0);
                    fVar3.lazySet(fVar.get());
                    this.f = fVar3;
                    return;
                } else {
                    this.f = fVar;
                    return;
                }
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public Throwable getError() {
            return this.h;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        @Nullable
        public T getValue() {
            f<T> fVar = this.f;
            while (true) {
                f<T> fVar2 = (f) fVar.get();
                if (fVar2 == null) {
                    break;
                }
                fVar = fVar2;
            }
            if (fVar.b < this.d.now(this.c) - this.b) {
                return null;
            }
            return fVar.a;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public boolean isDone() {
            return this.i;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void next(T t) {
            f<T> fVar = new f<>(t, this.d.now(this.c));
            f<T> fVar2 = this.g;
            this.g = fVar;
            this.e++;
            fVar2.set(fVar);
            int i2 = this.e;
            if (i2 > this.a) {
                this.e = i2 - 1;
                this.f = (f) this.f.get();
            }
            long now = this.d.now(this.c) - this.b;
            f<T> fVar3 = this.f;
            while (this.e > 1) {
                f<T> fVar4 = (f) fVar3.get();
                if (fVar4 == null) {
                    this.f = fVar3;
                    return;
                } else if (fVar4.b > now) {
                    this.f = fVar3;
                    return;
                } else {
                    this.e--;
                    fVar3 = fVar4;
                }
            }
            this.f = fVar3;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public int size() {
            return f(e());
        }
    }

    public static final class e<T> implements b<T> {
        public final int a;
        public int b;
        public volatile a<T> c;
        public a<T> d;
        public Throwable e;
        public volatile boolean f;

        public e(int i) {
            this.a = ObjectHelper.verifyPositive(i, SDKConstants.PARAM_CONTEXT_MAX_SIZE);
            a<T> aVar = new a<>(null);
            this.d = aVar;
            this.c = aVar;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public T[] a(T[] tArr) {
            a<T> aVar = this.c;
            int i = 0;
            a<T> aVar2 = aVar;
            while (true) {
                aVar2 = (a) aVar2.get();
                if (aVar2 == null) {
                    break;
                }
                i++;
            }
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) a2.b.a.a.a.k2(tArr, i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                aVar = (a) aVar.get();
                tArr[i2] = aVar.a;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void b(Throwable th) {
            this.e = th;
            c();
            this.f = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void c() {
            if (this.c.a != null) {
                a<T> aVar = new a<>(null);
                aVar.lazySet(this.c.get());
                this.c = aVar;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void complete() {
            c();
            this.f = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void d(c<T> cVar) {
            int i;
            if (cVar.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = cVar.a;
                a<T> aVar = (a) cVar.c;
                if (aVar == null) {
                    aVar = this.c;
                }
                long j = cVar.f;
                int i2 = 1;
                do {
                    long j2 = cVar.d.get();
                    while (true) {
                        i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (cVar.e) {
                            cVar.c = null;
                            return;
                        } else {
                            boolean z = this.f;
                            a<T> aVar2 = (a) aVar.get();
                            boolean z2 = aVar2 == null;
                            if (z && z2) {
                                cVar.c = null;
                                cVar.e = true;
                                Throwable th = this.e;
                                if (th == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(th);
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(aVar2.a);
                                j++;
                                aVar = aVar2;
                            }
                        }
                    }
                    if (i == 0) {
                        if (cVar.e) {
                            cVar.c = null;
                            return;
                        } else if (this.f && aVar.get() == null) {
                            cVar.c = null;
                            cVar.e = true;
                            Throwable th2 = this.e;
                            if (th2 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    cVar.c = aVar;
                    cVar.f = j;
                    i2 = cVar.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public Throwable getError() {
            return this.e;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public T getValue() {
            a<T> aVar = this.c;
            while (true) {
                a<T> aVar2 = (a) aVar.get();
                if (aVar2 == null) {
                    return aVar.a;
                }
                aVar = aVar2;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public boolean isDone() {
            return this.f;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void next(T t) {
            a<T> aVar = new a<>(t);
            a<T> aVar2 = this.d;
            this.d = aVar;
            this.b++;
            aVar2.set(aVar);
            int i = this.b;
            if (i > this.a) {
                this.b = i - 1;
                this.c = (a) this.c.get();
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public int size() {
            a<T> aVar = this.c;
            int i = 0;
            while (i != Integer.MAX_VALUE && (aVar = (a) aVar.get()) != null) {
                i++;
            }
            return i;
        }
    }

    public static final class f<T> extends AtomicReference<f<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final T a;
        public final long b;

        public f(T t, long j) {
            this.a = t;
            this.b = j;
        }
    }

    public static final class g<T> implements b<T> {
        public final List<T> a;
        public Throwable b;
        public volatile boolean c;
        public volatile int d;

        public g(int i) {
            this.a = new ArrayList(ObjectHelper.verifyPositive(i, "capacityHint"));
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public T[] a(T[] tArr) {
            int i = this.d;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.a;
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) a2.b.a.a.a.k2(tArr, i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                tArr[i2] = list.get(i2);
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void b(Throwable th) {
            this.b = th;
            this.c = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void c() {
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void complete() {
            this.c = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void d(c<T> cVar) {
            int i;
            if (cVar.getAndIncrement() == 0) {
                List<T> list = this.a;
                Subscriber<? super T> subscriber = cVar.a;
                Integer num = (Integer) cVar.c;
                int i2 = 0;
                if (num != null) {
                    i2 = num.intValue();
                } else {
                    cVar.c = 0;
                }
                long j = cVar.f;
                int i3 = 1;
                do {
                    long j2 = cVar.d.get();
                    while (true) {
                        i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (cVar.e) {
                            cVar.c = null;
                            return;
                        } else {
                            boolean z = this.c;
                            int i4 = this.d;
                            if (z && i2 == i4) {
                                cVar.c = null;
                                cVar.e = true;
                                Throwable th = this.b;
                                if (th == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(th);
                                    return;
                                }
                            } else if (i2 == i4) {
                                break;
                            } else {
                                subscriber.onNext(list.get(i2));
                                i2++;
                                j++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (cVar.e) {
                            cVar.c = null;
                            return;
                        }
                        boolean z2 = this.c;
                        int i5 = this.d;
                        if (z2 && i2 == i5) {
                            cVar.c = null;
                            cVar.e = true;
                            Throwable th2 = this.b;
                            if (th2 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    cVar.c = Integer.valueOf(i2);
                    cVar.f = j;
                    i3 = cVar.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public Throwable getError() {
            return this.b;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        @Nullable
        public T getValue() {
            int i = this.d;
            if (i == 0) {
                return null;
            }
            return this.a.get(i - 1);
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public boolean isDone() {
            return this.c;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public void next(T t) {
            this.a.add(t);
            this.d++;
        }

        @Override // io.reactivex.processors.ReplayProcessor.b
        public int size() {
            return this.d;
        }
    }

    public ReplayProcessor(b<T> bVar) {
        this.b = bVar;
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<>(new g(16));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithSize(int i) {
        return new ReplayProcessor<>(new e(i));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplayProcessor<>(new d(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return new ReplayProcessor<>(new d(i, j, timeUnit, scheduler));
    }

    public void cleanupBuffer() {
        this.b.c();
    }

    public void f(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.d.get();
            if (cVarArr != g && cVarArr != f) {
                int length = cVarArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (cVarArr[i] == cVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        cVarArr2 = f;
                    } else {
                        c<T>[] cVarArr3 = new c[(length - 1)];
                        System.arraycopy(cVarArr, 0, cVarArr3, 0, i);
                        System.arraycopy(cVarArr, i + 1, cVarArr3, i, (length - i) - 1);
                        cVarArr2 = cVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.d.compareAndSet(cVarArr, cVarArr2));
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @Nullable
    public Throwable getThrowable() {
        b<T> bVar = this.b;
        if (bVar.isDone()) {
            return bVar.getError();
        }
        return null;
    }

    public T getValue() {
        return this.b.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.processors.ReplayProcessor<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = e;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        b<T> bVar = this.b;
        return bVar.isDone() && bVar.getError() == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.d.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        b<T> bVar = this.b;
        return bVar.isDone() && bVar.getError() != null;
    }

    public boolean hasValue() {
        return this.b.size() != 0;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.c) {
            this.c = true;
            b<T> bVar = this.b;
            bVar.complete();
            for (c<T> cVar : this.d.getAndSet(g)) {
                bVar.d(cVar);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.c = true;
        b<T> bVar = this.b;
        bVar.b(th);
        for (c<T> cVar : this.d.getAndSet(g)) {
            bVar.d(cVar);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.c) {
            b<T> bVar = this.b;
            bVar.next(t);
            for (c<T> cVar : this.d.get()) {
                bVar.d(cVar);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.c) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        c<T> cVar = new c<>(subscriber, this);
        subscriber.onSubscribe(cVar);
        while (true) {
            c<T>[] cVarArr = this.d.get();
            z = false;
            if (cVarArr != g) {
                int length = cVarArr.length;
                c<T>[] cVarArr2 = new c[(length + 1)];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                if (this.d.compareAndSet(cVarArr, cVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z || !cVar.e) {
            this.b.d(cVar);
        } else {
            f(cVar);
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> create(int i) {
        return new ReplayProcessor<>(new g(i));
    }

    public T[] getValues(T[] tArr) {
        return this.b.a(tArr);
    }
}
