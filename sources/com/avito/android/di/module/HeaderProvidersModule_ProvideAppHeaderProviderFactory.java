package com.avito.android.di.module;

import com.avito.android.remote.interceptor.AppHeaderProvider;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HeaderProvidersModule_ProvideAppHeaderProviderFactory implements Factory<AppHeaderProvider> {
    public final HeaderProvidersModule a;
    public final Provider<BuildInfo> b;

    public HeaderProvidersModule_ProvideAppHeaderProviderFactory(HeaderProvidersModule headerProvidersModule, Provider<BuildInfo> provider) {
        this.a = headerProvidersModule;
        this.b = provider;
    }

    public static HeaderProvidersModule_ProvideAppHeaderProviderFactory create(HeaderProvidersModule headerProvidersModule, Provider<BuildInfo> provider) {
        return new HeaderProvidersModule_ProvideAppHeaderProviderFactory(headerProvidersModule, provider);
    }

    public static AppHeaderProvider provideAppHeaderProvider(HeaderProvidersModule headerProvidersModule, BuildInfo buildInfo) {
        return (AppHeaderProvider) Preconditions.checkNotNullFromProvides(headerProvidersModule.provideAppHeaderProvider(buildInfo));
    }

    @Override // javax.inject.Provider
    public AppHeaderProvider get() {
        return provideAppHeaderProvider(this.a, this.b.get());
    }
}
