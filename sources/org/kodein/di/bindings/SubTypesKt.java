package org.kodein.di.bindings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "T", "Lorg/kodein/di/Kodein$Builder$TypeBinder;", "Lorg/kodein/di/bindings/TypeBinderSubTypes;", "subTypes", "(Lorg/kodein/di/Kodein$Builder$TypeBinder;)Lorg/kodein/di/bindings/TypeBinderSubTypes;", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class SubTypesKt {
    @NotNull
    public static final <T> TypeBinderSubTypes<T> subTypes(@NotNull Kodein.Builder.TypeBinder<T> typeBinder) {
        Intrinsics.checkParameterIsNotNull(typeBinder, "$this$subTypes");
        return new TypeBinderSubTypes<>(typeBinder);
    }
}
