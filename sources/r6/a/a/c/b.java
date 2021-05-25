package r6.a.a.c;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
public final class b<T> extends a implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver {
    private static final long serialVersionUID = 8924480688481408726L;
    public final Consumer<? super T> d;

    public b(CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        super(compositeDisposable, consumer2, action);
        this.d = consumer;
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            try {
                this.d.accept(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }
}
