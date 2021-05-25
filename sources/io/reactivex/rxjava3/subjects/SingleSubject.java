package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {
    public static final a[] e = new a[0];
    public static final a[] f = new a[0];
    public final AtomicReference<a<T>[]> a = new AtomicReference<>(e);
    public final AtomicBoolean b = new AtomicBoolean();
    public T c;
    public Throwable d;

    public static final class a<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        public final SingleObserver<? super T> a;

        public a(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.a = singleObserver;
            lazySet(singleSubject);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            SingleSubject singleSubject = (SingleSubject) getAndSet(null);
            if (singleSubject != null) {
                singleSubject.c(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> SingleSubject<T> create() {
        return new SingleSubject<>();
    }

    public void c(@NonNull a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.a.get();
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
        } while (!this.a.compareAndSet(aVarArr, aVarArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.a.get() == f) {
            return this.d;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.a.get() == f) {
            return this.c;
        }
        return null;
    }

    public boolean hasObservers() {
        return this.a.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.a.get() == f && this.d != null;
    }

    public boolean hasValue() {
        return this.a.get() == f && this.c != null;
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onError(@NonNull Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (this.b.compareAndSet(false, true)) {
            this.d = th;
            for (a<T> aVar : this.a.getAndSet(f)) {
                aVar.a.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSubscribe(@NonNull Disposable disposable) {
        if (this.a.get() == f) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "onSuccess called with a null value.");
        if (this.b.compareAndSet(false, true)) {
            this.c = t;
            for (a<T> aVar : this.a.getAndSet(f)) {
                aVar.a.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(@NonNull SingleObserver<? super T> singleObserver) {
        boolean z;
        a<T> aVar = new a<>(singleObserver, this);
        singleObserver.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.a.get();
            z = false;
            if (aVarArr != f) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.a.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            Throwable th = this.d;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess(this.c);
            }
        } else if (aVar.isDisposed()) {
            c(aVar);
        }
    }
}
