package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
public final class AsyncSubject<T> extends Subject<T> {
    public static final a[] d = new a[0];
    public static final a[] e = new a[0];
    public final AtomicReference<a<T>[]> a = new AtomicReference<>(d);
    public Throwable b;
    public T c;

    public static final class a<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        public final AsyncSubject<T> a;

        public a(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            this.a = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            if (super.tryDispose()) {
                this.a.a(this);
            }
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> AsyncSubject<T> create() {
        return new AsyncSubject<>();
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
                        aVarArr2 = d;
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

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        if (this.a.get() == e) {
            return this.b;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.a.get() == e) {
            return this.c;
        }
        return null;
    }

    @Deprecated
    public Object[] getValues() {
        T value = getValue();
        return value != null ? new Object[]{value} : new Object[0];
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.a.get() == e && this.b == null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.a.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.a.get() == e && this.b != null;
    }

    public boolean hasValue() {
        return this.a.get() == e && this.c != null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        a<T>[] aVarArr = this.a.get();
        a<T>[] aVarArr2 = e;
        if (aVarArr != aVarArr2) {
            T t = this.c;
            a<T>[] andSet = this.a.getAndSet(aVarArr2);
            int i = 0;
            if (t == null) {
                int length = andSet.length;
                while (i < length) {
                    a<T> aVar = andSet[i];
                    if (!aVar.isDisposed()) {
                        aVar.downstream.onComplete();
                    }
                    i++;
                }
                return;
            }
            int length2 = andSet.length;
            while (i < length2) {
                andSet[i].complete(t);
                i++;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a<T>[] aVarArr = this.a.get();
        a<T>[] aVarArr2 = e;
        if (aVarArr == aVarArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.c = null;
        this.b = th;
        a<T>[] andSet = this.a.getAndSet(aVarArr2);
        for (a<T> aVar : andSet) {
            if (aVar.isDisposed()) {
                RxJavaPlugins.onError(th);
            } else {
                aVar.downstream.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.a.get() != e) {
            this.c = t;
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.a.get() == e) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        boolean z;
        a<T> aVar = new a<>(observer, this);
        observer.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.a.get();
            z = false;
            if (aVarArr != e) {
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
            Throwable th = this.b;
            if (th != null) {
                observer.onError(th);
                return;
            }
            T t = this.c;
            if (t != null) {
                aVar.complete(t);
            } else if (!aVar.isDisposed()) {
                aVar.downstream.onComplete();
            }
        } else if (aVar.isDisposed()) {
            a(aVar);
        }
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }
}
