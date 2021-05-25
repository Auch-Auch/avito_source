package io.reactivex.rxjava3.kotlin;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0002H\b¢\u0006\u0004\b\u0005\u0010\u0004\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0006*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0006*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\nH\u0007¢\u0006\u0004\b\b\u0010\u000b\u001a/\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0006*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"", "R", "Lio/reactivex/rxjava3/core/Maybe;", "cast", "(Lio/reactivex/rxjava3/core/Maybe;)Lio/reactivex/rxjava3/core/Maybe;", "ofType", "T", "Lio/reactivex/rxjava3/core/Observable;", "mergeAllMaybes", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Flowable;", "(Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/rxjava3/core/Flowable;", "", "Lio/reactivex/rxjava3/core/MaybeSource;", "concatAll", "(Ljava/lang/Iterable;)Lio/reactivex/rxjava3/core/Flowable;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class MaybeKt {

    public static final class a<T, R> implements Function<T, MaybeSource<? extends R>> {
        public static final a a = new a();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Maybe) obj;
        }
    }

    public static final class b<T, R> implements Function<T, MaybeSource<? extends R>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Maybe) obj;
        }
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Maybe<U>, java.lang.Object, io.reactivex.rxjava3.core.Maybe<R> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Maybe<R> cast(@NotNull Maybe<?> maybe) {
        Intrinsics.checkParameterIsNotNull(maybe, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Maybe maybe2 = (Maybe<U>) maybe.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(maybe2, "cast(R::class.java)");
        return maybe2;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> concatAll(@NotNull Iterable<? extends MaybeSource<T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$concatAll");
        Flowable<T> concat = Maybe.concat(iterable);
        Intrinsics.checkExpressionValueIsNotNull(concat, "Maybe.concat(this)");
        return concat;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<R>, java.lang.Object, io.reactivex.rxjava3.core.Observable<T> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> mergeAllMaybes(@NotNull Observable<Maybe<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$mergeAllMaybes");
        Observable observable2 = (Observable<R>) observable.flatMapMaybe(a.a);
        Intrinsics.checkExpressionValueIsNotNull(observable2, "flatMapMaybe { it }");
        return observable2;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Maybe<U>, java.lang.Object, io.reactivex.rxjava3.core.Maybe<R> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Maybe<R> ofType(@NotNull Maybe<?> maybe) {
        Intrinsics.checkParameterIsNotNull(maybe, "$this$ofType");
        Intrinsics.reifiedOperationMarker(4, "R");
        Maybe maybe2 = (Maybe<U>) maybe.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(maybe2, "ofType(R::class.java)");
        return maybe2;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Flowable<R>, java.lang.Object, io.reactivex.rxjava3.core.Flowable<T> */
    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> mergeAllMaybes(@NotNull Flowable<Maybe<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$mergeAllMaybes");
        Flowable flowable2 = (Flowable<R>) flowable.flatMapMaybe(b.a);
        Intrinsics.checkExpressionValueIsNotNull(flowable2, "flatMapMaybe { it }");
        return flowable2;
    }
}
