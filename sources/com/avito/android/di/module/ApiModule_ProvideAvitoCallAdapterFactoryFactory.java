package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import com.avito.android.util.BuildInfo;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.CallAdapter;
public final class ApiModule_ProvideAvitoCallAdapterFactoryFactory implements Factory<CallAdapter.Factory> {
    public final ApiModule a;
    public final Provider<Gson> b;
    public final Provider<BuildInfo> c;
    public final Provider<Features> d;
    public final Provider<CallAdapterFactoryResourceProvider> e;

    public ApiModule_ProvideAvitoCallAdapterFactoryFactory(ApiModule apiModule, Provider<Gson> provider, Provider<BuildInfo> provider2, Provider<Features> provider3, Provider<CallAdapterFactoryResourceProvider> provider4) {
        this.a = apiModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static ApiModule_ProvideAvitoCallAdapterFactoryFactory create(ApiModule apiModule, Provider<Gson> provider, Provider<BuildInfo> provider2, Provider<Features> provider3, Provider<CallAdapterFactoryResourceProvider> provider4) {
        return new ApiModule_ProvideAvitoCallAdapterFactoryFactory(apiModule, provider, provider2, provider3, provider4);
    }

    public static CallAdapter.Factory provideAvitoCallAdapterFactory(ApiModule apiModule, Gson gson, BuildInfo buildInfo, Features features, CallAdapterFactoryResourceProvider callAdapterFactoryResourceProvider) {
        return (CallAdapter.Factory) Preconditions.checkNotNullFromProvides(apiModule.provideAvitoCallAdapterFactory(gson, buildInfo, features, callAdapterFactoryResourceProvider));
    }

    @Override // javax.inject.Provider
    public CallAdapter.Factory get() {
        return provideAvitoCallAdapterFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
