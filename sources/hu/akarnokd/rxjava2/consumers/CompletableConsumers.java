package hu.akarnokd.rxjava2.consumers;

import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import r6.a.a.c.b;
public final class CompletableConsumers {
    public CompletableConsumers() {
        throw new IllegalStateException("No instances!");
    }

    public static Disposable subscribeAutoDispose(Completable completable, CompositeDisposable compositeDisposable, Action action) {
        ObjectHelper.requireNonNull(completable, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        b bVar = new b(compositeDisposable, Functions.emptyConsumer(), null, action);
        compositeDisposable.add(bVar);
        completable.subscribe(bVar);
        return bVar;
    }

    public static Disposable subscribeAutoDispose(Completable completable, CompositeDisposable compositeDisposable, Action action, Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(completable, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(action, "onSuccess is null");
        ObjectHelper.requireNonNull(consumer, "onError is null");
        b bVar = new b(compositeDisposable, Functions.emptyConsumer(), consumer, action);
        compositeDisposable.add(bVar);
        completable.subscribe(bVar);
        return bVar;
    }
}
