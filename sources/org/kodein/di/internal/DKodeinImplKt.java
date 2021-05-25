package org.kodein.di.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import org.kodein.di.KodeinContext;
import org.kodein.di.TypeToken;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class DKodeinImplKt {
    public static final TypeToken access$getAnyType$p(KodeinContext kodeinContext) {
        TypeToken type = kodeinContext.getType();
        if (type != null) {
            return type;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any?>");
    }
}
