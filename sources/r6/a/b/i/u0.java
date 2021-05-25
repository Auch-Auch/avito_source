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
public final class u0<T, R> extends Observable<R> implements ObservableTransformer<T, R> {
    public final Observable<T> a;
    public final Function<? super T, ? extends ObservableSource<? extends R>> b;

    public static final class a<T, R> implements Observer<T>, Disposable {
        public final Observer<? super R> a;
        public final Function<? super T, ? extends ObservableSource<? extends R>> b;
        public final a<T, R>.C0665a c = new C0665a();
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicInteger e = new AtomicInteger(1);
        public Disposable f;
        public volatile boolean g;

        /* renamed from: r6.a.b.i.u0$a$a  reason: collision with other inner class name */
        public final class C0665a extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = -3707363807296094399L;

            public C0665a() {
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                a aVar = a.this;
                aVar.g = false;
                if (aVar.e.decrementAndGet() == 0) {
                    aVar.d.tryTerminateConsumer(aVar.a);
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                a aVar = a.this;
                if (aVar.d.tryAddThrowableOrReport(th)) {
                    aVar.g = false;
                    if (aVar.e.decrementAndGet() == 0) {
                        aVar.d.tryTerminateConsumer(aVar.a);
                    }
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

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.f.dispose();
            DisposableHelper.dispose(this.c);
            this.d.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.f.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.e.decrementAndGet() == 0) {
                this.d.tryTerminateConsumer(this.a);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.g) {
                try {
                    ObservableSource observableSource = (ObservableSource) this.b.apply(t);
                    Objects.requireNonNull(observableSource, "The mapper returned a null ObservableSource");
                    ObservableSource observableSource2 = observableSource;
                    this.g = true;
                    this.e.incrementAndGet();
                    observableSource2.subscribe(this.c);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f.dispose();
                    if (this.d.tryAddThrowableOrReport(th)) {
                        onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public u0(Observable<T> observable, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.a = observable;
        this.b = function;
    }

    @Override // io.reactivex.rxjava3.core.ObservableTransformer
    public ObservableSource<R> apply(Observable<T> observable) {
        return new u0(observable, this.b);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new a(observer, this.b));
    }
}
