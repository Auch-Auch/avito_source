package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
public final class MaybeDelay<T> extends s6.a.e.d.c.b.a<T, T> {
    public final long a;
    public final TimeUnit b;
    public final Scheduler c;
    public final boolean d;

    public static final class a<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;
        public final MaybeObserver<? super T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public final boolean e;
        public T f;
        public Throwable g;

        public a(MaybeObserver<? super T> maybeObserver, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.a = maybeObserver;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
            this.e = z;
        }

        public void a(long j) {
            DisposableHelper.replace(this, this.d.scheduleDirect(this, j, this.c));
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            a(this.b);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            this.g = th;
            a(this.e ? this.b : 0);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            this.f = t;
            a(this.b);
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.g;
            if (th != null) {
                this.a.onError(th);
                return;
            }
            T t = this.f;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onComplete();
            }
        }
    }

    public MaybeDelay(MaybeSource<T> maybeSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(maybeSource);
        this.a = j;
        this.b = timeUnit;
        this.c = scheduler;
        this.d = z;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new a(maybeObserver, this.a, this.b, this.c, this.d));
    }
}
