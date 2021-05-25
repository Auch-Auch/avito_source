package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_UserAdvertsTabManuallyExposedTestGroupFactory implements Factory<SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_UserAdvertsTabManuallyExposedTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_UserAdvertsTabManuallyExposedTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_UserAdvertsTabManuallyExposedTestGroupFactory(abTestGroupModule, provider);
    }

    public static SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> userAdvertsTabManuallyExposedTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.userAdvertsTabManuallyExposedTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> get() {
        return userAdvertsTabManuallyExposedTestGroup(this.a, this.b.get());
    }
}
