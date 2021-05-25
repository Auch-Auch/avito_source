package com.avito.android.di.module;

import com.avito.android.remote.interceptor.DateHeaderProvider;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HeaderProvidersModule_ProvideDateHeaderProviderFactory implements Factory<DateHeaderProvider> {
    public final HeaderProvidersModule a;
    public final Provider<TimeSource> b;

    public HeaderProvidersModule_ProvideDateHeaderProviderFactory(HeaderProvidersModule headerProvidersModule, Provider<TimeSource> provider) {
        this.a = headerProvidersModule;
        this.b = provider;
    }

    public static HeaderProvidersModule_ProvideDateHeaderProviderFactory create(HeaderProvidersModule headerProvidersModule, Provider<TimeSource> provider) {
        return new HeaderProvidersModule_ProvideDateHeaderProviderFactory(headerProvidersModule, provider);
    }

    public static DateHeaderProvider provideDateHeaderProvider(HeaderProvidersModule headerProvidersModule, TimeSource timeSource) {
        return (DateHeaderProvider) Preconditions.checkNotNullFromProvides(headerProvidersModule.provideDateHeaderProvider(timeSource));
    }

    @Override // javax.inject.Provider
    public DateHeaderProvider get() {
        return provideDateHeaderProvider(this.a, this.b.get());
    }
}
