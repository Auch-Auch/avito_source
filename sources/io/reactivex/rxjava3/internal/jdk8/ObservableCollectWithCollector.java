package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
public final class ObservableCollectWithCollector<T, A, R> extends Observable<R> {
    public final Observable<T> a;
    public final Collector<? super T, A, R> b;

    public static final class a<T, A, R> extends DeferredScalarDisposable<R> implements Observer<T> {
        private static final long serialVersionUID = -229544830565448758L;
        public final BiConsumer<A, T> a;
        public final Function<A, R> b;
        public Disposable c;
        public boolean d;
        public A e;

        public a(Observer<? super R> observer, A a3, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            super(observer);
            this.e = a3;
            this.a = biConsumer;
            this.b = function;
        }

        @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable, io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            super.dispose();
            this.c.dispose();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.d) {
                this.d = true;
                this.c = DisposableHelper.DISPOSED;
                A a3 = this.e;
                this.e = null;
                try {
                    R apply = this.b.apply(a3);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    complete(apply);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            this.c = DisposableHelper.DISPOSED;
            this.e = null;
            this.downstream.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.d) {
                try {
                    this.a.accept(this.e, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.c.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableCollectWithCollector(Observable<T> observable, Collector<? super T, A, R> collector) {
        this.a = observable;
        this.b = collector;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NonNull Observer<? super R> observer) {
        try {
            this.a.subscribe(new a(observer, this.b.supplier().get(), this.b.accumulator(), this.b.finisher()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
