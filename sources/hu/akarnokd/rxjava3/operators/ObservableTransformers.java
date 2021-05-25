package hu.akarnokd.rxjava3.operators;

import hu.akarnokd.rxjava3.util.BiFunctionSecondIdentity;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import java.util.Objects;
import r6.a.b.i.a1;
import r6.a.b.i.s0;
import r6.a.b.i.t0;
import r6.a.b.i.u0;
import r6.a.b.i.v0;
import r6.a.b.i.w0;
import r6.a.b.i.x0;
import r6.a.b.i.y0;
import r6.a.b.i.z0;
public final class ObservableTransformers {
    public ObservableTransformers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> ObservableTransformer<T, R> errorJump(ObservableTransformer<T, R> observableTransformer) {
        Objects.requireNonNull(observableTransformer, "transformer");
        return new s0(null, observableTransformer);
    }

    public static <T> ObservableTransformer<T, T> filterAsync(Function<? super T, ? extends ObservableSource<Boolean>> function) {
        return filterAsync(function, Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> ObservableTransformer<T, R> flatMapDrop(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return new u0(null, function);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> ObservableTransformer<T, R> flatMapLatest(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return new v0(null, function);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> ObservableTransformer<T, Long> indexOf(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return new w0(null, predicate);
    }

    public static <T, R> ObservableTransformer<T, R> mapAsync(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return mapAsync(function, BiFunctionSecondIdentity.instance(), Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("custom")
    public static <T> ObservableTransformer<T, T> observeOnDrop(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new y0(null, scheduler);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("custom")
    public static <T> ObservableTransformer<T, T> observeOnLatest(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new z0(null, scheduler);
    }

    @SchedulerSupport("none")
    public static <T> ObservableTransformer<T, T> valve(ObservableSource<Boolean> observableSource) {
        return valve(observableSource, true, Flowable.bufferSize());
    }

    public static <T> ObservableTransformer<T, T> filterAsync(Function<? super T, ? extends ObservableSource<Boolean>> function, int i) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new t0(null, function, i);
    }

    public static <T, R> ObservableTransformer<T, R> mapAsync(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        return mapAsync(function, BiFunctionSecondIdentity.instance(), i);
    }

    @SchedulerSupport("none")
    public static <T> ObservableTransformer<T, T> valve(ObservableSource<Boolean> observableSource, boolean z) {
        return valve(observableSource, z, Flowable.bufferSize());
    }

    public static <T, U, R> ObservableTransformer<T, R> mapAsync(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return mapAsync(function, biFunction, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    public static <T> ObservableTransformer<T, T> valve(ObservableSource<Boolean> observableSource, boolean z, int i) {
        Objects.requireNonNull(observableSource, "other is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new a1(null, observableSource, z, i);
    }

    public static <T, U, R> ObservableTransformer<T, R> mapAsync(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new x0(null, function, biFunction, i);
    }
}
