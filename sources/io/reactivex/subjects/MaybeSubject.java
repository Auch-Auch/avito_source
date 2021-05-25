package io.reactivex.subjects;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class MaybeSubject<T> extends Maybe<T> implements MaybeObserver<T> {
    public static final a[] e = new a[0];
    public static final a[] f = new a[0];
    public final AtomicReference<a<T>[]> a = new AtomicReference<>(e);
    public final AtomicBoolean b = new AtomicBoolean();
    public T c;
    public Throwable d;

    public static final class a<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        public final MaybeObserver<? super T> a;

        public a(MaybeObserver<? super T> maybeObserver, MaybeSubject<T> maybeSubject) {
            this.a = maybeObserver;
            lazySet(maybeSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeSubject maybeSubject = (MaybeSubject) getAndSet(null);
            if (maybeSubject != null) {
                maybeSubject.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> MaybeSubject<T> create() {
        return new MaybeSubject<>();
    }

    public void a(a<T> aVar) {
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

    public boolean hasComplete() {
        return this.a.get() == f && this.c == null && this.d == null;
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

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        if (this.b.compareAndSet(false, true)) {
            for (a<T> aVar : this.a.getAndSet(f)) {
                aVar.a.onComplete();
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.b.compareAndSet(false, true)) {
            this.d = th;
            for (a<T> aVar : this.a.getAndSet(f)) {
                aVar.a.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        if (this.a.get() == f) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.b.compareAndSet(false, true)) {
            this.c = t;
            for (a<T> aVar : this.a.getAndSet(f)) {
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
                maybeObserver.onError(th);
                return;
            }
            T t = this.c;
            if (t == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(t);
            }
        } else if (aVar.isDisposed()) {
            a(aVar);
        }
    }
}
