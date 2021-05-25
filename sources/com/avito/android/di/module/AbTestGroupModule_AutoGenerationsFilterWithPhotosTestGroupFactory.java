package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_AutoGenerationsFilterWithPhotosTestGroupFactory implements Factory<SingleManuallyExposedAbTestGroup<SimpleTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_AutoGenerationsFilterWithPhotosTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static SingleManuallyExposedAbTestGroup<SimpleTestGroup> autoGenerationsFilterWithPhotosTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.autoGenerationsFilterWithPhotosTestGroup(abTestsConfigProvider));
    }

    public static AbTestGroupModule_AutoGenerationsFilterWithPhotosTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_AutoGenerationsFilterWithPhotosTestGroupFactory(abTestGroupModule, provider);
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<SimpleTestGroup> get() {
        return autoGenerationsFilterWithPhotosTestGroup(this.a, this.b.get());
    }
}
