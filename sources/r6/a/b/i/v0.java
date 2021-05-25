package r6.a.b.i;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class v0<T, R> extends Observable<R> implements ObservableTransformer<T, R> {
    public final Observable<T> a;
    public final Function<? super T, ? extends ObservableSource<? extends R>> b;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1251911925259779985L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends ObservableSource<? extends R>> b;
        public final a<T, R>.C0666a c = new C0666a();
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicReference<T> e = new AtomicReference<>();
        public Disposable f;
        public volatile boolean g;
        public volatile boolean h;
        public volatile boolean i;

        /* renamed from: r6.a.b.i.v0$a$a  reason: collision with other inner class name */
        public final class C0666a extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = -3707363807296094399L;

            public C0666a() {
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                a aVar = a.this;
                aVar.g = false;
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                a aVar = a.this;
                if (aVar.d.tryAddThrowableOrReport(th)) {
                    aVar.g = false;
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(R r) {
                a.this.a.onNext(r);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public a(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.a = observer;
            this.b = function;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                while (!this.i) {
                    if (!this.g) {
                        boolean z = this.h;
                        T andSet = this.e.getAndSet(null);
                        if (z && andSet == null) {
                            this.d.tryTerminateConsumer(this.a);
                            return;
                        } else if (andSet != null) {
                            try {
                                ObservableSource observableSource = (ObservableSource) this.b.apply(andSet);
                                Objects.requireNonNull(observableSource, "The mapper returned a null ObservableSource");
                                ObservableSource observableSource2 = observableSource;
                                this.g = true;
                                observableSource2.subscribe(this.c);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.f.dispose();
                                this.d.tryAddThrowableOrReport(th);
                                this.d.tryTerminateConsumer(this.a);
                                return;
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.e.lazySet(null);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.i = true;
            this.f.dispose();
            DisposableHelper.dispose(this.c);
            this.d.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.e.lazySet(null);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.h = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.e.set(t);
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public v0(Observable<T> observable, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.a = observable;
        this.b = function;
    }

    @Override // io.reactivex.rxjava3.core.ObservableTransformer
    public ObservableSource<R> apply(Observable<T> observable) {
        return new v0(observable, this.b);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new a(observer, this.b));
    }
}
