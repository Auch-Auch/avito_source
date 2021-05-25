package hu.akarnokd.rxjava2.operators;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.ImmediateThinScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import r6.a.a.h.g0;
import r6.a.a.h.k;
import r6.a.a.h.m;
import r6.a.a.h.q;
import r6.a.a.h.s;
import r6.a.a.h.t;
public final class Flowables {
    public Flowables() {
        throw new IllegalStateException("No instances!");
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, S> Flowable<T> generateAsync(Callable<S> callable, BiFunction<S, FlowableAsyncEmitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(callable, "initialState is null");
        ObjectHelper.requireNonNull(biFunction, "asyncGenerator is null");
        ObjectHelper.requireNonNull(consumer, "stateCleanup is null");
        return RxJavaPlugins.onAssembly(new k(callable, biFunction, consumer));
    }

    @SchedulerSupport("io.reactivex:computation")
    @BackpressureSupport(BackpressureKind.FULL)
    public static Flowable<Long> intervalBackpressure(long j, TimeUnit timeUnit) {
        return intervalBackpressure(j, j, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(Publisher<T>... publisherArr) {
        return orderedMerge(Functions.naturalOrder(), false, Flowable.bufferSize(), (Publisher[]) publisherArr);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> Flowable<T> repeat(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return RxJavaPlugins.onAssembly(new t(t));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> Flowable<T> repeatCallable(Callable<T> callable) {
        ObjectHelper.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.onAssembly(new s(callable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T, R> Flowable<R> zipLatest(Function<? super Object[], ? extends R> function, Publisher<? extends T>... publisherArr) {
        return zipLatest(function, ImmediateThinScheduler.INSTANCE, publisherArr);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    public static Flowable<Long> intervalBackpressure(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return intervalBackpressure(j, j, timeUnit, scheduler);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(boolean z, Publisher<T>... publisherArr) {
        return orderedMerge(Functions.naturalOrder(), z, Flowable.bufferSize(), publisherArr);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T, R> Flowable<R> zipLatest(Function<? super Object[], ? extends R> function, Scheduler scheduler, Publisher<? extends T>... publisherArr) {
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(publisherArr, "sources is null");
        return RxJavaPlugins.onAssembly(new g0(publisherArr, null, function, scheduler));
    }

    @SchedulerSupport("io.reactivex:computation")
    @BackpressureSupport(BackpressureKind.FULL)
    public static Flowable<Long> intervalBackpressure(long j, long j2, TimeUnit timeUnit) {
        return intervalBackpressure(j, j2, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(boolean z, int i, Publisher<T>... publisherArr) {
        return orderedMerge(Functions.naturalOrder(), z, i, publisherArr);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    public static Flowable<Long> intervalBackpressure(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly(new m(j, j2, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> Flowable<T> orderedMerge(Comparator<? super T> comparator, Publisher<T>... publisherArr) {
        return orderedMerge((Comparator) comparator, false, Flowable.bufferSize(), (Publisher[]) publisherArr);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> Flowable<T> orderedMerge(Comparator<? super T> comparator, boolean z, Publisher<T>... publisherArr) {
        return orderedMerge(comparator, z, Flowable.bufferSize(), publisherArr);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> Flowable<T> orderedMerge(Comparator<? super T> comparator, boolean z, int i, Publisher<T>... publisherArr) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        ObjectHelper.requireNonNull(publisherArr, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return RxJavaPlugins.onAssembly(new q(publisherArr, null, comparator, z, i));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T, R> Flowable<R> zipLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return zipLatest(iterable, function, ImmediateThinScheduler.INSTANCE);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T, R> Flowable<R> zipLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, Scheduler scheduler) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new g0(null, iterable, function, scheduler));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable, Comparator<? super T> comparator) {
        return orderedMerge((Iterable) iterable, (Comparator) comparator, false, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable, Comparator<? super T> comparator, boolean z) {
        return orderedMerge(iterable, comparator, z, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T1, T2, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        return zipLatest(publisher, publisher2, biFunction, ImmediateThinScheduler.INSTANCE);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable, Comparator<? super T> comparator, boolean z, int i) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return RxJavaPlugins.onAssembly(new q(null, iterable, comparator, z, i));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T1, T2, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, Scheduler scheduler) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(biFunction, "combiner is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new g0(new Publisher[]{publisher, publisher2}, null, Functions.toFunction(biFunction), scheduler));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable) {
        return orderedMerge((Iterable) iterable, Functions.naturalOrder(), false, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable, boolean z) {
        return orderedMerge(iterable, Functions.naturalOrder(), z, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable, boolean z, int i) {
        return orderedMerge(iterable, Functions.naturalOrder(), z, i);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T1, T2, T3, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        return zipLatest(publisher, publisher2, publisher3, function3, ImmediateThinScheduler.INSTANCE);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T1, T2, T3, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3, Scheduler scheduler) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(function3, "combiner is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new g0(new Publisher[]{publisher, publisher2, publisher3}, null, Functions.toFunction(function3), scheduler));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T1, T2, T3, T4, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Publisher<T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        return zipLatest(publisher, publisher2, publisher3, publisher4, function4, ImmediateThinScheduler.INSTANCE);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T1, T2, T3, T4, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Publisher<T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4, Scheduler scheduler) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(function4, "combiner is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new g0(new Publisher[]{publisher, publisher2, publisher3, publisher4}, null, Functions.toFunction(function4), scheduler));
    }
}
