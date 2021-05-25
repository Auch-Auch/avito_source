package com.avito.android.di.module;

import com.avito.android.beduin.action.StandardActions;
import com.avito.android.beduin.component.StandardComponents;
import com.avito.android.beduin.core.registry.BeduinRegistry;
import dagger.Module;
import dagger.Provides;
import java.util.Iterator;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/BeduinModule;", "", "Lcom/avito/android/beduin/core/registry/BeduinRegistry;", "provideBeduinRegistry", "()Lcom/avito/android/beduin/core/registry/BeduinRegistry;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class BeduinModule {
    @NotNull
    public static final BeduinModule INSTANCE = new BeduinModule();

    @Provides
    @Singleton
    @NotNull
    public final BeduinRegistry provideBeduinRegistry() {
        BeduinRegistry beduinRegistry = new BeduinRegistry();
        Iterator<T> it = StandardActions.INSTANCE.getList().iterator();
        while (it.hasNext()) {
            beduinRegistry.registerAction(it.next());
        }
        Iterator<T> it2 = StandardComponents.INSTANCE.getList().iterator();
        while (it2.hasNext()) {
            beduinRegistry.registerComponent(it2.next());
        }
        return beduinRegistry;
    }
}
