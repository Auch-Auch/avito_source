package org.kodein.di.bindings;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0016J9\u0010\n\u001a\u00020\u00022\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0010\u001a \u0012\u001c\u0012\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00070\u000f0\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00122\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0016\u0001\u0002\u0019\u001a¨\u0006\u001b"}, d2 = {"Lorg/kodein/di/bindings/ScopeRegistry;", "Lorg/kodein/di/bindings/ScopeCloseable;", "", "Lorg/kodein/di/bindings/RegKey;", "key", "", "sync", "Lkotlin/Function0;", "Lorg/kodein/di/bindings/Reference;", "creator", "getOrCreate", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function0;", "", "Lkotlin/Pair;", ResidentialComplexModuleKt.VALUES, "()Ljava/lang/Iterable;", "", ProductAction.ACTION_REMOVE, "(Ljava/lang/Object;)V", "clear", "()V", "close", "<init>", "Lorg/kodein/di/bindings/StandardScopeRegistry;", "Lorg/kodein/di/bindings/SingleItemScopeRegistry;", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public abstract class ScopeRegistry implements ScopeCloseable {
    public ScopeRegistry() {
    }

    public static /* synthetic */ Object getOrCreate$default(ScopeRegistry scopeRegistry, Object obj, boolean z, Function0 function0, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return scopeRegistry.getOrCreate(obj, z, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOrCreate");
    }

    public abstract void clear();

    @Override // org.kodein.di.bindings.ScopeCloseable
    public final void close() {
        clear();
    }

    @NotNull
    public abstract Object getOrCreate(@NotNull Object obj, boolean z, @NotNull Function0<? extends Reference<? extends Object>> function0);

    @Nullable
    public abstract Function0<Object> getOrNull(@NotNull Object obj);

    public abstract void remove(@NotNull Object obj);

    @NotNull
    public abstract Iterable<Pair<Object, Function0<Object>>> values();

    public ScopeRegistry(j jVar) {
    }
}
