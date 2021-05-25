package org.kodein.di.bindings;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a1\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00010\u00002\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/Function1;", "", "f", "externalFactory", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class ExternalSourceKt {
    @NotNull
    public static final Function1<Object, Object> externalFactory(@NotNull Function1<Object, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return function1;
    }
}
