package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
public interface MaybeObserver<T> {
    @Override // io.reactivex.rxjava3.core.CompletableObserver
    void onComplete();

    @Override // io.reactivex.rxjava3.core.SingleObserver
    void onError(@NonNull Throwable th);

    @Override // io.reactivex.rxjava3.core.SingleObserver
    void onSubscribe(@NonNull Disposable disposable);

    @Override // io.reactivex.rxjava3.core.SingleObserver
    void onSuccess(@NonNull T t);
}
