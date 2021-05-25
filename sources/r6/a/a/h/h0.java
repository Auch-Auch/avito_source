package r6.a.a.h;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;
public final class h0<T, R> extends Observable<R> implements ObservableTransformer<T, R> {
    public final Observable<T> a;
    public final ObservableTransformer<T, R> b;

    public static final class a<T, R> extends Observable<T> implements Observer<T>, Disposable {
        public final Observable<T> a;
        public final AtomicReference<Observer<? super T>> b = new AtomicReference<>();
        public final a<T, R>.C0591a c;
        public Disposable d;

        /* renamed from: r6.a.a.h.h0$a$a  reason: collision with other inner class name */
        public final class C0591a extends AtomicReference<Throwable> implements Observer<R>, Disposable {
            private static final long serialVersionUID = -5718512540714037078L;
            public final Observer<? super R> a;
            public Disposable b;

            public C0591a(a aVar, Observer<? super R> observer) {
                this.a = observer;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                this.b.dispose();
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return this.b.isDisposed();
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                Throwable th = (Throwable) get();
                if (th != null) {
                    this.a.onError(th);
                } else {
                    this.a.onComplete();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                Throwable th2 = (Throwable) get();
                if (th2 != null) {
                    th = new CompositeException(th2, th);
                }
                this.a.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(R r) {
                this.a.onNext(r);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                this.b = disposable;
                this.a.onSubscribe(this);
            }
        }

        public a(Observable<T> observable, Observer<? super R> observer) {
            this.a = observable;
            this.c = new C0591a(this, observer);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.b.get().onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.c.set(th);
            this.b.get().onComplete();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.b.get().onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.d = disposable;
            this.b.get().onSubscribe(this);
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super T> observer) {
            if (this.b.compareAndSet(null, observer)) {
                this.a.subscribe(this);
            } else {
                EmptyDisposable.error(new IllegalStateException("Only one Subscriber allowed"), observer);
            }
        }
    }

    public h0(Observable<T> observable, ObservableTransformer<T, R> observableTransformer) {
        this.a = observable;
        this.b = observableTransformer;
    }

    @Override // io.reactivex.ObservableTransformer
    public ObservableSource<R> apply(Observable<T> observable) {
        return new h0(observable, this.b);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        a aVar = new a(this.a, observer);
        try {
            ((ObservableSource) ObjectHelper.requireNonNull(this.b.apply(aVar), "The transformer returned a null Publisher")).subscribe(aVar.c);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
