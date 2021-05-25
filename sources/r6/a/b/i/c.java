package r6.a.b.i;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableConverter;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class c<R> extends Maybe<R> implements CompletableConverter<Maybe<R>> {
    public final Completable a;
    public final Supplier<? extends MaybeSource<? extends R>> b;
    public final Function<? super Throwable, ? extends MaybeSource<? extends R>> c;

    public static final class a<R> implements CompletableObserver, Disposable {
        public final C0645a<R> a;
        public final Supplier<? extends MaybeSource<? extends R>> b;
        public final Function<? super Throwable, ? extends MaybeSource<? extends R>> c;

        /* renamed from: r6.a.b.i.c$a$a  reason: collision with other inner class name */
        public static final class C0645a<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 314442824941893429L;
            public final MaybeObserver<? super R> a;

            public C0645a(MaybeObserver<? super R> maybeObserver) {
                this.a = maybeObserver;
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                this.a.onComplete();
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                this.a.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R r) {
                this.a.onSuccess(r);
            }
        }

        public a(MaybeObserver<? super R> maybeObserver, Supplier<? extends MaybeSource<? extends R>> supplier, Function<? super Throwable, ? extends MaybeSource<? extends R>> function) {
            this.a = new C0645a<>(maybeObserver);
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
                MaybeSource maybeSource = (MaybeSource) this.b.get();
                Objects.requireNonNull(maybeSource, "The onCompleteHandler returned a null MaybeSource");
                maybeSource.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            try {
                MaybeSource maybeSource = (MaybeSource) this.c.apply(th);
                Objects.requireNonNull(maybeSource, "The onErrorHandler returned a null MaybeSource");
                maybeSource.subscribe(this.a);
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

    public c(Completable completable, Supplier<? extends MaybeSource<? extends R>> supplier, Function<? super Throwable, ? extends MaybeSource<? extends R>> function) {
        this.a = completable;
        this.b = supplier;
        this.c = function;
    }

    @Override // io.reactivex.rxjava3.core.CompletableConverter
    public Object apply(Completable completable) {
        return new c(completable, this.b, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.a.subscribe(new a(maybeObserver, this.b, this.c));
    }
}
