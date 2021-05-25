package hu.akarnokd.rxjava2.operators;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import hu.akarnokd.rxjava2.util.BiFunctionSecondIdentity;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import r6.a.a.h.a;
import r6.a.a.h.a0;
import r6.a.a.h.b;
import r6.a.a.h.c;
import r6.a.a.h.c0;
import r6.a.a.h.d;
import r6.a.a.h.e;
import r6.a.a.h.e0;
import r6.a.a.h.f;
import r6.a.a.h.f0;
import r6.a.a.h.g;
import r6.a.a.h.h;
import r6.a.a.h.i;
import r6.a.a.h.j;
import r6.a.a.h.l;
import r6.a.a.h.n;
import r6.a.a.h.o;
import r6.a.a.h.p;
import r6.a.a.h.r;
import r6.a.a.h.u;
import r6.a.a.h.v;
import r6.a.a.h.w;
import r6.a.a.h.x;
import r6.a.a.h.y;
import r6.a.a.h.z;
public final class FlowableTransformers {
    public FlowableTransformers() {
        throw new IllegalStateException("No instances!");
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> FlowableTransformer<T, List<T>> bufferSplit(Predicate<? super T> predicate) {
        return bufferSplit(predicate, Functions.createArrayList(16));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> FlowableTransformer<T, List<T>> bufferUntil(Predicate<? super T> predicate) {
        return bufferUntil(predicate, Functions.createArrayList(16));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> FlowableTransformer<T, List<T>> bufferWhile(Predicate<? super T> predicate) {
        return bufferWhile(predicate, Functions.createArrayList(16));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> FlowableTransformer<T, T> cacheLast() {
        return new b(null);
    }

    public static <T, R> FlowableTransformer<T, R> coalesce(Callable<R> callable, BiConsumer<R, T> biConsumer) {
        return coalesce(callable, biConsumer, Flowable.bufferSize());
    }

    @SchedulerSupport("io.reactivex:computation")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> debounceFirst(long j, TimeUnit timeUnit) {
        return debounceFirst(j, timeUnit, Schedulers.computation());
    }

    public static <T, R> FlowableTransformer<T, R> errorJump(FlowableTransformer<T, R> flowableTransformer) {
        ObjectHelper.requireNonNull(flowableTransformer, "transformer");
        return new e(null, flowableTransformer);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    public static <T> FlowableTransformer<T, T> every(long j) {
        ObjectHelper.verifyPositive(j, "keep");
        return new f(null, j);
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

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> FlowableTransformer<T, Long> indexOf(Predicate<? super T> predicate) {
        return new l(null, predicate);
    }

    public static <T, R> FlowableTransformer<T, R> mapAsync(Function<? super T, ? extends Publisher<? extends R>> function) {
        return mapAsync(function, BiFunctionSecondIdentity.instance(), Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T, R> FlowableTransformer<T, R> mapFilter(BiConsumer<? super T, ? super BasicEmitter<R>> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "consumer is null");
        return new o(null, biConsumer);
    }

    @SchedulerSupport("io.reactivex:computation")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> FlowableTransformer<T, T> onBackpressureTimeout(long j, TimeUnit timeUnit) {
        return onBackpressureTimeout(j, timeUnit, Schedulers.computation());
    }

    public static <T, I, A, R> FlowableTransformer<T, R> partialCollect(Consumer<? super PartialCollectEmitter<T, I, A, R>> consumer, Consumer<? super T> consumer2, int i) {
        ObjectHelper.requireNonNull(consumer, "handler is null");
        ObjectHelper.requireNonNull(consumer2, "cleaner is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return new r(null, consumer, consumer2, i);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> FlowableTransformer<T, T> requestObserveOn(Scheduler scheduler) {
        return new u(null, (Scheduler) ObjectHelper.requireNonNull(scheduler, "scheduler == null"));
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    public static <T> FlowableTransformer<T, T> requestSample(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return requestSample(j, j, timeUnit, scheduler);
    }

    @SchedulerSupport("io.reactivex:computation")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> spanout(long j, TimeUnit timeUnit) {
        return spanout(0, j, timeUnit, Schedulers.computation(), false);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T, R> FlowableTransformer<T, R> switchFlatMap(Function<? super T, ? extends Publisher<? extends R>> function, int i) {
        return switchFlatMap(function, i, Flowable.bufferSize());
    }

    public static <T> FlowableTransformer<T, T> switchIfEmpty(Iterable<? extends Publisher<? extends T>> iterable) {
        return new z(null, iterable);
    }

    public static <T> FlowableTransformer<T, T> switchIfEmptyArray(Publisher<? extends T>... publisherArr) {
        return new a0(null, publisherArr);
    }

    @SchedulerSupport("io.reactivex:computation")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> FlowableTransformer<T, T> timeoutLast(long j, TimeUnit timeUnit) {
        return timeoutLast(j, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("io.reactivex:computation")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> FlowableTransformer<T, T> timeoutLastAbsolute(long j, TimeUnit timeUnit) {
        return timeoutLastAbsolute(j, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> valve(Publisher<Boolean> publisher) {
        return valve(publisher, true, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> FlowableTransformer<T, Flowable<T>> windowSplit(Predicate<? super T> predicate) {
        return windowSplit(predicate, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> FlowableTransformer<T, Flowable<T>> windowUntil(Predicate<? super T> predicate) {
        return windowUntil(predicate, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> FlowableTransformer<T, Flowable<T>> windowWhile(Predicate<? super T> predicate) {
        return windowWhile(predicate, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T, C extends Collection<? super T>> FlowableTransformer<T, C> bufferSplit(Predicate<? super T> predicate, Callable<C> callable) {
        return new a(null, predicate, a.b.SPLIT, callable);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T, C extends Collection<? super T>> FlowableTransformer<T, C> bufferUntil(Predicate<? super T> predicate, Callable<C> callable) {
        return new a(null, predicate, a.b.AFTER, callable);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T, C extends Collection<? super T>> FlowableTransformer<T, C> bufferWhile(Predicate<? super T> predicate, Callable<C> callable) {
        return new a(null, predicate, a.b.BEFORE, callable);
    }

    public static <T, R> FlowableTransformer<T, R> coalesce(Callable<R> callable, BiConsumer<R, T> biConsumer, int i) {
        ObjectHelper.requireNonNull(callable, "containerSupplier is null");
        ObjectHelper.requireNonNull(biConsumer, "coalescer is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new c(null, callable, biConsumer, i);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> debounceFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return new d(null, j, timeUnit, scheduler);
    }

    public static <T> FlowableTransformer<T, T> expand(Function<? super T, ? extends Publisher<? extends T>> function, ExpandStrategy expandStrategy) {
        return expand(function, expandStrategy, Flowable.bufferSize());
    }

    public static <T> FlowableTransformer<T, T> expandDelayError(Function<? super T, ? extends Publisher<? extends T>> function, ExpandStrategy expandStrategy) {
        return expandDelayError(function, expandStrategy, Flowable.bufferSize());
    }

    public static <T> FlowableTransformer<T, T> filterAsync(Function<? super T, ? extends Publisher<Boolean>> function, int i) {
        ObjectHelper.requireNonNull("combiner", "combiner is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new h(null, function, i);
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

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> FlowableTransformer<T, T> onBackpressureTimeout(long j, TimeUnit timeUnit, Scheduler scheduler, Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(consumer, "onEvict is null");
        return new p(null, Integer.MAX_VALUE, j, timeUnit, scheduler, consumer);
    }

    public static <T> FlowableTransformer<T, T> requestSample(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return new w(null, j, j2, timeUnit, scheduler);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> spanout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return spanout(0, j, timeUnit, scheduler, false);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T, R> FlowableTransformer<T, R> switchFlatMap(Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "maxActive");
        ObjectHelper.verifyPositive(i2, "bufferSize");
        return new y(null, function, i, i2);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> FlowableTransformer<T, T> timeoutLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return new c0(null, j, timeUnit, scheduler, false);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> FlowableTransformer<T, T> timeoutLastAbsolute(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return new c0(null, j, timeUnit, scheduler, true);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> valve(Publisher<Boolean> publisher, boolean z) {
        return valve(publisher, z, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> FlowableTransformer<T, Flowable<T>> windowSplit(Predicate<? super T> predicate, int i) {
        return new f0(null, predicate, f0.a.SPLIT, i);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> FlowableTransformer<T, Flowable<T>> windowUntil(Predicate<? super T> predicate, int i) {
        return new f0(null, predicate, f0.a.AFTER, i);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    public static <T> FlowableTransformer<T, Flowable<T>> windowWhile(Predicate<? super T> predicate, int i) {
        return new f0(null, predicate, f0.a.BEFORE, i);
    }

    public static <T> FlowableTransformer<T, T> expand(Function<? super T, ? extends Publisher<? extends T>> function, ExpandStrategy expandStrategy, int i) {
        ObjectHelper.requireNonNull(function, "expander is null");
        ObjectHelper.requireNonNull(expandStrategy, "strategy is null");
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new g(null, function, expandStrategy, i, false);
    }

    public static <T> FlowableTransformer<T, T> expandDelayError(Function<? super T, ? extends Publisher<? extends T>> function, ExpandStrategy expandStrategy, int i) {
        ObjectHelper.requireNonNull(function, "expander is null");
        ObjectHelper.requireNonNull(expandStrategy, "strategy is null");
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new g(null, function, expandStrategy, i, true);
    }

    public static <T, R> FlowableTransformer<T, R> flatMapAsync(Function<? super T, ? extends Publisher<? extends R>> function, Scheduler scheduler, int i, int i2, boolean z) {
        return new i(null, function, i, i2, z, scheduler);
    }

    public static <T, R> FlowableTransformer<T, R> flatMapSync(Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, boolean z) {
        return new j(null, function, i, i2, z);
    }

    public static <T, U, R> FlowableTransformer<T, R> mapAsync(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return mapAsync(function, biFunction, Flowable.bufferSize());
    }

    public static <T, U> FlowableTransformer<T, T> requestSample(Publisher<U> publisher) {
        return new v(null, publisher);
    }

    @SchedulerSupport("io.reactivex:computation")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> spanout(long j, long j2, TimeUnit timeUnit) {
        return spanout(j, j2, timeUnit, Schedulers.computation(), false);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> valve(Publisher<Boolean> publisher, boolean z, int i) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new e0(null, publisher, z, i);
    }

    public static <T, U, R> FlowableTransformer<T, R> mapAsync(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        ObjectHelper.requireNonNull("mapper", "mapper is null");
        ObjectHelper.requireNonNull("combiner", "combiner is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new n(null, function, biFunction, i);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> spanout(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return spanout(j, j2, timeUnit, scheduler, false);
    }

    @SchedulerSupport("io.reactivex:computation")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> spanout(long j, TimeUnit timeUnit, boolean z) {
        return spanout(0, j, timeUnit, Schedulers.computation(), z);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> FlowableTransformer<T, T> onBackpressureTimeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return onBackpressureTimeout(Integer.MAX_VALUE, j, timeUnit, scheduler, Functions.emptyConsumer());
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> spanout(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return spanout(0, j, timeUnit, scheduler, z);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> FlowableTransformer<T, T> onBackpressureTimeout(int i, long j, TimeUnit timeUnit, Scheduler scheduler, Consumer<? super T> consumer) {
        ObjectHelper.verifyPositive(i, SDKConstants.PARAM_CONTEXT_MAX_SIZE);
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(consumer, "onEvict is null");
        return new p(null, i, j, timeUnit, scheduler, consumer);
    }

    @SchedulerSupport("io.reactivex:computation")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> spanout(long j, long j2, TimeUnit timeUnit, boolean z) {
        return spanout(j, j2, timeUnit, Schedulers.computation(), z);
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public static <T> FlowableTransformer<T, T> spanout(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return new x(null, j, j2, timeUnit, scheduler, z, Flowable.bufferSize());
    }
}
