package org.kodein.di.bindings;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x6.d.a.n.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\fB\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H$¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lorg/kodein/di/bindings/SubScope;", "C", "PC", "Lorg/kodein/di/bindings/Scope;", "context", "getParentContext", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lorg/kodein/di/bindings/ScopeRegistry;", "getRegistry", "(Ljava/lang/Object;)Lorg/kodein/di/bindings/ScopeRegistry;", "newRegistry", "()Lorg/kodein/di/bindings/ScopeRegistry;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/bindings/Scope;", "getParentScope", "()Lorg/kodein/di/bindings/Scope;", "parentScope", "<init>", "(Lorg/kodein/di/bindings/Scope;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public abstract class SubScope<C, PC> implements Scope<C> {
    @NotNull
    public final Scope<PC> a;

    public static final class a<C> {
        public final C a;

        public a(C c) {
            this.a = c;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
            }
            return true;
        }

        public int hashCode() {
            C c = this.a;
            if (c != null) {
                return c.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a2.b.a.a.a.r(a2.b.a.a.a.L("Key(context="), this.a, ")");
        }
    }

    public static final class b extends Lambda implements Function0<Reference<? extends ScopeRegistry>> {
        public final /* synthetic */ SubScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SubScope subScope) {
            super(0);
            this.a = subScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Reference<? extends ScopeRegistry> invoke() {
            return SingletonReference.INSTANCE.make(new j(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.kodein.di.bindings.Scope<? super PC> */
    /* JADX WARN: Multi-variable type inference failed */
    public SubScope(@NotNull Scope<? super PC> scope) {
        Intrinsics.checkParameterIsNotNull(scope, "parentScope");
        this.a = scope;
    }

    public abstract PC getParentContext(C c);

    @NotNull
    public final Scope<PC> getParentScope() {
        return this.a;
    }

    @Override // org.kodein.di.bindings.Scope
    @NotNull
    public ScopeRegistry getRegistry(C c) {
        Object orCreate = this.a.getRegistry(getParentContext(c)).getOrCreate(new a(c), false, new b(this));
        if (orCreate != null) {
            return (ScopeRegistry) orCreate;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.bindings.ScopeRegistry");
    }

    @NotNull
    public ScopeRegistry newRegistry() {
        return new StandardScopeRegistry();
    }
}
