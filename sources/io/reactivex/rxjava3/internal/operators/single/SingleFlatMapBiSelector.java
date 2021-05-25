package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class SingleFlatMapBiSelector<T, U, R> extends Single<R> {
    public final SingleSource<T> a;
    public final Function<? super T, ? extends SingleSource<? extends U>> b;
    public final BiFunction<? super T, ? super U, ? extends R> c;

    public static final class a<T, U, R> implements SingleObserver<T>, Disposable {
        public final Function<? super T, ? extends SingleSource<? extends U>> a;
        public final C0499a<T, U, R> b;

        /* renamed from: io.reactivex.rxjava3.internal.operators.single.SingleFlatMapBiSelector$a$a  reason: collision with other inner class name */
        public static final class C0499a<T, U, R> extends AtomicReference<Disposable> implements SingleObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            public final SingleObserver<? super R> a;
            public final BiFunction<? super T, ? super U, ? extends R> b;
            public T c;

            public C0499a(SingleObserver<? super R> singleObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
                this.a = singleObserver;
                this.b = biFunction;
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                this.a.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(U u) {
                T t = this.c;
                this.c = null;
                try {
                    Object apply = this.b.apply(t, u);
                    Objects.requireNonNull(apply, "The resultSelector returned a null value");
                    this.a.onSuccess(apply);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.a.onError(th);
                }
            }
        }

        public a(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.b = new C0499a<>(singleObserver, biFunction);
            this.a = function;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.b);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.b.get());
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            this.b.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.b, disposable)) {
                this.b.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            try {
                Object apply = this.a.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                SingleSource singleSource = (SingleSource) apply;
                if (DisposableHelper.replace(this.b, null)) {
                    C0499a<T, U, R> aVar = this.b;
                    aVar.c = t;
                    singleSource.subscribe(aVar);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.b.a.onError(th);
            }
        }
    }

    public SingleFlatMapBiSelector(SingleSource<T> singleSource, Function<? super T, ? extends SingleSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.a = singleSource;
        this.b = function;
        this.c = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b, this.c));
    }
}
