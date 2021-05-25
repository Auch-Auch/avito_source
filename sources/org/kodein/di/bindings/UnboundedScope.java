package org.kodein.di.bindings;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0006\u0010\r¨\u0006\u0011"}, d2 = {"Lorg/kodein/di/bindings/UnboundedScope;", "Lorg/kodein/di/bindings/Scope;", "", "Lorg/kodein/di/bindings/ScopeCloseable;", "context", "Lorg/kodein/di/bindings/ScopeRegistry;", "getRegistry", "(Ljava/lang/Object;)Lorg/kodein/di/bindings/ScopeRegistry;", "", "close", "()V", AuthSource.SEND_ABUSE, "Lorg/kodein/di/bindings/ScopeRegistry;", "()Lorg/kodein/di/bindings/ScopeRegistry;", "registry", "<init>", "(Lorg/kodein/di/bindings/ScopeRegistry;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public class UnboundedScope implements Scope<Object>, ScopeCloseable {
    @NotNull
    public final ScopeRegistry a;

    public UnboundedScope() {
        this(null, 1, null);
    }

    public UnboundedScope(@NotNull ScopeRegistry scopeRegistry) {
        Intrinsics.checkParameterIsNotNull(scopeRegistry, "registry");
        this.a = scopeRegistry;
    }

    @Override // org.kodein.di.bindings.ScopeCloseable
    public void close() {
        this.a.clear();
    }

    @NotNull
    public final ScopeRegistry getRegistry() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnboundedScope(ScopeRegistry scopeRegistry, int i, j jVar) {
        this((i & 1) != 0 ? new StandardScopeRegistry() : scopeRegistry);
    }

    @Override // org.kodein.di.bindings.Scope
    @NotNull
    public ScopeRegistry getRegistry(@Nullable Object obj) {
        return this.a;
    }
}
