package r6.a.a.c;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
public final class c<T> extends a implements Observer<T> {
    private static final long serialVersionUID = 8924480688481408726L;
    public final Consumer<? super T> d;

    public c(CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        super(compositeDisposable, consumer2, action);
        this.d = consumer;
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (get() != DisposableHelper.DISPOSED) {
            try {
                this.d.accept(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                ((Disposable) get()).dispose();
                onError(th);
            }
        }
    }
}
