package com.avito.android.di.module;

import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CoreApplicationModule_ProvideSchedulersFactoryFactory implements Factory<SchedulersFactory3> {
    public final CoreApplicationModule a;

    public CoreApplicationModule_ProvideSchedulersFactoryFactory(CoreApplicationModule coreApplicationModule) {
        this.a = coreApplicationModule;
    }

    public static CoreApplicationModule_ProvideSchedulersFactoryFactory create(CoreApplicationModule coreApplicationModule) {
        return new CoreApplicationModule_ProvideSchedulersFactoryFactory(coreApplicationModule);
    }

    public static SchedulersFactory3 provideSchedulersFactory(CoreApplicationModule coreApplicationModule) {
        return (SchedulersFactory3) Preconditions.checkNotNullFromProvides(coreApplicationModule.provideSchedulersFactory());
    }

    @Override // javax.inject.Provider
    public SchedulersFactory3 get() {
        return provideSchedulersFactory(this.a);
    }
}
