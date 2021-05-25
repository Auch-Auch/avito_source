package org.kodein.di.bindings;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.internal.LangKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010\u0016J7\u0010\n\u001a\u00020\u00022\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0010\u001a \u0012\u001c\u0012\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00070\u000f0\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00122\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018R.\u0010\u001c\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00070\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0013\u0010#\u001a\u00020 8F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lorg/kodein/di/bindings/StandardScopeRegistry;", "Lorg/kodein/di/bindings/ScopeRegistry;", "", "Lorg/kodein/di/bindings/RegKey;", "key", "", "sync", "Lkotlin/Function0;", "Lorg/kodein/di/bindings/Reference;", "creator", "getOrCreate", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function0;", "", "Lkotlin/Pair;", ResidentialComplexModuleKt.VALUES, "()Ljava/util/List;", "", ProductAction.ACTION_REMOVE, "(Ljava/lang/Object;)V", "clear", "()V", "isEmpty", "()Z", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "_cache", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "_lock", "", "getSize", "()I", "size", "<init>", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class StandardScopeRegistry extends ScopeRegistry {
    public final Map<Object, Function0<Object>> a = LangKt.newConcurrentMap();
    public final Object b = new Object();

    public StandardScopeRegistry() {
        super(null);
    }

    @Override // org.kodein.di.bindings.ScopeRegistry
    public void clear() {
        List<Function0> list;
        List list2;
        Object obj = this.b;
        if (obj == null) {
            list = CollectionsKt___CollectionsKt.toList(this.a.values());
            this.a.clear();
        } else {
            synchronized (obj) {
                list2 = CollectionsKt___CollectionsKt.toList(this.a.values());
                this.a.clear();
            }
            list = list2;
        }
        for (Function0 function0 : list) {
            Object invoke = function0.invoke();
            if (!(invoke instanceof ScopeCloseable)) {
                invoke = null;
            }
            ScopeCloseable scopeCloseable = (ScopeCloseable) invoke;
            if (scopeCloseable != null) {
                scopeCloseable.close();
            }
        }
    }

    @Override // org.kodein.di.bindings.ScopeRegistry
    @NotNull
    public Object getOrCreate(@NotNull Object obj, boolean z, @NotNull Function0<? extends Reference<? extends Object>> function0) {
        Intrinsics.checkParameterIsNotNull(obj, "key");
        Intrinsics.checkParameterIsNotNull(function0, "creator");
        Object obj2 = null;
        Object obj3 = z ? this.b : null;
        Function0<Object> function02 = this.a.get(obj);
        Object invoke = function02 != null ? function02.invoke() : null;
        if (invoke != null) {
            return invoke;
        }
        if (obj3 == null) {
            Function0<Object> function03 = this.a.get(obj);
            if (function03 != null) {
                obj2 = function03.invoke();
            }
            if (obj2 == null) {
                Reference reference = (Reference) function0.invoke();
                Object component1 = reference.component1();
                this.a.put(obj, reference.component2());
                return component1;
            }
        } else {
            synchronized (obj3) {
                Function0<Object> function04 = this.a.get(obj);
                if (function04 != null) {
                    obj2 = function04.invoke();
                }
                if (obj2 == null) {
                    Reference reference2 = (Reference) function0.invoke();
                    Object component12 = reference2.component1();
                    this.a.put(obj, reference2.component2());
                    return component12;
                }
            }
        }
        return obj2;
    }

    @Override // org.kodein.di.bindings.ScopeRegistry
    @Nullable
    public Function0<Object> getOrNull(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "key");
        return this.a.get(obj);
    }

    public final int getSize() {
        return this.a.size();
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // org.kodein.di.bindings.ScopeRegistry
    public void remove(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "key");
        Function0<Object> remove = this.a.remove(obj);
        ScopeCloseable scopeCloseable = null;
        Object invoke = remove != null ? remove.invoke() : null;
        if (invoke instanceof ScopeCloseable) {
            scopeCloseable = invoke;
        }
        ScopeCloseable scopeCloseable2 = scopeCloseable;
        if (scopeCloseable2 != null) {
            scopeCloseable2.close();
        }
    }

    @Override // org.kodein.di.bindings.ScopeRegistry
    @NotNull
    public List<Pair<Object, Function0<Object>>> values() {
        Map<Object, Function0<Object>> map = this.a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Object, Function0<Object>> entry : map.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
