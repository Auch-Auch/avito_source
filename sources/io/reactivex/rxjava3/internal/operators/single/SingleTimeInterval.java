package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;
public final class SingleTimeInterval<T> extends Single<Timed<T>> {
    public final SingleSource<T> a;
    public final TimeUnit b;
    public final Scheduler c;
    public final boolean d;

    public static final class a<T> implements SingleObserver<T>, Disposable {
        public final SingleObserver<? super Timed<T>> a;
        public final TimeUnit b;
        public final Scheduler c;
        public final long d;
        public Disposable e;

        public a(SingleObserver<? super Timed<T>> singleObserver, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.a = singleObserver;
            this.b = timeUnit;
            this.c = scheduler;
            this.d = z ? scheduler.now(timeUnit) : 0;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.e.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onError(@NonNull Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(@NonNull T t) {
            this.a.onSuccess(new Timed(t, this.c.now(this.b) - this.d, this.b));
        }
    }

    public SingleTimeInterval(SingleSource<T> singleSource, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.a = singleSource;
        this.b = timeUnit;
        this.c = scheduler;
        this.d = z;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(@NonNull SingleObserver<? super Timed<T>> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b, this.c, this.d));
    }
}
