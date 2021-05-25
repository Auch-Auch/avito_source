package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableRefCount<T> extends Observable<T> {
    public final ConnectableObservable<T> a;
    public final int b;
    public final long c;
    public final TimeUnit d;
    public final Scheduler e;
    public a f;

    public static final class a extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        public final ObservableRefCount<?> a;
        public Disposable b;
        public long c;
        public boolean d;
        public boolean e;

        public a(ObservableRefCount<?> observableRefCount) {
            this.a = observableRefCount;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) throws Throwable {
            DisposableHelper.replace(this, disposable);
            synchronized (this.a) {
                if (this.e) {
                    this.a.a.reset();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.f(this);
        }
    }

    public static final class b<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        public final Observer<? super T> a;
        public final ObservableRefCount<T> b;
        public final a c;
        public Disposable d;

        public b(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, a aVar) {
            this.a = observer;
            this.b = observableRefCount;
            this.c = aVar;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.d.dispose();
            if (compareAndSet(false, true)) {
                ObservableRefCount<T> observableRefCount = this.b;
                a aVar = this.c;
                synchronized (observableRefCount) {
                    a aVar2 = observableRefCount.f;
                    if (aVar2 != null) {
                        if (aVar2 == aVar) {
                            long j = aVar.c - 1;
                            aVar.c = j;
                            if (j == 0) {
                                if (aVar.d) {
                                    if (observableRefCount.c == 0) {
                                        observableRefCount.f(aVar);
                                        return;
                                    }
                                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                                    aVar.b = sequentialDisposable;
                                    sequentialDisposable.replace(observableRefCount.e.scheduleDirect(aVar, observableRefCount.c, observableRefCount.d));
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.b.e(this.c);
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.b.e(this.c);
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0, TimeUnit.NANOSECONDS, null);
    }

    public void e(a aVar) {
        synchronized (this) {
            if (this.f == aVar) {
                Disposable disposable = aVar.b;
                if (disposable != null) {
                    disposable.dispose();
                    aVar.b = null;
                }
                long j = aVar.c - 1;
                aVar.c = j;
                if (j == 0) {
                    this.f = null;
                    this.a.reset();
                }
            }
        }
    }

    public void f(a aVar) {
        synchronized (this) {
            if (aVar.c == 0 && aVar == this.f) {
                this.f = null;
                Disposable disposable = (Disposable) aVar.get();
                DisposableHelper.dispose(aVar);
                if (disposable == null) {
                    aVar.e = true;
                } else {
                    this.a.reset();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar;
        boolean z;
        Disposable disposable;
        synchronized (this) {
            aVar = this.f;
            if (aVar == null) {
                aVar = new a(this);
                this.f = aVar;
            }
            long j = aVar.c;
            if (j == 0 && (disposable = aVar.b) != null) {
                disposable.dispose();
            }
            long j2 = j + 1;
            aVar.c = j2;
            z = true;
            if (aVar.d || j2 != ((long) this.b)) {
                z = false;
            } else {
                aVar.d = true;
            }
        }
        this.a.subscribe(new b(observer, this, aVar));
        if (z) {
            this.a.connect(aVar);
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.a = connectableObservable;
        this.b = i;
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
    }
}
