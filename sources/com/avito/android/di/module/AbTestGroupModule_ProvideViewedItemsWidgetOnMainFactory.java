package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.ViewedItemsWidgetOnMainTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideViewedItemsWidgetOnMainFactory implements Factory<SingleManuallyExposedAbTestGroup<ViewedItemsWidgetOnMainTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideViewedItemsWidgetOnMainFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideViewedItemsWidgetOnMainFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideViewedItemsWidgetOnMainFactory(abTestGroupModule, provider);
    }

    public static SingleManuallyExposedAbTestGroup<ViewedItemsWidgetOnMainTestGroup> provideViewedItemsWidgetOnMain(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideViewedItemsWidgetOnMain(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<ViewedItemsWidgetOnMainTestGroup> get() {
        return provideViewedItemsWidgetOnMain(this.a, this.b.get());
    }
}
