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
import n6.b.b;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a[\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b\u001ao\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\t*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b¢\u0006\u0004\b\f\u0010\r\u001a7\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"L", "R", "X", "Larrow/legacy/LeftProjection;", "Lkotlin/Function1;", "Larrow/core/Either;", "f", "flatMap", "(Larrow/legacy/LeftProjection;Lkotlin/jvm/functions/Function1;)Larrow/core/Either;", "Y", "x", "Lkotlin/Function2;", "map", "(Larrow/legacy/LeftProjection;Larrow/core/Either;Lkotlin/jvm/functions/Function2;)Larrow/core/Either;", "Lkotlin/Function0;", "default", "getOrElse", "(Larrow/legacy/LeftProjection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class LeftProjectionKt {

    public static final class a extends Lambda implements Function1<L, Either<? extends Y, ? extends R>> {
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
            return this.a.left().map(new b(this, obj));
        }
    }

    @NotNull
    public static final <L, R, X> Either<X, R> flatMap(@NotNull LeftProjection<? extends L, ? extends R> leftProjection, @NotNull Function1<? super L, ? extends Either<? extends X, ? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(leftProjection, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Either<? extends L, ? extends R> e = leftProjection.getE();
        if (e instanceof Either.Left) {
            return (Either) function1.invoke((Object) ((Either.Left) leftProjection.getE()).getA());
        }
        if (e instanceof Either.Right) {
            return EitherKt.Right(((Either.Right) leftProjection.getE()).getB());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <L, R> L getOrElse(@NotNull LeftProjection<? extends L, ? extends R> leftProjection, @NotNull Function0<? extends L> function0) {
        Intrinsics.checkParameterIsNotNull(leftProjection, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "default");
        Either<? extends L, ? extends R> e = leftProjection.getE();
        if (e instanceof Either.Left) {
            return (L) ((Either.Left) leftProjection.getE()).getA();
        }
        if (e instanceof Either.Right) {
            return (L) function0.invoke();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <L, R, X, Y> Either<Y, R> map(@NotNull LeftProjection<? extends L, ? extends R> leftProjection, @NotNull Either<? extends X, ? extends R> either, @NotNull Function2<? super L, ? super X, ? extends Y> function2) {
        Intrinsics.checkParameterIsNotNull(leftProjection, "$receiver");
        Intrinsics.checkParameterIsNotNull(either, "x");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        return flatMap(leftProjection, new a(either, function2));
    }
}
