package io.reactivex.rxjava3.kotlin;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function3;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ah\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u001a\b\u0004\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007H\b¢\u0006\u0004\b\t\u0010\n\u001aM\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b0\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b\t\u0010\f\u001a\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\r*\u00020\u0000\"\b\b\u0002\u0010\u000e*\u00020\u0000\"\b\b\u0003\u0010\u0003*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052 \b\u0004\u0010\b\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0011H\b¢\u0006\u0004\b\t\u0010\u0012\u001ak\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00130\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\r*\u00020\u0000\"\b\b\u0002\u0010\u000e*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\u0014\u001a¤\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00040\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\r*\u00020\u0000\"\b\b\u0002\u0010\u000e*\u00020\u0000\"\b\b\u0003\u0010\u0015*\u00020\u0000\"\b\b\u0004\u0010\u0003*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052&\b\u0004\u0010\b\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0017H\b¢\u0006\u0004\b\t\u0010\u0018\u001aÂ\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00050\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\r*\u00020\u0000\"\b\b\u0002\u0010\u000e*\u00020\u0000\"\b\b\u0003\u0010\u0015*\u00020\u0000\"\b\b\u0004\u0010\u0019*\u00020\u0000\"\b\b\u0005\u0010\u0003*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052,\b\u0004\u0010\b\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001bH\b¢\u0006\u0004\b\t\u0010\u001c\u001ah\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u001a\b\u0004\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007H\b¢\u0006\u0004\b\u001e\u0010\n\u001aM\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b0\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b\u001e\u0010\f¨\u0006\u001f"}, d2 = {"", "T", "U", "R", "Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/ObservableSource;", "other", "Lkotlin/Function2;", "combiner", "withLatestFrom", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/ObservableSource;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Pair;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/ObservableSource;)Lio/reactivex/rxjava3/core/Observable;", "T1", "T2", "o1", "o2", "Lkotlin/Function3;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/ObservableSource;Lio/reactivex/rxjava3/core/ObservableSource;Lkotlin/jvm/functions/Function3;)Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Triple;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/ObservableSource;Lio/reactivex/rxjava3/core/ObservableSource;)Lio/reactivex/rxjava3/core/Observable;", "T3", "o3", "Lkotlin/Function4;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/ObservableSource;Lio/reactivex/rxjava3/core/ObservableSource;Lio/reactivex/rxjava3/core/ObservableSource;Lkotlin/jvm/functions/Function4;)Lio/reactivex/rxjava3/core/Observable;", "T4", "o4", "Lkotlin/Function5;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/ObservableSource;Lio/reactivex/rxjava3/core/ObservableSource;Lio/reactivex/rxjava3/core/ObservableSource;Lio/reactivex/rxjava3/core/ObservableSource;Lkotlin/jvm/functions/Function5;)Lio/reactivex/rxjava3/core/Observable;", "zipper", "zipWith", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class ObservablesKt {

    public static final class a<T1, T2, R> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
        public static final a a = new a();

        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return new Pair(obj, obj2);
        }
    }

    public static final class b<T1, T2, T3, R> implements Function3<T, T1, T2, Triple<? extends T, ? extends T1, ? extends T2>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return new Triple(obj, obj2, obj3);
        }
    }

    public static final class c<T1, T2, R> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
        public static final c a = new c();

        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return new Pair(obj, obj2);
        }
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<U> observableSource, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(observableSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "combiner");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, new BiFunction<T, U, R>(function2) { // from class: io.reactivex.rxjava3.kotlin.ObservablesKt$withLatestFrom$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.BiFunction
            @NotNull
            public final R apply(T t, U u) {
                Function2 function22 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t, "t");
                Intrinsics.checkExpressionValueIsNotNull(u, "u");
                return (R) function22.invoke(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        return withLatestFrom;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U, R> Observable<R> zipWith(@NotNull Observable<T> observable, @NotNull ObservableSource<U> observableSource, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(observableSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Observable<R> zipWith = observable.zipWith(observableSource, new BiFunction<T, U, R>(function2) { // from class: io.reactivex.rxjava3.kotlin.ObservablesKt$zipWith$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.BiFunction
            @NotNull
            public final R apply(T t, U u) {
                Function2 function22 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t, "t");
                Intrinsics.checkExpressionValueIsNotNull(u, "u");
                return (R) function22.invoke(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return zipWith;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U> Observable<Pair<T, U>> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<U> observableSource) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(observableSource, "other");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, a.a);
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi…n { t, u -> Pair(t, u) })");
        return withLatestFrom;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U> Observable<Pair<T, U>> zipWith(@NotNull Observable<T> observable, @NotNull ObservableSource<U> observableSource) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(observableSource, "other");
        Observable<R> zipWith = observable.zipWith(observableSource, c.a);
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunction { t, u -> Pair(t, u) })");
        return zipWith;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, T1, T2, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2, @NotNull kotlin.jvm.functions.Function3<? super T, ? super T1, ? super T2, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Intrinsics.checkParameterIsNotNull(function3, "combiner");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, observableSource2, new Function3<T, T1, T2, R>(function3) { // from class: io.reactivex.rxjava3.kotlin.ObservablesKt$withLatestFrom$3
            public final /* synthetic */ kotlin.jvm.functions.Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function3
            @NotNull
            public final R apply(T t, T1 t1, T2 t2) {
                kotlin.jvm.functions.Function3 function32 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t, "t");
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                return (R) function32.invoke(t, t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, F…iner.invoke(t, t1, t2) })");
        return withLatestFrom;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, T1, T2> Observable<Triple<T, T1, T2>> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, observableSource2, b.a);
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, F…2 -> Triple(t, t1, t2) })");
        return withLatestFrom;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, T1, T2, T3, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2, @NotNull ObservableSource<T3> observableSource3, @NotNull Function4<? super T, ? super T1, ? super T2, ? super T3, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Intrinsics.checkParameterIsNotNull(observableSource3, "o3");
        Intrinsics.checkParameterIsNotNull(function4, "combiner");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, observableSource2, observableSource3, new io.reactivex.rxjava3.functions.Function4<T, T1, T2, T3, R>(function4) { // from class: io.reactivex.rxjava3.kotlin.ObservablesKt$withLatestFrom$5
            public final /* synthetic */ Function4 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function4
            @NotNull
            public final R apply(T t, T1 t1, T2 t2, T3 t3) {
                Function4 function42 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t, "t");
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                Intrinsics.checkExpressionValueIsNotNull(t3, "t3");
                return (R) function42.invoke(t, t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, o….invoke(t, t1, t2, t3) })");
        return withLatestFrom;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, T1, T2, T3, T4, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2, @NotNull ObservableSource<T3> observableSource3, @NotNull ObservableSource<T4> observableSource4, @NotNull Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Intrinsics.checkParameterIsNotNull(observableSource3, "o3");
        Intrinsics.checkParameterIsNotNull(observableSource4, "o4");
        Intrinsics.checkParameterIsNotNull(function5, "combiner");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, observableSource2, observableSource3, observableSource4, new io.reactivex.rxjava3.functions.Function5<T, T1, T2, T3, T4, R>(function5) { // from class: io.reactivex.rxjava3.kotlin.ObservablesKt$withLatestFrom$6
            public final /* synthetic */ Function5 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function5
            @NotNull
            public final R apply(T t, T1 t1, T2 t2, T3 t3, T4 t4) {
                Function5 function52 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t, "t");
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                Intrinsics.checkExpressionValueIsNotNull(t3, "t3");
                Intrinsics.checkExpressionValueIsNotNull(t4, "t4");
                return (R) function52.invoke(t, t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, o…oke(t, t1, t2, t3, t4) })");
        return withLatestFrom;
    }
}
