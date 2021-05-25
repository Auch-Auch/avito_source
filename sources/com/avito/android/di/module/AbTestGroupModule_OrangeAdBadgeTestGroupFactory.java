package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_OrangeAdBadgeTestGroupFactory implements Factory<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_OrangeAdBadgeTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_OrangeAdBadgeTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_OrangeAdBadgeTestGroupFactory(abTestGroupModule, provider);
    }

    public static ExposedAbTestGroup<OrangeAdBadgeTestGroup> orangeAdBadgeTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.orangeAdBadgeTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ExposedAbTestGroup<OrangeAdBadgeTestGroup> get() {
        return orangeAdBadgeTestGroup(this.a, this.b.get());
    }
}
