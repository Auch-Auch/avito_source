package arrow.syntax.function;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001af\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005H\f¢\u0006\u0004\b\u0007\u0010\b\u001aT\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\f¢\u0006\u0004\b\u0007\u0010\t\u001aB\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\n2\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\f¢\u0006\u0004\b\u0007\u0010\u000b\u001af\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005H\f¢\u0006\u0004\b\f\u0010\b\u001aT\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\f¢\u0006\u0004\b\f\u0010\t\u001aB\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\n2\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\f¢\u0006\u0004\b\f\u0010\u000b\u001aT\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u0005H\f¢\u0006\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"P1", "P2", "IP", "R", "Lkotlin/Function2;", "Lkotlin/Function1;", "f", "andThen", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function2;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function0;", "forwardCompose", "compose", "arrow-syntax"}, k = 2, mv = {1, 4, 0})
public final class CompositionKt {
    @NotNull
    public static final <P1, P2, IP, R> Function2<P1, P2, R> andThen(@NotNull Function2<? super P1, ? super P2, ? extends IP> function2, @NotNull Function1<? super IP, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function2, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return new CompositionKt$forwardCompose$1(function2, function1);
    }

    @NotNull
    public static final <IP, R, P1> Function1<P1, R> compose(@NotNull Function1<? super IP, ? extends R> function1, @NotNull Function1<? super P1, ? extends IP> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        Intrinsics.checkParameterIsNotNull(function12, "f");
        return new Function1<P1, R>(function1, function12) { // from class: arrow.syntax.function.CompositionKt$compose$1
            public final /* synthetic */ Function1 a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(P1 p1) {
                return (R) this.a.invoke(this.b.invoke(p1));
            }
        };
    }

    @NotNull
    public static final <P1, P2, IP, R> Function2<P1, P2, R> forwardCompose(@NotNull Function2<? super P1, ? super P2, ? extends IP> function2, @NotNull Function1<? super IP, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function2, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return new CompositionKt$forwardCompose$1(function2, function1);
    }

    @NotNull
    public static final <P1, IP, R> Function1<P1, R> andThen(@NotNull Function1<? super P1, ? extends IP> function1, @NotNull Function1<? super IP, ? extends R> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        Intrinsics.checkParameterIsNotNull(function12, "f");
        return new CompositionKt$forwardCompose$2(function1, function12);
    }

    @NotNull
    public static final <P1, IP, R> Function1<P1, R> forwardCompose(@NotNull Function1<? super P1, ? extends IP> function1, @NotNull Function1<? super IP, ? extends R> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        Intrinsics.checkParameterIsNotNull(function12, "f");
        return new CompositionKt$forwardCompose$2(function1, function12);
    }

    @NotNull
    public static final <IP, R> Function0<R> andThen(@NotNull Function0<? extends IP> function0, @NotNull Function1<? super IP, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function0, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return new CompositionKt$forwardCompose$3(function0, function1);
    }

    @NotNull
    public static final <IP, R> Function0<R> forwardCompose(@NotNull Function0<? extends IP> function0, @NotNull Function1<? super IP, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function0, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return new CompositionKt$forwardCompose$3(function0, function1);
    }
}
