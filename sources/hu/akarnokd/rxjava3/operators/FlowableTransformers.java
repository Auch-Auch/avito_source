package hu.akarnokd.rxjava3.operators;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import hu.akarnokd.rxjava3.util.BiFunctionSecondIdentity;
import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import r6.a.b.i.a0;
import r6.a.b.i.b0;
import r6.a.b.i.c0;
import r6.a.b.i.d0;
import r6.a.b.i.e0;
import r6.a.b.i.f;
import r6.a.b.i.f0;
import r6.a.b.i.g;
import r6.a.b.i.g0;
import r6.a.b.i.h;
import r6.a.b.i.i;
import r6.a.b.i.i0;
import r6.a.b.i.j;
import r6.a.b.i.k;
import r6.a.b.i.k0;
import r6.a.b.i.l;
import r6.a.b.i.l0;
import r6.a.b.i.m;
import r6.a.b.i.n;
import r6.a.b.i.o;
import r6.a.b.i.q;
import r6.a.b.i.s;
import r6.a.b.i.t;
import r6.a.b.i.u;
import r6.a.b.i.w;
import r6.a.b.i.z;
public final class FlowableTransformers {
    public FlowableTransformers() {
        throw new IllegalStateException("No instances!");
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, List<T>> bufferSplit(Predicate<? super T> predicate) {
        return bufferSplit(predicate, Functions.createArrayList(16));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, List<T>> bufferUntil(Predicate<? super T> predicate) {
        return bufferUntil(predicate, Functions.createArrayList(16));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, List<T>> bufferWhile(Predicate<? super T> predicate) {
        return bufferWhile(predicate, Functions.createArrayList(16));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, T> cacheLast() {
        return new g(null);
    }

    public static <T, R> FlowableTransformer<T, R> coalesce(Supplier<R> supplier, BiConsumer<R, T> biConsumer) {
        return coalesce(supplier, biConsumer, Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public static <T> FlowableTransformer<T, T> debounceFirst(long j, TimeUnit timeUnit) {
        return debounceFirst(j, timeUnit, Schedulers.computation());
    }

    public static <T, R> FlowableTransformer<T, R> errorJump(FlowableTransformer<T, R> flowableTransformer) {
        Objects.requireNonNull(flowableTransformer, "transformer");
        return new j(null, flowableTransformer);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, T> every(long j) {
        ObjectHelper.verifyPositive(j, "keep");
        return new k(null, j);
    }

    public static <T> FlowableTransformer<T, T> expand(Function<? super T, ? extends Publisher<? extends T>> function) {
        return expand(function, ExpandStrategy.DEPTH_FIRST, Flowable.bufferSize());
    }

    public static <T> FlowableTransformer<T, T> expandDelayError(Function<? super T, ? extends Publisher<? extends T>> function) {
        return expandDelayError(function, ExpandStrategy.DEPTH_FIRST, Flowable.bufferSize());
    }

    public static <T> FlowableTransformer<T, T> filterAsync(Function<? super T, ? extends Publisher<Boolean>> function) {
        return filterAsync(function, Flowable.bufferSize());
    }

    public static <T, R> FlowableTransformer<T, R> flatMapAsync(Function<? super T, ? extends Publisher<? extends R>> function, Scheduler scheduler) {
        return flatMapAsync(function, scheduler, 32, Flowable.bufferSize(), true);
    }

    public static <T, R> FlowableTransformer<T, R> flatMapSync(Function<? super T, ? extends Publisher<? extends R>> function) {
        return flatMapSync(function, 32, Flowable.bufferSize(), true);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, Long> indexOf(Predicate<? super T> predicate) {
        return new q(null, predicate);
    }

    public static <T, R> FlowableTransformer<T, R> mapAsync(Function<? super T, ? extends Publisher<? extends R>> function) {
        return mapAsync(function, BiFunctionSecondIdentity.instance(), Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public static <T, R> FlowableTransformer<T, R> mapFilter(BiConsumer<? super T, ? super BasicEmitter<R>> biConsumer) {
        Objects.requireNonNull(biConsumer, "consumer is null");
        return new t(null, biConsumer);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("io.reactivex:computation")
    public static <T> FlowableTransformer<T, T> onBackpressureTimeout(long j, TimeUnit timeUnit) {
        return onBackpressureTimeout(j, timeUnit, Schedulers.computation());
    }

    public static <T, I, A, R> FlowableTransformer<T, R> partialCollect(Consumer<? super PartialCollectEmitter<T, I, A, R>> consumer, Consumer<? super T> consumer2, int i) {
        Objects.requireNonNull(consumer, "handler is null");
        Objects.requireNonNull(consumer2, "cleaner is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return new w(null, consumer, consumer2, i);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> requestObserveOn(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler == null");
        return new z(null, scheduler);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> requestSample(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return requestSample(j, j, timeUnit, scheduler);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public static <T> FlowableTransformer<T, T> spanout(long j, TimeUnit timeUnit) {
        return spanout(0, j, timeUnit, Schedulers.computation(), false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, R> FlowableTransformer<T, R> switchFlatMap(Function<? super T, ? extends Publisher<? extends R>> function, int i) {
        return switchFlatMap(function, i, Flowable.bufferSize());
    }

    public static <T> FlowableTransformer<T, T> switchIfEmpty(Iterable<? extends Publisher<? extends T>> iterable) {
        return new e0(null, iterable);
    }

    @SafeVarargs
    public static <T> FlowableTransformer<T, T> switchIfEmptyArray(Publisher<? extends T>... publisherArr) {
        return new f0(null, publisherArr);
    }

    public static <T> FlowableTransformer<T, T> switchOnFirst(Predicate<? super T> predicate, Function<? super T, ? extends Publisher<? extends T>> function) {
        Objects.requireNonNull(predicate, "predicate");
        Objects.requireNonNull(function, "selector");
        return new g0(null, predicate, function);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("io.reactivex:computation")
    public static <T> FlowableTransformer<T, T> timeoutLast(long j, TimeUnit timeUnit) {
        return timeoutLast(j, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("io.reactivex:computation")
    public static <T> FlowableTransformer<T, T> timeoutLastAbsolute(long j, TimeUnit timeUnit) {
        return timeoutLastAbsolute(j, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, T> valve(Publisher<Boolean> publisher) {
        return valve(publisher, true, Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, Flowable<T>> windowSplit(Predicate<? super T> predicate) {
        return windowSplit(predicate, Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, Flowable<T>> windowUntil(Predicate<? super T> predicate) {
        return windowUntil(predicate, Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, Flowable<T>> windowWhile(Predicate<? super T> predicate) {
        return windowWhile(predicate, Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, C extends Collection<? super T>> FlowableTransformer<T, C> bufferSplit(Predicate<? super T> predicate, Supplier<C> supplier) {
        return new f(null, predicate, f.b.SPLIT, supplier);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, C extends Collection<? super T>> FlowableTransformer<T, C> bufferUntil(Predicate<? super T> predicate, Supplier<C> supplier) {
        return new f(null, predicate, f.b.AFTER, supplier);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, C extends Collection<? super T>> FlowableTransformer<T, C> bufferWhile(Predicate<? super T> predicate, Supplier<C> supplier) {
        return new f(null, predicate, f.b.BEFORE, supplier);
    }

    public static <T, R> FlowableTransformer<T, R> coalesce(Supplier<R> supplier, BiConsumer<R, T> biConsumer, int i) {
        Objects.requireNonNull(supplier, "containerSupplier is null");
        Objects.requireNonNull(biConsumer, "coalescer is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new h(null, supplier, biConsumer, i);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> debounceFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new i(null, j, timeUnit, scheduler);
    }

    public static <T> FlowableTransformer<T, T> expand(Function<? super T, ? extends Publisher<? extends T>> function, ExpandStrategy expandStrategy) {
        return expand(function, expandStrategy, Flowable.bufferSize());
    }

    public static <T> FlowableTransformer<T, T> expandDelayError(Function<? super T, ? extends Publisher<? extends T>> function, ExpandStrategy expandStrategy) {
        return expandDelayError(function, expandStrategy, Flowable.bufferSize());
    }

    public static <T> FlowableTransformer<T, T> filterAsync(Function<? super T, ? extends Publisher<Boolean>> function, int i) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new m(null, function, i);
    }

    public static <T, R> FlowableTransformer<T, R> flatMapAsync(Function<? super T, ? extends Publisher<? extends R>> function, Scheduler scheduler, boolean z) {
        return flatMapAsync(function, scheduler, 32, Flowable.bufferSize(), z);
    }

    public static <T, R> FlowableTransformer<T, R> flatMapSync(Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        return flatMapSync(function, 32, Flowable.bufferSize(), z);
    }

    public static <T, R> FlowableTransformer<T, R> mapAsync(Function<? super T, ? extends Publisher<? extends R>> function, int i) {
        return mapAsync(function, BiFunctionSecondIdentity.instance(), i);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> onBackpressureTimeout(long j, TimeUnit timeUnit, Scheduler scheduler, Consumer<? super T> consumer) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        Objects.requireNonNull(consumer, "onEvict is null");
        return new u(null, Integer.MAX_VALUE, j, timeUnit, scheduler, consumer);
    }

    public static <T> FlowableTransformer<T, T> requestSample(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return new b0(null, j, j2, timeUnit, scheduler);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> spanout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return spanout(0, j, timeUnit, scheduler, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, R> FlowableTransformer<T, R> switchFlatMap(Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "maxActive");
        ObjectHelper.verifyPositive(i2, "bufferSize");
        return new d0(null, function, i, i2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> timeoutLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new i0(null, j, timeUnit, scheduler, false);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> timeoutLastAbsolute(long j, TimeUnit timeUnit, Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new i0(null, j, timeUnit, scheduler, true);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, T> valve(Publisher<Boolean> publisher, boolean z) {
        return valve(publisher, z, Flowable.bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, Flowable<T>> windowSplit(Predicate<? super T> predicate, int i) {
        return new l0(null, predicate, l0.a.SPLIT, i);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, Flowable<T>> windowUntil(Predicate<? super T> predicate, int i) {
        return new l0(null, predicate, l0.a.AFTER, i);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, Flowable<T>> windowWhile(Predicate<? super T> predicate, int i) {
        return new l0(null, predicate, l0.a.BEFORE, i);
    }

    public static <T> FlowableTransformer<T, T> expand(Function<? super T, ? extends Publisher<? extends T>> function, ExpandStrategy expandStrategy, int i) {
        Objects.requireNonNull(function, "expander is null");
        Objects.requireNonNull(expandStrategy, "strategy is null");
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new l(null, function, expandStrategy, i, false);
    }

    public static <T> FlowableTransformer<T, T> expandDelayError(Function<? super T, ? extends Publisher<? extends T>> function, ExpandStrategy expandStrategy, int i) {
        Objects.requireNonNull(function, "expander is null");
        Objects.requireNonNull(expandStrategy, "strategy is null");
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new l(null, function, expandStrategy, i, true);
    }

    public static <T, R> FlowableTransformer<T, R> flatMapAsync(Function<? super T, ? extends Publisher<? extends R>> function, Scheduler scheduler, int i, int i2, boolean z) {
        return new n(null, function, i, i2, z, scheduler);
    }

    public static <T, R> FlowableTransformer<T, R> flatMapSync(Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, boolean z) {
        return new o(null, function, i, i2, z);
    }

    public static <T, U, R> FlowableTransformer<T, R> mapAsync(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return mapAsync(function, biFunction, Flowable.bufferSize());
    }

    public static <T, U> FlowableTransformer<T, T> requestSample(Publisher<U> publisher) {
        return new a0(null, publisher);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public static <T> FlowableTransformer<T, T> spanout(long j, long j2, TimeUnit timeUnit) {
        return spanout(j, j2, timeUnit, Schedulers.computation(), false);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public static <T> FlowableTransformer<T, T> valve(Publisher<Boolean> publisher, boolean z, int i) {
        Objects.requireNonNull(publisher, "other is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new k0(null, publisher, z, i);
    }

    public static <T, U, R> FlowableTransformer<T, R> mapAsync(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new s(null, function, biFunction, i);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> spanout(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return spanout(j, j2, timeUnit, scheduler, false);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public static <T> FlowableTransformer<T, T> spanout(long j, TimeUnit timeUnit, boolean z) {
        return spanout(0, j, timeUnit, Schedulers.computation(), z);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> onBackpressureTimeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return onBackpressureTimeout(Integer.MAX_VALUE, j, timeUnit, scheduler, Functions.emptyConsumer());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> spanout(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return spanout(0, j, timeUnit, scheduler, z);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> onBackpressureTimeout(int i, long j, TimeUnit timeUnit, Scheduler scheduler, Consumer<? super T> consumer) {
        ObjectHelper.verifyPositive(i, SDKConstants.PARAM_CONTEXT_MAX_SIZE);
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        Objects.requireNonNull(consumer, "onEvict is null");
        return new u(null, i, j, timeUnit, scheduler, consumer);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public static <T> FlowableTransformer<T, T> spanout(long j, long j2, TimeUnit timeUnit, boolean z) {
        return spanout(j, j2, timeUnit, Schedulers.computation(), z);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public static <T> FlowableTransformer<T, T> spanout(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new c0(null, j, j2, timeUnit, scheduler, z, Flowable.bufferSize());
    }
}
