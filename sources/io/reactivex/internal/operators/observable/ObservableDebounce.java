package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableDebounce<T, U> extends s6.a.c.b.c.a<T, T> {
    public final Function<? super T, ? extends ObservableSource<U>> a;

    public static final class a<T, U> implements Observer<T>, Disposable {
        public final Observer<? super T> a;
        public final Function<? super T, ? extends ObservableSource<U>> b;
        public Disposable c;
        public final AtomicReference<Disposable> d = new AtomicReference<>();
        public volatile long e;
        public boolean f;

        /* renamed from: io.reactivex.internal.operators.observable.ObservableDebounce$a$a  reason: collision with other inner class name */
        public static final class C0416a<T, U> extends DisposableObserver<U> {
            public final a<T, U> b;
            public final long c;
            public final T d;
            public boolean e;
            public final AtomicBoolean f = new AtomicBoolean();

            public C0416a(a<T, U> aVar, long j, T t) {
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

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (!this.e) {
                    this.e = true;
                    a();
                }
            }

            @Override // io.reactivex.Observer
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

            @Override // io.reactivex.Observer
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
            DisposableHelper.dispose(this.d);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f) {
                this.f = true;
                Disposable disposable = this.d.get();
                if (disposable != DisposableHelper.DISPOSED) {
                    C0416a aVar = (C0416a) disposable;
                    if (aVar != null) {
                        aVar.a();
                    }
                    DisposableHelper.dispose(this.d);
                    this.a.onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.d);
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.f) {
                long j = this.e + 1;
                this.e = j;
                Disposable disposable = this.d.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The ObservableSource supplied is null");
                    C0416a aVar = new C0416a(this, j, t);
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

        @Override // io.reactivex.Observer
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

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(new SerializedObserver(observer), this.a));
    }
}
