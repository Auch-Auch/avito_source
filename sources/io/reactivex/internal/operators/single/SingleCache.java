package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {
    public static final a[] f = new a[0];
    public static final a[] g = new a[0];
    public final SingleSource<? extends T> a;
    public final AtomicInteger b = new AtomicInteger();
    public final AtomicReference<a<T>[]> c = new AtomicReference<>(f);
    public T d;
    public Throwable e;

    public static final class a<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;
        public final SingleObserver<? super T> a;
        public final SingleCache<T> b;

        public a(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.a = singleObserver;
            this.b = singleCache;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.b.c(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.a = singleSource;
    }

    public void c(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.c.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (aVarArr[i] == aVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        aVarArr2 = f;
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
        } while (!this.c.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.e = th;
        a<T>[] andSet = this.c.getAndSet(g);
        for (a<T> aVar : andSet) {
            if (!aVar.get()) {
                aVar.a.onError(th);
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        this.d = t;
        a<T>[] andSet = this.c.getAndSet(g);
        for (a<T> aVar : andSet) {
            if (!aVar.get()) {
                aVar.a.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        boolean z;
        a<T> aVar = new a<>(singleObserver, this);
        singleObserver.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.c.get();
            z = false;
            if (aVarArr != g) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.c.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            if (aVar.get()) {
                c(aVar);
            }
            if (this.b.getAndIncrement() == 0) {
                this.a.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.e;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess(this.d);
        }
    }
}
