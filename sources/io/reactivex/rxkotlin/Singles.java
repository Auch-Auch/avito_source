package io.reactivex.rxkotlin;

import io.reactivex.Single;
import io.reactivex.SingleSource;
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
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b/\u00100J`\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bH\b¢\u0006\u0004\b\u000b\u0010\fJI\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\u000eJz\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00030\n\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u0011\"\u0004\b\u0003\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052 \b\u0004\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0013H\b¢\u0006\u0004\b\u000b\u0010\u0014Jc\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00150\n\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\u0016J\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00040\n\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u0011\"\u0004\b\u0003\u0010\u0017\"\u0004\b\u0004\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052&\b\u0004\u0010\t\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0019H\b¢\u0006\u0004\b\u000b\u0010\u001aJ®\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00050\n\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u0011\"\u0004\b\u0003\u0010\u0017\"\u0004\b\u0004\u0010\u001b\"\u0004\b\u0005\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052,\b\u0004\u0010\t\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001dH\b¢\u0006\u0004\b\u000b\u0010\u001eJÈ\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00060\n\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u0011\"\u0004\b\u0003\u0010\u0017\"\u0004\b\u0004\u0010\u001b\"\u0004\b\u0005\u0010\u001f\"\u0004\b\u0006\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00050\u000522\b\u0004\u0010\t\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060!H\b¢\u0006\u0004\b\u000b\u0010\"Jâ\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00070\n\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u0011\"\u0004\b\u0003\u0010\u0017\"\u0004\b\u0004\u0010\u001b\"\u0004\b\u0005\u0010\u001f\"\u0004\b\u0006\u0010#\"\u0004\b\u0007\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00060\u000528\b\u0004\u0010\t\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070%H\b¢\u0006\u0004\b\u000b\u0010&Jü\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\b0\n\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u0011\"\u0004\b\u0003\u0010\u0017\"\u0004\b\u0004\u0010\u001b\"\u0004\b\u0005\u0010\u001f\"\u0004\b\u0006\u0010#\"\u0004\b\u0007\u0010'\"\u0004\b\b\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052>\b\u0004\u0010\t\u001a8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0)H\b¢\u0006\u0004\b\u000b\u0010*J\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\t0\n\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u0011\"\u0004\b\u0003\u0010\u0017\"\u0004\b\u0004\u0010\u001b\"\u0004\b\u0005\u0010\u001f\"\u0004\b\u0006\u0010#\"\u0004\b\u0007\u0010'\"\u0004\b\b\u0010+\"\u0004\b\t\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\b0\u00052D\b\u0004\u0010\t\u001a>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t0-H\b¢\u0006\u0004\b\u000b\u0010.¨\u00061"}, d2 = {"Lio/reactivex/rxkotlin/Singles;", "", "T", "U", "R", "Lio/reactivex/SingleSource;", "s1", "s2", "Lkotlin/Function2;", "zipper", "Lio/reactivex/Single;", "zip", "(Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Single;", "Lkotlin/Pair;", "(Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;)Lio/reactivex/Single;", "T1", "T2", "T3", "s3", "Lkotlin/Function3;", "(Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lkotlin/jvm/functions/Function3;)Lio/reactivex/Single;", "Lkotlin/Triple;", "(Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;)Lio/reactivex/Single;", "T4", "s4", "Lkotlin/Function4;", "(Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lkotlin/jvm/functions/Function4;)Lio/reactivex/Single;", "T5", "s5", "Lkotlin/Function5;", "(Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lkotlin/jvm/functions/Function5;)Lio/reactivex/Single;", "T6", "s6", "Lkotlin/Function6;", "(Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lkotlin/jvm/functions/Function6;)Lio/reactivex/Single;", "T7", "s7", "Lkotlin/Function7;", "(Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lkotlin/jvm/functions/Function7;)Lio/reactivex/Single;", "T8", "s8", "Lkotlin/Function8;", "(Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lkotlin/jvm/functions/Function8;)Lio/reactivex/Single;", "T9", "s9", "Lkotlin/Function9;", "(Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lio/reactivex/SingleSource;Lkotlin/jvm/functions/Function9;)Lio/reactivex/Single;", "<init>", "()V", "rxkotlin"}, k = 1, mv = {1, 4, 0})
public final class Singles {
    public static final Singles INSTANCE = new Singles();

    public static final class a<T1, T2, R> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
        public static final a a = new a();

        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return new Pair(obj, obj2);
        }
    }

    public static final class b<T1, T2, T3, R> implements Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return new Triple(obj, obj2, obj3);
        }
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T, U, R> Single<R> zip(@NotNull SingleSource<T> singleSource, @NotNull SingleSource<U> singleSource2, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, new BiFunction<T, U, R>(function2) { // from class: io.reactivex.rxkotlin.Singles$zip$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(T t, U u) {
                return (R) this.a.invoke(t, u);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, BiFun…-> zipper.invoke(t, u) })");
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T, U> Single<Pair<T, U>> zip(@NotNull SingleSource<T> singleSource, @NotNull SingleSource<U> singleSource2) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Single<Pair<T, U>> zip = Single.zip(singleSource, singleSource2, a.a);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, BiFun…on { t, u -> Pair(t,u) })");
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(function3, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, new Function3<T1, T2, T3, R>(function3) { // from class: io.reactivex.rxkotlin.Singles$zip$3
            public final /* synthetic */ kotlin.jvm.functions.Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function3
            public final R apply(T1 t1, T2 t2, T3 t3) {
                return (R) this.a.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, F…per.invoke(t1, t2, t3) })");
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3> Single<Triple<T1, T2, T3>> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Single<Triple<T1, T2, T3>> zip = Single.zip(singleSource, singleSource2, singleSource3, b.a);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, F…t3 -> Triple(t1,t2,t3) })");
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        Intrinsics.checkParameterIsNotNull(function4, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, singleSource4, new io.reactivex.functions.Function4<T1, T2, T3, T4, R>(function4) { // from class: io.reactivex.rxkotlin.Singles$zip$5
            public final /* synthetic */ Function4 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function4
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
                return (R) this.a.invoke(t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…invoke(t1, t2, t3, t4) })");
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull SingleSource<T5> singleSource5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        Intrinsics.checkParameterIsNotNull(singleSource5, "s5");
        Intrinsics.checkParameterIsNotNull(function5, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, singleSource4, singleSource5, new io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R>(function5) { // from class: io.reactivex.rxkotlin.Singles$zip$6
            public final /* synthetic */ Function5 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function5
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…ke(t1, t2, t3, t4, t5) })");
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull SingleSource<T5> singleSource5, @NotNull SingleSource<T6> singleSource6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        Intrinsics.checkParameterIsNotNull(singleSource5, "s5");
        Intrinsics.checkParameterIsNotNull(singleSource6, "s6");
        Intrinsics.checkParameterIsNotNull(function6, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, new io.reactivex.functions.Function6<T1, T2, T3, T4, T5, T6, R>(function6) { // from class: io.reactivex.rxkotlin.Singles$zip$7
            public final /* synthetic */ Function6 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function6
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…1, t2, t3, t4, t5, t6) })");
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull SingleSource<T5> singleSource5, @NotNull SingleSource<T6> singleSource6, @NotNull SingleSource<T7> singleSource7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        Intrinsics.checkParameterIsNotNull(singleSource5, "s5");
        Intrinsics.checkParameterIsNotNull(singleSource6, "s6");
        Intrinsics.checkParameterIsNotNull(singleSource7, "s7");
        Intrinsics.checkParameterIsNotNull(function7, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, new io.reactivex.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R>(function7) { // from class: io.reactivex.rxkotlin.Singles$zip$8
            public final /* synthetic */ Function7 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function7
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…2, t3, t4, t5, t6, t7) })");
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull SingleSource<T5> singleSource5, @NotNull SingleSource<T6> singleSource6, @NotNull SingleSource<T7> singleSource7, @NotNull SingleSource<T8> singleSource8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        Intrinsics.checkParameterIsNotNull(singleSource5, "s5");
        Intrinsics.checkParameterIsNotNull(singleSource6, "s6");
        Intrinsics.checkParameterIsNotNull(singleSource7, "s7");
        Intrinsics.checkParameterIsNotNull(singleSource8, "s8");
        Intrinsics.checkParameterIsNotNull(function8, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, new io.reactivex.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>(function8) { // from class: io.reactivex.rxkotlin.Singles$zip$9
            public final /* synthetic */ Function8 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function8
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7, t8);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…3, t4, t5, t6, t7, t8) })");
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(@NotNull SingleSource<T1> singleSource, @NotNull SingleSource<T2> singleSource2, @NotNull SingleSource<T3> singleSource3, @NotNull SingleSource<T4> singleSource4, @NotNull SingleSource<T5> singleSource5, @NotNull SingleSource<T6> singleSource6, @NotNull SingleSource<T7> singleSource7, @NotNull SingleSource<T8> singleSource8, @NotNull SingleSource<T9> singleSource9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(singleSource3, "s3");
        Intrinsics.checkParameterIsNotNull(singleSource4, "s4");
        Intrinsics.checkParameterIsNotNull(singleSource5, "s5");
        Intrinsics.checkParameterIsNotNull(singleSource6, "s6");
        Intrinsics.checkParameterIsNotNull(singleSource7, "s7");
        Intrinsics.checkParameterIsNotNull(singleSource8, "s8");
        Intrinsics.checkParameterIsNotNull(singleSource9, "s9");
        Intrinsics.checkParameterIsNotNull(function9, "zipper");
        Single<R> zip = Single.zip(singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9, new io.reactivex.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>(function9) { // from class: io.reactivex.rxkotlin.Singles$zip$10
            public final /* synthetic */ Function9 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function9
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8, T9 t9) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7, t8, t9);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Single.zip(s1, s2, s3, s…4, t5, t6, t7, t8, t9) })");
        return zip;
    }
}
