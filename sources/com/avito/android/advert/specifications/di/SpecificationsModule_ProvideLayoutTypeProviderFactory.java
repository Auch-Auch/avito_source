package com.avito.android.advert.specifications.di;

import com.avito.android.serp.adapter.LayoutTypeProvider;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SpecificationsModule_ProvideLayoutTypeProviderFactory implements Factory<LayoutTypeProvider> {
    public final Provider<DeviceMetrics> a;

    public SpecificationsModule_ProvideLayoutTypeProviderFactory(Provider<DeviceMetrics> provider) {
        this.a = provider;
    }

    public static SpecificationsModule_ProvideLayoutTypeProviderFactory create(Provider<DeviceMetrics> provider) {
        return new SpecificationsModule_ProvideLayoutTypeProviderFactory(provider);
    }

    public static LayoutTypeProvider provideLayoutTypeProvider(DeviceMetrics deviceMetrics) {
        return (LayoutTypeProvider) Preconditions.checkNotNullFromProvides(SpecificationsModule.provideLayoutTypeProvider(deviceMetrics));
    }

    @Override // javax.inject.Provider
    public LayoutTypeProvider get() {
        return provideLayoutTypeProvider(this.a.get());
    }
}
