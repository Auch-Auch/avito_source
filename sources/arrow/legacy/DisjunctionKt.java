package arrow.legacy;

import arrow.legacy.Disjunction;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\u0004\b\f\u0010\r\u001a[\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\n*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00028\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00030\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001ao\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000e\"\u0004\b\u0003\u0010\u0013*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00032\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0015¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"T", "Lkotlin/Function0;", SDKConstants.PARAM_A2U_BODY, "Larrow/legacy/Disjunction;", "", "disjunctionTry", "(Lkotlin/jvm/functions/Function0;)Larrow/legacy/Disjunction;", "merge", "(Larrow/legacy/Disjunction;)Ljava/lang/Object;", "L", "R", "default", "getOrElse", "(Larrow/legacy/Disjunction;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "X", "Lkotlin/Function1;", "f", "flatMap", "(Larrow/legacy/Disjunction;Lkotlin/jvm/functions/Function1;)Larrow/legacy/Disjunction;", "Y", "x", "Lkotlin/Function2;", "map", "(Larrow/legacy/Disjunction;Larrow/legacy/Disjunction;Lkotlin/jvm/functions/Function2;)Larrow/legacy/Disjunction;", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class DisjunctionKt {

    public static final class a extends Lambda implements Function1<R, Disjunction<? extends L, ? extends Y>> {
        public final /* synthetic */ Disjunction a;
        public final /* synthetic */ Function2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Disjunction disjunction, Function2 function2) {
            super(1);
            this.a = disjunction;
            this.b = function2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return this.a.map(new n6.b.a(this, obj));
        }
    }

    @NotNull
    public static final <T> Disjunction<Throwable, T> disjunctionTry(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, SDKConstants.PARAM_A2U_BODY);
        try {
            return new Disjunction.Right(function0.invoke());
        } catch (Throwable th) {
            return new Disjunction.Left(th);
        }
    }

    @NotNull
    public static final <X, L, R> Disjunction<L, X> flatMap(@NotNull Disjunction<? extends L, ? extends R> disjunction, @NotNull Function1<? super R, ? extends Disjunction<? extends L, ? extends X>> function1) {
        Intrinsics.checkParameterIsNotNull(disjunction, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (disjunction instanceof Disjunction.Right) {
            return (Disjunction) function1.invoke((Object) ((Disjunction.Right) disjunction).getValue());
        }
        if (disjunction instanceof Disjunction.Left) {
            return new Disjunction.Left(((Disjunction.Left) disjunction).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <L, R> R getOrElse(@NotNull Disjunction<? extends L, ? extends R> disjunction, @NotNull Function0<? extends R> function0) {
        Intrinsics.checkParameterIsNotNull(disjunction, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "default");
        if (disjunction instanceof Disjunction.Right) {
            return (R) ((Disjunction.Right) disjunction).getValue();
        }
        if (disjunction instanceof Disjunction.Left) {
            return (R) function0.invoke();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <L, R, X, Y> Disjunction<L, Y> map(@NotNull Disjunction<? extends L, ? extends R> disjunction, @NotNull Disjunction<? extends L, ? extends X> disjunction2, @NotNull Function2<? super R, ? super X, ? extends Y> function2) {
        Intrinsics.checkParameterIsNotNull(disjunction, "$receiver");
        Intrinsics.checkParameterIsNotNull(disjunction2, "x");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        return flatMap(disjunction, new a(disjunction2, function2));
    }

    public static final <T> T merge(@NotNull Disjunction<? extends T, ? extends T> disjunction) {
        Intrinsics.checkParameterIsNotNull(disjunction, "$receiver");
        if (disjunction instanceof Disjunction.Right) {
            return (T) ((Disjunction.Right) disjunction).getValue();
        }
        if (disjunction instanceof Disjunction.Left) {
            return (T) ((Disjunction.Left) disjunction).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }
}
