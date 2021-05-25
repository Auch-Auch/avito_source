package hu.akarnokd.rxjava3.consumers;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import r6.a.b.d.b;
public final class CompletableConsumers {
    public CompletableConsumers() {
        throw new IllegalStateException("No instances!");
    }

    public static Disposable subscribeAutoDispose(Completable completable, CompositeDisposable compositeDisposable, Action action) {
        Objects.requireNonNull(completable, "source is null");
        Objects.requireNonNull(compositeDisposable, "composite is null");
        Objects.requireNonNull(action, "onComplete is null");
        b bVar = new b(compositeDisposable, Functions.emptyConsumer(), null, action);
        compositeDisposable.add(bVar);
        completable.subscribe(bVar);
        return bVar;
    }

    public static Disposable subscribeAutoDispose(Completable completable, CompositeDisposable compositeDisposable, Action action, Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(completable, "source is null");
        Objects.requireNonNull(compositeDisposable, "composite is null");
        Objects.requireNonNull(action, "onSuccess is null");
        Objects.requireNonNull(consumer, "onError is null");
        b bVar = new b(compositeDisposable, Functions.emptyConsumer(), consumer, action);
        compositeDisposable.add(bVar);
        completable.subscribe(bVar);
        return bVar;
    }
}
