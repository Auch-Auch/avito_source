package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAdvertDetailsMarketplaceDeliveryItemTestGroupFactory implements Factory<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAdvertDetailsMarketplaceDeliveryItemTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAdvertDetailsMarketplaceDeliveryItemTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAdvertDetailsMarketplaceDeliveryItemTestGroupFactory(abTestGroupModule, provider);
    }

    public static ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> provideAdvertDetailsMarketplaceDeliveryItemTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAdvertDetailsMarketplaceDeliveryItemTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> get() {
        return provideAdvertDetailsMarketplaceDeliveryItemTestGroup(this.a, this.b.get());
    }
}
