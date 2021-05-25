package hu.akarnokd.rxjava3.consumers;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import r6.a.b.d.d;
public final class FlowableConsumers {
    public FlowableConsumers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Disposable subscribeAutoDispose(Flowable<T> flowable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer) {
        Objects.requireNonNull(flowable, "source is null");
        Objects.requireNonNull(compositeDisposable, "composite is null");
        Objects.requireNonNull(consumer, "onNext is null");
        d dVar = new d(compositeDisposable, consumer, null, Functions.EMPTY_ACTION);
        compositeDisposable.add(dVar);
        flowable.subscribe((FlowableSubscriber) dVar);
        return dVar;
    }

    public static <T> Disposable subscribeAutoDispose(Flowable<T> flowable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        Objects.requireNonNull(flowable, "source is null");
        Objects.requireNonNull(compositeDisposable, "composite is null");
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        d dVar = new d(compositeDisposable, consumer, consumer2, Functions.EMPTY_ACTION);
        compositeDisposable.add(dVar);
        flowable.subscribe((FlowableSubscriber) dVar);
        return dVar;
    }

    public static <T> Disposable subscribeAutoDispose(Flowable<T> flowable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        Objects.requireNonNull(flowable, "source is null");
        Objects.requireNonNull(compositeDisposable, "composite is null");
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        d dVar = new d(compositeDisposable, consumer, consumer2, action);
        compositeDisposable.add(dVar);
        flowable.subscribe((FlowableSubscriber) dVar);
        return dVar;
    }
}
