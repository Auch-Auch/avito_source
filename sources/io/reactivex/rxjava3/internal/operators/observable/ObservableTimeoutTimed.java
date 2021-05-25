package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableTimeoutTimed<T> extends s6.a.e.d.c.c.a<T, T> {
    public final long a;
    public final TimeUnit b;
    public final Scheduler c;
    public final ObservableSource<? extends T> d;

    public static final class a<T> implements Observer<T> {
        public final Observer<? super T> a;
        public final AtomicReference<Disposable> b;

        public a(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
            this.a = observer;
            this.b = atomicReference;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.b, disposable);
        }
    }

    public static final class b<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, d {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Observer<? super T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler.Worker d;
        public final SequentialDisposable e = new SequentialDisposable();
        public final AtomicLong f = new AtomicLong();
        public final AtomicReference<Disposable> g = new AtomicReference<>();
        public ObservableSource<? extends T> h;

        public b(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
            this.a = observer;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
            this.h = observableSource;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed.d
        public void b(long j) {
            if (this.f.compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.g);
                ObservableSource<? extends T> observableSource = this.h;
                this.h = null;
                observableSource.subscribe(new a(this.a, this));
                this.d.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.g);
            DisposableHelper.dispose(this);
            this.d.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.a.onComplete();
                this.d.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.a.onError(th);
                this.d.dispose();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            long j = this.f.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.f.compareAndSet(j, j2)) {
                    ((Disposable) this.e.get()).dispose();
                    this.a.onNext(t);
                    this.e.replace(this.d.schedule(new e(j2, this), this.b, this.c));
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.g, disposable);
        }
    }

    public static final class c<T> extends AtomicLong implements Observer<T>, Disposable, d {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Observer<? super T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler.Worker d;
        public final SequentialDisposable e = new SequentialDisposable();
        public final AtomicReference<Disposable> f = new AtomicReference<>();

        public c(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.a = observer;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed.d
        public void b(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f);
                this.a.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.b, this.c)));
                this.d.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.f);
            this.d.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f.get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.a.onComplete();
                this.d.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.a.onError(th);
                this.d.dispose();
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
                    ((Disposable) this.e.get()).dispose();
                    this.a.onNext(t);
                    this.e.replace(this.d.schedule(new e(j2, this), this.b, this.c));
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f, disposable);
        }
    }

    public interface d {
        void b(long j);
    }

    public static final class e implements Runnable {
        public final d a;
        public final long b;

        public e(long j, d dVar) {
            this.b = j;
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    public ObservableTimeoutTimed(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        this.a = j;
        this.b = timeUnit;
        this.c = scheduler;
        this.d = observableSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        if (this.d == null) {
            c cVar = new c(observer, this.a, this.b, this.c.createWorker());
            observer.onSubscribe(cVar);
            cVar.e.replace(cVar.d.schedule(new e(0, cVar), cVar.b, cVar.c));
            this.source.subscribe(cVar);
            return;
        }
        b bVar = new b(observer, this.a, this.b, this.c.createWorker(), this.d);
        observer.onSubscribe(bVar);
        bVar.e.replace(bVar.d.schedule(new e(0, bVar), bVar.b, bVar.c));
        this.source.subscribe(bVar);
    }
}
