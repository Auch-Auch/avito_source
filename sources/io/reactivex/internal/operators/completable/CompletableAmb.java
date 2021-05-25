package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
public final class CompletableAmb extends Completable {
    public final CompletableSource[] a;
    public final Iterable<? extends CompletableSource> b;

    public static final class a implements CompletableObserver {
        public final AtomicBoolean a;
        public final CompositeDisposable b;
        public final CompletableObserver c;
        public Disposable d;

        public a(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.a = atomicBoolean;
            this.b = compositeDisposable;
            this.c = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.a.compareAndSet(false, true)) {
                this.b.delete(this.d);
                this.b.dispose();
                this.c.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.a.compareAndSet(false, true)) {
                this.b.delete(this.d);
                this.b.dispose();
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.d = disposable;
            this.b.add(disposable);
        }
    }

    public CompletableAmb(CompletableSource[] completableSourceArr, Iterable<? extends CompletableSource> iterable) {
        this.a = completableSourceArr;
        this.b = iterable;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        int i;
        CompletableSource[] completableSourceArr = this.a;
        if (completableSourceArr == null) {
            completableSourceArr = new CompletableSource[8];
            try {
                i = 0;
                for (CompletableSource completableSource : this.b) {
                    if (completableSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), completableObserver);
                        return;
                    }
                    if (i == completableSourceArr.length) {
                        CompletableSource[] completableSourceArr2 = new CompletableSource[((i >> 2) + i)];
                        System.arraycopy(completableSourceArr, 0, completableSourceArr2, 0, i);
                        completableSourceArr = completableSourceArr2;
                    }
                    int i2 = i + 1;
                    completableSourceArr[i] = completableSource;
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, completableObserver);
                return;
            }
        } else {
            i = completableSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (int i3 = 0; i3 < i; i3++) {
            CompletableSource completableSource2 = completableSourceArr[i3];
            if (!compositeDisposable.isDisposed()) {
                if (completableSource2 == null) {
                    Throwable nullPointerException = new NullPointerException("One of the sources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        compositeDisposable.dispose();
                        completableObserver.onError(nullPointerException);
                        return;
                    }
                    RxJavaPlugins.onError(nullPointerException);
                    return;
                }
                completableSource2.subscribe(new a(atomicBoolean, compositeDisposable, completableObserver));
            } else {
                return;
            }
        }
        if (i == 0) {
            completableObserver.onComplete();
        }
    }
}
