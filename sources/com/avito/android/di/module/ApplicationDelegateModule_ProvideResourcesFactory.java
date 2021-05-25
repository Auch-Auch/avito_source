package com.avito.android.di.module;

import android.app.Application;
import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApplicationDelegateModule_ProvideResourcesFactory implements Factory<Resources> {
    public final ApplicationDelegateModule a;
    public final Provider<Application> b;

    public ApplicationDelegateModule_ProvideResourcesFactory(ApplicationDelegateModule applicationDelegateModule, Provider<Application> provider) {
        this.a = applicationDelegateModule;
        this.b = provider;
    }

    public static ApplicationDelegateModule_ProvideResourcesFactory create(ApplicationDelegateModule applicationDelegateModule, Provider<Application> provider) {
        return new ApplicationDelegateModule_ProvideResourcesFactory(applicationDelegateModule, provider);
    }

    public static Resources provideResources(ApplicationDelegateModule applicationDelegateModule, Application application) {
        return (Resources) Preconditions.checkNotNullFromProvides(applicationDelegateModule.provideResources(application));
    }

    @Override // javax.inject.Provider
    public Resources get() {
        return provideResources(this.a, this.b.get());
    }
}
