package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.app.task.MutableApplicationStartupTasksRegistry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreApplicationModule_ProvideMutableApplicationStartupTasksRegistryFactory implements Factory<MutableApplicationStartupTasksRegistry> {
    public final CoreApplicationModule a;
    public final Provider<Features> b;

    public CoreApplicationModule_ProvideMutableApplicationStartupTasksRegistryFactory(CoreApplicationModule coreApplicationModule, Provider<Features> provider) {
        this.a = coreApplicationModule;
        this.b = provider;
    }

    public static CoreApplicationModule_ProvideMutableApplicationStartupTasksRegistryFactory create(CoreApplicationModule coreApplicationModule, Provider<Features> provider) {
        return new CoreApplicationModule_ProvideMutableApplicationStartupTasksRegistryFactory(coreApplicationModule, provider);
    }

    public static MutableApplicationStartupTasksRegistry provideMutableApplicationStartupTasksRegistry(CoreApplicationModule coreApplicationModule, Features features) {
        return (MutableApplicationStartupTasksRegistry) Preconditions.checkNotNullFromProvides(coreApplicationModule.provideMutableApplicationStartupTasksRegistry(features));
    }

    @Override // javax.inject.Provider
    public MutableApplicationStartupTasksRegistry get() {
        return provideMutableApplicationStartupTasksRegistry(this.a, this.b.get());
    }
}
