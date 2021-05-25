package hu.akarnokd.rxjava3.operators;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Function4;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.schedulers.ImmediateThinScheduler;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import r6.a.b.i.m0;
import r6.a.b.i.p;
import r6.a.b.i.r;
import r6.a.b.i.v;
import r6.a.b.i.x;
import r6.a.b.i.y;
public final class Flowables {
    public Flowables() {
        throw new IllegalStateException("No instances!");
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, S> Flowable<T> generateAsync(Supplier<S> supplier, BiFunction<S, FlowableAsyncEmitter<T>, S> biFunction, Consumer<? super S> consumer) {
        Objects.requireNonNull(supplier, "initialState is null");
        Objects.requireNonNull(biFunction, "asyncGenerator is null");
        Objects.requireNonNull(consumer, "stateCleanup is null");
        return RxJavaPlugins.onAssembly(new p(supplier, biFunction, consumer));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public static Flowable<Long> intervalBackpressure(long j, TimeUnit timeUnit) {
        return intervalBackpressure(j, j, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(Publisher<T>... publisherArr) {
        return orderedMerge(Comparator.naturalOrder(), false, Flowable.bufferSize(), (Publisher[]) publisherArr);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> repeat(T t) {
        Objects.requireNonNull(t, "item is null");
        return RxJavaPlugins.onAssembly(new x(t));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> repeatSupplier(Supplier<T> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly(new y(supplier));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> zipLatest(Function<? super Object[], ? extends R> function, Publisher<? extends T>... publisherArr) {
        return zipLatest(function, ImmediateThinScheduler.INSTANCE, publisherArr);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public static Flowable<Long> intervalBackpressure(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return intervalBackpressure(j, j, timeUnit, scheduler);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(boolean z, Publisher<T>... publisherArr) {
        return orderedMerge(Comparator.naturalOrder(), z, Flowable.bufferSize(), publisherArr);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SafeVarargs
    @SchedulerSupport("custom")
    public static <T, R> Flowable<R> zipLatest(Function<? super Object[], ? extends R> function, Scheduler scheduler, Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(function, "combiner is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        Objects.requireNonNull(publisherArr, "sources is null");
        return RxJavaPlugins.onAssembly(new m0(publisherArr, null, function, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public static Flowable<Long> intervalBackpressure(long j, long j2, TimeUnit timeUnit) {
        return intervalBackpressure(j, j2, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(boolean z, int i, Publisher<T>... publisherArr) {
        return orderedMerge(Comparator.naturalOrder(), z, i, publisherArr);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public static Flowable<Long> intervalBackpressure(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly(new r(j, j2, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T> Flowable<T> orderedMerge(Comparator<? super T> comparator, Publisher<T>... publisherArr) {
        return orderedMerge((Comparator) comparator, false, Flowable.bufferSize(), (Publisher[]) publisherArr);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T> Flowable<T> orderedMerge(Comparator<? super T> comparator, boolean z, Publisher<T>... publisherArr) {
        return orderedMerge(comparator, z, Flowable.bufferSize(), publisherArr);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SafeVarargs
    @SchedulerSupport("none")
    public static <T> Flowable<T> orderedMerge(Comparator<? super T> comparator, boolean z, int i, Publisher<T>... publisherArr) {
        Objects.requireNonNull(comparator, "comparator is null");
        Objects.requireNonNull(publisherArr, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return RxJavaPlugins.onAssembly(new v(publisherArr, null, comparator, z, i));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> zipLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return zipLatest(iterable, function, ImmediateThinScheduler.INSTANCE);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public static <T, R> Flowable<R> zipLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, Scheduler scheduler) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(function, "combiner is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new m0(null, iterable, function, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable, Comparator<? super T> comparator) {
        return orderedMerge((Iterable) iterable, (Comparator) comparator, false, Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable, Comparator<? super T> comparator, boolean z) {
        return orderedMerge(iterable, comparator, z, Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static <T1, T2, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        return zipLatest(publisher, publisher2, biFunction, ImmediateThinScheduler.INSTANCE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable, Comparator<? super T> comparator, boolean z, int i) {
        Objects.requireNonNull(comparator, "comparator is null");
        Objects.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return RxJavaPlugins.onAssembly(new v(null, iterable, comparator, z, i));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public static <T1, T2, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, Scheduler scheduler) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new m0(new Publisher[]{publisher, publisher2}, null, Functions.toFunction(biFunction), scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable) {
        return orderedMerge((Iterable) iterable, Comparator.naturalOrder(), false, Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable, boolean z) {
        return orderedMerge(iterable, Comparator.naturalOrder(), z, Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(Iterable<? extends Publisher<T>> iterable, boolean z, int i) {
        return orderedMerge(iterable, Comparator.naturalOrder(), z, i);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static <T1, T2, T3, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        return zipLatest(publisher, publisher2, publisher3, function3, ImmediateThinScheduler.INSTANCE);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public static <T1, T2, T3, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3, Scheduler scheduler) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(function3, "combiner is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new m0(new Publisher[]{publisher, publisher2, publisher3}, null, Functions.toFunction(function3), scheduler));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Publisher<T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        return zipLatest(publisher, publisher2, publisher3, publisher4, function4, ImmediateThinScheduler.INSTANCE);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public static <T1, T2, T3, T4, R> Flowable<R> zipLatest(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Publisher<T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4, Scheduler scheduler) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(function4, "combiner is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new m0(new Publisher[]{publisher, publisher2, publisher3, publisher4}, null, Functions.toFunction(function4), scheduler));
    }
}
