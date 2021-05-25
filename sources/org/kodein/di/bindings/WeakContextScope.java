package org.kodein.di.bindings;

import com.avito.android.remote.auth.AuthSource;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0013B\u0017\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00078\b@\bX\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lorg/kodein/di/bindings/WeakContextScope;", "C", "Lorg/kodein/di/bindings/Scope;", "context", "Lorg/kodein/di/bindings/ScopeRegistry;", "getRegistry", "(Ljava/lang/Object;)Lorg/kodein/di/bindings/ScopeRegistry;", "Ljava/util/WeakHashMap;", AuthSource.SEND_ABUSE, "Ljava/util/WeakHashMap;", "map", "Lkotlin/Function0;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "getNewRepo", "()Lkotlin/jvm/functions/Function0;", "newRepo", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Of", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public class WeakContextScope<C> implements Scope<C> {
    public static final Of Of = new Of(null);
    public final WeakHashMap<C, ScopeRegistry> a;
    @NotNull
    public final Function0<ScopeRegistry> b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lorg/kodein/di/bindings/WeakContextScope$Of;", "Lorg/kodein/di/bindings/WeakContextScope;", "", "T", "Lorg/kodein/di/bindings/Scope;", "of", "()Lorg/kodein/di/bindings/Scope;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Of extends WeakContextScope<Object> {
        public Of() {
            super(null, 1, null);
        }

        @NotNull
        public final <T> Scope<T> of() {
            return this;
        }

        public Of(j jVar) {
            super(null, 1, null);
        }
    }

    public static final class a extends Lambda implements Function0<StandardScopeRegistry> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public StandardScopeRegistry invoke() {
            return new StandardScopeRegistry();
        }
    }

    public WeakContextScope() {
        this(null, 1, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends org.kodein.di.bindings.ScopeRegistry> */
    /* JADX WARN: Multi-variable type inference failed */
    public WeakContextScope(@NotNull Function0<? extends ScopeRegistry> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "newRepo");
        this.b = function0;
        this.a = new WeakHashMap<>();
    }

    @NotNull
    public final Function0<ScopeRegistry> getNewRepo() {
        return this.b;
    }

    @Override // org.kodein.di.bindings.Scope
    @NotNull
    public ScopeRegistry getRegistry(C c) {
        ScopeRegistry scopeRegistry;
        ScopeRegistry scopeRegistry2 = this.a.get(c);
        if (scopeRegistry2 != null) {
            Intrinsics.checkExpressionValueIsNotNull(scopeRegistry2, "it");
            return scopeRegistry2;
        }
        synchronized (this.a) {
            WeakHashMap<C, ScopeRegistry> weakHashMap = this.a;
            ScopeRegistry scopeRegistry3 = weakHashMap.get(c);
            if (scopeRegistry3 == null) {
                scopeRegistry3 = this.b.invoke();
                weakHashMap.put(c, scopeRegistry3);
            }
            Intrinsics.checkExpressionValueIsNotNull(scopeRegistry3, "map.getOrPut(context) { newRepo() }");
            scopeRegistry = scopeRegistry3;
        }
        return scopeRegistry;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WeakContextScope(Function0 function0, int i, j jVar) {
        this((i & 1) != 0 ? a.a : function0);
    }
}
