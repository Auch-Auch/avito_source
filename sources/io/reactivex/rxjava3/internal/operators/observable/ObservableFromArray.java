package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Objects;
public final class ObservableFromArray<T> extends Observable<T> {
    public final T[] a;

    public static final class a<T> extends BasicQueueDisposable<T> {
        public final Observer<? super T> a;
        public final T[] b;
        public int c;
        public boolean d;
        public volatile boolean e;

        public a(Observer<? super T> observer, T[] tArr) {
            this.a = observer;
            this.b = tArr;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.c = this.b.length;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.e = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.c == this.b.length;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            int i = this.c;
            T[] tArr = this.b;
            if (i == tArr.length) {
                return null;
            }
            this.c = i + 1;
            T t = tArr[i];
            Objects.requireNonNull(t, "The array element is null");
            return t;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.d = true;
            return 1;
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.a = tArr;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer, this.a);
        observer.onSubscribe(aVar);
        if (!aVar.d) {
            T[] tArr = aVar.b;
            int length = tArr.length;
            for (int i = 0; i < length && !aVar.e; i++) {
                T t = tArr[i];
                if (t == null) {
                    aVar.a.onError(new NullPointerException(a2.b.a.a.a.Q2("The element at index ", i, " is null")));
                    return;
                } else {
                    aVar.a.onNext(t);
                }
            }
            if (!aVar.e) {
                aVar.a.onComplete();
            }
        }
    }
}
