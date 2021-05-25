package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
public final class ObservableElementAt<T> extends s6.a.e.d.c.c.a<T, T> {
    public final long a;
    public final T b;
    public final boolean c;

    public static final class a<T> implements Observer<T>, Disposable {
        public final Observer<? super T> a;
        public final long b;
        public final T c;
        public final boolean d;
        public Disposable e;
        public long f;
        public boolean g;

        public a(Observer<? super T> observer, long j, T t, boolean z) {
            this.a = observer;
            this.b = j;
            this.c = t;
            this.d = z;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.e.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.g) {
                this.g = true;
                T t = this.c;
                if (t != null || !this.d) {
                    if (t != null) {
                        this.a.onNext(t);
                    }
                    this.a.onComplete();
                    return;
                }
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = true;
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.g) {
                long j = this.f;
                if (j == this.b) {
                    this.g = true;
                    this.e.dispose();
                    this.a.onNext(t);
                    this.a.onComplete();
                    return;
                }
                this.f = j + 1;
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j, T t, boolean z) {
        super(observableSource);
        this.a = j;
        this.b = t;
        this.c = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a, this.b, this.c));
    }
}
