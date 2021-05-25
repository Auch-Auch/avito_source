package io.reactivex.rxkotlin;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0019\u0010\u0002\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007¢\u0006\u0004\b\u0002\u0010\b\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u0002\u0010\n\u001a!\u0010\r\u001a\n \f*\u0004\u0018\u00010\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\r\u001a\n \f*\u0004\u0018\u00010\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0004\b\r\u0010\u0010\u001a!\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/reactivex/functions/Action;", "Lio/reactivex/Completable;", "toCompletable", "(Lio/reactivex/functions/Action;)Lio/reactivex/Completable;", "Ljava/util/concurrent/Callable;", "", "(Ljava/util/concurrent/Callable;)Lio/reactivex/Completable;", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)Lio/reactivex/Completable;", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/Completable;", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "mergeAllCompletables", "(Lio/reactivex/Observable;)Lio/reactivex/Completable;", "Lio/reactivex/Flowable;", "(Lio/reactivex/Flowable;)Lio/reactivex/Completable;", "", "Lio/reactivex/CompletableSource;", "concatAll", "(Ljava/lang/Iterable;)Lio/reactivex/Completable;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class CompletableKt {

    public static final class a<T, R> implements Function<Completable, CompletableSource> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(Completable completable) {
            Completable completable2 = completable;
            Intrinsics.checkParameterIsNotNull(completable2, "it");
            return completable2;
        }
    }

    public static final class b<T, R> implements Function<Completable, CompletableSource> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(Completable completable) {
            Completable completable2 = completable;
            Intrinsics.checkParameterIsNotNull(completable2, "it");
            return completable2;
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Completable concatAll(@NotNull Iterable<? extends CompletableSource> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        return Completable.concat(iterable);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Completable mergeAllCompletables(@NotNull Observable<Completable> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        return observable.flatMapCompletable(a.a);
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Action action) {
        Intrinsics.checkParameterIsNotNull(action, "$receiver");
        Completable fromAction = Completable.fromAction(action);
        Intrinsics.checkExpressionValueIsNotNull(fromAction, "Completable.fromAction(this)");
        return fromAction;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final Completable mergeAllCompletables(@NotNull Flowable<Completable> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return flowable.flatMapCompletable(b.a);
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Callable<? extends Object> callable) {
        Intrinsics.checkParameterIsNotNull(callable, "$receiver");
        Completable fromCallable = Completable.fromCallable(callable);
        Intrinsics.checkExpressionValueIsNotNull(fromCallable, "Completable.fromCallable(this)");
        return fromCallable;
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Future<? extends Object> future) {
        Intrinsics.checkParameterIsNotNull(future, "$receiver");
        Completable fromFuture = Completable.fromFuture(future);
        Intrinsics.checkExpressionValueIsNotNull(fromFuture, "Completable.fromFuture(this)");
        return fromFuture;
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "$receiver");
        Completable fromCallable = Completable.fromCallable(new s6.a.f.a(function0));
        Intrinsics.checkExpressionValueIsNotNull(fromCallable, "Completable.fromCallable(this)");
        return fromCallable;
    }
}
