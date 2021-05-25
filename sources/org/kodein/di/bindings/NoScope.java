package org.kodein.di.bindings;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lorg/kodein/di/bindings/NoScope;", "Lorg/kodein/di/bindings/Scope;", "", "context", "Lorg/kodein/di/bindings/StandardScopeRegistry;", "getRegistry", "(Ljava/lang/Object;)Lorg/kodein/di/bindings/StandardScopeRegistry;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/bindings/StandardScopeRegistry;", "_registry", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class NoScope implements Scope<Object> {
    public final StandardScopeRegistry a = new StandardScopeRegistry();

    @Override // org.kodein.di.bindings.Scope
    @NotNull
    public StandardScopeRegistry getRegistry(@Nullable Object obj) {
        return this.a;
    }
}
