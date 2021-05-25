package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableAutoConnect;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservablePublishClassic;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
public abstract class ConnectableObservable<T> extends Observable<T> {
    public final ConnectableObservable<T> a() {
        return this instanceof ObservablePublishClassic ? RxJavaPlugins.onAssembly((ConnectableObservable) new ObservablePublishAlt(((ObservablePublishClassic) this).publishSource())) : this;
    }

    @NonNull
    public Observable<T> autoConnect() {
        return autoConnect(1);
    }

    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    @SchedulerSupport("none")
    @CheckReturnValue
    @NonNull
    public Observable<T> refCount() {
        return RxJavaPlugins.onAssembly(new ObservableRefCount(a()));
    }

    @NonNull
    public Observable<T> autoConnect(int i) {
        return autoConnect(i, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> refCount(int i) {
        return refCount(i, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    @NonNull
    public Observable<T> autoConnect(int i, @NonNull Consumer<? super Disposable> consumer) {
        if (i > 0) {
            return RxJavaPlugins.onAssembly(new ObservableAutoConnect(this, i, consumer));
        }
        connect(consumer);
        return RxJavaPlugins.onAssembly((ConnectableObservable) this);
    }

    @SchedulerSupport("io.reactivex:computation")
    @CheckReturnValue
    public final Observable<T> refCount(long j, TimeUnit timeUnit) {
        return refCount(1, j, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> refCount(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return refCount(1, j, timeUnit, scheduler);
    }

    @SchedulerSupport("io.reactivex:computation")
    @CheckReturnValue
    public final Observable<T> refCount(int i, long j, TimeUnit timeUnit) {
        return refCount(i, j, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> refCount(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i, "subscriberCount");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableRefCount(a(), i, j, timeUnit, scheduler));
    }
}
