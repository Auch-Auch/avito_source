package n6.a;

import arrow.core.Option;
import arrow.core.PartialFunction;
import arrow.core.PartialFunctionKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class f<A, B> implements Function1<A, Option<? extends B>> {
    @NotNull
    public final PartialFunction<A, B> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: arrow.core.PartialFunction<? super A, ? extends B> */
    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull PartialFunction<? super A, ? extends B> partialFunction) {
        Intrinsics.checkParameterIsNotNull(partialFunction, "pf");
        this.a = partialFunction;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return (Option) PartialFunctionKt.invokeOrElse(PartialFunctionKt.andThen(this.a, d.a), obj, (Function1<? super Object, ? extends Object>) e.a);
    }
}
