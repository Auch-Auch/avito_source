package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function3;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\\\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u001a\b\u0004\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006H\b¢\u0006\u0004\b\b\u0010\t\u001aE\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\u000b\u001av\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042 \b\u0004\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0010H\b¢\u0006\u0004\b\b\u0010\u0011\u001a_\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00120\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0013\u001a\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0014\"\u0004\b\u0004\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00042&\b\u0004\u0010\u0007\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0016H\b¢\u0006\u0004\b\b\u0010\u0017\u001aª\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0014\"\u0004\b\u0004\u0010\u0018\"\u0004\b\u0005\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00042,\b\u0004\u0010\u0007\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001aH\b¢\u0006\u0004\b\b\u0010\u001b\u001a\\\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u001a\b\u0004\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006H\b¢\u0006\u0004\b\u001d\u0010\t\u001aE\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0007¢\u0006\u0004\b\u001d\u0010\u000b¨\u0006\u001e"}, d2 = {"T", "U", "R", "Lio/reactivex/Observable;", "Lio/reactivex/ObservableSource;", "other", "Lkotlin/Function2;", "combiner", "withLatestFrom", "(Lio/reactivex/Observable;Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Observable;", "Lkotlin/Pair;", "(Lio/reactivex/Observable;Lio/reactivex/ObservableSource;)Lio/reactivex/Observable;", "T1", "T2", "o1", "o2", "Lkotlin/Function3;", "(Lio/reactivex/Observable;Lio/reactivex/ObservableSource;Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function3;)Lio/reactivex/Observable;", "Lkotlin/Triple;", "(Lio/reactivex/Observable;Lio/reactivex/ObservableSource;Lio/reactivex/ObservableSource;)Lio/reactivex/Observable;", "T3", "o3", "Lkotlin/Function4;", "(Lio/reactivex/Observable;Lio/reactivex/ObservableSource;Lio/reactivex/ObservableSource;Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function4;)Lio/reactivex/Observable;", "T4", "o4", "Lkotlin/Function5;", "(Lio/reactivex/Observable;Lio/reactivex/ObservableSource;Lio/reactivex/ObservableSource;Lio/reactivex/ObservableSource;Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function5;)Lio/reactivex/Observable;", "zipper", "zipWith", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class ObservablesKt {

    public static final class a<T1, T2, R> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
        public static final a a = new a();

        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return new Pair(obj, obj2);
        }
    }

    public static final class b<T1, T2, T3, R> implements Function3<T, T1, T2, Triple<? extends T, ? extends T1, ? extends T2>> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return new Triple(obj, obj2, obj3);
        }
    }

    public static final class c<T1, T2, R> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
        public static final c a = new c();

        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return new Pair(obj, obj2);
        }
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<U> observableSource, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "combiner");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, new BiFunction<T, U, R>(function2) { // from class: io.reactivex.rxkotlin.ObservablesKt$withLatestFrom$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(T t, U u) {
                return (R) this.a.invoke(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        return withLatestFrom;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U, R> Observable<R> zipWith(@NotNull Observable<T> observable, @NotNull ObservableSource<U> observableSource, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Observable<R> zipWith = observable.zipWith(observableSource, new BiFunction<T, U, R>(function2) { // from class: io.reactivex.rxkotlin.ObservablesKt$zipWith$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(T t, U u) {
                return (R) this.a.invoke(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return zipWith;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U> Observable<Pair<T, U>> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<U> observableSource) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "other");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, a.a);
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi…ion{ t, u -> Pair(t,u) })");
        return withLatestFrom;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U> Observable<Pair<T, U>> zipWith(@NotNull Observable<T> observable, @NotNull ObservableSource<U> observableSource) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "other");
        Observable<R> zipWith = observable.zipWith(observableSource, c.a);
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunction { t, u -> Pair(t,u) })");
        return zipWith;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, T1, T2, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2, @NotNull kotlin.jvm.functions.Function3<? super T, ? super T1, ? super T2, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Intrinsics.checkParameterIsNotNull(function3, "combiner");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, observableSource2, new Function3<T, T1, T2, R>(function3) { // from class: io.reactivex.rxkotlin.ObservablesKt$withLatestFrom$3
            public final /* synthetic */ kotlin.jvm.functions.Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function3
            public final R apply(T t, T1 t1, T2 t2) {
                return (R) this.a.invoke(t, t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, F…iner.invoke(t, t1, t2) })");
        return withLatestFrom;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, T1, T2> Observable<Triple<T, T1, T2>> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, observableSource2, b.a);
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, F…2 -> Triple(t, t1, t2) })");
        return withLatestFrom;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, T1, T2, T3, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2, @NotNull ObservableSource<T3> observableSource3, @NotNull Function4<? super T, ? super T1, ? super T2, ? super T3, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Intrinsics.checkParameterIsNotNull(observableSource3, "o3");
        Intrinsics.checkParameterIsNotNull(function4, "combiner");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, observableSource2, observableSource3, new io.reactivex.functions.Function4<T, T1, T2, T3, R>(function4) { // from class: io.reactivex.rxkotlin.ObservablesKt$withLatestFrom$5
            public final /* synthetic */ Function4 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function4
            public final R apply(T t, T1 t1, T2 t2, T3 t3) {
                return (R) this.a.invoke(t, t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, o….invoke(t, t1, t2, t3) })");
        return withLatestFrom;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, T1, T2, T3, T4, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2, @NotNull ObservableSource<T3> observableSource3, @NotNull ObservableSource<T4> observableSource4, @NotNull Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Intrinsics.checkParameterIsNotNull(observableSource3, "o3");
        Intrinsics.checkParameterIsNotNull(observableSource4, "o4");
        Intrinsics.checkParameterIsNotNull(function5, "combiner");
        Observable<R> withLatestFrom = observable.withLatestFrom(observableSource, observableSource2, observableSource3, observableSource4, new io.reactivex.functions.Function5<T, T1, T2, T3, T4, R>(function5) { // from class: io.reactivex.rxkotlin.ObservablesKt$withLatestFrom$6
            public final /* synthetic */ Function5 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function5
            public final R apply(T t, T1 t1, T2 t2, T3 t3, T4 t4) {
                return (R) this.a.invoke(t, t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, o…oke(t, t1, t2, t3, t4) })");
        return withLatestFrom;
    }
}
