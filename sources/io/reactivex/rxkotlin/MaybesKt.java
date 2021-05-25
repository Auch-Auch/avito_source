package io.reactivex.rxkotlin;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\\\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u001a\b\u0004\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006H\b¢\u0006\u0004\b\b\u0010\t\u001aE\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\u000b¨\u0006\f"}, d2 = {"T", "U", "R", "Lio/reactivex/Maybe;", "Lio/reactivex/MaybeSource;", "other", "Lkotlin/Function2;", "zipper", "zipWith", "(Lio/reactivex/Maybe;Lio/reactivex/MaybeSource;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Maybe;", "Lkotlin/Pair;", "(Lio/reactivex/Maybe;Lio/reactivex/MaybeSource;)Lio/reactivex/Maybe;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class MaybesKt {

    public static final class a<T1, T2, R> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
        public static final a a = new a();

        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return new Pair(obj, obj2);
        }
    }

    @NotNull
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T, U, R> Maybe<R> zipWith(@NotNull Maybe<T> maybe, @NotNull MaybeSource<U> maybeSource, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(maybe, "$receiver");
        Intrinsics.checkParameterIsNotNull(maybeSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Maybe<R> zipWith = maybe.zipWith(maybeSource, new BiFunction<T, U, R>(function2) { // from class: io.reactivex.rxkotlin.MaybesKt$zipWith$1
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
    public static final <T, U> Maybe<Pair<T, U>> zipWith(@NotNull Maybe<T> maybe, @NotNull MaybeSource<U> maybeSource) {
        Intrinsics.checkParameterIsNotNull(maybe, "$receiver");
        Intrinsics.checkParameterIsNotNull(maybeSource, "other");
        Maybe<R> zipWith = maybe.zipWith(maybeSource, a.a);
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunction { t, u -> Pair(t,u) })");
        return zipWith;
    }
}
