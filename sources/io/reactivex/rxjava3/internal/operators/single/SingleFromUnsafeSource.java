package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
public final class SingleFromUnsafeSource<T> extends Single<T> {
    public final SingleSource<T> a;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.a = singleSource;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(singleObserver);
    }
}
