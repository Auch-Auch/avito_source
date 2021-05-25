package com.avito.android.di.module;

import com.avito.android.app.ActivityProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CoreApplicationModule_ProvideActivityProviderFactory implements Factory<ActivityProvider> {
    public final CoreApplicationModule a;

    public CoreApplicationModule_ProvideActivityProviderFactory(CoreApplicationModule coreApplicationModule) {
        this.a = coreApplicationModule;
    }

    public static CoreApplicationModule_ProvideActivityProviderFactory create(CoreApplicationModule coreApplicationModule) {
        return new CoreApplicationModule_ProvideActivityProviderFactory(coreApplicationModule);
    }

    public static ActivityProvider provideActivityProvider(CoreApplicationModule coreApplicationModule) {
        return (ActivityProvider) Preconditions.checkNotNullFromProvides(coreApplicationModule.provideActivityProvider());
    }

    @Override // javax.inject.Provider
    public ActivityProvider get() {
        return provideActivityProvider(this.a);
    }
}
