package hu.akarnokd.rxjava3.consumers;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import r6.a.b.d.b;
public final class MaybeConsumers {
    public MaybeConsumers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Disposable subscribeAutoDispose(Maybe<T> maybe, CompositeDisposable compositeDisposable, Consumer<? super T> consumer) {
        Objects.requireNonNull(maybe, "source is null");
        Objects.requireNonNull(compositeDisposable, "composite is null");
        Objects.requireNonNull(consumer, "onSuccess is null");
        b bVar = new b(compositeDisposable, consumer, null, Functions.EMPTY_ACTION);
        compositeDisposable.add(bVar);
        maybe.subscribe(bVar);
        return bVar;
    }

    public static <T> Disposable subscribeAutoDispose(Maybe<T> maybe, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        Objects.requireNonNull(maybe, "source is null");
        Objects.requireNonNull(compositeDisposable, "composite is null");
        Objects.requireNonNull(consumer, "onSuccess is null");
        Objects.requireNonNull(consumer2, "onError is null");
        b bVar = new b(compositeDisposable, consumer, consumer2, Functions.EMPTY_ACTION);
        compositeDisposable.add(bVar);
        maybe.subscribe(bVar);
        return bVar;
    }

    public static <T> Disposable subscribeAutoDispose(Maybe<T> maybe, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        Objects.requireNonNull(maybe, "source is null");
        Objects.requireNonNull(compositeDisposable, "composite is null");
        Objects.requireNonNull(consumer, "onSuccess is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        b bVar = new b(compositeDisposable, consumer, consumer2, action);
        compositeDisposable.add(bVar);
        maybe.subscribe(bVar);
        return bVar;
    }
}
