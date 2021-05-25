package com.avito.android.di.module;

import android.app.Application;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreApplicationModule_ProvideContextFactory implements Factory<Context> {
    public final CoreApplicationModule a;
    public final Provider<Application> b;

    public CoreApplicationModule_ProvideContextFactory(CoreApplicationModule coreApplicationModule, Provider<Application> provider) {
        this.a = coreApplicationModule;
        this.b = provider;
    }

    public static CoreApplicationModule_ProvideContextFactory create(CoreApplicationModule coreApplicationModule, Provider<Application> provider) {
        return new CoreApplicationModule_ProvideContextFactory(coreApplicationModule, provider);
    }

    public static Context provideContext(CoreApplicationModule coreApplicationModule, Application application) {
        return (Context) Preconditions.checkNotNullFromProvides(coreApplicationModule.provideContext(application));
    }

    @Override // javax.inject.Provider
    public Context get() {
        return provideContext(this.a, this.b.get());
    }
}
