package org.kodein.di.bindings;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.TypeToken;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "T", "Lorg/kodein/di/Kodein$Builder$TypeBinder;", "Lorg/kodein/di/TypeToken;", "", "setTypeToken", "Lorg/kodein/di/bindings/TypeBinderInSet;", "InSet", "(Lorg/kodein/di/Kodein$Builder$TypeBinder;Lorg/kodein/di/TypeToken;)Lorg/kodein/di/bindings/TypeBinderInSet;", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class SetKt {
    @NotNull
    public static final <T> TypeBinderInSet<T, Set<T>> InSet(@NotNull Kodein.Builder.TypeBinder<T> typeBinder, @NotNull TypeToken<Set<T>> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeBinder, "$this$InSet");
        Intrinsics.checkParameterIsNotNull(typeToken, "setTypeToken");
        return new TypeBinderInSet<>(typeBinder, typeToken);
    }
}
