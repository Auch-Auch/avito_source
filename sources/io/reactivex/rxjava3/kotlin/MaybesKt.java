package io.reactivex.rxjava3.kotlin;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ah\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u001a\b\u0004\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007H\b¢\u0006\u0004\b\t\u0010\n\u001aM\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b0\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b\t\u0010\f¨\u0006\r"}, d2 = {"", "T", "U", "R", "Lio/reactivex/rxjava3/core/Maybe;", "Lio/reactivex/rxjava3/core/MaybeSource;", "other", "Lkotlin/Function2;", "zipper", "zipWith", "(Lio/reactivex/rxjava3/core/Maybe;Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Maybe;", "Lkotlin/Pair;", "(Lio/reactivex/rxjava3/core/Maybe;Lio/reactivex/rxjava3/core/MaybeSource;)Lio/reactivex/rxjava3/core/Maybe;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class MaybesKt {

    public static final class a<T1, T2, R> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
        public static final a a = new a();

        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return new Pair(obj, obj2);
        }
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U, R> Maybe<R> zipWith(@NotNull Maybe<T> maybe, @NotNull MaybeSource<U> maybeSource, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(maybe, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(maybeSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Maybe<R> zipWith = maybe.zipWith(maybeSource, new BiFunction<T, U, R>(function2) { // from class: io.reactivex.rxjava3.kotlin.MaybesKt$zipWith$1
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
    public static final <T, U> Maybe<Pair<T, U>> zipWith(@NotNull Maybe<T> maybe, @NotNull MaybeSource<U> maybeSource) {
        Intrinsics.checkParameterIsNotNull(maybe, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(maybeSource, "other");
        Maybe<R> zipWith = maybe.zipWith(maybeSource, a.a);
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunction { t, u -> Pair(t, u) })");
        return zipWith;
    }
}
