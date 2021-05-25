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
public final class i0<T, R> extends Observable<R> implements ObservableTransformer<T, R> {
    public final Observable<T> a;
    public final Function<? super T, ? extends ObservableSource<? extends R>> b;

    public static final class a<T, R> implements Observer<T>, Disposable {
        public final Observer<? super R> a;
        public final Function<? super T, ? extends ObservableSource<? extends R>> b;
        public final a<T, R>.C0592a c = new C0592a();
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicInteger e = new AtomicInteger(1);
        public Disposable f;
        public volatile boolean g;

        /* renamed from: r6.a.a.h.i0$a$a  reason: collision with other inner class name */
        public final class C0592a extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = -3707363807296094399L;

            public C0592a() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                a.this.a();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                a aVar = a.this;
                if (aVar.d.addThrowable(th)) {
                    aVar.a();
                } else {
                    RxJavaPlugins.onError(th);
                }
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
            this.g = false;
            if (this.e.decrementAndGet() == 0) {
                Throwable terminate = this.d.terminate();
                if (terminate == null) {
                    this.a.onComplete();
                } else {
                    this.a.onError(terminate);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f.dispose();
            DisposableHelper.dispose(this.c);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.e.decrementAndGet() == 0) {
                Throwable terminate = this.d.terminate();
                if (terminate == null) {
                    this.a.onComplete();
                } else {
                    this.a.onError(terminate);
                }
            }
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
            if (!this.g) {
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null ObservableSource");
                    this.g = true;
                    this.e.incrementAndGet();
                    observableSource.subscribe(this.c);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public i0(Observable<T> observable, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.a = observable;
        this.b = function;
    }

    @Override // io.reactivex.ObservableTransformer
    public ObservableSource<R> apply(Observable<T> observable) {
        return new i0(observable, this.b);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new a(observer, this.b));
    }
}
