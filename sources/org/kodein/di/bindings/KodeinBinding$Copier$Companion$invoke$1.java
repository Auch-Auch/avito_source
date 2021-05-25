package org.kodein.di.bindings;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.KodeinContainer;
import org.kodein.di.bindings.KodeinBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001J)\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"org/kodein/di/bindings/KodeinBinding$Copier$Companion$invoke$1", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "Lorg/kodein/di/KodeinContainer$Builder;", "builder", "Lorg/kodein/di/bindings/KodeinBinding;", "copy", "(Lorg/kodein/di/KodeinContainer$Builder;)Lorg/kodein/di/bindings/KodeinBinding;", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class KodeinBinding$Copier$Companion$invoke$1 implements KodeinBinding.Copier<C, A, T> {
    public final /* synthetic */ Function1 a;

    public KodeinBinding$Copier$Companion$invoke$1(Function1 function1) {
        this.a = function1;
    }

    @Override // org.kodein.di.bindings.KodeinBinding.Copier
    @NotNull
    public KodeinBinding<C, A, T> copy(@NotNull KodeinContainer.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        return (KodeinBinding) this.a.invoke(builder);
    }
}
