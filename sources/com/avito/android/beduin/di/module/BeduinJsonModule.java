package com.avito.android.beduin.di.module;

import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.beduin.core.registry.BeduinRegistry;
import com.avito.android.beduin.parse.BeduinActionParamsTypeAdapter;
import com.avito.android.beduin.parse.BeduinModelTypeAdapter;
import com.avito.android.remote.parse.adapter.RuntimeTypeAdapterFactory;
import com.google.gson.TypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/beduin/di/module/BeduinJsonModule;", "", "Lcom/avito/android/beduin/core/registry/BeduinRegistry;", "beduinRegistry", "Lcom/avito/android/beduin/parse/BeduinModelTypeAdapter;", "beduinModelTypeAdapter", "Lcom/avito/android/beduin/parse/BeduinActionParamsTypeAdapter;", "beduinActionParamsTypeAdapter", "", "Lcom/google/gson/TypeAdapterFactory;", "provideBeduinTypeAdapterFactories", "(Lcom/avito/android/beduin/core/registry/BeduinRegistry;Lcom/avito/android/beduin/parse/BeduinModelTypeAdapter;Lcom/avito/android/beduin/parse/BeduinActionParamsTypeAdapter;)Ljava/util/Set;", "provideBeduinModelTypeAdapter", "()Lcom/avito/android/beduin/parse/BeduinModelTypeAdapter;", "provideBeduinActionParamsTypeAdapter", "()Lcom/avito/android/beduin/parse/BeduinActionParamsTypeAdapter;", "<init>", "()V", "beduin_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class BeduinJsonModule {
    @NotNull
    public static final BeduinJsonModule INSTANCE = new BeduinJsonModule();

    @Provides
    @NotNull
    public final BeduinActionParamsTypeAdapter provideBeduinActionParamsTypeAdapter() {
        return new BeduinActionParamsTypeAdapter();
    }

    @Provides
    @NotNull
    public final BeduinModelTypeAdapter provideBeduinModelTypeAdapter() {
        return new BeduinModelTypeAdapter();
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0049: APUT  
      (r0v4 com.google.gson.TypeAdapterFactory[])
      (0 ??[int, short, byte, char])
      (r1v1 com.avito.android.remote.parse.adapter.RuntimeTypeAdapterFactory)
     */
    @Provides
    @ElementsIntoSet
    @NotNull
    public final Set<TypeAdapterFactory> provideBeduinTypeAdapterFactories(@NotNull BeduinRegistry beduinRegistry, @NotNull BeduinModelTypeAdapter beduinModelTypeAdapter, @NotNull BeduinActionParamsTypeAdapter beduinActionParamsTypeAdapter) {
        Intrinsics.checkNotNullParameter(beduinRegistry, "beduinRegistry");
        Intrinsics.checkNotNullParameter(beduinModelTypeAdapter, "beduinModelTypeAdapter");
        Intrinsics.checkNotNullParameter(beduinActionParamsTypeAdapter, "beduinActionParamsTypeAdapter");
        TypeAdapterFactory[] typeAdapterFactoryArr = new TypeAdapterFactory[2];
        RuntimeTypeAdapterFactory of = RuntimeTypeAdapterFactory.of(BeduinModel.class, "type");
        Iterator<T> it = beduinRegistry.getRegisteredComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            for (String str : beduinRegistry.getTypeNameByComponent(next)) {
                of.registerSubtype(beduinRegistry.getModelTypeByComponent(next), str, beduinModelTypeAdapter);
            }
        }
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(of, "RuntimeTypeAdapterFactor…          }\n            }");
        typeAdapterFactoryArr[0] = of;
        RuntimeTypeAdapterFactory of2 = RuntimeTypeAdapterFactory.of(BeduinAction.class, "type");
        for (T t : beduinRegistry.getRegisteredActions()) {
            for (String str2 : beduinRegistry.getTypeNameByAction(t)) {
                of2.registerSubtype(JvmClassMappingKt.getJavaClass((KClass) t), str2, beduinActionParamsTypeAdapter);
            }
        }
        Unit unit2 = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(of2, "RuntimeTypeAdapterFactor…          }\n            }");
        typeAdapterFactoryArr[1] = of2;
        return y.setOf((Object[]) typeAdapterFactoryArr);
    }
}
