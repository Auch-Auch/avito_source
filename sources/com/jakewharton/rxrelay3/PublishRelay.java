package com.jakewharton.rxrelay3;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class PublishRelay<T> extends Relay<T> {
    public static final a[] b = new a[0];
    public final AtomicReference<a<T>[]> a = new AtomicReference<>(b);

    public static final class a<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        public final Observer<? super T> a;
        public final PublishRelay<T> b;

        public a(Observer<? super T> observer, PublishRelay<T> publishRelay) {
            this.a = observer;
            this.b = publishRelay;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.b.e(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> PublishRelay<T> create() {
        return new PublishRelay<>();
    }

    @Override // com.jakewharton.rxrelay3.Relay, io.reactivex.rxjava3.functions.Consumer
    public void accept(T t) {
        Objects.requireNonNull(t, "value == null");
        a<T>[] aVarArr = this.a.get();
        for (a<T> aVar : aVarArr) {
            if (!aVar.get()) {
                aVar.a.onNext(t);
            }
        }
    }

    public void e(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.a.get();
            if (aVarArr != b) {
                int length = aVarArr.length;
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
                        aVarArr2 = b;
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

    @Override // com.jakewharton.rxrelay3.Relay
    public boolean hasObservers() {
        return this.a.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        a<T> aVar = new a<>(observer, this);
        observer.onSubscribe(aVar);
        do {
            aVarArr = this.a.get();
            int length = aVarArr.length;
            aVarArr2 = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.a.compareAndSet(aVarArr, aVarArr2));
        if (aVar.get()) {
            e(aVar);
        }
    }
}
