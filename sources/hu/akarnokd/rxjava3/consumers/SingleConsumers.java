package hu.akarnokd.rxjava3.consumers;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import r6.a.b.d.b;
public final class SingleConsumers {
    public SingleConsumers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Disposable subscribeAutoDispose(Single<T> single, CompositeDisposable compositeDisposable, Consumer<? super T> consumer) {
        Objects.requireNonNull(single, "source is null");
        Objects.requireNonNull(compositeDisposable, "composite is null");
        Objects.requireNonNull(consumer, "onSuccess is null");
        b bVar = new b(compositeDisposable, consumer, null, Functions.EMPTY_ACTION);
        compositeDisposable.add(bVar);
        single.subscribe(bVar);
        return bVar;
    }

    public static <T> Disposable subscribeAutoDispose(Single<T> single, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        Objects.requireNonNull(single, "source is null");
        Objects.requireNonNull(compositeDisposable, "composite is null");
        Objects.requireNonNull(consumer, "onSuccess is null");
        Objects.requireNonNull(consumer2, "onError is null");
        b bVar = new b(compositeDisposable, consumer, consumer2, Functions.EMPTY_ACTION);
        compositeDisposable.add(bVar);
        single.subscribe(bVar);
        return bVar;
    }
}
