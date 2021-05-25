package hu.akarnokd.rxjava2.consumers;

import io.reactivex.Maybe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import r6.a.a.c.b;
public final class MaybeConsumers {
    public MaybeConsumers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Disposable subscribeAutoDispose(Maybe<T> maybe, CompositeDisposable compositeDisposable, Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(maybe, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        b bVar = new b(compositeDisposable, consumer, null, Functions.EMPTY_ACTION);
        compositeDisposable.add(bVar);
        maybe.subscribe(bVar);
        return bVar;
    }

    public static <T> Disposable subscribeAutoDispose(Maybe<T> maybe, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObjectHelper.requireNonNull(maybe, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        b bVar = new b(compositeDisposable, consumer, consumer2, Functions.EMPTY_ACTION);
        compositeDisposable.add(bVar);
        maybe.subscribe(bVar);
        return bVar;
    }

    public static <T> Disposable subscribeAutoDispose(Maybe<T> maybe, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.requireNonNull(maybe, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        b bVar = new b(compositeDisposable, consumer, consumer2, action);
        compositeDisposable.add(bVar);
        maybe.subscribe(bVar);
        return bVar;
    }
}
