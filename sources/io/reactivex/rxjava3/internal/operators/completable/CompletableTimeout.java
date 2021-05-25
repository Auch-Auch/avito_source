package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
public final class CompletableTimeout extends Completable {
    public final CompletableSource a;
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;
    public final CompletableSource e;

    public final class a implements Runnable {
        public final AtomicBoolean a;
        public final CompositeDisposable b;
        public final CompletableObserver c;

        /* renamed from: io.reactivex.rxjava3.internal.operators.completable.CompletableTimeout$a$a  reason: collision with other inner class name */
        public final class C0439a implements CompletableObserver {
            public C0439a() {
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                a.this.b.dispose();
                a.this.c.onComplete();
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable th) {
                a.this.b.dispose();
                a.this.c.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                a.this.b.add(disposable);
            }
        }

        public a(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.a = atomicBoolean;
            this.b = compositeDisposable;
            this.c = completableObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.compareAndSet(false, true)) {
                this.b.clear();
                CompletableSource completableSource = CompletableTimeout.this.e;
                if (completableSource == null) {
                    CompletableObserver completableObserver = this.c;
                    CompletableTimeout completableTimeout = CompletableTimeout.this;
                    completableObserver.onError(new TimeoutException(ExceptionHelper.timeoutMessage(completableTimeout.b, completableTimeout.c)));
                    return;
                }
                completableSource.subscribe(new C0439a());
            }
        }
    }

    public static final class b implements CompletableObserver {
        public final CompositeDisposable a;
        public final AtomicBoolean b;
        public final CompletableObserver c;

        public b(CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.a = compositeDisposable;
            this.b = atomicBoolean;
            this.c = completableObserver;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            if (this.b.compareAndSet(false, true)) {
                this.a.dispose();
                this.c.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            if (this.b.compareAndSet(false, true)) {
                this.a.dispose();
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.a.add(disposable);
        }
    }

    public CompletableTimeout(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.a = completableSource;
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = completableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.add(this.d.scheduleDirect(new a(atomicBoolean, compositeDisposable, completableObserver), this.b, this.c));
        this.a.subscribe(new b(compositeDisposable, atomicBoolean, completableObserver));
    }
}
