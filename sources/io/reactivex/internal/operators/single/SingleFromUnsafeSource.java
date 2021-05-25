package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
public final class SingleFromUnsafeSource<T> extends Single<T> {
    public final SingleSource<T> a;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.a = singleSource;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(singleObserver);
    }
}
