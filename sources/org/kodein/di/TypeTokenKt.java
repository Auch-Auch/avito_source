package org.kodein.di;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import x6.d.a.i;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\"\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003¨\u0006\b"}, d2 = {"Lorg/kodein/di/TypeToken;", "", "getAnyToken", "()Lorg/kodein/di/TypeToken;", "AnyToken", "", "getUnitToken", "UnitToken", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class TypeTokenKt {
    @NotNull
    public static final TypeToken<Object> getAnyToken() {
        i iVar = i.c;
        return i.b;
    }

    @NotNull
    public static final TypeToken<Unit> getUnitToken() {
        i iVar = i.c;
        return i.a;
    }
}
