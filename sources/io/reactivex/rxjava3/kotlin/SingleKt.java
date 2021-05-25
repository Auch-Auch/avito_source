package io.reactivex.rxjava3.kotlin;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a/\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\b\b\u0000\u0010\u0005*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\tH\u0007¢\u0006\u0004\b\u0007\u0010\n\u001a/\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\b\b\u0000\u0010\u0005*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "R", "Lio/reactivex/rxjava3/core/Single;", "cast", "(Lio/reactivex/rxjava3/core/Single;)Lio/reactivex/rxjava3/core/Single;", "T", "Lio/reactivex/rxjava3/core/Observable;", "mergeAllSingles", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Flowable;", "(Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/rxjava3/core/Flowable;", "", "Lio/reactivex/rxjava3/core/SingleSource;", "concatAll", "(Ljava/lang/Iterable;)Lio/reactivex/rxjava3/core/Flowable;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class SingleKt {

    public static final class a<T, R> implements Function<T, SingleSource<? extends R>> {
        public static final a a = new a();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Single) obj;
        }
    }

    public static final class b<T, R> implements Function<T, SingleSource<? extends R>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Single) obj;
        }
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Single<U>, java.lang.Object, io.reactivex.rxjava3.core.Single<R> */
    @NotNull
    public static final /* synthetic */ <R> Single<R> cast(@NotNull Single<?> single) {
        Intrinsics.checkParameterIsNotNull(single, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Single single2 = (Single<U>) single.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(single2, "cast(R::class.java)");
        return single2;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> concatAll(@NotNull Iterable<? extends SingleSource<T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$concatAll");
        Flowable<T> concat = Single.concat(iterable);
        Intrinsics.checkExpressionValueIsNotNull(concat, "Single.concat(this)");
        return concat;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<R>, java.lang.Object, io.reactivex.rxjava3.core.Observable<T> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> mergeAllSingles(@NotNull Observable<Single<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$mergeAllSingles");
        Observable observable2 = (Observable<R>) observable.flatMapSingle(a.a);
        Intrinsics.checkExpressionValueIsNotNull(observable2, "flatMapSingle { it }");
        return observable2;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Flowable<R>, java.lang.Object, io.reactivex.rxjava3.core.Flowable<T> */
    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> mergeAllSingles(@NotNull Flowable<Single<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$mergeAllSingles");
        Flowable flowable2 = (Flowable<R>) flowable.flatMapSingle(b.a);
        Intrinsics.checkExpressionValueIsNotNull(flowable2, "flatMapSingle { it }");
        return flowable2;
    }
}
