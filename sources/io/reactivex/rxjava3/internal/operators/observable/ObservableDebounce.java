package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableDebounce<T, U> extends s6.a.e.d.c.c.a<T, T> {
    public final Function<? super T, ? extends ObservableSource<U>> a;

    public static final class a<T, U> implements Observer<T>, Disposable {
        public final Observer<? super T> a;
        public final Function<? super T, ? extends ObservableSource<U>> b;
        public Disposable c;
        public final AtomicReference<Disposable> d = new AtomicReference<>();
        public volatile long e;
        public boolean f;

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.ObservableDebounce$a$a  reason: collision with other inner class name */
        public static final class C0481a<T, U> extends DisposableObserver<U> {
            public final a<T, U> b;
            public final long c;
            public final T d;
            public boolean e;
            public final AtomicBoolean f = new AtomicBoolean();

            public C0481a(a<T, U> aVar, long j, T t) {
                this.b = aVar;
                this.c = j;
                this.d = t;
            }

            public void a() {
                if (this.f.compareAndSet(false, true)) {
                    a<T, U> aVar = this.b;
                    long j = this.c;
                    T t = this.d;
                    if (j == aVar.e) {
                        aVar.a.onNext(t);
                    }
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                if (!this.e) {
                    this.e = true;
                    a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                if (this.e) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.e = true;
                a<T, U> aVar = this.b;
                DisposableHelper.dispose(aVar.d);
                aVar.a.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(U u) {
                if (!this.e) {
                    this.e = true;
                    dispose();
                    a();
                }
            }
        }

        public a(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.a = observer;
            this.b = function;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.c.dispose();
            DisposableHelper.dispose(this.d);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.f) {
                this.f = true;
                Disposable disposable = this.d.get();
                if (disposable != DisposableHelper.DISPOSED) {
                    C0481a aVar = (C0481a) disposable;
                    if (aVar != null) {
                        aVar.a();
                    }
                    DisposableHelper.dispose(this.d);
                    this.a.onComplete();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.d);
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.f) {
                long j = this.e + 1;
                this.e = j;
                Disposable disposable = this.d.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    Object apply = this.b.apply(t);
                    Objects.requireNonNull(apply, "The ObservableSource supplied is null");
                    ObservableSource observableSource = (ObservableSource) apply;
                    C0481a aVar = new C0481a(this, j, t);
                    if (this.d.compareAndSet(disposable, aVar)) {
                        observableSource.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    this.a.onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.a = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(new SerializedObserver(observer), this.a));
    }
}
