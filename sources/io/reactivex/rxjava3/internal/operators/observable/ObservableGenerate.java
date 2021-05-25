package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
public final class ObservableGenerate<T, S> extends Observable<T> {
    public final Supplier<S> a;
    public final BiFunction<S, Emitter<T>, S> b;
    public final Consumer<? super S> c;

    public static final class a<T, S> implements Emitter<T>, Disposable {
        public final Observer<? super T> a;
        public final BiFunction<S, ? super Emitter<T>, S> b;
        public final Consumer<? super S> c;
        public S d;
        public volatile boolean e;
        public boolean f;
        public boolean g;

        public a(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
            this.a = observer;
            this.b = biFunction;
            this.c = consumer;
            this.d = s;
        }

        public final void a(S s) {
            try {
                this.c.accept(s);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.e = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            if (!this.f) {
                this.f = true;
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (th == null) {
                th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            this.f = true;
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            if (this.g) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else {
                this.g = true;
                this.a.onNext(t);
            }
        }
    }

    public ObservableGenerate(Supplier<S> supplier, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.a = supplier;
        this.b = biFunction;
        this.c = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            a aVar = new a(observer, this.b, this.c, this.a.get());
            observer.onSubscribe(aVar);
            S s = aVar.d;
            if (aVar.e) {
                aVar.d = null;
                aVar.a(s);
                return;
            }
            BiFunction<S, ? super Emitter<T>, S> biFunction = aVar.b;
            while (!aVar.e) {
                aVar.g = false;
                try {
                    s = biFunction.apply(s, aVar);
                    if (aVar.f) {
                        aVar.e = true;
                        aVar.d = null;
                        aVar.a(s);
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    aVar.d = null;
                    aVar.e = true;
                    aVar.onError(th);
                    aVar.a(s);
                    return;
                }
            }
            aVar.d = null;
            aVar.a(s);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, observer);
        }
    }
}
