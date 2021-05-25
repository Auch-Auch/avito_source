package arrow.legacy;

import arrow.core.Either;
import arrow.core.EitherKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import n6.b.c;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0005\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u0000\"\u0004\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00022\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00028\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\t0\b¢\u0006\u0004\b\u000b\u0010\f\u001ao\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00030\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0007\"\u0004\b\u0003\u0010\r*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"L", "R", "Larrow/legacy/RightProjection;", "Lkotlin/Function0;", "default", "getOrElse", "(Larrow/legacy/RightProjection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "X", "Lkotlin/Function1;", "Larrow/core/Either;", "f", "flatMap", "(Larrow/legacy/RightProjection;Lkotlin/jvm/functions/Function1;)Larrow/core/Either;", "Y", "x", "Lkotlin/Function2;", "map", "(Larrow/legacy/RightProjection;Larrow/core/Either;Lkotlin/jvm/functions/Function2;)Larrow/core/Either;", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class RightProjectionKt {

    public static final class a extends Lambda implements Function1<R, Either<? extends L, ? extends Y>> {
        public final /* synthetic */ Either a;
        public final /* synthetic */ Function2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Either either, Function2 function2) {
            super(1);
            this.a = either;
            this.b = function2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return this.a.right().map(new c(this, obj));
        }
    }

    @NotNull
    public static final <X, L, R> Either<L, X> flatMap(@NotNull RightProjection<? extends L, ? extends R> rightProjection, @NotNull Function1<? super R, ? extends Either<? extends L, ? extends X>> function1) {
        Intrinsics.checkParameterIsNotNull(rightProjection, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Either<? extends L, ? extends R> e = rightProjection.getE();
        if (e instanceof Either.Left) {
            return EitherKt.Left(((Either.Left) rightProjection.getE()).getA());
        }
        if (e instanceof Either.Right) {
            return (Either) function1.invoke((Object) ((Either.Right) rightProjection.getE()).getB());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <L, R> R getOrElse(@NotNull RightProjection<? extends L, ? extends R> rightProjection, @NotNull Function0<? extends R> function0) {
        Intrinsics.checkParameterIsNotNull(rightProjection, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "default");
        Either<? extends L, ? extends R> e = rightProjection.getE();
        if (e instanceof Either.Right) {
            return (R) ((Either.Right) rightProjection.getE()).getB();
        }
        if (e instanceof Either.Left) {
            return (R) function0.invoke();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <L, R, X, Y> Either<L, Y> map(@NotNull RightProjection<? extends L, ? extends R> rightProjection, @NotNull Either<? extends L, ? extends X> either, @NotNull Function2<? super R, ? super X, ? extends Y> function2) {
        Intrinsics.checkParameterIsNotNull(rightProjection, "$receiver");
        Intrinsics.checkParameterIsNotNull(either, "x");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        return flatMap(rightProjection, new a(either, function2));
    }
}
