package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.AdvertDetailsPriceSubscriptionTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAdvertDetailsPriceSubscriptionTestGroupFactory implements Factory<ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAdvertDetailsPriceSubscriptionTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAdvertDetailsPriceSubscriptionTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAdvertDetailsPriceSubscriptionTestGroupFactory(abTestGroupModule, provider);
    }

    public static ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> provideAdvertDetailsPriceSubscriptionTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAdvertDetailsPriceSubscriptionTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> get() {
        return provideAdvertDetailsPriceSubscriptionTestGroup(this.a, this.b.get());
    }
}
