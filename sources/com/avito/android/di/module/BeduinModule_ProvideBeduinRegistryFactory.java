package com.avito.android.di.module;

import com.avito.android.beduin.core.registry.BeduinRegistry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class BeduinModule_ProvideBeduinRegistryFactory implements Factory<BeduinRegistry> {

    public static final class a {
        public static final BeduinModule_ProvideBeduinRegistryFactory a = new BeduinModule_ProvideBeduinRegistryFactory();
    }

    public static BeduinModule_ProvideBeduinRegistryFactory create() {
        return a.a;
    }

    public static BeduinRegistry provideBeduinRegistry() {
        return (BeduinRegistry) Preconditions.checkNotNullFromProvides(BeduinModule.INSTANCE.provideBeduinRegistry());
    }

    @Override // javax.inject.Provider
    public BeduinRegistry get() {
        return provideBeduinRegistry();
    }
}
