package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aM\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00070\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\b\u001aM\u0010\u000b\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00070\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "T", "Lio/reactivex/Observable;", "Lio/reactivex/Single;", "kotlin.jvm.PlatformType", "mergeAllSingles", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lio/reactivex/Flowable;", "(Lio/reactivex/Flowable;)Lio/reactivex/Flowable;", "", "Lio/reactivex/SingleSource;", "concatAll", "(Ljava/lang/Iterable;)Lio/reactivex/Flowable;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class SingleKt {

    public static final class a<T, R> implements Function<T, SingleSource<? extends R>> {
        public static final a a = new a();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Single single = (Single) obj;
            Intrinsics.checkParameterIsNotNull(single, "it");
            return single;
        }
    }

    public static final class b<T, R> implements Function<T, SingleSource<? extends R>> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Single single = (Single) obj;
            Intrinsics.checkParameterIsNotNull(single, "it");
            return single;
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> concatAll(@NotNull Iterable<? extends SingleSource<T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        return Single.concat(iterable);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Observable<R>, io.reactivex.Observable<T> */
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> mergeAllSingles(@NotNull Observable<Single<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        return (Observable<R>) observable.flatMapSingle(a.a);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Flowable<R>, io.reactivex.Flowable<T> */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final <T> Flowable<T> mergeAllSingles(@NotNull Flowable<Single<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return (Flowable<R>) flowable.flatMapSingle(b.a);
    }
}
