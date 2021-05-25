package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableCache<T> extends s6.a.c.b.c.a<T, T> implements Observer<T> {
    public static final a[] j = new a[0];
    public static final a[] k = new a[0];
    public final AtomicBoolean a = new AtomicBoolean();
    public final int b;
    public final AtomicReference<a<T>[]> c;
    public volatile long d;
    public final b<T> e;
    public b<T> f;
    public int g;
    public Throwable h;
    public volatile boolean i;

    public static final class a<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        public final Observer<? super T> a;
        public final ObservableCache<T> b;
        public b<T> c;
        public int d;
        public long e;
        public volatile boolean f;

        public a(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.a = observer;
            this.b = observableCache;
            this.c = observableCache.e;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            if (!this.f) {
                this.f = true;
                ObservableCache<T> observableCache = this.b;
                do {
                    aVarArr = observableCache.c.get();
                    int length = aVarArr.length;
                    if (length != 0) {
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                i = -1;
                                break;
                            } else if (aVarArr[i] == this) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i >= 0) {
                            if (length == 1) {
                                aVarArr2 = ObservableCache.j;
                            } else {
                                a<T>[] aVarArr3 = new a[(length - 1)];
                                System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                                System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                                aVarArr2 = aVarArr3;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!observableCache.c.compareAndSet(aVarArr, aVarArr2));
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f;
        }
    }

    public static final class b<T> {
        public final T[] a;
        public volatile b<T> b;

        public b(int i) {
            this.a = (T[]) new Object[i];
        }
    }

    public ObservableCache(Observable<T> observable, int i2) {
        super(observable);
        this.b = i2;
        b<T> bVar = new b<>(i2);
        this.e = bVar;
        this.f = bVar;
        this.c = new AtomicReference<>(j);
    }

    public void a(a<T> aVar) {
        if (aVar.getAndIncrement() == 0) {
            long j2 = aVar.e;
            int i2 = aVar.d;
            b<T> bVar = aVar.c;
            Observer<? super T> observer = aVar.a;
            int i3 = this.b;
            int i4 = 1;
            while (!aVar.f) {
                boolean z = this.i;
                boolean z2 = this.d == j2;
                if (z && z2) {
                    aVar.c = null;
                    Throwable th = this.h;
                    if (th != null) {
                        observer.onError(th);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z2) {
                    if (i2 == i3) {
                        bVar = bVar.b;
                        i2 = 0;
                    }
                    observer.onNext(bVar.a[i2]);
                    i2++;
                    j2++;
                } else {
                    aVar.e = j2;
                    aVar.d = i2;
                    aVar.c = bVar;
                    i4 = aVar.addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                }
            }
            aVar.c = null;
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.i = true;
        for (a<T> aVar : this.c.getAndSet(k)) {
            a(aVar);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.h = th;
        this.i = true;
        for (a<T> aVar : this.c.getAndSet(k)) {
            a(aVar);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        int i2 = this.g;
        if (i2 == this.b) {
            b<T> bVar = new b<>(i2);
            bVar.a[0] = t;
            this.g = 1;
            this.f.b = bVar;
            this.f = bVar;
        } else {
            this.f.a[i2] = t;
            this.g = i2 + 1;
        }
        this.d++;
        for (a<T> aVar : this.c.get()) {
            a(aVar);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        a<T> aVar = new a<>(observer, this);
        observer.onSubscribe(aVar);
        do {
            aVarArr = this.c.get();
            if (aVarArr == k) {
                break;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.c.compareAndSet(aVarArr, aVarArr2));
        if (this.a.get() || !this.a.compareAndSet(false, true)) {
            a(aVar);
        } else {
            this.source.subscribe(this);
        }
    }
}
