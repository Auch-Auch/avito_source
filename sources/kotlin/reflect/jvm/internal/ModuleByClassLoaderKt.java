package kotlin.reflect.jvm.internal;

import com.avito.android.remote.auth.AuthSource;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import t6.w.f.a.k;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"(\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getOrCreateModule", "(Ljava/lang/Class;)Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "", "clearModuleByClassLoaderCache", "()V", "Ljava/util/concurrent/ConcurrentMap;", "Lt6/w/f/a/k;", "Ljava/lang/ref/WeakReference;", AuthSource.SEND_ABUSE, "Ljava/util/concurrent/ConcurrentMap;", "moduleByClassLoader", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
public final class ModuleByClassLoaderKt {
    public static final ConcurrentMap<k, WeakReference<RuntimeModuleData>> a = new ConcurrentHashMap();

    public static final void clearModuleByClassLoaderCache() {
        a.clear();
    }

    @NotNull
    public static final RuntimeModuleData getOrCreateModule(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "$this$getOrCreateModule");
        ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(cls);
        k kVar = new k(safeClassLoader);
        ConcurrentMap<k, WeakReference<RuntimeModuleData>> concurrentMap = a;
        WeakReference<RuntimeModuleData> weakReference = concurrentMap.get(kVar);
        if (weakReference != null) {
            RuntimeModuleData runtimeModuleData = weakReference.get();
            if (runtimeModuleData != null) {
                Intrinsics.checkNotNullExpressionValue(runtimeModuleData, "it");
                return runtimeModuleData;
            }
            concurrentMap.remove(kVar, weakReference);
        }
        RuntimeModuleData create = RuntimeModuleData.Companion.create(safeClassLoader);
        while (true) {
            ConcurrentMap<k, WeakReference<RuntimeModuleData>> concurrentMap2 = a;
            WeakReference<RuntimeModuleData> putIfAbsent = concurrentMap2.putIfAbsent(kVar, new WeakReference<>(create));
            if (putIfAbsent == null) {
                return create;
            }
            RuntimeModuleData runtimeModuleData2 = putIfAbsent.get();
            if (runtimeModuleData2 != null) {
                return runtimeModuleData2;
            }
            concurrentMap2.remove(kVar, putIfAbsent);
        }
    }
}
