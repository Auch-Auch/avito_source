package r6.a.a.h;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class j0<T, R> extends Observable<R> implements ObservableTransformer<T, R> {
    public final Observable<T> a;
    public final Function<? super T, ? extends ObservableSource<? extends R>> b;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1251911925259779985L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends ObservableSource<? extends R>> b;
        public final a<T, R>.C0593a c = new C0593a();
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicReference<T> e = new AtomicReference<>();
        public Disposable f;
        public volatile boolean g;
        public volatile boolean h;
        public volatile boolean i;

        /* renamed from: r6.a.a.h.j0$a$a  reason: collision with other inner class name */
        public final class C0593a extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = -3707363807296094399L;

            public C0593a() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                a aVar = a.this;
                aVar.g = false;
                aVar.a();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                a aVar = a.this;
                if (aVar.d.addThrowable(th)) {
                    aVar.g = false;
                    aVar.a();
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(R r) {
                a.this.a.onNext(r);
            }

            @Override // io.reactivex.Observer
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
                            Throwable terminate = this.d.terminate();
                            if (terminate == null) {
                                this.a.onComplete();
                                return;
                            } else {
                                this.a.onError(terminate);
                                return;
                            }
                        } else if (andSet != null) {
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(andSet), "The mapper returned a null ObservableSource");
                                this.g = true;
                                observableSource.subscribe(this.c);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.f.dispose();
                                this.d.addThrowable(th);
                                this.a.onError(this.d.terminate());
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.i = true;
            this.f.dispose();
            DisposableHelper.dispose(this.c);
            if (getAndIncrement() == 0) {
                this.e.lazySet(null);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.h = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.d.addThrowable(th)) {
                onComplete();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.e.set(t);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public j0(Observable<T> observable, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.a = observable;
        this.b = function;
    }

    @Override // io.reactivex.ObservableTransformer
    public ObservableSource<R> apply(Observable<T> observable) {
        return new j0(observable, this.b);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new a(observer, this.b));
    }
}
