package r6.a.b.i;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.core.SingleTransformer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class f1<T, R> extends Single<R> implements SingleTransformer<T, R> {
    public final Single<T> a;
    public final Function<? super T, ? extends SingleSource<? extends R>> b;
    public final Function<? super Throwable, ? extends SingleSource<? extends R>> c;

    public static final class a<T, R> implements SingleObserver<T>, Disposable {
        public final C0652a<R> a;
        public final Function<? super T, ? extends SingleSource<? extends R>> b;
        public final Function<? super Throwable, ? extends SingleSource<? extends R>> c;

        /* renamed from: r6.a.b.i.f1$a$a  reason: collision with other inner class name */
        public static final class C0652a<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 314442824941893429L;
            public final SingleObserver<? super R> a;

            public C0652a(SingleObserver<? super R> singleObserver) {
                this.a = singleObserver;
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                this.a.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R r) {
                this.a.onSuccess(r);
            }
        }

        public a(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
            this.a = new C0652a<>(singleObserver);
            this.b = function;
            this.c = function2;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.a);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.a.get());
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            try {
                SingleSource singleSource = (SingleSource) this.c.apply(th);
                Objects.requireNonNull(singleSource, "The onErrorHandler returned a null SingleSource");
                singleSource.subscribe(this.a);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.a.onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate((Disposable) this.a.get(), disposable)) {
                this.a.lazySet(disposable);
                this.a.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            try {
                SingleSource singleSource = (SingleSource) this.b.apply(t);
                Objects.requireNonNull(singleSource, "The onSuccessHandler returned a null SingleSource");
                singleSource.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }
    }

    public f1(Single<T> single, Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
        this.a = single;
        this.b = function;
        this.c = function2;
    }

    @Override // io.reactivex.rxjava3.core.SingleTransformer
    public SingleSource apply(Single single) {
        return new f1(single, this.b, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b, this.c));
    }
}
