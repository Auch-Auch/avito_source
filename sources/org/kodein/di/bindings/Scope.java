package org.kodein.di.bindings;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lorg/kodein/di/bindings/Scope;", "C", "", "context", "Lorg/kodein/di/bindings/ScopeRegistry;", "getRegistry", "(Ljava/lang/Object;)Lorg/kodein/di/bindings/ScopeRegistry;", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface Scope<C> {
    @NotNull
    ScopeRegistry getRegistry(C c);
}
