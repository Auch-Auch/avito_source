package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Consumer<Throwable>, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -4361286194466301354L;
    public final Consumer<? super Throwable> a;
    public final Action b;

    public CallbackCompletableObserver(Action action) {
        this.a = this;
        this.b = action;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.observers.LambdaConsumerIntrospection
    public boolean hasCustomOnError() {
        return this.a != this;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        try {
            this.b.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        try {
            this.a.accept(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void accept(Throwable th) {
        RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
    }

    public CallbackCompletableObserver(Consumer<? super Throwable> consumer, Action action) {
        this.a = consumer;
        this.b = action;
    }
}
