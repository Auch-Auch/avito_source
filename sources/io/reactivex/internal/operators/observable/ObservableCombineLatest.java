package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableCombineLatest<T, R> extends Observable<R> {
    public final ObservableSource<? extends T>[] a;
    public final Iterable<? extends ObservableSource<? extends T>> b;
    public final Function<? super Object[], ? extends R> c;
    public final int d;
    public final boolean e;

    public static final class a<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        public final b<T, R> a;
        public final int b;

        public a(b<T, R> bVar, int i) {
            this.a = bVar;
            this.b = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            if (r4 == r2.length) goto L_0x001d;
         */
        @Override // io.reactivex.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r5 = this;
                io.reactivex.internal.operators.observable.ObservableCombineLatest$b<T, R> r0 = r5.a
                int r1 = r5.b
                monitor-enter(r0)
                java.lang.Object[] r2 = r0.d     // Catch:{ all -> 0x0029 }
                if (r2 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                goto L_0x0028
            L_0x000b:
                r1 = r2[r1]     // Catch:{ all -> 0x0029 }
                r3 = 1
                if (r1 != 0) goto L_0x0012
                r1 = 1
                goto L_0x0013
            L_0x0012:
                r1 = 0
            L_0x0013:
                if (r1 != 0) goto L_0x001d
                int r4 = r0.k     // Catch:{ all -> 0x0029 }
                int r4 = r4 + r3
                r0.k = r4     // Catch:{ all -> 0x0029 }
                int r2 = r2.length     // Catch:{ all -> 0x0029 }
                if (r4 != r2) goto L_0x001f
            L_0x001d:
                r0.h = r3     // Catch:{ all -> 0x0029 }
            L_0x001f:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                if (r1 == 0) goto L_0x0025
                r0.a()
            L_0x0025:
                r0.c()
            L_0x0028:
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.a.onComplete():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            if (r3 == r5.length) goto L_0x0029;
         */
        @Override // io.reactivex.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onError(java.lang.Throwable r5) {
            /*
                r4 = this;
                io.reactivex.internal.operators.observable.ObservableCombineLatest$b<T, R> r0 = r4.a
                int r1 = r4.b
                io.reactivex.internal.util.AtomicThrowable r2 = r0.i
                boolean r2 = r2.addThrowable(r5)
                if (r2 == 0) goto L_0x003a
                boolean r5 = r0.f
                r2 = 1
                if (r5 == 0) goto L_0x0031
                monitor-enter(r0)
                java.lang.Object[] r5 = r0.d     // Catch:{ all -> 0x002e }
                if (r5 != 0) goto L_0x0018
                monitor-exit(r0)     // Catch:{ all -> 0x002e }
                goto L_0x003d
            L_0x0018:
                r1 = r5[r1]     // Catch:{ all -> 0x002e }
                if (r1 != 0) goto L_0x001e
                r1 = 1
                goto L_0x001f
            L_0x001e:
                r1 = 0
            L_0x001f:
                if (r1 != 0) goto L_0x0029
                int r3 = r0.k     // Catch:{ all -> 0x002e }
                int r3 = r3 + r2
                r0.k = r3     // Catch:{ all -> 0x002e }
                int r5 = r5.length     // Catch:{ all -> 0x002e }
                if (r3 != r5) goto L_0x002b
            L_0x0029:
                r0.h = r2     // Catch:{ all -> 0x002e }
            L_0x002b:
                monitor-exit(r0)     // Catch:{ all -> 0x002e }
                r2 = r1
                goto L_0x0031
            L_0x002e:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002e }
                throw r5
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r0.a()
            L_0x0036:
                r0.c()
                goto L_0x003d
            L_0x003a:
                io.reactivex.plugins.RxJavaPlugins.onError(r5)
            L_0x003d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.a.onError(java.lang.Throwable):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object[]> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            boolean z;
            b<T, R> bVar = this.a;
            int i = this.b;
            synchronized (bVar) {
                Object[] objArr = bVar.d;
                if (objArr != null) {
                    Object obj = objArr[i];
                    int i2 = bVar.j;
                    if (obj == null) {
                        i2++;
                        bVar.j = i2;
                    }
                    objArr[i] = t;
                    if (i2 == objArr.length) {
                        bVar.e.offer(objArr.clone());
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    return;
                }
            }
            if (z) {
                bVar.c();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class b<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        public final Observer<? super R> a;
        public final Function<? super Object[], ? extends R> b;
        public final a<T, R>[] c;
        public Object[] d;
        public final SpscLinkedArrayQueue<Object[]> e;
        public final boolean f;
        public volatile boolean g;
        public volatile boolean h;
        public final AtomicThrowable i = new AtomicThrowable();
        public int j;
        public int k;

        public b(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z) {
            this.a = observer;
            this.b = function;
            this.f = z;
            this.d = new Object[i2];
            a<T, R>[] aVarArr = new a[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                aVarArr[i4] = new a<>(this, i4);
            }
            this.c = aVarArr;
            this.e = new SpscLinkedArrayQueue<>(i3);
        }

        public void a() {
            a<T, R>[] aVarArr = this.c;
            for (a<T, R> aVar : aVarArr) {
                Objects.requireNonNull(aVar);
                DisposableHelper.dispose(aVar);
            }
        }

        public void b(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.d = null;
            }
            spscLinkedArrayQueue.clear();
        }

        public void c() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object[]> spscLinkedArrayQueue = this.e;
                Observer<? super R> observer = this.a;
                boolean z = this.f;
                int i2 = 1;
                while (!this.g) {
                    if (z || this.i.get() == null) {
                        boolean z2 = this.h;
                        Object[] poll = spscLinkedArrayQueue.poll();
                        boolean z3 = poll == null;
                        if (z2 && z3) {
                            b(spscLinkedArrayQueue);
                            Throwable terminate = this.i.terminate();
                            if (terminate == null) {
                                observer.onComplete();
                                return;
                            } else {
                                observer.onError(terminate);
                                return;
                            }
                        } else if (z3) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            try {
                                observer.onNext((Object) ObjectHelper.requireNonNull(this.b.apply(poll), "The combiner returned a null value"));
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.i.addThrowable(th);
                                a();
                                b(spscLinkedArrayQueue);
                                observer.onError(this.i.terminate());
                                return;
                            }
                        }
                    } else {
                        a();
                        b(spscLinkedArrayQueue);
                        observer.onError(this.i.terminate());
                        return;
                    }
                }
                b(spscLinkedArrayQueue);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.g) {
                this.g = true;
                a();
                if (getAndIncrement() == 0) {
                    b(this.e);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.a = observableSourceArr;
        this.b = iterable;
        this.c = function;
        this.d = i;
        this.e = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int i;
        ObservableSource<? extends T>[] observableSourceArr = this.a;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            i = 0;
            for (ObservableSource<? extends T> observableSource : this.b) {
                if (i == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i >> 2) + i)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i] = observableSource;
                i++;
            }
        } else {
            i = observableSourceArr.length;
        }
        if (i == 0) {
            EmptyDisposable.complete(observer);
            return;
        }
        b bVar = new b(observer, this.c, i, this.d, this.e);
        a<T, R>[] aVarArr = bVar.c;
        int length = aVarArr.length;
        bVar.a.onSubscribe(bVar);
        for (int i2 = 0; i2 < length && !bVar.h && !bVar.g; i2++) {
            observableSourceArr[i2].subscribe(aVarArr[i2]);
        }
    }
}
