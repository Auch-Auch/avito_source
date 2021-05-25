package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.AdCascadesInChannelsTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_AdCascadesInChannelsFactory implements Factory<SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_AdCascadesInChannelsFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> adCascadesInChannels(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.adCascadesInChannels(abTestsConfigProvider));
    }

    public static AbTestGroupModule_AdCascadesInChannelsFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_AdCascadesInChannelsFactory(abTestGroupModule, provider);
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> get() {
        return adCascadesInChannels(this.a, this.b.get());
    }
}
