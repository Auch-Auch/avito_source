package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.AntiFraudCheckListTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAntiFraudCheckListTestGroupFactory implements Factory<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAntiFraudCheckListTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAntiFraudCheckListTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAntiFraudCheckListTestGroupFactory(abTestGroupModule, provider);
    }

    public static SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> provideAntiFraudCheckListTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAntiFraudCheckListTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> get() {
        return provideAntiFraudCheckListTestGroup(this.a, this.b.get());
    }
}
