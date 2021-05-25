package r6.a.b.i;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleConverter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class b1<T> extends Completable implements SingleConverter<T, Completable> {
    public final Single<T> a;
    public final Function<? super T, ? extends CompletableSource> b;
    public final Function<? super Throwable, ? extends CompletableSource> c;

    public static final class a<T> implements SingleObserver<T>, Disposable {
        public final C0644a a;
        public final Function<? super T, ? extends CompletableSource> b;
        public final Function<? super Throwable, ? extends CompletableSource> c;

        /* renamed from: r6.a.b.i.b1$a$a  reason: collision with other inner class name */
        public static final class C0644a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 314442824941893429L;
            public final CompletableObserver a;

            public C0644a(CompletableObserver completableObserver) {
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

        public a(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, Function<? super Throwable, ? extends CompletableSource> function2) {
            this.a = new C0644a(completableObserver);
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
                CompletableSource completableSource = (CompletableSource) this.c.apply(th);
                Objects.requireNonNull(completableSource, "The onErrorHandler returned a null CompletableSource");
                completableSource.subscribe(this.a);
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
                CompletableSource completableSource = (CompletableSource) this.b.apply(t);
                Objects.requireNonNull(completableSource, "The onSuccessHandler returned a null CompletableSource");
                completableSource.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }
    }

    public b1(Single<T> single, Function<? super T, ? extends CompletableSource> function, Function<? super Throwable, ? extends CompletableSource> function2) {
        this.a = single;
        this.b = function;
        this.c = function2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.core.SingleConverter
    public Completable apply(Single single) {
        return new b1(single, this.b, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver, this.b, this.c));
    }
}
