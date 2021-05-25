package r6.a.b.i;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableConverter;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class e<R> extends Single<R> implements CompletableConverter<Single<R>> {
    public final Completable a;
    public final Supplier<? extends SingleSource<? extends R>> b;
    public final Function<? super Throwable, ? extends SingleSource<? extends R>> c;

    public static final class a<R> implements CompletableObserver, Disposable {
        public final C0650a<R> a;
        public final Supplier<? extends SingleSource<? extends R>> b;
        public final Function<? super Throwable, ? extends SingleSource<? extends R>> c;

        /* renamed from: r6.a.b.i.e$a$a  reason: collision with other inner class name */
        public static final class C0650a<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 314442824941893429L;
            public final SingleObserver<? super R> a;

            public C0650a(SingleObserver<? super R> singleObserver) {
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

        public a(SingleObserver<? super R> singleObserver, Supplier<? extends SingleSource<? extends R>> supplier, Function<? super Throwable, ? extends SingleSource<? extends R>> function) {
            this.a = new C0650a<>(singleObserver);
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
                SingleSource singleSource = (SingleSource) this.b.get();
                Objects.requireNonNull(singleSource, "The onCompleteHandler returned a null SingleSource");
                singleSource.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
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

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate((Disposable) this.a.get(), disposable)) {
                this.a.lazySet(disposable);
                this.a.a.onSubscribe(this);
            }
        }
    }

    public e(Completable completable, Supplier<? extends SingleSource<? extends R>> supplier, Function<? super Throwable, ? extends SingleSource<? extends R>> function) {
        this.a = completable;
        this.b = supplier;
        this.c = function;
    }

    @Override // io.reactivex.rxjava3.core.CompletableConverter
    public Object apply(Completable completable) {
        return new e(completable, this.b, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b, this.c));
    }
}
