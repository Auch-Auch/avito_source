package r6.a.a.e;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class f<T> extends Observable<T> {
    public final ObservableSource<? extends T> a;
    public final BooleanSupplier b;
    public final BooleanSupplier c;

    public static final class a<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5255585317630843019L;
        public final Observer<? super T> a;
        public final AtomicInteger b = new AtomicInteger();
        public final BooleanSupplier c;
        public final ObservableSource<? extends T> d;
        public volatile boolean e;

        public a(Observer<? super T> observer, BooleanSupplier booleanSupplier, ObservableSource<? extends T> observableSource) {
            this.a = observer;
            this.c = booleanSupplier;
            this.d = observableSource;
        }

        public void a() {
            if (this.b.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.e) {
                        this.e = true;
                        this.d.subscribe(this);
                    }
                    if (this.b.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            try {
                if (this.c.getAsBoolean()) {
                    this.e = false;
                    a();
                    return;
                }
                this.a.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public f(ObservableSource<? extends T> observableSource, BooleanSupplier booleanSupplier, BooleanSupplier booleanSupplier2) {
        this.a = observableSource;
        this.b = booleanSupplier;
        this.c = booleanSupplier2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            if (this.b.getAsBoolean()) {
                a aVar = new a(observer, this.c, this.a);
                observer.onSubscribe(aVar);
                aVar.a();
                return;
            }
            EmptyDisposable.complete(observer);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
