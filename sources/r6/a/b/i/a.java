package r6.a.b.i;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.CompletableTransformer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class a extends Completable implements CompletableTransformer {
    public final Completable a;
    public final Supplier<? extends CompletableSource> b;
    public final Function<? super Throwable, ? extends CompletableSource> c;

    /* renamed from: r6.a.b.i.a$a  reason: collision with other inner class name */
    public static final class C0639a implements CompletableObserver, Disposable {
        public final C0640a a;
        public final Supplier<? extends CompletableSource> b;
        public final Function<? super Throwable, ? extends CompletableSource> c;

        /* renamed from: r6.a.b.i.a$a$a  reason: collision with other inner class name */
        public static final class C0640a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 314442824941893429L;
            public final CompletableObserver a;

            public C0640a(CompletableObserver completableObserver) {
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

        public C0639a(CompletableObserver completableObserver, Supplier<? extends CompletableSource> supplier, Function<? super Throwable, ? extends CompletableSource> function) {
            this.a = new C0640a(completableObserver);
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
                CompletableSource completableSource = (CompletableSource) this.b.get();
                Objects.requireNonNull(completableSource, "The onCompleteHandler returned a null CompletableSource");
                completableSource.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
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

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate((Disposable) this.a.get(), disposable)) {
                this.a.lazySet(disposable);
                this.a.a.onSubscribe(this);
            }
        }
    }

    public a(Completable completable, Supplier<? extends CompletableSource> supplier, Function<? super Throwable, ? extends CompletableSource> function) {
        this.a = completable;
        this.b = supplier;
        this.c = function;
    }

    @Override // io.reactivex.rxjava3.core.CompletableTransformer
    public CompletableSource apply(Completable completable) {
        return new a(completable, this.b, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new C0639a(completableObserver, this.b, this.c));
    }
}
