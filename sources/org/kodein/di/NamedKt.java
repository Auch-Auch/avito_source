package org.kodein.di;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007\"\u001a\u0010\u000b\u001a\u00020\b*\u00020\u00028F@\u0006ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"", "T", "Lorg/kodein/di/KodeinAware;", "Lorg/kodein/di/TypeToken;", "type", "Lorg/kodein/di/KodeinProperty;", "Constant", "(Lorg/kodein/di/KodeinAware;Lorg/kodein/di/TypeToken;)Lorg/kodein/di/KodeinProperty;", "Lorg/kodein/di/Named;", "getNamed", "(Lorg/kodein/di/KodeinAware;)Lorg/kodein/di/KodeinAware;", "named", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class NamedKt {
    @NotNull
    public static final <T> KodeinProperty<T> Constant(@NotNull KodeinAware kodeinAware, @NotNull TypeToken<? extends T> typeToken) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$Constant");
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return Named.m699Instanceimpl(getNamed(kodeinAware), typeToken);
    }

    @NotNull
    public static final KodeinAware getNamed(@NotNull KodeinAware kodeinAware) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$named");
        return Named.m708constructorimpl(kodeinAware);
    }
}
