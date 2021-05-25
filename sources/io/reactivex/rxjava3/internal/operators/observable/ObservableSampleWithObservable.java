package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableSampleWithObservable<T> extends s6.a.e.d.c.c.a<T, T> {
    public final ObservableSource<?> a;
    public final boolean b;

    public static final class a<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        public final AtomicInteger e = new AtomicInteger();
        public volatile boolean f;

        public a(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableSampleWithObservable.c
        public void a() {
            this.f = true;
            if (this.e.getAndIncrement() == 0) {
                b();
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableSampleWithObservable.c
        public void c() {
            if (this.e.getAndIncrement() == 0) {
                do {
                    boolean z = this.f;
                    b();
                    if (z) {
                        this.a.onComplete();
                        return;
                    }
                } while (this.e.decrementAndGet() != 0);
            }
        }
    }

    public static final class b<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public b(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableSampleWithObservable.c
        public void a() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableSampleWithObservable.c
        public void c() {
            b();
        }
    }

    public static abstract class c<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3517602651313910099L;
        public final Observer<? super T> a;
        public final ObservableSource<?> b;
        public final AtomicReference<Disposable> c = new AtomicReference<>();
        public Disposable d;

        public c(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.a = observer;
            this.b = observableSource;
        }

        public abstract void a();

        public void b() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.a.onNext(andSet);
            }
        }

        public abstract void c();

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.c);
            this.d.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.c);
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.c);
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.onSubscribe(this);
                if (this.c.get() == null) {
                    this.b.subscribe(new d(this));
                }
            }
        }
    }

    public static final class d<T> implements Observer<Object> {
        public final c<T> a;

        public d(c<T> cVar) {
            this.a = cVar;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            c<T> cVar = this.a;
            cVar.d.dispose();
            cVar.a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            c<T> cVar = this.a;
            cVar.d.dispose();
            cVar.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            this.a.c();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.a.c, disposable);
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z) {
        super(observableSource);
        this.a = observableSource2;
        this.b = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.b) {
            this.source.subscribe(new a(serializedObserver, this.a));
        } else {
            this.source.subscribe(new b(serializedObserver, this.a));
        }
    }
}
