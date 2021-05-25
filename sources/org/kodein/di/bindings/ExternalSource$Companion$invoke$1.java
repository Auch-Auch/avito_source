package org.kodein.di.bindings;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J?\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"org/kodein/di/bindings/ExternalSource$Companion$invoke$1", "Lorg/kodein/di/bindings/ExternalSource;", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "key", "Lkotlin/Function1;", "", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class ExternalSource$Companion$invoke$1 implements ExternalSource {
    public final /* synthetic */ Function2 a;

    public ExternalSource$Companion$invoke$1(Function2 function2) {
        this.a = function2;
    }

    @Override // org.kodein.di.bindings.ExternalSource
    @Nullable
    public Function1<Object, Object> getFactory(@NotNull BindingKodein<?> bindingKodein, @NotNull Kodein.Key<?, ?, ?> key) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "kodein");
        Intrinsics.checkParameterIsNotNull(key, "key");
        return (Function1) this.a.invoke(bindingKodein, key);
    }
}
