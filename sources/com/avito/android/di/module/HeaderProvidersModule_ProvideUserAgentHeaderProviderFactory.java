package com.avito.android.di.module;

import com.avito.android.remote.UserAgentProvider;
import com.avito.android.remote.interceptor.UserAgentHeaderProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HeaderProvidersModule_ProvideUserAgentHeaderProviderFactory implements Factory<UserAgentHeaderProvider> {
    public final HeaderProvidersModule a;
    public final Provider<UserAgentProvider> b;

    public HeaderProvidersModule_ProvideUserAgentHeaderProviderFactory(HeaderProvidersModule headerProvidersModule, Provider<UserAgentProvider> provider) {
        this.a = headerProvidersModule;
        this.b = provider;
    }

    public static HeaderProvidersModule_ProvideUserAgentHeaderProviderFactory create(HeaderProvidersModule headerProvidersModule, Provider<UserAgentProvider> provider) {
        return new HeaderProvidersModule_ProvideUserAgentHeaderProviderFactory(headerProvidersModule, provider);
    }

    public static UserAgentHeaderProvider provideUserAgentHeaderProvider(HeaderProvidersModule headerProvidersModule, UserAgentProvider userAgentProvider) {
        return (UserAgentHeaderProvider) Preconditions.checkNotNullFromProvides(headerProvidersModule.provideUserAgentHeaderProvider(userAgentProvider));
    }

    @Override // javax.inject.Provider
    public UserAgentHeaderProvider get() {
        return provideUserAgentHeaderProvider(this.a, this.b.get());
    }
}
