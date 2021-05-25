package com.avito.android.di.module;

import com.avito.android.serp.adapter.LayoutTypeProvider;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideLayoutTypeProviderFactory implements Factory<LayoutTypeProvider> {
    public final Provider<DeviceMetrics> a;

    public SerpItemConverterModule_ProvideLayoutTypeProviderFactory(Provider<DeviceMetrics> provider) {
        this.a = provider;
    }

    public static SerpItemConverterModule_ProvideLayoutTypeProviderFactory create(Provider<DeviceMetrics> provider) {
        return new SerpItemConverterModule_ProvideLayoutTypeProviderFactory(provider);
    }

    public static LayoutTypeProvider provideLayoutTypeProvider(DeviceMetrics deviceMetrics) {
        return (LayoutTypeProvider) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideLayoutTypeProvider(deviceMetrics));
    }

    @Override // javax.inject.Provider
    public LayoutTypeProvider get() {
        return provideLayoutTypeProvider(this.a.get());
    }
}
