package com.avito.android.di.module;

import com.avito.android.preferences.FingerprintStorage;
import com.avito.android.remote.interceptor.FingerprintHeaderProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HeaderProvidersModule_ProvideFingerprintHeaderProviderFactory implements Factory<FingerprintHeaderProvider> {
    public final HeaderProvidersModule a;
    public final Provider<FingerprintStorage> b;

    public HeaderProvidersModule_ProvideFingerprintHeaderProviderFactory(HeaderProvidersModule headerProvidersModule, Provider<FingerprintStorage> provider) {
        this.a = headerProvidersModule;
        this.b = provider;
    }

    public static HeaderProvidersModule_ProvideFingerprintHeaderProviderFactory create(HeaderProvidersModule headerProvidersModule, Provider<FingerprintStorage> provider) {
        return new HeaderProvidersModule_ProvideFingerprintHeaderProviderFactory(headerProvidersModule, provider);
    }

    public static FingerprintHeaderProvider provideFingerprintHeaderProvider(HeaderProvidersModule headerProvidersModule, FingerprintStorage fingerprintStorage) {
        return (FingerprintHeaderProvider) Preconditions.checkNotNullFromProvides(headerProvidersModule.provideFingerprintHeaderProvider(fingerprintStorage));
    }

    @Override // javax.inject.Provider
    public FingerprintHeaderProvider get() {
        return provideFingerprintHeaderProvider(this.a, this.b.get());
    }
}
