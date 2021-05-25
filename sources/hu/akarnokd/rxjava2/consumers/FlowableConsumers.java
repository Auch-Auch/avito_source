package hu.akarnokd.rxjava2.consumers;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import r6.a.a.c.d;
public final class FlowableConsumers {
    public FlowableConsumers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Disposable subscribeAutoDispose(Flowable<T> flowable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(flowable, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        d dVar = new d(compositeDisposable, consumer, null, Functions.EMPTY_ACTION);
        compositeDisposable.add(dVar);
        flowable.subscribe((FlowableSubscriber) dVar);
        return dVar;
    }

    public static <T> Disposable subscribeAutoDispose(Flowable<T> flowable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObjectHelper.requireNonNull(flowable, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        d dVar = new d(compositeDisposable, consumer, consumer2, Functions.EMPTY_ACTION);
        compositeDisposable.add(dVar);
        flowable.subscribe((FlowableSubscriber) dVar);
        return dVar;
    }

    public static <T> Disposable subscribeAutoDispose(Flowable<T> flowable, CompositeDisposable compositeDisposable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.requireNonNull(flowable, "source is null");
        ObjectHelper.requireNonNull(compositeDisposable, "composite is null");
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        d dVar = new d(compositeDisposable, consumer, consumer2, action);
        compositeDisposable.add(dVar);
        flowable.subscribe((FlowableSubscriber) dVar);
        return dVar;
    }
}
