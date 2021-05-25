package arrow.core;

import arrow.Kind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001**\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0002j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007*@\u0010\t\u001a\u0004\b\u0000\u0010\u0000\u001a\u0004\b\u0001\u0010\u0001\"\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\b2\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00010\u0002*(\u0010\n\u001a\u0004\b\u0000\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u000b"}, d2 = {"I", "O", "Larrow/Kind;", "Larrow/core/ForFunction1;", "Larrow/core/Function1Of;", "Larrow/core/Function1;", "fix", "(Larrow/Kind;)Larrow/core/Function1;", "Larrow/Kind2;", "Function1Of", "Function1PartialOf", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class Higherkind_arrow_core_Function1Kt {
    @NotNull
    public static final <I, O> Function1<I, O> fix(@NotNull Kind<? extends Kind<ForFunction1, ? extends I>, ? extends O> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        return (Function1) kind;
    }
}
