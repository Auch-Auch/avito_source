package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideViewedItemsTabTestGroubFactory implements Factory<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideViewedItemsTabTestGroubFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideViewedItemsTabTestGroubFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideViewedItemsTabTestGroubFactory(abTestGroupModule, provider);
    }

    public static SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> provideViewedItemsTabTestGroub(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideViewedItemsTabTestGroub(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> get() {
        return provideViewedItemsTabTestGroub(this.a, this.b.get());
    }
}
