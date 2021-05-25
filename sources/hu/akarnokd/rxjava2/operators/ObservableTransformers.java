package hu.akarnokd.rxjava2.operators;

import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;
import r6.a.a.h.h0;
import r6.a.a.h.i0;
import r6.a.a.h.j0;
import r6.a.a.h.k0;
import r6.a.a.h.l0;
import r6.a.a.h.m0;
public final class ObservableTransformers {
    public ObservableTransformers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> ObservableTransformer<T, R> errorJump(ObservableTransformer<T, R> observableTransformer) {
        ObjectHelper.requireNonNull(observableTransformer, "transformer");
        return new h0(null, observableTransformer);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @NonNull
    public static <T, R> ObservableTransformer<T, R> flatMapDrop(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return new i0(null, function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @NonNull
    public static <T, R> ObservableTransformer<T, R> flatMapLatest(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return new j0(null, function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @NonNull
    public static <T> ObservableTransformer<T, Long> indexOf(@NonNull Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return new k0(null, predicate);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    @NonNull
    public static <T> ObservableTransformer<T, T> observeOnDrop(@NonNull Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return new l0(null, scheduler);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    @NonNull
    public static <T> ObservableTransformer<T, T> observeOnLatest(@NonNull Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return new m0(null, scheduler);
    }
}
