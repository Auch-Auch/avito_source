package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.remote.SupportFeaturesHeaderProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HeaderProvidersModule_ProvideSupportFeaturesHeaderProviderFactory implements Factory<SupportFeaturesHeaderProvider> {
    public final HeaderProvidersModule a;
    public final Provider<Features> b;

    public HeaderProvidersModule_ProvideSupportFeaturesHeaderProviderFactory(HeaderProvidersModule headerProvidersModule, Provider<Features> provider) {
        this.a = headerProvidersModule;
        this.b = provider;
    }

    public static HeaderProvidersModule_ProvideSupportFeaturesHeaderProviderFactory create(HeaderProvidersModule headerProvidersModule, Provider<Features> provider) {
        return new HeaderProvidersModule_ProvideSupportFeaturesHeaderProviderFactory(headerProvidersModule, provider);
    }

    public static SupportFeaturesHeaderProvider provideSupportFeaturesHeaderProvider(HeaderProvidersModule headerProvidersModule, Features features) {
        return (SupportFeaturesHeaderProvider) Preconditions.checkNotNullFromProvides(headerProvidersModule.provideSupportFeaturesHeaderProvider(features));
    }

    @Override // javax.inject.Provider
    public SupportFeaturesHeaderProvider get() {
        return provideSupportFeaturesHeaderProvider(this.a, this.b.get());
    }
}
