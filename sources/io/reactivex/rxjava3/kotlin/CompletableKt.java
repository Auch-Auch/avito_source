package io.reactivex.rxjava3.kotlin;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0019\u0010\u0002\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007¢\u0006\u0004\b\u0002\u0010\b\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u0002\u0010\n\u001a\u0019\u0010\f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0004\b\f\u0010\u000f\u001a\u0019\u0010\u0012\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/reactivex/rxjava3/functions/Action;", "Lio/reactivex/rxjava3/core/Completable;", "toCompletable", "(Lio/reactivex/rxjava3/functions/Action;)Lio/reactivex/rxjava3/core/Completable;", "Ljava/util/concurrent/Callable;", "", "(Ljava/util/concurrent/Callable;)Lio/reactivex/rxjava3/core/Completable;", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)Lio/reactivex/rxjava3/core/Completable;", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Observable;", "mergeAllCompletables", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Flowable;", "(Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/rxjava3/core/Completable;", "", "Lio/reactivex/rxjava3/core/CompletableSource;", "concatAll", "(Ljava/lang/Iterable;)Lio/reactivex/rxjava3/core/Completable;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class CompletableKt {

    public static final class a<T, R> implements Function<Completable, CompletableSource> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Completable completable) {
            return completable;
        }
    }

    public static final class b<T, R> implements Function<Completable, CompletableSource> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Completable completable) {
            return completable;
        }
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Completable concatAll(@NotNull Iterable<? extends CompletableSource> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$concatAll");
        Completable concat = Completable.concat(iterable);
        Intrinsics.checkExpressionValueIsNotNull(concat, "Completable.concat(this)");
        return concat;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Completable mergeAllCompletables(@NotNull Observable<Completable> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$mergeAllCompletables");
        Completable flatMapCompletable = observable.flatMapCompletable(a.a);
        Intrinsics.checkExpressionValueIsNotNull(flatMapCompletable, "flatMapCompletable { it }");
        return flatMapCompletable;
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Action action) {
        Intrinsics.checkParameterIsNotNull(action, "$this$toCompletable");
        Completable fromAction = Completable.fromAction(action);
        Intrinsics.checkExpressionValueIsNotNull(fromAction, "Completable.fromAction(this)");
        return fromAction;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static final Completable mergeAllCompletables(@NotNull Flowable<Completable> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$mergeAllCompletables");
        Completable flatMapCompletable = flowable.flatMapCompletable(b.a);
        Intrinsics.checkExpressionValueIsNotNull(flatMapCompletable, "flatMapCompletable { it }");
        return flatMapCompletable;
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Callable<? extends Object> callable) {
        Intrinsics.checkParameterIsNotNull(callable, "$this$toCompletable");
        Completable fromCallable = Completable.fromCallable(callable);
        Intrinsics.checkExpressionValueIsNotNull(fromCallable, "Completable.fromCallable(this)");
        return fromCallable;
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Future<? extends Object> future) {
        Intrinsics.checkParameterIsNotNull(future, "$this$toCompletable");
        Completable fromFuture = Completable.fromFuture(future);
        Intrinsics.checkExpressionValueIsNotNull(fromFuture, "Completable.fromFuture(this)");
        return fromFuture;
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "$this$toCompletable");
        Completable fromCallable = Completable.fromCallable(new s6.a.e.e.a(function0));
        Intrinsics.checkExpressionValueIsNotNull(fromCallable, "Completable.fromCallable(this)");
        return fromCallable;
    }
}
