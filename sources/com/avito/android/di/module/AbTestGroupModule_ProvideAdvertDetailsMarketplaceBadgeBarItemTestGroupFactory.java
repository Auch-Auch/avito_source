package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceBadgeBarItemTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAdvertDetailsMarketplaceBadgeBarItemTestGroupFactory implements Factory<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAdvertDetailsMarketplaceBadgeBarItemTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAdvertDetailsMarketplaceBadgeBarItemTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAdvertDetailsMarketplaceBadgeBarItemTestGroupFactory(abTestGroupModule, provider);
    }

    public static ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup> provideAdvertDetailsMarketplaceBadgeBarItemTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAdvertDetailsMarketplaceBadgeBarItemTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup> get() {
        return provideAdvertDetailsMarketplaceBadgeBarItemTestGroup(this.a, this.b.get());
    }
}
