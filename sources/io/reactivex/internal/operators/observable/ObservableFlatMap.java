package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableFlatMap<T, U> extends s6.a.c.b.c.a<T, U> {
    public final Function<? super T, ? extends ObservableSource<? extends U>> a;
    public final boolean b;
    public final int c;
    public final int d;

    public static final class a<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        public final long a;
        public final b<T, U> b;
        public volatile boolean c;
        public volatile SimpleQueue<U> d;
        public int e;

        public a(b<T, U> bVar, long j) {
            this.a = j;
            this.b = bVar;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.c = true;
            this.b.c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.b.h.addThrowable(th)) {
                b<T, U> bVar = this.b;
                if (!bVar.c) {
                    bVar.b();
                }
                this.c = true;
                this.b.c();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            if (this.e == 0) {
                b<T, U> bVar = this.b;
                if (bVar.get() != 0 || !bVar.compareAndSet(0, 1)) {
                    SimpleQueue simpleQueue = this.d;
                    if (simpleQueue == null) {
                        simpleQueue = new SpscLinkedArrayQueue(bVar.e);
                        this.d = simpleQueue;
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
            this.b.c();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.e = requestFusion;
                    this.d = queueDisposable;
                    this.c = true;
                    this.b.c();
                } else if (requestFusion == 2) {
                    this.e = requestFusion;
                    this.d = queueDisposable;
                }
            }
        }
    }

    public static final class b<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        public static final a<?, ?>[] q = new a[0];
        public static final a<?, ?>[] r = new a[0];
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
        public long m;
        public int n;
        public Queue<ObservableSource<? extends U>> o;
        public int p;

        public b(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i2, int i3) {
            this.a = observer;
            this.b = function;
            this.c = z;
            this.d = i2;
            this.e = i3;
            if (i2 != Integer.MAX_VALUE) {
                this.o = new ArrayDeque(i2);
            }
            this.j = new AtomicReference<>(q);
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
            Throwable terminate = this.h.terminate();
            if (terminate != ExceptionHelper.TERMINATED) {
                this.a.onError(terminate);
            }
            return true;
        }

        public boolean b() {
            a<?, ?>[] andSet;
            this.k.dispose();
            a<?, ?>[] aVarArr = this.j.get();
            a<?, ?>[] aVarArr2 = r;
            if (aVarArr == aVarArr2 || (andSet = this.j.getAndSet(aVarArr2)) == aVarArr2) {
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Throwable terminate;
            if (!this.i) {
                this.i = true;
                if (b() && (terminate = this.h.terminate()) != null && terminate != ExceptionHelper.TERMINATED) {
                    RxJavaPlugins.onError(terminate);
                }
            }
        }

        public void e() {
            int i2;
            Observer<? super U> observer = this.a;
            int i3 = 1;
            while (!a()) {
                SimplePlainQueue<U> simplePlainQueue = this.f;
                if (simplePlainQueue != null) {
                    while (!a()) {
                        U poll = simplePlainQueue.poll();
                        if (poll != null) {
                            observer.onNext(poll);
                        }
                    }
                    return;
                }
                boolean z = this.g;
                SimplePlainQueue<U> simplePlainQueue2 = this.f;
                a<?, ?>[] aVarArr = this.j.get();
                int length = aVarArr.length;
                int i4 = 0;
                if (this.d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        i2 = this.o.size();
                    }
                } else {
                    i2 = 0;
                }
                if (!z || !((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i2 == 0)) {
                    if (length != 0) {
                        long j2 = this.m;
                        int i5 = this.n;
                        if (length <= i5 || aVarArr[i5].a != j2) {
                            if (length <= i5) {
                                i5 = 0;
                            }
                            for (int i6 = 0; i6 < length && aVarArr[i5].a != j2; i6++) {
                                i5++;
                                if (i5 == length) {
                                    i5 = 0;
                                }
                            }
                            this.n = i5;
                            this.m = aVarArr[i5].a;
                        }
                        int i7 = 0;
                        for (int i8 = 0; i8 < length; i8++) {
                            if (!a()) {
                                a<T, U> aVar = aVarArr[i5];
                                SimpleQueue<U> simpleQueue = aVar.d;
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
                                            this.h.addThrowable(th);
                                            if (!a()) {
                                                f(aVar);
                                                i7++;
                                                i5++;
                                                if (i5 != length) {
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                }
                                boolean z2 = aVar.c;
                                SimpleQueue<U> simpleQueue2 = aVar.d;
                                if (z2 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                    f(aVar);
                                    if (!a()) {
                                        i7++;
                                    } else {
                                        return;
                                    }
                                }
                                i5++;
                                if (i5 != length) {
                                }
                                i5 = 0;
                            } else {
                                return;
                            }
                        }
                        this.n = i5;
                        this.m = aVarArr[i5].a;
                        i4 = i7;
                    }
                    if (i4 == 0) {
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else if (this.d != Integer.MAX_VALUE) {
                        while (true) {
                            int i9 = i4 - 1;
                            if (i4 == 0) {
                                continue;
                                break;
                            }
                            synchronized (this) {
                                ObservableSource<? extends U> poll3 = this.o.poll();
                                if (poll3 == null) {
                                    this.p--;
                                } else {
                                    h(poll3);
                                }
                            }
                            i4 = i9;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Throwable terminate = this.h.terminate();
                    if (terminate == ExceptionHelper.TERMINATED) {
                        return;
                    }
                    if (terminate == null) {
                        observer.onComplete();
                        return;
                    } else {
                        observer.onError(terminate);
                        return;
                    }
                }
            }
        }

        public void f(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.j.get();
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
                        if (length == 1) {
                            aVarArr2 = q;
                        } else {
                            a<?, ?>[] aVarArr3 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                            System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.j.compareAndSet(aVarArr, aVarArr2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v8, types: [io.reactivex.internal.fuseable.SimpleQueue] */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            if (decrementAndGet() == 0) goto L_0x006c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h(io.reactivex.ObservableSource<? extends U> r8) {
            /*
                r7 = this;
            L_0x0000:
                boolean r0 = r8 instanceof java.util.concurrent.Callable
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x008e
                java.util.concurrent.Callable r8 = (java.util.concurrent.Callable) r8
                r0 = 2147483647(0x7fffffff, float:NaN)
                java.lang.Object r8 = r8.call()     // Catch:{ all -> 0x0060 }
                if (r8 != 0) goto L_0x0012
            L_0x0011:
                goto L_0x006c
            L_0x0012:
                int r3 = r7.get()
                if (r3 != 0) goto L_0x002a
                boolean r3 = r7.compareAndSet(r1, r2)
                if (r3 == 0) goto L_0x002a
                io.reactivex.Observer<? super U> r3 = r7.a
                r3.onNext(r8)
                int r8 = r7.decrementAndGet()
                if (r8 != 0) goto L_0x005c
                goto L_0x0011
            L_0x002a:
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r3 = r7.f
                if (r3 != 0) goto L_0x0043
                int r3 = r7.d
                if (r3 != r0) goto L_0x003a
                io.reactivex.internal.queue.SpscLinkedArrayQueue r3 = new io.reactivex.internal.queue.SpscLinkedArrayQueue
                int r4 = r7.e
                r3.<init>(r4)
                goto L_0x0041
            L_0x003a:
                io.reactivex.internal.queue.SpscArrayQueue r3 = new io.reactivex.internal.queue.SpscArrayQueue
                int r4 = r7.d
                r3.<init>(r4)
            L_0x0041:
                r7.f = r3
            L_0x0043:
                boolean r8 = r3.offer(r8)
                if (r8 != 0) goto L_0x0054
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r3 = "Scalar queue full?!"
                r8.<init>(r3)
                r7.onError(r8)
                goto L_0x006c
            L_0x0054:
                int r8 = r7.getAndIncrement()
                if (r8 == 0) goto L_0x005c
                r8 = 0
                goto L_0x006d
            L_0x005c:
                r7.e()
                goto L_0x006c
            L_0x0060:
                r8 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r8)
                io.reactivex.internal.util.AtomicThrowable r3 = r7.h
                r3.addThrowable(r8)
                r7.c()
            L_0x006c:
                r8 = 1
            L_0x006d:
                if (r8 == 0) goto L_0x00c2
                int r8 = r7.d
                if (r8 == r0) goto L_0x00c2
                monitor-enter(r7)
                java.util.Queue<io.reactivex.ObservableSource<? extends U>> r8 = r7.o     // Catch:{ all -> 0x008b }
                java.lang.Object r8 = r8.poll()     // Catch:{ all -> 0x008b }
                io.reactivex.ObservableSource r8 = (io.reactivex.ObservableSource) r8     // Catch:{ all -> 0x008b }
                if (r8 != 0) goto L_0x0084
                int r0 = r7.p     // Catch:{ all -> 0x008b }
                int r0 = r0 - r2
                r7.p = r0     // Catch:{ all -> 0x008b }
                r1 = 1
            L_0x0084:
                monitor-exit(r7)     // Catch:{ all -> 0x008b }
                if (r1 == 0) goto L_0x0000
                r7.c()
                goto L_0x00c2
            L_0x008b:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            L_0x008e:
                io.reactivex.internal.operators.observable.ObservableFlatMap$a r0 = new io.reactivex.internal.operators.observable.ObservableFlatMap$a
                long r3 = r7.l
                r5 = 1
                long r5 = r5 + r3
                r7.l = r5
                r0.<init>(r7, r3)
            L_0x009a:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableFlatMap$a<?, ?>[]> r3 = r7.j
                java.lang.Object r3 = r3.get()
                io.reactivex.internal.operators.observable.ObservableFlatMap$a[] r3 = (io.reactivex.internal.operators.observable.ObservableFlatMap.a[]) r3
                io.reactivex.internal.operators.observable.ObservableFlatMap$a<?, ?>[] r4 = io.reactivex.internal.operators.observable.ObservableFlatMap.b.r
                if (r3 != r4) goto L_0x00aa
                io.reactivex.internal.disposables.DisposableHelper.dispose(r0)
                goto L_0x00bd
            L_0x00aa:
                int r4 = r3.length
                int r5 = r4 + 1
                io.reactivex.internal.operators.observable.ObservableFlatMap$a[] r5 = new io.reactivex.internal.operators.observable.ObservableFlatMap.a[r5]
                java.lang.System.arraycopy(r3, r1, r5, r1, r4)
                r5[r4] = r0
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableFlatMap$a<?, ?>[]> r4 = r7.j
                boolean r3 = r4.compareAndSet(r3, r5)
                if (r3 == 0) goto L_0x009a
                r1 = 1
            L_0x00bd:
                if (r1 == 0) goto L_0x00c2
                r8.subscribe(r0)
            L_0x00c2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.b.h(io.reactivex.ObservableSource):void");
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.g) {
                this.g = true;
                c();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
            } else if (this.h.addThrowable(th)) {
                this.g = true;
                c();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.g) {
                try {
                    ObservableSource<? extends U> observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null ObservableSource");
                    if (this.d != Integer.MAX_VALUE) {
                        synchronized (this) {
                            int i2 = this.p;
                            if (i2 == this.d) {
                                this.o.offer(observableSource);
                                return;
                            }
                            this.p = i2 + 1;
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

        @Override // io.reactivex.Observer
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

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (!ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.a)) {
            this.source.subscribe(new b(observer, this.a, this.b, this.c, this.d));
        }
    }
}
