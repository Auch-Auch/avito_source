package r6.a.b.f;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class j<T> extends Observable<T> {
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

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
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
            DisposableHelper.replace(this, disposable);
        }
    }

    public j(ObservableSource<? extends T> observableSource, BooleanSupplier booleanSupplier, BooleanSupplier booleanSupplier2) {
        this.a = observableSource;
        this.b = booleanSupplier;
        this.c = booleanSupplier2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
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
