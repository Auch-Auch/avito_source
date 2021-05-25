package r6.a.b.i;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeConverter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class q0<T, R> extends Observable<R> implements MaybeConverter<T, Observable<R>> {
    public final Maybe<T> a;
    public final Function<? super T, ? extends ObservableSource<? extends R>> b;
    public final Function<? super Throwable, ? extends ObservableSource<? extends R>> c;
    public final Supplier<? extends ObservableSource<? extends R>> d;

    public static final class a<T, R> implements MaybeObserver<T>, Disposable {
        public final C0661a<R> a;
        public final Function<? super T, ? extends ObservableSource<? extends R>> b;
        public final Function<? super Throwable, ? extends ObservableSource<? extends R>> c;
        public final Supplier<? extends ObservableSource<? extends R>> d;

        /* renamed from: r6.a.b.i.q0$a$a  reason: collision with other inner class name */
        public static final class C0661a<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 314442824941893429L;
            public final Observer<? super R> a;

            public C0661a(Observer<? super R> observer) {
                this.a = observer;
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
            public void onNext(R r) {
                this.a.onNext(r);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public a(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Supplier<? extends ObservableSource<? extends R>> supplier) {
            this.a = new C0661a<>(observer);
            this.b = function;
            this.c = function2;
            this.d = supplier;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.a);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.a.get());
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            try {
                ObservableSource observableSource = (ObservableSource) this.d.get();
                Objects.requireNonNull(observableSource, "The onCompleteHandler returned a null ObservableSource");
                observableSource.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            try {
                ObservableSource observableSource = (ObservableSource) this.c.apply(th);
                Objects.requireNonNull(observableSource, "The onErrorHandler returned a null ObservableSource");
                observableSource.subscribe(this.a);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.a.onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate((Disposable) this.a.get(), disposable)) {
                this.a.lazySet(disposable);
                this.a.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            try {
                ObservableSource observableSource = (ObservableSource) this.b.apply(t);
                Objects.requireNonNull(observableSource, "The onSuccessHandler returned a null ObservableSource");
                observableSource.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }
    }

    public q0(Maybe<T> maybe, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Supplier<? extends ObservableSource<? extends R>> supplier) {
        this.a = maybe;
        this.b = function;
        this.c = function2;
        this.d = supplier;
    }

    @Override // io.reactivex.rxjava3.core.MaybeConverter
    public Object apply(Maybe maybe) {
        return new q0(maybe, this.b, this.c, this.d);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new a(observer, this.b, this.c, this.d));
    }
}
