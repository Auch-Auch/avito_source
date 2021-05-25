package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApiModule_ProvideCallAdapterResourceProviderFactory implements Factory<CallAdapterFactoryResourceProvider> {
    public final ApiModule a;
    public final Provider<Application> b;

    public ApiModule_ProvideCallAdapterResourceProviderFactory(ApiModule apiModule, Provider<Application> provider) {
        this.a = apiModule;
        this.b = provider;
    }

    public static ApiModule_ProvideCallAdapterResourceProviderFactory create(ApiModule apiModule, Provider<Application> provider) {
        return new ApiModule_ProvideCallAdapterResourceProviderFactory(apiModule, provider);
    }

    public static CallAdapterFactoryResourceProvider provideCallAdapterResourceProvider(ApiModule apiModule, Application application) {
        return (CallAdapterFactoryResourceProvider) Preconditions.checkNotNullFromProvides(apiModule.provideCallAdapterResourceProvider(application));
    }

    @Override // javax.inject.Provider
    public CallAdapterFactoryResourceProvider get() {
        return provideCallAdapterResourceProvider(this.a, this.b.get());
    }
}
