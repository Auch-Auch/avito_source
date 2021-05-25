package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
public final class CompletableConcatArray extends Completable {
    public final CompletableSource[] a;

    public static final class a extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        public final CompletableObserver a;
        public final CompletableSource[] b;
        public int c;
        public final SequentialDisposable d = new SequentialDisposable();

        public a(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
            this.a = completableObserver;
            this.b = completableSourceArr;
        }

        public void a() {
            if (!this.d.isDisposed() && getAndIncrement() == 0) {
                CompletableSource[] completableSourceArr = this.b;
                while (!this.d.isDisposed()) {
                    int i = this.c;
                    this.c = i + 1;
                    if (i == completableSourceArr.length) {
                        this.a.onComplete();
                        return;
                    }
                    completableSourceArr[i].subscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.d.replace(disposable);
        }
    }

    public CompletableConcatArray(CompletableSource[] completableSourceArr) {
        this.a = completableSourceArr;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        a aVar = new a(completableObserver, this.a);
        completableObserver.onSubscribe(aVar.d);
        aVar.a();
    }
}
