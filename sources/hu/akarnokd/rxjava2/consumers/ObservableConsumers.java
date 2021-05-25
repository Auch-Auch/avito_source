package hu.akarnokd.rxjava2.consumers;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import r6.a.a.c.c;
public final class ObservableConsumers {
    public ObservableConsumers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Disposable subscribeAutoDispose(Observable<T> observable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(observable, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        c cVar = new c(compositeDisposable, consumer, null, Functions.EMPTY_ACTION);
        compositeDisposable.add(cVar);
        observable.subscribe(cVar);
        return cVar;
    }

    public static <T> Disposable subscribeAutoDispose(Observable<T> observable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObjectHelper.requireNonNull(observable, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        c cVar = new c(compositeDisposable, consumer, consumer2, Functions.EMPTY_ACTION);
        compositeDisposable.add(cVar);
        observable.subscribe(cVar);
        return cVar;
    }

    public static <T> Disposable subscribeAutoDispose(Observable<T> observable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.requireNonNull(observable, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        c cVar = new c(compositeDisposable, consumer, consumer2, action);
        compositeDisposable.add(cVar);
        observable.subscribe(cVar);
        return cVar;
    }
}
