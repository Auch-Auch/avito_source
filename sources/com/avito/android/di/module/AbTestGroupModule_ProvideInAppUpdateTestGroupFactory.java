package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.InAppUpdateTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideInAppUpdateTestGroupFactory implements Factory<InAppUpdateTestGroup> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideInAppUpdateTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideInAppUpdateTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideInAppUpdateTestGroupFactory(abTestGroupModule, provider);
    }

    public static InAppUpdateTestGroup provideInAppUpdateTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (InAppUpdateTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideInAppUpdateTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public InAppUpdateTestGroup get() {
        return provideInAppUpdateTestGroup(this.a, this.b.get());
    }
}
