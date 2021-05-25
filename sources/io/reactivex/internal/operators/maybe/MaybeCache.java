package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {
    public static final a[] e = new a[0];
    public static final a[] f = new a[0];
    public final AtomicReference<MaybeSource<T>> a;
    public final AtomicReference<a<T>[]> b = new AtomicReference<>(e);
    public T c;
    public Throwable d;

    public static final class a<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;
        public final MaybeObserver<? super T> a;

        public a(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.a = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeCache maybeCache = (MaybeCache) getAndSet(null);
            if (maybeCache != null) {
                maybeCache.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public MaybeCache(MaybeSource<T> maybeSource) {
        this.a = new AtomicReference<>(maybeSource);
    }

    public void a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.b.get();
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
                        aVarArr2 = e;
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
        } while (!this.b.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        a<T>[] andSet = this.b.getAndSet(f);
        for (a<T> aVar : andSet) {
            if (!aVar.isDisposed()) {
                aVar.a.onComplete();
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        this.d = th;
        a<T>[] andSet = this.b.getAndSet(f);
        for (a<T> aVar : andSet) {
            if (!aVar.isDisposed()) {
                aVar.a.onError(th);
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        this.c = t;
        a<T>[] andSet = this.b.getAndSet(f);
        for (a<T> aVar : andSet) {
            if (!aVar.isDisposed()) {
                aVar.a.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        boolean z;
        a<T> aVar = new a<>(maybeObserver, this);
        maybeObserver.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.b.get();
            z = false;
            if (aVarArr != f) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.b.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            if (aVar.isDisposed()) {
                a(aVar);
                return;
            }
            MaybeSource<T> andSet = this.a.getAndSet(null);
            if (andSet != null) {
                andSet.subscribe(this);
            }
        } else if (!aVar.isDisposed()) {
            Throwable th = this.d;
            if (th != null) {
                maybeObserver.onError(th);
                return;
            }
            T t = this.c;
            if (t != null) {
                maybeObserver.onSuccess(t);
            } else {
                maybeObserver.onComplete();
            }
        }
    }
}
