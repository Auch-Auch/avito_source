package arrow.core;

import arrow.Kind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aP\u0010\n\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00028\u00010\u0006j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\b2\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"I", "O", "Lkotlin/Function1;", "Larrow/core/Function1;", "k", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Function1;", "Larrow/Kind;", "Larrow/core/ForFunction1;", "Larrow/core/Function1Of;", "i", "invoke", "(Larrow/Kind;Ljava/lang/Object;)Ljava/lang/Object;", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class Function1Kt {
    public static final <I, O> O invoke(@NotNull Kind<? extends Kind<ForFunction1, ? extends I>, ? extends O> kind, I i) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        return ((Function1) kind).getF().invoke(i);
    }

    @NotNull
    public static final <I, O> Function1<I, O> k(@NotNull Function1<? super I, ? extends O> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        return new Function1<>(function1);
    }
}
