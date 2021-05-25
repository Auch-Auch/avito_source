package com.jakewharton.rxrelay3;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ReplayRelay<T> extends Relay<T> {
    public static final c[] c = new c[0];
    public static final Object[] d = new Object[0];
    public final b<T> a;
    public final AtomicReference<c<T>[]> b = new AtomicReference<>(c);

    public static final class a<T> extends AtomicReference<a<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final T a;

        public a(T t) {
            this.a = t;
        }
    }

    public interface b<T> {
        T[] a(T[] tArr);

        void add(T t);

        void c();

        void d(c<T> cVar);

        @Nullable
        T getValue();

        int size();
    }

    public static final class c<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        public final Observer<? super T> a;
        public final ReplayRelay<T> b;
        public Object c;
        public volatile boolean d;

        public c(Observer<? super T> observer, ReplayRelay<T> replayRelay) {
            this.a = observer;
            this.b = replayRelay;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.d) {
                this.d = true;
                this.b.e(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }
    }

    public static final class d<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        public final int a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public int e;
        public volatile f<T> f;
        public f<T> g;

        public d(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            if (i <= 0) {
                throw new IllegalArgumentException(a2.b.a.a.a.M2("maxSize > 0 required but it was ", i));
            } else if (j > 0) {
                Objects.requireNonNull(timeUnit, "unit == null");
                Objects.requireNonNull(scheduler, "scheduler == null");
                this.a = i;
                this.b = j;
                this.c = timeUnit;
                this.d = scheduler;
                f<T> fVar = new f<>(null, 0);
                this.g = fVar;
                this.f = fVar;
            } else {
                throw new IllegalArgumentException(a2.b.a.a.a.T2("maxAge > 0 required but it was ", j));
            }
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public T[] a(T[] tArr) {
            f<T> b2 = b();
            int e2 = e(b2);
            if (e2 != 0) {
                if (tArr.length < e2) {
                    tArr = (T[]) ((Object[]) a2.b.a.a.a.k2(tArr, e2));
                }
                for (int i = 0; i != e2; i++) {
                    b2 = (f) b2.get();
                    tArr[i] = b2.a;
                }
                if (tArr.length > e2) {
                    tArr[e2] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public void add(T t) {
            f<T> fVar = new f<>(t, this.d.now(this.c));
            f<T> fVar2 = this.g;
            this.g = fVar;
            this.e++;
            fVar2.set(fVar);
            int i = this.e;
            if (i > this.a) {
                this.e = i - 1;
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

        public f<T> b() {
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

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public void c() {
            f<T> fVar = this.f;
            if (fVar.a != null) {
                f<T> fVar2 = new f<>(null, 0);
                fVar2.lazySet((f) fVar.get());
                this.f = fVar2;
            }
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public void d(c<T> cVar) {
            if (cVar.getAndIncrement() == 0) {
                int i = 1;
                Observer<? super T> observer = cVar.a;
                f<T> fVar = (f) cVar.c;
                if (fVar == null) {
                    fVar = b();
                }
                while (!cVar.d) {
                    while (!cVar.d) {
                        f<T> fVar2 = (f) fVar.get();
                        if (fVar2 != null) {
                            observer.onNext(fVar2.a);
                            fVar = fVar2;
                        } else if (fVar.get() == null) {
                            cVar.c = fVar;
                            i = cVar.addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    }
                    cVar.c = null;
                    return;
                }
                cVar.c = null;
            }
        }

        public int e(f<T> fVar) {
            int i = 0;
            while (i != Integer.MAX_VALUE && (fVar = (f) fVar.get()) != null) {
                i++;
            }
            return i;
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
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

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public int size() {
            return e(b());
        }
    }

    public static final class e<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        public final int a;
        public int b;
        public volatile a<T> c;
        public a<T> d;

        public e(int i) {
            if (i > 0) {
                this.a = i;
                a<T> aVar = new a<>(null);
                this.d = aVar;
                this.c = aVar;
                return;
            }
            throw new IllegalArgumentException(a2.b.a.a.a.M2("maxSize > 0 required but it was ", i));
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public T[] a(T[] tArr) {
            a<T> aVar = this.c;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) a2.b.a.a.a.k2(tArr, size));
                }
                for (int i = 0; i != size; i++) {
                    aVar = (a) aVar.get();
                    tArr[i] = aVar.a;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public void add(T t) {
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

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public void c() {
            a<T> aVar = this.c;
            if (aVar.a != null) {
                a<T> aVar2 = new a<>(null);
                aVar2.lazySet((a) aVar.get());
                this.c = aVar2;
            }
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public void d(c<T> cVar) {
            if (cVar.getAndIncrement() == 0) {
                int i = 1;
                Observer<? super T> observer = cVar.a;
                a<T> aVar = (a) cVar.c;
                if (aVar == null) {
                    aVar = this.c;
                }
                while (!cVar.d) {
                    a<T> aVar2 = (a) aVar.get();
                    if (aVar2 != null) {
                        observer.onNext(aVar2.a);
                        aVar = aVar2;
                    } else if (aVar.get() != null) {
                        continue;
                    } else {
                        cVar.c = aVar;
                        i = cVar.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                }
                cVar.c = null;
            }
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        @Nullable
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

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
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

    public static final class g<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = -733876083048047795L;
        public final List<T> a;
        public volatile int b;

        public g(int i) {
            if (i > 0) {
                this.a = new ArrayList(i);
                return;
            }
            throw new IllegalArgumentException("capacityHint <= 0");
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public T[] a(T[] tArr) {
            int i = this.b;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) a2.b.a.a.a.k2(tArr, i));
            }
            List<T> list = this.a;
            for (int i2 = 0; i2 < i; i2++) {
                tArr[i2] = list.get(i2);
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public void add(T t) {
            this.a.add(t);
            this.b++;
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public void c() {
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public void d(c<T> cVar) {
            if (cVar.getAndIncrement() == 0) {
                List<T> list = this.a;
                Observer<? super T> observer = cVar.a;
                Integer num = (Integer) cVar.c;
                int i = 0;
                int i2 = 1;
                if (num != null) {
                    i = num.intValue();
                } else {
                    cVar.c = 0;
                }
                while (!cVar.d) {
                    int i3 = this.b;
                    while (i3 != i) {
                        if (cVar.d) {
                            cVar.c = null;
                            return;
                        } else {
                            observer.onNext(list.get(i));
                            i++;
                        }
                    }
                    if (i == this.b) {
                        cVar.c = Integer.valueOf(i);
                        i2 = cVar.addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
                cVar.c = null;
            }
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        @Nullable
        public T getValue() {
            int i = this.b;
            if (i != 0) {
                return this.a.get(i - 1);
            }
            return null;
        }

        @Override // com.jakewharton.rxrelay3.ReplayRelay.b
        public int size() {
            return this.b;
        }
    }

    public ReplayRelay(b<T> bVar) {
        this.a = bVar;
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayRelay<T> create() {
        return new ReplayRelay<>(new g(16));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayRelay<T> createWithSize(int i) {
        return new ReplayRelay<>(new e(i));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayRelay<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplayRelay<>(new d(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayRelay<T> createWithTimeAndSize(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return new ReplayRelay<>(new d(i, j, timeUnit, scheduler));
    }

    @Override // com.jakewharton.rxrelay3.Relay, io.reactivex.rxjava3.functions.Consumer
    public void accept(T t) {
        Objects.requireNonNull(t, "value == null");
        b<T> bVar = this.a;
        bVar.add(t);
        for (c<T> cVar : this.b.get()) {
            bVar.d(cVar);
        }
    }

    public void cleanupBuffer() {
        this.a.c();
    }

    public void e(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.b.get();
            if (cVarArr != c) {
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
                        cVarArr2 = c;
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
        } while (!this.b.compareAndSet(cVarArr, cVarArr2));
    }

    @Nullable
    public T getValue() {
        return this.a.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.jakewharton.rxrelay3.ReplayRelay<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = d;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @Override // com.jakewharton.rxrelay3.Relay
    public boolean hasObservers() {
        return this.b.get().length != 0;
    }

    public boolean hasValue() {
        return this.a.size() != 0;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        c<T> cVar = new c<>(observer, this);
        observer.onSubscribe(cVar);
        if (!cVar.d) {
            do {
                cVarArr = this.b.get();
                int length = cVarArr.length;
                cVarArr2 = new c[(length + 1)];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
            } while (!this.b.compareAndSet(cVarArr, cVarArr2));
            if (cVar.d) {
                e(cVar);
            } else {
                this.a.d(cVar);
            }
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayRelay<T> create(int i) {
        return new ReplayRelay<>(new g(i));
    }

    public T[] getValues(T[] tArr) {
        return this.a.a(tArr);
    }
}
