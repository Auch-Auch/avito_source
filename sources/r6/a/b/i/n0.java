package r6.a.b.i;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeConverter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class n0<T> extends Completable implements MaybeConverter<T, Completable> {
    public final Maybe<T> a;
    public final Function<? super T, ? extends CompletableSource> b;
    public final Function<? super Throwable, ? extends CompletableSource> c;
    public final Supplier<? extends CompletableSource> d;

    public static final class a<T> implements MaybeObserver<T>, Disposable {
        public final C0657a a;
        public final Function<? super T, ? extends CompletableSource> b;
        public final Function<? super Throwable, ? extends CompletableSource> c;
        public final Supplier<? extends CompletableSource> d;

        /* renamed from: r6.a.b.i.n0$a$a  reason: collision with other inner class name */
        public static final class C0657a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 314442824941893429L;
            public final CompletableObserver a;

            public C0657a(CompletableObserver completableObserver) {
                this.a = completableObserver;
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                this.a.onComplete();
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable th) {
                this.a.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public a(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, Function<? super Throwable, ? extends CompletableSource> function2, Supplier<? extends CompletableSource> supplier) {
            this.a = new C0657a(completableObserver);
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
                CompletableSource completableSource = (CompletableSource) this.d.get();
                Objects.requireNonNull(completableSource, "The onCompleteHandler returned a null CompletableSource");
                completableSource.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            try {
                CompletableSource completableSource = (CompletableSource) this.c.apply(th);
                Objects.requireNonNull(completableSource, "The onErrorHandler returned a null CompletableSource");
                completableSource.subscribe(this.a);
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
                CompletableSource completableSource = (CompletableSource) this.b.apply(t);
                Objects.requireNonNull(completableSource, "The onSuccessHandler returned a null CompletableSource");
                completableSource.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }
    }

    public n0(Maybe<T> maybe, Function<? super T, ? extends CompletableSource> function, Function<? super Throwable, ? extends CompletableSource> function2, Supplier<? extends CompletableSource> supplier) {
        this.a = maybe;
        this.b = function;
        this.c = function2;
        this.d = supplier;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.core.MaybeConverter
    public Completable apply(Maybe maybe) {
        return new n0(maybe, this.b, this.c, this.d);
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver, this.b, this.c, this.d));
    }
}
