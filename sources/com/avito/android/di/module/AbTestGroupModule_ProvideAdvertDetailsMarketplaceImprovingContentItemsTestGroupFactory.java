package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceImprovingContentItemsTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAdvertDetailsMarketplaceImprovingContentItemsTestGroupFactory implements Factory<ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAdvertDetailsMarketplaceImprovingContentItemsTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAdvertDetailsMarketplaceImprovingContentItemsTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAdvertDetailsMarketplaceImprovingContentItemsTestGroupFactory(abTestGroupModule, provider);
    }

    public static ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> provideAdvertDetailsMarketplaceImprovingContentItemsTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAdvertDetailsMarketplaceImprovingContentItemsTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> get() {
        return provideAdvertDetailsMarketplaceImprovingContentItemsTestGroup(this.a, this.b.get());
    }
}
