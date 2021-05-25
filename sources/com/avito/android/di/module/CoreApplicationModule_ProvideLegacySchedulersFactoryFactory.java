package com.avito.android.di.module;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CoreApplicationModule_ProvideLegacySchedulersFactoryFactory implements Factory<SchedulersFactory> {
    public final CoreApplicationModule a;

    public CoreApplicationModule_ProvideLegacySchedulersFactoryFactory(CoreApplicationModule coreApplicationModule) {
        this.a = coreApplicationModule;
    }

    public static CoreApplicationModule_ProvideLegacySchedulersFactoryFactory create(CoreApplicationModule coreApplicationModule) {
        return new CoreApplicationModule_ProvideLegacySchedulersFactoryFactory(coreApplicationModule);
    }

    public static SchedulersFactory provideLegacySchedulersFactory(CoreApplicationModule coreApplicationModule) {
        return (SchedulersFactory) Preconditions.checkNotNullFromProvides(coreApplicationModule.provideLegacySchedulersFactory());
    }

    @Override // javax.inject.Provider
    public SchedulersFactory get() {
        return provideLegacySchedulersFactory(this.a);
    }
}
