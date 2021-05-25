package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
public final class MaybeAmb<T> extends Maybe<T> {
    public final MaybeSource<? extends T>[] a;
    public final Iterable<? extends MaybeSource<? extends T>> b;

    public static final class a<T> implements MaybeObserver<T> {
        public final MaybeObserver<? super T> a;
        public final AtomicBoolean b;
        public final CompositeDisposable c;
        public Disposable d;

        public a(MaybeObserver<? super T> maybeObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
            this.a = maybeObserver;
            this.c = compositeDisposable;
            this.b = atomicBoolean;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.b.compareAndSet(false, true)) {
                this.c.delete(this.d);
                this.c.dispose();
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (this.b.compareAndSet(false, true)) {
                this.c.delete(this.d);
                this.c.dispose();
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.d = disposable;
            this.c.add(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            if (this.b.compareAndSet(false, true)) {
                this.c.delete(this.d);
                this.c.dispose();
                this.a.onSuccess(t);
            }
        }
    }

    public MaybeAmb(MaybeSource<? extends T>[] maybeSourceArr, Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.a = maybeSourceArr;
        this.b = iterable;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        int i;
        MaybeSource<? extends T>[] maybeSourceArr = this.a;
        if (maybeSourceArr == null) {
            maybeSourceArr = new MaybeSource[8];
            try {
                i = 0;
                for (MaybeSource<? extends T> maybeSource : this.b) {
                    if (maybeSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), maybeObserver);
                        return;
                    }
                    if (i == maybeSourceArr.length) {
                        MaybeSource<? extends T>[] maybeSourceArr2 = new MaybeSource[((i >> 2) + i)];
                        System.arraycopy(maybeSourceArr, 0, maybeSourceArr2, 0, i);
                        maybeSourceArr = maybeSourceArr2;
                    }
                    int i2 = i + 1;
                    maybeSourceArr[i] = maybeSource;
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, maybeObserver);
                return;
            }
        } else {
            i = maybeSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        maybeObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (int i3 = 0; i3 < i; i3++) {
            MaybeSource<? extends T> maybeSource2 = maybeSourceArr[i3];
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (maybeSource2 == null) {
                compositeDisposable.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the MaybeSources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    maybeObserver.onError(nullPointerException);
                    return;
                } else {
                    RxJavaPlugins.onError(nullPointerException);
                    return;
                }
            } else {
                maybeSource2.subscribe(new a(maybeObserver, compositeDisposable, atomicBoolean));
            }
        }
        if (i == 0) {
            maybeObserver.onComplete();
        }
    }
}
