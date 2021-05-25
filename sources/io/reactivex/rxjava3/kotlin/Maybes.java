package io.reactivex.rxjava3.kotlin;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function3;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b/\u00100Jl\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bH\b¢\u0006\u0004\b\u000b\u0010\fJQ\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\n\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\u000eJ\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00030\n\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\b\b\u0001\u0010\u0010*\u00020\u0001\"\b\b\u0002\u0010\u0011*\u00020\u0001\"\b\b\u0003\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052 \b\u0004\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0013H\b¢\u0006\u0004\b\u000b\u0010\u0014Jo\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00150\n\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\b\b\u0001\u0010\u0010*\u00020\u0001\"\b\b\u0002\u0010\u0011*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\u0016J¨\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00040\n\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\b\b\u0001\u0010\u0010*\u00020\u0001\"\b\b\u0002\u0010\u0011*\u00020\u0001\"\b\b\u0003\u0010\u0017*\u00020\u0001\"\b\b\u0004\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052&\b\u0004\u0010\t\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0019H\b¢\u0006\u0004\b\u000b\u0010\u001aJÆ\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00050\n\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\b\b\u0001\u0010\u0010*\u00020\u0001\"\b\b\u0002\u0010\u0011*\u00020\u0001\"\b\b\u0003\u0010\u0017*\u00020\u0001\"\b\b\u0004\u0010\u001b*\u00020\u0001\"\b\b\u0005\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052,\b\u0004\u0010\t\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001dH\b¢\u0006\u0004\b\u000b\u0010\u001eJä\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00060\n\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\b\b\u0001\u0010\u0010*\u00020\u0001\"\b\b\u0002\u0010\u0011*\u00020\u0001\"\b\b\u0003\u0010\u0017*\u00020\u0001\"\b\b\u0004\u0010\u001b*\u00020\u0001\"\b\b\u0005\u0010\u001f*\u00020\u0001\"\b\b\u0006\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00050\u000522\b\u0004\u0010\t\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060!H\b¢\u0006\u0004\b\u000b\u0010\"J\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00070\n\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\b\b\u0001\u0010\u0010*\u00020\u0001\"\b\b\u0002\u0010\u0011*\u00020\u0001\"\b\b\u0003\u0010\u0017*\u00020\u0001\"\b\b\u0004\u0010\u001b*\u00020\u0001\"\b\b\u0005\u0010\u001f*\u00020\u0001\"\b\b\u0006\u0010#*\u00020\u0001\"\b\b\u0007\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00060\u000528\b\u0004\u0010\t\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070%H\b¢\u0006\u0004\b\u000b\u0010&J \u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\b0\n\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\b\b\u0001\u0010\u0010*\u00020\u0001\"\b\b\u0002\u0010\u0011*\u00020\u0001\"\b\b\u0003\u0010\u0017*\u00020\u0001\"\b\b\u0004\u0010\u001b*\u00020\u0001\"\b\b\u0005\u0010\u001f*\u00020\u0001\"\b\b\u0006\u0010#*\u00020\u0001\"\b\b\u0007\u0010'*\u00020\u0001\"\b\b\b\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052>\b\u0004\u0010\t\u001a8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0)H\b¢\u0006\u0004\b\u000b\u0010*J¾\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\t0\n\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\b\b\u0001\u0010\u0010*\u00020\u0001\"\b\b\u0002\u0010\u0011*\u00020\u0001\"\b\b\u0003\u0010\u0017*\u00020\u0001\"\b\b\u0004\u0010\u001b*\u00020\u0001\"\b\b\u0005\u0010\u001f*\u00020\u0001\"\b\b\u0006\u0010#*\u00020\u0001\"\b\b\u0007\u0010'*\u00020\u0001\"\b\b\b\u0010+*\u00020\u0001\"\b\b\t\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\b0\u00052D\b\u0004\u0010\t\u001a>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t0-H\b¢\u0006\u0004\b\u000b\u0010.¨\u00061"}, d2 = {"Lio/reactivex/rxjava3/kotlin/Maybes;", "", "T", "U", "R", "Lio/reactivex/rxjava3/core/MaybeSource;", "s1", "s2", "Lkotlin/Function2;", "zipper", "Lio/reactivex/rxjava3/core/Maybe;", "zip", "(Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Maybe;", "Lkotlin/Pair;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;)Lio/reactivex/rxjava3/core/Maybe;", "T1", "T2", "T3", "s3", "Lkotlin/Function3;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function3;)Lio/reactivex/rxjava3/core/Maybe;", "Lkotlin/Triple;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;)Lio/reactivex/rxjava3/core/Maybe;", "T4", "s4", "Lkotlin/Function4;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function4;)Lio/reactivex/rxjava3/core/Maybe;", "T5", "s5", "Lkotlin/Function5;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function5;)Lio/reactivex/rxjava3/core/Maybe;", "T6", "s6", "Lkotlin/Function6;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function6;)Lio/reactivex/rxjava3/core/Maybe;", "T7", "s7", "Lkotlin/Function7;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function7;)Lio/reactivex/rxjava3/core/Maybe;", "T8", "s8", "Lkotlin/Function8;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function8;)Lio/reactivex/rxjava3/core/Maybe;", "T9", "s9", "Lkotlin/Function9;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function9;)Lio/reactivex/rxjava3/core/Maybe;", "<init>", "()V", "rxkotlin"}, k = 1, mv = {1, 4, 0})
public final class Maybes {
    public static final Maybes INSTANCE = new Maybes();

