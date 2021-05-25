package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
public final class CompletableAndThenCompletable extends Completable {
    public final CompletableSource a;
    public final CompletableSource b;

    public static final class a implements CompletableObserver {
        public final AtomicReference<Disposable> a;
        public final CompletableObserver b;

        public a(AtomicReference<Disposable> atomicReference, CompletableObserver completableObserver) {
            this.a = atomicReference;
            this.b = completableObserver;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            this.b.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.a, disposable);
        }
    }

    public static final class b extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -4101678820158072998L;
        public final CompletableObserver a;
        public final CompletableSource b;

        public b(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.a = completableObserver;
            this.b = completableSource;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.b.subscribe(new a(this, this.a));
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.a.onSubscribe(this);
            }
        }
    }

    public CompletableAndThenCompletable(CompletableSource completableSource, CompletableSource completableSource2) {
        this.a = completableSource;
        this.b = completableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new b(completableObserver, this.b));
    }
}
