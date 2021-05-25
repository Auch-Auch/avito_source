package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableFlatMap<T, U> extends s6.a.e.d.c.c.a<T, U> {
    public final Function<? super T, ? extends ObservableSource<? extends U>> a;
    public final boolean b;
    public final int c;
    public final int d;

    public static final class a<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        public final b<T, U> a;
        public volatile boolean b;
        public volatile SimpleQueue<U> c;
        public int d;

        public a(b<T, U> bVar, long j) {
            this.a = bVar;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.b = true;
            this.a.c();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.a.h.tryAddThrowableOrReport(th)) {
                b<T, U> bVar = this.a;
                if (!bVar.c) {
                    bVar.b();
                }
                this.b = true;
                this.a.c();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(U u) {
            if (this.d == 0) {
                b<T, U> bVar = this.a;
                if (bVar.get() != 0 || !bVar.compareAndSet(0, 1)) {
                    SimpleQueue simpleQueue = this.c;
                    if (simpleQueue == null) {
                        simpleQueue = new SpscLinkedArrayQueue(bVar.e);
                        this.c = simpleQueue;
                    }
                    simpleQueue.offer(u);
                    if (bVar.getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    bVar.a.onNext(u);
                    if (bVar.decrementAndGet() == 0) {
                        return;
                    }
                }
                bVar.e();
                return;
            }
            this.a.c();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.d = requestFusion;
                    this.c = queueDisposable;
                    this.b = true;
                    this.a.c();
                } else if (requestFusion == 2) {
                    this.d = requestFusion;
                    this.c = queueDisposable;
                }
            }
        }
    }

    public static final class b<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        public static final a<?, ?>[] p = new a[0];
        public static final a<?, ?>[] q = new a[0];
        private static final long serialVersionUID = -2117620485640801370L;
        public final Observer<? super U> a;
        public final Function<? super T, ? extends ObservableSource<? extends U>> b;
        public final boolean c;
        public final int d;
        public final int e;
        public volatile SimplePlainQueue<U> f;
        public volatile boolean g;
        public final AtomicThrowable h = new AtomicThrowable();
        public volatile boolean i;
        public final AtomicReference<a<?, ?>[]> j;
        public Disposable k;
        public long l;
        public int m;
        public Queue<ObservableSource<? extends U>> n;
        public int o;

        public b(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i2, int i3) {
            this.a = observer;
            this.b = function;
            this.c = z;
            this.d = i2;
            this.e = i3;
            if (i2 != Integer.MAX_VALUE) {
                this.n = new ArrayDeque(i2);
            }
            this.j = new AtomicReference<>(p);
        }

        public boolean a() {
            if (this.i) {
                return true;
            }
            Throwable th = (Throwable) this.h.get();
            if (this.c || th == null) {
                return false;
            }
            b();
            this.h.tryTerminateConsumer(this.a);
            return true;
        }

        public boolean b() {
            this.k.dispose();
            AtomicReference<a<?, ?>[]> atomicReference = this.j;
            a<?, ?>[] aVarArr = q;
            a<?, ?>[] andSet = atomicReference.getAndSet(aVarArr);
            if (andSet == aVarArr) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                Objects.requireNonNull(aVar);
                DisposableHelper.dispose(aVar);
            }
            return true;
        }

        public void c() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.i = true;
            if (b()) {
                this.h.tryTerminateAndReport();
            }
        }

        public void e() {
            int i2;
            Observer<? super U> observer = this.a;
            int i3 = 1;
            while (!a()) {
                SimplePlainQueue<U> simplePlainQueue = this.f;
                int i4 = 0;
                if (simplePlainQueue != null) {
                    while (!a()) {
                        U poll = simplePlainQueue.poll();
                        if (poll != null) {
                            observer.onNext(poll);
                            i4++;
                        }
                    }
                    return;
                }
                if (i4 == 0) {
                    boolean z = this.g;
                    SimplePlainQueue<U> simplePlainQueue2 = this.f;
                    a<?, ?>[] aVarArr = this.j.get();
                    int length = aVarArr.length;
                    if (this.d != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i2 = this.n.size();
                        }
                    } else {
                        i2 = 0;
                    }
                    if (!z || !((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i2 == 0)) {
                        if (length != 0) {
                            int min = Math.min(length - 1, this.m);
                            for (int i5 = 0; i5 < length; i5++) {
                                if (!a()) {
                                    a<T, U> aVar = aVarArr[min];
                                    SimpleQueue<U> simpleQueue = aVar.c;
                                    if (simpleQueue != null) {
                                        while (true) {
                                            try {
                                                U poll2 = simpleQueue.poll();
                                                if (poll2 == null) {
                                                    break;
                                                }
                                                observer.onNext(poll2);
                                                if (a()) {
                                                    return;
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.throwIfFatal(th);
                                                DisposableHelper.dispose(aVar);
                                                this.h.tryAddThrowableOrReport(th);
                                                if (!a()) {
                                                    f(aVar);
                                                    i4++;
                                                    min++;
                                                    if (min != length) {
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                    boolean z2 = aVar.b;
                                    SimpleQueue<U> simpleQueue2 = aVar.c;
                                    if (z2 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                        f(aVar);
                                        i4++;
                                    }
                                    min++;
                                    if (min != length) {
                                    }
                                    min = 0;
                                } else {
                                    return;
                                }
                            }
                            this.m = min;
                        }
                        if (i4 == 0) {
                            i3 = addAndGet(-i3);
                            if (i3 == 0) {
                                return;
                            }
                        } else if (this.d != Integer.MAX_VALUE) {
                            i(i4);
                        }
                    } else {
                        this.h.tryTerminateConsumer(this.a);
                        return;
                    }
                } else if (this.d != Integer.MAX_VALUE) {
                    i(i4);
                }
            }
        }

        public void f(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.j.get();
                int length = aVarArr.length;
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
                    if (length == 1) {
                        aVarArr2 = p;
                    } else {
                        a<?, ?>[] aVarArr3 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                        System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } while (!this.j.compareAndSet(aVarArr, aVarArr2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v8, types: [io.reactivex.rxjava3.internal.fuseable.SimpleQueue] */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            if (decrementAndGet() == 0) goto L_0x005e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h(io.reactivex.rxjava3.core.ObservableSource<? extends U> r8) {
            /*
                r7 = this;
            L_0x0000:
                boolean r0 = r8 instanceof io.reactivex.rxjava3.functions.Supplier
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x0080
                io.reactivex.rxjava3.functions.Supplier r8 = (io.reactivex.rxjava3.functions.Supplier) r8
                r0 = 2147483647(0x7fffffff, float:NaN)
                java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x0052 }
                if (r8 != 0) goto L_0x0012
                goto L_0x005e
            L_0x0012:
                int r3 = r7.get()
                if (r3 != 0) goto L_0x002a
                boolean r3 = r7.compareAndSet(r1, r2)
                if (r3 == 0) goto L_0x002a
                io.reactivex.rxjava3.core.Observer<? super U> r3 = r7.a
                r3.onNext(r8)
                int r8 = r7.decrementAndGet()
                if (r8 != 0) goto L_0x004e
                goto L_0x005e
            L_0x002a:
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<U> r3 = r7.f
                if (r3 != 0) goto L_0x0043
                int r3 = r7.d
                if (r3 != r0) goto L_0x003a
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue r3 = new io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue
                int r4 = r7.e
                r3.<init>(r4)
                goto L_0x0041
            L_0x003a:
                io.reactivex.rxjava3.internal.queue.SpscArrayQueue r3 = new io.reactivex.rxjava3.internal.queue.SpscArrayQueue
                int r4 = r7.d
                r3.<init>(r4)
            L_0x0041:
                r7.f = r3
            L_0x0043:
                r3.offer(r8)
                int r8 = r7.getAndIncrement()
                if (r8 == 0) goto L_0x004e
                r8 = 0
                goto L_0x005f
            L_0x004e:
                r7.e()
                goto L_0x005e
            L_0x0052:
                r8 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r8)
                io.reactivex.rxjava3.internal.util.AtomicThrowable r3 = r7.h
                r3.tryAddThrowableOrReport(r8)
                r7.c()
            L_0x005e:
                r8 = 1
            L_0x005f:
                if (r8 == 0) goto L_0x00b4
                int r8 = r7.d
                if (r8 == r0) goto L_0x00b4
                monitor-enter(r7)
                java.util.Queue<io.reactivex.rxjava3.core.ObservableSource<? extends U>> r8 = r7.n     // Catch:{ all -> 0x007d }
                java.lang.Object r8 = r8.poll()     // Catch:{ all -> 0x007d }
                io.reactivex.rxjava3.core.ObservableSource r8 = (io.reactivex.rxjava3.core.ObservableSource) r8     // Catch:{ all -> 0x007d }
                if (r8 != 0) goto L_0x0076
                int r0 = r7.o     // Catch:{ all -> 0x007d }
                int r0 = r0 - r2
                r7.o = r0     // Catch:{ all -> 0x007d }
                r1 = 1
            L_0x0076:
                monitor-exit(r7)     // Catch:{ all -> 0x007d }
                if (r1 == 0) goto L_0x0000
                r7.c()
                goto L_0x00b4
            L_0x007d:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            L_0x0080:
                io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap$a r0 = new io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap$a
                long r3 = r7.l
                r5 = 1
                long r5 = r5 + r3
                r7.l = r5
                r0.<init>(r7, r3)
            L_0x008c:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap$a<?, ?>[]> r3 = r7.j
                java.lang.Object r3 = r3.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap$a[] r3 = (io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap.a[]) r3
                io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap$a<?, ?>[] r4 = io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap.b.q
                if (r3 != r4) goto L_0x009c
                io.reactivex.rxjava3.internal.disposables.DisposableHelper.dispose(r0)
                goto L_0x00af
            L_0x009c:
                int r4 = r3.length
                int r5 = r4 + 1
                io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap$a[] r5 = new io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap.a[r5]
                java.lang.System.arraycopy(r3, r1, r5, r1, r4)
                r5[r4] = r0
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap$a<?, ?>[]> r4 = r7.j
                boolean r3 = r4.compareAndSet(r3, r5)
                if (r3 == 0) goto L_0x008c
                r1 = 1
            L_0x00af:
                if (r1 == 0) goto L_0x00b4
                r8.subscribe(r0)
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap.b.h(io.reactivex.rxjava3.core.ObservableSource):void");
        }

        public void i(int i2) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 != 0) {
                    synchronized (this) {
                        ObservableSource<? extends U> poll = this.n.poll();
                        if (poll == null) {
                            this.o--;
                        } else {
                            h(poll);
                        }
                    }
                    i2 = i3;
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.g) {
                this.g = true;
                c();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
            } else if (this.h.tryAddThrowableOrReport(th)) {
                this.g = true;
                c();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.g) {
                try {
                    Object apply = this.b.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                    ObservableSource<? extends U> observableSource = (ObservableSource) apply;
                    if (this.d != Integer.MAX_VALUE) {
                        synchronized (this) {
                            int i2 = this.o;
                            if (i2 == this.d) {
                                this.n.offer(observableSource);
                                return;
                            }
                            this.o = i2 + 1;
                        }
                    }
                    h(observableSource);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.k.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
        super(observableSource);
        this.a = function;
        this.b = z;
        this.c = i;
        this.d = i2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (!ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.a)) {
            this.source.subscribe(new b(observer, this.a, this.b, this.c, this.d));
        }
    }
}