    public static final class a<T1, T2, R> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
        public static final a a = new a();

        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return new Pair(obj, obj2);
        }
    }

    public static final class b<T1, T2, T3, R> implements Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return new Triple(obj, obj2, obj3);
        }
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T, U, R> Maybe<R> zip(@NotNull MaybeSource<T> maybeSource, @NotNull MaybeSource<U> maybeSource2, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, new BiFunction<T, U, R>(function2) { // from class: io.reactivex.rxjava3.kotlin.Maybes$zip$1
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
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2,\n      …-> zipper.invoke(t, u) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T, U> Maybe<Pair<T, U>> zip(@NotNull MaybeSource<T> maybeSource, @NotNull MaybeSource<U> maybeSource2) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Maybe<Pair<T, U>> zip = Maybe.zip(maybeSource, maybeSource2, a.a);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2,\n      …n { t, u -> Pair(t, u) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, R> Maybe<R> zip(@NotNull MaybeSource<T1> maybeSource, @NotNull MaybeSource<T2> maybeSource2, @NotNull MaybeSource<T3> maybeSource3, @NotNull kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(function3, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, new Function3<T1, T2, T3, R>(function3) { // from class: io.reactivex.rxjava3.kotlin.Maybes$zip$3
            public final /* synthetic */ kotlin.jvm.functions.Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function3
            @NotNull
            public final R apply(T1 t1, T2 t2, T3 t3) {
                kotlin.jvm.functions.Function3 function32 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                Intrinsics.checkExpressionValueIsNotNull(t3, "t3");
                return (R) function32.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3,\n  …per.invoke(t1, t2, t3) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3> Maybe<Triple<T1, T2, T3>> zip(@NotNull MaybeSource<T1> maybeSource, @NotNull MaybeSource<T2> maybeSource2, @NotNull MaybeSource<T3> maybeSource3) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Maybe<Triple<T1, T2, T3>> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, b.a);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3,\n  … -> Triple(t1, t2, t3) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, R> Maybe<R> zip(@NotNull MaybeSource<T1> maybeSource, @NotNull MaybeSource<T2> maybeSource2, @NotNull MaybeSource<T3> maybeSource3, @NotNull MaybeSource<T4> maybeSource4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(function4, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, new io.reactivex.rxjava3.functions.Function4<T1, T2, T3, T4, R>(function4) { // from class: io.reactivex.rxjava3.kotlin.Maybes$zip$5
            public final /* synthetic */ Function4 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function4
            @NotNull
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
                Function4 function42 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                Intrinsics.checkExpressionValueIsNotNull(t3, "t3");
                Intrinsics.checkExpressionValueIsNotNull(t4, "t4");
                return (R) function42.invoke(t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…invoke(t1, t2, t3, t4) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, R> Maybe<R> zip(@NotNull MaybeSource<T1> maybeSource, @NotNull MaybeSource<T2> maybeSource2, @NotNull MaybeSource<T3> maybeSource3, @NotNull MaybeSource<T4> maybeSource4, @NotNull MaybeSource<T5> maybeSource5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(maybeSource5, "s5");
        Intrinsics.checkParameterIsNotNull(function5, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, new io.reactivex.rxjava3.functions.Function5<T1, T2, T3, T4, T5, R>(function5) { // from class: io.reactivex.rxjava3.kotlin.Maybes$zip$6
            public final /* synthetic */ Function5 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function5
            @NotNull
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
                Function5 function52 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                Intrinsics.checkExpressionValueIsNotNull(t3, "t3");
                Intrinsics.checkExpressionValueIsNotNull(t4, "t4");
                Intrinsics.checkExpressionValueIsNotNull(t5, "t5");
                return (R) function52.invoke(t1, t2, t3, t4, t5);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…ke(t1, t2, t3, t4, t5) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, R> Maybe<R> zip(@NotNull MaybeSource<T1> maybeSource, @NotNull MaybeSource<T2> maybeSource2, @NotNull MaybeSource<T3> maybeSource3, @NotNull MaybeSource<T4> maybeSource4, @NotNull MaybeSource<T5> maybeSource5, @NotNull MaybeSource<T6> maybeSource6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(maybeSource5, "s5");
        Intrinsics.checkParameterIsNotNull(maybeSource6, "s6");
        Intrinsics.checkParameterIsNotNull(function6, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, new io.reactivex.rxjava3.functions.Function6<T1, T2, T3, T4, T5, T6, R>(function6) { // from class: io.reactivex.rxjava3.kotlin.Maybes$zip$7
            public final /* synthetic */ Function6 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function6
            @NotNull
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62) {
                Function6 function62 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                Intrinsics.checkExpressionValueIsNotNull(t3, "t3");
                Intrinsics.checkExpressionValueIsNotNull(t4, "t4");
                Intrinsics.checkExpressionValueIsNotNull(t5, "t5");
                Intrinsics.checkExpressionValueIsNotNull(t62, "t6");
                return (R) function62.invoke(t1, t2, t3, t4, t5, t62);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…1, t2, t3, t4, t5, t6) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, R> Maybe<R> zip(@NotNull MaybeSource<T1> maybeSource, @NotNull MaybeSource<T2> maybeSource2, @NotNull MaybeSource<T3> maybeSource3, @NotNull MaybeSource<T4> maybeSource4, @NotNull MaybeSource<T5> maybeSource5, @NotNull MaybeSource<T6> maybeSource6, @NotNull MaybeSource<T7> maybeSource7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(maybeSource5, "s5");
        Intrinsics.checkParameterIsNotNull(maybeSource6, "s6");
        Intrinsics.checkParameterIsNotNull(maybeSource7, "s7");
        Intrinsics.checkParameterIsNotNull(function7, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, new io.reactivex.rxjava3.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R>(function7) { // from class: io.reactivex.rxjava3.kotlin.Maybes$zip$8
            public final /* synthetic */ Function7 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function7
            @NotNull
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7) {
                Function7 function72 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                Intrinsics.checkExpressionValueIsNotNull(t3, "t3");
                Intrinsics.checkExpressionValueIsNotNull(t4, "t4");
                Intrinsics.checkExpressionValueIsNotNull(t5, "t5");
                Intrinsics.checkExpressionValueIsNotNull(t62, "t6");
                Intrinsics.checkExpressionValueIsNotNull(t7, "t7");
                return (R) function72.invoke(t1, t2, t3, t4, t5, t62, t7);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…2, t3, t4, t5, t6, t7) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Maybe<R> zip(@NotNull MaybeSource<T1> maybeSource, @NotNull MaybeSource<T2> maybeSource2, @NotNull MaybeSource<T3> maybeSource3, @NotNull MaybeSource<T4> maybeSource4, @NotNull MaybeSource<T5> maybeSource5, @NotNull MaybeSource<T6> maybeSource6, @NotNull MaybeSource<T7> maybeSource7, @NotNull MaybeSource<T8> maybeSource8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(maybeSource5, "s5");
        Intrinsics.checkParameterIsNotNull(maybeSource6, "s6");
        Intrinsics.checkParameterIsNotNull(maybeSource7, "s7");
        Intrinsics.checkParameterIsNotNull(maybeSource8, "s8");
        Intrinsics.checkParameterIsNotNull(function8, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, new io.reactivex.rxjava3.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>(function8) { // from class: io.reactivex.rxjava3.kotlin.Maybes$zip$9
            public final /* synthetic */ Function8 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function8
            @NotNull
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8) {
                Function8 function82 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                Intrinsics.checkExpressionValueIsNotNull(t3, "t3");
                Intrinsics.checkExpressionValueIsNotNull(t4, "t4");
                Intrinsics.checkExpressionValueIsNotNull(t5, "t5");
                Intrinsics.checkExpressionValueIsNotNull(t62, "t6");
                Intrinsics.checkExpressionValueIsNotNull(t7, "t7");
                Intrinsics.checkExpressionValueIsNotNull(t8, "t8");
                return (R) function82.invoke(t1, t2, t3, t4, t5, t62, t7, t8);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…3, t4, t5, t6, t7, t8) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Maybe<R> zip(@NotNull MaybeSource<T1> maybeSource, @NotNull MaybeSource<T2> maybeSource2, @NotNull MaybeSource<T3> maybeSource3, @NotNull MaybeSource<T4> maybeSource4, @NotNull MaybeSource<T5> maybeSource5, @NotNull MaybeSource<T6> maybeSource6, @NotNull MaybeSource<T7> maybeSource7, @NotNull MaybeSource<T8> maybeSource8, @NotNull MaybeSource<T9> maybeSource9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(maybeSource3, "s3");
        Intrinsics.checkParameterIsNotNull(maybeSource4, "s4");
        Intrinsics.checkParameterIsNotNull(maybeSource5, "s5");
        Intrinsics.checkParameterIsNotNull(maybeSource6, "s6");
        Intrinsics.checkParameterIsNotNull(maybeSource7, "s7");
        Intrinsics.checkParameterIsNotNull(maybeSource8, "s8");
        Intrinsics.checkParameterIsNotNull(maybeSource9, "s9");
        Intrinsics.checkParameterIsNotNull(function9, "zipper");
        Maybe<R> zip = Maybe.zip(maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, maybeSource9, new io.reactivex.rxjava3.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>(function9) { // from class: io.reactivex.rxjava3.kotlin.Maybes$zip$10
            public final /* synthetic */ Function9 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function9
            @NotNull
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8, T9 t9) {
                Function9 function92 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                Intrinsics.checkExpressionValueIsNotNull(t3, "t3");
                Intrinsics.checkExpressionValueIsNotNull(t4, "t4");
                Intrinsics.checkExpressionValueIsNotNull(t5, "t5");
                Intrinsics.checkExpressionValueIsNotNull(t62, "t6");
                Intrinsics.checkExpressionValueIsNotNull(t7, "t7");
                Intrinsics.checkExpressionValueIsNotNull(t8, "t8");
                Intrinsics.checkExpressionValueIsNotNull(t9, "t9");
                return (R) function92.invoke(t1, t2, t3, t4, t5, t62, t7, t8, t9);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Maybe.zip(s1, s2, s3, s4…4, t5, t6, t7, t8, t9) })");
        return zip;
    }
}
