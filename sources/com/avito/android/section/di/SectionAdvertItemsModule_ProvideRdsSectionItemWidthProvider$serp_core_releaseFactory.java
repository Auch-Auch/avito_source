package com.avito.android.section.di;

import com.avito.android.section.SectionResourceProvider;
import com.avito.android.section.item.SectionItemWidthProvider;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SectionAdvertItemsModule_ProvideRdsSectionItemWidthProvider$serp_core_releaseFactory implements Factory<SectionItemWidthProvider> {
    public final Provider<DeviceMetrics> a;
    public final Provider<SectionResourceProvider> b;

    public SectionAdvertItemsModule_ProvideRdsSectionItemWidthProvider$serp_core_releaseFactory(Provider<DeviceMetrics> provider, Provider<SectionResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SectionAdvertItemsModule_ProvideRdsSectionItemWidthProvider$serp_core_releaseFactory create(Provider<DeviceMetrics> provider, Provider<SectionResourceProvider> provider2) {
        return new SectionAdvertItemsModule_ProvideRdsSectionItemWidthProvider$serp_core_releaseFactory(provider, provider2);
    }

    public static SectionItemWidthProvider provideRdsSectionItemWidthProvider$serp_core_release(DeviceMetrics deviceMetrics, SectionResourceProvider sectionResourceProvider) {
        return (SectionItemWidthProvider) Preconditions.checkNotNullFromProvides(SectionAdvertItemsModule.provideRdsSectionItemWidthProvider$serp_core_release(deviceMetrics, sectionResourceProvider));
    }

    @Override // javax.inject.Provider
    public SectionItemWidthProvider get() {
        return provideRdsSectionItemWidthProvider$serp_core_release(this.a.get(), this.b.get());
    }
}
