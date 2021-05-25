package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.app.external.ApplicationInfoProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExternalApplicationsModule_ProvideApplicationInfoProviderFactory implements Factory<ApplicationInfoProvider> {
    public final ExternalApplicationsModule a;
    public final Provider<Application> b;

    public ExternalApplicationsModule_ProvideApplicationInfoProviderFactory(ExternalApplicationsModule externalApplicationsModule, Provider<Application> provider) {
        this.a = externalApplicationsModule;
        this.b = provider;
    }

    public static ExternalApplicationsModule_ProvideApplicationInfoProviderFactory create(ExternalApplicationsModule externalApplicationsModule, Provider<Application> provider) {
        return new ExternalApplicationsModule_ProvideApplicationInfoProviderFactory(externalApplicationsModule, provider);
    }

    public static ApplicationInfoProvider provideApplicationInfoProvider(ExternalApplicationsModule externalApplicationsModule, Application application) {
        return (ApplicationInfoProvider) Preconditions.checkNotNullFromProvides(externalApplicationsModule.provideApplicationInfoProvider(application));
    }

    @Override // javax.inject.Provider
    public ApplicationInfoProvider get() {
        return provideApplicationInfoProvider(this.a, this.b.get());
    }
}
