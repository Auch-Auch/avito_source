package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
public final class SingleEquals<T> extends Single<Boolean> {
    public final SingleSource<? extends T> a;
    public final SingleSource<? extends T> b;

    public static class a<T> implements SingleObserver<T> {
        public final int a;
        public final CompositeDisposable b;
        public final Object[] c;
        public final SingleObserver<? super Boolean> d;
        public final AtomicInteger e;

        public a(int i, CompositeDisposable compositeDisposable, Object[] objArr, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
            this.a = i;
            this.b = compositeDisposable;
            this.c = objArr;
            this.d = singleObserver;
            this.e = atomicInteger;
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            int andSet = this.e.getAndSet(-1);
            if (andSet == 0 || andSet == 1) {
                this.b.dispose();
                this.d.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.b.add(disposable);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            this.c[this.a] = t;
            if (this.e.incrementAndGet() == 2) {
                SingleObserver<? super Boolean> singleObserver = this.d;
                Object[] objArr = this.c;
                singleObserver.onSuccess(Boolean.valueOf(Objects.equals(objArr[0], objArr[1])));
            }
        }
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.a = singleSource;
        this.b = singleSource2;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        this.a.subscribe(new a(0, compositeDisposable, objArr, singleObserver, atomicInteger));
        this.b.subscribe(new a(1, compositeDisposable, objArr, singleObserver, atomicInteger));
    }
}
