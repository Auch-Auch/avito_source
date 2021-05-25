package com.avito.android.serp.adapter;

import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpItemAbViewConfig_Factory implements Factory<SerpItemAbViewConfig> {
    public final Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> a;
    public final Provider<SerpItemsPrefetchTestGroup> b;

    public SerpItemAbViewConfig_Factory(Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> provider, Provider<SerpItemsPrefetchTestGroup> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SerpItemAbViewConfig_Factory create(Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> provider, Provider<SerpItemsPrefetchTestGroup> provider2) {
        return new SerpItemAbViewConfig_Factory(provider, provider2);
    }

    public static SerpItemAbViewConfig newInstance(ExposedAbTestGroup<PriceOnTopTestGroup> exposedAbTestGroup, SerpItemsPrefetchTestGroup serpItemsPrefetchTestGroup) {
        return new SerpItemAbViewConfig(exposedAbTestGroup, serpItemsPrefetchTestGroup);
    }

    @Override // javax.inject.Provider
    public SerpItemAbViewConfig get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
