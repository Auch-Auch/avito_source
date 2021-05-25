package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
public final class CompletableDisposeOn extends Completable {
    public final CompletableSource a;
    public final Scheduler b;

    public static final class a implements CompletableObserver, Disposable, Runnable {
        public final CompletableObserver a;
        public final Scheduler b;
        public Disposable c;
        public volatile boolean d;

        public a(CompletableObserver completableObserver, Scheduler scheduler) {
            this.a = completableObserver;
            this.b = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d = true;
            this.b.scheduleDirect(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (!this.d) {
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
            } else {
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.dispose();
            this.c = DisposableHelper.DISPOSED;
        }
    }

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.a = completableSource;
        this.b = scheduler;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver, this.b));
    }
}
