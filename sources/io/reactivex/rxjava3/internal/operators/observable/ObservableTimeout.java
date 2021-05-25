package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableTimeout<T, U, V> extends s6.a.e.d.c.c.a<T, T> {
    public final ObservableSource<U> a;
    public final Function<? super T, ? extends ObservableSource<V>> b;
    public final ObservableSource<? extends T> c;

    public static final class a extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;
        public final d a;
        public final long b;

        public a(long j, d dVar) {
            this.b = j;
            this.a = dVar;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.a.b(this.b);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.a.a(this.b, th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                disposable.dispose();
                lazySet(disposableHelper);
                this.a.b(this.b);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class b<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, d {
        private static final long serialVersionUID = -7508389464265974549L;
        public final Observer<? super T> a;
        public final Function<? super T, ? extends ObservableSource<?>> b;
        public final SequentialDisposable c = new SequentialDisposable();
        public final AtomicLong d;
        public final AtomicReference<Disposable> e;
        public ObservableSource<? extends T> f;

        public b(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function, ObservableSource<? extends T> observableSource) {
            this.a = observer;
            this.b = function;
            this.f = observableSource;
            this.d = new AtomicLong();
            this.e = new AtomicReference<>();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout.d
        public void a(long j, Throwable th) {
            if (this.d.compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this);
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed.d
        public void b(long j) {
            if (this.d.compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.e);
                ObservableSource<? extends T> observableSource = this.f;
                this.f = null;
                observableSource.subscribe(new ObservableTimeoutTimed.a(this.a, this));
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.e);
            DisposableHelper.dispose(this);
            this.c.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.d.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.c.dispose();
                this.a.onComplete();
                this.c.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.d.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.c.dispose();
                this.a.onError(th);
                this.c.dispose();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            long j = this.d.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.d.compareAndSet(j, j2)) {
                    Disposable disposable = (Disposable) this.c.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.a.onNext(t);
                    try {
                        Object apply = this.b.apply(t);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        ObservableSource observableSource = (ObservableSource) apply;
                        a aVar = new a(j2, this);
                        if (this.c.replace(aVar)) {
                            observableSource.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.e.get().dispose();
                        this.d.getAndSet(Long.MAX_VALUE);
                        this.a.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.e, disposable);
        }
    }

    public static final class c<T> extends AtomicLong implements Observer<T>, Disposable, d {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Observer<? super T> a;
        public final Function<? super T, ? extends ObservableSource<?>> b;
        public final SequentialDisposable c = new SequentialDisposable();
        public final AtomicReference<Disposable> d = new AtomicReference<>();

        public c(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function) {
            this.a = observer;
            this.b = function;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout.d
        public void a(long j, Throwable th) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.d);
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed.d
        public void b(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.d);
                this.a.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.d);
            this.c.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.d.get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.c.dispose();
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.c.dispose();
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    Disposable disposable = (Disposable) this.c.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.a.onNext(t);
                    try {
                        Object apply = this.b.apply(t);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        ObservableSource observableSource = (ObservableSource) apply;
                        a aVar = new a(j2, this);
                        if (this.c.replace(aVar)) {
                            observableSource.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.d.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.a.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.d, disposable);
        }
    }

    public interface d extends ObservableTimeoutTimed.d {
        void a(long j, Throwable th);
    }

    public ObservableTimeout(Observable<T> observable, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        super(observable);
        this.a = observableSource;
        this.b = function;
        this.c = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        if (this.c == null) {
            c cVar = new c(observer, this.b);
            observer.onSubscribe(cVar);
            ObservableSource<U> observableSource = this.a;
            if (observableSource != null) {
                a aVar = new a(0, cVar);
                if (cVar.c.replace(aVar)) {
                    observableSource.subscribe(aVar);
                }
            }
            this.source.subscribe(cVar);
            return;
        }
        b bVar = new b(observer, this.b, this.c);
        observer.onSubscribe(bVar);
        ObservableSource<U> observableSource2 = this.a;
        if (observableSource2 != null) {
            a aVar2 = new a(0, bVar);
            if (bVar.c.replace(aVar2)) {
                observableSource2.subscribe(aVar2);
            }
        }
        this.source.subscribe(bVar);
    }
}
