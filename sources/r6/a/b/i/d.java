package r6.a.b.i;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableConverter;
import io.reactivex.rxjava3.core.CompletableObserver;
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
public final class d<R> extends Observable<R> implements CompletableConverter<Observable<R>> {
    public final Completable a;
    public final Supplier<? extends ObservableSource<? extends R>> b;
    public final Function<? super Throwable, ? extends ObservableSource<? extends R>> c;

    public static final class a<R> implements CompletableObserver, Disposable {
        public final C0647a<R> a;
        public final Supplier<? extends ObservableSource<? extends R>> b;
        public final Function<? super Throwable, ? extends ObservableSource<? extends R>> c;

        /* renamed from: r6.a.b.i.d$a$a  reason: collision with other inner class name */
        public static final class C0647a<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 314442824941893429L;
            public final Observer<? super R> a;

            public C0647a(Observer<? super R> observer) {
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

        public a(Observer<? super R> observer, Supplier<? extends ObservableSource<? extends R>> supplier, Function<? super Throwable, ? extends ObservableSource<? extends R>> function) {
            this.a = new C0647a<>(observer);
            this.b = supplier;
            this.c = function;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.a);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.a.get());
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            try {
                ObservableSource observableSource = (ObservableSource) this.b.get();
                Objects.requireNonNull(observableSource, "The onCompleteHandler returned a null ObservableSource");
                observableSource.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
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

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate((Disposable) this.a.get(), disposable)) {
                this.a.lazySet(disposable);
                this.a.a.onSubscribe(this);
            }
        }
    }

    public d(Completable completable, Supplier<? extends ObservableSource<? extends R>> supplier, Function<? super Throwable, ? extends ObservableSource<? extends R>> function) {
        this.a = completable;
        this.b = supplier;
        this.c = function;
    }

    @Override // io.reactivex.rxjava3.core.CompletableConverter
    public Object apply(Completable completable) {
        return new d(completable, this.b, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new a(observer, this.b, this.c));
    }
}
